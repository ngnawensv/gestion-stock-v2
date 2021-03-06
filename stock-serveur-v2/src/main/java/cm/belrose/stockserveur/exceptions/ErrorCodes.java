package cm.belrose.stockserveur.exceptions;

/**
 * @author Ngnawen
 * @since 07/08/2021
 * <p>
 * Cette enumeration permet de definir les code d'erreurs
 */
public enum ErrorCodes {


    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    //TODO Completer le reste  des codes d'erreurs

    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),

    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALID(3001),

    ENTREPRISE_NOT_FOUND(4000),
    ENTREPRISE_NOT_VALID(4001),

    FOURNISSEUR_NOT_FOUND(5000),
    FOURNISSEUR_NOT_VALID(5001),

    COMMANDE_CLIENT_NOT_FOUND(6000),
    COMMANDE_CLIENT_NOT_VALID(6001),
    COMMANDE_CLIENT_NON_MODIFIABLE(6001),

    COMMANDE_FOURNISSEUR_NOT_FOUND(7000),
    COMMANDE_FOURNISSEUR_NOT_VALID(7001),
    COMMANDE_FOURNISSEUR_NON_MODIFIABLE(6001),

    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_CLIENT_NOT_VALID(8001),

    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_VALID(9001),

    LIGNE_VENTE_NOT_FOUND(10000),
    LIGNE_VENTE_NOT_VALID(10001),

    MOUVEMENT_STOCK_NOT_FOUND(11000),
    MOUVEMENT_NOT_VALID(11001),

    USER_NOT_FOUND(12000),
    USER_NOT_VALID(12001),

    VENTE_NOT_FOUND(13000),
    VENTE_NOT_VALID(13001),

    SOUS_CATEGORIE_NOT_FOUND(14000),
    SOUS_CATEGORIE_NOT_VALID(14001),

    ROLE_NOT_FOUND(15000),
    ROLE_NOT_VALID(15001),

    BAD_CREDENTIALS(16000),
    //Liste des exceptions techniques
    UPDATE_PHOTO_EXCEPTION(17000),
    UNKNOWN_CONTEXT (17001);

    private int code;
    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
