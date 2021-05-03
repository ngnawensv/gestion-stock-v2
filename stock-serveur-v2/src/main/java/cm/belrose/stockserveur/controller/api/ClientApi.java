package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.ClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+ "/clients")
public interface ClientApi {

    @PostMapping(value=APP_ROOT+"/clients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value=APP_ROOT+"/clients/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/clients",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/clients/{id}")
    void delete(@PathVariable("id") Long id);
}
