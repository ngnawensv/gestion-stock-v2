package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.CommandeClient;
import cm.belrose.stockserveur.model.LigneCommandeClient;
import cm.belrose.stockserveur.repository.ArticleRepository;
import cm.belrose.stockserveur.repository.ClientRepository;
import cm.belrose.stockserveur.repository.CommandeClientRepository;
import cm.belrose.stockserveur.repository.LigneCommandeClientRepository;
import cm.belrose.stockserveur.service.CommandeClientService;
import cm.belrose.stockserveur.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        //Validation de l'objet commande client. Ceci en s'assurant code, dateCommande, Client ne son pas nuls
        //Ici on à déjà validé que l'objet client n'est pas null
        List<String> errors= CommandeClientValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valid", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
        }

        //Verification de l'existence du client dans la BD. c-a-d que le client envoyé existe déjà dans la BD
        Optional<Client> client=clientRepository.findById(dto.getClient().getId());
        if(client.isEmpty()){
            log.warn("Client avec ID {} was not found in the DB", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID "+dto.getClient().getId()+"n'a été trouvé dans la BD",ErrorCodes.CLIENT_NOT_FOUND);
        }

        //Vérification de l'existence des articles dans la base de données
        List<String> articleErrors=new ArrayList<>();
        if(dto.getLigneCommandeClientList()!=null){
            dto.getLigneCommandeClientList().forEach(ligneCommandeClientDto -> {
                if(ligneCommandeClientDto.getArticle()!=null){
                    Optional<Article> article=articleRepository.findById(ligneCommandeClientDto.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("L'article avec l'ID "+ligneCommandeClientDto.getArticle().getId()+" n'existe pas");
                    }
                }else {
                    articleErrors.add("Impossible d'enregistrer une commande avec un article NULL");
                }
            });
        }
        if(!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BD ",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        //Enregistrement de toutes les commandes clients
        CommandeClient saveCommandeClient=commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        //boucler les lignes de commande client
        if(dto.getLigneCommandeClientList()!=null){
            dto.getLigneCommandeClientList().forEach(ligneCommandeClientDto -> {
                LigneCommandeClient ligneCommandeClient= LigneCommandeClientDto.toEntity(ligneCommandeClientDto);
                ligneCommandeClient.setCommandeClient(saveCommandeClient);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(saveCommandeClient);
    }

    @Override
    public CommandeClientDto findById(Long id) {
        if(id==null){
            log.error("Commande client ID est NULL");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Aucune commande client n'a été trouvé avec l'ID "+id,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findCommandeClientByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Commande client code tes NULL");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Aucune commande client n'a été trouvé avec le code "+code,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }
    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Commande client ID est NULL");
            return ;
        }
        commandeClientRepository.deleteById(id);

    }
}
