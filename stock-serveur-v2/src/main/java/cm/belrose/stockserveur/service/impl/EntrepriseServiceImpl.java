package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.config.constants.Constant;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.dto.RolesDto;
import cm.belrose.stockserveur.dto.UsersDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.RoleEnum;
import cm.belrose.stockserveur.model.Roles;
import cm.belrose.stockserveur.repository.EntrepriseRepository;
import cm.belrose.stockserveur.repository.RolesRepository;
import cm.belrose.stockserveur.service.EntrepriseService;
import cm.belrose.stockserveur.service.UsersService;
import cm.belrose.stockserveur.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author NGNAWEN
 */
@Service
@Transactional
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private UsersService usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors= EntrepriseValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Entreprise non valide {}", dto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        EntrepriseDto saveEntreprise=EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
        UsersDto usersDto= fromEntreprise(saveEntreprise);
        RolesDto rolesDto=RolesDto.fromEntity(rolesRepository.findByName(RoleEnum.ROLE_ADMIN).get());
        Set<RolesDto> rolesDtoSet=new HashSet<>();
        rolesDtoSet.add(rolesDto);
        usersDto.setRoles(rolesDtoSet);
        UsersDto savedUser=usersService.save(usersDto);

        return saveEntreprise;
    }

    private UsersDto fromEntreprise(EntrepriseDto dto) {
        return UsersDto.builder()
                .adresse(dto.getAdresse())
                .nom(dto.getNom())
                .prenom(dto.getCodeFiscal())
                .email(dto.getEmail())
                .password(generateRandomPassword())
                .entreprise(dto)
                .dateNaissance(Instant.now())
                .photo(dto.getLogo())
                .build();
    }
    private String generateRandomPassword() {
        return passwordEncoder.encode(Constant.DEFAULT_ADMIN_PASSWORD);
    }
    @Override
    public EntrepriseDto findById(Long id) {
        if(id==null){
            log.error("Entreprise ID is null");
            return null;
        }
        return entrepriseRepository.findById(id)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune entreprise avec l'ID = "+id+" n'a été trouvé dans la BD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseByCodeFiscal(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Categorie CODE is null");
            return null;
        }
        return entrepriseRepository.findEntrepriseByNom(code)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune entreprise avec le NOM = "+code+" n'a été trouvé dans la BD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Categorie CODE is null");
            return null;
        }
        return entrepriseRepository.findEntrepriseByNom(nom)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucune entreprise avec le NOM = "+nom+" n'a été trouvé dans la BD",
                                ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseByEmail(String email) {
        if(!StringUtils.hasLength(email)){
            log.error("Categorie CODE is null");
            return null;
        }
        return entrepriseRepository.findEntrepriseByNom(email)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucune entreprise avec le NOM = "+email+" n'a été trouvé dans la BD",
                                ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Entreprise ID is null");
            return ;
        }
        entrepriseRepository.deleteById(id);
    }

}
