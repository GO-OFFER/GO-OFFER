package edu.escuelaing.eci.arsw.gooffer.services;

import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.ServicioRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosServices {

    @Autowired
    private ServicioRepositoryImpl servicio;

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

}
