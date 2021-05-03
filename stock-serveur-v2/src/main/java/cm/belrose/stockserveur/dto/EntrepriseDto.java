package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Adresse;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntrepriseDto {
    private Long id;
    private String nom;
    private String codeFiscal;
    private String email;
    private String logo;
    private AdresseDto adresse;

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
                .logo(entity.getLogo())
                .adresse(AdresseDto.fromEntity(entity.getAdresse()))
                .build();

    }

    public static Entreprise toEntity(EntrepriseDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Entreprise (EntrepriseDto==>Entreprise)
        Entreprise entreprise=new Entreprise();
        entreprise.setId(dto.getId());
        entreprise.setNom(dto.getNom());
        entreprise.setCodeFiscal(dto.getCodeFiscal());
        entreprise.setEmail(dto.getEmail());
        entreprise.setLogo(dto.getLogo());
        entreprise.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        return entreprise;

    }
}
