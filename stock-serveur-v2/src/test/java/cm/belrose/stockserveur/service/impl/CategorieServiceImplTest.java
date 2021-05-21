package cm.belrose.stockserveur.service.impl;
import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.service.CategorieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategorieServiceImplTest {

    @Autowired
    private CategorieService categorieService;



    //Test de la methode save d'une categorie dans le cas optimal c-à-d quand tout se passe bien
    @Test
    public  void shouldSaveCategorieOnServiceWithSuccess(){
        //Creation d'un objet CategorieDto(expectedCategorie<=>Objet attendu)
        CategorieDto expectedCategorie=CategorieDto.builder()
                .code("code_cat1")
                .libelle("libelle_cat1")
                .entrepriseId(1L)
                .build();

        //Enregistre de l'objet precedement crée
        CategorieDto saveCategorie=categorieService.save(expectedCategorie);

        //Définition des assertions
        assertNotNull(saveCategorie);
        assertNotNull(saveCategorie.getId());
        assertNotNull(saveCategorie.getCode());
        assertEquals(expectedCategorie.getCode(),saveCategorie.getCode());
        assertEquals(expectedCategorie.getLibelle(),saveCategorie.getLibelle());
        assertEquals(expectedCategorie.getEntrepriseId(),saveCategorie.getEntrepriseId());
    }

    //Test de la methode findById d'une categorie dans le cas optimal c-à-d quand tout se passe bien
    @Test
    public  void shouldFindCategorieByIdOnServiceWithSuccess(){
        //Creation d'un objet CategorieDto(expectedCategorie<=>Objet attendu)
        CategorieDto expectedCategorie=CategorieDto.builder()
                .code("code_cat2")
                .libelle("libelle_cate2")
                .entrepriseId(1L)
                .build();

        //Enregistre de l'objet precedement crée
        CategorieDto saveCategorie=categorieService.save(expectedCategorie);
        //Rechercher une categorie suivant l'id
        CategorieDto foundCategorie=categorieService.findById(saveCategorie.getId());

        //Définition des assertions
        assertNotNull(foundCategorie);
        assertNotNull(foundCategorie.getId());
        assertNotNull(foundCategorie.getCode());
        assertEquals(expectedCategorie.getCode(),foundCategorie.getCode());
        assertEquals(expectedCategorie.getLibelle(),foundCategorie.getLibelle());
        assertEquals(expectedCategorie.getEntrepriseId(),foundCategorie.getEntrepriseId());
    }

    //Test de la methode findAll d'une categorie dans le cas optimal c-à-d quand tout se passe bien
    @Test
    public  void shouldFindAllCategorieOnServiceWithSuccess(){
        //Creation des objets CategorieDto(expectedCategorie<=>Objet attendu)
        CategorieDto expectedCategorie=CategorieDto.builder()
                .code("code_cat3")
                .libelle("libelle_cate3")
                .entrepriseId(1L)
                .build();
        CategorieDto expectedCategorie1=CategorieDto.builder()
                .code("code_cat3")
                .libelle("libelle_cate3")
                .entrepriseId(1L)
                .build();
        CategorieDto expectedCategorie2=CategorieDto.builder()
                .code("code_cat3")
                .libelle("libelle_cate3")
                .entrepriseId(1L)
                .build();

        List<CategorieDto> listOfExpectedCategorie= Arrays.asList(expectedCategorie,expectedCategorie1,expectedCategorie2);
        //Enregistre de l'objet precedement crée
        listOfExpectedCategorie.forEach(categorieDto -> categorieService.save(categorieDto));

        //Définition des assertions
        //assertEquals(3,listOfExpectedCategorie.size());
        assertNotNull(categorieService.findAll());
    }

    //Test de la methode update d'une categorie dans le cas optimal c-à-d quand tout se passe bien
    @Test
    public  void shouldUpdateCategorieOnServiceWithSuccess(){
        //Creation d'un objet CategorieDto(expectedCategorie<=>Objet attendu)
        CategorieDto expectedCategorie=CategorieDto.builder()
                .code("cat test")
                .libelle("libelle test")
                .entrepriseId(1L)
                .build();
        //Enregistre de l'objet precedement crée
        CategorieDto saveCategorie=categorieService.save(expectedCategorie);
        CategorieDto updateCategorie=saveCategorie;
        updateCategorie.setCode("cat update");
        saveCategorie=categorieService.save(updateCategorie);

        //Définition des assertions
        assertNotNull(updateCategorie);
        assertNotNull(updateCategorie.getId());
        assertEquals(updateCategorie.getCode(),saveCategorie.getCode());
        assertEquals(updateCategorie.getLibelle(),saveCategorie.getLibelle());
        assertEquals(updateCategorie.getEntrepriseId(),saveCategorie.getEntrepriseId());
    }

    @Test
    public void shouldDeleteCategorieByIdOnServiceWithSuccess(){
        CategorieDto expectedCategorie=CategorieDto.builder()
                .code("code_cat5")
                .libelle("libelle_cat5")
                .entrepriseId(1L)
                .build();
        CategorieDto saveCategorie=categorieService.save(expectedCategorie);
        categorieService.delete(saveCategorie.getId());
    }

    @Test
    public  void shouldThrowInvalidEntityException(){
        //Creation d'un objet CategorieDto vide
        CategorieDto expectedCategorie=CategorieDto.builder().build();
        InvalidEntityException expectedException=assertThrows(InvalidEntityException.class,()->categorieService.save(expectedCategorie));
        assertEquals(ErrorCodes.CATEGORY_NOT_VALID,expectedException.getErrorCodes());
        assertEquals(1,expectedException.getErrors().size());
        assertEquals("Veuillez renseigner le code de la catagorie",expectedException.getErrors().get(0));
    }

    @Test
    public  void shouldThrowEntityNotFoundException(){
        EntityNotFoundException expectedException=assertThrows(EntityNotFoundException.class,()->categorieService.findById(0l));
        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND,expectedException.getErrorCodes());
        assertEquals("Aucun categorie avec l'ID=0 n'a été trouvé dans la BD",expectedException.getMessage());
    }


}