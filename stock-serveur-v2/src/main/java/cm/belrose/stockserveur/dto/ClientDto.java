package cm.belrose.stockserveur.dto;


import cm.belrose.stockserveur.model.Adresse;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.model.Entreprise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String genre;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String email;
    private String numTel;
    private String photo;
    private AdresseDto adresse;
    private Long entrepriseId;
    @JsonIgnore
    private List<CommandeClientDto> commandeClientList;


    public static ClientDto fromEntity(Client entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type ClientDto (Client==>ClientDto)
        return ClientDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .genre(entity.getGenre())
                .dateNaissance(entity.getDateNaissance())
                .lieuNaissance(entity.getLieuNaissance())
                .email(entity.getEmail())
                .numTel(entity.getNumTel())
                .photo(entity.getPhoto())
                .entrepriseId(entity.getEntrepriseId())
                .adresse(AdresseDto.fromEntity(entity.getAdresse()))
                .build();

    }

    public static Client toEntity(ClientDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Client (ClientDto==>Client)
        Client client=new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setGenre(dto.getGenre());
        client.setDateNaissance(dto.getDateNaissance());
        client.setLieuNaissance(dto.lieuNaissance);
        client.setEmail(dto.getEmail());
        client.setNumTel(dto.getNumTel());
        client.setPhoto(dto.getPhoto());
        client.setEntrepriseId(dto.getEntrepriseId());
        client.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        return client;

    }
}
