package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/entreprises")
public interface EntrepriseApi {

    @PostMapping(value=APP_ROOT+"/entreprises", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(value=APP_ROOT+"/entreprises/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/entreprises/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseByCode(@PathVariable("code")String code);

    @GetMapping(value=APP_ROOT+"/entreprises",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value=APP_ROOT+"/entreprises/{id}")
    void delete(@PathVariable("id") Long id);
}
