package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Builder
@Data
public class UsersDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Instant dateNaissance;
    private String genre;
    private String photo;
    private AdresseDto adresse;
    private EntrepriseDto entreprise;
   // @JsonIgnore
    private Set<RolesDto> roles;
/*
    public UsersDto(Long id ,String username, String email, String password, Set<RolesDto> rolesDto) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rolesDto = rolesDto;
    }
    public UsersDto(String username, String email, String password, Set<RolesDto> rolesDto) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rolesDto = rolesDto;
    }*/

    public static UsersDto fromEntity(Users entity){
        if(entity==null){
            return null;
        }
        //Construction d'un objet de type CategorieDto (Categorie==>CategorieDto)
        return UsersDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .dateNaissance(entity.getDateNaissance())
                .genre(entity.getGenre())
                .photo(entity.getPhoto())
                .adresse(AdresseDto.fromEntity(entity.getAdresse()))
                .entreprise(EntrepriseDto.fromEntity(entity.getEntreprise()))
                .build();

    }

    public static Users toEntity(UsersDto dto){
        if(dto==null){
            return null;
        }
        //Construction d'un objet de type Categorie (CategorieDto==>Categorie)
        Users users =new Users();
        users.setId(dto.getId());
        users.setUsername(dto.getUsername());
        users.setEmail(dto.getEmail());
        users.setPassword(dto.getPassword());
        users.setNom(dto.getNom());
        users.setPrenom(dto.getPrenom());
        users.setDateNaissance(dto.getDateNaissance());
        users.setGenre(dto.getGenre());
        users.setPhoto(dto.getPhoto());
        users.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        users.setEntreprise(EntrepriseDto.toEntity(dto.getEntreprise()));
        return users;

    }
}
