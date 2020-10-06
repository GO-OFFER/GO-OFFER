package edu.escuelaing.eci.arsw.gooffer.repository;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;



public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    Optional<Usuario> findByNombre(@Param("nombre") String nombre);
    //public Usuario findByNombre(String nombre);
   // public Usuario findByNombreAndPassword(String nombre,String password);

}
