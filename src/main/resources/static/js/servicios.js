apiServicios = (function() {
    //var url = "http://localhost:8080/servicios"
     var url = "https://go-offer.herokuapp.com/servicios/"
    function getServiciosByVendedor(id, callback) {//
        $.getJSON("servicios/" + id, function (data) {
            callback(data);
        });
    }
	function getServicioById(id,name,callback) {//
        $.getJSON("servicios/" + id +"/" + name, function (data) {
			callback(data);
        });
    }

	function getFavoritosById(id,callback){
		 $.getJSON("favoritos/" + id , function (data) {
			callback(data);
        });
	}
	
	function getServicios(callback) {//
	    console.log(url);
	    $.getJSON(url,(data)=>{
	                        //console.log(data);
                            callback(data);
        },null)
        /*$.getJSON("https://go-offer.herokuapp.com/servicios", function (data) {
            callback(data);
        });*/
	}
    
	function crearServicio(map, name) {
		var fun = JSON.stringify(map);
		const promise = new Promise((resolve, reject) => {
			$.ajax({
				url: "servicios/"+name,
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
	
	function saveFavorito(map) {
		var fun = JSON.stringify(map);
		const promise = new Promise((resolve, reject) => {
			$.ajax({
				url: "favoritos/nuevoFavorito",
				type: 'POST',
				data: fun,
				contentType: "application/json"
			}).done(function() {
				Swal.fire({
					position: 'top-end',
					icon: 'success',
					title: 'Nuevo favorito agregado',
					showConfirmButton: false,
					timer: 1500
				})
				resolve('SUCCESS');

			}).fail(function(msg) {
				reject('FAIL');
			});
		});

	}
	function crearComentario(map) {
		var fun = JSON.stringify(map);
		const promise = new Promise((resolve, reject) => {
			$.ajax({
				url: "comentarios/comentarioNuevo",
				type: 'POST',
				data: fun,
				contentType: "application/json"
			}).done(function() {
				Swal.fire({
					position: 'top-end',
					icon: 'success',
					title: 'Registro de comentario exitoso',
					showConfirmButton: false,
					timer: 1500
				})
				resolve('SUCCESS');

			}).fail(function(msg) {
				reject('FAIL');
			});
		});

	}
	function getComentariosById(id, callback) {//
        $.getJSON("comentarios/" + id, function (data) {
            callback(data);
        });
    }
	
	function eliminarServicio(id){
        ///var fun = JSON.stringify(funcion);

        const promise = new Promise((resolve, reject) => {
            $.ajax({
                url: "servicios/" + id,
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
				//callback();
                resolve('SUCCESS');

            }).fail(function (msg) {
                reject('FAIL');
            });
        });

	}

	function actualizarServicioSeleccionado(id,val){
	var fun = JSON.stringify(val);
        const promise = new Promise((resolve, reject) => {
            $.ajax({
                url: "servicios/" + id,
                type: 'PUT',
                data: fun,
                contentType: "application/json"
            }).done(function () {
				Swal.fire({
					position: 'top-end',
					icon: 'success',
					title: 'Servicio actualizado',
					showConfirmButton: false,
					timer: 1500
				})
                resolve('SUCCESS');

            }).fail(function (msg) {
                reject('FAIL');
            });
        });
        
            
    }

	return {
		getServicioById:getServicioById,
		getServicios: getServicios,
		crearServicio:crearServicio,
		eliminarServicio:eliminarServicio,
		getServiciosByVendedor:getServiciosByVendedor,
		actualizarServicioSeleccionado:actualizarServicioSeleccionado,
		crearComentario:crearComentario,
		getComentariosById:getComentariosById,
		saveFavorito:saveFavorito,
		getFavoritosById:getFavoritosById
	}

})();
