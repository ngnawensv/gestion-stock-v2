package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CommandeClientDto;
import cm.belrose.stockserveur.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {



    public static List<String> validator(CommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande du fournisseur");
            errors.add("Veuillez selectionner le fournisseur");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande du fournisseur");
        }

        if (dto.getFournisseur()== null) {
            errors.add("Veuillez selectionner le fournisseur");
        }else{
            if (!StringUtils.hasLength(dto.getFournisseur().getNom())) {
                errors.add("Veuillez renseigner le sexe du fournisseur");
            }
        }
        return  errors;
    }
}
