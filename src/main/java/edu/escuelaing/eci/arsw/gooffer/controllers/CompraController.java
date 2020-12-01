package edu.escuelaing.eci.arsw.gooffer.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.services.CompraServices;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
@RequestMapping(value = "/compras")
public class CompraController {
	@Autowired
	CompraServices compraServices;
	
	@RequestMapping(method = RequestMethod.GET)
    public  ResponseEntity<?>  findAllCompras() {
        List<Compra> compras = null;
        try {
            compras = compraServices.findAllCompras();
        } catch (Exception ex) {
        	Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(compras, HttpStatus.ACCEPTED);
    }
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public  ResponseEntity<?>  findCalifByIdServicio(@PathVariable int id) {
		List<Compra> compras = null;
        try {
            compras = compraServices.findCalifByIdS(id);
        } catch (Exception ex) {
        	Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(compras, HttpStatus.ACCEPTED);
    }
	@RequestMapping(value = "/postIdServicioCache/{map}", method = RequestMethod.POST)	
    public ResponseEntity<?> postIdServicioCache(@PathVariable int map){
        try {
        	System.out.println(" LLEGUE BIEN GRACIAS POR PREGUNTAR IDCACHEEEEE ");
        	compraServices.postIdServicioCache(map);
        	
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
	@RequestMapping(value="/getIdServicioCache",method = RequestMethod.GET)
	public  ResponseEntity<?>  getIdServicioCache() {
		int idd = 0;
        try {
            idd = compraServices.getIdServicioCache();
        } catch (Exception ex) {
        	Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idd, HttpStatus.ACCEPTED);
    }
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody Compra compra){
        try {
        	System.out.println(" LLEGUE BIEN GRACIAS POR PREGUNTAR Compra "+ compra);
        	compraServices.saveCompra(compra);
        	
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
}
