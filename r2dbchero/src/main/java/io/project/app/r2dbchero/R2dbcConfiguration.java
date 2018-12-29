/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.r2dbchero;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 *
 * @author armena
 */
@Configuration
@EnableR2dbcRepositories("io.project.app.r2dbchero.repositories")
class R2dbcConfiguration extends AbstractR2dbcConfiguration {

    private final ConnectionFactory connectionFactory;

    R2dbcConfiguration(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public ConnectionFactory connectionFactory() {
        return this.connectionFactory;
    }
}
