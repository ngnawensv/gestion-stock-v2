package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.model.EtatCommande;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/commandesclients")
public interface CommandeClientApi {

    @PostMapping(value=APP_ROOT+"/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @PatchMapping(value=APP_ROOT+"/commandesclients/update/etat/{idCommande}/{etatCommande}")
    ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("idCommande") Long idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);

    @PatchMapping(value=APP_ROOT+"/commandesclients/update/quantite/{idCommande}/{idLigneCommande}/{idQuantite}")
    ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande")Long idLigneCommande,
                                             @PathVariable("quantite")BigDecimal quantite);

    @PatchMapping(value=APP_ROOT+"/commandesclients/upadate/client/{idCommande}/{idClient}")
    ResponseEntity<CommandeClientDto> updateClient(@PathVariable("idCommande") Long idCommande, @PathVariable("idClient") Long idClient);

    @PatchMapping(value=APP_ROOT+"/commandesclients/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    ResponseEntity<CommandeClientDto> updateArticle(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande") Long idLigneCommande,
                                    @PathVariable("idArticle")Long idArticle);

    @GetMapping(value=APP_ROOT+"/commandesclients/{code}")
    ResponseEntity<CommandeClientDto> findCommandeClientByCode(@PathVariable("code") String code);

    @GetMapping(value=APP_ROOT+"/commandesclients/lignesCommande/{idCommande}")
    ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(@PathVariable("idCommande") Long idCommande);

    @GetMapping(value=APP_ROOT+"/commandesclients/{id}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/commandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/commandesclients/delete/article/{idCommande}/{idLigneCommande}")
    ResponseEntity<CommandeClientDto> deleteArticle(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande") Long idLigneCommande);

    @DeleteMapping(value=APP_ROOT+"/commandesclients/delete/{id}")
    void delete(@PathVariable("id") Long id);
}
