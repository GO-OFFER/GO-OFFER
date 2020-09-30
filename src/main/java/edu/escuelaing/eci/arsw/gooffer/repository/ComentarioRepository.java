package edu.escuelaing.eci.arsw.gooffer.repository;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Compra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Integer>{
    /*void addComentario(Comentario comentario);
    void editComentario(Comentario comentario);
    void deleteComentario(int id);
    List<Comentario> findAllComentario();
    Comentario getComentarioById(String id);
    */
}
