package com.example.demo.model.entitat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Seleccion implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
//    @OneToMany(mappedBy ="seleccion")
//    private Set<Jugador> jugadors;

    public Seleccion(String nom) {
        this.nom = nom;
    }
}
