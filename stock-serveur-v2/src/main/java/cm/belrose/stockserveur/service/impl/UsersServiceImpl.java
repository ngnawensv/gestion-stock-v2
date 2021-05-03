package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.UsersDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.repository.UsersRepository;
import cm.belrose.stockserveur.service.UsersService;
import cm.belrose.stockserveur.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Le 08/11/2020
 * @author Ngnawen Samuel
 */
@Service
@Transactional
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UsersDto save(UsersDto dto) {
        List<String> errors= UserValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Utilisateur non valide {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_VALID, errors);
        }
        return UsersDto.fromEntity(usersRepository.save(UsersDto.toEntity(dto)));
    }

    @Override
    public UsersDto findById(Long id) {
        if(id==null){
            log.error("Client ID is null");
            return null;
        }

        return usersRepository.findById(id)
                .map(UsersDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucun utilisateur avec l'id= "+id+" n'a été trouvé dans la BD",
                                ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public UsersDto findUsersByUsername(String username) {
        return usersRepository.findUsersByUsername(username)
                .map(UsersDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucun utilisateur avec le username= "+username+" n'a été trouvé dans la BD",
                                ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public UsersDto findUsersByEmail(String email) {
        return usersRepository.findUsersByEmail(email)
                .map(UsersDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Aucun utilisateur avec l'email= "+email+" n'a été trouvé dans la BD",
                                ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<UsersDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }



    /*@Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;*/

  /*  private static String currentUser=null;*/
    /*@Override
    public void save(Users user) {
        userRepository.save(user);
    }*/

    /*@Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }
*/
    /*@Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }
*/
    /*@Override
    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
*/
    /*@Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
*/
    /*@Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
*/
    /*@Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        currentUser=userDetails.getUsername();
        //System.out.println("userDetails.getUsername()+++> : " + userDetails.getUsername());
        return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
    }*/
/*
    @Override
    public MessageResponse registerUser(SignupRequest signUpRequest) {
        // Create new user's account
        Users user = new Users(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),null);
        Set<String> strRoles = signUpRequest.getRole();
        Set<Roles> roles = new HashSet<>();
        if (strRoles == null) {
            Roles userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Roles is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Roles adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Roles is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Roles modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Roles is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Roles userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Roles is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponse("Users registered successfully!");
    }
*/
}
