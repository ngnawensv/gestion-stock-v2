package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.VenteApi;
import cm.belrose.stockserveur.dto.VenteDto;
import cm.belrose.stockserveur.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VenteApi {

    @Autowired
    private VenteService venteService;

    @Override
    public VenteDto save(VenteDto dto) {
        return venteService.save(dto);
    }

    @Override
    public VenteDto findById(Long id) {
        return venteService.findById(id);
    }

    @Override
    public VenteDto findVenteByCode(String code) {
        return venteService.findVenteByCode(code);
    }

    @Override
    public List<VenteDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void delete(Long id) {
        venteService.delete(id);

    }
}
