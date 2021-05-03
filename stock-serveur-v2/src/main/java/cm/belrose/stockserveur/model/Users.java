package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Le 09/11/2020
 *
 *@author  Ngnawen Samuel
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Audited
@Table(name = "users")
public class Users extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String genre;
    private String photo;
    private Instant dateNaissance;
    @NotAudited
    @Embedded
    private Adresse adresse;
    @NotAudited
    @ManyToOne
    //@JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    /**
     * FetchType.LAZY : indique que la relation doit être chargée à la demande ;
     * FetchType.EAGER : indique que la relation (Users-role) doit être chargée en même temps que l'entité qui la Users
     */
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(	name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    public Users(String username, String email, String password, Entreprise entreprise, Set<Roles> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.entreprise=entreprise;
        this.roles = roles;
    }
}
