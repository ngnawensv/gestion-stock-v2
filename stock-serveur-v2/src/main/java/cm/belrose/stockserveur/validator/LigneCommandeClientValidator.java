package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {


    public static List<String> validator(LigneCommandeClientDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez selectionner la commande du client");
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

        if (dto.getCommandeClient()== null) {
            errors.add("Veuillez selectionner la commande du client");
        }else{
            if (!StringUtils.hasLength(dto.getCommandeClient().getCode())) {
                errors.add("Veuillez renseigner le code de la commande du client");
            }
        }
        return  errors;
    }
}
