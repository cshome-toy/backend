package com.cshome.toy.discopy.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Discopy API")
                .version("1.0.0")
                .description("Discord Clone Project API documentation")
                .termsOfService("http://swagger.io/terms/");
        final String securitySchemeName = "bearerAuth";
        Server server = new Server().url("/");

        return new OpenAPI()
            .servers(List.of(server))
            .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
            .components(
                new Components()
                    .addSecuritySchemes(securitySchemeName,
                        new SecurityScheme()
                            .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                            .in(SecurityScheme.In.HEADER)
                    )
            )
            .info(info);
    }
}