package com.senac.aulaapijovemprogramador.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenApi(){

        return new OpenAPI().info(new Info()
                .title("API Aula Jovem")
                .version("1.0")
                .description("API responsavel por apresentar codigos e didaticas aos alunos do jovem programador!")
                .termsOfService("http://mtxsistemas.tech")
        );
    }
}
