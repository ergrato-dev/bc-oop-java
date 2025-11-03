# Ejercicios Semanales - Semana 07

## 📊 Distribución de Puntos

| Ejercicio | Descripción | Puntos |
|-----------|-------------|--------|
| **Ejercicio 1** | Reorganizar código en paquetes | **25 pts** |
| **Ejercicio 2** | Agregar validaciones con excepciones | **30 pts** |
| **Ejercicio 3** | Crear excepciones personalizadas | **25 pts** |
| **Ejercicio 4** | Main con demostración completa | **20 pts** |
| **TOTAL** | | **100 pts** |

---

## 📝 Ejercicio 1: Reorganización en Paquetes (25 pts)

### Objetivo
Reorganizar tu código actual en una estructura de paquetes profesional.

### Tareas

#### 1.1 Crear estructura de paquetes (10 pts)
```
src/
└── com/
    └── [tudominio]/
        ├── modelo/
        ├── servicio/
        ├── excepciones/
        └── Main.java
```

#### 1.2 Mover clases a paquetes apropiados (10 pts)
- **modelo/**: Todas las clases de entidades (Reserva, Cliente, Producto, etc.)
- **servicio/**: Clases gestoras (GestorReservas, GestorInventario, etc.)
- **excepciones/**: (vacío por ahora, se llenará en ejercicio 3)

#### 1.3 Agregar declaraciones package e imports (5 pts)
- Cada archivo debe tener `package` al inicio
- Imports necesarios para usar clases de otros paquetes

### Criterios de Evaluación
- ✅ Estructura de carpetas coincide con paquetes (5 pts)
- ✅ Declaración `package` correcta en cada archivo (5 pts)
- ✅ Imports específicos (no wildcards innecesarios) (5 pts)
- ✅ Código compila sin errores (5 pts)
- ✅ Convención de nombres (com.dominio.modulo) (5 pts)

### Ejemplo: Agencia de Viajes

**Antes (Semana 06)**:
```
src/
├── Reserva.java
├── Cliente.java
├── GestorReservas.java
└── Main.java
```

**Después (Semana 07)**:
```
src/
└── com/
    └── agencia/
        ├── modelo/
        │   ├── Reserva.java
        │   └── Cliente.java
        ├── servicio/
        │   └── GestorReservas.java
        └── Main.java
```

**Reserva.java**:
```java
package com.agencia.modelo;

import java.time.LocalDate;

public class Reserva {
    private String codigo;
    private Cliente cliente;
    private LocalDate fecha;
    private double precio;
    
    // Constructor, getters, setters, toString
}
```

**GestorReservas.java**:
```java
package com.agencia.servicio;

import com.agencia.modelo.Reserva;
import com.agencia.modelo.Cliente;
import java.util.ArrayList;

public class GestorReservas {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    
    public void agregarReserva(Reserva r) {
        reservas.add(r);
    }
}
```

---

## 📝 Ejercicio 2: Validaciones con Excepciones (30 pts)

### Objetivo
Agregar validaciones robustas usando excepciones de Java.

### Tareas

#### 2.1 Identificar operaciones críticas (5 pts)
Determina qué operaciones pueden fallar:
- Agregar entidad con datos inválidos
- Buscar entidad que no existe
- Operaciones con valores negativos o null

#### 2.2 Implementar validaciones (15 pts)
Agrega validaciones que lancen excepciones:

```java
// Ejemplo: Validar precio
public void setPrice(double precio) {
    if (precio <= 0) {
        throw new IllegalArgumentException("Precio debe ser mayor a 0");
    }
    this.precio = precio;
}

// Ejemplo: Validar null
public void setCliente(Cliente cliente) {
    if (cliente == null) {
        throw new IllegalArgumentException("Cliente no puede ser null");
    }
    this.cliente = cliente;
}
```

#### 2.3 Agregar try-catch en servicio (10 pts)
Maneja excepciones en tu clase gestora:

```java
public void procesarReserva(String codigo, double precio) {
    try {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        // Procesar reserva
        System.out.println("✅ Reserva procesada");
    } catch (IllegalArgumentException e) {
        System.err.println("❌ Error: " + e.getMessage());
    }
}
```

### Criterios de Evaluación
- ✅ Mínimo 3 validaciones con excepciones (10 pts)
- ✅ Uso de excepciones apropiadas (IllegalArgumentException, NullPointerException) (10 pts)
- ✅ Try-catch en método crítico (5 pts)
- ✅ Mensajes descriptivos en excepciones (5 pts)

---

## 📝 Ejercicio 3: Excepciones Personalizadas (25 pts)

### Objetivo
Crear excepciones específicas para tu dominio.

### Tareas

#### 3.1 Crear 2 excepciones personalizadas (10 pts)

**Ejemplo 1: Agencia de Viajes**
```java
package com.agencia.excepciones;

/**
 * Excepción lanzada cuando una reserva no cumple requisitos
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

```java
package com.agencia.excepciones;

/**
 * Excepción lanzada cuando no hay disponibilidad
 */
