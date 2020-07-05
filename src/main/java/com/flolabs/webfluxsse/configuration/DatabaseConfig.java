//package com.flolabs.webfluxsse.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
//import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
//import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
//import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//import org.springframework.transaction.ReactiveTransactionManager;
//
//import io.r2dbc.h2.H2ConnectionFactory;
//import io.r2dbc.spi.ConnectionFactory;
//
//@Configuration
//@EnableR2dbcRepositories
//public class DatabaseConfig extends AbstractR2dbcConfiguration {
//
//	@Override
//	@Bean
//	public ConnectionFactory connectionFactory() {
//		return H2ConnectionFactory.inMemory("testdb;DB_CLOSE_DELAY=-1");
//	}
//
//	@Bean
//	ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
//		return new R2dbcTransactionManager(connectionFactory);
//	}
//
//	@Bean
//	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
//
//		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//		initializer.setConnectionFactory(connectionFactory);
//
//		CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
//		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
//		initializer.setDatabasePopulator(populator);
//
//		return initializer;
//	}
//
//}