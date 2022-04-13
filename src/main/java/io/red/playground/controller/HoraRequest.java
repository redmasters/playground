package io.red.playground.controller;

import java.time.LocalTime;

public record HoraRequest(
       LocalTime horaInicio,
       LocalTime horaEntrada
) {
}
