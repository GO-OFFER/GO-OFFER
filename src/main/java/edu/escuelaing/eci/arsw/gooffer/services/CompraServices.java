package edu.escuelaing.eci.arsw.gooffer.services;
import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.ServicioRepository;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.CompraRepositoryImpl;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.UsuarioRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServices {
	@Autowired
    private CompraRepositoryImpl compraRepository;
	
	public List<Compra> findAllCompras(){
        return compraRepository.findAllComentarios();
    }
}
