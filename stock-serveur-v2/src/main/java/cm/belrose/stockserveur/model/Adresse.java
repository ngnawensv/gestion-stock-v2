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
    private String codePostale;
    private String rue;
    private String ville;
    private String pays;

}
