package com.example.demo.model.entitat;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
public class Jugador implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private int edad;
    private String email;
    private String telefon;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Seleccion seleccion;

    public Jugador(String nom, int edad, String email, String telefon) {
        this.nom = nom;
        this.edad = edad;
        this.email = email;
        this.telefon = telefon;
//        this.seleccion = seleccion;
    }
}
