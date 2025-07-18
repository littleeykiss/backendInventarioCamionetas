package com.patito.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrearPedidoRequest {

    private Long clienteId;
    private Long tiendaId;
    private String ipUsuario;
    private String nombreVendedor;
    private List<DetalleProductoDTO> productos;

    // Este DTO se envía desde el frontend para generar un nuevo pedido.
    // Incluye los IDs de cliente y tienda, IP del usuario, vendedor y los productos solicitados.
}