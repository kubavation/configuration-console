package com.durys.jakub.configurationconsole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ConfigurationConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationConsoleApplication.class, args);
	}

}
