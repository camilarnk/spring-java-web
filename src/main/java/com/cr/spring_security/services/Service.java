package com.cr.spring_security.services;

import com.cr.spring_security.models.Model;
import com.cr.spring_security.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public Model create(Model model) {
        return repository.save(model);
    }

    public List<Model> findAll() {
        return repository.findAll();
    }

    public Optional<Model> findById(Long id) {
        return repository.findById(id);
    }

}
