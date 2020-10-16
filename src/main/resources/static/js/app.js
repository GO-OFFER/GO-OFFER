var api = apiServicios;
const app = (function() {
	
	var idServicio;
	var nombreUsuario;
	//var id;
	var person = {name: '', id: ''};
	//const { Seq } = require('immutable');
	//const myObject = { a: 1, b: 2, c: 3 };
	
// { a: 1, b: 4, c: 9 }

    function inicio() {
		nombreUsuario = $("#usuario").val();
		console.info(nombreUsuario);
		
		$.getScript("js/usuario.js", function() { api.checkPassword(nombreUsuario,validarCuenta); });
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

		console.info($("#usuario").val());
		var nameServicio = $("#nombreServicio").val();
		var descripcion = $("#descripcion").val();
		var tipo = $("#palabra").val();
		var f = new Date();
		var date= f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();
		console.info(date);
		var map = {
			"idVendedor":1,
			"nombre": nameServicio,
			"descripcion": descripcion,
			"creationdate": date
		};
		$.getScript("js/usuario.js", function() { api.crearServicio(map, "prueba1"); });
		
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
		$.getScript("js/usuario.js", function() { api.crear(map, nameUsuario); });
	}
	function getServicios() {
        //api.getServicios(table);
        api.getServicios(cards);
    }
	var _map = function (list){
    	return list.map(function(servicio){
    			return {nombre:servicio.nombre, descripcion: servicio.descripcion}
    	})
    }
	function table(servicios) {
	    servicios = _map(servicios);
	    $("#body").html("");
    	servicios.map(function(servicio) {
    		$('#body')
    			.append(
    			  `<tr>
    				<td>`+servicio.nombre+`</td>
    				<td>`+servicio.descripcion+`</td>`+
    				"<td><form><button type='button' class='btn btn-primary' onclick=''>Open</button></form></td>,"+
    			  `</tr>`
    			);
    	});
    };
    function cards(servicios) {
    	    servicios = _map(servicios);
        	servicios.map(function(servicio) {
        		   // console.log(servicio.nombre);
        		   // console.log(servicio.descripcion);
        		$('#row')
        			.append(
        			  `<div class='product--blue'>
        			     <div class='product_inner'>
        			        <img src='https://paizbmw.es/wp-content/uploads/2017/04/Mecanica.png' width='300'>
                            <p>`+servicio.nombre+`</p>
                            <p>`+servicio.descripcion+`</p>
                            <p>Vendedor</p>
                            <button>Ofertar</button>
                        </div>
                        <div class='product_overlay'>
                            <h2>Ofertar</h2>
                            <i class='fa fa-check'></i>
                        </div>
        			  </div>`
        			);
        	});
        };
	function getServiciosByVendedor() {
        /*$.getScript("js/usuario.js", function(){
           api.getServiciosByVendedor("1", mapElemtosObjetos);
        });*/
        api.getServicios(table);
    }

    function mapElemtosObjetos(datos) {
        var mapeoDatos = datos.map(function (val) {
            return {id:val.id,
					nombre: val.nombre, 
				descripcion: val.descripcion};
        })
        rellenarTabla(mapeoDatos);
    }

    function rellenarTabla(datos) {
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
    }

	function eliminarServicio(id){
		console.info(id);
		$.getScript("js/usuario.js", function(){
           api.eliminarServicio(id,getServiciosByVendedor);
        });
	
	}

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
		eliminarServicio:eliminarServicio

	}





})();