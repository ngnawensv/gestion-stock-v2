package cm.belrose.stockserveur.service.strategy;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.service.ClientService;
import cm.belrose.stockserveur.service.FlickrService;
import com.flickr4java.flickr.FlickrException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("clientStrategy")
@Slf4j
public class SaveClientPhoto implements Strategy<ClientDto> {
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private ClientService clientService;

    @Override
    public ClientDto savePhoto(Long id,InputStream photo, String titre) throws FlickrException {
        ClientDto client=clientService.findById(id);
        String urlPhoto=flickrService.savePhotos(photo,titre);
        if(!StringUtils.hasLength(urlPhoto)){
            throw new InvalidOperationException("Erreur d'enregistrement de la photo du client",
                    ErrorCodes.UPDATE_PHOTO_EXCEPTION) ;
        }
        client.setPhoto(urlPhoto);
        return clientService.save(client);
    }
}
