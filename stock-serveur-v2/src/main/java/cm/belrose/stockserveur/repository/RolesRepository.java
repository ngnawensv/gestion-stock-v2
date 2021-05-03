package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.RoleEnum;
import cm.belrose.stockserveur.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *@author  Ngnawen Samuel
 */

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(RoleEnum name);
}
