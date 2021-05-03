package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class LigneCommandeFournisseurDto {
    private Long id;
    private ArticleDto article;
    private CommandeFournisseurDto commandeFournisseur;
    private Long entrepriseId;


    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return LigneCommandeFournisseurDto.builder()
                .id(entity.getId())
                .entrepriseId(entity.getEntrepriseId())
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .commandeFournisseur(CommandeFournisseurDto.fromEntity(entity.getCommandeFournisseur()))
                .build();

    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        LigneCommandeFournisseur ligneCommandeFournisseur=new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(dto.getId());
        ligneCommandeFournisseur.setEntrepriseId(dto.getEntrepriseId());
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneCommandeFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntity(dto.getCommandeFournisseur()));
        return ligneCommandeFournisseur;

    }
}
