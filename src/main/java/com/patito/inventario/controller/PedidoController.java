package com.patito.inventario.controller;

import com.patito.inventario.dto.CrearPedidoRequest;
import com.patito.inventario.dto.PedidoResponse;
import com.patito.inventario.dto.ProductoPedidoDTO;
import com.patito.inventario.model.Pedido;
import com.patito.inventario.model.Producto;
import com.patito.inventario.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listarTodos() {
        List<Pedido> pedidos = pedidoService.findAll();
        List<PedidoResponse> response = pedidos.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // Mapper inline para simplificar
    private PedidoResponse mapToResponse(Pedido pedido) {
        List<ProductoPedidoDTO> productos = pedido.getDetalles().stream().map(det -> {
            Producto producto = det.getProducto();
            return ProductoPedidoDTO.builder()
                    .hawa(producto.getHawa())
                    .nombre(producto.getNombre())
                    .cantidad(det.getCantidad())
                    .precioUnitario(producto.getPrecioLista())
                    .descuento(producto.getDescuento())
                    .subtotal(det.getSubtotal())
                    .build();
        }).toList();

        return PedidoResponse.builder()
                .id(pedido.getId())
                .cliente(pedido.getCliente().getNombre())
                .tienda(pedido.getTienda().getNombre())
                .nombreVendedor(pedido.getNombreVendedor())
                .fechaCreacion(String.valueOf(pedido.getFechaCreacion()))
                .estatus(pedido.getEstatus().name())
                .productos(productos)
                .build();
    }

}
