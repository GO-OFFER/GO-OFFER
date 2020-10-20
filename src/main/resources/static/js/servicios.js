apiServicios = (function() {
  	var url = "http://localhost:8080/servicios"
   //var url = "https://go-offer.herokuapp.com/servicios/"
    function getServiciosByVendedor(id, callback) {//
        $.getJSON("http://localhost:8080/servicios/" + id, function (data) {
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

	}
	
	
	function eliminarServicio(id){
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
				//callback();
                resolve('SUCCESS');

            }).fail(function (msg) {
                reject('FAIL');
            });
        });

	}


	return {
		getServicios: getServicios,
		crearServicio:crearServicio,
		eliminarServicio:eliminarServicio,
		getServiciosByVendedor:getServiciosByVendedor
	}

})();
