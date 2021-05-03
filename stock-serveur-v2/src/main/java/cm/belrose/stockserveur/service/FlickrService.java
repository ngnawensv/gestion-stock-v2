package cm.belrose.stockserveur.service;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrService {
    String savePhotos (InputStream photo, String title) throws FlickrException;
}
