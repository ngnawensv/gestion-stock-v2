package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SousCategorieRepository extends JpaRepository<SousCategorie,Long> {
    Optional<SousCategorie> findSousCategorieByCode(String code);
}
