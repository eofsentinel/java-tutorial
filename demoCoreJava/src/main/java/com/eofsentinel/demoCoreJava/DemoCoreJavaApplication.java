package com.eofsentinel.demoCoreJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoCoreJavaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoCoreJavaApplication.class, args);

		Dev obj = context.getBean(Dev.class);
		obj.setComputer("desktop");

		obj.build();
	}

}
