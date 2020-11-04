package edu.escuelaing.eci.arsw.gooffer.repository.impl;


import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service 
public class ServicioRepositoryImpl{

	 @Autowired
	 ServicioRepository servicioRepository;
	 
	 public List<Servicio> findAllServices() {
	       return servicioRepository.findAll();
	  }
	  public void saveServicio(Servicio servicio) {
		  LocalDate creationDate = LocalDate.now();
		  
		  servicio.setCreacion(Date.valueOf(creationDate));
		  
		  servicioRepository.save(servicio);
	}
	public List<Servicio> findServiciosById(int id) {
		List<Servicio> lista= new ArrayList<Servicio>();
		for (Servicio s: servicioRepository.findAll()) {
			if(s.getIdVendedor()==id) {
				lista.add(s);
			}
		}
		return lista;
	}
	public void delete(int id) {
		servicioRepository.deleteById(id);
	}
	public void update(Servicio servi) {
		//servicioRepository.updateById(servi.getId(),servi.getDescripcion());
		Servicio s=servicioRepository.findById(servi.getId()).get();
		s.setDescripcion(servi.getDescripcion());
		servicioRepository.save(s);
	}
	public Optional<Servicio> findServiciosByIdAndName(int id) {
		return servicioRepository.findById(id);
	}

   
}
