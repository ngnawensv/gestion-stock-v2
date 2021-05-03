package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/commandesfournisseurs")
public interface CommandeFournisseurApi {

    @PostMapping(value=APP_ROOT+"/commandeFournisseurs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(value=APP_ROOT+"/commandeFournisseurs/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/commandeFournisseurs/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findCommandeClientByCode(@PathVariable("code")String code);

    @GetMapping(value=APP_ROOT+"/commandeFournisseurs",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeFournisseurDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/commandeFournisseurs/{id}")
    void delete(@PathVariable("id") Long id);
}
