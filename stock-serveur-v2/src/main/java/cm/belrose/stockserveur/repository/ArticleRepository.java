package cm.belrose.stockserveur.repository;

import cm.belrose.stockserveur.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *@author  Ngnawen Samuel
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

    Optional<Article> findArticleByCode(String code);

    List<Article> findByDesignationContaining(String designation);

    List<Article> findAllByCategorieId(Long idCategorie);

}
