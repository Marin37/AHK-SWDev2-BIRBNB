package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.enums.EstadoReserva;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Reserva {
    private LocalDate fechaAlta;
    private Usuario huesped;
    private Alojamiento alojamiento;
    private RangoFechas fechas;
    private EstadoReserva estado;
    private Double precioPorNoche;

    public void actualizarEstado(EstadoReserva nuevoEstado) {
        this.estado = nuevoEstado;
        // TODO: pendiente de ser guardada ↓
        Notificacion notificacion = new FactoryNotificacion().crearSegunReserva(this);
    }
}
