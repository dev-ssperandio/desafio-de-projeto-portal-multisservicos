package me.dio.desafio_de_projeto_portal_multisservicos.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Portal Multisserviços API")
                        .version("1.0.0")
                        .description("API desenvolvida para o Bootcamp Claro com Spring para gerenciamento de pacotes de serviços de telefonia, abstraindo os serviços básicos prestados pela Claro.\n\n" +
                                "### Contato\n" +
                                "**LinkedIn:** [Sidney Ribeiro Sperandio](https://www.linkedin.com/in/sidneysperandio/)\n" +
                                "**GitHub:** [dev-ssperandio](https://github.com/dev-ssperandio)\n" +
                                "**WhatsApp:** [Clique aqui para mandar mensagem](https://wa.me/5511975018322)")
                        .contact(new Contact()
                                .name("Sidney Ribeiro Sperandio")
                                .email("dev.ssperandio@gmail.com")));
    }
}
