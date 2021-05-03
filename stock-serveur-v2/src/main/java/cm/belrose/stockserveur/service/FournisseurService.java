package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.FournisseurDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Long id);

    List<FournisseurDto> findAll() ;

    void delete(Long id);
}
