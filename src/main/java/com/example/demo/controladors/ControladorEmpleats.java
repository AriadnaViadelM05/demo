package com.example.demo.controladors;


import com.example.demo.model.entitat.Empleat;
import com.example.demo.model.serveis.EmpleatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorEmpleats {
    @Autowired
    private EmpleatService servei;

    @GetMapping("/empleats/list")
    public String llistar(Model m) {
        m.addAttribute("llistaEmpleats", servei.llistat());
        return "list";
    }

    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m) {
        m.addAttribute("empleatForm", new Empleat());
        return "afegir";
    }

    @PostMapping("/empleats/new/submit")
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleat emp) {
        servei.afegir(emp);
        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/eliminar")
    public String eliminarEmpleat(@RequestParam("id") int id) {
        servei.eliminarPerId(id);
        return "redirect:/empleats/list";
    }

    @PostMapping("/empleats/edit/submit")
    public String editarSubmit(@ModelAttribute("empleatForm") Empleat emp) {
        servei.substituir(emp);
        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/edit/{id}")
    public String editarEmpleat(@PathVariable("id") int id, Model m) {
        m.addAttribute("empleatForm", servei.consultaPerId(id));
        return "afegir";
    }

    @GetMapping("/empleats/listord")
    public String llistarOrdenat(Model m) {
        m.addAttribute("llistaEmpleats", servei.llistatOrdenatPerNom());
        return "list";
    }

    @GetMapping("/empleats/consultaid")
    public String consultaPerId(@RequestParam("id") int id, Model m) {
        m.addAttribute("llistaEmpleats", servei.consultaPerId(id));
        return "list";
    }
}
