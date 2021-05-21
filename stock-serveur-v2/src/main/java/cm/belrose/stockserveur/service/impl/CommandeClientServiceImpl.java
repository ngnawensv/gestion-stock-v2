package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.*;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.*;
import cm.belrose.stockserveur.repository.ArticleRepository;
import cm.belrose.stockserveur.repository.ClientRepository;
import cm.belrose.stockserveur.repository.CommandeClientRepository;
import cm.belrose.stockserveur.repository.LigneCommandeClientRepository;
import cm.belrose.stockserveur.service.CommandeClientService;
import cm.belrose.stockserveur.service.MouvementStockService;
import cm.belrose.stockserveur.validator.ArticleValidator;
import cm.belrose.stockserveur.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {
    @Autowired
    private CommandeClientRepository commandeClientRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    @Autowired
    MouvementStockService mouvementStockService;

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        //Validation de l'objet commande client. Ceci en s'assurant code, dateCommande, Client ne son pas nuls
        //Ici on à déjà validé que l'objet client n'est pas null
        List<String> errors = CommandeClientValidator.validator(dto);
        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valid", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }
        if (dto.getId() != null && dto.isCommandeLivree()) {
            log.error("Throw new invalidOperationExceptio..............");
        }
        //Verification de l'existence du client dans la BD. c-a-d que le client envoyé existe déjà dans la BD
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()) {
            log.warn("Client avec ID {} was not found in the DB", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID " + dto.getClient().getId() + "n'a été trouvé dans la BD", ErrorCodes.CLIENT_NOT_FOUND);
        }
        //Vérification de l'existence des articles dans la base de données
        List<String> articleErrors = new ArrayList<>();
        if (dto.getLigneCommandeClientList() != null) {
            dto.getLigneCommandeClientList().forEach(ligneCommandeClientDto -> {
                if (ligneCommandeClientDto.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligneCommandeClientDto.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligneCommandeClientDto.getArticle().getId() + " n'existe pas");
                    }
                } else {
                    articleErrors.add("Impossible d'enregistrer une commande avec un article NULL");
                }
            });
        }
        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BD ", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        //Enregistrement de toutes les commandes clients
        CommandeClient saveCommandeClient = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
        //boucler les lignes de commande client
        if (dto.getLigneCommandeClientList() != null) {
            dto.getLigneCommandeClientList().forEach(ligneCommandeClientDto -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligneCommandeClientDto);
                ligneCommandeClient.setCommandeClient(saveCommandeClient);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }
        return CommandeClientDto.fromEntity(saveCommandeClient);
    }

    @Override
    public CommandeClientDto updateEtatCommande(Long idCommande, EtatCommande etatCommande) {
        checkIdCommande(idCommande);
        if (!StringUtils.hasLength(String.valueOf(etatCommande))) {
            log.error("L'etat de la commande client est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec etat null", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        CommandeClientDto commandeClient = checkEtatCommande(idCommande);
        commandeClient.setEtatCommande(etatCommande);

        CommandeClient saveCommandeClient = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClient));
        if (commandeClient.isCommandeLivree()) {
            updateMouvementStock(idCommande);
        }
        return CommandeClientDto.fromEntity(saveCommandeClient);
    }

    @Override
    public CommandeClientDto updateClient(Long idCommande, Long idClient) {
        checkIdCommande(idCommande);
        if (idClient == null) {
            log.error("ID de la commande client est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec ID null", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        CommandeClientDto commandeClient = checkEtatCommande(idCommande);
        Optional<Client> clientOptional = clientRepository.findById(idClient);
        if (clientOptional.isEmpty()) {
            throw new EntityNotFoundException("Aucun client n'a été trouvé avec l'id " + idClient, ErrorCodes.CLIENT_NOT_FOUND);
        }
        commandeClient.setClient(clientOptional.get());
        return CommandeClientDto.fromEntity(commandeClientRepository.save(CommandeClientDto.toEntity(commandeClient)));
    }

    @Override
    public CommandeClientDto updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);
        if (quantite == null && quantite.compareTo(BigDecimal.ZERO) == 0) {
            log.error("Quantité de la commande client est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec quantité null ou zero", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        CommandeClientDto commandeClient = checkEtatCommande(idCommande);
        Optional<LigneCommandeClient> ligneCommandeClientOptional = findLigneCommandeClient(idLigneCommande);
        LigneCommandeClient ligneCommandeClient = ligneCommandeClientOptional.get();
        ligneCommandeClient.setQuantite(quantite);
        ligneCommandeClientRepository.save(ligneCommandeClient);
        return commandeClient;
    }

    @Override
    public CommandeClientDto updateArticle(Long idCommande, Long idLigneCommande, Long idArticle) {
        checkIdLigneCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);
        checkIdArticle(idArticle);

        CommandeClientDto commandeClientDto = checkEtatCommande(idCommande);

        Optional<LigneCommandeClient> ligneCommandeClient = findLigneCommandeClient(idLigneCommande);
        Optional<Article> articleOptional = articleRepository.findById(idArticle);
        if (articleOptional.isEmpty()) {
            throw new EntityNotFoundException("Aucun article n'a été trouvé avec l'id " + idArticle, ErrorCodes.ARTICLE_NOT_FOUND);
        }
        List<String> errors = ArticleValidator.validator(ArticleDto.fromEntity(articleOptional.get()));
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Article invalide ", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        LigneCommandeClient ligneCommandeClientToSaved = ligneCommandeClient.get();
        ligneCommandeClientToSaved.setArticle(articleOptional.get());
        ligneCommandeClientRepository.save(ligneCommandeClientToSaved);
        return commandeClientDto;
    }


    @Override
    public CommandeClientDto findById(Long id) {
        if (id == null) {
            log.error("Commande client ID est NULL");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune commande client n'a été trouvé avec l'ID " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findCommandeClientByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Commande client code tes NULL");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune commande client n'a été trouvé avec le code " + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Long idCommande) {
        return ligneCommandeClientRepository.findAllByCommandeClientId(idCommande).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Commande client ID est NULL");
            return;
        }
        commandeClientRepository.deleteById(id);

    }

    @Override
    public CommandeClientDto deleteArticle(Long idCommande, Long idLigneCommande) {
        checkIdLigneCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);

        CommandeClientDto commandeClientDto = checkEtatCommande(idCommande);

        //Just to check the LigneCommandeClient and inform the client in case it is absent
        findLigneCommandeClient(idLigneCommande);
        ligneCommandeClientRepository.deleteById(idLigneCommande);
        return commandeClientDto;
    }

    private CommandeClientDto checkEtatCommande(Long idCommande) {
        CommandeClientDto commandeClient = findById(idCommande);
        if (commandeClient.isCommandeLivree()) {
            throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livrée", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        return commandeClient;
    }

    private void checkIdCommande(Long idCommande) {
        if (idCommande == null) {
            log.error("ID de la commande client est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec ID null", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }

    private void checkIdLigneCommande(Long idLigneCommande) {
        if (idLigneCommande == null) {
            log.error("ID de la ligne commande client est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec ID null", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }

    private void checkIdArticle(Long idArticle) {
        if (idArticle == null) {
            log.error("ID de l'article est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec " + idArticle + " article null ", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }

    private Optional<LigneCommandeClient> findLigneCommandeClient(Long idLigneCommande) {
        Optional<LigneCommandeClient> ligneCommandeClientOptional = ligneCommandeClientRepository.findById(idLigneCommande);
        if (ligneCommandeClientOptional.isEmpty()) {
            throw new EntityNotFoundException("Aucun client n'a été trouvé avec l'id " + idLigneCommande, ErrorCodes.CLIENT_NOT_FOUND);
        }
        return ligneCommandeClientOptional;
    }

    private void updateMouvementStock(Long idCommande) {
        List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandeClientId(idCommande);
        ligneCommandeClients.forEach(lig -> {
            MouvementStockDto mouvementStockDto = MouvementStockDto.builder()
                    .article(ArticleDto.fromEntity(lig.getArticle()))
                    .dateMouvement(Instant.now())
                    .typeMouvementStock(TypeMouvementStock.SORTIE)
                    .sourceMouvementStock(SourceMouvementStock.COMMANDE_CLIENT)
                    .quantite(lig.getQuantite())
                    .entrepriseId(lig.getEntrepriseId())
                    .build();
            mouvementStockService.sortieStock(mouvementStockDto);
        });
    }
}
