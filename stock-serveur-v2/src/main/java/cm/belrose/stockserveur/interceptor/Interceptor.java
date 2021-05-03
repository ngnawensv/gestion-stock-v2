package cm.belrose.stockserveur.interceptor;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            //select user0_.
            final String entityName = sql.substring(7, sql.indexOf("."));
            final String entrepriseId = MDC.get("entrepriseId");
            if (StringUtils.hasLength(entityName)
                    && !entityName.toLowerCase().contains("entreprise")
                    && !entityName.toLowerCase().contains("roles")
                    && StringUtils.hasLength(entrepriseId)) {
            //if (!sql.startsWith("select entreprise0")) {
                if (sql.contains("where")) {
                   // sql = sql + " and entreprise_id = 1";
                    sql = sql + " and " + entityName + ".entreprise_id = " + entrepriseId;
                } else {
                   // sql = sql + " where entreprise_id = 1";
                    sql = sql + " where " + entityName + ".entreprise_id = " + entrepriseId;
                }
            }

        }
        //}
        return super.onPrepareStatement(sql);
    }
}
