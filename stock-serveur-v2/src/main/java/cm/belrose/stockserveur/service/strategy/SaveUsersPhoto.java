package cm.belrose.stockserveur.service.strategy;

import cm.belrose.stockserveur.dto.UsersDto;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.Users;
import cm.belrose.stockserveur.service.ArticleService;
import cm.belrose.stockserveur.service.FlickrService;
import cm.belrose.stockserveur.service.UsersService;
import com.flickr4java.flickr.FlickrException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("usersStrategy")
@Slf4j
public class SaveUsersPhoto implements Strategy<UsersDto> {
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private UsersService usersService;

    @Override
    public UsersDto savePhoto(Long id,InputStream photo, String titre) throws FlickrException {
        UsersDto user=usersService.findById(id);
        String urlPhoto=flickrService.savePhotos(photo,titre);
        if(!StringUtils.hasLength(urlPhoto)){
            throw new InvalidOperationException("Erreur d'enregistrement de la photo de l'utilisateur",
                    ErrorCodes.UPDATE_PHOTO_EXCEPTION) ;
        }
        user.setPhoto(urlPhoto);
        return usersService.save(user);
    }
}
