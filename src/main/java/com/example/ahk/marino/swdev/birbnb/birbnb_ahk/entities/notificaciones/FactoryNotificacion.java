package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.notificaciones;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.reservas.Reserva;

public class FactoryNotificacion {

    private String crearMensajeSegunReserva(Reserva reserva) {

        String alojamientoYFechas =
                "para el alojamiento " + reserva.getAlojamiento().getNombre()
                        + " desde el " + reserva.getFechas().getFechaInicio()
                        + " hasta el " + reserva.getFechas().getFechaFin();
        return switch (reserva.getEstado()) {
            case PENDIENTE -> "Tenes una reserva de " + reserva.getHuesped().getNombre()
                    + " " + alojamientoYFechas + ".";
            case CONFIRMADA -> "Tu reserva " + alojamientoYFechas
                    + " ha sido confirmada.";
            case CANCELADA -> "La reserva " + alojamientoYFechas + " ha sido cancelada por el huesped.";
        };
    }

    public Notificacion crearSegunReserva(Reserva reserva) {
        Notificacion notif = new Notificacion();

        switch (reserva.getEstado()) {
            case PENDIENTE, CANCELADA -> notif.setUsuario(reserva.getAlojamiento().getAnfitrion());
            case CONFIRMADA -> notif.setUsuario(reserva.getHuesped());
        }

        notif.setMensage(crearMensajeSegunReserva(reserva));

        return new Notificacion();
    }
}
