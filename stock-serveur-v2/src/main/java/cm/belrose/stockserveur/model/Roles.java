package cm.belrose.stockserveur.model;

import cm.belrose.stockserveur.config.audit.Auditable;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

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
@Audited
@Table(name = "roles")
public class Roles extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
    //Ce champs est juste mis pour simplifier les choses
    //@Column(name = "entreprise_id")
   // private Long entrepriseId;

    public Roles(RoleEnum name) {
        this.name = name;
    }
}

