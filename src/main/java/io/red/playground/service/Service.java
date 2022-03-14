package io.red.playground.service;


import io.red.playground.model.Senha;
import io.red.playground.repositories.SenhaRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final SenhaRepository repository;

    public Service(SenhaRepository repository) {
        this.repository = repository;
    }

    public Senha gerarSenha() {
        Senha novaSenha = new Senha();
        final var ultimaSenha = repository.findMax();
        repository.save(novaSenha);
        return novaSenha;
    }

    public List<Senha> recuperarTodas() {
        return repository.findAll();
    }
}
