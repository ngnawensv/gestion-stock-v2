package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Long> {
    List<LigneCommandeClient> findAllByCommandeClientId(Long idCommande);

    List<LigneCommandeClient> findAllByArticleId(Long idArticle);
}
