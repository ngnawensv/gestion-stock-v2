package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ngnawen
 * @since 07/03/2021
 * Cette classe permet de valider une entité avant sa persistence dans une base de données.
 * La validation concerne principalement les champs obligatoires
 *
 */
public class CategorieValidator {

    public static List<String> validator(CategorieDto dto){
        List<String> errors=new ArrayList<>();
        if(dto==null||!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez renseigner le code de la catagorie");
        }
        return errors;
    }
}
