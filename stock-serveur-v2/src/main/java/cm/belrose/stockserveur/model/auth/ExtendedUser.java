package cm.belrose.stockserveur.model.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class ExtendedUser extends User {
    @Getter
    @Setter
    private Long entrepriseId;

    public ExtendedUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public ExtendedUser(String username, String password,Long entrepriseId, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.entrepriseId=entrepriseId;
    }
}
