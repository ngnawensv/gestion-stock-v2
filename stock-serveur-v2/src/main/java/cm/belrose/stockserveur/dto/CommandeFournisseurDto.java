package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDto {
    private Long id;
    private String code;
    private Instant dateCommande;
    private Fournisseur fournisseur;
    private EtatCommande etatCommande;
    private Long entrepriseId;
    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurList;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CommandeFournisseurValidator (CommandeFournisseur==>CommandeFournisseurValidator)
        return CommandeFournisseurDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .dateCommande(entity.getDateCommande())
                .fournisseur(entity.getFournisseur())
                .entrepriseId(entity.getEntrepriseId())
                .build();

    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type CommandeFournisseur (CommandeFournisseurValidator==>CommandeFournisseur)
        CommandeFournisseur commandeFournisseur=new CommandeFournisseur();
        commandeFournisseur.setId(dto.getId());
        commandeFournisseur.setCode(dto.getCode());
        commandeFournisseur.setEntrepriseId(dto.getEntrepriseId());
        commandeFournisseur.setDateCommande(dto.getDateCommande());
        commandeFournisseur.setFournisseur(dto.getFournisseur());
        return commandeFournisseur;
    }

    public Boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
