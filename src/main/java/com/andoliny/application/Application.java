package com.andoliny.application;

import com.andoliny.dataconfig.ApplicationConfig;
import com.andoliny.scheduller.Schedule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {Application.class,Schedule.class, ApplicationConfig.class}, args);

	}

}
