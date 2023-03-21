package com.llit;

import com.llit.controllers.CheapkaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackageClasses = CheapkaController.class)
public class CheapkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheapkaApplication.class, args);

        System.out.println("works");
    }

}
