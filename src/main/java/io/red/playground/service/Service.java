package io.red.playground.service;


import io.red.playground.model.Senha;
import io.red.playground.repositories.SenhaRepository;

@org.springframework.stereotype.Service
public class Service {

    private final SenhaRepository repository;

    public Service(SenhaRepository repository) {
        this.repository = repository;
    }

    public Senha gerarSenha(){
        Senha novaSenha = new Senha();
        Long senha = 0L;
        senha++;

        novaSenha.setSenha(senha);
        repository.save(novaSenha);
        return novaSenha;
    }
}
