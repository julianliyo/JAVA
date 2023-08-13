package com.julian.productos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.julian.productos.models.categoriamodel;
import com.julian.productos.services.procatservices;

import jakarta.validation.Valid;

@Controller
public class categoriacontroller {
	// INYECCION DE DEPENDECIAS
		private final procatservices mainServ;
		public categoriacontroller(procatservices service) {
			this.mainServ = service;
		}
		
		@GetMapping("/categories/new")
		public String formProduct(@ModelAttribute("categoria") categoriamodel categoria) {
			return "categoria.jsp";
		}
		
		@PostMapping("/categories/new")
		public String nuevoProduct(@Valid @ModelAttribute("categoria") categoriamodel categoria, 
				BindingResult resultado) {
			if (resultado.hasErrors()) {

				return "categoria.jsp";
			}
			mainServ.crearCategoria(categoria);
			return "redirect:/";
		}

}