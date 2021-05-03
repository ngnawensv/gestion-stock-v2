package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.CommandeClient;
import cm.belrose.stockserveur.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VenteRepository extends JpaRepository<Vente,Long> {

    Optional<Vente> findVenteByCode(String code);
}
