package com.cr.spring_security.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // define como classe de configuraçao
@EnableWebSecurity // a classe habilita e desabilita o spring security
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        // libera o acesso ao get de /pessoas sem estar autenticado
                        auth.requestMatchers(HttpMethod.GET, "/pessoas").permitAll()
                                .requestMatchers(HttpMethod.POST, "/pessoas").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/pessoas/**").permitAll())
                .build();
    }

}
