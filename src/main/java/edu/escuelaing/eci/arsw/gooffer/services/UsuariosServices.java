package edu.escuelaing.eci.arsw.gooffer.services;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.UsuarioRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices {
	
    @Autowired
    private UsuarioRepositoryImpl usuarioRepository;

    public List<Usuario> findAllUsers(){
        return usuarioRepository.findAllUsers();
    }

	public void saveUsuario(Usuario usuario) {
		usuarioRepository.saveUsuario(usuario);
		
	}
	public Optional<Usuario> findById(Integer id){
        return usuarioRepository.findById(id);
    }
     
   /* public List<Usuario> findAllUsuario(){
        return usuarioRepository.findAll();
    }

    public void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }*/
}
