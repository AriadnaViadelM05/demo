package com.example.demo.model.serveis;

import com.example.demo.model.entitat.Empleat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmpleatService {
    private List<Empleat> repositori = new ArrayList<>();

    public void afegir(Empleat e) {
        repositori.add(e);
    }
    public List<Empleat> llistat() {
        return repositori;
    }
    public List<Empleat> llistatOrdenatPerNom(){
        Collections.sort(repositori, new Comparator<Empleat>() {
            @Override
            public int compare(Empleat t1, Empleat t2) {
                return (t1.getNom()).compareTo((t2.getNom()));
            }
        });
        return repositori;
    };

    @PostConstruct
    public void init() {
        repositori.addAll(
                Arrays.asList(
                        new Empleat(1, "Montse Madridejos", "montse@itb.cat", "677123456",true),
                        new Empleat(2, "Alberto Vila", "alberto@itb.cat", "699876543",false),
                        new Empleat(3, "Robert López", "robert@bbc.com", "123456789",true),
                        new Empleat(4, "zzzzzzzzzzzzzzz", "robert@bbc.com", "123456789",true),
                        new Empleat(5, "aaaaaaaaaaaaaaaaaaa", "robert@bbc.com", "123456789",true)
                )
        );
    }
}
