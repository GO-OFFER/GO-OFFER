package edu.escuelaing.eci.arsw.gooffer;

//import edu.escuelaing.eci.arsw.gooffer.services;
import edu.escuelaing.eci.arsw.gooffer.model.Comentario;
import edu.escuelaing.eci.arsw.gooffer.model.Compra;
import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import edu.escuelaing.eci.arsw.gooffer.services.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

		import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
/*@TestPropertySource(properties = {
		"spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.H2Dialect",
		"spring.datasource.url=jdbc:h2:tcp://localhost/~/test",
		"spring.datasource.username=sa",
		"spring.datasource.password="
})*/
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

	@Test
	public void deberiaInsertarUsuario() {
		Usuario Usuario = new Usuario();
		Random num = new Random();
		int generator = num.nextInt(1000);
		Usuario.setId(1003);
		Usuario.setEmail("estudianteprueba"+ generator +"@mail.escuela.co");
		Usuario.setNumCompras(6);
		Usuario.setNombre("test03");
		Usuario.setTipo(1);
		Usuario.setPassword("12345");
		us.saveUsuario(Usuario);
		Usuario nuevo = null;
		List<Usuario> usuarioList = us.findAllUsers();
		for(Usuario u :usuarioList){
			if(u.getEmail().equalsIgnoreCase(Usuario.getEmail())) {
				nuevo = u;
			}
		}
		assertEquals(nuevo.getEmail(), (Usuario.getEmail()));

	}
	//@Test
	/*public void DeberiaConsultarPorId() {
		Usuario Usuario = new Usuario();
		Random num = new Random();
		int generator = num.nextInt(1000);
		Usuario.setId(1003);
		Usuario.setEmail("estudianteprueba"+ generator +"@mail.escuela.co");
		Usuario.setNumCompras(6);
		Usuario.setNombre("test03");
		Usuario.setTipo(1);
		Usuario.setPassword("12345");
		us.saveUsuario(Usuario);
		Optional<edu.escuelaing.eci.arsw.gooffer.model.Usuario> nuevo = us.findById(1003);
		/*List<Usuario> usuarioList = us.findAllUsers();
		for(Usuario u :usuarioList){
			if(u.getEmail().equalsIgnoreCase(Usuario.getEmail())) {
				nuevo = u;
			}
		}
		assertEquals("test03", (Usuario.getNombre()));

	}*/
	@Test
	public void DeberiaInsertarServicio() {
		Servicio Servicio = new Servicio();
		Servicio.setId(1003);
		Servicio.setIdVendedor(111);
		Servicio.setNombre("service03");
		Servicio.setDescripcion("12345");
		us4.saveServicio(Servicio);
		Servicio nuevo = null;
		List<Servicio> servicioList = us4.findAllServices();
		for(Servicio s :servicioList){
			System.out.println(s.getNombre());
			if(s.getNombre().equalsIgnoreCase(Servicio.getNombre())) {
				nuevo = s;
			}
		}
		assertEquals(nuevo.getNombre(), (Servicio.getNombre()));

	}
	/*@Test
	public void login1() {
		Usuario Usuario = new Usuario();
		Random num = new Random();
		int generator = num.nextInt(1000);
		Usuario.setId(1003);
		Usuario.setEmail("estudianteprueba"+ generator +"@mail.escuela.co");
		Usuario.setNumCompras(6);
		Usuario.setNombre("test04");
		Usuario.setTipo(1);
		Usuario.setPassword("12345");
		us.saveUsuario(Usuario);
		Usuario nuevo = null;
		List<Usuario> usuarioList = us.findAllUsers();
		for(Usuario u :usuarioList){
			if(u.getEmail().equalsIgnoreCase("estudianteprueba"+ generator +"@mail.escuela.co")) {
				nuevo = u;
			}
		}
		assertEquals(nuevo.getPassword(),"12345");
	}
	@Test
	public void noDeberialogin2() {
		Usuario Usuario = new Usuario();
		Random num = new Random();
		int generator = num.nextInt(1000);
		Usuario.setId(1003);
		Usuario.setEmail("estudianteprueba"+ generator +"@mail.escuela.co");
		Usuario.setNumCompras(6);
		Usuario.setNombre("test04");
		Usuario.setTipo(1);
		Usuario.setPassword("12345");
		us.saveUsuario(Usuario);
		Usuario nuevo = null;
		List<Usuario> usuarioList = us.findAllUsers();
		for(Usuario u :usuarioList){
			if(u.getEmail().equalsIgnoreCase("estudianteprueba"+ generator +"@mail.escuela.co")) {
				nuevo = u;
			}
		}
		assertFalse(nuevo.getPassword()=="12344");
	}*/

}
