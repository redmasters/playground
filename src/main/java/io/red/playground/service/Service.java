package io.red.playground.service;


import io.red.playground.model.Senha;
import io.red.playground.repositories.SenhaRepository;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final SenhaRepository repository;

    public Service(SenhaRepository repository) {
        this.repository = repository;
    }

    public Date generateSequenceByDate(Date date) {
        List<Senha> senhas = repository.findByData(date);
        if (senhas.isEmpty()) {
            Senha senha = new Senha();
            senha.setData(date);
            senha.setNumero(1);
            repository.save(senha);
            return date;
        } else {
            Senha senha = senhas.get(0);
            senha.setNumero(senha.getNumero() + 1);
            repository.save(senha);
            return senha.getData();
        }
    }

}
