package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.CommandeClient;
import cm.belrose.stockserveur.model.Entreprise;
import cm.belrose.stockserveur.model.EtatCommande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeClientDto {
    private Long id;
    private String code;
    private Instant dateCommande;
    private Client client;
    private EtatCommande etatCommande;
    private Long entrepriseId;
    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClientList;

    public static CommandeClientDto fromEntity(CommandeClient entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (CommandeClient==>CommandeClientValidator)
        return CommandeClientDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .dateCommande(entity.getDateCommande())
                .client(entity.getClient())
                .etatCommande(entity.getEtatCommande())
                .entrepriseId(entity.getEntrepriseId())
                .build();

    }

    public static CommandeClient toEntity(CommandeClientDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type CommandeClient (CommandeClientValidator==>CommandeClient)
//        CommandeClient commandeClient=new CommandeClient();
//        commandeClient.setId(dto.getId());
//        commandeClient.setCode(dto.getCode());
//        commandeClient.setEntrepriseId(dto.getEntrepriseId());
//        commandeClient.setDateCommande(dto.getDateCommande());
//        commandeClient.setClient(dto.getClient());
        return CommandeClient.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .entrepriseId(dto.getEntrepriseId())
                .dateCommande(dto.getDateCommande())
                .client(dto.getClient())
                .etatCommande(dto.getEtatCommande())
                .build();

    }

    public Boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
