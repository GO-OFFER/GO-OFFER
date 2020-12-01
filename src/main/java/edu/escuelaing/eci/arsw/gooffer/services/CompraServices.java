package edu.escuelaing.eci.arsw.gooffer.services;
import edu.escuelaing.eci.arsw.gooffer.cache.GoofferCache;
import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.CompraRepositoryImpl;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.UsuarioRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServices {
	@Autowired
    private CompraRepositoryImpl compraRepository;

	@Autowired
    @Qualifier("GoofferCacheImpl")
    private GoofferCache goofferCache;

	public List<Compra> findAllCompras(){
        return compraRepository.findAllCompras();
    }
    public void saveCompra(Compra c){
        compraRepository.saveCompra(c);
    }
	public List<Compra> findCalifByIdS(int id) {
		return compraRepository.findCalifByIdS(id);
	}
	public void postIdServicioCache(int id) {
		goofferCache.postIdServicioCache(id);
	}
	public int getIdServicioCache() {
		return goofferCache.getIdServicioCache();
	}
}
