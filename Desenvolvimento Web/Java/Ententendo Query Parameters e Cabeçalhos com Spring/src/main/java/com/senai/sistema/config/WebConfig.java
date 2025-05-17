package com.senai.sistema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite qualquer origem com credenciais
        registry.addMapping("/**")
                .allowedOriginPatterns("*")  // Permite qualquer origem usando padrões
                .allowedMethods("*")         // Permite qualquer método HTTP (GET, POST, PUT, DELETE, etc.)
                .allowedHeaders("*")         // Permite qualquer cabeçalho
                .allowCredentials(true)      // Permite o envio de credenciais (cookies, cabeçalhos de autenticação, etc.)
                .maxAge(3600);               // Define o tempo de cache do CORS
    }
}
