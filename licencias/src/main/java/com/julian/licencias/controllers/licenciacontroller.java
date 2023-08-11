package com.julian.licencias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.julian.licencias.models.personamodels;
import com.julian.licencias.models.licenciamodels;
import com.julian.licencias.services.licenciaserv;

import jakarta.validation.Valid;

@Controller
public class licenciacontroller {


	@Autowired
	private licenciaserv licenciaserv;
	
	@GetMapping("/")
	public String root(Model viewModel) {
		
		List<personamodels> todosUsuarios = licenciaserv.todasPersonas();
		viewModel.addAttribute("todos", todosUsuarios);
		return "index.jsp";
	}

	@GetMapping("/personas/new")
	public String formularioPersona(@ModelAttribute("persona") personamodels persona) {
		return "nuevapersona.jsp";
	}

	@PostMapping("/personas/new")
	public String crearPersona(@Valid @ModelAttribute("persona") personamodels persona, BindingResult resultado) {
		if (resultado.hasErrors()) {

			return "nuevapersona.jsp";
		}
		licenciaserv.crearPersona(persona);
		return "redirect:/";

	}

	@GetMapping("/licencias/new")
	public String formularioLicencia(@ModelAttribute("licencia") licenciamodels licencia, Model viewModel) {
		viewModel.addAttribute("personas", licenciaserv.obtenerPersonasSinLic());
		return "nuevalicencia.jsp";
	}

	@PostMapping("licencias/new")
	public String crearLicencia(@Valid @ModelAttribute("licencia") licenciamodels licencia, 
			BindingResult resultado, Model viewModel) {
		if (resultado.hasErrors()) {
			viewModel.addAttribute("personas", licenciaserv.obtenerPersonasSinLic());
			return "nuevalicencia.jsp";
		}
		licenciaserv.crearLicencia(licencia);

		return "redirect:/";
	}
	@GetMapping("/licencias/{id}")
	public String mostrarPersona(@PathVariable("id") Long id, Model viewModel) {
		personamodels personaBuscar = licenciaserv.buscarPersonaPorId(id);
	    
	    if (personaBuscar != null) {
	        viewModel.addAttribute("personaBuscar", personaBuscar);
	    } else {
	        viewModel.addAttribute("mensajeError", "id no encontrado");
	    }
	    
	    return "mostrarinfo.jsp";
	}


}