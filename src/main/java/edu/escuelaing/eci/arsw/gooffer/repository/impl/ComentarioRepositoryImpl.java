package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.repository.ComentarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComentarioRepositoryImpl implements ComentarioRepository {
    @Override
    public void addComentario(Comentario comentario) {

    }

    @Override
    public void editComentario(Comentario comentario) {

    }

    @Override
    public void deleteComentario(int id) {

    }

    @Override
    public List<Comentario> findAllComentario() {
        return null;
    }

    @Override
    public Comentario getComentarioById(String id) {
        return null;
    }
}
