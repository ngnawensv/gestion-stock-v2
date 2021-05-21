package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.CommandeFournisseurDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeFournisseurDto;
import cm.belrose.stockserveur.model.EtatCommande;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/commandesFournisseurs")
public interface CommandeFournisseurApi {


    @PostMapping(value=APP_ROOT+"/commandesFournisseurs/create")
    ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto dto);

    @PatchMapping(value=APP_ROOT+"/commandesFournisseurs/update/etat/{idCommande}/{etatCommande}")
    ResponseEntity<CommandeFournisseurDto> updateEtatCommande(@PathVariable("idCommande") Long idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);

    @PatchMapping(value=APP_ROOT+"/commandesFournisseurs/update/quantite/{idCommande}/{idLigneCommande}/{idQuantite}")
    ResponseEntity<CommandeFournisseurDto> updateQuantiteCommande(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande")Long idLigneCommande,
                                                             @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping(value=APP_ROOT+"/commandesFournisseurs/upadate/client/{idCommande}/{idFournisseur}")
    ResponseEntity<CommandeFournisseurDto> updateFournisseur(@PathVariable("idCommande") Long idCommande, @PathVariable("idClient") Long idFournisseur);

    @PatchMapping(value=APP_ROOT+"/commandesFournisseurs/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    ResponseEntity<CommandeFournisseurDto> updateArticle(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande") Long idLigneCommande,
                                                    @PathVariable("idArticle")Long idArticle);

    @GetMapping(value=APP_ROOT+"/commandesFournisseurs/{code}")
    ResponseEntity<CommandeFournisseurDto> findCommandeFournisseurByCode(@PathVariable("code") String code);

    @GetMapping(value=APP_ROOT+"/commandesFournisseurs/lignesCommande/{idCommande}")
    ResponseEntity<List<LigneCommandeFournisseurDto>> findAllLignesCommandesFournisseurByCommandeFournisseurId(@PathVariable("idCommande") Long idCommande);

    @GetMapping(value=APP_ROOT+"/commandesFournisseurs/{id}")
    ResponseEntity<CommandeFournisseurDto> findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/commandesFournisseurs/all")
    ResponseEntity<List<CommandeFournisseurDto>> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/commandesFournisseurs/delete/article/{idCommande}/{idLigneCommande}")
    ResponseEntity<CommandeFournisseurDto> deleteArticle(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande") Long idLigneCommande);

    @DeleteMapping(value=APP_ROOT+"/commandesFournisseurs/delete/{id}")
    void delete(@PathVariable("id") Long id);
}
