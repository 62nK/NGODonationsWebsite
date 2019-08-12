package com.patpintar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.tariq.models.repos") 
@EntityScan("com.ketu.model.beans")
@ComponentScan({"com.andrea.controllers","com.tariq.models.services"})
@SpringBootApplication
public class NgoDonationsWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoDonationsWebsiteApplication.class, args);
	}

}
