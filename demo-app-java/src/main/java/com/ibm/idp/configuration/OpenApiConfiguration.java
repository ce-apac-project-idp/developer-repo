package com.ibm.idp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Component
public class OpenApiConfiguration {
	
	  @Bean
	  public OpenAPI openAPI() {
	    String host = System.getenv("HOST");
	    Info info = new Info().title("CE IDP Sample Service API Documentation").version("v1")
	            .description("Skillset Navigator Backend Service")
	            .termsOfService(host)
	            .contact(new Contact().name("Cient Engineering").email(""))
	            .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));

	    return new OpenAPI()
	            .components(new Components())
	            .info(info);
	  }

}
