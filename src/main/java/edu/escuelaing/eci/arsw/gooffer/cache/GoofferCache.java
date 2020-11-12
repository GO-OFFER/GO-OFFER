package edu.escuelaing.eci.arsw.gooffer.cache;

import java.util.List;

public interface GoofferCache {
	


	void postFavoritos(String favorito);

	boolean existFavoritos(String favorito);

	void deleteFavorito(String favorito);

}
