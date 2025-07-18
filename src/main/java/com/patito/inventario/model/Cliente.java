// 2️⃣ ENTIDAD: Cliente.java
// Representa al cliente que realiza el pedido. Se almacena su información básica para fines de facturación y seguimiento.

package com.patito.inventario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String telefono;

    private String direccion;

    // Esta información se utilizará en la pantalla de confirmación de pedido y para persistencia en base de datos.
}