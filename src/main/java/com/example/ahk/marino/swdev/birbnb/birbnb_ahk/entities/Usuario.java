package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String nombre;
    private String email;
    private TipoUsuario tipo;
}
