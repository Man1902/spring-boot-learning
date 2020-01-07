package com.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ComponentScan("com.learning.springboot")
@EnableJpaRepositories("com.learning.springboot.dao")
@EntityScan("com.learning.springboot.vo")*/
public class SpringBootDemoApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApp.class, args);

	}

}
