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
		return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder().host("ec2-52-200-48-116.compute-1.amazonaws.com").port(5432)
				.username("lazcssygxpfcip").password("f2a6a7a883a44493de1388439d6748d9dbaa20faaccd8c116424e495ae64af78").database("d764agnlackhlq").build());
	}

}
