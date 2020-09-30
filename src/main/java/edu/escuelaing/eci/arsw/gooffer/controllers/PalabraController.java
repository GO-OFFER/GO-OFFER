package edu.escuelaing.eci.arsw.gooffer.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.eci.arsw.gooffer.model.Palabra;

import edu.escuelaing.eci.arsw.gooffer.services.PalabraServices;

@RestController
@RequestMapping(value = "/palabras")
public class PalabraController {
	
	@Autowired
	PalabraServices palabraServices;
	
	@RequestMapping(method = RequestMethod.GET)
    public  ResponseEntity<?>  findAllPalabras() {
        List<Palabra> palabras = null;
        try {
            palabras = palabraServices.findAllPalabras();
        } catch (Exception ex) {
        	Logger.getLogger(PalabraController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(palabras, HttpStatus.ACCEPTED);
    }
}
