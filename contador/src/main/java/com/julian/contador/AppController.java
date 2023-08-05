package com.julian.contador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
@SpringBootApplication
public class AppController {
	
	public static void main(String[] args) {
		SpringApplication.run(AppController.class, args);
	}

	private void setCounterSession(HttpSession session, int veces) {
		session.setAttribute("counter", veces);
	}
	

	private int getCounterSession(HttpSession session) {
		Object counter = session.getAttribute("counter");
		if (counter == null) {
			setCounterSession(session, 0);
			counter = session.getAttribute("counter");
		}
		return (int) counter;
	}

	@GetMapping("/")
	public String index(HttpSession session) {
		int conteoActual = getCounterSession(session);
		setCounterSession(session, conteoActual + 1);
		
		return "visita.jsp"; 
	}

	@GetMapping("/contador")
	public String contador(HttpSession session, Model model) {
		int contador = getCounterSession(session);
		model.addAttribute("contador", contador);
		return "contador.jsp"; 
	}
}
