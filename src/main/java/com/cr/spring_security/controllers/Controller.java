package com.cr.spring_security.controllers;

import com.cr.spring_security.models.Model;
import com.cr.spring_security.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping
    public ResponseEntity<Model> create(@RequestBody Model model) {
        Model request = service.create(model);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Model>> findAll() {
        List<Model> request = service.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Model>> findById(@PathVariable Long id) {
        Optional<Model> request = service.findById(id);
        if(request.isPresent()) {
            return ResponseEntity.ok().body(request);
        }
        return ResponseEntity.notFound().build();
    }

}
