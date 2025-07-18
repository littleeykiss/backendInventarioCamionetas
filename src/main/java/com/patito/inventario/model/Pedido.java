// Entidad principal del sistema. Representa el pedido como tal, ligándolo al cliente, tienda, vendedor y sus productos asociados.

package com.patito.inventario.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaCreacion;

    private String ipUsuario;

    @Enumerated(EnumType.STRING)
    private EstatusPedido estatus;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    private String nombreVendedor;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;

    @PrePersist
    public void asignarFecha() {
        this.fechaCreacion = LocalDateTime.now();
        this.estatus = EstatusPedido.PENDIENTE;
    }

    // Esta clase almacena toda la información del pedido completo. Se liga con cliente, tienda y sus productos.
    // Agrego un método con @PrePersist para establecer la fecha y estatus por defecto al guardar.
}
