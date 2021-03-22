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
   public PasswordEncoder passwordEncoder() {
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
              .antMatchers("/", "/index").permitAll()
              .antMatchers("/empleats/new", "/empleats/eliminar").hasRole("ADMIN")
              .antMatchers("/empleats/edit/{id}").hasRole("USER")
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .loginPage("/login").permitAll()
              .failureUrl("/login_error")
              .and()
              .logout().permitAll();
   }

}
