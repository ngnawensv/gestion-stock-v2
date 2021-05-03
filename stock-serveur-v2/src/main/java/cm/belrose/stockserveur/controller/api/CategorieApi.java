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

    @PostMapping(value=APP_ROOT+"/categories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrement d'une categorie",
            notes = "Cette methode permet d'enregistrer une categorie" ,
            response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Catégorie créee avec succès"),
            @ApiResponse(code = 400,message = "Objet catégorie non valide")
    })
    CategorieDto save(@RequestBody CategorieDto dto);



    @GetMapping(value=APP_ROOT+"/categories/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche d'une categorie",
            notes = "Cette methode permet de rechercher une categorie par son ID" , response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Categorie a été retrouvée dans la BD"),
            @ApiResponse(code = 404,message = "Aucune categorie n'existe dans la BD avec l'ID fourni")
    })
    CategorieDto findById(@PathVariable("id") Long id);



    @GetMapping(value=APP_ROOT+"/categories/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche  d'une categorie",
            notes = "Cette methode permet de rechercher une categorie par son code" , response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Categorie a été retrouvé dans la BD"),
            @ApiResponse(code = 404,message = "Aucune categorie n'existe dans la BD avec le code fourni")
    })
    CategorieDto findCategorieByCode(@PathVariable("code") String code);



    @GetMapping(value=APP_ROOT+"/categories",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie d'une liste des articles",
            notes = "Cette methode permet de rechercher et renvoyer une liste des categories" ,
            responseContainer = "List<CategorieDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "La liste des categorie / une liste vide"),
    })
    List<CategorieDto> findAll() ;




    @DeleteMapping(value=APP_ROOT+"/categories/{id}")
    @ApiOperation(value = "Suppression d'une categorie",
            notes = "Cette methode permet de supprimer une categories à partir de son ID", response=CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Categorie supprimé avec succès")
    })
    void delete(Long id);

}
