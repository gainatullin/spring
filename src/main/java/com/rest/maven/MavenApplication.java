package com.rest.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication(scanBasePackages="com.rest.maven")
@EnableJpaRepositories("com.rest.maven.*")
@ComponentScan(basePackages = { "com.rest.maven.*" })
@EntityScan("com.rest.maven.entity")
public class MavenApplication {
	public static void main(String[] args) {
		SpringApplication.run(MavenApplication.class, args);
		System.out.println("SUCCESS");
	}


}
