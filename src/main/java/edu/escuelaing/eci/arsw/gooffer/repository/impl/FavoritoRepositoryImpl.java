package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Favorito;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.FavoritoRepository;

@Component
public class FavoritoRepositoryImpl {
	
	@Autowired
	FavoritoRepository favoritoRepository;
	
	public List<Favorito> findAllFavoritos() {
        return  favoritoRepository.findAll();
    }

	public void save(Favorito fav) {
		favoritoRepository.save(fav);
	}

	public List<Favorito> FindById(int id) {
		
		List<Favorito> res= new ArrayList<Favorito>();
		for (Favorito c: favoritoRepository.findAll()) {
			if(c.getIdusuario()==id) {
				res.add(c);
				
			}
		}
		
		
		
		return  res;
	}

}
