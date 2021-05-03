package cm.belrose.stockserveur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @EnableJpaRepositories(...): allows integrating spring-data-envers project to your Spring Boot project
 */
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
@SpringBootApplication
//@EnableJpaAuditing
/*@EntityScan(basePackageClasses = {
		StockserveurApplication.class,
		Jsr310JpaConverters.class
})*/
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class StockserveurApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockserveurApplication.class, args);
	}









}
