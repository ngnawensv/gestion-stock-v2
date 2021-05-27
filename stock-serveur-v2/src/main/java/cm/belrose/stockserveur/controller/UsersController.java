package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.UsersApi;
import cm.belrose.stockserveur.dto.UsersDto;
import cm.belrose.stockserveur.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController implements UsersApi {

    @Autowired
    private UsersService usersService;

    @Override
    public UsersDto save(UsersDto dto) {
        return usersService.save(dto);
    }

    @Override
    public UsersDto findById(Long id) {
        return usersService.findById(id);
    }

    @Override
    public UsersDto findByEmail(String email) {
        return usersService.findUsersByEmail(email);
    }

    @Override
    public List<UsersDto> findAll() {
        return usersService.findAll();
    }

    @Override
    public void delete(Long id) {
        usersService.delete(id);
    }
}
