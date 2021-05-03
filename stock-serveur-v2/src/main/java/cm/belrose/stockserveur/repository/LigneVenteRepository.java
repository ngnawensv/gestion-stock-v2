package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Long> {
}
