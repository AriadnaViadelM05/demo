package com.example.demo.model.serveis;

import com.example.demo.model.entitat.User;
import com.example.demo.repositoris.RepositoriUser;
import com.example.demo.security.ConfiguracioSeguretatWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RepositoriUser users;
    public void afegir(User e) {
        System.out.println("xifrat"+ e);
        users.save(e);
    }
    public List<User> llistat() {
        return users.findAll();
    }

    public User consultaPerId(String s) {
        return users.findById(s).orElse(null);
    }


    @PostConstruct
    public void init() {
        users.save( new User("admin",new BCryptPasswordEncoder().encode("admin"), "ADMIN"));
        users.save( new User("user", new BCryptPasswordEncoder().encode("user"), "USER"));

    }


}
