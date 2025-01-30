package ruslan.simple_task_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SimpleTaskTrackerApplication {

	public static void main(String[] args) {
//		var pe = new BCryptPasswordEncoder();
//		System.out.println(pe.encode("12345"));
//		System.exit(0);
		SpringApplication.run(SimpleTaskTrackerApplication.class, args);
	}

}
