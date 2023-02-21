package a.grebnev.dailyreports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DailyReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyReportsApplication.class, args);
	}
}
