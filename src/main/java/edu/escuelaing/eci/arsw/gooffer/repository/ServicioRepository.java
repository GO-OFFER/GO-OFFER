package edu.escuelaing.eci.arsw.gooffer.repository;


import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServicioRepository  extends JpaRepository<Servicio,Integer> {
    /*void addServicio(Servicio servicio);
    void editServicio(Servicio servicio);
    void deleteServicio(int id);
    List<Servicio> findAllServicio();
    Servicio getServicioById(String id);
    */
//	 @Query("UPDATE servicios SET descripcion= :des  WHERE servicios.id = :id")
//	 void updateById(@Param("id") int id, @Param("descripcion") String des );
//	 
//	@Modifying
//    @Query("update servicio c set c.descripcion = :descripcion where c.id = :id")
//    public void updateById(@Param(value="id") int id, @Param(value="descripcion") String descripcion);
	
	
}
