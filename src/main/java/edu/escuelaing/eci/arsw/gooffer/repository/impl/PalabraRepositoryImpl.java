package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import edu.escuelaing.eci.arsw.gooffer.model.Palabra;
import edu.escuelaing.eci.arsw.gooffer.repository.PalabraRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PalabraRepositoryImpl implements PalabraRepository {
    @Override
    public void addPalabra(Palabra palabra) {

    }

    @Override
    public void editPalabra(Palabra palabra) {

    }

    @Override
    public void deletePalabra(int id) {

    }

    @Override
    public List<Palabra> findAllPalabra() {
        return null;
    }

    @Override
    public Palabra getPalabraById(String id) {
        return null;
    }
}
