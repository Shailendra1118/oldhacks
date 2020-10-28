package com.tbooking.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Taxi Booking App
 * 
 * @author Shailendra
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.tbooking")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
