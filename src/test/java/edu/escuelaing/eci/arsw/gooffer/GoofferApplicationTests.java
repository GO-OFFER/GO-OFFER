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
/*@ActiveProfiles("test")
@TestPropertySource(properties = {
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
	public void DeberiaInsertarServicio() throws ParseException {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		Servicio Servicio = new Servicio();
		Servicio.setId(1003);
		Servicio.setIdVendedor(111);
		Servicio.setNombre("service03");
		Servicio.setDescripcion("12345");
		Servicio.setCreacion(new Date(DATE_FORMAT.parse("2013-09-29").getTime()));
		us4.saveServicio(Servicio);
		Servicio nuevo = null;
		List<Servicio> servicioList = us4.findAllServices();
		for(Servicio s :servicioList){
			if(s.getNombre().equalsIgnoreCase(Servicio.getNombre())) {
				nuevo = s;
			}
		}
		assertEquals(nuevo.getNombre(), (Servicio.getNombre()));

	}
	@Test
	public void deberiaInsertarComentario(){
		Comentario Comentario = new Comentario();
		Random num = new Random();
		int generator = num.nextInt(1000);
		Comentario.setId(10003);
		Comentario.setComentario("prueba");
		Comentario.setIdusuario(103);
		Comentario.setIdservicio(generator);
		us2.saveComentario(Comentario);
		List<Comentario> comentarios = us2.findAllComentarios();
		Comentario co = null;
		for(Comentario c: comentarios){
			if(Comentario.getComentario().equalsIgnoreCase(c.getComentario())){
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
	@Test
	public void deberiaInsertarPalabra(){
		Palabra Palabra = new Palabra();
		Palabra.setId(1003);
		Palabra.setIdservicio(1003);
		Palabra.setPalabra("prueba palabra");
		us3.savePalabra(Palabra);
		List<Palabra> palabras =  us3.findAllPalabras();
		Palabra pa = null;
		for(Palabra p: palabras){
			if(Palabra.getPalabraa().equalsIgnoreCase(p.getPalabraa())){
				pa = p;
			}
		}
		assertEquals(pa.getPalabraa(),Palabra.getPalabraa());

	}
	@Test
	public void noDeberiaInsertarUsuario() {
		boolean no = true;
		Usuario Usuario = new Usuario();
		Usuario.setId(1003);
		//Usuario.setEmail("estudianteprueba824@mail.escuela.cmmmmmo");//ambiente pruebas
		Usuario.setEmail("estudianteprueba693@mail.escuela.co"); //ambiente producción
		Usuario.setNumCompras(6);
		Usuario.setNombre("test03");
		Usuario.setTipo(1);
		Usuario.setPassword("12345");
		try{
			us.saveUsuario(Usuario);
		}catch(Exception ex){
			no =false;
		}
		assertFalse(no);
	}
	@Test
	public void noDeberiaInsertarServicio() throws ParseException {
		boolean no = false;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		Servicio Servicio = new Servicio();
		Servicio.setId(45);
		Servicio.setIdVendedor(111);
		Servicio.setNombre("service03");
		Servicio.setDescripcion("12345");
		Servicio.setCreacion(new Date(DATE_FORMAT.parse("2013-09-29").getTime()));
		us4.saveServicio(Servicio);
		List<Servicio> servicios = us4.findAllServices();
		for(Servicio s : servicios){
			if(s.getId()==45){
				no = true;
			}
		}
		assertFalse(no);
	}
	/*@Test
	public void noDeberiaInsertarComentario(){
		boolean no = true;
		Comentario Comentario = new Comentario();
		//Comentario.setId(1);//ambiente pruebas
		Comentario.setId(368);// ambiente produccion
		Comentario.setComentario("prueba");
		Comentario.setIdusuario(103);
		Comentario.setIdservicio(235);
		try {
			us2.saveComentario(Comentario);
		}catch(Exception ex){
			no = false;
		}
		assertFalse(no);
	}*/
	@Test
	public void noDeberiaInsertarFavorito(){
		boolean no = true;
		Favorito Favorito = new Favorito();
		Favorito.setIdservicio(1003);
		Favorito.setIdusuario(1003);
		List<Favorito> favoritos = us5.findAllFavoritos();
		Favorito fa = null;
		for(Favorito f: favoritos){
			if(Favorito.getIdservicio()==f.getIdservicio()){
				no= false;
			}else{
				us5.saveFavorito(Favorito);
			}
		}
		assertFalse(no);
	}
	@Test
	public void noDeberiaInsertarCompra() throws ParseException {
		boolean no = true;
		Compra Compra = new Compra();
		Compra.setId(6);
		Compra.setIdservicio(1003);
		Compra.setIdusuario(1003);
		Compra.setCalificacion(100);
		try{
			us1.saveCompra(Compra);
		}catch(Exception ex){
			no = false;
		}
		assertFalse(no);
	}
	@Test
	public void noDeberiaInsertarPalabra(){
		boolean no = true;
		Palabra Palabra = new Palabra();
		Palabra.setId(418);
		Palabra.setIdservicio(1003);
		Palabra.setPalabra("prueba palabra");
		us3.savePalabra(Palabra);
		List<Palabra> palabras =  us3.findAllPalabras();
		Palabra pa = null;
		for(Palabra p: palabras){
			if(Palabra.getIdservicio()==p.getIdservicio()){
				no= false;
			}else{
				us3.savePalabra(Palabra);
			}
		}
		assertFalse(no);

	}
	@Test
	public void deberiaConsultarUsuarioPorId() {
		//String id = "estudianteprueba304@mail.escuela.cmmmmmo"; //ambiente pruebas
		String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		String id2 = null;
		List<Usuario> usuarioList = us.findAllUsers();
		for(Usuario u :usuarioList){
			if(u.getEmail().equalsIgnoreCase(id)) {
				id2 = u.getEmail();
			}
		}
		assertEquals(id,id2);
	}
	@Test
	public void deberiaConsultarServicioPorId(){
		int id = 166; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		int id2 = 0;
		List<Servicio> servicios = us4.findAllServices();
		for(Servicio s :servicios){
			if(s.getId()==id) {
				id2 = s.getId();
			}
		}
		assertEquals(id,id2);
	}
	@Test
	public void deberiaConsultarComentarioPorId(){
		//int id = 42; //ambiente pruebas
		int id = 367; //ambiente produccion
		int id2 = 0;
		List<Comentario> comentarios = us2.findAllComentarios();
		for(Comentario c :comentarios){
			if(c.getId()==id) {
				id2 = c.getId();
			}
		}
		assertEquals(id,id2);
	}
	@Test
	public void deberiaConsultarFavoritoPorId(){
		int id = 1003; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		int id2 = 0;
		List<Favorito> favoritos = us5.findAllFavoritos();
		for(Favorito f :favoritos){
			if(f.getIdservicio()==id) {
				id2 = f.getIdservicio();
			}
		}
		assertEquals(id,id2);
	}
	@Test
	public void deberiaConsultarCompraPorId(){
		//int id = 348; //ambiente pruebas
		int id = 401; //ambiente produccion
		int id2 = 0;
		List<Compra> compras = us1.findAllCompras();
		for(Compra p :compras){
			if(p.getId()==id) {
				id2 = p.getId();
			}
		}
		assertEquals(id,id2);
	}
	@Test
	public void deberiaConsultarPalabraPorId(){
		//int id = 418; //ambiente pruebas
		int id = 480;  //ambiente produccion
		int id2 = 0;
		List<Palabra> palabras = us3.findAllPalabras();
		for(Palabra p :palabras){
			if(p.getId()==id) {
				id2 = p.getId();
			}
		}
		assertEquals(id,id2);
	}
	@Test
	public void noDeberiaConsultarUsuarioPorId() {
		String id = "estudianteprueba12304@mail.escuela.co"; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		String id2 = null;
		List<Usuario> usuarioList = us.findAllUsers();
		for(Usuario u :usuarioList){
			if(u.getEmail().equalsIgnoreCase(id)) {
				id2 = u.getEmail();
			}
		}
		assertFalse(id.equalsIgnoreCase(id2));
	}
	@Test
	public void noDeberiaConsultarServicioPorId(){
		int id = 45; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		int id2 = 0;
		List<Servicio> servicios = us4.findAllServices();
		for(Servicio s :servicios){
			if(s.getId()==id) {
				id2 = s.getId();
			}
		}
		assertFalse(id==id2);
	}
	@Test
	public void noDeberiaConsultarComentarioPorId(){
		int id = 100000; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		int id2 = 0;
		List<Comentario> comentarios = us2.findAllComentarios();
		for(Comentario c :comentarios){
			if(c.getId()==id) {
				id2 = c.getId();
			}
		}
		assertFalse(id==id2);
	}
	@Test
	public void noDeberiaConsultarFavoritoPorId(){
		int id = 42; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		int id2 = 0;
		List<Favorito> favoritos = us5.findAllFavoritos();
		for(Favorito f :favoritos){
			System.out.println(f.getIdservicio());
			if(f.getIdservicio()==id) {
				id2 = f.getIdservicio();
			}
		}
		assertFalse(id==id2);
	}
	@Test
	public void noDeberiaConsultarCompraPorId(){
		int id = 10003; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		int id2 = 0;
		List<Favorito> favoritos = us5.findAllFavoritos();
		for(Favorito f :favoritos){
			System.out.println(f.getIdservicio());
			if(f.getIdservicio()==id) {
				id2 = f.getIdservicio();
			}
		}
		assertFalse(id==id2);
	}
	@Test
	public void noDeberiaConsultarPalabraPorId(){
		int id = 10003; //ambiente pruebas
		//String id = "estudianteprueba108@mail.escuela.co"; //ambiente produccion
		int id2 = 0;
		List<Favorito> favoritos = us5.findAllFavoritos();
		for(Favorito f :favoritos){
			System.out.println(f.getIdservicio());
			if(f.getIdservicio()==id) {
				id2 = f.getIdservicio();
			}
		}
		assertFalse(id==id2);
	}
	/*@Test
	public void deberiaIngresar() {
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
	public void noDeberiaIngresar() {
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
