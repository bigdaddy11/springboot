package com.dokuku.semi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SemiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemiApplication.class, args);
	}

}
