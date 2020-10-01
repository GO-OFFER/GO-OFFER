package edu.escuelaing.eci.arsw.gooffer;

import static org.junit.Assert.assertTrue;

//import edu.escuelaing.eci.arsw.gooffer.services;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.escuelaing.eci.arsw.gooffer.services.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class GoofferApplicationTests {

	 @Autowired
	 private UsuariosServices us;
	 @Autowired
	 private CompraServices us1;
	 @Autowired
	 private ComentarioServices us2;
	 @Autowired
	 private PalabraServices us3;
	 @Autowired
	 private ServiciosServices us4;
	 
	@Test
	void consultaTablaUsuarios() {
		assertTrue(us.findAllUsers()!=null);
	}
	
	@Test
	void consultaTablaCompra() {
		assertTrue(us1.findAllCompras()!=null);
	}

	@Test
	void consultaTablaComentario() {
		assertTrue(us2.findAllComentarios()!=null);
	}
	
	@Test
	void consultaTablaPalabra() {
		assertTrue(us3.findAllPalabras()!=null);
	}
	@Test
	void consultaTablaServicios() {
		assertTrue(us4.findAllServices()!=null);
	}
}
