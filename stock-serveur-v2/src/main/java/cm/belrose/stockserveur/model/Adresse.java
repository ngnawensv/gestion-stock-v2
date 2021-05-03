package cm.belrose.stockserveur.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Adresse {
    @Column(name = "adresse_1")
    private String adresse1;
    @Column(name = "adresse_2")
    private String adresse2;
    private String ville;
    @Column(name = "code_postale")
    private String codePostale;
    private String pays;

}
