package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.CommandeFournisseurApi;
import cm.belrose.stockserveur.dto.CommandeFournisseurDto;
import cm.belrose.stockserveur.service.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    @Autowired
    private CommandeFournisseurService commandeFournisseurService;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }

    @Override
    public CommandeFournisseurDto findById(Long id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public CommandeFournisseurDto findCommandeClientByCode(String code) {
        return commandeFournisseurService.findCommandeClientByCode(code);
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    public void delete(Long id) {
        commandeFournisseurService.delete(id);
    }
}
