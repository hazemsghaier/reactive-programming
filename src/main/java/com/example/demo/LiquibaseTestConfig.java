package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LiquibaseTestConfig {

    @Bean
    public CommandLineRunner testLiquibaseResource(ApplicationContext ctx) {
        return args -> {
            // Chemin exactement comme dans application.yml
            String path = "classpath:db/migration/master-changelog.xml";
            Resource r = ctx.getResource(path);
            System.out.printf("Liquibase changelog resolution [%s] : %s%n",
                    path, r.exists() ? "OK" : "NOT FOUND");
        };
    }

}
