package com.julian.licencias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.licencias.models.licenciamodels;


@Repository
public interface licenciarepo extends CrudRepository<licenciamodels, Long>{
	
	public licenciamodels findTopByOrderByNumberDesc();

}