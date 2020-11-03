package edu.escuelaing.eci.arsw.gooffer.services;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.repository.impl.UsuarioRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices implements UserDetailsService {
//public class UsuariosServices {
    @Autowired
    private UsuarioRepositoryImpl usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<Usuario> findAllUsers(){
        return usuarioRepository.findAllUsers();
    }

	public void saveUsuario(Usuario usuario) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        /*modificar el password para que sea seguro*/
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuarioRepository.saveUsuario(usuario);
		
	}
	public Optional<Usuario> findById(Integer id){
        return usuarioRepository.findById(id);
    }


     
	public Usuario findByName(String username) {
        return usuarioRepository.findUsuarioByNombre(username);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us = usuarioRepository.findUsuarioByNombre(username);
        String tipo = Integer.toString(us.getTipo());
        System.out.print(us.getEmail()+ us.getNombre()+ us.getPassword());
        List<GrantedAuthority> roles  = new ArrayList<>();
        /*roles.add(new SimpleGrantedAuthority("Vendedor"));
        roles.add(new SimpleGrantedAuthority("Comprador"));
        roles.add(new SimpleGrantedAuthority("1"));
        roles.add(new SimpleGrantedAuthority("2"));*/
        UserDetails userD = new User(us.getEmail(),us.getPassword(),true,true,true,true,new ArrayList<>());
        return userD;
    }
    //public Usuario findByNameAndPassword(String username,String password) {
        //return usuarioRepository.findByUserNombreAndPassword(username,password);
    //}
   /* public List<Usuario> findAllUsuario(){
        return usuarioRepository.findAll();
    }

    public void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }*/
}
