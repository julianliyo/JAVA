package com.julian.productos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.julian.productos.models.productocategoriamodel;
import com.julian.productos.services.procatservices;

@Controller
public class productocategoriacontroller {
	
	//INYECTAR DEPENDECIAS
	private final procatservices mainServ;
	public productocategoriacontroller(procatservices mainS) {
		this.mainServ = mainS;
	}
	

	@PostMapping("/aso/{idProducto}")
	public String asociarProductoCategoria(@PathVariable("idProducto") Long idProducto,
			@ModelAttribute("asociacion") productocategoriamodel productosCategorias,
			Model viewModel, BindingResult resultado) {
		
		if(resultado.hasErrors()) {
			return "mostrar.jsp";
		}
		mainServ.crearVinculo(productosCategorias);
		return "redirect:/product/"+idProducto;
		
	}
	
	
	
}