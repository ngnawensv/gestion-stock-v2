package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *@author  Ngnawen Samuel
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUsersByUsername(String username);

    Optional<Users> findUsersByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
