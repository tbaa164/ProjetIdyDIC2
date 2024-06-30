package com.example.GestionDeSuivi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestionDeSuiviApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeSuiviApplication.class, args);
	}

}
