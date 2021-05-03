package cm.belrose.stockserveur.config.audit;


import cm.belrose.stockserveur.model.auth.ExtendedUser;
import cm.belrose.stockserveur.service.auth.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.file.attribute.UserPrincipal;
import java.util.Optional;
/**
 * @author Ngnawen Samuel
 * @since 17/11/2020 18:20
 *
 * This class is use to pull the authenticate user with spring security context
 *
 */
@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return Optional.ofNullable("Super Admin");
        }

       ExtendedUser userPrincipal = (ExtendedUser) authentication.getPrincipal();
        log.info("Extended user "+userPrincipal.getUsername());
        //UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getUsername());
    }
}
