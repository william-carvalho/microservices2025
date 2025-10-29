package br.com.will.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Exchange Microservice API", version = "v1", description = "Docunentation of Exchange service API"))
public class OpenApiConfiguration {
    @Bean
    public OpenAPI cusOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Exchange Microservice API")
                        .version("v1")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://api.nexti.com/swagger-ui/index.html")));
    }
}
