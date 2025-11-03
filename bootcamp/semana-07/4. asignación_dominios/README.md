# Asignación de Dominios - Semana 07

## 🎯 Objetivo General

Aplicar **organización en paquetes** y **manejo de excepciones** al sistema que vienes desarrollando desde la **Semana 01**.

---

## 📌 Continuidad del Proyecto

### ⚠️ IMPORTANTE: Continúas con TU MISMO DOMINIO

**NO** empiezas un nuevo proyecto. **Evolucionas** el sistema que has venido construyendo:

- **Semana 01**: Introducción a POO → Definiste tu dominio
- **Semana 02**: Clases y Objetos → Creaste clases básicas
- **Semana 03**: Encapsulación → Agregaste getters/setters
- **Semana 04**: Herencia → Creaste jerarquías
- **Semana 05**: Polimorfismo → Sobrecarga y sobrescritura
- **Semana 06**: Abstracción e Interfaces → Clases abstractas e interfaces
- **🔥 Semana 07**: **Paquetes y Excepciones** → Organización y manejo de errores

---

## 📂 Nueva Estructura con Paquetes

Transforma tu código actual a esta estructura:

```
src/
└── com/
    └── [tudominio]/
        ├── modelo/           ← Clases del dominio (entidades)
        ├── servicio/         ← Lógica de negocio (gestores)
        ├── excepciones/      ← Excepciones personalizadas
        ├── util/             ← Utilidades (opcional)
        └── Main.java         ← Punto de entrada
```

### Ejemplo con Agencia de Viajes:
```
src/
└── com/
    └── agencia/
        ├── modelo/
        │   ├── Reserva.java
        │   ├── Cliente.java
        │   ├── Destino.java
        │   └── Paquete.java
        ├── servicio/
        │   ├── GestorReservas.java
        │   └── GestorPagos.java
        ├── excepciones/
        │   ├── ReservaInvalidaException.java
        │   ├── DisponibilidadException.java
        │   └── PagoRechazadoException.java
        └── Main.java
```

---

## 🎨 Adaptación por Dominio

### 1. Agencia de Viajes
**Paquetes**:
- `com.agencia.modelo`: Reserva, Cliente, Destino
- `com.agencia.servicio`: GestorReservas
- `com.agencia.excepciones`: ReservaInvalidaException, DisponibilidadException

**Excepciones sugeridas**:
- `ReservaInvalidaException`: Fecha inválida, precio negativo, código duplicado
- `DisponibilidadException`: Sin cupo, destino no disponible
- `PagoRechazadoException`: Saldo insuficiente, método de pago inválido

### 2. Restaurante
**Paquetes**:
- `com.restaurante.modelo`: Mesa, Pedido, Platillo
- `com.restaurante.servicio`: GestorMesas, GestorPedidos
- `com.restaurante.excepciones`: MesaNoDisponibleException, PlatilloAgotadoException

**Excepciones sugeridas**:
- `MesaNoDisponibleException`: Mesa ocupada, capacidad insuficiente
- `PlatilloAgotadoException`: Sin ingredientes, fuera de menú
- `PedidoInvalidoException`: Total negativo, pedido vacío

### 3. Biblioteca
**Paquetes**:
- `com.biblioteca.modelo`: Libro, Usuario, Prestamo
- `com.biblioteca.servicio`: GestorPrestamos
- `com.biblioteca.excepciones`: LibroNoDisponibleException, PrestamoVencidoException

**Excepciones sugeridas**:
- `LibroNoDisponibleException`: Libro prestado, libro dañado
- `PrestamoVencidoException`: Fecha vencida, multa pendiente
- `UsuarioSuspendidoException`: Usuario con multas, préstamos vencidos

### 4. Tienda Online
**Paquetes**:
- `com.tienda.modelo`: Producto, Carrito, Pedido
- `com.tienda.servicio`: GestorInventario, GestorPedidos
- `com.tienda.excepciones`: ProductoAgotadoException, CarritoVacioException

**Excepciones sugeridas**:
- `ProductoAgotadoException`: Sin stock, producto descontinuado
- `CarritoVacioException`: Intento de checkout sin productos
- `PagoInvalidoException`: Tarjeta rechazada, monto insuficiente

