package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.ChangerMotDePasseUserDto;
import cm.belrose.stockserveur.dto.UsersDto;

import java.util.List;

public interface UsersService {

    UsersDto save(UsersDto dto);

    UsersDto findById(Long id);

    List<UsersDto> findAll() ;

    void delete(Long id);

    UsersDto findUsersByUsername(String username);

    UsersDto findUsersByEmail(String email);

    UsersDto changerMotDePasse(ChangerMotDePasseUserDto dto);

    //void save(Users user);

   // Optional<Users> findById(Long id);

   // List<Users> findAll();

   // Optional<Users> findUserByUsername(String username);

    //Boolean existsByUsername(String username);

    //Boolean existsByEmail(String email);

     //JwtResponse authenticateUser(LoginRequest loginRequest);

   //  MessageResponse registerUser(SignupRequest signUpRequest);

}
