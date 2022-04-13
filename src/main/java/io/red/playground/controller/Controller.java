package io.red.playground.controller;

import io.red.playground.dto.SenhaDTO;
import io.red.playground.model.Senha;
import io.red.playground.service.SenhaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> compararHoras(@RequestBody HoraRequest request) {
//        LocalTime horaEntrada = LocalTime.of(8, 0, 0);
//        LocalTime inputHora = LocalTime.of(8, 29, 0);
//        boolean ehAntes = inputHora.isBefore(horaEntrada);
//        boolean ate30MinutosDepois = inputHora.isAfter(horaEntrada.plusMinutes(30L));
//        String trintaMinutos = horaEntrada.plusMinutes(30L).toString();

        LocalTime horaInicio = request.horaInicio();
        LocalTime horaEntrada = request.horaEntrada();
        boolean ehAntes = horaEntrada.isBefore(horaEntrada);
        boolean ate30MinutosDepois = horaEntrada.isAfter(horaEntrada.plusMinutes(30L));
        String trintaMinutos = horaInicio.plusMinutes(30L).toString();

        if (horaEntrada.isAfter(horaInicio) || horaEntrada.equals(horaInicio)) {
            log.info("deubom");
            return ResponseEntity.status(HttpStatus.CREATED).body(horaEntrada);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito");
        }

    }


    @GetMapping
    public List<Senha> recuperarSenhas() {
        return senhaService.recuperarTodas();
    }

}
