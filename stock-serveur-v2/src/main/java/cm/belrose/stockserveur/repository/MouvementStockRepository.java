package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementStock,Long> {
}
