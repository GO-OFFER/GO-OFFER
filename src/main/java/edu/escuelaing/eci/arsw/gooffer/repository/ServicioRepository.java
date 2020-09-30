package edu.escuelaing.eci.arsw.gooffer.repository;


import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository  extends JpaRepository<Servicio,Integer> {
    /*void addServicio(Servicio servicio);
    void editServicio(Servicio servicio);
    void deleteServicio(int id);
    List<Servicio> findAllServicio();
    Servicio getServicioById(String id);
    */

}
