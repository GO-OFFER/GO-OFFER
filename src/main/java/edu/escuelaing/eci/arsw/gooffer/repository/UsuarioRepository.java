package edu.escuelaing.eci.arsw.gooffer.repository;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;


import java.util.List;

public interface UsuarioRepository{
    Usuario findById(int id);
    void deleteById(int id);
    void addUsuario(Usuario usuario);
    void editUsuario(Usuario usuario);
    List<Usuario> findAllUsuario();


}
