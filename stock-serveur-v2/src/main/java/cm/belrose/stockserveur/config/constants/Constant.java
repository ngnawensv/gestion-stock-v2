package cm.belrose.stockserveur.config.constants;

public interface Constant {


    String DEFAULT_ENTREPRISE="Ets.BELROSE";
    String DEFAULT_ADMIN_USERNAME = "Admin";
    String DEFAULT_ADMIN_EMAIL = "admin@admin.com";
    String DEFAULT_ADMIN_PASSWORD = "admin";
    String DEFAULT_CATEGORIE_CODE = "CAT00000";
    //String SECRET_KEY="secret";

    String APP_ROOT = "api2";
    String ARTICLE_ENDPOINT=APP_ROOT+"/articles";
    String CATEGORIE_ENDPOINT=APP_ROOT+"/categories";
    String ENTREPRISE_ENDPOINT=APP_ROOT+"/entreprises";
    String AUTHENTICATION_ENDPOINT=APP_ROOT+"/authenticate";
    String USER_ENDPOINT=APP_ROOT+"/users";


}
