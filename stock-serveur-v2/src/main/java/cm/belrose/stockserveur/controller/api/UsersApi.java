package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.UsersDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/users")
public interface UsersApi {

    @PostMapping(value=APP_ROOT+"/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UsersDto save(@RequestBody UsersDto dto);

    @GetMapping(value=APP_ROOT+"/users/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    UsersDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/users",produces = MediaType.APPLICATION_JSON_VALUE)
    List<UsersDto> findAll() ;

    @DeleteMapping(value=APP_ROOT+"/users/{id}")
    void delete(@PathVariable Long id);
}
