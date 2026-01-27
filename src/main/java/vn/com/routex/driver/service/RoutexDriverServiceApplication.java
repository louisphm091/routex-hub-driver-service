package vn.com.routex.driver.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RoutexDriverServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoutexDriverServiceApplication.class, args);
    }
}
