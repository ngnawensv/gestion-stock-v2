package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.SousCategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SousCategorieValidator {
    public static List<String> validator(SousCategorieDto dto){
        List<String> errors=new ArrayList<>();
        if(dto==null){
            errors.add("Veuillez renseigner le code de la sous catagorie");
            errors.add("Veuillez renseigner le libellé de la sous catagorie");
            errors.add("Veuillez renseigner la catagorie");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez renseigner le code de la sous catagorie");
        }
        if(!StringUtils.hasLength(dto.getLibelle())){
            errors.add("Veuillez renseigner le libellé de la sous catagorie");
        }
        if(dto.getCategorie()==null){
            errors.add("Veuillez renseigner la catagorie");
        }
        return errors;
    }
}
