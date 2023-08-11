package com.julian.lookify.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.julian.lookify.models.cancionmodels;
import com.julian.lookify.services.cancionservices;

@Controller
public class cancionescontroller {
	
	@Autowired
	cancionservices cancionservices;
	
	//RETORNA A PÁGINA PRINCIPAL
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//PÁGINA PRINCIPAL
	@GetMapping("/dashboard")
	public String dashboard(String artist, Model model) {
		List<cancionmodels> cancion = cancionservices.allcanciones();
		model.addAttribute("cancion", cancion);
		return "dashboard.jsp";
	}
	
	
	//NUEVA CANCIÓN
	@GetMapping("/cancion/nuevo")
	public String addSong(@ModelAttribute("cancion") cancionmodels cancion) {
		return "agregar.jsp";
	}
	
	@PostMapping("/cancion/nuevo")
	public String addSong(@Valid @ModelAttribute("cancion") cancionmodels cancion, BindingResult result) {
		if(result.hasErrors()) {
			return "agregar.jsp";
		}else {
			cancionservices.crearcancion(cancion);
			return "redirect:/dashboard";
		}
	}
	
	//INFORMACION ESPECÍFICA DE UNA CANCIÓN
	@GetMapping("/cancion/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		cancionmodels cancion = cancionservices.findCancion(id);
		model.addAttribute("cancion", cancion);
		return "detalles.jsp";
	}
	
	
	//TOP 10 DE CANCIONES
	@GetMapping("/top10")
	public String details(Model model) {
		List<cancionmodels> cancion = cancionservices.top10();
		model.addAttribute("cancion", cancion);
		return "top.jsp";
	}
	
	
	//BORRAR UNA CANCION
	@GetMapping("/cancion/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		cancionservices.eliminarcancion(cancionservices.findCancion(id));
		return "redirect:/dashboard";
	}
	
	//BUSCAR POR ARTISTA
	@GetMapping("/buscar")
	public String search(@RequestParam(name = "q", required = false) String artista, Model model) {
		if (artista == null || artista.isEmpty()) {
			return "redirect:/dashboard";
		}
		List<cancionmodels> cancion = cancionservices.findPorArtista(artista);
		model.addAttribute("cancion", cancion);
		
		return "buscar.jsp";
	}
}