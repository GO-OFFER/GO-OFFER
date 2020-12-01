package edu.escuelaing.eci.arsw.gooffer.cache;

import java.util.List;

import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Favorito;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;

public interface GoofferCache {
	

	//void postServicios(ArrayList )
	
	

	boolean hayServiciosCache();

	List<Servicio> getServiciosCache();

	void postServiciosCache(List<Servicio> servicios);

	void postServicioCache(Servicio servicio2);

	boolean hayFavoritosCache(int id);

	List<Favorito> getFavoritosCache(int id);

	void postFavoritosCache(int id, List<Favorito> favortios);

	boolean existServicioCache(int id);

	void deleteServicioCache(int id);

	void putServicioCache(Servicio servi);

	void postFavoritoCache(Favorito fav);

	void postIdServicioCache(int id);

	int getIdServicioCache();

}
