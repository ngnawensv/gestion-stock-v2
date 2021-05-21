package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.PhotoApi;
import cm.belrose.stockserveur.service.strategy.StrategyPhotoContext;
import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class PhotoController implements PhotoApi {

    @Autowired
    private StrategyPhotoContext strategyPhotoContext;
    @Override
    public Object savePhoto(String context, Long id, MultipartFile photo, String title) throws IOException, FlickrException {
        return strategyPhotoContext.savePhoto(context,id,photo.getInputStream(),title);
    }
}
