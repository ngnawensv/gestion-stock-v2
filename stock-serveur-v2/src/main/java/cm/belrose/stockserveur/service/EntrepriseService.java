package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

/**
 * @author NGNAWEN
 */
public interface EntrepriseService {
    EntrepriseDto save(EntrepriseDto dto);
    EntrepriseDto findById(Long id);
    EntrepriseDto findEntrepriseByCodeFiscal(String codeFiscal);
    EntrepriseDto findEntrepriseByNom(String nom);
    EntrepriseDto findEntrepriseByEmail(String email);
    List<EntrepriseDto> findAll();
    void delete(Long id);
}
