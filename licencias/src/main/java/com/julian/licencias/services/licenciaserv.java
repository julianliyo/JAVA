package com.julian.licencias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.licencias.models.licenciamodels;

import com.julian.licencias.models.personamodels;
import com.julian.licencias.repositories.licenciarepo;
import com.julian.licencias.repositories.Personarepo;

@Service
public class licenciaserv {
	
	// Inyeccion Dependencias
	@Autowired
	private licenciarepo licenciaRepo;
	
	@Autowired 
	private Personarepo personaRepo;
	
	
	//SERVICIOS PARA PERSONA
	public personamodels crearPersona(personamodels persona) {
		return personaRepo.save(persona);
	}
	
	public List<personamodels> todasPersonas(){
		return personaRepo.findAll();
	}
	
	
	//SERVICIOS PARA LICENCIA
	public licenciamodels crearLicencia(licenciamodels licencia) {
		licencia.setNumber(this.generarNumerLic());
		return licenciaRepo.save(licencia);
	}
	
	public List<personamodels> obtenerPersonasSinLic(){
		return personaRepo.findByLicenciaIdIsNull();
//		return personaRepo.encontrarNoLic();
	}
	
	
	//Metodo para generar numero de licencia
	public int generarNumerLic() {
		licenciamodels lic = licenciaRepo.findTopByOrderByNumberDesc();
		if(lic ==null) {
			return 1;
		}
		int numeroMayorLicencia = lic.getNumber();
		numeroMayorLicencia++;
		return numeroMayorLicencia;
		
	}
    public personamodels buscarPersonaPorId(Long id) {
        Optional<personamodels> optionalPersona = personaRepo.findById(id);
        return optionalPersona.orElse(null);
    }

}