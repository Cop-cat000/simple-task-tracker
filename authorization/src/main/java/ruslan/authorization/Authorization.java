package ruslan.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ruslan")
@EnableJpaRepositories(basePackages = "ruslan")
@EntityScan(basePackages = "ruslan")
public class Authorization {

	public static void main(String[] args) {
		SpringApplication.run(Authorization.class, args);
	}

}
