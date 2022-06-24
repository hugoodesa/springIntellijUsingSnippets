package br.com.alura.springIntellij;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringIntellijApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntellijApplication.class, args);
	}

}
