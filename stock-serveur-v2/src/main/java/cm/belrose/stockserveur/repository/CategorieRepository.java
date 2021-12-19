package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author Ngnawen Samuel
 *
 * @since  07/11/2020
 *
 * RevisionRepository<Categorie,Long,Long> allows 4 different methods to get versioning information
 * belongs to the Categorie entity class.
 *
 */

@Repository
public interface CategorieRepository  extends RevisionRepository<Categorie, Long, Long>, JpaRepository<Categorie, Long> {
    Optional<Categorie> findCategorieByCode(String code);
}
