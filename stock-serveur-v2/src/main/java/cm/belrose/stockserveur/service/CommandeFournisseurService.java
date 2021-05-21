package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.CommandeFournisseurDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeFournisseurDto;
import cm.belrose.stockserveur.model.EtatCommande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    CommandeFournisseurDto updateEtatCommande(Long idCommande, EtatCommande etatCommande);
    CommandeFournisseurDto updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite);
    CommandeFournisseurDto updateFournisseur(Long idCommande, Long idFournisseur);
    CommandeFournisseurDto updateArticle(Long idCommande, Long idLigneCommande, Long idArticle);
    CommandeFournisseurDto findById(Long id);
    CommandeFournisseurDto findCommandeFournisseurByCode(String code);
    List<CommandeFournisseurDto> findAll() ;
    List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Long idCommande);
    //delete article===>delete LigneCommandeFournisseur
    CommandeFournisseurDto deleteArticle(Long idCommande, Long idLigneCommande);

    void delete(Long id);
}
