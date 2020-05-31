package com.gourmet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GroumetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroumetApiApplication.class, args);
	}
	
	// Configuración de CORS
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/restaurantes").allowedOrigins("http://localhost:5500");
			}
		};
	}
	

}

