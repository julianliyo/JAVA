package com.julian.lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.julian.lenguajes.models.LenguajeModel;
import com.julian.lenguajes.services.lenguajeservices;

import jakarta.validation.Valid;

@Controller
public class lenguajecontrollers {


	@Autowired
	private lenguajeservices lenguajeservices;

	@GetMapping("/")
	public String raiz() {
		return "redirect:/lenguajes";

	}


	@GetMapping("/lenguajes")
	public String index(Model model) {
		List<LenguajeModel> lenguaje = lenguajeservices.alllenguajes();
		model.addAttribute("lenguaje", lenguaje);
		return "/lenguajes/index.jsp";
	}


	@PostMapping("/lenguajes")
	public String createOrUpdate(@Valid @ModelAttribute("lenguajes") LenguajeModel lenguajes, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        List<LenguajeModel> lenguaje = lenguajeservices.alllenguajes();
	        model.addAttribute("lenguaje", lenguaje);
	        return "lenguajes/index.jsp"; 
	    } else {
	        lenguajeservices.createlenguaje(lenguajes);
	        return "redirect:/lenguajes";
	    }
	}

    //INFORMACION DE UN LIBRO EN ESPECÍFICO
    @GetMapping("/lenguajes/{id}")
    public String show(@PathVariable Long id, Model model) {
    	LenguajeModel lenguajes = lenguajeservices.findlenguaje(id);

        if (lenguajes != null) {
        	model.addAttribute("lenguaje", lenguajes);
            return "lenguajes/muestra.jsp";
        } else {
            return "redirect:/lenguajes";
        }
    }
    
    //EDITAR UN LENGUAJE
    @GetMapping("/lenguajes/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	LenguajeModel lenguaje = lenguajeservices.findlenguaje(id);
    	model.addAttribute("lenguaje", lenguaje);
    	return "lenguajes/editar.jsp";
    }
    
    @PutMapping(value="/lenguajes/{id}")
    public String update(@Valid @ModelAttribute("lenguajes") LenguajeModel lenguajes, BindingResult result) {
    	if (result.hasErrors()) {
    		return "/lenguajes/editar.jsp";
    	} else {
    		lenguajeservices.actualizarlenguaje(lenguajes);
    		return "redirect:/lenguajes";
    	}
    }
    
    //BORRAR UN LENGUAJE
    @DeleteMapping(value="/lenguajes/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	lenguajeservices.borrarlenguaje(id);
        return "redirect:/lenguajes";
    }
    
}
