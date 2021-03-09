package com.example.demo.security;

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

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
              .inMemoryAuthentication()
              .passwordEncoder(new BCryptPasswordEncoder())
              .withUser("ari")
              .password("0000")
              .roles("vip");
   }
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http

              .authorizeRequests()
              .antMatchers("/", "/hola").permitAll()
              .antMatchers("/secret").authenticated()
              .anyRequest().authenticated();
//              .and()
//              .formLogin()
//              .loginPage("/login")
//              .permitAll();
//              .and()
//              .logout()
//              .permitAll();
   }

}
