package edu.escuelaing.eci.arsw.gooffer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.eci.arsw.gooffer.model.Palabra;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.PalabraRepositoryImpl;

@Service
public class PalabraServices {
	@Autowired
    private PalabraRepositoryImpl palabraRepository;

	public List<Palabra> findAllPalabras(){
        return palabraRepository.findAllPalabras();
    }
    public void savePalabra(Palabra palabra){ palabraRepository.savePalabra(palabra);}
}
