package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validator(EntrepriseDto dto){
        List<String> errors=new ArrayList<>();
        if(dto==null||!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le code de l'entreprise");
        }
        return errors;
    }
}
