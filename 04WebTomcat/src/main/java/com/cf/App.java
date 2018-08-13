package com.cf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	/**
	 * 针对特定的容器进行配置
	 * TomcatEmbeddedServletContainerFactory -->tomcat
	 * JettyEmbeddedServletContainerFactory -->jetty
	 * 
	 * @return
	 */
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory  tomcat = new TomcatServletWebServerFactory();
		tomcat.setPort(8888);
		
		return tomcat;
	}

}
