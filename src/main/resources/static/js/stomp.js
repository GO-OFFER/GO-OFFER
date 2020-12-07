stomp =( function (){
    var stompClient = null;
    function init(){
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
    };
    class Service {
        constructor(idVendedor, nombre,descripcion,creacion) {
            this.idVendedor = idVendedor;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.creacion = creacion;
        }
    }
    var connectAndSubscribeServicio = function () {
        init();
       // console.info('Connecting to WS...');
        //var socket = new SockJS('/stompendpoint');
        //stompClient = Stomp.over(socket);
        //subscribe to /topic/TOPICXX when connections succeed
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            //stompClient.subscribe('/topic/servicios.' + fun.name, function (message) {
            stompClient.subscribe('/topic/services', function (message) {
               alert("evento recibido");
               var theObject = JSON.parse(message.body);
               console.log(theObject);
            });
        });
    };
    var addService = function (fun) {
        init();
        console.log("Publishing....");
        console.log(fun);
        console.log(stompClient);
        stompClient.connect({}, function (frame) {
            stompClient.send("/app/services."+fun.nombre, {}, JSON.stringify(fun));
        });
        app.getServicios();

    };
    var disconnect = function() {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        //setConnected(false);
        console.log("Disconnected");
    };
    return {
        init : init,
        addService : addService,
        connectAndSubscribeServicio : connectAndSubscribeServicio,
        addService : addService,
        disconnect : disconnect,
    }
})();