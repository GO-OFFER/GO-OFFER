//var api = apiServicios; 
app = (function() {
	
	var idServicio;
	var nombreUsuario;
	//var id;
	var person = {name: '', id: ''};
	//const { Seq } = require('immutable');
	//const myObject = { a: 1, b: 2, c: 3 };

    function inicio() {
		nombreUsuario = $("#usuario").val();
		console.info(nombreUsuario);
		
		$.getScript("js/usuario.js", function() { apiUsuario.checkPassword(nombreUsuario,validarCuenta); });
	}
    var validarCuenta = function(username){
        var password = $('#pass').val();
        //var hash = CryptoJS.SHA256(password);
        console.log(password);
        console.log(username.nombre);
        console.log(username.tipo);
        console.log(username.password);
        sessionStorage.setItem("currentUser",username.nombre);
        sessionStorage.setItem("currentRol",username.rol);
        if (username.password == password){
            if(username.tipo === 1){
				//Seq(myObject).map(x => x * x).toObject();
                person.name= username.nombre;
				person.id= username.id;
				//Object.freeze(person);
				console.info(nombreUsuario+" nom yyy id "+ person.id);
				location.href = "/perfilVendedor.html";
				console.info(person);

            }
            else{
               location.href = "/registroServicio.html";
            }
        }
        else {
            alert("ContraseÃ±a incorrecta");
        }
    }

	function salvarServicio() {

		//console.info($("#usuario").val());
		var nameServicio = $("#nombreServicio").val();
		var descripcion = $("#descripcion").val();
		var tipo = $("#palabra").val();
		var f = new Date();
		var date= f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();
		console.info(date);
		var map = {
			"idVendedor":1, ////LEER///////// parametro 1 es ID del vendedor (por ahora esta quemado como 1, pero hay que buscar pasar el id del loggeado pa que traiga los servicios del loggeado)
			"nombre": nameServicio,
			"descripcion": descripcion,
			"creationdate": date
		};
			
		$.getScript("js/servicios.js", function() { apiServicios.crearServicio(map, "servicio"); });
		
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
        apiServicios.getServicios(cards);
    }
	function getServiciosByVendedor() {
        //apiUsuario.getServicios(table);
		////LEER///////// parametro 1 es ID del vendedor (por ahora esta quemado como 1, pero hay que buscar pasar el id del loggeado pa que traiga los servicios del loggeado)
        apiServicios.getServiciosByVendedor("1",table);
    }
	
	/*function getServiciosByVendedor() {
        $.getScript("js/usuario.js", function(){
           api.getServiciosByVendedor("1", mapElemtosObjetos);
        });
        apiServicios.getServicios(table);
    }*/

	
	var _map = function (list){
    	return list.map(function(val){
    			return {id:val.id,
					nombre: val.nombre, 
				descripcion: val.descripcion}
    	})
    }
	
	function table(servicios) {
	    servicios = _map(servicios);
	    $("#body").html("");
    	servicios.map(function(servicio) {
    		$('#body')
    			.append(
					'<tr><td>'
					+servicio.nombre+'</td><td>'
					+servicio.descripcion+'</td>'+
    				"<td><form>"+
					"<button type='button' class='btn btn-primary' onclick='app.eliminarServicio("+servicio.id+")'>Eliminar</button>"+
					"<button type='button' class='btn btn-primary' onclick='app.actualizarServicio("+servicio.id+")'>Actualizar</button>"+
					"</form></td>,"+ '</tr>'
    			);
    	});
	apiServicios.getServiciosByVendedor("1",table);
    }
	function actualizarServicio(id){
			
		var seleccion = $("#tabla");
        var nameS= '<label id="nameS" for="nombre">Nuevo nombre:</label>'
        var descrip= '<label id="descripcion" for="nombre">Nueva descripcion:</label>'
        var in1 = '<input type="text" id="movieNew" name="movie" placeholder="Nombre Servicio">';
		var in2='<textarea id="descripcion"	rows="4" cols="50" name="descripcion" form="usrform" placeholder="Descripcion"></textarea>';        
		//var inGenre = '<input type="text" id="genreNew" name="genre" placeholder="Descripcion servicio">';
        var id1 = '<br id="id1">';
        var id2 = '<br id="id2">';
		var boton = "<button type='button' class='btn btn-primary' onclick='app.actualizarServicioSeleccionado("+id+")'>Actualizar servicio</button>";

		seleccion.append('<p>.</p>');
		seleccion.append(nameS);
        seleccion.append(in1);
        seleccion.append(id1);
        seleccion.append(descrip);
        seleccion.append(in2);
        seleccion.append(id2);
		seleccion.append(boton);

		
		//rellenodata=true;

		}
	
	function eliminarServicio(id){
		console.info(id);
		$.getScript("js/servicios.js", function(){
           apiServicios.eliminarServicio(id);
        });
	
	}
	
	function actualizarServicioSeleccionado(id){
		////////IMPLEMENTAR (DEBERIA IR LA PETICION DE ACTUALIZAR A SERVICIOS.JS Y DE AHI AL BACK)
	}
	
    function cards(servicios) {
    	    servicios = _map(servicios);
        	servicios.map(function(servicio) {
        		   // console.log(servicio.nombre);
        		   // console.log(servicio.descripcion);
        		$('#row')
        			.append(
        			  '<div class=product--orange>'+
        			     '<div class=product_inner>'+
        			        '<img src=https://paizbmw.es/wp-content/uploads/2017/04/Mecanica.png width=300>'+
                            '<p style = "font-family:arial; font-size: 1.8em;">'+servicio.nombre+'</p>'+
                            '<p style = "font-family:arial; font-size: 1.7em;">'+servicio.descripcion+'</p>'+
                            '<button>Ofertar</button>'+
                        '</div>'+
                        '<div class=product_overlay>'+
                            '<h2>Ofertar</h2>'+
                            '<i class=fa fa-check></i>'+
                        '</div>'+
        			  '</div>'
        			);
        	});
        };
	
    /*function mapElemtosObjetos(datos) {
        var mapeoDatos = datos.map(function (val) {
            return {id:val.id,
					nombre: val.nombre, 
				descripcion: val.descripcion};
        })
        rellenarTabla(mapeoDatos);
    }*/

    /*function rellenarTabla(datos) {
        var tabla = $("table");
        var body = $("tbody");
        if (body != null) {body.remove();}
        
		tabla.append("<tbody>");
		var tblBody = $("tbody");
                
		datos.map(function(servicio){
			idServicio=servicio.id;
            var fila = '<tr><td>' + servicio.nombre + '</td><td>' 
				+ servicio.descripcion + '</td><td>'+ 
				"<input type='button' class='show' value='Eliminar' onclick=" + 
				"app.eliminarServicio("+servicio.id+")" +  
				"></input>"	+ '</tr>';
            tblBody.append(fila);
        });
        tabla.append(tblBody);
        tabla.append("</tbody>");
    }*/

	

		/*
		if(rellenodata){
			newFunction();
			rellenodata=false;
		}else{
			va.date=newDate;
			fecha=newDate;
			console.info(va);
			console.info(cine);
			$.getScript(moduloApiclient, function(){api.update(cine,va);});
				app.getFunctionsByCinemaAndDate();
			}*/
	
	return {
	    getServicios: getServicios,
		salvar: salvar,
		salvarServicio:salvarServicio,
		validarCuenta:validarCuenta,
		inicio:inicio,
		getServiciosByVendedor:getServiciosByVendedor,
		eliminarServicio:eliminarServicio,
		actualizarServicio:actualizarServicio,
		actualizarServicioSeleccionado:actualizarServicioSeleccionado

	}





})();