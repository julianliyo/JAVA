package com.julian.productos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.julian.productos.models.productocategoriamodel;
import com.julian.productos.services.procatservices;
import com.julian.productos.models.productomodel;


import jakarta.validation.Valid;

@Controller
public class productocontroller {

	// INYECCION DE DEPENDECIAS
	private final procatservices mainServ;
	public productocontroller(procatservices service) {
		this.mainServ = service;
	}
	
	@GetMapping("/products/new")
	public String formProduct(@ModelAttribute("producto") productomodel producto) {
		return "producto.jsp";
	}
	
	@PostMapping("/products/new")
	public String nuevoProduct(@Valid @ModelAttribute("producto") productomodel producto, 
			BindingResult resultado) {
		if (resultado.hasErrors()) {

			return "producto.jsp";
		}
		mainServ.crearProducto(producto);
		return "redirect:/";
	}
	
	@GetMapping("/product/{idProduct}")
	public String mostrarProducto(@PathVariable("idProduct") Long idProduct,
			@ModelAttribute("asociacion") productocategoriamodel asociacion,
			Model modelo) {
		productomodel producto = mainServ.unProducto(idProduct);
		modelo.addAttribute("categorias", mainServ.productoSinCategoria(producto));
		modelo.addAttribute("producto",producto);
		System.out.println(producto.getCategories().size());
		return "mostrar.jsp";
	}
	
	
}