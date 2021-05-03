package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.ArticleApi;
import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.payload.response.MessageResponse;
import cm.belrose.stockserveur.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Le 10/11/2020
 *
 * @author Ngnawen Samuel
 */
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class ArticleController  implements ArticleApi {

    @Autowired
    private ArticleService articleService;

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto update(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Long id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCode(String code) {
        return articleService.findArticleByCode(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Long id) {
        articleService.delete(id);
        return;
    }



    /*@PostMapping(value=APP_ROOT+"/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> save(@RequestBody ArticleDto dto) {
        Article article = articleService.save(dto);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping(value=APP_ROOT+"/articles/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> findById(@PathVariable("id") Long id){
        Optional<Article> _article = articleService.findById(id);

        if (_article.isPresent()) {
            return new ResponseEntity<>(_article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value=APP_ROOT+"/articles/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> findByCode(@PathVariable("code") String code){
        Optional<Article> _article = articleService.findByCode(code);

        if (_article.isPresent()) {
            return new ResponseEntity<>(_article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value=APP_ROOT+"/articles",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> findByCode(@PathVariable("code") String code){
        Optional<Article> _article = articleService.findByCode(code);

        if (_article.isPresent()) {
            return new ResponseEntity<>(_article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value=APP_ROOT+"/articles/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("id") Long id) {
        try {
            articleService.delete(id);
            logger.info("Article is successfully delete........");
            return new ResponseEntity<>(new MessageResponse("Article is successfully delete........"), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Deleting operation failed........");
            return new ResponseEntity<>(new MessageResponse("Deleting operation failed........"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

   /* @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAll(@RequestParam(required = false) String nom) throws Exception {
        try {
            List<Article> articles = new ArrayList<>();
            //Creating Consumer for article object which will be used in forEach method for adding article on the list
            Consumer<Article> consumer= article->articles.add(article);
            //Consumer<Article> consumer1= articles::add; // same with the above consumer by using reference method
            if (nom == null)
                articleService.findAll().forEach(consumer);
            else
                articleService.findByNomContaining(nom).forEach(consumer);
            if (articles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/



    /*@PutMapping("articles/{id}")
    public ResponseEntity<Article> update(@PathVariable("id") long id, @RequestBody Article article) throws Exception {
        Optional<Article> articleData = articleService.findById(id);
        if (articleData.isPresent()) {
            Article _article= articleData.get();
            _article.setId(id);
            _article.setDesignation(article.getDesignation());
            _article.setPrixAchat(article.getPrixAchat());
            _article.setPrixVente(article.getPrixVente());
            _article.setQuantite(article.getQuantite());
            return new ResponseEntity<>(articleService.update(_article), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/



   /* @DeleteMapping("/articles")
    public ResponseEntity<MessageResponse> deleteAll() {
        try {
            articleService.deleteAll();
            logger.info("All Articles are successfully deleted........");
            return new ResponseEntity<>(new MessageResponse("All Articles are successfully deleted........"), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Deleting operation failed........");
            return new ResponseEntity<>(new MessageResponse("Deleting operation failed........"),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }*/
}
