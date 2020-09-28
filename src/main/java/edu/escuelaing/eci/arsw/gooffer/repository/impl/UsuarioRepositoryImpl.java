package edu.escuelaing.eci.arsw.gooffer.repository.impl;



import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final List<Usuario> usuarios=new ArrayList<>();

    public UsuarioRepositoryImpl() {
        //funcion 1

        Usuario prueba1 = new Usuario(1, "james", "prueba1@gmail.com", "USUARIO",  "hola123");
        Usuario prueba2 = new Usuario(2, "rodolfo", "prueba2@gmail.com", "USUARIO",  "hola123");
        Usuario prueba3 = new Usuario(3, "gustavo", "prueba3@gmail.com", "USUARIO",  "hola123");

        usuarios.add(prueba1);
        usuarios.add(prueba2);
        usuarios.add(prueba3);

    }
    @Override
    public Usuario findById(int id) {
        for(Usuario u: usuarios){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }

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

}
