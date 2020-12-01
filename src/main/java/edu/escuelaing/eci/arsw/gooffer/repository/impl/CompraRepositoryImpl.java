package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Favorito;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.CompraRepository;
import edu.escuelaing.eci.arsw.gooffer.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CompraRepositoryImpl{
	@Autowired
    CompraRepository compraRepository;
	public List<Compra> findAllCompras() {
        return  compraRepository.findAll();
    }
    public void saveCompra(Compra compra) {
        compraRepository.save(compra);
    }
	public List<Compra> findCalifByIdS(int id) {
		List<Compra> res= new ArrayList<Compra>();
		for (Compra c: compraRepository.findAll()) {
			if(c.getIdServicio()==id) {
				res.add(c);
			}
		}
		
		return res;
	}


}
