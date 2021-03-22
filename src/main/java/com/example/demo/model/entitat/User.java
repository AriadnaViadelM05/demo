package com.example.demo.model.entitat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String id;
    private String name;
    private String password;
    private String rol;
}
