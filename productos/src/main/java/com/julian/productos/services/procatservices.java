package com.julian.productos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.julian.productos.models.productocategoriamodel;
import com.julian.productos.models.categoriamodel;
import com.julian.productos.models.productomodel;

import com.julian.productos.repositories.productorepo;
import com.julian.productos.repositories.productocategoriarepo;
import com.julian.productos.repositories.categoriarepo;

@Service
public class procatservices {

	// INYECCION DE DEPENDECIAS
		private final productorepo productoRepo;
		private final categoriarepo categoriaRepo;
		private final productocategoriarepo procatRepo;
		public procatservices(productorepo pRe, categoriarepo cRe, productocategoriarepo pCRe) {
			this.productoRepo = pRe;
			this.categoriaRepo = cRe;
			this.procatRepo = pCRe;
		}
		
		

		public productomodel crearProducto(productomodel producto) {
			return productoRepo.save(producto);
		}
		public categoriamodel crearCategoria(categoriamodel categoria) {
			return categoriaRepo.save(categoria);
		}
		public productocategoriamodel crearVinculo(productocategoriamodel productoCategorias) {
			return procatRepo.save(productoCategorias);
		}
		

		public List<categoriamodel> productoSinCategoria(productomodel producto){
			return categoriaRepo.findByProductsNotContains(producto);
		}
		
		public productomodel unProducto(Long id) {
			return productoRepo.findById(id).orElse(null);
		}
		
		public List<productomodel> todosProductos(){
			return productoRepo.findAll();
		}
	
}