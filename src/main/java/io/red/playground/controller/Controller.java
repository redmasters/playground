package io.red.playground.controller;

import io.red.playground.model.Senha;
import io.red.playground.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/play")
public class Controller {

    Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public Senha gerarSenha(){
        return service.gerarSenha();
    }

}
