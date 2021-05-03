package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.model.CommandeClient;

import java.util.List;
import java.util.Optional;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findById(Long id);

    CommandeClientDto findCommandeClientByCode(String code);

    List<CommandeClientDto> findAll() ;

    void delete(Long id);
}
