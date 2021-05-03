package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.SousCategorieApi;
import cm.belrose.stockserveur.dto.SousCategorieDto;
import cm.belrose.stockserveur.model.SousCategorie;
import cm.belrose.stockserveur.service.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SousCategorieController implements SousCategorieApi {

    @Autowired
    private SousCategorieService sousCategorieService;

    @Override
    public SousCategorieDto save(SousCategorieDto dto) {
        return sousCategorieService.save(dto);
    }

    @Override
    public SousCategorieDto findById(Long id) {
        return sousCategorieService.findById(id);
    }

    @Override
    public SousCategorieDto findSousCategorieByCode(String code) {
        return sousCategorieService.findSousCategorieByCode(code);
    }

    @Override
    public List<SousCategorieDto> findAll() {
        return sousCategorieService.findAll();
    }

    @Override
    public void delete(Long id) {
        sousCategorieService.delete(id);
    }
}
