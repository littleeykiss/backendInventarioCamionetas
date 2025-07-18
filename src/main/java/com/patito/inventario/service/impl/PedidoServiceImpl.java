package com.patito.inventario.service.impl;

import com.patito.inventario.dto.*;
import com.patito.inventario.model.*;
import com.patito.inventario.repository.*;
import com.patito.inventario.service.PedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final TiendaRepository tiendaRepository;
    private final ProductoRepository productoRepository;
    private final DetallePedidoRepository detallePedidoRepository;

    /**
     * Implementación de la lógica para crear un pedido.
     * Incluye validación de existencia y cálculo de subtotales.
     */
    @Transactional
    public PedidoResponse crearPedido(CrearPedidoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Tienda tienda = tiendaRepository.findById(request.getTiendaId())
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));

        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .tienda(tienda)
                .ipUsuario(request.getIpUsuario())
                .nombreVendedor(request.getNombreVendedor())
                .build();

        List<DetallePedido> detalles = request.getProductos().stream().map(productoDTO -> {
            Producto producto = productoRepository.findById(productoDTO.getHawa())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + productoDTO.getHawa()));

            if (producto.getExistencia() < productoDTO.getCantidad()) {
                throw new RuntimeException("No hay existencia suficiente para el producto: " + producto.getHawa());
            }

            double subtotal = (producto.getPrecioLista() - producto.getDescuento()) * productoDTO.getCantidad();

            return DetallePedido.builder()
                    .pedido(pedido)
                    .producto(producto)
                    .cantidad(productoDTO.getCantidad())
                    .subtotal(subtotal)
                    .build();
        }).collect(Collectors.toList());

        pedido.setDetalles(detalles);
        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        return PedidoResponse.builder()
                .id(pedidoGuardado.getId())
                .cliente(cliente.getNombre())
                .tienda(tienda.getNombre())
                .nombreVendedor(pedidoGuardado.getNombreVendedor())
                .estatus(pedidoGuardado.getEstatus().name())
                .fechaCreacion(pedidoGuardado.getFechaCreacion().toString())
                .productos(detalles.stream().map(dp -> ProductoPedidoDTO.builder()
                        .hawa(dp.getProducto().getHawa())
                        .nombre(dp.getProducto().getNombre())
                        .cantidad(dp.getCantidad())
                        .precioUnitario(dp.getProducto().getPrecioLista())
                        .descuento(dp.getProducto().getDescuento())
                        .subtotal(dp.getSubtotal())
                        .build()).collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
