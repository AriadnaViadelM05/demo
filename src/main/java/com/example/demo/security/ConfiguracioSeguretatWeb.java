package com.example.demo.security;

import com.example.demo.model.serveis.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracioSeguretatWeb extends WebSecurityConfigurerAdapter {
   @Autowired
   private UserDetailsService userDetailsService;

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
              .userDetailsService(userDetailsService)
              .passwordEncoder(passwordEncoder());
   }
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http

              .authorizeRequests()
              .antMatchers("/", "/register", "/login", "/registre","/llistat").permitAll()
              .antMatchers("/jugadors/new", "/jugadors/edit/submit", "/jugadors/edit/{id}").hasRole("ADMIN")
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .loginPage("/login")
              .failureUrl("/error_login")
              .and()
              .logout()
              .permitAll();
   }

}
