package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeFournisseurDto;
import cm.belrose.stockserveur.dto.LigneVenteDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Long id);

    ArticleDto findArticleByCode(String code);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Long idArticle);

    List<LigneCommandeClientDto> findHistoriqueCommandeClient(Long idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Long idArticle);

    List<ArticleDto> findAllArticleByIdCategorie(Long idCategorie);


    void delete(Long id);
}
