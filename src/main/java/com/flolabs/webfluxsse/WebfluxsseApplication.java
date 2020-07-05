package com.flolabs.webfluxsse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.flolabs.webfluxsse")
@EnableR2dbcRepositories
public class WebfluxsseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxsseApplication.class, args);
	}

}
