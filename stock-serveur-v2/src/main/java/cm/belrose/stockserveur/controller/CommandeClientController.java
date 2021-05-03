package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.CommandeClientApi;
import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.service.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeClientController implements CommandeClientApi {

    @Autowired
    private CommandeClientService commandeClientService;

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        return commandeClientService.save(dto);
    }

    @Override
    public CommandeClientDto findById(Long id) {
        return commandeClientService.findById(id);
    }

    @Override
    public CommandeClientDto findCommandeClientByCode(String code) {
        return commandeClientService.findCommandeClientByCode(code);
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientService.findAll();
    }

    @Override
    public void delete(Long id) {
        commandeClientService.delete(id);
    }
}
