package com.example.demo.repositoris;

import com.example.demo.model.entitat.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriUser extends JpaRepository<User,String> {
}
