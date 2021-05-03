package cm.belrose.stockserveur.config.flickr;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.auth.Auth;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.apis.FlickrApi.FlickrPerm;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Cette classe permet juste de configurer l'API Flickr afin de générant le apiKey et le apiSecret
 */
//@Configuration
public class FlickrConfiguration {

    @Value("${flickr.apiKey}")
    private  String apiKey;
    @Value("${flickr.apiSecret}")
    private  String apiSecret;

   // @Bean
    public Flickr getFlick() throws InterruptedException, ExecutionException, IOException, FlickrException {
        //Creation d'un objet de type Flickr
        Flickr flickr=new Flickr(apiKey,apiSecret,new REST());

        //Creation d'un objet de type OAuth10aService avec la permission voulue pour mon application
        OAuth10aService service=new ServiceBuilder(apiKey)
                .apiSecret(apiSecret)
                .build(FlickrApi.instance(FlickrPerm.DELETE));

        final Scanner scanner=new Scanner(System.in);

        final OAuth1RequestToken request= service.getRequestToken();

        final String authUrl=service.getAuthorizationUrl(request);
        System.out.println("authorizationUrl : "+authUrl);
        System.out.println("Paste it here >> ");

        final String authVerifier=scanner.nextLine();

        OAuth1AccessToken accesToken=service.getAccessToken(request,authVerifier);
        System.out.println("AccesToken : "+accesToken.getToken());
        System.out.println("TokenSecret: "+accesToken.getTokenSecret());

        Auth auth=flickr.getAuthInterface().checkToken(accesToken);

        System.out.println("================================================");
        System.out.println("Token : "+auth.getToken());
        System.out.println("TokenSecret : "+auth.getTokenSecret());

        return flickr;

    }
}
