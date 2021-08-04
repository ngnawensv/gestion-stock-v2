package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.ChangerMotDePasseUserDto;
import cm.belrose.stockserveur.dto.UsersDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.Users;
import cm.belrose.stockserveur.repository.UsersRepository;
import cm.belrose.stockserveur.service.UsersService;
import cm.belrose.stockserveur.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * Le 08/11/2020
 * @author Ngnawen Samuel
 */
@Service
@Transactional
@Slf4j
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
    public UsersDto changerMotDePasse(ChangerMotDePasseUserDto dto) {
        validate(dto);
        Optional<Users> utilisateurOptional = usersRepository.findById(dto.getId());
        if (utilisateurOptional.isEmpty()) {
            log.warn("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId());
            throw new EntityNotFoundException("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId(), ErrorCodes.USER_NOT_FOUND);
        }
        Users user = utilisateurOptional.get();
        user.setPassword(passwordEncoder.encode(dto.getMotDePasse()));

        return UsersDto.fromEntity(usersRepository.save(user));
    }

    @Override
    public List<UsersDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private void validate(ChangerMotDePasseUserDto dto) {
        if (dto == null) {
            log.warn("Impossible de modifier le mot de passe avec un objet NULL");
            throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
                    ErrorCodes.USER_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (dto.getId() == null) {
            log.warn("Impossible de modifier le mot de passe avec un ID NULL");
            throw new InvalidOperationException("ID utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.USER_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
            throw new InvalidOperationException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.USER_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
            throw new InvalidOperationException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
                    ErrorCodes.USER_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }
}
