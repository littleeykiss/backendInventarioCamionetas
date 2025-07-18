// Esta entidad representa los productos disponibles en inventario (camionetas).
// Se usará el identificador HAWA como clave única.

package com.patito.inventario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    private String hawa; // Identificador HAWA único del producto

    private String nombre;

    private double precioLista;

    private double descuento;

    private int existencia; // Cantidad actual en inventario

    // Este modelo permite centralizar la información básica del producto que será usada durante el pedido.
}
