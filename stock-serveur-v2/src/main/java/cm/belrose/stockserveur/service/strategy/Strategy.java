package cm.belrose.stockserveur.service.strategy;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface Strategy<T> { //On utilise un type générique car après enregistrement d'un objet on le retourne
    T savePhoto(Long id, InputStream photo, String titre) throws FlickrException;
}
