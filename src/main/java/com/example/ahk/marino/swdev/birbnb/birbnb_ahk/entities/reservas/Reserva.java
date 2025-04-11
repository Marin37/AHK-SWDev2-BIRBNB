package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.reservas;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.notificaciones.FactoryNotificacion;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.notificaciones.Notificacion;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.usuarios.Usuario;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.alojamientos.Alojamiento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "reservations")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;

    @ManyToOne
    @Enumerated
    @JoinColumn(name = "huesped_id",nullable = false)
    private Usuario huesped;

    @ManyToOne
    @JoinColumn(name = "alojamiento_id", nullable = false)
    private Alojamiento alojamiento;

    @Embedded
    @Column(name = "")
    private RangoFechas fechas;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @Column(name = "")

    private Double precioPorNoche;

    public void actualizarEstado(EstadoReserva nuevoEstado) {
        this.estado = nuevoEstado;
        // TODO: pendiente de ser guardada ↓
        Notificacion notificacion = new FactoryNotificacion().crearSegunReserva(this);
    }
}
