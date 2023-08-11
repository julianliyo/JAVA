package com.julian.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.julian.lookify.models.cancionmodels;
import com.julian.lookify.repositories.cancionrepo;


@Service
public class cancionservices {
    private final cancionrepo cancionrepo;
   
    public cancionservices(cancionrepo cancionrepo){
        this.cancionrepo = cancionrepo;
    }

    //Devolver todas las canciones
    public List<cancionmodels> allcanciones(){
        return cancionrepo.findAll();
    }

    //Crear canción
    public cancionmodels crearcancion(cancionmodels cancion){
        return cancionrepo.save(cancion);
    }

    //Buscar cancion y retornala si esta, sino retorna null
    public cancionmodels findCancion(Long id){
        Optional<cancionmodels> optionalCancion = cancionrepo.findById(id);
        if (optionalCancion.isPresent()){
            return optionalCancion.get();
        }else{
            return null;
        }
    }

    public List<cancionmodels> findPorArtista(String artista){
        return cancionrepo.findByArtista(artista);
    }

    public void eliminarcancion(cancionmodels cancionmodels) {
    	cancionrepo.delete(cancionmodels);
    }
	public List<cancionmodels> top10() {
		return cancionrepo.findTop10ByOrderByCalificacionDesc();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	