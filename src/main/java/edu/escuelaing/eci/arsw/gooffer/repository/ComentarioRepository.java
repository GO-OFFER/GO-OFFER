package edu.escuelaing.eci.arsw.gooffer.repository;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComentarioRepository extends JpaRepository<Comentario,Integer>{
    /*void addComentario(Comentario comentario);
    void editComentario(Comentario comentario);
    void deleteComentario(int id);
    List<Comentario> findAllComentario();
    Comentario getComentarioById(String id);
    */
	
//	  @Query("SELECT u FROM comentario u WHERE u.idservicio = :idservicio")
//	  Comentario findByidservicio(@Param("idservicio") int idservicio);
}
