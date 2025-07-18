// Representa la tienda desde donde se hace el pedido. Se puede usar para filtrar o identificar pedidos por ubicación.

package com.patito.inventario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    // Esta entidad nos permite vincular el pedido con la sucursal física. Puede ser útil para reportes o filtrado por tienda.
}