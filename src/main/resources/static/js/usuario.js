api = (function() {

	function crear(usuario, name) {
		var fun = JSON.stringify(usuario);
		const promise = new Promise((resolve, reject) => {
			$.ajax({
				url: "https://go-offer.herokuapp.com/usuarios/" + name,
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
	function crearServicio(map, name) {
		var fun = JSON.stringify(map);
		const promise = new Promise((resolve, reject) => {
			$.ajax({
				url: "https://go-offer.herokuapp.com/servicios/"+name,
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
	return {
		crear: crear,
		crearServicio:crearServicio
	}

})();
