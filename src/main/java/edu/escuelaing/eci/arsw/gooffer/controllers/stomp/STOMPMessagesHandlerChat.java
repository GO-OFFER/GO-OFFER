package edu.escuelaing.eci.arsw.gooffer.controllers.stomp;

import edu.escuelaing.eci.arsw.gooffer.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class STOMPMessagesHandlerChat {
    @Autowired
    SimpMessagingTemplate msgt;

    /*@MessageMapping("/chat.room.send")
    public void sendMessage(ChatMessage chatMessage) {
        System.out.println("Mensaje enviado");
        msgt.convertAndSend("/topic/public", chatMessage);
    }*/
    @MessageMapping("/stompendpoint.{room}.send")
    public void sendMessage(ChatMessage chatMessage, @DestinationVariable("room") String room) {
        System.out.println("Mensaje enviado");
        msgt.convertAndSend("/topic/stompendpoint."+room, chatMessage);
    }

}
