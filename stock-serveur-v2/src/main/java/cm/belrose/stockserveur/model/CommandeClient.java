package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

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
@Table(name = "Commandeclients")
public class CommandeClient extends Auditable<String> implements Serializable {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String code;
      @Column(name = "date_commande")
      private Instant dateCommande;
      @NotAudited
      @ManyToOne
      @JoinColumn(name = "client_id")
      private Client client;
      @NotAudited
      @OneToMany(mappedBy = "commandeClient")
      private List<LigneCommandeClient> ligneCommandeClientList;
      //Ce champs est juste mis pour simplifier les choses
      //@Column(name = "entreprise_id")
      private Long entrepriseId;


}
