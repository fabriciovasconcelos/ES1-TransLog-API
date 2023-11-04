package unirio.es1.TransLogAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class TransLogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransLogApiApplication.class, args);
	}

}
