# 🚚 Sistema de Pedidos de Camionetas - Tiendas Patito

Este proyecto fue desarrollado como solución al examen Fullstack solicitado. Implementé un backend robusto con Spring Boot, seguridad con JWT, manejo de entidades relacionadas con JPA, validaciones, y documentación con Swagger. Todos los endpoints son funcionales y cuentan con lógica de negocio que cumple las reglas establecidas, incluyendo validación de stock y estructura de pedidos.

---

## 🛠️ Tecnologías

* Java 17
* Spring Boot 3
* Spring Security + JWT
* Spring Data JPA
* SQL Server
* Swagger (OpenAPI 3)
* Maven

---

## 📦 Estructura del proyecto

* `/model`: Entidades JPA (`Producto`, `Pedido`, `Cliente`, `Tienda`, etc.)
* `/dto`: Objetos de transferencia (entrada y salida)
* `/repository`: Repositorios JPA
* `/service` y `/service/impl`: Interfaces y lógica de negocio
* `/controller`: Endpoints REST
* `/config`: Seguridad y configuración Swagger
* `/security`: Utilidades JWT

---

## 🚀 Cómo ejecutar el proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/littleeykis/inventario-camionetas.git
cd inventario-camionetas
```

### 2. Configura la base de datos

Edita `application.properties` con tu configuración de SQL Server:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:3306;databaseName=patito_db
spring.datasource.username=user
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update
```

---

### 3. Ejecuta el proyecto

```bash
mvn spring-boot:run
```

---

## 🔐 Seguridad con JWT

### Obtener token de autenticación:

```http
POST /api/auth/login?username=demo
```

Respuesta:

```json
"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

### Usar el token:

Agrega este header en tus peticiones:

```
Authorization: Bearer <token>
```

---

## 📚 Swagger

La documentación interactiva está disponible en:

```
http://localhost:8080/swagger-ui.html
```

---

## ✅ Endpoint principal

### Crear pedido

```http
POST /api/pedidos
Authorization: Bearer <token>
Content-Type: application/json
```

```json
{
  "clienteId": 1,
  "tiendaId": 1,
  "ipUsuario": "192.168.1.10",
  "nombreVendedor": "Juan Pérez",
  "productos": [
    { "hawa": "CAM123", "cantidad": 2 }
  ]
}
```

---

## ✍️ Observaciones

* El token se genera sin autenticación real (solo para pruebas).
* El sistema valida stock antes de crear el pedido.
* Swagger está disponible para probar todos los endpoints.

---

## 📬 Contacto

Erik Guadalupe Sánchez López
📧 [ersalo123@gmail.com](mailto:ersalo123@gmail.com)
