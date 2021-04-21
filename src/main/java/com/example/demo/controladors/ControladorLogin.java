package com.example.demo.controladors;

import com.example.demo.model.entitat.MyUser;
import com.example.demo.model.serveis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLogin {
    @Autowired
    private UserService servei;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String afegirUsuari(Model m) {
        m.addAttribute("userForm", new MyUser());
        return "register";
    }

    @PostMapping("/register")
    public String afegirSubmit(@ModelAttribute MyUser user) {
        MyUser aux = new MyUser(user.getUsername(), user.getPassword());
        servei.afegir(aux);
        return "redirect:/login";
    }

}
