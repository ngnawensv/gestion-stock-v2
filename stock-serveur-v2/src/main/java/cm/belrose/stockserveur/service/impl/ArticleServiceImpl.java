package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.config.constants.Constant;
import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.Categorie;
import cm.belrose.stockserveur.repository.ArticleRepository;
import cm.belrose.stockserveur.repository.CategorieRepository;
import cm.belrose.stockserveur.service.ArticleService;
import cm.belrose.stockserveur.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Le 11/11/2020
 *
 * @author Ngnawen Samuel
 */
@Service
@Transactional
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    @Override
    public ArticleDto save(ArticleDto dto) {
        //Verification de la validité de l'article
        List<String> errors= ArticleValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Article non valide {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Long id){
        if(id==null){
            log.error("Article ID is null");
            return null;
        }
        return articleRepository.findById(id)
                .map(ArticleDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucun article avec l'ID="+id+"n'a été trouvé dans la BD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findArticleByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Article CODE is null");
            return null;
        }
        return articleRepository.findArticleByCode(code)
                .map(ArticleDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucun article avec le CODE= "+code+" n'a été trouvé dans la BD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll(){
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Article ID is null");
            return ;
        }
        articleRepository.deleteById(id);
    }

}
