package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.VenteDto;

import java.util.List;

public interface VenteService {

    VenteDto save(VenteDto dto);

    VenteDto findById(Long id);

    VenteDto findVenteByCode(String code);

    List<VenteDto> findAll() ;

    void delete(Long id);
}
