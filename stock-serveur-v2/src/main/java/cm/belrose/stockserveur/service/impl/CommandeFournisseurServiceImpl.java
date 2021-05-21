package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.*;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.*;
import cm.belrose.stockserveur.repository.*;
import cm.belrose.stockserveur.service.CommandeFournisseurService;
import cm.belrose.stockserveur.service.MouvementStockService;
import cm.belrose.stockserveur.validator.ArticleValidator;
import cm.belrose.stockserveur.validator.CommandeClientValidator;
import cm.belrose.stockserveur.validator.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {
    @Autowired
    private CommandeFournisseurRepository commandeFournisseurRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    @Autowired
    private MouvementStockService mouvementStockService;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors= CommandeFournisseurValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error("Commande fournisseur n'est pas valide");
            throw new InvalidEntityException("La commande fournisseur n'est pas valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }

        Optional<Fournisseur> client=fournisseurRepository.findById(dto.getFournisseur().getId());
        if(client.isEmpty()){
            log.warn("Founisseur avec ID {} was not found in the DB", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'ID "+dto.getFournisseur().getId()+"n'a été trouvé dans la BD",ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        //Vérification de l'existence des articles dans la base de données
        List<String> articleErrors=new ArrayList<>();
        if(dto.getLigneCommandeFournisseurList()!=null){
            dto.getLigneCommandeFournisseurList().forEach(ligneCommandeFournisseurDto -> {
                if(ligneCommandeFournisseurDto.getArticle()!=null){
                    Optional<Article> article=articleRepository.findById(ligneCommandeFournisseurDto.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("L'article avec l'ID "+ligneCommandeFournisseurDto.getArticle().getId()+" n'existe pas");
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

        //Enregistrement de toutes les commandes fournisseurs
        CommandeFournisseur saveCommandeFournisseur=commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        //boucler les lignes de commande fournisseur
        if(dto.getLigneCommandeFournisseurList()!=null){
            dto.getLigneCommandeFournisseurList().forEach(ligneCommandefournisseurDto -> {
                LigneCommandeFournisseur ligneCommandeFournisseur= LigneCommandeFournisseurDto.toEntity(ligneCommandefournisseurDto);
                ligneCommandeFournisseur.setCommandeFournisseur(saveCommandeFournisseur);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }

        return CommandeFournisseurDto.fromEntity(saveCommandeFournisseur);
    }


    @Override
    public List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Long idCommande) {
        return  ligneCommandeFournisseurRepository.findAllByCommandeFournisseurId(idCommande).stream()
                .map(LigneCommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeFournisseurDto updateEtatCommande(Long idCommande, EtatCommande etatCommande) {
        checkIdCommande(idCommande);
        if(!StringUtils.hasLength(String.valueOf(etatCommande))){
            log.error("L'etat de la commande fournisseur est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec etat null",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NON_MODIFIABLE);
        }
        CommandeFournisseurDto commandeFournisseur=checkEtatCommande(idCommande);
        commandeFournisseur.setEtatCommande(etatCommande);

        CommandeFournisseur saveCommandeFounisseur=commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseur));
        if(commandeFournisseur.isCommandeLivree()){
            updateMouvementStock(idCommande);
        }
        return CommandeFournisseurDto.fromEntity(saveCommandeFounisseur);
    }

    @Override
    public CommandeFournisseurDto updateFournisseur(Long idCommande, Long idFournisseur){
        checkIdCommande(idCommande);
        if (idFournisseur==null){
            log.error("ID de la commande fournisseur est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec ID null",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NON_MODIFIABLE);
        }
        CommandeFournisseurDto commandeFournisseur=checkEtatCommande(idCommande);
        Optional<Fournisseur> fournisseurOptional=fournisseurRepository.findById(idFournisseur);
        if(fournisseurOptional.isEmpty()){
            throw  new EntityNotFoundException("Aucun fournisseur n'a été trouvé avec l'id "+idFournisseur,ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }
        commandeFournisseur.setFournisseur(fournisseurOptional.get());
        return CommandeFournisseurDto.fromEntity(commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseur)));
    }

    @Override
    public CommandeFournisseurDto updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);
        if(quantite==null&& quantite.compareTo(BigDecimal.ZERO)==0){
            log.error("Quantité de la commande fournisseur est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec quantité null ou zero",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NON_MODIFIABLE);
        }
        CommandeFournisseurDto commandeFournisseur=checkEtatCommande(idCommande);
        Optional<LigneCommandeFournisseur> ligneCommandeFournisseurOptional=findLigneCommandeFournisseur(idLigneCommande);
        LigneCommandeFournisseur ligneCommandeFournisseur=ligneCommandeFournisseurOptional.get();
        ligneCommandeFournisseur.setQuantite(quantite);
        ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
        return commandeFournisseur;
    }

    @Override
    public CommandeFournisseurDto updateArticle(Long idCommande, Long idLigneCommande, Long idArticle) {
        checkIdLigneCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);
        checkIdArticle(idArticle);

        CommandeFournisseurDto commandeFournisseurDto=checkEtatCommande(idCommande);

        Optional<LigneCommandeFournisseur> ligneCommandeFournisseur=findLigneCommandeFournisseur(idLigneCommande);
        Optional<Article> articleOptional=articleRepository.findById(idArticle);
        if(articleOptional.isEmpty()){
            throw  new EntityNotFoundException("Aucun article n'a été trouvé avec l'id "+idArticle,ErrorCodes.ARTICLE_NOT_FOUND);
        }
        List<String> errors= ArticleValidator.validator(ArticleDto.fromEntity(articleOptional.get()));
        if (!errors.isEmpty()){
            throw  new InvalidEntityException("Article invalide ",ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
        LigneCommandeFournisseur ligneCommandeFournisseurToSaved=ligneCommandeFournisseur.get();
        ligneCommandeFournisseurToSaved.setArticle(articleOptional.get());
        ligneCommandeFournisseurRepository.save(ligneCommandeFournisseurToSaved);
        return commandeFournisseurDto;
    }

    @Override
    public CommandeFournisseurDto findById(Long id) {
        if(id==null){
            log.error("Commande fournisseur ID est NULL");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Aucune commande fournisseur n'a été trouvé avec l'ID "+id,ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto findCommandeFournisseurByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Commande fournisseur code tes NULL");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Aucune commande fournisseur n'a été trouvé avec le code "+code,ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }
    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public CommandeFournisseurDto deleteArticle(Long idCommande, Long idLigneCommande) {
        checkIdLigneCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);

        CommandeFournisseurDto commandeFournisseurDto=checkEtatCommande(idCommande);

        //Just to check the LigneCommandeFournisseur and inform the client in case it is absent
        findLigneCommandeFournisseur(idLigneCommande);
        ligneCommandeFournisseurRepository.deleteById(idLigneCommande);
        return commandeFournisseurDto;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Commande fournisseur ID est NULL");
            return ;
        }
        commandeFournisseurRepository.deleteById(id);

    }


    private CommandeFournisseurDto checkEtatCommande(Long idCommande){
        CommandeFournisseurDto commandeFournisseur=findById(idCommande);
        if(commandeFournisseur.isCommandeLivree()){
            throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livrée",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NON_MODIFIABLE);
        }
        return commandeFournisseur;
    }
    private void checkIdCommande(Long idCommande){
        if(idCommande==null){
            log.error("ID de la commande fournisseur est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec ID null",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NON_MODIFIABLE);
        }
    }
    private void checkIdLigneCommande(Long idLigneCommande){
        if (idLigneCommande==null){
            log.error("ID de la ligne commande fournisseur est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec ID null",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NON_MODIFIABLE);
        }
    }

    private void checkIdArticle(Long idArticle){
        if (idArticle==null){
            log.error("ID de l'article est null");
            throw new InvalidOperationException("Imposible de modifier l'etat de la commande avec "+idArticle+" article null ",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NON_MODIFIABLE);
        }
    }

    private Optional<LigneCommandeFournisseur> findLigneCommandeFournisseur(Long idLigneCommande) {
        Optional<LigneCommandeFournisseur> ligneCommandeFournisseurOptional=ligneCommandeFournisseurRepository.findById(idLigneCommande);
        if(ligneCommandeFournisseurOptional.isEmpty()){
            throw  new EntityNotFoundException("Aucun client n'a été trouvé avec l'id "+idLigneCommande,ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }
        return ligneCommandeFournisseurOptional;
    }

    private void updateMouvementStock(Long idCommande){
        List<LigneCommandeFournisseur> ligneCommandeFournisseurs=ligneCommandeFournisseurRepository.findAllByCommandeFournisseurId(idCommande);
        ligneCommandeFournisseurs.forEach(lig->{
            MouvementStockDto mouvementStockDto=MouvementStockDto.builder()
                    .article(ArticleDto.fromEntity(lig.getArticle()))
                    .dateMouvement(Instant.now())
                    .typeMouvementStock(TypeMouvementStock.ENTREE)
                    .sourceMouvementStock(SourceMouvementStock.COMMANDE_FOURNISSEUR)
                    .quantite(lig.getQuantite())
                    .entrepriseId(lig.getEntrepriseId())
                    .build();
            mouvementStockService.entreeStock(mouvementStockDto);
        });
    }
}
