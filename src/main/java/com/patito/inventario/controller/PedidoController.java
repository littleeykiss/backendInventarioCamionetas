package com.patito.inventario.controller;

import com.patito.inventario.dto.CrearPedidoRequest;
import com.patito.inventario.dto.PedidoResponse;
import com.patito.inventario.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    /**
     * Endpoint para registrar un nuevo pedido.
     * @param request datos del pedido desde el frontend
     * @return respuesta con ID y detalle del pedido creado
     */
    @PostMapping
    public ResponseEntity<PedidoResponse> crearPedido(@RequestBody CrearPedidoRequest request) {
        PedidoResponse response = pedidoService.crearPedido(request);
        return ResponseEntity.ok(response);
    }
}
