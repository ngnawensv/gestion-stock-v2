package cm.belrose.stockserveur.config.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Ngnawen Samuel
 * @since 18/11/2020 10:20
 *
 *
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    //Initialiser  AuditorAware<String> avec une instance de AuditorAwareImpl
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
