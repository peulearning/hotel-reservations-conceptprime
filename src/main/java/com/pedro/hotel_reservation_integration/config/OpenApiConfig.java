package com.pedro.hotel_reservation_integration.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hotelReservationAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Hotel Reservation Integration API")

                        .description("""
                                API responsável pela integração de reservas de hotéis
                                através de Polling e Webhook.
                                Desenvolvida como solução para teste técnico.
                                """)

                        .version("1.0.0")

                        .contact(new Contact()
                                .name("Pedro Henrique Ribeiro"))

                        .license(new License()
                                .name("MIT")))

                .externalDocs(new ExternalDocumentation()

                        .description("GitHub")

                        .url("https://github.com/peulearning/hotel-reservations-conceptprime"));
    }

}