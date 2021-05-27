package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.auth.AuthenticationRequest;
import cm.belrose.stockserveur.dto.auth.AuthenticationResponse;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static cm.belrose.stockserveur.config.constants.Constant.AUTHENTICATION_ENDPOINT;

@Api(AUTHENTICATION_ENDPOINT)
public interface AuthenticationApi {
    @PostMapping(AUTHENTICATION_ENDPOINT)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws Exception;

}
