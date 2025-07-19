
-- Insertar productos (camionetas)
INSERT INTO patito_db.producto (hawa, nombre, precio_lista, descuento, existencia) VALUES
('CAM123', 'Camioneta Ford Ranger', 450000, 15000, 5),
('CAM456', 'Chevrolet Colorado', 420000, 10000, 3),
('CAM789', 'Toyota Hilux', 470000, 20000, 7);

-- Insertar clientes
INSERT INTO patito_db.cliente (nombre, correo, telefono, direccion) VALUES
('Luis Martínez', 'luis@example.com', '5512345678', 'Av. Reforma 100, CDMX'),
('María López', 'maria@example.com', '5544332211', 'Calle 5, Guadalajara'),
('Carlos Ruiz', 'carlos@example.com', '5599887766', 'Insurgentes Sur 300, CDMX');

-- Insertar tiendas
INSERT INTO patito_db.tienda (nombre, direccion) VALUES
('Sucursal Centro', 'Av. Juárez 10, CDMX'),
('Sucursal Norte', 'Periférico 500, Monterrey'),
('Sucursal Sur', 'Av. Colón 200, Mérida');
