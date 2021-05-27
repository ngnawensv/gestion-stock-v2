package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.dto.UsersDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;
import static cm.belrose.stockserveur.config.constants.Constant.USER_ENDPOINT;

@Api(USER_ENDPOINT)
public interface UsersApi {

    @PostMapping(value=USER_ENDPOINT)
    @ApiOperation(value = "Enregistrement d'un utilisateur",
            notes = "Cette methode permet d'enregistrer un utilisateur" , response = UsersDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Utilisateur créee avec succès"),
            @ApiResponse(code = 400,message = "Objet utilisateur non valide")
    })
    UsersDto save(@RequestBody UsersDto dto);

    @GetMapping(value=USER_ENDPOINT+"/{id}")
    @ApiOperation(value = "Recherche  d'un utilisateur",
            notes = "Cette methode permet de rechercher un utilisateur par son id" , response = UsersDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Utilisateur a été retrouvé dans la BD"),
            @ApiResponse(code = 404,message = "Aucun utilisateur n'existe dans la BD avec l'email fourni")
    })
    UsersDto findById(@PathVariable("id") Long id);


    @GetMapping(value=USER_ENDPOINT+"/find/{email}")
    @ApiOperation(value = "Recherche  d'un utilisateur",
            notes = "Cette methode permet de rechercher un utilisateur par son email" , response = UsersDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Utilisateur a été retrouvé dans la BD"),
            @ApiResponse(code = 404,message = "Aucun utilisateur n'existe dans la BD avec l'email fourni")
    })
    UsersDto findByEmail(@PathVariable("email") String email);

    @GetMapping(value=USER_ENDPOINT)
    @ApiOperation(value = "Lister les utilisateurs",
            notes = "Cette methode permet de lister tous les utilisateurs de la BD" , responseContainer = "List<UsersDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Liste des utilisateurs ou liste vide")
    })
    List<UsersDto> findAll() ;

    @DeleteMapping(value=USER_ENDPOINT+"/{id}")
    void delete(@PathVariable Long id);
}
