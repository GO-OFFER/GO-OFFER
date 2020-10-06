package edu.escuelaing.eci.arsw.gooffer.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.services.ServiciosServices;

@RestController
@RequestMapping(value = "/servicios")
public class ServiciosController {
	

	@Autowired
	ServiciosServices serviciosService;
	@RequestMapping(method = RequestMethod.GET)
	public  ResponseEntity<?>  findAllServicios() {
        List<Servicio> servicios = null;
        try {
            servicios = serviciosService.findAllServices();
        } catch (Exception ex) {
        	Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicios, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(value="/{name}",method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody Servicio servicio, @PathVariable String name){
        try {
        	System.out.println(name+" LLEGUE BIEN GRACIAS POR PREGUNTAR  "+ servicio);
        	serviciosService.saveServicio(servicio);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public  ResponseEntity<?>  findServiciosById(@PathVariable int id) {
        List<Servicio> servicios = null;
        try {
            servicios = serviciosService.findServiciosById(id);
        } catch (Exception ex) {
        	Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicios, HttpStatus.ACCEPTED);
    }
	
}
