package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.alojamientos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pictures")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion;

    private String path;
}
