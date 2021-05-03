package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.EntrepriseApi;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {

    @Autowired
    private EntrepriseService entrepriseService;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Long id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findEntrepriseByCode(String code) {
        return entrepriseService.findEntrepriseByCode(code);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Long id) {
        entrepriseService.delete(id);
    }
}
