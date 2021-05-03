package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.LigneVenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {


    public static List<String> validator(LigneVenteDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez selectionner la vente");
            errors.add("Veuillez renseigner le prix unitaire de la ligne de vente");
            return errors;
        }

        if (dto.getArticle()==null) {
            errors.add("Veuillez selectionner l'article ");
        }else{
            if (!StringUtils.hasLength(dto.getArticle().getCode())) {
                errors.add("Le champs code est obligatoire");
            }
            if (!StringUtils.hasLength(dto.getArticle().getDesignation())) {
                errors.add("Le champs designation est obligatoire");
            }
        }

        if (dto.getVente()==null) {
            errors.add("Veuillez selectionner la vente");
        }else{
            if (!StringUtils.hasLength(dto.getVente().getCode())) {
                errors.add("Le champs code est obligatoire");
            }
        }

        if (dto.getPrixUniataire()==null) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne de vente");
        }

        if (dto.getQuantite()==null) {
            errors.add("Veuillez renseigner la quantité de la ligne de vente");
        }
        return  errors;
    }
}
