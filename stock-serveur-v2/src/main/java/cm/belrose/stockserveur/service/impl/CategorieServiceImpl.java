package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.Categorie;
import cm.belrose.stockserveur.repository.CategorieRepository;
import cm.belrose.stockserveur.service.CategorieService;
import cm.belrose.stockserveur.validator.ArticleValidator;
import cm.belrose.stockserveur.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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
                ()->new EntityNotFoundException("Aucun categorie avec l'ID="+id+"n'a été trouvé dans la BD",
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

    @Override
    public Article update(CategorieDto dto) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Article> findByNomContaining(String libelle) {
        return null;
    }

   /* private static final Logger logger = LoggerFactory.getLogger(CategorieServiceImpl.class);
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public Optional<Categorie> findById(Long id) throws Exception {
        return categorieRepository.findById(id);
    }

    @Override
    public List<Categorie> findAll() throws Exception {
        return categorieRepository.findAll();
    }

    *//*@Override
    public Categorie save(CategorieDTO categorieDto) throws Exception {
       Categorie cat= new Categorie(categorieDto.getCode(),categorieDto.getNom());
       return  categorieRepository.save(cat);
    }*//*

    @Override
    public Categorie save(Categorie categorie) throws Exception {
        //Categorie _categorie= new Categorie(categorie.getCode(),categorie.getNom());
        try{
            Assert.notNull(categorie,"Category must not be null");
            return  categorieRepository.save(categorie);
        }catch(Exception ex){
            logger.error(ex.getMessage(),ex);
            return  categorieRepository.save(categorie);
        }
    }

    @Override
    public Categorie update(Categorie categorie) throws Exception {
        try{
            Assert.notNull(categorie,"Category must not be null");
            return  categorieRepository.save(categorie);
        }catch(Exception ex){
            logger.error(ex.getMessage(),ex);
            return  categorieRepository.save(categorie);
        }
    }

   *//* @Override
    public void delete(Categorie categorie) throws Exception {
        try {
            categorieRepository.delete(categorie);
        } catch (EmptyResultDataAccessException ex) {
            logger.error(String.format("Categpry with Name =" + categorie.getNom() + " don't exist"));
            throw new EmptyResultDataAccessException("DeleteUserError", HttpStatus.NOT_FOUND.value());
        }

    }*//*

    @Override
    public void deleteById(Long id) {
        Optional<Categorie> categorie=categorieRepository.findById(id);
        if (categorie.get().getCode()=="0000"){
            logger.error("Impossible to delete default category");
        }
        categorieRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        categorieRepository.deleteAll();
    }

    @Override
    public Boolean existsByNom(String nom) {
        return categorieRepository.existsByLibelle(nom);
    }

   *//* @Override
    public Page<Categorie> cherhcer(String keyword, Pageable pageable) {
        return categorieRepository.chercher(keyword,pageable);
    }*//*

    @Override
    public Categorie findByCode(String code) {
        return categorieRepository.findByCode(code);
    }

    @Override
    public List<Categorie> findByNomContaining(String nom) {
        return categorieRepository.findByLibelleContaining(nom);
    }*/
}
