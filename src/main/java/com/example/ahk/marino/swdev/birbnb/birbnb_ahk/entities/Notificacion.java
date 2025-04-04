package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Notificacion {
    private String mensage;
    private Usuario usuario;
    private LocalDate fechaAlta;
    private Boolean leida;
    private LocalDateTime fechaLeida;

    public Notificacion() {
        this.leida = false;
        this.fechaAlta = new LocalDate.now();
    }

    private void marcarComoLeida() {
        if (this.leida = true) {
            return;
        }
        this.leida = true;
        this.fechaLeida = LocalDateTime.now();
    }
}
