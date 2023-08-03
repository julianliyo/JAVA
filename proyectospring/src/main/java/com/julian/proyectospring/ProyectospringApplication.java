package com.julian.proyectospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication

@RestController
public class ProyectospringApplication {
        public static void main(String[] args) {
                SpringApplication.run(ProyectospringApplication.class, args);
        }

                @RequestMapping("/coding")

                    @GetMapping
                    public String helloCodingDojo() {
                        return "¡Hola Coding Dojo!";
                    }

                    @GetMapping("/coding/python")
                    public String pythonCodingDojo() {
                        return "¡Python/Django fue increíble!";
                    }

                    @GetMapping("/coding/java")
                    public String javaCodingDojo() {
                        return "¡Java/Spring es mejor!";
                    }
                   
                    @RestController
                    public class DojoController {  
                    
                        @GetMapping("/{dojoNombre}")
                        public String getDojoByName(@PathVariable String dojoNombre) {
                            switch (dojoNombre) {
                            case "dojo":
                            	return "¡El Dojo es increíble!";
                                case "burbank-dojo":
                                    return "El Dojo Burbank está localizado al sur de California.";
                                case "san-jose":
                                    return "El Dojo SJ es el cuartel general.";
                            }
							return dojoNombre;
                        }
                    }
}


