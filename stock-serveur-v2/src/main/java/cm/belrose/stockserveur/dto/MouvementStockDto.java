package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.MouvementStock;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MouvementStockDto {
    private Long id;
    private ArticleDto article;
    private BigDecimal quantite;
    private Instant dateMouvement;
    private Long entrepriseId;


    public static MouvementStockDto fromEntity(MouvementStock entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return MouvementStockDto.builder()
                .id(entity.getId())
                .dateMouvement(entity.getDateMouvement())
                .quantite(entity.getQuantite())
                .entrepriseId(entity.getEntrepriseId())
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .build();

    }

    public static MouvementStock toEntity(MouvementStockDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        MouvementStock mouvementStock=new MouvementStock();
        mouvementStock.setId(dto.getId());
        mouvementStock.setQuantite(dto.getQuantite());
        mouvementStock.setDateMouvement(dto.getDateMouvement());
        mouvementStock.setEntrepriseId(dto.getEntrepriseId());
        mouvementStock.setArticle(ArticleDto.toEntity(dto.getArticle()));
        return mouvementStock;

    }
}
