package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Adresse;
import lombok.Builder;
import lombok.Data;


/**
 * @author Ngnawen
 * @since 05/03/2021
 * Cette classe contient principalement deux méthodes qui serviront à la persistence (toEntity())
 * et à la récupération(fromEntity()) des données
 *
 */

@Builder
@Data
public class AdresseDto {
    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostale;
    private String pays;

    /**
     * Cette méthode permet de faire le mapping de l'entité vers le dto
     * @param entity
     * @return
     */
    public static AdresseDto fromEntity(Adresse entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type AdresseDto (Adresse==>AdresseDto)
        return AdresseDto.builder()
                .adresse1(entity.getAdresse1())
                .adresse2(entity.getAdresse2())
                .codePostale(entity.getCodePostale())
                .ville(entity.getVille())
                .pays(entity.getPays())
                .build();

    }

    /**
     * Cette méthode permet de faire le mapping du dto vers l'entité
     * @param dto
     * @return
     */
    public static Adresse toEntity(AdresseDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Adresse (AdresseDto==>Adresse)
        Adresse adresse=new Adresse();
        adresse.setAdresse1(dto.getAdresse1());
        adresse.setAdresse2(dto.getAdresse2());
        adresse.setCodePostale(dto.getCodePostale());
        adresse.setPays(dto.getPays());
        adresse.setVille(dto.getVille());
        return adresse;

    }
}
