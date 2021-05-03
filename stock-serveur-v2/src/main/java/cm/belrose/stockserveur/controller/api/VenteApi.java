package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.VenteDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/ventes")
public interface VenteApi {

    @PostMapping(value=APP_ROOT+"/ventes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto save(@RequestBody VenteDto dto);

    @GetMapping(value=APP_ROOT+"/ventes/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/ventes/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findVenteByCode(@PathVariable("code") String code);

    @GetMapping(value=APP_ROOT+"/ventes",produces = MediaType.APPLICATION_JSON_VALUE)
    List<VenteDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/ventes/{id}")
    void delete(@PathVariable("id") Long id);
}
