package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementStock,Long> {
    @Query("select sum(m.quantite) from MouvementStock m where m.article.id=:idArticle")
    BigDecimal stockReelArticle(@Param("idArticle") Long idArticle);
    List<MouvementStock> findAllByArticleId(Long idArticle);

}
