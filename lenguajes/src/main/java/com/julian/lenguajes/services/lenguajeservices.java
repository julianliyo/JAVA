package com.julian.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.lenguajes.models.LenguajeModel;
import com.julian.lenguajes.repositories.lenguajerepo;

import jakarta.validation.Valid;

@Service
public class lenguajeservices {

    
    @Autowired 
    private lenguajerepo lenguajerepo;

    public List<LenguajeModel> alllenguajes() {
        return lenguajerepo.findAll();
    }

    public LenguajeModel createlenguaje(LenguajeModel b) {
    		return lenguajerepo.save(b);
    		
    }

    public LenguajeModel findlenguaje(Long id) {
        Optional<LenguajeModel> optionalBook = lenguajerepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    

    public LenguajeModel actualizarlenguaje(LenguajeModel lenguaje) {
    	LenguajeModel temporal = findlenguaje(lenguaje.getId());
    	temporal.setName(lenguaje.getName());
    	temporal.setCreator(lenguaje.getCreator());
    	temporal.setVersion(lenguaje.getVersion());;
    	return lenguajerepo.save(temporal);
    }
    

    public LenguajeModel actualizarlenguaje(Long id, 
    		String name, 
    		String creator, 
    		double version) {
    	LenguajeModel temporal = lenguajerepo.findById(id).orElse(null);
    	if(temporal != null) {
    		temporal.setName(name);
    		temporal.setCreator(creator);
    		temporal.setVersion(version);		
    		lenguajerepo.save(temporal);
    		return temporal;
    	}else {
    		
    		return temporal;
    	}
    }
    
    

    public void borrarlenguaje(Long id) {
    	lenguajerepo.deleteById(id);
    }


    
}