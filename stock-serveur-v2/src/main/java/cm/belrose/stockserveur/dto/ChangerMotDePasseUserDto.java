package cm.belrose.stockserveur.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePasseUserDto {
    private Long id;

    private String motDePasse;

    private String confirmMotDePasse;
}
