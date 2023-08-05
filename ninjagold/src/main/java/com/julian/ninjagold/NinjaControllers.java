package com.julian.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaControllers {
	
	@GetMapping("/")
	public String irRaiz() {
		return "redirect:/gold";
	}

	@GetMapping("/gold")
	public String raiz(HttpSession sesion, Model model) {
		model.addAttribute("gold", sesion.getAttribute("gold"));
		model.addAttribute("resultados", sesion.getAttribute("resultados"));
		return "index.jsp";
	}
	
	
	@PostMapping("/gold")
	public String enviarOro(HttpSession sesion, @RequestParam(value="lugar")String lugar) {
		

		int oro = 0;
		ArrayList<String> resultados = new ArrayList<String>();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM d yyyy h:mm a");
		

		if(sesion.getAttribute("gold") == null) {
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
		}else {
			oro= (int) sesion.getAttribute("gold");
			resultados =  (ArrayList<String>) sesion.getAttribute("resultados");
		}
		

		if(lugar.equals("farm")) {
			int cantidad = new Random().nextInt(11)+10;
			oro += cantidad;
			resultados.add(0,"Entraste a Farm y aumentas "+ cantidad + " de oro. " + "(" +formatoFecha.format(new Date()) + ")" );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		else if(lugar.equals("cave")) {
			int cantidad = new Random().nextInt(6)+5;
			oro += cantidad;
			resultados.add(0,"Entraste a Cave y aumentas "+ cantidad + " de oro. " + "(" +formatoFecha.format(new Date()) + ")");
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		else if(lugar.equals("house")) {
			int cantidad = new Random().nextInt(3)+3;
			oro += cantidad;
			resultados.add(0,"Entraste a House y aumentas "+ cantidad + " de oro. " + "(" + formatoFecha.format(new Date()) + ")" );
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		else if(lugar.equals("casino")) {
			int cantidad = new Random().nextInt(101)-50;
			oro += cantidad;
			if (cantidad >= 0) {
	            resultados.add(0, "Entraste a Casino y aumentas " + cantidad + " de oro. " + "(" + formatoFecha.format(new Date()) + ")");
	        } else {
	            resultados.add(0, "Entraste a Casino y pierdes " + (-cantidad) + " de oro. " + "(" + formatoFecha.format(new Date()) + ")");
	        }
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
			return "redirect:/gold";
		}
		
		
		return "redirect:/gold";
	}
	
	 @GetMapping("/reset")
	 public String reset(HttpSession sesion) {
		 sesion.invalidate();
		 return "redirect:/gold";
	 }
}