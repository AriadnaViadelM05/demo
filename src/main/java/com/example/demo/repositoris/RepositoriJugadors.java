package com.example.demo.repositoris;

import com.example.demo.model.entitat.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriJugadors extends JpaRepository<Jugador,Long> {
}
