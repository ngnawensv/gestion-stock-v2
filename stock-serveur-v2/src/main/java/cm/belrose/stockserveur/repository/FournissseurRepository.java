package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournissseurRepository extends JpaRepository<Fournisseur,Long> {
}
