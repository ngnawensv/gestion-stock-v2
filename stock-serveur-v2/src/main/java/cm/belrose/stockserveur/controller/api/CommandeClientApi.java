package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/commandesclients")
public interface CommandeClientApi {

    @PostMapping(value=APP_ROOT+"/commandeClients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto save(@RequestBody CommandeClientDto dto);

    @GetMapping(value=APP_ROOT+"/commandeClients/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/commandeClients/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findCommandeClientByCode(@PathVariable("id") String code);

    @GetMapping(value=APP_ROOT+"/commandeClients",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeClientDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/commandeClients/{id}")
    void delete(@PathVariable("id") Long id);
}
