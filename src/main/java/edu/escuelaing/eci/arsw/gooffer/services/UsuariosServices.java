package edu.escuelaing.eci.arsw.gooffer.services;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /*public Usuario findbyId(int id){
        return usuario.findById(id);
    }*/
    public List<Usuario> findAllUsuario(){
        return usuarioRepository.findAll();
    }

    public void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
