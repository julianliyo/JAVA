package com.julian.productos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.julian.productos.models.productomodel;


public interface productorepo extends CrudRepository<productomodel, Long>{
	
List<productomodel> findAll();
}