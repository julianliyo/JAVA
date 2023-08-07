package com.julian.bookapia.controllers;

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

import com.julian.bookapia.models.bookmodel;
import com.julian.bookapia.services.bookservices;

import jakarta.validation.Valid;

@Controller
public class bookcontroll {


	@Autowired
	private bookservices bookservices;

	@GetMapping("/")
	public String raiz() {
		return "redirect:/books";

	}


	@GetMapping("/books")
	public String index(Model model) {
		List<bookmodel> books = bookservices.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}


	@GetMapping("/books/new")
	public String formularioLibro(@ModelAttribute("libro") bookmodel book) {
		return "/books/crealibro.jsp";
	}

	@PostMapping("/books")
	public String crearLibro(@Valid @ModelAttribute("libro") bookmodel book, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			return "/books/crealibro.jsp";
		} else {
			bookservices.createBook(book);
			return "redirect:/books";
		}
	}

	
	@DeleteMapping("/books/{id}")
	public String destroy(@PathVariable("id") Long id) {
		bookservices.borrarRegistro(id);
		return "redirect:/books";
	}
	

	@GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        bookmodel book = bookservices.findBook(id);
        model.addAttribute("libro", book);
        return "/books/editar.jsp";
      
    }
    
    @GetMapping("/books/{id}")
    public String show(@PathVariable Long id, Model model) {
        bookmodel book = bookservices.findBook(id);

        if (book != null) {
            model.addAttribute("libro", book);
            return "books/editar.jsp"; 
        } else {
            return "redirect:/books"; 
    }
}
}
