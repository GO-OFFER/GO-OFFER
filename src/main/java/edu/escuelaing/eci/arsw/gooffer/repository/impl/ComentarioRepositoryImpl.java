package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ComentarioRepositoryImpl{
	
	@Autowired
    ComentarioRepository comentarioRepository;
	
	public List<Comentario> findAllComentarios() {
        return  comentarioRepository.findAll();
    }
    public void saveComentario(Comentario comentario) {
    	LocalDate creationDate = LocalDate.now();
		  
		  comentario.setFecha(Date.valueOf(creationDate));
        comentarioRepository.save(comentario);
    }
	public Optional<Comentario> findAllComentariosById(int id) {
		return  comentarioRepository.findById(id);
	}
}
