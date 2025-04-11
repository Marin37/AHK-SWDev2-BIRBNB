package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.ubicaciones;


import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "calle", nullable = false)
    private String calle;

    @Column(name = "altura", nullable = false)
    private String altura;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @Column(name = "latitud", nullable = false)
    private String latitud;

    @Column(name = "longitud", nullable = false)
    private String longitud;
}
