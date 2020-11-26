package edu.escuelaing.eci.arsw.gooffer.cache.Impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import edu.escuelaing.eci.arsw.gooffer.cache.GoofferCache;
import edu.escuelaing.eci.arsw.gooffer.model.*;

@Service("GoofferCacheImpl")
public class GoofferCacheImpl implements GoofferCache {
	
	
	private List<Servicio> servicios = null;
	
	private HashMap<String,List<Favorito>> favoritos = new HashMap<String, List<Favorito>>();
	
	


	@Override
	public boolean hayServiciosCache() {
		return servicios!=null;
	}

	@Override
	public List<Servicio> getServiciosCache() {
		return servicios;
	}

	@Override
	public void postServiciosCache(List<Servicio> ser) {
		this.servicios=ser;
	}

	@Override
	public void postServicioCache(Servicio servicio2) {
		this.servicios.add(servicio2);
	}

	@Override
	public boolean hayFavoritosCache(int id) {
		
		return favoritos.containsKey(String.valueOf(id));
	}

	@Override
	public List<Favorito> getFavoritosCache(int id) {
		return favoritos.get(String.valueOf(id));
	}

	@Override
	public void postFavoritosCache(int id, List<Favorito> favortios) {
		favoritos.put(String.valueOf(id), favortios);
	}

	@Override
	public boolean existServicioCache(int id) {
		boolean res=false;
		for(Servicio s: servicios) {
			if(s.getId()==id) {
				res=true;
			}
		}
		return res;
	}

	@Override
	public void deleteServicioCache(int id) {
		for(Servicio s: servicios) {
			if(s.getId()==id) {
				servicios.remove(s);
			}
		}
	}

	@Override
	public void putServicioCache(Servicio servi) {
		for(Servicio s: servicios) {
			if(s.getId()==servi.getId()) {
				servicios.remove(s);
				servicios.add(servi);
			}
		}
		
	}

	@Override
	public void postFavoritoCache(Favorito fav) {
		List<Favorito> listanew=favoritos.get(String.valueOf(fav.getIdusuario()));
		listanew.add(fav);
		favoritos.remove(String.valueOf(fav.getIdusuario()));
		favoritos.put(String.valueOf(fav.getIdusuario()), listanew);
	}



	

	

}
