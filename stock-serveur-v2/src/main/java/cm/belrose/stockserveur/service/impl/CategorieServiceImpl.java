package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.repository.CategorieRepository;
import cm.belrose.stockserveur.service.CategorieService;
import cm.belrose.stockserveur.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Le 11/11/2020
 *
 * @author Ngnawen Samuel
 */
@Service
@Transactional
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public CategorieDto save(CategorieDto dto) {
        List<String> errors= CategorieValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Categorie non valide {}", dto);
            throw new InvalidEntityException("La catégorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategorieDto.fromEntity(categorieRepository.save(CategorieDto.toEntity(dto)));
    }

    @Override
    public CategorieDto findById(Long id) {
        if(id==null){
            log.error("Categorie ID is null");
            return null;
        }
        return categorieRepository.findById(id)
                .map(CategorieDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucun categorie avec l'ID="+id+" n'a été trouvé dans la BD",
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategorieDto findCategorieByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Categorie CODE is null");
            return null;
        }
        return categorieRepository.findCategorieByCode(code)
                .map(CategorieDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune caegoriet avec le CODE= "+code+" n'a été trouvé dans la BD",
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Categorie ID is null");
            return ;
        }
        categorieRepository.deleteById(id);
    }
}
