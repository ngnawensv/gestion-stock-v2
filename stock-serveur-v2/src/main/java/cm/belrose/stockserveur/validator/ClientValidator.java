package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {


    public static List<String> validator(ClientDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner l'email du client");
            errors.add("Veuillez renseigner le sexe du client");
            errors.add("Veuillez renseigner le numéro de telephone du client");
            errors.add("Veuillez renseigner l'adresse du client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du client");
        }

        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Veuillez renseigner l'email du client");
        }

        if (!StringUtils.hasLength(dto.getGenre())) {
            errors.add("Veuillez renseigner le sexe du client");
        }

        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("Veuillez renseigner le numéro de telephone du client");
        }

        if(dto.getAdresse()==null){
            errors.add("Veuillez renseigner l'adresse du client");
        }else{
            if(!StringUtils.hasLength(dto.getAdresse().getRue())){
                errors.add("Le champs rue du client");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getCodePostale())){
                errors.add("Le champs code postale du client");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getVille())){
                errors.add("Le champs ville du client");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getPays())){
                errors.add("Le champs pays du client");
            }

        }

        return  errors;
    }
}
