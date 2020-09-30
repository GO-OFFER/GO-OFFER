package edu.escuelaing.eci.arsw.gooffer.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.eci.arsw.gooffer.model.Compra;
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
}
