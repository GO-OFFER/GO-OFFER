app = (function() {

    function inicio() {
		var nombreusuario = $("#usuario").val();
		$.getScript("js/usuario.js", function() { api.checkPassword(nombreusuario,validarCuenta); });
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
                location.href = "/perfilVendedor.html"

            }
            else{
               location.href = "/registroServicio.html"
            }
        }
        else {
            alert("ContraseÃ±a incorrecta");
        }
    }

	function salvarServicio() {

		
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
		}
		$.getScript("js/usuario.js", function() { api.crearServicio(map, "prueba12"); });
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
		}
		$.getScript("js/usuario.js", function() { api.crear(map, nameUsuario); });
		
	function getServiciosByVendedor() {
        
        $.getScript(moduloApiclient, function(){
           api.getServiciosByVendedor("1", mapElemtosObjetos);
        });
    }

    function mapElemtosObjetos(datos) {
        var mapeoDatos = datos.map(function (val) {
            return {nombre: val.nombre, 
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
                    va.movie.name= movie.movieName;
                    va.movie.genre= movie.genre;
            var fila = '<tr><td>' + movie.movieName + '</td><td>' 
				+ movie.genre + '</td><td>' 
				+ movie.hour + '</td><td>' + 
				"<input type='button' class='show' value='Disponibilidad' onclick=" + 
				"app.busquedaSillas()" + 
				"></input>"+"<input type='button' class='show' value='Conectarse' onclick=" + 
				"app.busquedaSillas()" + 
				"></input>"	+ '</tr>';
           
			
            tblBody.append(fila);
        })
		if(rellenodata){app.busquedaSillas(); rellenodata=false;}
        tabla.append(tblBody);
        tabla.append("</tbody>");
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
	}
	return {
		salvar: salvar,
		salvarServicio:salvarServicio,
		validarCuenta:validarCuenta,
		inicio:inicio

	}





})();