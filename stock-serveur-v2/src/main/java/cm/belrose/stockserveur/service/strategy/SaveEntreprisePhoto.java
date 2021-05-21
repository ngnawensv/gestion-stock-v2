package cm.belrose.stockserveur.service.strategy;

import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.service.EntrepriseService;
import cm.belrose.stockserveur.service.FlickrService;
import com.flickr4java.flickr.FlickrException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("entrepriseStrategy")
@Slf4j
public class SaveEntreprisePhoto implements Strategy<EntrepriseDto> {
    @Autowired
    private FlickrService flickrService;
    @Autowired
    private EntrepriseService entrepriseService;
    @Override
    public EntrepriseDto savePhoto(Long id,InputStream photo, String titre) throws FlickrException {
        EntrepriseDto entreprise=entrepriseService.findById(id);
        String urlPhoto=flickrService.savePhotos(photo,titre);
        if(!StringUtils.hasLength(urlPhoto)){
            throw new InvalidOperationException("Erreur d'enregistrement du logo de l'entreprise",
                    ErrorCodes.UPDATE_PHOTO_EXCEPTION) ;
        }
        entreprise.setLogo(urlPhoto);
        return entrepriseService.save(entreprise);
    }
}
