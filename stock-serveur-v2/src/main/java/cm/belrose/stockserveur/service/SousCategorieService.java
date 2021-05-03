package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.SousCategorieDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

public interface SousCategorieService {

    SousCategorieDto save(SousCategorieDto dto);

    SousCategorieDto findById(Long id);

    SousCategorieDto findSousCategorieByCode(String code);

    List<SousCategorieDto> findAll() ;

    void delete(Long id);
}
