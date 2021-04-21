package com.example.demo.model.entitat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MyUser {
    @Id
    private String username;
    private String password;
    private String rol;
//    public User() {
//        rol = "user";
//    }

    public MyUser(String user, String pwd) {
        username=user;
        password=new BCryptPasswordEncoder().encode(pwd);
        rol="user";
    }

//    public User(String username, String password, String rol) {
//        this.username = username;
//        this.password = new BCryptPasswordEncoder().encode(password);;
//        this.rol = rol;
//    }


}
