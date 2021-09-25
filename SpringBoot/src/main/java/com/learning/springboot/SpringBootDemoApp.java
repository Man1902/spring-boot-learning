package com.learning.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ComponentScan("com.learning.springboot")
@EnableJpaRepositories("com.learning.springboot.dao")
@EntityScan("com.learning.springboot.vo")*/
public class SpringBootDemoApp implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApp.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
