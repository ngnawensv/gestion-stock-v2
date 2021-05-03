package cm.belrose.stockserveur.exceptions.handlers;

import cm.belrose.stockserveur.exceptions.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe represente l'objet à renvoyé lorsqu'on catch une exception
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCodes code;
    private String message;
    @Builder.Default
    private List<String> errors=new ArrayList<>();
}
