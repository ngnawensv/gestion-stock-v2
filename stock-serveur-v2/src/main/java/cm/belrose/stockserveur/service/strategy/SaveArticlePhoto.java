package cm.belrose.stockserveur.service.strategy;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.service.ArticleService;
import cm.belrose.stockserveur.service.FlickrService;
import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("articleStrategy")
@Slf4j
public class SaveArticlePhoto implements Strategy<ArticleDto> {

    @Autowired
    private FlickrService flickrService;
    @Autowired
    private ArticleService articleService;

    @Override
    public ArticleDto savePhoto(Long id,InputStream photo, String titre) throws FlickrException {
        ArticleDto article=articleService.findById(id);
        String urlPhoto=flickrService.savePhotos(photo,titre);
        if(!StringUtils.hasLength(urlPhoto)){
           throw new InvalidOperationException("Erreur d'enregistrement de la photo de l'article",
                   ErrorCodes.UPDATE_PHOTO_EXCEPTION) ;
        }
        article.setPhoto(urlPhoto);
        return articleService.save(article);
    }
}
