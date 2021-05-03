package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.RolesDto;
import cm.belrose.stockserveur.model.RoleEnum;

import java.util.List;

public interface RolesService {

    RolesDto save(RolesDto dto);

    RolesDto findById(Long id);

    RolesDto findRoleByName(RoleEnum name);

    List<RolesDto> findAll() ;

    void delete(Long id);

}
