package edu.escuelaing.eci.arsw.gooffer.repository.impl;



import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRepositoryImpl {
    private final List<Usuario> usuarios=new ArrayList<>();

    @Autowired
    UsuarioRepository p;
    	
    public UsuarioRepositoryImpl() {
    	
        //funcion 1

      //  Usuario prueba1 = new Usuario( 1, "james", "prueba1@gmail.com", 1,  "hola123",0);
       // Usuario prueba2 = new Usuario(2, "rodolfo", "prueba2@gmail.com", 1,  "hola123",0);
       // Usuario prueba3 = new Usuario(3, "gustavo", "prueba3@gmail.com", 1,  "hola123",0);

        //usuarios.add(prueba1);
      //  usuarios.add(prueba2);
       // usuarios.add(prueba3);

    }
    

    public List<Usuario> findAllUsers() {
        return p.findAll();
    }
    public void saveUsuario(Usuario usuario) {
		p.save(usuario);
	}
    /*
    @Override
    public void deleteById(int id) {

    }

    @Override
    public void addUsuario(Usuario usuario) {
        boolean existe = false;
        for(Usuario u: usuarios){
            if(u.getId()==usuario.getId()){
                existe = true;
            }
        }
        if(!existe){
            usuarios.add(usuario);
        }
    }

    @Override
    public void editUsuario(Usuario usuario) {

    }

    @Override
    public List<Usuario> findAllUsuario() {
        return usuarios;
    }
    */


	


}
