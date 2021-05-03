package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.RolesDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/roles")
public interface RolesApi {

    @PostMapping(value=APP_ROOT+"/roles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody RolesDto rolesDto);

    @GetMapping(value=APP_ROOT+"/roles/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/roles",produces = MediaType.APPLICATION_JSON_VALUE)
    List<RolesDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/roles/{id}")
    void delete(@PathVariable("id")Long id);
}
