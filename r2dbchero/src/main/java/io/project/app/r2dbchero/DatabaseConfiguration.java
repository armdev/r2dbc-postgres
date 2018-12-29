/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.r2dbchero;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DatabaseConfiguration {

    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder() //
                .host("localhost")
                .port(5432)
                .database("socnet")
                .username("postgres")
                .password("socnet")
                .build();

        return new PostgresqlConnectionFactory(config);
    }

   

}
