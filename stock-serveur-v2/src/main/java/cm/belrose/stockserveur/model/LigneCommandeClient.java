package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;

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
    @NotAudited
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "commandeclient_id")
    private CommandeClient commandeClient;
    //Ce champs est juste mis pour simplifier les choses
    //@Column(name = "entreprise_id")
    private Long entrepriseId;

}
