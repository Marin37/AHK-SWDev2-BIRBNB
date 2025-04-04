package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RangoFechas {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Boolean hayColisionCon(RangoFechas otroRango) {
        // Check (periodo) < start or newEnd == oldStart
        boolean esAntes =
                (otroRango.fechaFin.isBefore(this.fechaInicio) || otroRango.fechaFin.equals(this.fechaInicio))
                        && otroRango.fechaInicio.isBefore(this.fechaInicio);

        // Check (periodo) > end or nesStart == oldEnd
        boolean esDespues =
                (otroRango.fechaInicio.isAfter(this.fechaFin) || otroRango.fechaInicio.equals(this.fechaFin))
                        && otroRango.fechaFin.isAfter(this.fechaFin);

        return esAntes == esDespues;
        // Casos:
        // Si NO HAY una colision, entonces tengo que o bien AMBAS SON ANTES OR AMBAS SON DESPUES, uno en false y otro en true -> esAntes==esDespues => False
        // Si HAY una colision, entonces tengo que NO esAntes y NO esDespues => esAntes==esDespues => True
        // El caso que sean antes y tambien despues no es alcanzable en esta logica.
    }

    public boolean esRangoValido() {
        return this.fechaInicio.isBefore(fechaFin);
    }
}
