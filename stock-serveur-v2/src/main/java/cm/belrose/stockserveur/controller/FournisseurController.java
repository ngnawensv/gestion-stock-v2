package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.FournisseurApi;
import cm.belrose.stockserveur.dto.FournisseurDto;
import cm.belrose.stockserveur.model.Fournisseur;
import cm.belrose.stockserveur.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {
    @Autowired
    private FournisseurService fournisseurService;

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Long id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Long id) {
        fournisseurService.delete(id);
    }
}
