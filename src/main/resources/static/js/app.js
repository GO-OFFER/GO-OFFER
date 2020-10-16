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
		
	function getServiciosByVendedor() {
        $.getScript("js/usuario.js", function(){
           api.getServiciosByVendedor("1", mapElemtosObjetos);
        });
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
		salvar: salvar,
		salvarServicio:salvarServicio,
		validarCuenta:validarCuenta,
		inicio:inicio,
		getServiciosByVendedor:getServiciosByVendedor,
		eliminarServicio:eliminarServicio

	}





})();