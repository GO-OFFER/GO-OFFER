package edu.escuelaing.eci.arsw.gooffer.services;

import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.cache.*;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.ServicioRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosServices {

    @Autowired
    private ServicioRepositoryImpl servicio;
    
    @Autowired
    @Qualifier("GoofferCacheImpl")
    private GoofferCache goofferCache;

    /* public Servicio getServicioById(String id){
        return servicio.getServicioById(id);
    }*/
    public void addServicio(Servicio servicio){

    }
    public void editServicio(Servicio servicio){

    }
    public void deleteServicio(int id){
    	servicio.delete(id);
    }
    public List<Servicio> findAllServices(){
        return servicio.findAllServices();
    }

    public void saveServicio(Servicio servi){
        servicio.saveServicio(servi);
    }
	public List<Servicio> findServiciosById(int id) {
		return servicio.findServiciosById(id);
	}
	public void update(Servicio servi) {
		servicio.update(servi);
		
	}
	public Optional<Servicio> findServiciosByIdAndName(int id) {
		return servicio.findServiciosByIdAndName(id);
	}
	public boolean hayServiciosCache() {
		return goofferCache.hayServiciosCache();
	}
	public List<Servicio> getServiciosCache() {
		return goofferCache.getServiciosCache();
		
	}
	public void postServiciosCache(List<Servicio> servicios) {
		goofferCache.postServiciosCache(servicios);
	}
	public void postServicioCache(Servicio servicio2) {
		goofferCache.postServicioCache(servicio2);
	}
	public boolean existServicioCache(int id) {
		return goofferCache.existServicioCache(id);
	}
	public void deleteServicioCache(int id) {
		goofferCache.deleteServicioCache(id);
	}
	public void putServicioCache(Servicio servi) {
		goofferCache.putServicioCache(servi);
	}

}
