package cm.belrose.stockserveur.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class CategorieRepositoryTest {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldSaveCategorieOnRepositoryWithSuccess() {
        /*Categorie expectedCategorie = Categorie.builder()
                .id(10l)
                .code("code_cat_repo1")
                .libelle("libelle_cat_repo1")
                .entrepriseId(1l)
                .build();

        entityManager.persist(expectedCategorie);
        entityManager.flush();

        Categorie saveCategorie = categorieRepository.save(expectedCategorie);
        assertNull(saveCategorie.getCreatedBy());
        assertNull(saveCategorie.getUpdateDate());
        assertNull(saveCategorie.getCreatedDate());
        assertNull(saveCategorie.getUpdateDate());
        assertNotNull(saveCategorie);
        assertNotNull(saveCategorie.getEntrepriseId());
        assertNotNull(saveCategorie.getCode());
        assertEquals(expectedCategorie.getCode(), saveCategorie.getCode());
        assertEquals(expectedCategorie.getLibelle(), saveCategorie.getLibelle());
        assertEquals(expectedCategorie.getEntrepriseId(), saveCategorie.getEntrepriseId());*/
    }

}
