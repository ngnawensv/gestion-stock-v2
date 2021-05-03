package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.LigneVente;
import cm.belrose.stockserveur.model.Vente;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private Long id;
    private ArticleDto article;
    private VenteDto vente;
    private BigDecimal quantite;
    private BigDecimal prixUniataire;
    private Long entrepriseId;


    public static LigneVenteDto fromEntity(LigneVente entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return LigneVenteDto.builder()
                .id(entity.getId())
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .vente(VenteDto.fromEntity(entity.getVente()))
                .quantite(entity.getQuantite())
                .prixUniataire(entity.getPrixUniataire())
                .entrepriseId(entity.getEntrepriseId())
                .build();

    }

    public static LigneVente toEntity(LigneVenteDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        LigneVente ligneVente=new LigneVente();
        ligneVente.setId(dto.getId());
        ligneVente.setQuantite(dto.getQuantite());
        ligneVente.setPrixUniataire(dto.getPrixUniataire());
        ligneVente.setEntrepriseId(dto.getEntrepriseId());
        ligneVente.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneVente.setVente(VenteDto.toEntity(dto.getVente()));
        return ligneVente;

    }
}
