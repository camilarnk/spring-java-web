package com.cr.spring_security.services;

import com.cr.spring_security.models.Pessoa;
import com.cr.spring_security.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // classifica essa classe como uma camada de serviço
public class PessoaService {

    @Autowired // injeta as dependencias da classe PessoaRepository
    private PessoaRepository repository;

    public Pessoa create(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }

    public Pessoa update(Pessoa pessoa, Long id) {
       Pessoa p = repository.findById(id).get();

       p.setNome(pessoa.getNome());
       p.setEndereco(pessoa.getEndereco());

       return repository.save(p);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
