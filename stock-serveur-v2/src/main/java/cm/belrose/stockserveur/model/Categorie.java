package cm.belrose.stockserveur.model;
import cm.belrose.stockserveur.config.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 *@author  Ngnawen Samuel
 * @since  09/11/2020 20:30:00
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name = "categories")
public class Categorie extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;
    //Ce champs est juste mis pour simplifier les choses
   // @Column(name = "entreprise_id")
    private Long entrepriseId;
    @NotAudited
    @OneToMany(mappedBy = "categorie")
    private List<Article> articleList;

}
