package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.dto.SousCategorieDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Categorie;
import cm.belrose.stockserveur.model.SousCategorie;
import cm.belrose.stockserveur.repository.SousCategorieRepository;
import cm.belrose.stockserveur.service.SousCategorieService;
import cm.belrose.stockserveur.validator.CategorieValidator;
import cm.belrose.stockserveur.validator.SousCategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class SousCategorieServiceImpl implements SousCategorieService {

    @Autowired
    private SousCategorieRepository sousCategorieRepository;

    @Override
    public SousCategorieDto save(SousCategorieDto dto) {
        List<String> errors= SousCategorieValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" SousCategorie non valide {}", dto);
            throw new InvalidEntityException("La sous catégorie n'est pas valide", ErrorCodes.SOUS_CATEGORIE_NOT_VALID, errors);
        }
        return SousCategorieDto.fromEntity(sousCategorieRepository.save(SousCategorieDto.toEntity(dto)));
    }

    @Override
    public SousCategorieDto findById(Long id) {
        if(id==null){
            log.error(" Sous categorie ID is null");
            return null;
        }
        return sousCategorieRepository.findById(id)
                .map(SousCategorieDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune sous categorie avec l'ID="+id+"n'a été trouvé dans la BD",
                        ErrorCodes.SOUS_CATEGORIE_NOT_FOUND));
    }

    @Override
    public SousCategorieDto findSousCategorieByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Sous categorie CODE is null");
            return null;
        }
        Optional<SousCategorie> sousCategorie=sousCategorieRepository.findSousCategorieByCode(code);
        SousCategorieDto dto=SousCategorieDto.fromEntity(sousCategorie.get());
        return Optional.of(dto).orElseThrow(
                ()->new EntityNotFoundException("Aucune sous categorie avec le CODE= "+code+" n'a été trouvé dans la BD",
                        ErrorCodes.SOUS_CATEGORIE_NOT_FOUND));
    }

    @Override
    public List<SousCategorieDto> findAll() {
        return sousCategorieRepository.findAll().stream()
                .map(SousCategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Sous categorie ID is null");
            return ;
        }
        sousCategorieRepository.deleteById(id);
    }

}
