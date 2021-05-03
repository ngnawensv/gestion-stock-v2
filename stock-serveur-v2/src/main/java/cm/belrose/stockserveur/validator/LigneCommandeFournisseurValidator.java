package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validator(LigneCommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez selectionner la commande du fournisseur");
            return errors;
        }

        if (dto.getArticle()==null) {
            errors.add("Veuillez selectionner l'article");
        }else{
            if (!StringUtils.hasLength(dto.getArticle().getCode())) {
                errors.add("Le champs code est obligatoire");
            }
            if (!StringUtils.hasLength(dto.getArticle().getDesignation())) {
                errors.add("Le champs designation est obligatoire");
            }
        }

        if (dto.getCommandeFournisseur()== null) {
            errors.add("Veuillez selectionner la commande du fournisseur");
        }else{
            if (!StringUtils.hasLength(dto.getCommandeFournisseur().getCode())) {
                errors.add("Veuillez renseigner le code de la commande du fournisseur");
            }
        }
        return  errors;
    }
}
