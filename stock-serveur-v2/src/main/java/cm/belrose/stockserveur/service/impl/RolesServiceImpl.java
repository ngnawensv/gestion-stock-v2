package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.RolesDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.RoleEnum;
import cm.belrose.stockserveur.repository.RolesRepository;
import cm.belrose.stockserveur.service.RolesService;
import cm.belrose.stockserveur.validator.RoleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Le 08/11/2020
 * @author Ngnawen Samuel
 */
@Service
@Slf4j
public class RolesServiceImpl implements RolesService {

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public RolesDto save(RolesDto dto) {
        List<String> errors= RoleValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Roles non valide {}", dto);
            throw new InvalidEntityException("Le role n'est pas valide", ErrorCodes.ROLE_NOT_VALID, errors);
        }
        return RolesDto.fromEntity(rolesRepository.save(RolesDto.toEntity(dto)));
    }


    @Override
    public RolesDto findById(Long id) {
        if(id==null){
            log.error("Roles ID is null");
            return null;
        }
        return rolesRepository.findById(id)
                .map(RolesDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucune role avec l'ID="+id+"n'a été trouvé dans la BD",
                                ErrorCodes.ROLE_NOT_FOUND));
    }


    @Override
    public RolesDto findRoleByName(RoleEnum name) {
        if(name==null){
            log.error("Roles ID is null");
            return null;
        }
        return rolesRepository.findByName(name)
                .map(RolesDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucune role avec le nom="+name+"n'a été trouvé dans la BD",
                                ErrorCodes.ROLE_NOT_FOUND));
    }


    @Override
    public List<RolesDto> findAll() {
        return rolesRepository.findAll().stream()
                .map(RolesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Roles ID is null");
            return ;
        }
        rolesRepository.deleteById(id);
    }

    /*


    @Override
    public void save(Roles role) {
        Assert.notNull(role,"Roles must not be null");
        roleRepository.save(role);
    }

    @Override
    public RolesDto findByName(RoleEnum name) {
        return roleRepository.fi(name);
    }

    @Override
    public void saveAll(Set<Roles> listOfRoles) {
        roleRepository.saveAll(listOfRoles);
    }

    @Override
    public List<Roles> findAllRole() {
        return roleRepository.findAll();
    }
*/
}
