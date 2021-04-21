package com.example.demo.repositoris;

import com.example.demo.model.entitat.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriUser extends JpaRepository<MyUser,String> {
}
