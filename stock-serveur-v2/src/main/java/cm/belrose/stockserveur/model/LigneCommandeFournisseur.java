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
@Entity
@Table(name = "lignecommandefournisseurs")
public class LigneCommandeFournisseur extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Long entrepriseId;//Ce champs est juste mis pour simplifier les choses
    @NotAudited
    @ManyToOne
    private Article article;
    @ManyToOne
    private CommandeFournisseur commandeFournisseur;

}
