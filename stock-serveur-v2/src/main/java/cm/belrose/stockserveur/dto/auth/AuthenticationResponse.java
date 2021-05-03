package cm.belrose.stockserveur.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

    private String accessToken; //Token à utiliser pour l'authentification
}