public class DisponibilidadException extends Exception {
    
    public DisponibilidadException(String mensaje) {
        super(mensaje);
    }
    
    public DisponibilidadException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
```

#### 3.2 Usar excepciones en servicio (10 pts)

```java
package com.agencia.servicio;

import com.agencia.modelo.*;
import com.agencia.excepciones.*;
import java.time.LocalDate;

public class GestorReservas {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private int cupoMaximo = 10;
    
    public void agregarReserva(String codigo, Cliente cliente, LocalDate fecha, double precio)
            throws ReservaInvalidaException, DisponibilidadException {
        
        // Validar código
        if (!codigo.matches("R\\d{3}")) {
            throw new ReservaInvalidaException(
                "Código debe tener formato R### (ejemplo: R001)"
            );
        }
        
        // Validar precio
        if (precio <= 0) {
            throw new ReservaInvalidaException("Precio debe ser mayor a 0");
        }
        
        // Verificar disponibilidad
        long count = reservas.stream()
            .filter(r -> r.getFecha().equals(fecha))
            .count();
            
        if (count >= cupoMaximo) {
            throw new DisponibilidadException(
                "No hay cupo disponible para la fecha: " + fecha
            );
        }
        
        // Agregar reserva
        Reserva nueva = new Reserva(codigo, cliente, fecha, precio);
        reservas.add(nueva);
        System.out.println("✅ Reserva agregada: " + nueva);
    }
}
```

#### 3.3 Documentar con Javadoc (5 pts)
Agrega comentarios Javadoc a tus excepciones y métodos que las lanzan.

### Criterios de Evaluación
- ✅ Mínimo 2 excepciones personalizadas (checked) (10 pts)
- ✅ Nombres descriptivos terminan en "Exception" (3 pts)
- ✅ Constructores apropiados (mensaje, mensaje+causa) (5 pts)
- ✅ Uso correcto con `throw` y `throws` (5 pts)
- ✅ Documentación Javadoc (2 pts)

### Sugerencias por Dominio

| Dominio | Excepción 1 | Excepción 2 | Excepción 3 (opcional) |
|---------|-------------|-------------|------------------------|
| **Agencia Viajes** | ReservaInvalidaException | DisponibilidadException | PagoRechazadoException |
| **Restaurante** | MesaNoDisponibleException | PlatilloAgotadoException | PedidoInvalidoException |
| **Biblioteca** | LibroNoDisponibleException | PrestamoVencidoException | UsuarioSuspendidoException |
| **Tienda** | ProductoAgotadoException | CarritoVacioException | PagoInvalidoException |
| **Academia** | CupoLlenoException | MatriculaInvalidaException | NotaInvalidaException |
| **Veterinaria** | CitaNoDisponibleException | MascotaNoRegistradaException | TratamientoInvalidoException |
| **Gimnasio** | MembresiaVencidaException | ClaseLlenaException | SocioSuspendidoException |
| **Hotel** | HabitacionOcupadaException | ReservaInvalidaException | PagoIncompletoException |
| **Cine** | BoletosAgotadosException | FuncionCanceladaException | AsientoOcupadoException |
| **Transporte** | RutaNoDisponibleException | SaldoInsuficienteException | AutobusLlenoException |

---

## 📝 Ejercicio 4: Main de Demostración (20 pts)

### Objetivo
Crear un Main que demuestre el manejo completo de excepciones.

### Tareas

#### 4.1 Casos de prueba (15 pts)
Demuestra al menos 5 casos:
1. ✅ Operación exitosa
2. ❌ Excepción por validación (IllegalArgumentException)
3. ❌ Excepción personalizada 1
4. ❌ Excepción personalizada 2
5. ✅ Recuperación después de error

#### 4.2 Estructura del Main

```java
package com.agencia;

import com.agencia.modelo.*;
import com.agencia.servicio.GestorReservas;
import com.agencia.excepciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión - Semana 07 ===\n");
        
