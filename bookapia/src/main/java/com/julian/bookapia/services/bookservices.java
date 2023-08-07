package com.julian.bookapia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.bookapia.models.bookmodel;
import com.julian.bookapia.repositories.repo;

@Service
public class bookservices {


    
    @Autowired 
    private repo repo;

    public List<bookmodel> allBooks() {
        return repo.findAll();
    }

    public bookmodel createBook(bookmodel b) {
    		return repo.save(b);
    		
    }

    public bookmodel findBook(Long id) {
        Optional<bookmodel> optionalBook = repo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    

    public bookmodel actualizarLibro(bookmodel libro) {
    	bookmodel temporal = findBook(libro.getId());
    	temporal.setDescription(libro.getDescription());
    	temporal.setLanguage(libro.getLanguage());
    	temporal.setNumberOfPages(libro.getNumberOfPages());
    	temporal.setTitle(libro.getTitle());
    	return repo.save(temporal);
    }
    

    public bookmodel actualizarLibro(Long id, 
    		String title, 
    		String desc, 
    		String lang, 
    		Integer numOfPages) {
    	bookmodel temporal = repo.findById(id).orElse(null);
    	if(temporal != null) {
    		temporal.setDescription(desc);
    		temporal.setLanguage(lang);
    		temporal.setNumberOfPages(numOfPages);
    		temporal.setTitle(title);
    		
    		repo.save(temporal);
    		return temporal;
    	}else {
    		
    		return temporal;
    	}
    }
    
    

    public void borrarRegistro(Long id) {
    	repo.deleteById(id);
    }
    
    
}