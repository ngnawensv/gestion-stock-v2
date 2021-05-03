package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.SousCategorieDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/souscategories")
public interface SousCategorieApi {

    @PostMapping(value=APP_ROOT+"/sousCategories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    SousCategorieDto save(@RequestBody SousCategorieDto dto);

    @GetMapping(value=APP_ROOT+"/sousCategories/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    SousCategorieDto findById(@PathVariable("id")Long id);

    @GetMapping(value=APP_ROOT+"/sousCategories/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    SousCategorieDto findSousCategorieByCode(@PathVariable("code") String code);

    @GetMapping(value=APP_ROOT+"/sousCategories",produces = MediaType.APPLICATION_JSON_VALUE)
    List<SousCategorieDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/sousCategories/{id}")
    void delete(@PathVariable("id")Long id);
}
