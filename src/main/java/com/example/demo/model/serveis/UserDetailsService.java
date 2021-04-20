package com.example.demo.model.serveis;

import com.example.demo.model.entitat.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService servei;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        User u = servei.consultaPerId(s); //User POJO
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (u != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        }
        else throw new UsernameNotFoundException("user no existeix");
        return builder.build();
    }


}
