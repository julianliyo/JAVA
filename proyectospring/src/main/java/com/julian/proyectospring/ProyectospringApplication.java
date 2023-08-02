package com.julian.proyectospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication

@RestController
public class ProyectospringApplication {
        public static void main(String[] args) {
                SpringApplication.run(ProyectospringApplication.class, args);
        }
        
        // 1. Anotación
        @RequestMapping("/")
        // 3. Método que se asigna a la Solicitud anterior.
        public String hello() { // 3
                return "Hola, como estas cliente?";
        }
        
        // 1. Anotación
        @RequestMapping("/random")
        // 3. Método que se asigna a la Solicitud anterior.
        public String springbot() { // 3
                return "Spring boot es muy bueno, y es facil de utilizar";
        }
}

