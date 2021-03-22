package com.example.demo.model.serveis;

import com.example.demo.model.entitat.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public User consultaNom(String name) {
        User busqueda = new User();
        for (User e : users) {
            if (e.getName().equals(name)) {
                busqueda = e;
                break;
            }
        }
        return busqueda;
    }

    public void afegir(User u) {

        users.add(u);
    }
    @PostConstruct
    public void init() {
        users.addAll(
                Arrays.asList(
                        new User("1", "admin", "admin", "ADMIN"),
                        new User("2", "user", "user", "USER")
                )
        );
    }


}