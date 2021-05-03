package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.SousCategorie;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SousCategorieDto {
    private Long id;
    private String code;
    private String libelle;
    private CategorieDto categorie;
    private Long entrepriseId;


    public static SousCategorieDto fromEntity(SousCategorie entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return SousCategorieDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .libelle(entity.getLibelle())
                .entrepriseId(entity.getEntrepriseId())
                .categorie(CategorieDto.fromEntity(entity.getCategorie()))
                .build();

    }

    public static SousCategorie toEntity(SousCategorieDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        SousCategorie sousCategorie=new SousCategorie();
        sousCategorie.setId(dto.getId());
        sousCategorie.setCode(dto.getCode());
        sousCategorie.setLibelle(dto.getLibelle());
        sousCategorie.setEntrepriseId(dto.getEntrepriseId());
        sousCategorie.setCategorie(CategorieDto.toEntity(dto.getCategorie()));
        return sousCategorie;

    }
}
