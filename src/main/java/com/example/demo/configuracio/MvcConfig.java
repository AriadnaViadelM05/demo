package com.example.demo.configuracio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
   public void addViewControllers(ViewControllerRegistry reg) {
   reg.addViewController("/hola").setViewName("hola");
   reg.addViewController("/secret").setViewName("secret");
   reg.addViewController("/topsecret").setViewName("topsecret");

   }
}