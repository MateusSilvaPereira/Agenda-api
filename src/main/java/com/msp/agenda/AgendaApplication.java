package com.msp.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//@ComponentScan({"main.controllers", "main.repositories"})
//@EnableJpaRepositories("main.repositories")
@EntityScan(basePackages = {"com.msp.agenda.models"})
@ComponentScan(basePackages = {"com.*"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
