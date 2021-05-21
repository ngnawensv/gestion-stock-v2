package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Le 09/11/2020
 *
 * @author Ngnawen Samuel
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table( name = "mouvementstocks" )
public class MouvementStock extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @NotAudited
    @ManyToOne
    private Article article;
    private BigDecimal quantite;
    private Instant dateMouvement;
    private TypeMouvementStock typeMouvementStock;
    //Permet de distinguer par exemple une sortie pour une commande client d'une sortie pour une vente
    private SourceMouvementStock sourceMouvementStock;
    //Ce champs est juste mis pour simplifier les choses
    private Long entrepriseId;
}
