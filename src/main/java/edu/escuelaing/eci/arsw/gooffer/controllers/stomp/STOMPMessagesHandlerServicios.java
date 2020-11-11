package edu.escuelaing.eci.arsw.gooffer.controllers.stomp;

import edu.escuelaing.eci.arsw.gooffer.model.Servicio;
import edu.escuelaing.eci.arsw.gooffer.services.ServiciosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class STOMPMessagesHandlerServicios {

        @Autowired
        SimpMessagingTemplate msgt;

        @Autowired
        ServiciosServices serviciosServices;

        @MessageMapping("/services.{name}")
        public void handleChosenService(Servicio servicio, @DestinationVariable("name") String nombre){
            //Guarda servicio
            System.out.println("Aceptacion de servicio");
            System.out.println(servicio);
            //serviciosServices.saveServicio(new Servicio(servicio.getIdVendedor(),servicio.getNombre(),servicio.getDescripcion(),servicio.getCreacion()));
            msgt.convertAndSend("/topic/services",servicio);
        }
}
