package com.example.demo.model.entitat;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class Empleat {
    private int id;
    private String nom;
    private String email;
    private String telefon;
    private boolean mayordeedad;

    public Empleat(int id, String nom, String email, String telefon, boolean mayordeedad) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telefon = telefon;
        this.mayordeedad = mayordeedad;
    }
}
