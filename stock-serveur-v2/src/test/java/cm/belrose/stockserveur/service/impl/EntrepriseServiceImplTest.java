package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.AdresseDto;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.repository.EntrepriseRepository;
import cm.belrose.stockserveur.service.EntrepriseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith( SpringExtension.class )
@SpringBootTest
class EntrepriseServiceImplTest {

    @Autowired
    private EntrepriseService entrepriseService;

    @Test
    public void shouldSaveEntrepriseWithSuccess(){
        AdresseDto adresseDto=AdresseDto.builder()
                .adresse1("Adresse")
                .adresse2("Adresse 2")
                .codePostale("Code postale")
                .pays("Pays")
                .ville("Ville")
                .build();
        EntrepriseDto expectedEntreprise=EntrepriseDto.builder()
                .codeFiscal("code_entr1")
                .nom("nom_entr1")
                .email("email_entr1")
                .logo("logo_entr1")
                .adresse(adresseDto)
                .build();

        EntrepriseDto saveEntreprise=entrepriseService.save(expectedEntreprise);
        assertNotNull(saveEntreprise);
        assertNotNull(saveEntreprise.getId());
        assertNotNull(saveEntreprise.getCodeFiscal());
        assertNotNull(saveEntreprise.getNom());
        assertEquals(expectedEntreprise.getCodeFiscal(),saveEntreprise.getCodeFiscal());
        assertEquals(expectedEntreprise.getNom(),saveEntreprise.getNom());
        assertEquals(expectedEntreprise.getEmail(),saveEntreprise.getEmail());
        assertEquals(expectedEntreprise.getLogo(),saveEntreprise.getLogo());
        assertEquals(expectedEntreprise.getAdresse(),saveEntreprise.getAdresse());

    }

    @Test
    public  void shouldThrowEntityNotFoundException(){
        EntityNotFoundException expectedException=assertThrows(EntityNotFoundException.class,()->entrepriseService.findById(0l));
        assertEquals(ErrorCodes.ENTREPRISE_NOT_FOUND,expectedException.getErrorCodes());
        assertEquals("Aucune entreprise avec l'ID = 0 n'a été trouvé dans la BD",expectedException.getMessage());
    }
}