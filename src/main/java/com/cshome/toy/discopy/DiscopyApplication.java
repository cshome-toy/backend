package com.cshome.toy.discopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DiscopyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscopyApplication.class, args);
	}

}
