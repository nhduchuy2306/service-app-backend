package com.example.servicebackend.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(name = "Authorization", type = SecuritySchemeType.HTTP, scheme = "Bearer", in = SecuritySchemeIn.HEADER)
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .openapi("3.0.1")
                .security(null);
    }

    private Info apiInfo() {
        return new Info()
                .title("Service Backend")
                .description("Service Backend for the Service Frontend")
                .termsOfService("http://swagger.io/terms/")
                .version("1.0.0");
    }
}
