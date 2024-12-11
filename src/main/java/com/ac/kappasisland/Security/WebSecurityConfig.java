package com.ac.kappasisland.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        // CORS nous empêche d’obtenir nos éléments, donc nous le démantelons
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests()
                .anyRequest().permitAll();
        return http.build();
    }

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource() {
        // Nous créons une configuration,
        CorsConfiguration configuration = new CorsConfiguration();
        // permettre notre projet Angular,
        configuration.setAllowedOrigins(List.of("http://localhost:52804"));
        // lui donner toutes les permissions,
        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        // autoriser son en-tête,
        configuration.setAllowedHeaders(List.of("*"));
        // et maintenant nous le permettons.
        configuration.setAllowCredentials(true);
        // Maintenant, il faut sauvegarder la configuration !
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
