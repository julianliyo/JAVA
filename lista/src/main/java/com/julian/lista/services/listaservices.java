package com.julian.lista.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.lista.models.contact;
import com.julian.lista.models.estudiante;

import com.julian.lista.repositories.contactrepo;
import com.julian.lista.repositories.estudianterepo;


@Service
public class listaservices {

		@Autowired
		private estudianterepo estudianteRepo;
		
		@Autowired 
		private contactrepo contactRepo;
		
		

		public estudiante crearestudiante(estudiante estudiante) {
			return estudianteRepo.save(estudiante);
		}
		
		public List<estudiante> allestudiantes(){
			return estudianteRepo.findAll();
		}
		


		public contact crearcontact(contact contact) {
			return contactRepo.save(contact);
		}
		
		public List<estudiante> estudiantesincontact(){
			return estudianteRepo.findBycontactIsNull();
		}
		
	    public estudiante estudiantePorId(Long id) {
	        Optional<estudiante> optionalEstudiante = estudianteRepo.findById(id);
	        return optionalEstudiante.orElse(null);
	    }
}