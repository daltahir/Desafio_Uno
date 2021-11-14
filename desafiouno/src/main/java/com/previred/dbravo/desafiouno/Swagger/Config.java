package com.previred.dbravo.desafiouno.Swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration

public class Config {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.previred.dbravo.desafiouno.Controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("API Faltantes: Desafio Previred")
                .version("1.0")
                .description("API para resolver desafio 1 Previred")
                .contact(new Contact("Diego Bravo", "https://www.linkedin.com/in/diego-bravo-a89451164","diego.bravo@gmail.com"))
                .license("Apache License Version 2.0")
                .build();
    }
}
