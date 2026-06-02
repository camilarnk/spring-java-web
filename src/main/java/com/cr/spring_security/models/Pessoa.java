package com.cr.spring_security.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity // classifica a classe como uma entidade no banco
@Table(name = "tb_pessoas") // cria a tabela tb_pessoas no banco de dados
public class Pessoa {

    @Id // classica o atributo como um id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera um id automaticamente
    private Long id;
    private String nome;
    private String endereco;

    @OneToMany // um objeto da classe atual pode se relacionar com vários objetos do tipo declarado
    private List<Job> jobs = new ArrayList<>();

    public Pessoa() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
