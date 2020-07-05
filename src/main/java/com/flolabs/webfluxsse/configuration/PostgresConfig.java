package com.flolabs.webfluxsse.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class PostgresConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder().host("localhost").port(5432)
				.username("postgres").password("Shreya123").database("flolabs").build());
	}

}
