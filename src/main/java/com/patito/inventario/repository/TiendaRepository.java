package com.patito.inventario.repository;

import com.patito.inventario.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {
    // Permite acceder a los datos de la tienda
}

