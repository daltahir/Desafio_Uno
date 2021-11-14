package com.previred.dbravo.desafiouno;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
public class DesafiounoApplication {
	@Configuration
	public class JacksonConfiguration {

	    @Bean
	    public ObjectMapper objectMapper() {
	        return new ObjectMapper()
	                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT )
	                .enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY );
	    }
	}

	

	public static void main(String[] args) {
		SpringApplication.run(DesafiounoApplication.class, args);
		
	}

	

}
