package com.mns.cda.filsrouge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FilsRougeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilsRougeApplication.class, args);
    }

}
