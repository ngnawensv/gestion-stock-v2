package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.AuthenticationApi;
import cm.belrose.stockserveur.dto.auth.AuthenticationRequest;
import cm.belrose.stockserveur.dto.auth.AuthenticationResponse;
import cm.belrose.stockserveur.model.auth.ExtendedUser;
import cm.belrose.stockserveur.service.auth.UserDetailsServiceImpl;
import cm.belrose.stockserveur.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

//@CrossOrigin(origins = "*", maxAge = 3600) centralisation dans  securityConfiguration
@RestController
@Slf4j
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
        final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(request.getLogin());
        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);
        log.info("Token is successful generate......................");
        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }
}
