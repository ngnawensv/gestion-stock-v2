package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.UsersDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.repository.UsersRepository;
import cm.belrose.stockserveur.service.UsersService;
import cm.belrose.stockserveur.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Le 08/11/2020
 * @author Ngnawen Samuel
 */
@Service
@Transactional
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UsersDto save(UsersDto dto) {
        List<String> errors= UserValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Utilisateur non valide {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_VALID, errors);
        }
        return UsersDto.fromEntity(usersRepository.save(UsersDto.toEntity(dto)));
    }

    @Override
    public UsersDto findById(Long id) {
        if(id==null){
            log.error("Client ID is null");
            return null;
        }

        return usersRepository.findById(id)
                .map(UsersDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucun utilisateur avec l'id= "+id+" n'a été trouvé dans la BD",
                                ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public UsersDto findUsersByUsername(String username) {
        return usersRepository.findUsersByUsername(username)
                .map(UsersDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucun utilisateur avec le username= "+username+" n'a été trouvé dans la BD",
                                ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public UsersDto findUsersByEmail(String email) {
        return usersRepository.findUsersByEmail(email)
                .map(UsersDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucun utilisateur avec l'email= "+email+" n'a été trouvé dans la BD",
                                ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<UsersDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
