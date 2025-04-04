package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.enums.EstadoReserva;

import java.time.LocalDate;

public class CambioEstadoReserva {
    private LocalDate fecha;
    private EstadoReserva estado;
    private Reserva reserva;
    private String motivo;
    private Usuario usuario;
}
