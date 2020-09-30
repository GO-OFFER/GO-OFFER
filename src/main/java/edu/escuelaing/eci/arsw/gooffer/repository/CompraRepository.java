package edu.escuelaing.eci.arsw.gooffer.repository;

import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra,Integer>{
   /* void addCompra(Compra compra);
    void editCompra(Compra compra);
    void deleteCompra(int id);
    List<Compra> findAllCompra();
    Compra getCompraById(String id);
    */
}
