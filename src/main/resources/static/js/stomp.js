
var stomp = function (){
    var stompClient = null;

    class Service {
        constructor(idVendedor, nombre,descripcion,creacion) {
            this.idVendedor = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.creacion = creacion;
        }
    }
    var connectAndSubscribeServicio = function (fun) {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        //subscribe to /topic/TOPICXX when connections succeed
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/servicios.' + fun.name, function (message) {
               alert("evento recibido");
               var theObject = JSON.parse(message.body);
               //verifyAvailability(theObject.row,theObject.col);
            });
        });
    };
    var addService = function (fun) {
        var service = new Service(fun.idVendedor,fun.nombre,fun.descripcion,fun.creationdate)
        console.log("Publishing....");
        console.log(service);
        console.log(stompClient);
        stompClient.send("/app/services", {}, JSON.stringify(service));
    };
    var disconnect = function() {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        //setConnected(false);
        console.log("Disconnected");
    };
    return {
    }
})();