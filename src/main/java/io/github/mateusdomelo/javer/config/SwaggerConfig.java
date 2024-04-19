package io.github.mateusdomelo.javer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Javer Bank | Bridge API")
                .description(
                        "API projetada para integração (leitura, escrita, atualização, exclusão)" +
                                " com o banco de dados (H2)"
                ).contact(contactInfo());
    }

    private Contact contactInfo() {
        return new Contact()
                .name("Mateus Melo")
                .email("mateusmelo@gmail.com")
                .url("https://github.com/mateusdomelo");
    }
}
