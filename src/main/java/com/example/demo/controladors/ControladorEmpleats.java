package com.example.demo.controladors;


import com.example.demo.model.entitat.Empleat;
import com.example.demo.model.serveis.EmpleatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorEmpleats {
    @Autowired
    private EmpleatService servei;

    @GetMapping("/empleats/list")
    public String llistar(Model m){
        m.addAttribute("llistatEmpleats",servei.llistat());
        return "llistat";
    }
    @GetMapping("/empleats/nom")
    public String llistarnom(Model m){
        m.addAttribute("llistarnom",servei.llistatOrdenatPerNom());
        return "llistarnom";
    }

    /* inici de l'aplicació. Anem a afegir Empleats amb un formulari*/
    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
       m.addAttribute("empleatForm",new Empleat());
        return "afegir";
    }

    @PostMapping("empleats/new/submit")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleat emp){
      servei.afegir(emp);
      return "redirect:/empleats/list";
    }
}
