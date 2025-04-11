package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "cities")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id", nullable = false)
    private Pais pais;
}
