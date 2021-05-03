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
@Table(name = "ligneVentes")
public class LigneVente extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantite;
    @Column(name = "prix_unitaire")
    private BigDecimal prixUniataire;
    @NotAudited
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "vente_id")
    private Vente vente;
    //Ce champs est juste mis pour simplifier les choses
    //@Column(name = "entreprise_id")
    private Long entrepriseId;
}
