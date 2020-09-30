package edu.escuelaing.eci.arsw.gooffer.repository;



import edu.escuelaing.eci.arsw.gooffer.model.Palabra;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PalabraRepository extends JpaRepository<Palabra,Integer>{
	/*
    void addPalabra(Palabra palabra);
    void editPalabra(Palabra palabra);
    void deletePalabra(int id);
    List<Palabra> findAllPalabra();
    Palabra getPalabraById(String id);
    */
}
