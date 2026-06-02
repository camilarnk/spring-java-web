package com.cr.spring_security.services;

import com.cr.spring_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // classifica essa classe como uma camada de serviço
public class UserService implements UserDetailsService {

    @Autowired // injeta as dependencias da classe UserRepository
    private UserRepository userRepository;

    @Override // sobreescreve o metodo loadUserByUsername vindo de outra classe
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }
}
