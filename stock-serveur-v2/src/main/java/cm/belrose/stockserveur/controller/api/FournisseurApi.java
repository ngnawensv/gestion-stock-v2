package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/fournisseurs")
public interface FournisseurApi {

    @PostMapping(value=APP_ROOT+"/forunisseurs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(value=APP_ROOT+"/forunisseurs/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("id")Long id);

    @GetMapping(value=APP_ROOT+"/forunisseurs",produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/forunisseurs/{id}")
    void delete(@PathVariable("id") Long id);
}
