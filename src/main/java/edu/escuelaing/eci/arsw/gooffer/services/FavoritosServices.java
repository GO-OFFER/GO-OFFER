package edu.escuelaing.eci.arsw.gooffer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.eci.arsw.gooffer.model.Favorito;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.*;

@Service
public class FavoritosServices {
	
	
	 @Autowired
	    private FavoritoRepositoryImpl favorito;

	 
	 
	 public List<Favorito> findAllFavoritos(){
	        return favorito.findAllFavoritos();
	    }



	public void saveFavorito(Favorito fav) {
		favorito.save(fav);
	}



	public List<Favorito> findFavoritosById(int id) {
		return favorito.FindById(id);
	}
}
