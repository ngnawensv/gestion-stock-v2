package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author NGNAWEN
 * @since 10/04/2021
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entreprises")
public class Entreprise extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeFiscal;
    private String nom;
    private String email;
    private String logo;
    private String siteWeb;
    private String numeroTelephone;
    private String description;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "entreprise")
    private List<Users> usersList;
}
