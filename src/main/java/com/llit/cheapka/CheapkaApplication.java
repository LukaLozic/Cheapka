package com.llit.cheapka;

import controllers.CheapkaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackageClasses = CheapkaController.class)
public class CheapkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheapkaApplication.class, args);

        System.out.println("works");
    }

}
