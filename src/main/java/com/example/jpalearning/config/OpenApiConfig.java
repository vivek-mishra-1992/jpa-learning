package com.example.jpalearning.config;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "Product API", version = "v1", description = "API for managing products")
)
public class OpenApiConfig {
}
