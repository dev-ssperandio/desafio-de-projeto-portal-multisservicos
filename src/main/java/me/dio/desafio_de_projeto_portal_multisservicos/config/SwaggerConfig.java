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
                                "**LinkedIn:** [Sidney Sperandio](https://www.linkedin.com/in/sidneysperandio/)\n\n" +
                                "**GitHub:** [dev-ssperandio](https://github.com/dev-ssperandio)\n\n" +
                                "**WhatsApp:** [Clique aqui para mandar mensagem](https://wa.me/5511975018322)\n\n" +
                                "**E-mail:** [Envie um email](mailto:dev.ssperandio@gmail.com)\n\n" +
                                "### Autor\n" +
                                "Sidney Ribeiro Sperandio"));
    }
}
