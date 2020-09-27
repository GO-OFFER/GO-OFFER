package edu.escuelaing.eci.arsw.gooffer.repository.impl;

import edu.escuelaing.eci.arsw.gooffer.model.Palabra;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.UsuarioRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public Usuario findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void addUsuario(Usuario usuario) {

    }

    @Override
    public void editUsuario(Usuario usuario) {

    }

    @Override
    public List<Usuario> findAllUsuario() {
        return null;
    }

}