        GestorReservas gestor = new GestorReservas();
        Cliente cliente = new Cliente("Ana García", "ana@mail.com");
        
        // Caso 1: Reserva válida ✅
        System.out.println("--- Caso 1: Reserva Válida ---");
        try {
            gestor.agregarReserva("R001", cliente, LocalDate.now(), 1500000);
        } catch (ReservaInvalidaException | DisponibilidadException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
        
        // Caso 2: Código inválido ❌
        System.out.println("\n--- Caso 2: Código Inválido ---");
        try {
            gestor.agregarReserva("ABC", cliente, LocalDate.now(), 2000000);
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Código incorrecto: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.err.println("❌ Sin disponibilidad: " + e.getMessage());
        }
        
        // Caso 3: Precio inválido ❌
        System.out.println("\n--- Caso 3: Precio Negativo ---");
        try {
            gestor.agregarReserva("R002", cliente, LocalDate.now(), -1000);
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Precio inválido: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.err.println("❌ Sin disponibilidad: " + e.getMessage());
        }
        
        // Caso 4 y 5: Demostrar más casos...
        
        System.out.println("\n✅ Semana 07 completada: Paquetes y Excepciones");
    }
}
```

#### 4.3 Finally para limpieza (5 pts)
Agrega al menos 1 ejemplo con finally:

```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("config.txt"));
    // Leer archivo
} catch (IOException e) {
    System.err.println("Error leyendo archivo");
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error cerrando archivo");
        }
    }
}
```

### Criterios de Evaluación
- ✅ Mínimo 5 casos de prueba (10 pts)
- ✅ Try-catch para cada caso (5 pts)
- ✅ Mensajes claros de éxito/error (3 pts)
- ✅ Al menos 1 uso de finally (2 pts)

---

## 📦 Entregables Finales

1. **Código fuente completo** organizado en paquetes
2. **Mínimo 2 excepciones personalizadas** en paquete `excepciones/`
3. **Main.java** con casos de prueba
4. **README.md** explicando tu dominio y excepciones

---

## ✅ Checklist Pre-Entrega

Antes de entregar, verifica:

- [ ] Estructura de paquetes correcta
- [ ] Todos los archivos tienen `package` declaration
- [ ] Imports organizados (específicos, no wildcards)
- [ ] Mínimo 2 excepciones personalizadas (checked)
- [ ] Excepciones tienen 2 constructores (mensaje, mensaje+causa)
- [ ] Métodos críticos declaran excepciones con `throws`
- [ ] Main tiene try-catch para manejar excepciones
- [ ] Al menos 5 casos de prueba en Main
- [ ] Código compila sin errores
- [ ] Código ejecuta y muestra salida correcta

---

## 💡 Tips Finales

1. **Piensa en tu dominio**: ¿Qué errores son específicos de tu negocio?
2. **Nombra bien**: `ReservaInvalidaException` es mejor que `ErrorException`
3. **Checked vs Unchecked**: Usa checked (extend `Exception`) para errores de negocio
4. **Mensajes descriptivos**: Incluye contexto en el mensaje de error
5. **No captures genérico**: Usa catch específico para cada tipo de excepción

---

**¡Éxito con tus ejercicios!** 🚀
