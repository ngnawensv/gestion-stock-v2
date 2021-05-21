package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.CommandeFournisseurApi;
import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.CommandeFournisseurDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeFournisseurDto;
import cm.belrose.stockserveur.model.EtatCommande;
import cm.belrose.stockserveur.service.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {
    @Autowired
    private CommandeFournisseurService commandeFournisseurService;

    @Override
    public ResponseEntity<CommandeFournisseurDto> save(CommandeFournisseurDto dto) {
        return ResponseEntity.ok(commandeFournisseurService.save(dto)) ;
    }
    @Override
    public ResponseEntity<CommandeFournisseurDto> updateEtatCommande(Long idCommande, EtatCommande etatCommande) {
        return ResponseEntity.ok(commandeFournisseurService.updateEtatCommande(idCommande,etatCommande));
    }
    @Override
    public ResponseEntity<CommandeFournisseurDto> updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite) {
        return ResponseEntity.ok(commandeFournisseurService.updateQuantiteCommande(idCommande,idLigneCommande,quantite));
    }
    @Override
    public ResponseEntity<CommandeFournisseurDto> updateFournisseur(Long idCommande, Long idFournisseur) {
        return ResponseEntity.ok(commandeFournisseurService.updateFournisseur(idCommande,idFournisseur));
    }
    @Override
    public ResponseEntity<CommandeFournisseurDto> updateArticle(Long idCommande, Long idLigneCommande, Long idArticle) {
        return ResponseEntity.ok(commandeFournisseurService.updateArticle(idCommande,idLigneCommande,idArticle));
    }
    @Override
    public ResponseEntity<List<LigneCommandeFournisseurDto>> findAllLignesCommandesFournisseurByCommandeFournisseurId(Long idCommande) {
        return ResponseEntity.ok(commandeFournisseurService.findAllLignesCommandesFournisseurByCommandeFournisseurId(idCommande));
    }
    @Override
    public ResponseEntity<CommandeFournisseurDto> findById(Long id) {
        return ResponseEntity.ok(commandeFournisseurService.findById(id));
    }
    @Override
    public ResponseEntity<CommandeFournisseurDto> findCommandeFournisseurByCode(String code) {
        return ResponseEntity.ok(commandeFournisseurService.findCommandeFournisseurByCode(code));
    }
    @Override
    public ResponseEntity<List<CommandeFournisseurDto>> findAll() {
        return ResponseEntity.ok(commandeFournisseurService.findAll());
    }
    @Override
    public ResponseEntity<CommandeFournisseurDto> deleteArticle(Long idCommande, Long idLigneCommande) {
        return ResponseEntity.ok(commandeFournisseurService.deleteArticle(idCommande,idLigneCommande));
    }
    @Override
    public void delete(Long id) {
        commandeFournisseurService.delete(id);
    }
}
