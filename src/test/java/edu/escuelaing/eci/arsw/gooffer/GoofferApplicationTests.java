package edu.escuelaing.eci.arsw.gooffer;

//import edu.escuelaing.eci.arsw.gooffer.services;
import edu.escuelaing.eci.arsw.gooffer.model.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import edu.escuelaing.eci.arsw.gooffer.services.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	 @Autowired
	 private FavoritosServices us5;


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
	void consultaTablaFavorito(){
		assertTrue(us5.findAllFavoritos()!=null);
	}


	@Test
	public void deberiaInsertarUsuario() {
		Usuario Usuario = new Usuario();
		Random num = new Random();
		int generator = num.nextInt(1000);
		Usuario.setId(1003);
		Usuario.setEmail("estudianteprueba"+ generator +"@mail.escuela.cmmmmmo");
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
	
	@Test
	public void DeberiaConsultarPorId() {
		Usuario Usuario = new Usuario();
		Random num = new Random();
		int generator = num.nextInt(1000);
		String id = null;
		Usuario.setId(1003);
		Usuario.setEmail("estudianteprueba"+ generator +"@mail.escuela.co");
		Usuario.setNumCompras(6);
		Usuario.setNombre("test03");
		Usuario.setTipo(1);
		Usuario.setPassword("12345");
		us.saveUsuario(Usuario);
		List<Usuario> usuarioList = us.findAllUsers();
		for(Usuario u :usuarioList){
			if(u.getEmail().equalsIgnoreCase(Usuario.getEmail())) {
				id = u.getEmail();
			}
		}
		assertEquals(id, (Usuario.getEmail()));

	}
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
	@Test
	public void deberiaInsertarComentario(){
		Comentario Comentario = new Comentario();
		Comentario.setId(10003);
		Comentario.setComentario("prueba");
		Comentario.setIdusuario(103);
		Comentario.setIdservicio(1003);
		us2.saveComentario(Comentario);
		List<Comentario> comentarios = us2.findAllComentarios();
		Comentario co = null;
		for(Comentario c: comentarios){
			if(Comentario.getComentario().equalsIgnoreCase(c.getComentario())){
				System.out.println("entraaa oadreee");
				co = c;
			}
		}
		assertEquals(co.getComentario(),Comentario.getComentario());
	}
	@Test
	public void deberiaInsertarFavorito(){
		Favorito Favorito = new Favorito();
		Favorito.setIdservicio(1003);
		Favorito.setIdusuario(1003);
		us5.saveFavorito(Favorito);
		List<Favorito> favoritos = us5.findAllFavoritos();
		Favorito fa = null;
		for(Favorito f: favoritos){
			if(Favorito.getIdservicio()==f.getIdservicio()){
				fa = f;
			}
		}
		assertEquals(fa.getIdservicio(),Favorito.getIdservicio());
	}
	@Test
	public void deberiaInsertarCompra() throws ParseException {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		Compra Compra = new Compra();
		Compra.setId(1003);
		Compra.setIdservicio(1003);
		Compra.setIdusuario(1003);
		Compra.setCreationdate(new Date(DATE_FORMAT.parse("2013-09-29").getTime()));
		Compra.setCalificacion(100);
		us1.saveCompra(Compra);
		List<Compra> compras = us1.findAllCompras();
		Compra co = null;
		for(Compra c: compras){
			if(Compra.getCalificacion()==c.getCalificacion()){
				co = c;
			}
		}
		assertEquals(co.getCalificacion(),Compra.getCalificacion());
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
