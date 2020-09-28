package edu.escuelaing.eci.arsw.gooffer.repository;


import edu.escuelaing.eci.arsw.gooffer.model.Palabra;

import java.util.List;

public interface PalabraRepository{
    void addPalabra(Palabra palabra);
    void editPalabra(Palabra palabra);
    void deletePalabra(int id);
    List<Palabra> findAllPalabra();
    Palabra getPalabraById(String id);
}
