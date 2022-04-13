package io.red.playground.controller;

import io.red.playground.dto.SenhaDTO;
import io.red.playground.model.Senha;
import io.red.playground.service.SenhaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/v1/play")
public class Controller {

    SenhaService senhaService;

    private final Logger log = LoggerFactory.getLogger(Controller.class);

    public Controller(SenhaService senhaService) {
        this.senhaService = senhaService;
    }

//    @PostMapping
//    public Senha gerarSenha(){
//        return senhaService.gerarSenha();
//    }

    @PostMapping("/agendar/")
    public Senha agendar(@RequestBody SenhaDTO senhaDTO) {
        return senhaService.agendar(senhaDTO);
    }

    @PostMapping("/comparar")
    public void compararHoras() {
        LocalTime horaEntrada = LocalTime.of(8, 0, 0);
        LocalTime inputHora = LocalTime.of(8, 30, 0);
        boolean ehAntes = inputHora.isBefore(horaEntrada);
        boolean ate30MinutosDepois = inputHora.isAfter(horaEntrada.plusMinutes(30L));
        String trintaMinutos = horaEntrada.plusMinutes(30L).toString();
        log.info("Hora Entrada: {}", horaEntrada);
        log.info("Hora Input: {}", inputHora);
        log.info("Entrou antes ? {}", ehAntes);
        log.info("Entrou 30min depois ? {}", ate30MinutosDepois);
        log.info("Trinta minutos? {}", trintaMinutos);

    }


    @GetMapping
    public List<Senha> recuperarSenhas() {
        return senhaService.recuperarTodas();
    }

}
