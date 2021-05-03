package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validator(FournisseurDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom du fournisseur");
            errors.add("Veuillez renseigner l'email du fournisseur");
            errors.add("Veuillez renseigner le sexe du fournisseur");
            errors.add("Veuillez renseigner le numéro de telephone du fournisseur");
            errors.add("Veuillez renseigner l'adresse du fournisseur");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du fournisseur");
        }

        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Veuillez renseigner l'email du fournisseur");
        }

        if (!StringUtils.hasLength(dto.getGenre())) {
            errors.add("Veuillez renseigner le sexe du fournisseur");
        }

        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("Veuillez renseigner le numéro de telephone du fournisseur");
        }

        if(dto.getAdresse()==null){
            errors.add("Veuillez renseigner l'adresse du fournisseur");
        }else{
            if(!StringUtils.hasLength(dto.getAdresse().getAdresse1())){
                errors.add("Le champs adresse 1 du fournisseur");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getCodePostale())){
                errors.add("Le champs code postale du fournisseur");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getVille())){
                errors.add("Le champs ville du fournisseur");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getPays())){
                errors.add("Le champs pays du fournisseur");
            }

        }

        return  errors;
    }
}
