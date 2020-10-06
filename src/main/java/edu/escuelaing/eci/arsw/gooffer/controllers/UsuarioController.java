package edu.escuelaing.eci.arsw.gooffer.controllers;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Set;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuariosServices usuariosS;

    @RequestMapping(method = RequestMethod.GET)
    public  ResponseEntity<?>  findAllUsuarios() {
        List<Usuario> usuarios = null;
        try {
            usuarios = usuariosS.findAllUsers();
        } catch (Exception ex) {
        	Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
    }
   
    @RequestMapping(path = "/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<?> getUsuario(@PathVariable String nombre) {
        try {
            //obtener datos que se enviaran a traves del API
            Optional<Usuario> user = usuariosS.findByName(nombre);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/{name}",method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody Usuario usuario,@PathVariable String name){
        try {
        	System.out.println(name+" LLEGUE BIEN GRACIAS POR PREGUNTAR  "+usuario);
            usuariosS.saveUsuario(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
/*
    @RequestMapping(method = RequestMethod.GET)
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "example";
    }
*/
}
