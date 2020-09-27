package edu.escuelaing.eci.arsw.gooffer.repository;


import edu.escuelaing.eci.arsw.gooffer.model.Servicio;

import java.util.List;

public interface ServicioRepository   {
    void addServicio(Servicio servicio);
    void editServicio(Servicio servicio);
    void deleteServicio(int id);
    List<Servicio> findAllServicio();
    Servicio getServicioById(String id);

}
