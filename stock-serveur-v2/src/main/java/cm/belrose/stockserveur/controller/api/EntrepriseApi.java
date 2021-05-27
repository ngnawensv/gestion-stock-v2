package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.model.Entreprise;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;
import static cm.belrose.stockserveur.config.constants.Constant.ENTREPRISE_ENDPOINT;

/**
 * @author NGNAWEN
 */
@Api(ENTREPRISE_ENDPOINT)
public interface EntrepriseApi {
    @ApiOperation(
            value = "Enregistrement d'une entreprise",
            notes = "Cette methode permet d'enregistrer un entreprise" ,
            response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Entreprise enregistré avec succès"),
            @ApiResponse(code = 404,message = "Entreprise à enregistré non valide"),
            @ApiResponse(code = 500,message = "Erreur d'enregistrement de l'entreprise"),
    })
    @PostMapping(value=ENTREPRISE_ENDPOINT+"/create")
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @ApiOperation(
            value = "Recherche  d'une entreprise",
            notes = "Cette methode permet de rechercher une entreprise par son ID" ,
            response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Entreprise retrouvée dans la base de données"),
            @ApiResponse(code = 404,message = "Entreprise inexistente dans la base de données avec l'ID fourni")
    })
    @GetMapping(value=ENTREPRISE_ENDPOINT+"/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("id") Long id);

    @ApiOperation(
            value = "Recherche  d'une entreprise",
            notes = "Cette methode permet de rechercher une entreprise par son code" ,
            response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Entreprise retrouvée dans la base de données"),
            @ApiResponse(code = 404,message = "Entreprise inexistente dans la base de données avec le code fourni")
    })
    @GetMapping(value=ENTREPRISE_ENDPOINT+"/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseByCode(@PathVariable("code")String code);

    @ApiOperation(
            value = "Recherche  d'une entreprise",
            notes = "Cette methode permet de rechercher une entreprise par son nom" ,
            response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Entreprise retrouvée dans la base de données"),
            @ApiResponse(code = 404,message = "Entreprise inexistente dans la base de données avec le nom fourni")
    })
    @GetMapping(value=ENTREPRISE_ENDPOINT+"/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseByNom(@PathVariable("nom")String nom);

    @ApiOperation(
            value = "Recherche  d'une entreprise",
            notes = "Cette methode permet de rechercher une entreprise par son email" ,
            response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Entreprise retrouvée dans la base de données"),
            @ApiResponse(code = 404,message = "Entreprise inexistente dans la base de données avec l'email fourni")
    })
    @GetMapping(value=ENTREPRISE_ENDPOINT+"/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseByEmail(@PathVariable("email")String email);

    @ApiOperation(
            value = "Liste toutes les entreprises",
            notes = "Cette methode permet de retourner la liste de toutes les entreprise" ,
            responseContainer = "List<EntrepriseDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Entreprise retrouvée dans la base de données"),
            @ApiResponse(code = 404,message = "Entreprise inexistente dans la base de données avec le code fourni")
    })
    @GetMapping(value=ENTREPRISE_ENDPOINT,produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @ApiOperation(value = "Suppression d'une entreprise",
            notes = "Cette methode permet de supprimer une entreprise à partir de son ID",
            response=EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Entreprise supprimé avec succès")
    })
    @DeleteMapping(value=ENTREPRISE_ENDPOINT+"/{id}")
    void delete(@PathVariable("id") Long id);
}
