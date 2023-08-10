package com.julian.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.lenguajes.models.LenguajeModel;

@Repository
public interface lenguajerepo extends CrudRepository<LenguajeModel, Long>{
	

    List<LenguajeModel> findAll();

    List<LenguajeModel> findByCreatorContaining(String search);

    Long countByNameContaining(String search);

    Long deleteByNameStartingWith(String search);

    
    
	

}