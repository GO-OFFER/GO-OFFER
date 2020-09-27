package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import edu.escuelaing.eci.arsw.gooffer.model.Palabra;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class ServicioRepositoryImpl implements ServicioRepository {

    @Override
    public void addServicio(Servicio servicio) {

    }

    @Override
    public void editServicio(Servicio servicio) {

    }

    @Override
    public void deleteServicio(int id) {

    }

    @Override
    public List<Servicio> findAllServicio() {
        return null;
    }

    @Override
    public Servicio getServicioById(String id) {
        return null;
    }
}
