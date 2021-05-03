package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.RolesApi;
import cm.belrose.stockserveur.dto.RolesDto;
import cm.belrose.stockserveur.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolesController implements RolesApi {

    @Autowired
    private RolesService rolesService;

    @Override
    public void save(RolesDto rolesDto) {

    }

    @Override
    public RolesDto findById(Long id) {
        return null;
    }

    @Override
    public List<RolesDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
