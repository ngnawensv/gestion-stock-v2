package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name = "mouvementstocks")
public class MouvementStock extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotAudited
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    private BigDecimal quantite;
    @Column(name = "date_mouvement")
    private Instant dateMouvement;
    //Ce champs est juste mis pour simplifier les choses
    //@Column(name = "entreprise_id")
    private Long entrepriseId;
}
