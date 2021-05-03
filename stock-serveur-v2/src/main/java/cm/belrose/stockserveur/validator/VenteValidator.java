package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validator(VenteDto dto){
        List<String> errors=new ArrayList<>();
        if(dto==null||!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez renseigner le code de la vente");
        }
        return errors;
    }
}
