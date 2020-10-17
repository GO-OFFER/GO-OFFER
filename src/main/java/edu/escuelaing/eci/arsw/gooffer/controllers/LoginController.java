package edu.escuelaing.eci.arsw.gooffer.controllers;

import edu.escuelaing.eci.arsw.gooffer.model.Usuario;
import edu.escuelaing.eci.arsw.gooffer.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginController {

    /*@Autowired
    UsuariosServices usuariosS;

    @GetMapping("/login")
    public String login(Model model, Principal principal, RedirectAttributes flash){
        if(principal != null){
            flash.addFlashAttribute("info","Ya ha iniciado sesión");
            return "redirect:/";
        }
        return "login";
    }*/


}

