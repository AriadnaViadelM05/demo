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

    public List<Empleat> llistatOrdenatPerNom(){
        List<Empleat> llistatOrdenatPerNom = empleats;
        llistatOrdenatPerNom.sort(((o1, o2) -> o1.getNom().compareTo(o2.getNom())));
        return llistatOrdenatPerNom;
    }
    public Empleat consultaPerId(int id){
        for (Empleat empleat : empleats) {
            if (empleat.getId()==id){
                return empleat;
            }
        }
        return null;
    }
    public void eliminarPerId(int id){
        empleats.removeIf(empleat -> empleat.getId() == id);
    }
    public void substituir(Empleat e) {
        for (int i = 0; i < empleats.size(); i++) {
            if (empleats.get(i).getId() == e.getId()){
                empleats.set(i,e);
            }
        }
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
