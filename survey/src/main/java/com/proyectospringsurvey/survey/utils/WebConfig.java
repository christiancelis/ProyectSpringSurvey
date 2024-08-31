package com.proyectospringsurvey.survey.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("") // Permite cualquier origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Permite estos métodos
                .allowedHeaders("*") // Permite cualquier encabezado
                .allowCredentials(true); // Permite enviar credenciales (si es necesario)
    }
}