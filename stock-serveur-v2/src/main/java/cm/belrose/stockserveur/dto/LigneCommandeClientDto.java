package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeClientDto {
    private Long id;
    private ArticleDto article;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private CommandeClientDto commandeClient;
    private Long entrepriseId;


    public static LigneCommandeClientDto fromEntity(LigneCommandeClient entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return LigneCommandeClientDto.builder()
                .id(entity.getId())
                .entrepriseId(entity.getEntrepriseId())
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .commandeClient(CommandeClientDto.fromEntity(entity.getCommandeClient()))
                .build();

    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        LigneCommandeClient ligneCommandeClient=new LigneCommandeClient();
        ligneCommandeClient.setId(dto.getId());
        ligneCommandeClient.setEntrepriseId(dto.getEntrepriseId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(dto.getCommandeClient()));
        return ligneCommandeClient;

    }
}
