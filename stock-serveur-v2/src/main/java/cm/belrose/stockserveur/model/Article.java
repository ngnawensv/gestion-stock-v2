package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
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
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name = "articles")
public class Article extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String designation;
    @Column(name = "prix_unitaire_hors_taxe")
    private BigDecimal prixUnitaireHt;
    @Column(name = "taux_tva")
    private BigDecimal tauxTva;
    @Column(name = "prix_unitaire_ttc")
    private BigDecimal prixUnitaireTtc;
    @Column(name = "prix_achat")
    private BigDecimal prixAchat;
    @Column(name = "prix_vente")
    private BigDecimal prixVente;
    private double quantite;
    private String photo;
    @NotAudited
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    //Ce champs est juste mis pour simplifier les choses
    //@Column(name = "entreprise_id")
    private Long entrepriseId;

}
