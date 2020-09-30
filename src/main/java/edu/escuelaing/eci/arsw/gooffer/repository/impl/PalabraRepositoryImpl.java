package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import edu.escuelaing.eci.arsw.gooffer.model.Palabra;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.PalabraRepository;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PalabraRepositoryImpl{
	
	@Autowired
	PalabraRepository palabraRepository;
	 
	 public List<Palabra> findAllPalabras() {
	       return palabraRepository.findAll();
	  }
    
}
