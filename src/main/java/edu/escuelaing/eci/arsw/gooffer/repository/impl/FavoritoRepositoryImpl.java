package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Favorito;
import edu.escuelaing.eci.arsw.gooffer.repository.FavoritoRepository;

@Component
public class FavoritoRepositoryImpl {
	
	@Autowired
	FavoritoRepository favoritoRepositoryImpl;
	
	public List<Favorito> findAllFavoritos() {
        return  favoritoRepositoryImpl.findAll();
    }

}
