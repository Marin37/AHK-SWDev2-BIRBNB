package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.enums.Caracteristica;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.enums.Moneda;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    @Getter
    @Setter
    private Usuario anfitrion;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private Double precioPorNoche;
    @Getter
    @Setter
    private Moneda moneda;
    @Getter
    @Setter
    private LocalTime horarioCheckIn;
    @Getter
    @Setter
    private LocalTime horarioCheckOut;
    @Getter
    @Setter
    private Direccion direccion;
    @Getter
    @Setter
    private Integer cantHuespedesMax;
    @Getter
    private List<Caracteristica> caracteristicas;
    @Getter
    private List<Reserva> reservas;
    @Getter
    private List<Foto> fotos;

    public Alojamiento() {
        this.caracteristicas = new ArrayList<Caracteristica>();
        this.reservas = new ArrayList<Reserva>();
        this.fotos = new ArrayList<Foto>();
    }

    public Boolean estasDisponibleEn(RangoFechas rangoDeFechasAReservar) {
        return reservas.stream().noneMatch(r -> r.getFechas().hayColisionCon(rangoDeFechasAReservar));
    }

    public Boolean tuPrecioEstaDentroDe(Double valMin, Double valMax) {
        // TODO check tipo de Moneda con this.moneda
        return this.precioPorNoche >= valMin && this.precioPorNoche <= valMax;
    }

    public Boolean tenesCaracteristica(Caracteristica caracteristicas) {
        return this.caracteristicas.contains(caracteristicas);
    }

    public Boolean puedenAlojarse(Integer cantHuespedes) {
        return cantHuespedes <= this.cantHuespedesMax;
    }
}
