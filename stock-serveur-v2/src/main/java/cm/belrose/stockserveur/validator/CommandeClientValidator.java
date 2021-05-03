package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validator(CommandeClientDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande du client");
            errors.add("Veuillez selectionner le client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande du client");
        }

        if (dto.getClient()== null) {
            errors.add("Veuillez selectionner le client");
        }else{
            if (!StringUtils.hasLength(dto.getClient().getNom())) {
                errors.add("Veuillez renseigner le sexe du client");
            }
        }
        return  errors;
    }
}
