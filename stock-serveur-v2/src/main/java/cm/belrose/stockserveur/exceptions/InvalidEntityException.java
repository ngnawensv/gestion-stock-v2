package cm.belrose.stockserveur.exceptions;

import lombok.Getter;

import java.util.List;

/**
 * @author Ngnawen
 * @since 07/03/2021
 *
 * Cette classe permet de lever une exception lorsqu'on essaye d'enregistrer quelque chose dans la base de données
 * et la propriété n'ai pas valide en passant par la validaton croisée
 */

public class InvalidEntityException  extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;
    @Getter
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);

    }

    public InvalidEntityException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }


    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes) {
        super(message, cause);
        this.errorCodes = errorCodes;
    }


    public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors) {
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes, List<String> errors) {
        super(message, cause);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }
}
