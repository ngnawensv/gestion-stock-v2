package cm.belrose.stockserveur.exceptions;

import lombok.Getter;

/**
 * @author Ngnawen
 * @since 07/03/2021
 *
 * Cette classe represente une exception générique.Par exemple si je cherche un article suivante un code
 * et que l'article n'existe pas je vais renvoyer une exception du type EntityNotFoundException.
 * Cela permet d'envoyer une exception claire au client ou au comsommateur.
 */
public class EntityNotFoundException extends RuntimeException {

    @Getter
    private ErrorCodes errorCodes;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCodes) {
        super(message, cause);
        this.errorCodes = errorCodes;
    }
}
