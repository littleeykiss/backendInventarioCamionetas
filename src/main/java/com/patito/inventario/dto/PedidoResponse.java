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
public class PedidoResponse {

    private Long id;
    private String cliente;
    private String tienda;
    private String nombreVendedor;
    private String estatus;
    private String fechaCreacion;
    private List<ProductoPedidoDTO> productos;

    // Este DTO será devuelto al frontend al confirmar que se creó correctamente el pedido.
}