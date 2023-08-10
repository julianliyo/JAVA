package com.julian.lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julian.lenguajes.models.LenguajeModel;
import com.julian.lenguajes.services.lenguajeservices;

@RestController
public class lenguajeapi {
	
	@Autowired
	private lenguajeservices lenguajeservices;
	
    //muestra todos los lenguajes
    @GetMapping("/api/lenguajes")
    public List<LenguajeModel> index() {
        return lenguajeservices.alllenguajes();
    }
    
	//creas un lenguaje
    @PostMapping(value="/api/lenguajes")
    public LenguajeModel create(@RequestParam(value="lenguaje") String name, 
    		@RequestParam(value="creator") String creator, 
    		@RequestParam(value="version") double version) {
    	LenguajeModel lenguaje = new LenguajeModel(name, creator, version);
        return lenguajeservices.createlenguaje(lenguaje);
    }
    
    // muestra info lenguaje
    @GetMapping("/api/lenguajes/{id}")
    public LenguajeModel show(@PathVariable("id") Long id) {
    	LenguajeModel language = lenguajeservices.findlenguaje(id);
        return language;
    }
    
    //actualizar info lenguaje
    @PutMapping("/api/lenguajes/{id}")
    public LenguajeModel actualizar(@PathVariable("id")Long id,
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="creator") String creator,
    		@RequestParam(value="version") double version) {
    	LenguajeModel lenguaje = new LenguajeModel(id, name, creator, version);
        return lenguajeservices.actualizarlenguaje(lenguaje);

    }

    //BORRAR LENGUAJE
    @DeleteMapping("/api/lenguajes/{id}")
    public void borrarRegistro(@PathVariable("id")Long id) {
    	lenguajeservices.borrarlenguaje(id);
    }
}