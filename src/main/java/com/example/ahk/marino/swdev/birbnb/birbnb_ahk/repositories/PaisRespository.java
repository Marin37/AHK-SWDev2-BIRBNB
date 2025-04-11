package com.example.ahk.marino.swdev.birbnb.birbnb_ahk.repositories;

import com.example.ahk.marino.swdev.birbnb.birbnb_ahk.entities.ubicaciones.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRespository extends JpaRepository<Pais,Long> {
}