### 5. Sistema Académico
**Paquetes**:
- `com.academia.modelo`: Estudiante, Curso, Matricula
- `com.academia.servicio`: GestorMatriculas
- `com.academia.excepciones`: CupoLlenoException, MatriculaInvalidaException

**Excepciones sugeridas**:
- `CupoLlenoException`: Curso sin cupo
- `MatriculaInvalidaException`: Requisitos no cumplidos, horario conflictivo
- `NotaInvalidaException`: Nota fuera de rango

### 6. Clínica Veterinaria
**Paquetes**:
- `com.veterinaria.modelo`: Mascota, Cita, Tratamiento
- `com.veterinaria.servicio`: GestorCitas
- `com.veterinaria.excepciones`: CitaNoDisponibleException, MascotaNoRegistradaException

**Excepciones sugeridas**:
- `CitaNoDisponibleException`: Horario ocupado, veterinario no disponible
- `MascotaNoRegistradaException`: Mascota sin historial
- `TratamientoInvalidoException`: Dosis incorrecta, alergia detectada

### 7. Gimnasio
**Paquetes**:
- `com.gimnasio.modelo`: Socio, Membresia, Clase
- `com.gimnasio.servicio`: GestorMembresias, GestorClases
- `com.gimnasio.excepciones`: MembresiaVencidaException, ClaseLlenaException

**Excepciones sugeridas**:
- `MembresiaVencidaException`: Membresía expirada, pago pendiente
- `ClaseLlenaException`: Cupo completo
- `SocioSuspendidoException`: Suspensión por falta de pago

### 8. Hotel
**Paquetes**:
- `com.hotel.modelo`: Habitacion, Reserva, Huesped
- `com.hotel.servicio`: GestorReservas
- `com.hotel.excepciones`: HabitacionOcupadaException, ReservaInvalidaException

**Excepciones sugeridas**:
- `HabitacionOcupadaException`: Habitación no disponible
- `ReservaInvalidaException`: Fechas inconsistentes, check-in antes de check-out
- `PagoIncompletoException`: Depósito insuficiente

### 9. Cine
**Paquetes**:
- `com.cine.modelo`: Pelicula, Sala, Boleto
- `com.cine.servicio`: GestorFunciones
- `com.cine.excepciones`: BoletosAgotadosException, FuncionCanceladaException

**Excepciones sugeridas**:
- `BoletosAgotadosException`: Función llena
- `FuncionCanceladaException`: Función cancelada o reprogramada
- `AsientoOcupadoException`: Asiento ya reservado

### 10. Transporte Público
**Paquetes**:
- `com.transporte.modelo`: Ruta, Autobus, Pasaje
- `com.transporte.servicio`: GestorRutas
- `com.transporte.excepciones`: RutaNoDisponibleException, SaldoInsuficienteException

**Excepciones sugeridas**:
- `RutaNoDisponibleException`: Ruta suspendida
- `SaldoInsuficienteException`: Tarjeta sin saldo
- `AutobusLlenoException`: Capacidad excedida

---

## 📋 Ejercicios Semanales

Consulta el archivo `EJERCICIOS_SEMANALES.md` para ver los 4 ejercicios específicos que debes completar.

---

## 📝 Formato de Entrega

Consulta el archivo `FORMATO_ENTREGA.md` para ver los requisitos de entrega y estructura de carpetas.

---

## 💡 Consejos

1. **Revisa tu código actual**: Identifica qué clases irían en cada paquete
2. **Piensa en errores**: ¿Qué puede salir mal en tu dominio?
3. **Crea excepciones específicas**: No uses `Exception` genérica
4. **Valida entradas**: Lanza excepciones cuando detectes datos inválidos
5. **Maneja errores**: Usa try-catch en el Main para demostrar manejo

---

## ❓ Preguntas Frecuentes

**P: ¿Debo crear un nuevo proyecto?**  
R: NO. Reorganiza tu proyecto actual en paquetes.

**P: ¿Cuántas excepciones debo crear?**  
R: Mínimo 2, pero se recomienda 3 para cubrir diferentes casos.

**P: ¿Checked o Unchecked?**  
R: Para errores de negocio (reserva inválida, sin stock), usa **Checked** (extend `Exception`).

**P: ¿Puedo usar excepciones de Java?**  
R: Sí, pero también debes crear tus excepciones personalizadas.

---

**¡Éxito en la Semana 07!** 🚀
