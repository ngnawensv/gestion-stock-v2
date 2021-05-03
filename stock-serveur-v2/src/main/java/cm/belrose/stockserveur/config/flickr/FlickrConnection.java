package cm.belrose.stockserveur.config.flickr;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cette classe de configuration permet de gerer la connexion à flickr
 */
@Configuration
@Slf4j
public class FlickrConnection {
    @Value("${flickr.apiKey}")
    private  String apiKey;
    @Value("${flickr.apiSecret}")
    private  String apiSecret;
    @Value("${flickr.appKey}")
    private  String appKey;
    @Value("${flickr.appSecret}")
    private  String appSecret;

    @Bean
    public Flickr getFlickr(){
       Flickr flickr=new Flickr(apiKey,apiSecret,new REST());

        Auth auth=new Auth();

        auth.setPermission(Permission.DELETE);

        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);

        RequestContext requestContext=RequestContext.getRequestContext();
        requestContext.setAuth(auth);

        flickr.setAuth(auth);
        log.info("Succès de conexion à flickr........");
        return  flickr;
    }
}
