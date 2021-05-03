package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Long id);

    EntrepriseDto findEntrepriseByCode(String code);

    List<EntrepriseDto> findAll();

    void delete(Long id);
}
