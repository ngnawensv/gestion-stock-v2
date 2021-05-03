package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.Categorie;
import cm.belrose.stockserveur.model.Entreprise;
import lombok.*;

import java.math.BigDecimal;
@Builder
@Data
public class ArticleDto {
    private Long id;
    private String code;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private BigDecimal prixAchat;
    private BigDecimal prixVente;
    private double quantite;
    private String photo;
    private CategorieDto categorieDto;
    private Long entrepriseId;


    //Construction d'un objet de type ArticleDto à partir de l'entité Article (Article==>ArticleDto)
    public static ArticleDto fromEntity(Article entity){
        if(entity==null){
            return null;
        }
        return ArticleDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .designation(entity.getDesignation())
                .prixAchat(entity.getPrixAchat())
                .prixUnitaireHt(entity.getPrixUnitaireHt())
                .prixUnitaireTtc(entity.getPrixUnitaireTtc())
                .prixVente(entity.getPrixVente())
                .tauxTva(entity.getTauxTva())
                .quantite(entity.getQuantite())
                .entrepriseId(entity.getEntrepriseId())
                .photo(entity.getPhoto())
                .categorieDto(CategorieDto.fromEntity(entity.getCategorie()))
                .build();

    }


    //Construction d'un objet de type Article à partir d'un dto (ArticleDto==>Article)
    public static Article toEntity(ArticleDto dto){
        if(dto==null){
            return null;
        }
        Article article=new Article();
        article.setId(dto.getId());
        article.setDesignation(dto.getDesignation());
        article.setPrixAchat(dto.getPrixAchat());
        article.setQuantite(dto.getQuantite());
        article.setPrixVente(dto.getPrixVente());
        article.setCode(dto.getCode());
        article.setPrixUnitaireHt(dto.getPrixUnitaireHt());
        article.setTauxTva(dto.getTauxTva());
        article.setEntrepriseId(dto.getEntrepriseId());
        article.setPrixUnitaireTtc(dto.getPrixUnitaireTtc());
        article.setCategorie(CategorieDto.toEntity(dto.getCategorieDto()));
        return article;

    }
}
