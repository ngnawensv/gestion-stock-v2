package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeFournisseurDto;
import cm.belrose.stockserveur.dto.LigneVenteDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;
import static cm.belrose.stockserveur.config.constants.Constant.ARTICLE_ENDPOINT;

@Api(ARTICLE_ENDPOINT)
@RequestMapping()
public interface ArticleApi {

    @PostMapping(value=ARTICLE_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrement d'un article",
            notes = "Cette methode permet d'enregistrer un article" , response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Article créee avec succès"),
            @ApiResponse(code = 400,message = "Objet article non valide")
    })
    ArticleDto save(@RequestBody ArticleDto dto) ;



    @PutMapping(value=ARTICLE_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modification d'un article",
            notes = "Cette methode permet de modifier un article" , response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "L'oject article modifier")
    })
    ArticleDto update(@RequestBody ArticleDto dto) ;



    @GetMapping(value=ARTICLE_ENDPOINT+"/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche d'un article",
            notes = "Cette methode permet de rechercher un article par son ID" , response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Article a été retrouvé dns la BD"),
            @ApiResponse(code = 404,message = "Aucun article n'existe dans la BD avec l'ID fourni")
    })
    ArticleDto findById(@PathVariable("id") Long id);



    @GetMapping(value=ARTICLE_ENDPOINT+"/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche  d'un article",
            notes = "Cette methode permet de rechercher un article par son code" , response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Article a été retrouvé dans la BD"),
            @ApiResponse(code = 404,message = "Aucun article n'existe dans la BD avec le code fourni")
    })
    ArticleDto findByCode(@PathVariable("code") String code);

    @GetMapping(value=ARTICLE_ENDPOINT,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie d'une liste des articles",
            notes = "Cette methode permet de rechercher et renvoyer  la liste des categorie de la base de données" ,
            responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Liste des aticles / Liste vide")
    })
    List<ArticleDto> findAll();

    @GetMapping(value=ARTICLE_ENDPOINT+"/historique/vente/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Long idArticle);

    @GetMapping(value=ARTICLE_ENDPOINT+"/historique/commandeclient/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LigneCommandeClientDto> findHistoriqueCommandeClient(@PathVariable("idArticle") Long idArticle);

    @GetMapping(value=ARTICLE_ENDPOINT+"/historique/commandefournisseur/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Long idArticle);

    @GetMapping(value=ARTICLE_ENDPOINT+"/historique/filtre/categorie/{idCategorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> findAllArticleByIdCategorie(@PathVariable("idCategorie") Long idCategorie);

    @DeleteMapping(value=ARTICLE_ENDPOINT+"/{id}")
    @ApiOperation(value = "Suppression d'un article",
            notes = "Cette methode permet de supprimer un article à partir de son ID",
            response=ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Article supprimé avec succès")
    })
    void delete(@PathVariable("id") Long id) ;


}
