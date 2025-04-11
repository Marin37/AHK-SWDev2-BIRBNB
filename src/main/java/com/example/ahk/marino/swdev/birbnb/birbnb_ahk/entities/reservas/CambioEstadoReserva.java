package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.reservas;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservationsStatusChange")
public class CambioEstadoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate fecha;

    @Column
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @Column
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;
}
