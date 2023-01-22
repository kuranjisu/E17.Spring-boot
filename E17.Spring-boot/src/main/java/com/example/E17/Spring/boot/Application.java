package com.example.E17.Spring.boot;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@Configuration
@EntityScan(basePackages = "com/example/E17")
@EnableJpaRepositories(basePackages = "com.example.E17")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
