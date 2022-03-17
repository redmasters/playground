package io.red.playground.service;


import io.red.playground.dto.SenhaDTO;
import io.red.playground.model.Senha;
import io.red.playground.repositories.SenhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenhaService {

    private final SenhaRepository repository;

    public SenhaService(SenhaRepository repository) {
        this.repository = repository;
    }

    public void gerarSenha() {
        final var ultimaSenha = repository.findFirstByOrderBySenhaDesc();

        Long number = 0L;
        Senha novaSenha = new Senha();

        if(ultimaSenha.isEmpty()){
            number++;
            novaSenha.setSenha(number);
            repository.save(novaSenha);
        } else {
            number++;
            final var s = ultimaSenha.get().getSenha() + number;
            novaSenha.setSenha(s);
            repository.save(novaSenha);
        }
    }

    public List<Senha> recuperarTodas() {
        return repository.findAll();
    }

    public Senha agendar(SenhaDTO senhaDTO) {
        var novaSenha = new SenhaDTO();

        return null;
    }
}


















