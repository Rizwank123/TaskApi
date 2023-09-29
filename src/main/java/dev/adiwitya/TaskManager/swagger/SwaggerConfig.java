package dev.adiwitya.TaskManager.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration

public class SwaggerConfig {
	
	@Bean
	public OpenAPI SpringTaskApi() {
//		return new OpenAPI()
//				.info(new Info().title("Personal Task Manager")
//				.description("Simple api to manage task using spring boot and spring JDBC ")
//			.version("v0.1.0")
//			.license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")).contact(new Contact().email("md.rizwank431@gmail.com").name("Mohammad Rizwan").url("https://Rizwank123.github.io")))
//				.externalDocs(new ExternalDocumentation().description("This Sprin boot rest Api for managing task int build by Mohammad Rizwan")
//				
//				
//				);
		
		
		
		    return new OpenAPI().addSecurityItem(new SecurityRequirement().
		            addList("Bearer Authentication"))
		        .components(new Components().addSecuritySchemes
		            ("Bearer Authentication", createAPIKeyScheme()))
		        .info(new Info().title("Personal Task Manager")
		            .description("Some custom description of API.")
		            .version("1.0").contact(new Contact().name("Mohammad Rizwan")
		                .email( "www.baeldung.com").url("md.rizwank431@gmail.com"))
		            .license(new License().name("License of API")
		                .url("API license URL")));
		}		
				
	
	private SecurityScheme createAPIKeyScheme() {
    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
        .bearerFormat("JWT")
        .scheme("bearer");
}

}
