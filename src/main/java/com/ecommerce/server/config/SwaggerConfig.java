package com.ecommerce.server.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Louis Vuitton API").description("Louis Vuitton E-commerce Application")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Louis Pham")));
    }
}
