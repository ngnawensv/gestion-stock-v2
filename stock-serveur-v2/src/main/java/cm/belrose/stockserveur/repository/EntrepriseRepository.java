package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
    Optional<Entreprise> findEntrepriseByNom(String nom);
}
