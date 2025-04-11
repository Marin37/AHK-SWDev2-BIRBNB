package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table( name = "countries" )
public class Pais {
    @Id // this means that is a PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column( name = "name", columnDefinition = "VARCHAR(50)")
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }
}
/*
naturales = desprenden/representan algo que ya estaba en el dominio, non-ficticias, unico
subrogadas = AUTO_INCREMENT y los UUID
UUID sirve xq es mas largo y complejo, baja sustancialmente la probabilidad de que un random tire un UUID al azar
*/