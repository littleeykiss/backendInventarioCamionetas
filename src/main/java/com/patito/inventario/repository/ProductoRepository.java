package com.patito.inventario.repository;

import com.patito.inventario.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
    // Permite buscar productos por clave primaria
}