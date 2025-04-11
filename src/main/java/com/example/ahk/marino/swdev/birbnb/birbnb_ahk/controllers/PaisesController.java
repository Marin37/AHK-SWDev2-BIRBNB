package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.controllers;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.ubicaciones.Pais;
import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.repositories.PaisRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    @Autowired
    private PaisRespository paisRespository;

    @GetMapping
    public ResponseEntity<List<Pais>> generarPaises() {
        Pais argentina = new Pais("Argentina");
        Pais brasil = new Pais("Brasil");
        Pais uruguay = new Pais("Uruguay");

        // List<Pais> paises = [argentina,brasil,uruguay];
        this.paisRespository.save(argentina);
        this.paisRespository.save(brasil);
        this.paisRespository.save(uruguay);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(List.of(argentina, brasil, uruguay));
    }
}
