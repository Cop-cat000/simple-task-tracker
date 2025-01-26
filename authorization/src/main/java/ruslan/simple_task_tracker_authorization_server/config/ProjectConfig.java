package ruslan.simple_task_tracker_authorization_server.config;

import jakarta.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ruslan.simple_task_tracker_authorization_server.persistence.units.AuthorizationPersistenceUnitInfo;

import java.util.HashMap;

@Configuration
public class ProjectConfig {

    @Bean
    public EntityManagerFactory authorizationEntityManagerFactory() {
        return new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new AuthorizationPersistenceUnitInfo(),
                        new HashMap<String, String>()
                );
    }
}
