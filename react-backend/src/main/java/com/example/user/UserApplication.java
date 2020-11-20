package com.example.user;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource()
	{
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://localhost:8080"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}


	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/").allowedOrigins("http://localhost:8080");
			/*	registry.addMapping("/**")
						.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");


				registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
			}
		};
	}
	*/

}
