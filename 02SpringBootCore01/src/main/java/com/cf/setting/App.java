package com.cf.setting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@Configuration  
//@EnableAutoConfiguration  
//@ComponentScan  

public class App {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		SpringApplication.run(App.class, args);

	}
}
