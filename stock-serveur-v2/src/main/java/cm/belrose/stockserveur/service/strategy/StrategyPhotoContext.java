package cm.belrose.stockserveur.service.strategy;

import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.service.ArticleService;
import com.flickr4java.flickr.FlickrException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service
public class StrategyPhotoContext {
    @Autowired
    private BeanFactory beanFactory;//determine la classe à injectée
    private Strategy strategy;
    @Setter
    private String context;

    public  Object savePhoto(String context, Long id, InputStream photo, String title) throws FlickrException {
        determineContext(context);
        return strategy.savePhoto(id,photo,title);
    }

    public void determineContext(String context) {
        final String beanName=context+"Strategy";
        switch(context){
            case "article":
                strategy=beanFactory.getBean(beanName, SaveArticlePhoto.class);
                break;
            case "client":
                strategy=beanFactory.getBean(beanName, SaveClientPhoto.class);
                break;
            case "entreprise":
                strategy=beanFactory.getBean(beanName, SaveEntreprisePhoto.class);
                break;
            case "fournisseur":
                strategy=beanFactory.getBean(beanName, SaveFournisseurPhoto.class);
                break;
            case "user":
                strategy=beanFactory.getBean(beanName, SaveUsersPhoto.class);
                break;
                default: throw new InvalidOperationException("Context Inconnue pour l'enregistrement de la photo",
                        ErrorCodes.UNKNOWN_CONTEXT);

        }
    }
}
