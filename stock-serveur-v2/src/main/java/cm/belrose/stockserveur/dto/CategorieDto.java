package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.Categorie;
import cm.belrose.stockserveur.model.Entreprise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class CategorieDto {
    private Long id;
    private String code;
    private String libelle;
    private Long entrepriseId;
    @JsonIgnore
    private List<ArticleDto> articleList;

    /**
     * Cette Methode permet de faire le mapping entre l'entité Categorie et le DTO CategorieDto
     * Bref elle permet de construire un DTO à partir d'une entités
     * @param entity
     * @return
     */
    public static CategorieDto fromEntity(Categorie entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return CategorieDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .libelle(entity.getLibelle())
                .entrepriseId(entity.getEntrepriseId())
                .build();

    }

    /**
     * Cette methode  permet de construire un Entite à partir d'un DTO
     * @param dto
     * @return
     */
    public static Categorie toEntity(CategorieDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        Categorie categorie=new Categorie();
        categorie.setId(dto.getId());
        categorie.setCode(dto.getCode());
        categorie.setEntrepriseId(dto.getEntrepriseId());
        categorie.setLibelle(dto.getLibelle());
        return categorie;

    }
}
