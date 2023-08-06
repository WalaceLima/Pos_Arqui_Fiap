package br.com.archtech.apis.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Gestão de Energia")
                        .description("Api's para cadastro de Pessoas,Casas e Eletrodomésticos.Este sistema tem por finalidade calcular o consumo mensal de energia")
                        .version("1.1"));
    }
}
