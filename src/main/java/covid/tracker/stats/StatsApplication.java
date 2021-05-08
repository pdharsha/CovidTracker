package covid.tracker.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

// @SpringBootApplication
@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StatsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(StatsApplication.class, args);
	}

}
