package edu.escuelaing.eci.arsw.gooffer.services;

import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosServices {

    @Autowired
    private ServicioRepository servicio;

    public Servicio getServicioById(String id){
        return servicio.getServicioById(id);
    }
    public void addServicio(Servicio servicio){

    }
    public void editServicio(Servicio servicio){

    }
    public void deleteServicio(int id){

    }
    public List<Servicio> findAllServicio(){
        return servicio.findAllServicio();
    }

}
