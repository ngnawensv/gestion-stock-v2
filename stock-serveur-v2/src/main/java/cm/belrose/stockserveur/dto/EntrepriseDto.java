package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Adresse;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author NGNAWEN
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntrepriseDto {
    private Long id;
    private String codeFiscal;
    private String nom;
    private String email;
    private String logo;
    private String siteWeb;
    private String numeroTelephone;
    private String description;
    private AdresseDto adresse;
    @JsonIgnore
    private List<UsersDto> usersList;

    public static EntrepriseDto fromEntity(Entreprise entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type EntrepriseDto (Entreprise==>EntrepriseDto)
        return EntrepriseDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .codeFiscal(entity.getCodeFiscal())
                .email(entity.getEmail())
                .numeroTelephone(entity.getNumeroTelephone())
                .siteWeb(entity.getSiteWeb())
                .description(entity.getDescription())
                .logo(entity.getLogo())
                .adresse(AdresseDto.fromEntity(entity.getAdresse()))
                .build();

    }

    public static Entreprise toEntity(EntrepriseDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Entreprise (EntrepriseDto==>Entreprise)
        return Entreprise.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .codeFiscal(dto.getCodeFiscal())
                .numeroTelephone(dto.getNumeroTelephone())
                .siteWeb(dto.getSiteWeb())
                .description(dto.getDescription())
                .email(dto.getEmail())
                .logo(dto.getLogo())
                .adresse(AdresseDto.toEntity(dto.getAdresse()))
                .build();

    }
}
