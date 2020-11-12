package edu.escuelaing.eci.arsw.gooffer.cache.Impl;



import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import edu.escuelaing.eci.arsw.gooffer.cache.GoofferCache;

@Service("GoofferCacheImpl")
public class GoofferCacheImpl implements GoofferCache {
	
	private CopyOnWriteArrayList<String> favoritos = new  CopyOnWriteArrayList<String>();
	

	@Override
	public void postFavoritos(String favorito) {
		favoritos.add(favorito);
	}

	@Override
	public boolean existFavoritos(String favorito) {
		return favoritos.contains(favorito);
	}

	@Override
	public void deleteFavorito(String favorito) {
		favoritos.remove(favorito);
		
	}

	

}
