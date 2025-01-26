package ruslan.simple_task_tracker.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ruslan.simple_task_tracker.persistence.units.AuthorizationPersistenceUnitInfo;
import ruslan.simple_task_tracker.persistence.units.MainPersistenceUnitInfo;

import java.util.HashMap;

@Configuration
public class ProjectConfig {
/*
    @Bean
    public EntityManagerFactory mainEntityManagerFactory() {
        return new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new AuthorizationPersistenceUnitInfo(),
                        new HashMap<String, String>()
                );
    }

    @Bean
    public EntityManagerFactory authorizationEntityManagerFactory() {
        return new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new MainPersistenceUnitInfo(),
                        new HashMap<String, String>()
                );
    }*/
}
