package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.dto.LigneVenteDto;
import cm.belrose.stockserveur.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Long> {
    List<LigneVente>findAllByArticleId(Long idArticle);
}
