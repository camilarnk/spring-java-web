package com.cr.spring_security.services;

import com.cr.spring_security.models.PessoaModel;
import com.cr.spring_security.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public PessoaModel create(PessoaModel model) {
        return repository.save(model);
    }

    public List<PessoaModel> findAll() {
        return repository.findAll();
    }

    public Optional<PessoaModel> findById(Long id) {
        return repository.findById(id);
    }

}
