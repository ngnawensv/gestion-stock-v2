package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto dto);

    CommandeFournisseurDto findById(Long id);

    CommandeFournisseurDto findCommandeClientByCode(String code);

    List<CommandeFournisseurDto> findAll() ;

    void delete(Long id);
}
