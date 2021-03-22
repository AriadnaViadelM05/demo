package com.example.demo.model.serveis;

import com.example.demo.model.entitat.Empleat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmpleatService {
    private List<Empleat> empleats = new ArrayList<>();

    public void afegir(Empleat e) {
        empleats.add(e);
    }

    public List<Empleat> llistat() {
        return empleats;
    }

    public Empleat consultaPerId(int id) {
        Empleat busqueda = new Empleat();
        for (Empleat e : empleats) {
            if (e.getId() == id) {
                busqueda = e;
                break;
            }
        }
        return busqueda;
    }

    public void eliminarPerId(int id) {

        empleats.removeIf(e -> e.getId() == id);
    }

    public void substituir(Empleat e) {
        eliminarPerId(e.getId());
        empleats.add(e);
    }



    @PostConstruct
    public void init() {
        empleats.addAll(
                Arrays.asList(
                        new Empleat(1, "Montse Madridejos", "montse@itb.cat", "677123456",true),
                        new Empleat(2, "Alberto Vila", "alberto@itb.cat", "699876543",false),
                        new Empleat(3, "Robert López", "robert@bbc.com", "123456789",true)
                )
        );
    }
}
