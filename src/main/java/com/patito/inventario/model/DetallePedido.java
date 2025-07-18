// 5️⃣ ENTIDAD: DetallePedido.java
// Relación entre un pedido y sus productos. Aquí se almacena cuántas unidades se pidieron y el subtotal.

package com.patito.inventario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_hawa")
    private Producto producto;

    private int cantidad;

    private double subtotal;

    // Este modelo permite reflejar qué productos contiene el pedido y cuántas unidades se están solicitando.
    // La relación con Producto es por el campo HAWA.
}