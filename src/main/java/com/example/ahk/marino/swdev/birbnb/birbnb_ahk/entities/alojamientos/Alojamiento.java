package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.alojamientos;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.Moneda;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.reservas.RangoFechas;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.reservas.Reserva;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.ubicaciones.Direccion;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "lodges")
public class Alojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "anfitrion_id", nullable = false)
    private Usuario anfitrion;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Getter
    @Setter
    @Column(name = "precioPorNoche")
    private Double precioPorNoche;

    @Getter
    @Setter
    @Column(name = "moneda")
    @Enumerated(EnumType.STRING)
    private Moneda moneda;

    @Getter
    @Setter
    @Column(name = "horarioCheckIn", columnDefinition = "TIME")
    private LocalTime horarioCheckIn;

    @Getter
    @Setter
    @Column(name = "horarioCheckOut", columnDefinition = "TIME")
    private LocalTime horarioCheckOut;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;

    @Getter
    @Setter
    @Column
    private Integer cantHuespedesMax;

    @Getter
    @OneToMany
    @JoinColumn(name = "alojamiento_id")
    private List<Foto> fotos;

    @Getter
    @ElementCollection
    @CollectionTable(name = "alojamiento_caracteristicas_enum", joinColumns = @JoinColumn(name = "alojamiendo_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "caracteristicas")
    private List<Caracteristica> caracteristicas;

    @Getter
    @OneToMany(mappedBy = "alojamiento")
    private List<Reserva> reservas;

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
