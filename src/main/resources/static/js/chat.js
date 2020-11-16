chat = (function(){
    var mensaje;
    var stompClient = null;
    var usuario;
    var room;

    class ChatMessage {
        constructor(content, type){
            this.content = content;
            this.type = type;
        }
    }

    function init(){
        $("#container-super").hide();
        $("#envios").hide();

    }
    function init2(){
        connectAndSubscribe();
    }
    function connectAndSubscribe(){
        console.info('Connecting to WS...');
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, function (frame){
            console.log('Connected: ' + frame);
            console.log('Connected: ' + room);
            stompClient.subscribe("/topic/public."+room, function (eventbody){
                console.log("Recibido");
                var mensajeARepartir = JSON.parse(eventbody.body);
                agregar(mensajeARepartir)
            });
        });
    }

    function enviarMensaje(){
        mensaje = document.querySelector('#contenido');

        var chatMessage = {
                content: mensaje.value,
                type: 'CHAT',
                sender: usuario
            };
        console.log(chatMessage);
        stompClient.send("/app/chat."+room+".send", {}, JSON.stringify(chatMessage));
    }

    function agregar(contenido){

        //var contenido = $("#contenido").val();

        console.log(contenido.sender)
        console.log(usuario)
        console.log(contenido.sender==usuario)
        if(contenido.type == "CHAT" && contenido.sender==usuario){
            var mensaje = "<div class='container'> <img src='/images/avatar.png' alt='Avatar' style='width: 100%;'> <p>"+contenido.content+"</p> <span class='time-left'>"+contenido.sender+"</span> </div>";
            $("#container-super").append(mensaje);
        }else if(contenido.type == "CONEXION" && contenido.sender!=usuario){
            var mensajeConexion = "<div class='container' style='width: 50%;'> <img style='width: 50%;'> <p>"+contenido.content+"</p> </div>";
            $("#container-super").append(mensajeConexion);
        }
        else if(contenido.type == "CHAT" && contenido.sender!=usuario){
            var mensaje = "<div class='container darker'> <img src='/images/avatar.png' alt='Avatar' class='right' style='width: 100%;'> <p>"+contenido.content+"</p> <span class='time-left'>"+contenido.sender+"</span> </div>";
            $("#container-super").append(mensaje);
        }

    }

    function ingresar(){
        usuario = localStorage.getItem("selectedUser")
        //usuario = $("#nombreUsuario").val();
        //room = $("#room").val();
        $("#logear").css({
              display: 'none',
              visibility: 'hidden'
            });
        $("#container-super").show();
        $("#envios").show();
        var mensajeInicial1 = "<div class='container'> <img src='/images/avatar.png' alt='Avatar' style='width: 100%;'> <p>Hola "+usuario+", te doy la bienvenida </p> </div>";
        var mensajeInicial2 = "<div class='container darker'> <img src='/images/avatar.png' alt='Avatar' class='right' style='width: 100%;'> <p>�Disfrutalo!</p> </div>";
        $("#container-super").append(mensajeInicial1);
        $("#container-super").append(mensajeInicial2);
        conexion();

    }

    function conexion(){
        var chatMessage = {
                content: usuario+" se ha conectado",
                type: 'CONEXION',
                sender: usuario
            };
        stompClient.send("/app/stompendpoint."+room+".send", {}, JSON.stringify(chatMessage));

    }
  /*  $(function (){
        $("#conectar").click(function(){ init2(); });
        $("#enviar").click(function(){ enviarMensaje(); });
        $("#ingresar").click(function(){ ingresar(); });

    });*/
	return {
		init:init,
		connectAndSubscribe:connectAndSubscribe,
		conexion:conexion,
		agregar : agregar,
		ingresar : ingresar,
		enviarMensaje : enviarMensaje,

	}
})();