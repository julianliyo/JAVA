package com.julian.lista.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.lista.models.estudiante;

@Repository
public interface estudianterepo extends CrudRepository<estudiante, Long> {
	
	List<estudiante> findAll();
	
	List<estudiante> findBycontactIsNull();
	
	Optional<estudiante> findById(Long id);

}