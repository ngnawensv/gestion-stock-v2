package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.CommandeFournisseurDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeFournisseurDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.*;
import cm.belrose.stockserveur.repository.*;
import cm.belrose.stockserveur.service.CommandeFournisseurService;
import cm.belrose.stockserveur.validator.CommandeClientValidator;
import cm.belrose.stockserveur.validator.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    @Autowired
    private CommandeFournisseurRepository commandeFournisseurRepository;

    @Autowired
    private FournissseurRepository fournissseurRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors= CommandeFournisseurValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error("Commande fournisseur n'est pas valide");
            throw new InvalidEntityException("La commande fournisseur n'est pas valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }

        Optional<Fournisseur> client=fournissseurRepository.findById(dto.getFournisseur().getId());
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
    public CommandeFournisseurDto findCommandeClientByCode(String code) {
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
    public void delete(Long id) {
        if(id==null){
            log.error("Commande fournisseur ID est NULL");
            return ;
        }
        commandeFournisseurRepository.deleteById(id);

    }
}
