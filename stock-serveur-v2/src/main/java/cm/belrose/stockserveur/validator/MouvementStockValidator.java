package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.LigneVenteDto;
import cm.belrose.stockserveur.dto.MouvementStockDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MouvementStockValidator {


    public static List<String> validator(MouvementStockDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez renseigner la quantité dans le mouvement de stock");
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

        if (dto.getQuantite()==null) {
            errors.add("Veuillez renseigner la quantité dans le mouvement de stock");
        }
        return  errors;
    }

}
