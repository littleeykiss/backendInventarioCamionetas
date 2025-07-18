package com.patito.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleProductoDTO {

    private String hawa;      // ID del producto
    private int cantidad;     // Unidades solicitadas

    // Este objeto se incluye en la lista de productos al registrar un pedido.
    // El backend validará si hay existencia suficiente antes de aceptar.
}