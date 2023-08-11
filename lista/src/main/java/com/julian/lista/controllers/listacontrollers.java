package com.julian.lista.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.julian.lista.models.contact;
import com.julian.lista.models.estudiante;
import com.julian.lista.services.listaservices;

import jakarta.validation.Valid;

@Controller
public class listacontrollers {
	
	// INYECCION DEPENDENCIAS 
		@Autowired
		private listaservices listaservices;
		
		@GetMapping("/")
		public String raiz() {
			return "redirect:/estudiantes";
			
		}
		
		@GetMapping("/estudiantes")
		public String root(Model viewModel) {
			
			List<estudiante> estudiante = listaservices.allestudiantes();
			viewModel.addAttribute("estudiante", estudiante);
			return "index.jsp";
		}

		@GetMapping("/estudiantes/new")
		public String formularioEstudiante(@ModelAttribute("estudiante") estudiante estudiante) {
			return "nuevoestudiante.jsp";
		}

		@PostMapping("/estudiantes/new")
		public String crearEstudiante(@Valid @ModelAttribute("estudiante") estudiante estudiante, BindingResult resultado) {
			if (resultado.hasErrors()) {

				return "nuevoestudiante.jsp";
			}
			listaservices.crearestudiante(estudiante);
			return "redirect:/";

		}

		@GetMapping("/contact/new")
		public String formularioContact(@ModelAttribute("contact") contact contact, Model viewModel) {
			viewModel.addAttribute("estudiantes", listaservices.estudiantesincontact());
			return "nuevocontacto.jsp";
		}
		
		@PostMapping("/contact/new")
		public String crearContacto(@Valid @ModelAttribute("contact") contact contact, BindingResult resultado) {
			if (resultado.hasErrors()) {

				return "nuevocontacto.jsp";
			}
			listaservices.crearcontact(contact);
			return "redirect:/";

		}
}