package com.cr.spring_security.controllers;

import com.cr.spring_security.models.Pessoa;
import com.cr.spring_security.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController // classifica a classe como controlador rest
@RequestMapping("/pessoas") // define a rota endpoint
public class PessoaController {

    @Autowired // injeta as dependencias de PessoaService
    private PessoaService service;

    @PostMapping // define o metodo como post (cria um objeto)
    // @RequestBody define que o objeto Pessoa sera passado pelo corpo da requisição
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
        Pessoa request = service.create(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping // define o metodo como get (busca todos objetos)
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> request = service.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}") // define metodo como get por id
    // @PathVariable esta indicando que o id sera passado pela url
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        Optional<Pessoa> request = service.findById(id);
        if(request.isPresent()) {
            return ResponseEntity.ok().body(request);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}") // define metodo como put (atualiza objeto existente)
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        Pessoa request = service.update(pessoa, id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}") // define metodo como delete por id
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
