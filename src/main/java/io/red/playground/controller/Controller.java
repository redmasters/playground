package io.red.playground.controller;

import io.red.playground.dto.SenhaDTO;
import io.red.playground.model.Senha;
import io.red.playground.service.SenhaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/play")
public class Controller {

    SenhaService senhaService;

    public Controller(SenhaService senhaService) {
        this.senhaService = senhaService;
    }

//    @PostMapping
//    public Senha gerarSenha(){
//        return senhaService.gerarSenha();
//    }

    @PostMapping("/agendar/")
    public Senha agendar(@RequestBody SenhaDTO senhaDTO){
        return senhaService.agendar(senhaDTO);
    }


    @GetMapping
    public List<Senha> recuperarSenhas(){
        return senhaService.recuperarTodas();
    }

}
