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
                location.href = "/registroServicio.html"
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
		inicio:inicio,

	}





})();