package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.model.CommandeClient;
import cm.belrose.stockserveur.model.EtatCommande;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);
    CommandeClientDto updateEtatCommande(Long idCommande, EtatCommande etatCommande);
    CommandeClientDto updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite);
    CommandeClientDto updateClient(Long idCommande, Long idClient);
    //Modifier un article d'une ligne de commande d'un client tout en s'assurant que l'article n'est pas encore livrée
    CommandeClientDto updateArticle(Long idCommande, Long idLigneCommande, Long idArticle);
    CommandeClientDto findById(Long id);
    CommandeClientDto findCommandeClientByCode(String code);
    List<CommandeClientDto> findAll() ;
    List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Long idCommande);
    //delete article===>delete LigneCommandeClient
    CommandeClientDto deleteArticle(Long idCommande, Long idLigneCommande);
    void delete(Long id);
}
