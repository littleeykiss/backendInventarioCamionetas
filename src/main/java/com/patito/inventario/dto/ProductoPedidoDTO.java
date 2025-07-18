package com.patito.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoPedidoDTO {

    private String hawa;
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private double descuento;
    private double subtotal;

    // Este DTO permite mostrar el detalle de cada producto en el resumen del pedido.
}