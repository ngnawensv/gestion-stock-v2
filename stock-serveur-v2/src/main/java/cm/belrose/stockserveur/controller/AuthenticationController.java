package cm.belrose.stockserveur.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@Slf4j
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request) throws Exception {
        log.info("Inside the authenticate method...........");
       // try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword()));
//        }catch (BadCredentialsException e){
//            throw new Exception("Incorrect username or password", e);
//        }

        final UserDetails userDetails=userDetailsServiceImpl.loadUserByUsername(request.getLogin());
        final String jwt=jwtUtil.generateToken((ExtendedUser)userDetails);
        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }
}
