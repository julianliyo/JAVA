package com.julian.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.lookify.models.cancionmodels;

@Repository
public interface cancionrepo extends CrudRepository<cancionmodels, Long>{
	

    List<cancionmodels> findAll();

    List<cancionmodels> findByArtista(String artista);

    List<cancionmodels> findTop10ByOrderByCalificacionDesc();

    
    
    
	

}