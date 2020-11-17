//var api = apiServicios; 
app = (function() {

	var idServicio = 0;
	var nombreUsuario;
	var idLogg = 0;
	var map;
	//var id;
	var person = { name: '', id: '' };
	//const { Seq } = require('immutable');
	//const myObject = { a: 1, b: 2, c: 3 };
	var idLogg=0;

	function inicio() {
		nombreUsuario = $("#usuario").val();
		console.info(nombreUsuario);

		$.getScript("js/usuario.js", function() { apiUsuario.checkPassword(nombreUsuario, validarCuenta); });
	}
	var validarCuenta = function(username) {
		var password = $('#pass').val();
		//var hash = CryptoJS.SHA256(password);
		console.log(password);
		console.log(username.nombre);
		console.log(username.tipo);
		console.log(username.password);
		sessionStorage.setItem("currentUser", username.nombre);
		sessionStorage.setItem("currentRol", username.rol);
		if (username.password == password) {
			if (username.tipo === 1) {
				//Seq(myObject).map(x => x * x).toObject();
				person.name = username.nombre;
				person.id = username.id;
				//Object.freeze(person);
				console.info(nombreUsuario + " nom yyy id " + person.id);
				location.href = "/perfilVendedor.html";
				console.info(person);

			}
			else {
				location.href = "/registroServicio.html";
			}
		}
		else {
			alert("ContraseÃ±a incorrecta");
		}
	}

	function salvarServicio(user) {
		//console.info($("#usuario").val());
		var flag=true;
		var nameServicio = $("#nombreServicio").val();
		var descripcion = $("#descripcion").val();
		var tipo = $("#palabra").val();
		var f = new Date();
		var date = f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear();
		if(user==null){
			apiUsuario.getUsuarioByNombre(localStorage.getItem("selectedUser"), salvarServicio);
		}else{
			map = {
				"idVendedor": user.id, ////LEER///////// parametro 1 es ID del vendedor (por ahora esta quemado como 1, pero hay que buscar pasar el id del loggeado pa que traiga los servicios del loggeado)
				"nombre": nameServicio,
				"descripcion": descripcion,
				"creationdate": date
			};
			console.info(user.id+ "esto aqui :()");
			console.info(map+" yo tambien ");
			$.getScript("js/servicios.js", function() {apiServicios.crearServicio(map,map.nombre); });
			stomp.addService(map);
			;
		}
	}
	

	function setUserLogged(nickname) {
		console.log(nickname);
		localStorage.setItem("selectedUser", nickname);
	}

	function setRoomName(name) {
    		console.log(name);
    		localStorage.setItem("selectedRoom", name);
    	}
	
	function printUserLogged() {
		if (localStorage.getItem("selectedUser") !== undefined) {
			console.log('user');
			console.log(localStorage.getItem("selectedUser"));
		}

	}
	function salvar() {

		var nameUsuario = $("#usuario").val();
		var usuarioemail = $("#usuarioemail").val();
		var Contraseña = $("#Contraseña").val();
		var tipo = $("#tipo").val();
		console.info(nameUsuario);
		console.info(usuarioemail);
		console.info(Contraseña);
		console.info(tipo);
		var map = {
			"nombre": nameUsuario,
			"email": usuarioemail,
			"tipo": tipo,
			"password": Contraseña,
			"numcompras": 0
		};
		$.getScript("js/usuario.js", function() { apiUsuario.crear(map, nameUsuario); });
	}
	function getServicios() {
		//apiUsuario.getServicios(table);
		printUserLogged();
		apiServicios.getServicios(cards);
		stomp.connectAndSubscribeServicio();
	}

	function getServiciosByVendedor() {

		apiUsuario.getUsuarioByNombre(localStorage.getItem("selectedUser"), getUsuarioByNombre);

	}
	function getUsuarioByNombre(user) {
		//apiUsuario.getServicios(table);
		////LEER///////// parametro 1 es ID del vendedor (por ahora esta quemado como 1, pero hay que buscar pasar el id del loggeado pa que traiga los servicios del loggeado)
		//console.log(user);
		idLogg=user.id;
		apiServicios.getServiciosByVendedor(user.id, table);
	}

	var _map = function(list) {
		return list.map(function(val) {
			return {
				id: val.id,
				nombre: val.nombre,
				descripcion: val.descripcion
			}
		})
	}

	function table(servicios) {
		servicios = _map(servicios);
		$("#body").html("");
		servicios.map(function(servicio) {
			$('#body')
				.append(
					'<tr><td>'
					+ servicio.nombre + '</td><td>'
					+ servicio.descripcion + '</td>' +
					"<td><form>" +
					"<button type='button' class='btn btn-primary' onclick='app.eliminarServicio(" + servicio.id + ")'>Eliminar</button>" +
					"<button type='button' class='btn btn-primary' onclick='app.actualizarServicio(" + servicio.id + ")'>Actualizar</button>" +
					"</form></td>," + '</tr>'
				);
		});
		apiServicios.getServiciosByVendedor(idLogg, table);
	}
	function actualizarServicio(id) {

		var seleccion = $("#tabla");
		var nameS = '<label id="nameS" for="nombre">Nueva descripcion:</label>'
		//var descrip= '<label id="descripcion" for="nombre">Nueva descripcion:</label>'
		var in1 = '<textarea type="text" id="descripcion" rows="4" cols="50" name="descripcion" placeholder="Descripcion Servicio">';
		//var in2='<textarea id="descripcion"	rows="4" cols="50" name="descripcion" form="usrform" placeholder="Descripcion">';        
		//var inGenre = '<input type="text" id="descripcion" name="genre" placeholder="Descripcion servicio">';
		var id1 = '<br id="id1">';
		//var id2 = '<br id="id2">';
		var boton = "<button type='button' class='btn btn-primary' onclick='app.actualizarServicioSeleccionado(" + id + ")'>Actualizar servicio</button>";

		seleccion.append('<p>.</p>');
		seleccion.append(nameS);
		seleccion.append(in1);
		seleccion.append(id1);
		//seleccion.append(descrip);
        /*seleccion.append(in2);
        seleccion.append(id2);*/
		seleccion.append(boton);


		//rellenodata=true;

	}

	function eliminarServicio(id) {
		console.info(id);
		$.getScript("js/servicios.js", function() {
			apiServicios.eliminarServicio(id);
		});

	}

	function actualizarServicioSeleccionado(id) {
		////////IMPLEMENTAR (DEBERIA IR LA PETICION DE ACTUALIZAR A SERVICIOS.JS Y DE AHI AL BACK)
		var valores = { id: id, descripcion: $("#descripcion").val(), nombre: "", creacion: "", idVendedor: "1" };
		console.info(valores.descripcion);
		console.info($("#descripcion").val());
		apiServicios.actualizarServicioSeleccionado(id, valores);
	}

	function cards(servicios) {
		servicios = _map(servicios);
		servicios.map(function(servicio) {
			// console.log(servicio.nombre);
			// console.log(servicio.descripcion);
			$('#row')
				.append(
					'<div class=product--orange>' +
					'<div class=product_inner>' +
					'<img src=https://paizbmw.es/wp-content/uploads/2017/04/Mecanica.png width=300>' +
					'<p style = "font-family:arial; font-size: 1.8em;">' + servicio.nombre + '</p>' +
					"<button type='button' onclick='app.servicioSeleccionado("+servicio.id+")'>Ver </button>" +
					'</div>' +
					'<div class=product_overlay>' +
					'<h2>Ofertar</h2>' +
					'<i class=fa fa-check></i>' +
					'</div>' +
					'</div>'
				);
		});
		
	}
	
	function servicioSeleccionado(id,name){
		console.info(id);
		//limpiar
		$('#boton').empty();
		$('#row').empty();
		
		//impimir sericio
		apiServicios.getServicioById(id,"no me borres",imprimirServicio);
	}
	
	function imprimirServicio(servicio){
		idServicio=servicio.id;
		//console.info(servicio.id);
		setRoomName(idServicio);
		console.info(localStorage.getItem("selectedRoom"));
		var seleccion = $("#boton");
		 $("#container").append( "<p>.</p><div class=col-md-12>"+
			 "<h2>"+servicio.nombre+"</h2>"+
			"<div class=jumbotron>"+
				"<h2>"+
					"Descripcion:"+
				"</h2>"+
				"<div>"+servicio.descripcion+"</div>"+
				"<p>"+
					"<a class='btn btn-primary btn-large' href='/chat.html'>Ofertar Servicio</a>"+
				"</p>"+
			"</div>"+
			"<div class=card>"+
				"<h5 class=card-header>"+
					"Comentarios"+
				"</h5>"+
				"<div class=card-body id='buscar'>"+
					"<button type='button' class='btn btn-primary' onclick='app.mapComentarios()'>mostrar comentarios</button>"+
				"</div>"+
				"<div class=card-footer>"+
					"<textarea id='nuevoComentario' rows='4' cols='50' name='escribe tu comentario' form='usrform' placeholder='escribe tu comentario'></textarea>"+
					"<button type='button' class='btn btn-primary' onclick='app.insertarComentario(nuevoComentario.value)'>agregar</button>"+
				"</div>"+
			"</div>"+
		"</div> <p>.</p>");
	}
	function mapComentarios(){
		apiServicios.getComentariosById(idServicio,mapComentariosById);
	}
	function mapComentariosById(comentarios){
		
		console.info(comentarios);
		var flag= $("#tabla1");
		// var table="<table><tr><td id='table1'style='width: 100px; color: red;'>comentarios</td>";
		if(flag!=null){
			$("#titulo").remove();
			$("#tabla1").remove();
		}
		var table =" <h2 id='titulo'>comentarios:</h2>"+
		"<table class='table' id='tabla1'>"+
			"<thead class='thead-dark'>"+
				"<tr>"+
					"<th scope='col'>ID Usuario</th>"+
					"<th scope='col'>comentario</th>"+
					"<th scope='col'>fecha</th>"+
				"</tr>";
		// comentarios = _map(comentarios)
		//console.info(comentarios);
		if(comentarios.lenght>1){
		comentarios.map(function(comentario) {
			
			
			table+=
					'<tr><td>'
					+ comentario.idusuario + '</td><td>'
					+ comentario.comentario + '</td><td>'
					+ comentario.fecha + '</td>' + '</tr>';
				
		});
		table+="</thead>"+"</table>";
		$("#buscar").append(table);
		
		
	}else{
				table+=
					'<tr><td>'
					+ comentarios.idusuario + '</td><td>'
					+ comentarios.comentario + '</td><td>'
					+ comentarios.fecha + '</td>' + '</tr>'
				;
				table+="</thead>"+"</table>";
				$("#buscar").append(table);
				
	}
	
		
	}
	function insertarComentario(nuevoComentario){
		
		if(idLogg==0){
			apiUsuario.getUsuarioByNombre(localStorage.getItem("selectedUser"), mapUsuario);
		}else{
		var f = new Date();
		var date = f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear();
		console.info(idServicio);
		console.info(idLogg);
		console.info(date);
		console.info(nuevoComentario);
		var map = {
				"idservicio": idServicio, ////LEER///////// parametro 1 es ID del vendedor (por ahora esta quemado como 1, pero hay que buscar pasar el id del loggeado pa que traiga los servicios del loggeado)
				"idusuario": idLogg,
				"creationdate": date,
				"comentario": nuevoComentario
		};
	
		apiServicios.crearComentario(map);
		}
		
	}
	function mapUsuario(user){
		idLogg =user.id;
	}
	
	function perfiles(){
		apiUsuario.getUsuarioByNombre(localStorage.getItem("selectedUser") ,relleno);
	}
	function relleno(user){
		var perfil = "perfilVendedor.html";
		
		if(user.tipo==2){
			perfil="perfilComprador.html";
		}
		
		$("#sidebar").append(
			"<div class=menu_section>"+
            "<ul>"+
                "<li><a href="+perfil+">PERFIL</a></li>"+
                "<li><a href='about.html'>About</a></li>"+
            "</ul>"+
        "</div>");
	}
	
	function compras(){
		
	}
	
	function favoritos(){
	
		$("#container").append(
			"<div class=container-fluid>"+
	"<div class=row>"+
		"<div class='col-md-12'>"+
			"<div class=list-group>"+
				 "<a class=list-group-item list-group-item-action active>Favoritos del dia</a>"+
				"<div class=list-group-item>"+
					"List header"+
				"</div>"+
				"<div class=list-group-item>"+
					"<h4 class=list-group-item-heading>"+
						"List group item heading"+
					"</h4>"+
					"<p class=list-group-item-text>"+
						"..."+
					"</p>"+ 
				"</div>"+
				"<div class=list-group-item justify-content-between>"+
					"Help <span class=badge badge-secondary badge-pill>14</span>"+
				"</div> <a href='#' class=list-group-item list-group-item-action active justify-content-between>Home <span class=badge badge-light badge-pill>14</span></a>"+
			"</div>"+
			"<div class=jumbotron>"+
				"<h2>"+
					"Bienvenido"+
				"</h2>"+
				"<p>"+
					"Estos son los articulos que te han gustado hoy! Contratalos YA! c:"+
				"</p>"+
			"</div>"+
			"<div class=media>"+
				"<img class=mr-3 alt='Bootstrap Media Preview' src='https://www.layoutit.com/img/sports-q-c-64-64-8.jpg' />"+
				"<div class=media-body>"+
					"<h5 class=mt-0>"+
						"Vendedor"+
					"</h5>Hola el servicio por el que preguntaste lo haría por un valor de $100 y podria hacerlo el sabado en la mañana..."+
					"<div class=media mt-3>"+
						 "<a class=pr-3 href='#'><img alt='Bootstrap Media Another Preview' src='https://www.layoutit.com/img/sports-q-c-64-64-2.jpg' /></a>"+
						"<div class=media-body>"+
							"<h5 class=mt-0>"+
								"Comprador"+
							"</h5>Me parece perfecto, mi direccion es 2600 14th St NW, Washington, DC 20009... te espero"+
						"</div>"+
					"</div>"+
				"</div>"+
			"</div><span class=badge badge-info></span>"+
		"</div>"+
	"</div>"+
"</div> <p>.<p>");
	}
	
	
	return {
		setUserLogged: setUserLogged,
		printUserLogged: printUserLogged,
		getServicios: getServicios,
		salvar: salvar,
		salvarServicio: salvarServicio,
		validarCuenta: validarCuenta,
		inicio: inicio,
		getServiciosByVendedor: getServiciosByVendedor,
		eliminarServicio: eliminarServicio,
		actualizarServicio: actualizarServicio,
		actualizarServicioSeleccionado: actualizarServicioSeleccionado,
		servicioSeleccionado:servicioSeleccionado,
		insertarComentario:insertarComentario,
		mapComentariosById:mapComentariosById,
		mapComentarios:mapComentarios,
		perfiles:perfiles,
		compras:compras,
		favoritos:favoritos

	}





})();