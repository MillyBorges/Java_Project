package br.com.fecaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

      @Bean
      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http
                  .csrf(csrf -> csrf.disable()) // Desabilita CSRF (necessário para permitir POST sem proteção CSRF)
                  .authorizeHttpRequests(auth -> auth
                          .anyRequest().permitAll() // Permite todas as requisições, sem autenticação
                  );

          return http.build();
      }
}