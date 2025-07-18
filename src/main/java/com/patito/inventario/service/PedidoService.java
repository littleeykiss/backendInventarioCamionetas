package com.patito.inventario.service;

import com.patito.inventario.dto.CrearPedidoRequest;
import com.patito.inventario.dto.PedidoResponse;
import com.patito.inventario.model.Pedido;

import java.util.List;

public interface PedidoService {

    /**
     * Registra un nuevo pedido a partir de la información del cliente, tienda, productos, IP, etc.
     * Realiza validación de existencia de producto y calcula totales.
     *
     * @param request datos del pedido desde el frontend
     * @return respuesta detallada con ID, productos, totales y fecha
     */
    PedidoResponse crearPedido(CrearPedidoRequest request);

    List<Pedido> findAll();

    // En esta interfaz defino el contrato del servicio. Será implementado en PedidoServiceImpl.
}