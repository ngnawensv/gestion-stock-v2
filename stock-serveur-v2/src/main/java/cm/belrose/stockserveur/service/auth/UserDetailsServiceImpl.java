package cm.belrose.stockserveur.service.auth;

import cm.belrose.stockserveur.dto.UsersDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.model.Users;
import cm.belrose.stockserveur.model.auth.ExtendedUser;
import cm.belrose.stockserveur.repository.UsersRepository;
import cm.belrose.stockserveur.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user= usersRepository.findUsersByEmail(email).get();

        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().name())));

        return new ExtendedUser(user.getEmail(),user.getPassword(),user.getEntreprise().getId(), authorities);
    }
}
