package edu.escuelaing.eci.arsw.gooffer.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.services.ComentarioServices;
import edu.escuelaing.eci.arsw.gooffer.services.CompraServices;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {
	@Autowired
	ComentarioServices comentarioServices;
	
	@RequestMapping(method = RequestMethod.GET)
    public  ResponseEntity<?>  findAllComentarios() {
        List<Comentario> comentarios = null;
        try {
            comentarios = comentarioServices.findAllComentarios();
        } catch (Exception ex) {
        	Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comentarios, HttpStatus.ACCEPTED);
    }
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
    public  ResponseEntity<?>  findAllComentariosById(@PathVariable int id) {
        Optional<Comentario> comentarios = null;
        try {
            comentarios = comentarioServices.findAllComentariosById(id);
        } catch (Exception ex) {
        	Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comentarios, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(value="/comentarioNuevo",method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody Comentario comentario){
        try {
        	System.out.println(" LLEGUE BIEN GRACIAS POR PREGUNTAR  0000");        	
        	System.out.println(" LLEGUE BIEN GRACIAS POR PREGUNTAR  "+ comentario);
        	comentarioServices.saveComentario(comentario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
}
