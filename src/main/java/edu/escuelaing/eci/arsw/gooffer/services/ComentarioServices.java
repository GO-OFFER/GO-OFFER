package edu.escuelaing.eci.arsw.gooffer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.ComentarioRepositoryImpl;

@Service
public class ComentarioServices {
	@Autowired
	ComentarioRepositoryImpl comentarioRepositoryImpl;
	
	public List<Comentario> findAllComentarios(){
        return comentarioRepositoryImpl.findAllComentarios();
    }

}
