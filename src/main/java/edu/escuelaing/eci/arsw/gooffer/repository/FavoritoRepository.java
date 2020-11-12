package edu.escuelaing.eci.arsw.gooffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito,Integer>{

}
