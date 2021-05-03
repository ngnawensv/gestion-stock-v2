package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

/**
 * Le 11/11/2020
 *
 * @author Ngnawen Samuel
 */
public interface CategorieService {

    CategorieDto save(CategorieDto dto);

    CategorieDto findById(Long id);

    CategorieDto findCategorieByCode(String code);

    List<CategorieDto> findAll() ;

    void delete(Long id);

    Article update(CategorieDto dto);

    void deleteAll();

    List<Article> findByNomContaining(String libelle);
}
