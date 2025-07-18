package com.patito.inventario.repository;

import com.patito.inventario.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Permite acceder a los datos del cliente
}