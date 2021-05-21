package cm.belrose.stockserveur.service.strategy;

import cm.belrose.stockserveur.dto.FournisseurDto;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidOperationException;
import cm.belrose.stockserveur.model.Fournisseur;
import cm.belrose.stockserveur.service.FlickrService;
import cm.belrose.stockserveur.service.FournisseurService;
import com.flickr4java.flickr.FlickrException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("fournisseurStrategy")
@Slf4j
public class SaveFournisseurPhoto implements Strategy<FournisseurDto> {

    @Autowired
    private FlickrService flickrService;
    @Autowired
    private FournisseurService fournisseurService;

    @Override
    public FournisseurDto savePhoto(Long id, InputStream photo, String titre) throws FlickrException {
        FournisseurDto fournisseur=fournisseurService.findById(id);
        String urlPhoto=flickrService.savePhotos(photo,titre);
        if(!StringUtils.hasLength(urlPhoto)){
            throw new InvalidOperationException("Erreur d'enregistrement de la photo du fournisseur",
                    ErrorCodes.UPDATE_PHOTO_EXCEPTION) ;
        }
        fournisseur.setPhoto(urlPhoto);
        return fournisseurService.save(fournisseur);
    }
}
