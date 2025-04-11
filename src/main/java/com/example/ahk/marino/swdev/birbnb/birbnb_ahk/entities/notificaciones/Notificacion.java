package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.notificaciones;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String mensage;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;

    @Column
    private Boolean leida;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaLeida;

    public Notificacion() {
        this.leida = false;
        this.fechaAlta = LocalDate.now();
    }

    private void marcarComoLeida() {
        if (this.leida = true) {
            return;
        }
        this.leida = true;
        this.fechaLeida = LocalDateTime.now();
    }
}
