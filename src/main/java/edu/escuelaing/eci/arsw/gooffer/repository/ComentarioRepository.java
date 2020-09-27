package edu.escuelaing.eci.arsw.gooffer.repository;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;

import java.util.List;

public interface ComentarioRepository  {
    void addComentario(Comentario comentario);
    void editComentario(Comentario comentario);
    void deleteComentario(int id);
    List<Comentario> findAllComentario();
    Comentario getComentarioById(String id);
}
