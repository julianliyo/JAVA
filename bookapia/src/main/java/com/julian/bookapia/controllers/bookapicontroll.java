package com.julian.bookapia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julian.bookapia.models.bookmodel;
import com.julian.bookapia.services.bookservices;

@RestController
public class bookapicontroll {
	
	

	    
	    @Autowired
	    private bookservices bookservice;

	    @GetMapping("/api/books")
	    public List<bookmodel> index() {
	        return bookservice.allBooks();
	    }

	    @PostMapping(value="/api/books")
	    public bookmodel create(@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	        bookmodel book = new bookmodel(title, desc, lang, numOfPages);
	        return bookservice.createBook(book);
	    }
	    

	    @GetMapping("/api/books/{id}")
	    public bookmodel show(@PathVariable("id") Long id) {
	        bookmodel book = bookservice.findBook(id);
	        return book;
	    }

	    @PutMapping("/api/books/{id}")
	    public bookmodel actualizar(@PathVariable("id")Long id,
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	bookmodel book = new bookmodel(id, title, desc, lang,numOfPages);
	    	return bookservice.actualizarLibro(book);
	    	
	    }
	    
	    

	    @DeleteMapping("/api/books/{id}")
	    public void borrarRegistro(@PathVariable("id")Long id) {
	    	bookservice.borrarRegistro(id);
	    }
	    	
	    

	
}