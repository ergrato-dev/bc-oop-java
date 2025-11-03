# Excepciones Personalizadas en Java

## 📋 Índice
1. [¿Por qué Crear Excepciones Personalizadas?](#por-qué-crear-excepciones-personalizadas)
2. [Cómo Crear Excepciones Personalizadas](#cómo-crear-excepciones-personalizadas)
3. [Convenciones de Nomenclatura](#convenciones-de-nomenclatura)
4. [Ejemplos por Dominio](#ejemplos-por-dominio)
5. [Buenas Prácticas](#buenas-prácticas)

---

## ¿Por qué Crear Excepciones Personalizadas?

### Razones

✅ **Comunicar errores específicos del dominio**
```java
throw new ReservaInvalidaException("Fecha no disponible");
// vs
throw new Exception("Error");  // Muy genérico
```

✅ **Facilitar el manejo de errores**
```java
try {
    gestor.agregarReserva(reserva);
} catch (ReservaInvalidaException e) {
    // Manejo específico para reservas
} catch (PagoRechazadoException e) {
    // Manejo específico para pagos
}
```

✅ **Mejorar la documentación del código**
```java
/**
 * @throws ReservaInvalidaException si la reserva no cumple requisitos
 * @throws DisponibilidadException si no hay cupo
 */
public void agregarReserva(Reserva r) throws ReservaInvalidaException, DisponibilidadException
```

---

## Cómo Crear Excepciones Personalizadas

### Estructura Básica

```java
public class MiExcepcionException extends Exception {
    
    // Constructor sin parámetros
    public MiExcepcionException() {
        super();
    }
    
    // Constructor con mensaje
    public MiExcepcionException(String mensaje) {
        super(mensaje);
    }
    
    // Constructor con mensaje y causa
    public MiExcepcionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
    
    // Constructor con causa
    public MiExcepcionException(Throwable causa) {
        super(causa);
    }
}
```

### Ejemplo 1: Checked Exception

```java
package com.agencia.excepciones;

/**
 * Excepción lanzada cuando una reserva es inválida
 */
public class ReservaInvalidaException extends Exception {
    
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
    
    public ReservaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
```

**Uso:**
```java
public void agregarReserva(Reserva r) throws ReservaInvalidaException {
    if (r.getPrecio() <= 0) {
        throw new ReservaInvalidaException("El precio debe ser mayor a 0");
    }
    // ... resto del código
}
```

### Ejemplo 2: Unchecked Exception

```java
package com.agencia.excepciones;

/**
 * Excepción lanzada cuando un argumento es inválido
 */
public class ArgumentoInvalidoException extends RuntimeException {
    
    public ArgumentoInvalidoException(String mensaje) {
        super(mensaje);
    }
    
    public ArgumentoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
```

**Uso:**
```java
public void setEdad(int edad) {
    if (edad < 0 || edad > 150) {
        throw new ArgumentoInvalidoException("Edad debe estar entre 0 y 150");
    }
    this.edad = edad;
}
```

---

## Convenciones de Nomenclatura

### Reglas

| Regla | Ejemplo | ❌ Incorrecto |
|-------|---------|---------------|
| Terminar en "Exception" | `ReservaInvalidaException` | `ReservaInvalida` |
| PascalCase | `ClienteNoEncontradoException` | `clientenoencont radoexception` |
| Descriptivo | `PagoRechazadoException` | `ErrorException` |
| Específico al dominio | `DisponibilidadException` | `MyException` |

### Ejemplos Correctos

```java
// ✅ Checked
public class ReservaInvalidaException extends Exception { }
public class ClienteNoEncontradoException extends Exception { }
public class PagoRechazadoException extends Exception { }

// ✅ Unchecked
public class FormatoCodigoInvalidoException extends RuntimeException { }
public class LimiteExcedidoException extends RuntimeException { }
```

---

## Ejemplos por Dominio

### 1. Agencia de Viajes

```java
package com.agencia.excepciones;

// Excepción para reservas inválidas
public class ReservaInvalidaException extends Exception {
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
}

// Excepción para disponibilidad
public class DisponibilidadException extends Exception {
    public DisponibilidadException(String mensaje) {
        super(mensaje);
    }
}

// Excepción para pagos
public class PagoRechazadoException extends Exception {
    private String codigoRechazo;
    
    public PagoRechazadoException(String mensaje, String codigoRechazo) {
        super(mensaje);
        this.codigoRechazo = codigoRechazo;
    }
    
    public String getCodigoRechazo() {
        return codigoRechazo;
    }
}
```

**Uso completo:**
```java
package com.agencia.servicio;

import com.agencia.modelo.*;
import com.agencia.excepciones.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorReservas {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private int cupoMaximo = 10;
    
    public void agregarReserva(String codigo, Cliente cliente, LocalDate fecha, double precio)
            throws ReservaInvalidaException, DisponibilidadException {
        
        // Validación de formato
        if (!codigo.matches("R\\d{3}")) {
            throw new ReservaInvalidaException(
                "Código debe tener formato R### (ejemplo: R001)"
            );
        }
        
        // Validación de precio
        if (precio <= 0) {
            throw new ReservaInvalidaException("Precio debe ser mayor a 0");
        }
        
        // Validación de disponibilidad
        long reservasDia = reservas.stream()
            .filter(r -> r.getFecha().equals(fecha))
            .count();
            
        if (reservasDia >= cupoMaximo) {
            throw new DisponibilidadException(
                "No hay cupo disponible para la fecha: " + fecha
            );
        }
        
        // Verificar duplicados
        for (Reserva r : reservas) {
            if (r.getCodigo().equals(codigo)) {
                throw new ReservaInvalidaException(
                    "Ya existe una reserva con código: " + codigo
                );
            }
        }
        
        // Si todo está bien, agregar
        Reserva nueva = new Reserva(codigo, cliente, fecha, precio);
        reservas.add(nueva);
        System.out.println("✅ Reserva agregada: " + nueva);
    }
    
    public void procesarPago(String codigoReserva, double monto)
            throws PagoRechazadoException {
        
        if (monto <= 0) {
            throw new PagoRechazadoException("Monto inválido", "MONTO_INVALIDO");
        }
        
        // Simular verificación de pago
        if (monto > 5000000) {
            throw new PagoRechazadoException(
                "Monto excede límite permitido", 
                "LIMITE_EXCEDIDO"
            );
        }
        
        System.out.println("✅ Pago procesado: $" + monto);
    }
}
```

### 2. Restaurante

```java
package com.restaurante.excepciones;

public class PlatilloNoDisponibleException extends Exception {
    public PlatilloNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}

public class MesaNoDisponibleException extends Exception {
    private int mesaSugerida;
    
    public MesaNoDisponibleException(String mensaje, int mesaSugerida) {
        super(mensaje);
        this.mesaSugerida = mesaSugerida;
    }
    
    public int getMesaSugerida() {
        return mesaSugerida;
    }
}

public class IngredienteNoDisponibleException extends RuntimeException {
    public IngredienteNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
```

### 3. Biblioteca

```java
package com.biblioteca.excepciones;

public class LibroNoDisponibleException extends Exception {
    private LocalDate fechaDevolucion;
    
    public LibroNoDisponibleException(String mensaje, LocalDate fechaDevolucion) {
        super(mensaje);
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}

public class PrestamoVencidoException extends Exception {
    private double multa;
    
    public PrestamoVencidoException(String mensaje, double multa) {
        super(mensaje);
        this.multa = multa;
    }
    
    public double getMulta() {
        return multa;
    }
}
```

### 4. Tienda Online

```java
package com.tienda.excepciones;

public class ProductoAgotadoException extends Exception {
    private int stockDisponible;
    
    public ProductoAgotadoException(String mensaje, int stockDisponible) {
        super(mensaje);
        this.stockDisponible = stockDisponible;
    }
    
    public int getStockDisponible() {
        return stockDisponible;
    }
}

public class CarritoVacioException extends RuntimeException {
    public CarritoVacioException(String mensaje) {
        super(mensaje);
    }
}
```

---

## Buenas Prácticas

### ✅ DO (Hacer)

1. **Usa nombres descriptivos**
```java
// ✅ BIEN
throw new ReservaInvalidaException("Fecha no disponible");

// ❌ MAL
throw new MyException("Error");
```

2. **Agrega contexto con atributos**
```java
public class PagoRechazadoException extends Exception {
    private String codigoRechazo;
    private double montoIntentado;
    
    // Constructor y getters
}
```

3. **Extiende de la clase apropiada**
```java
// ✅ Checked: Para situaciones recuperables
public class ReservaInvalidaException extends Exception { }

// ✅ Unchecked: Para errores de programación
public class ArgumentoInvalidoException extends RuntimeException { }
```

4. **Incluye 4 constructores estándar**
```java
public class MiException extends Exception {
    public MiException() { super(); }
    public MiException(String mensaje) { super(mensaje); }
    public MiException(String mensaje, Throwable causa) { super(mensaje, causa); }
    public MiException(Throwable causa) { super(causa); }
}
```

5. **Documenta con Javadoc**
```java
/**
 * Excepción lanzada cuando una reserva no cumple los requisitos mínimos.
 * 
 * @author Tu Nombre
 * @since 1.0
 */
public class ReservaInvalidaException extends Exception {
    // ...
}
```

### ❌ DON'T (No hacer)

1. **No crees excepciones genéricas**
```java
// ❌ MAL
public class ErrorException extends Exception { }
public class ProblemaException extends Exception { }
```

2. **No abuses de excepciones unchecked**
```java
// ❌ MAL: Situación recuperable debería ser checked
public class ArchivoNoEncontradoException extends RuntimeException { }
```

3. **No captures tu propia excepción sin razón**
```java
// ❌ MAL
try {
    throw new MiException();
} catch (MiException e) {
    // No hacer nada
}
```

---

## Ejemplo Completo: Main de Prueba

```java
package com.agencia;

import com.agencia.modelo.*;
import com.agencia.servicio.GestorReservas;
import com.agencia.excepciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GestorReservas gestor = new GestorReservas();
        Cliente cliente = new Cliente("Ana García", "ana@mail.com");
        
        // Caso 1: Reserva válida
        try {
            gestor.agregarReserva("R001", cliente, LocalDate.now(), 1500000);
        } catch (ReservaInvalidaException e) {
            System.out.println("❌ Reserva inválida: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.out.println("❌ Sin disponibilidad: " + e.getMessage());
        }
        
        // Caso 2: Código inválido
        try {
            gestor.agregarReserva("ABC", cliente, LocalDate.now(), 2000000);
        } catch (ReservaInvalidaException e) {
            System.out.println("❌ Código incorrecto: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.out.println("❌ Sin disponibilidad: " + e.getMessage());
        }
        
        // Caso 3: Pago
        try {
            gestor.procesarPago("R001", 1500000);
        } catch (PagoRechazadoException e) {
            System.out.println("❌ Pago rechazado: " + e.getMessage());
            System.out.println("   Código: " + e.getCodigoRechazo());
        }
    }
}
```

---

## 📝 Resumen

| Aspecto | Recomendación |
|---------|---------------|
| **Nombre** | Terminar en "Exception", descriptivo |
| **Herencia** | `Exception` (checked) o `RuntimeException` (unchecked) |
| **Constructores** | Mínimo 2 (mensaje, mensaje+causa) |
| **Atributos** | Agregar contexto relevante |
| **Paquete** | `com.dominio.excepciones` |

---

**Siguiente**: [05 - Buenas Prácticas](./05-buenas-practicas.md)
