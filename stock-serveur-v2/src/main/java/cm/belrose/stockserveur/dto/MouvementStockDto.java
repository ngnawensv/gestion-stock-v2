package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.*;
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
    private TypeMouvementStock typeMouvementStock;
    private SourceMouvementStock sourceMouvementStock;
    private Long entrepriseId;

    public static MouvementStockDto fromEntity(MouvementStock entity) {
        if (entity == null) {
            return null;
        }
        return MouvementStockDto.builder()
                .id(entity.getId())
                .dateMouvement(entity.getDateMouvement())
                .sourceMouvementStock(entity.getSourceMouvementStock())
                .quantite(entity.getQuantite())
                .entrepriseId(entity.getEntrepriseId())
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .build();
    }

    public static MouvementStock toEntity(MouvementStockDto dto) {
        if (dto == null) {
            return null;
        }
        return MouvementStock.builder()
                .id(dto.getId())
                .dateMouvement(dto.getDateMouvement())
                .sourceMouvementStock(dto.getSourceMouvementStock())
                .quantite(dto.getQuantite())
                .entrepriseId(dto.getEntrepriseId())
                .article(ArticleDto.toEntity(dto.getArticle()))
                .build();
    }
}
