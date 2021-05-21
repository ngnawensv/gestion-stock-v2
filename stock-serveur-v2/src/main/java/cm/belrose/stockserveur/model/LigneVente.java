package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ligneVentes")
public class LigneVente extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantite;
    private BigDecimal prixUniataire;
    private Long entrepriseId; //Ce champs est juste mis pour simplifier les choses
    @NotAudited
    @ManyToOne
    private Article article;
    @NotAudited
    @ManyToOne
    private Vente vente;
}
