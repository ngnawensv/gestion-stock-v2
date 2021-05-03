package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

public interface ArticleService {

     ArticleDto save(ArticleDto dto);

    ArticleDto findById(Long id);

    ArticleDto findArticleByCode(String code);

     List<ArticleDto> findAll() ;

     void delete(Long id);
}
