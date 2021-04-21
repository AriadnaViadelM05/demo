package com.example.demo.controladors;



import com.example.demo.model.entitat.Jugador;
import com.example.demo.model.serveis.JugadorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorJugadors {
    @Autowired
    private JugadorsService servei;

    @GetMapping("/jugadors/list")
    public String llistar(Model m) {
        m.addAttribute("llistaJugadors", servei.llistat());
        return "list";
    }

    @GetMapping("/jugadors/new")
    public String afegirJugador(Model m) {
        m.addAttribute("jugadorForm", new Jugador());
        return "afegir";
    }

    @PostMapping("/jugadors/new/submit")
    public String afegirSubmit(@ModelAttribute("jugadorForm") Jugador jugador) {
        servei.afegir(jugador);
        return "redirect:/jugadors/list";
    }

    @GetMapping("/jugadors/eliminar")
    public String eliminarJugador(@RequestParam("id") int id) {
        servei.eliminarPerId(id);
        return "redirect:/jugadors/list";
    }

    @PostMapping("/jugadors/edit/submit")
    public String editarSubmit(@ModelAttribute("jugadorForm") Jugador jugador) {
        servei.substituir(jugador);
        return "redirect:/jugadors/list";
    }

    @GetMapping("/jugadors/edit/{id}")
    public String editarJugador(@PathVariable("id") int id, Model m) {
        m.addAttribute("jugadorForm", servei.consultaPerId(id));
        return "afegir";
    }


    @GetMapping("/jugadors/consultaid")
    public String consultaPerId(@RequestParam("id") int id, Model m) {
        m.addAttribute("llistaJugadors", servei.consultaPerId(id));
        return "list";
    }
}
