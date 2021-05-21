package cm.belrose.stockserveur.config.initializer;

import cm.belrose.stockserveur.config.constants.Constant;
import cm.belrose.stockserveur.model.*;
import cm.belrose.stockserveur.repository.CategorieRepository;
import cm.belrose.stockserveur.repository.EntrepriseRepository;
import cm.belrose.stockserveur.repository.RolesRepository;
import cm.belrose.stockserveur.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;


/**
 * Le 16/11/2020 à 09heures
 *
 * @author Ngnawen Samuel
 * <p>
 * Cette classe permet de créer le super utilisateur au demarrage de l'application avec ses roles
 */
@Component
@Slf4j
public class InitializeDataBase implements CommandLineRunner {

    //private static final Logger logger = LoggerFactory.getLogger(InitializeDataBase.class);

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //Creation of default Entreprise...
        Optional<Entreprise> default_entreprise = entrepriseRepository.findEntrepriseByNom(Constant.DEFAULT_ENTREPRISE);
        Entreprise entreprise = new Entreprise();
        if (default_entreprise.isEmpty()) {
            entreprise = new Entreprise(1l, Constant.DEFAULT_ENTREPRISE, null,null,null,null,null,null,null,null);
            entrepriseRepository.save(entreprise);
            log.info("Default entreprise is successful save......");
        } else {
            log.info("Default entreprise already exist....");

        }

        //Creation of default User with there roles.....
        Optional<Roles> role = rolesRepository.findByName(RoleEnum.ROLE_ADMIN);
        if (role.isEmpty()) {
            Set<Roles> rolesList = new HashSet<>(Arrays.asList(
                    new Roles(RoleEnum.ROLE_ADMIN),
                    new Roles(RoleEnum.ROLE_MODERATOR),
                    new Roles(RoleEnum.ROLE_USER)));
            if (!CollectionUtils.isEmpty(rolesList)) {
                rolesRepository.saveAll(rolesList);
                log.info("All roles successful save !!!!");
            } else {
                log.info("List of roles is empty !!!!");
            }
            Users user = new Users(
                    Constant.DEFAULT_ADMIN_USERNAME,
                    Constant.DEFAULT_ADMIN_EMAIL,
                    passwordEncoder.encode(Constant.DEFAULT_ADMIN_PASSWORD),
                    entreprise, rolesList);
            usersRepository.save(user);
            log.info("Super user successful create!!!!");
        } else {
            log.info("Super user is already exist!!!!");
        }

        // Creation of default category ........
        Optional<Categorie> default_categorie = categorieRepository.findCategorieByCode(Constant.DEFAULT_CATEGORIE_CODE);
        if (!default_categorie.isPresent()) {
            Categorie defaultCategorie = new Categorie(1l, Constant.DEFAULT_CATEGORIE_CODE, "Default categorie", 1l);
            categorieRepository.save(defaultCategorie);
            log.info("Default category is successful create!!!!");
        } else {
            log.info("Default category is already exist!!!!");
        }


    }
}
