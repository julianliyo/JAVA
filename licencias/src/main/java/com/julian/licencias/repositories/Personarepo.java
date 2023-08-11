package com.julian.licencias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.licencias.models.personamodels;

@Repository
public interface Personarepo extends CrudRepository<personamodels, Long> {
	
	List<personamodels> findAll();
	
	
	@Query(value="SELECT p.* FROM persona p LEFT OUTER JOIN licencia l ON p.id=l.persona_id WHERE l.id IS NULL", nativeQuery=true)
	List<personamodels> encontrarNoLic();
	
	List<personamodels> findByLicenciaIdIsNull();
	
	

}