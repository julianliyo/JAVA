package com.julian.bookapia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.julian.bookapia.models.bookmodel;

@Repository
public interface repo extends CrudRepository<bookmodel, Long>{
	

    List<bookmodel> findAll();

    List<bookmodel> findByDescriptionContaining(String search);

    Long countByTitleContaining(String search);

    Long deleteByTitleStartingWith(String search);

    
    
	

}