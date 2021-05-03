package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.LigneVente;
import cm.belrose.stockserveur.model.Vente;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VenteDto {
    private Long id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private Long entrepriseId;
    private List<LigneVenteDto> ligneVenteList;


    public static VenteDto fromEntity(Vente entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type VenteDto (Vente==>VenteDto)
        return VenteDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .dateVente(entity.getDateVente())
                .commentaire(entity.getCommentaire())
                .entrepriseId(entity.getEntrepriseId())
                .build();

    }

    public static Vente toEntity(VenteDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Vente (VenteDto==>Vente)
        Vente vente=new Vente();
        vente.setId(dto.getId());
        vente.setCode(dto.getCode());
        vente.setDateVente(dto.getDateVente());
        vente.setCommentaire(dto.getCommentaire());
        vente.setEntrepriseId(dto.getEntrepriseId());
        return vente;

    }
}
