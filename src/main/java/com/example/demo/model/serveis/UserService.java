package com.example.demo.model.serveis;

import com.example.demo.model.entitat.MyUser;
import com.example.demo.repositoris.RepositoriUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RepositoriUser users;
    public void afegir(MyUser e) {
        System.out.println("xifrat"+ e);
        users.save(e);
    }
    public List<MyUser> llistat() {
        return users.findAll();
    }

    public MyUser consultaPerId(String s) {
        return users.findById(s).orElse(null);
    }


    @PostConstruct
    public void init() {
        users.save( new MyUser("admin",new BCryptPasswordEncoder().encode("admin"), "ADMIN"));
        users.save( new MyUser("user", new BCryptPasswordEncoder().encode("user"), "USER"));

    }


}
