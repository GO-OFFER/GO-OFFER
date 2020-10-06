package edu.escuelaing.eci.arsw.gooffer.controllers;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UsuariosServices usuariosS;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarioByEmail() {
        List<Usuario> usuarios = null;
        try {
            usuarios = usuariosS.findAllUsers();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
    }

}
