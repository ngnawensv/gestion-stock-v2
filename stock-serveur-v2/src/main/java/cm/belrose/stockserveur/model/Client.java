package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Le 09/11/2020
 *
 * @author Ngnawen Samuel
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String genre;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String email;
    private String numeroTelephone;
    private String photo;
    @Embedded
    private Adresse adresse;
    //Ce champs est juste mis pour simplifier les choses
    private Long entrepriseId;
    @NotAudited
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClientList;

}
