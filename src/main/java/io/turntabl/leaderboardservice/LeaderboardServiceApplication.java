package io.turntabl.leaderboardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableScheduling
@CrossOrigin(origins = "http://localhost:4200")
public class LeaderboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaderboardServiceApplication.class, args);
	}

}
