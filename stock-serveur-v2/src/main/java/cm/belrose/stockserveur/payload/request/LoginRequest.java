package cm.belrose.stockserveur.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
