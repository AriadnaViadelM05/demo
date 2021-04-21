package com.example.demo.model.serveis;

import com.example.demo.model.entitat.Jugador;
import com.example.demo.model.entitat.MyUser;
import com.example.demo.model.entitat.Seleccion;
import com.example.demo.repositoris.RepositoriJugadors;
import com.example.demo.repositoris.RepositoriUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class JugadorsService {
    @Autowired
    private RepositoriJugadors jugadors;
    public void afegir(Jugador e) {
        jugadors.save(e);
    }
    public List<Jugador> llistat() {
        return jugadors.findAll();
    }

    public Jugador consultaPerId(long id){
        return jugadors.findById(id).orElse(null);
    }
    public void eliminarPerId(long id){
        jugadors.deleteById(id);
    }
    public void substituir(Jugador e) {
        jugadors.save(e);
    }


    @PostConstruct
    public void init() {
        Seleccion seleccion = new Seleccion("USA");
        jugadors.saveAll(
                Arrays.asList(
                        new Jugador("LeBron James", 28, "LeBronJames@gmail.com", "677123456",seleccion),
                        new Jugador("Kobe Bryant", 25, "KobeBryant@gmail.com", "699876543",seleccion),
                        new Jugador("Bill Russell", 21, "BillRussell@gmail.com", "653456789",seleccion),
                        new Jugador("Larry Bird ", 30, "LarryBird@gmail.com", "693456789",seleccion),
                        new Jugador("Shaquille O'neal", 19, "ShaquilleO'neal@gmail.com", "613456789",seleccion)

                )
        );
    }
}
