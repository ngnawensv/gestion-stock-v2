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
      private Instant dateCommande;
      private EtatCommande etatCommande;
      private Long entrepriseId;  //Ce champs est juste mis pour simplifier les choses
      @NotAudited
      @ManyToOne
      private Client client;
      @NotAudited
      @OneToMany (mappedBy = "commandeClient")
      private List<LigneCommandeClient> ligneCommandeClients;


}
