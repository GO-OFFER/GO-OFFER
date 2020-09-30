package edu.escuelaing.eci.arsw.gooffer.repository.impl;


import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ServicioRepositoryImpl{

	 @Autowired
	 ServicioRepository servicioRepository;
	 
	 public List<Servicio> findAllServices() {
	       return servicioRepository.findAll();
	  }

   
}
