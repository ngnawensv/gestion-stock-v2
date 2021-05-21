package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
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
@Table(name = "lignecommandeclients")
public class LigneCommandeClient extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    @NotAudited
    @ManyToOne
    private Article article;
    @ManyToOne
    private CommandeClient commandeClient;
    //Ce champs est juste mis pour simplifier les choses
    private Long entrepriseId;

}
