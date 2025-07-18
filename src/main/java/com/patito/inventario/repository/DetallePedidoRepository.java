package com.patito.inventario.repository;

import com.patito.inventario.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    // Permite obtener los detalles de productos dentro de un pedido
}
