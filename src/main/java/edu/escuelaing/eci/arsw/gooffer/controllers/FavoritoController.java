package edu.escuelaing.eci.arsw.gooffer.controllers;

import java.util.List;
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
import edu.escuelaing.eci.arsw.gooffer.model.Favorito;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.services.*;


@RestController
@RequestMapping(value = "/favoritos")
public class FavoritoController {
	
	
		@Autowired
		FavoritosServices favoritosServices;
		
		@RequestMapping(method = RequestMethod.GET)
	    public  ResponseEntity<?>  findAllComentarios() {
	        List<Favorito> favo = null;
	        try {
	            favo = favoritosServices.findAllFavoritos();
	        } catch (Exception ex) {
	        	Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
	            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(favo, HttpStatus.ACCEPTED);
	    }
	
		 @RequestMapping(value="/nuevoFavorito",method = RequestMethod.POST)
		    public ResponseEntity<?> addFav(@RequestBody Favorito fav){
		        try {
		        	System.out.println("LLEGUE BIEN GRACIAS POR PREGUNTAR  FAVORITOOOOOOOOOOOOOO");
		        	System.out.println(fav.getIdservicio()+"  seeeeer -------- uuuuuuusauario"+ fav.getIdusuario());
		        	favoritosServices.saveFavorito(fav);
		            return new ResponseEntity<>(HttpStatus.CREATED);
		        } catch (Exception ex) {
		            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
		            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
		        }
		    }
		 
		 @RequestMapping(value="/{id}",method = RequestMethod.GET)
			public  ResponseEntity<?>  findServiciosById(@PathVariable int id) {
		        List<Favorito> favortios = null;
		        try {
		        	favortios = favoritosServices.findFavoritosById(id);
		        } catch (Exception ex) {
		        	Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
		            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<>(favortios, HttpStatus.ACCEPTED);
		    }
//		@RequestMapping(value = "/saveFavoritoCache", method = RequestMethod.POST)	
//	    public ResponseEntity<?> postUsernameCache(@RequestBody Favorito favorito){
//	        try {
//	            user.postUsernameCache(favorito);
//	            return new ResponseEntity<>(HttpStatus.CREATED);
//	        } catch (Exception ex) {
//	            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
//	            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
//	        }        
//
//	    }
//	    
//	    @RequestMapping(value = "/deleteFavoritoCache/{user}", method = RequestMethod.DELETE)	
//	    public ResponseEntity<?> deleteUsernameCache(@PathVariable(name="user") String usuario){
//	        try {
//	            user.deleteUsernameCache(usuario);
//	            return new ResponseEntity<>(HttpStatus.CREATED);
//	        } catch (Exception ex) {
//	            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
//	            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
//	        }        
//
//	    }
//	    
//	    @RequestMapping(value = "/existFavoritoname/{favorito}", method = RequestMethod.GET)	
//	    public ResponseEntity<?> existUsername(@PathVariable(name="favorito") String favorito){
//	        try {
//	            return new ResponseEntity<>(favorito.existUsername(favorito), HttpStatus.CREATED);
//	        } catch (Exception ex) {
//	            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
//	            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
//	        }        
//
//	    }
}
