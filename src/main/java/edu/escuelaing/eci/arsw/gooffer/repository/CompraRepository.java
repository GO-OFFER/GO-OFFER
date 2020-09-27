package edu.escuelaing.eci.arsw.gooffer.repository;

import edu.escuelaing.eci.arsw.gooffer.model.Compra;

import java.util.List;

public interface CompraRepository{
    void addCompra(Compra compra);
    void editCompra(Compra compra);
    void deleteCompra(int id);
    List<Compra> findAllCompra();
    Compra getCompraById(String id);
}
