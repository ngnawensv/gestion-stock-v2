package cm.belrose.stockserveur.validator;

import cm.belrose.stockserveur.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validator(ArticleDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la designation de l'article");
            errors.add("Veuillez renseigner le prix d'achat de l'article");
            errors.add("Veuillez renseigner le prix unitaire HT de l'article");
            errors.add("Veuillez renseigner la TVA de l'article");
            errors.add("Veuillez renseigner le prix de vente  de l'article");
            errors.add("Veuillez selectionner une categorie");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de l'article");
        }

        if (!StringUtils.hasLength(dto.getDesignation())) {
            errors.add("Veuillez renseigner la designation de l'article");
        }

        if (dto.getPrixAchat() == null) {
            errors.add("Veuillez renseigner le prix d'achat de l'article");
        }

        if (dto.getPrixUnitaireHt() == null) {
            errors.add("Veuillez renseigner le prix unitaire HT de l'article");
        }

        if (dto.getTauxTva() == null) {
            errors.add("Veuillez renseigner la TVA de l'article");
        }

        if (dto.getPrixVente() == null) {
            errors.add("Veuillez renseigner lep rix de vente  de l'article");
        }

        if (dto.getCategorieDto() == null) {
            errors.add("Veuillez selectionner une categorie");
        }
        return  errors;
    }
}
