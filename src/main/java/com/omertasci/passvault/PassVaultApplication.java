package com.omertasci.passvault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan({"com.omertasci.passvault.controller, com.omertasci.passvault.service, com.omertasci.passvault.security"})
@EntityScan("com.omertasci.passvault.entity")
@EnableJpaRepositories("com.omertasci.passvault.repository")
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableMethodSecurity
public class PassVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassVaultApplication.class, args);
	}

}
