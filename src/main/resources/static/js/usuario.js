apiUsuario = (function() {
	
	 function getServiciosByVendedor(id, callback) {//
        $.getJSON("https://go-offer.herokuapp.com/servicios/" + id, function (data) {
            callback(data);
        });
    }
	function getUsuairoByNombre(name, callback) {//
        $.getJSON("https://go-offer.herokuapp.com/servicios/"+name, function (data) {
            callback(data);
        });
    }
	function checkPassword(username,callback) {
	    console.log(username);
	    const promise = new Promise((resolve, reject) => {
                $.ajax({
                    url: "usuarios/" + username ,
                    success: function(result) {
                      callback(result);
                    },
                     error: function(XMLHttpRequest, textStatus, errorThrown) {
                         alert("Usuario no encontrado");

                    } ,
                    async: true
                });
        });
    }
	function crear(usuario, name) {
		var fun = JSON.stringify(usuario);
		const promise = new Promise((resolve, reject) => {
			$.ajax({
				url: "https://go-offer.herokuapp.com/usuarios/" + name, ///https://go-offer.herokuapp.com-----http://localhost:8080
				type: 'POST',
				data: fun,
				contentType: "application/json"
			}).done(function() {
				Swal.fire({
					position: 'top-end',
					icon: 'success',
					title: 'Registro exitoso',
					showConfirmButton: false,
					timer: 1500
				})
				resolve('SUCCESS');

			}).fail(function(msg) {
				reject('FAIL');
			});
		});

	}
/*	function crearServicio(map, name) {
		var fun = JSON.stringify(map);
		const promise = new Promise((resolve, reject) => {
			$.ajax({
				url: "http://localhost:8080/servicios/"+name,
				type: 'POST',
				data: fun,
				contentType: "application/json"
			}).done(function() {
				Swal.fire({
					position: 'top-end',
					icon: 'success',
					title: 'Registro exitoso',
					showConfirmButton: false,
					timer: 1500
				})
				resolve('SUCCESS');

			}).fail(function(msg) {
				reject('FAIL');
			});
		});

	}*/
	
	/*function eliminarServicio(id,callback){
        ///var fun = JSON.stringify(funcion);

        const promise = new Promise((resolve, reject) => {
            $.ajax({
                url: "http://localhost:8080/servicios/" + id,
                type: 'DELETE',
                //data: fun,
                contentType: "application/json"
            }).done(function () {
				Swal.fire({
					position: 'top-end',
					icon: 'success',
					title: 'Servicio eliminado',
					showConfirmButton: false,
					timer: 1500
				})
				callback();
                resolve('SUCCESS');

            }).fail(function (msg) {
                reject('FAIL');
            });
        });

	}*/
	/*function checkPassword(username,callback) {
	    console.log(username);
	    const promise = new Promise((resolve, reject) => {
                $.ajax({
                    url: "usuarios/" + username ,
                    success: function(result) {
                      callback(result);
                    },
                     error: function(XMLHttpRequest, textStatus, errorThrown) {
                         alert("Usuario no encontrado");

                    } ,
                    async: true
                });
        });
    }*/
	return {
		crear: crear,
		//crearServicio:crearServicio,
		checkPassword:checkPassword,
		getServiciosByVendedor:getServiciosByVendedor
		//eliminarServicio:eliminarServicio
	}

})();
