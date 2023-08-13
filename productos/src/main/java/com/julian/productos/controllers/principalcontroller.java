package com.julian.productos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.julian.productos.services.procatservices;

@Controller
public class principalcontroller {
	
	private final procatservices mainServ;
	public principalcontroller(procatservices mainS) {
		this.mainServ = mainS;
	}

	@GetMapping("/")
	public String root(Model modelo) {
		modelo.addAttribute("productos", mainServ.todosProductos() );
		return "index.jsp";
	}
	
}