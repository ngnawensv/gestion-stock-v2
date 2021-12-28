package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.CategorieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;
import static cm.belrose.stockserveur.config.constants.Constant.CATEGORIE_ENDPOINT;

@Api(CATEGORIE_ENDPOINT)
public interface CategorieApi {

    //Documentation de la méthode save(...)
    @ApiOperation(
            value = "Enregistrement d'une categorie",
            notes = "Cette methode permet d'enregistrer une categorie" ,
            response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Catégorie créee avec succès"),
            @ApiResponse(code = 400,message = "Catégorie à enregistré non valide"),
            @ApiResponse(code = 500,message = "Erreur d'enregistrement de la catégorie")
    })
    //Endpoint d'enregistrement d'un categorie
    @PostMapping(value=CATEGORIE_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto save(@RequestBody CategorieDto dto);


    //Documentation de la méthode findById(...)
    @ApiOperation(
            value = "Recherche d'une categorie",
            notes = "Cette methode permet de rechercher une categorie par son ID" ,
            response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Categorie a été retrouvée dans la BD"),
            @ApiResponse(code = 404,message = "Aucune categorie n'existe dans la BD avec l'ID fourni")
    })
    //Endpoint de recherche d'une categorie selon le id
    @GetMapping(value=CATEGORIE_ENDPOINT+"/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findById(@PathVariable("id") Long id);


    //Documentation de la méthode findByCode(...)
    @ApiOperation(
            value = "Recherche  d'une categorie",
            notes = "Cette methode permet de rechercher une categorie par son code" ,
            response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Categorie a été retrouvé dans la BD"),
            @ApiResponse(code = 404,message = "Aucune categorie n'existe dans la BD avec le code fourni")
    })
    //Endpoint de recherche d'une categorie selon le code
    @GetMapping(value=CATEGORIE_ENDPOINT+"/code/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findByCode(@PathVariable("code") String code);


    //Documentation de la méthode findAll(...)
    @ApiOperation(
            value = "Renvoie d'une liste des articles",
            notes = "Cette methode permet de rechercher et renvoyer une liste des categories" ,
            responseContainer = "List<CategorieDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "La liste des categorie / une liste vide"),
    })
    //Endpoint pour lister toutes les categories
    @GetMapping(value=CATEGORIE_ENDPOINT,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> findAll() ;

    //Documentation de la méthode delete(...)
    @ApiOperation(value = "Suppression d'une categorie",
            notes = "Cette methode permet de supprimer une categories à partir de son ID",
            response=CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Categorie supprimé avec succès")
    })
    //Endpoint de suppresion d'un categorie en fonction de l'id
    @DeleteMapping(value=CATEGORIE_ENDPOINT+"/{id}")
    void delete(@PathVariable("id") Long id);

}
