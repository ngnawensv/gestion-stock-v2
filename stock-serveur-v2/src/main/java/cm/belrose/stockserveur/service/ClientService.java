package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.model.Article;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto dto);

    ClientDto findById(Long id);

    List<ClientDto> findAll() ;

    void delete(Long id);
}
