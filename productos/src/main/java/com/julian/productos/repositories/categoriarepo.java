package com.julian.productos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.julian.productos.models.categoriamodel;
import com.julian.productos.models.productomodel;

public interface categoriarepo extends CrudRepository<categoriamodel, Long>{

	List<categoriamodel> findByProductsNotContains(productomodel producto);
}