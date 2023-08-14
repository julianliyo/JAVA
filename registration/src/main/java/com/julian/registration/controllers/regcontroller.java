package com.julian.registration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.julian.registration.models.LogReg;
import com.julian.registration.models.User;
import com.julian.registration.services.userServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class regcontroller {
	
	private final userServices userServ;
	public regcontroller(userServices uSer) {
		this.userServ = uSer;
	}
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		return "registration.jsp";
	}
	
	
	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") User usuario,
			BindingResult resultado, Model viewModel ) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("login", new LogReg());
			return "registration.jsp";
		}
		User usuarioRegistrado = userServ.registroUsuario(usuario, resultado);
		viewModel.addAttribute("login", new LogReg());
		if(usuarioRegistrado != null) {
			viewModel.addAttribute("registro", "Gracias por registrarte, ahora login por favor");
		}
		return "registration.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LogReg loginuser,
			BindingResult resultado, Model viewModel, HttpSession sesion) {
		if (resultado.hasErrors()) {
			viewModel.addAttribute("user", new User());
			return "registration.jsp";
		}
		
		if(userServ.authenthicateUser(
				loginuser.getEmail(), 
				loginuser.getPassword(), 
				resultado )) {
			User usuarioLog = userServ.encontrarPorEmail(loginuser.getEmail());
			sesion.setAttribute("userID",usuarioLog.getId());
			return "redirect:/dashboard";
		}else {
			viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
			viewModel.addAttribute("user", new User());
			return "registration.jsp";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String bienvenida(HttpSession sesion, Model viewModel) {
		Long userId =  (Long) sesion.getAttribute("userID");
		if(userId == null ) {
			return "redirect:/";
		}
		User usuario = userServ.encontrarUserPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		return "index.jsp";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.setAttribute("userID", null);
		return "redirect:/";
	}

}