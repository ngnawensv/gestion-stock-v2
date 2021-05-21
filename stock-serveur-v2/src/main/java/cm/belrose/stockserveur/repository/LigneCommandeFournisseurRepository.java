package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Long> {
    List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(Long idCommande);

    List<LigneCommandeFournisseur> findAllByArticleId(Long idArticle);
}
