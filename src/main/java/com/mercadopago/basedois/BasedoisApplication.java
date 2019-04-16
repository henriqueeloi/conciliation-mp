package com.mercadopago.basedois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource({"classpath*:beanio-job.xml"})
public class BasedoisApplication {

	public static void main(String[] args) {

		SpringApplication.run(BasedoisApplication.class, args);
	}

}
