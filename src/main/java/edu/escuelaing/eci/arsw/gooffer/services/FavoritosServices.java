package edu.escuelaing.eci.arsw.gooffer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.escuelaing.eci.arsw.gooffer.cache.GoofferCache;
import edu.escuelaing.eci.arsw.gooffer.model.Favorito;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.*;

@Service
public class FavoritosServices {
	
	
	 @Autowired
	    private FavoritoRepositoryImpl favorito;

	 @Autowired
	    @Qualifier("GoofferCacheImpl")
	    private GoofferCache goofferCache;
	 
	 public List<Favorito> findAllFavoritos(){
	        return favorito.findAllFavoritos();
	    }



	public void saveFavorito(Favorito fav) {
		favorito.save(fav);
	}



	public List<Favorito> findFavoritosById(int id) {
		return favorito.FindById(id);
	}



	public boolean hayFavoritosCache(int id) {
		
		return goofferCache.hayFavoritosCache(id);
	}



	public List<Favorito> getFavoritosCache(int id) {
		return goofferCache.getFavoritosCache(id);
	}



	public void postFavoritosCache(int id, List<Favorito> favortios) {
		goofferCache.postFavoritosCache(id,favortios);
	}



	public void postFavoritoCache(Favorito fav) {
		goofferCache.postFavoritoCache(fav);
	}
}
