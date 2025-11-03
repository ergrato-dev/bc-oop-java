# Organización de Código en Paquetes

## 📋 Índice
1. [¿Qué es un Paquete?](#qué-es-un-paquete)
2. [¿Para qué sirven los Paquetes?](#para-qué-sirven-los-paquetes)
3. [Convenciones de Nomenclatura](#convenciones-de-nomenclatura)
4. [Declaración de Paquetes](#declaración-de-paquetes)
5. [Importación de Clases](#importación-de-clases)
6. [Estructura de Directorios](#estructura-de-directorios)
7. [Ejemplos Prácticos](#ejemplos-prácticos)

---

## ¿Qué es un Paquete?

Un **paquete** (package) es un mecanismo de Java para **agrupar clases relacionadas** en un mismo espacio de nombres.

### Analogía
- **Paquete** = Carpeta/Directorio en tu sistema de archivos
- **Clases** = Archivos dentro de esa carpeta

```
proyecto/
├── com/
│   └── agencia/
│       ├── modelo/
│       │   ├── Cliente.java
│       │   ├── Reserva.java
│       │   └── Destino.java
│       ├── servicio/
│       │   └── GestorReservas.java
│       └── excepciones/
│           └── ReservaInvalidaException.java
```

---

## ¿Para qué sirven los Paquetes?

### 1. **Organización**
Agrupar clases relacionadas de forma lógica

```
com.agencia.modelo       → Clases de datos (Cliente, Reserva)
com.agencia.servicio     → Lógica de negocio (GestorReservas)
com.agencia.excepciones  → Excepciones personalizadas
com.agencia.util         → Utilidades comunes
```

### 2. **Evitar Conflictos de Nombres**
Dos clases pueden tener el mismo nombre si están en paquetes diferentes:

```java
com.agencia.modelo.Empleado        // Tu clase
java.util.Date                     // Clase de Java
org.ejemplo.util.Date              // Clase de otra librería
```

### 3. **Control de Acceso**
Modificador de acceso **default** (sin modificador) = visible solo dentro del mismo paquete

```java
class HelperInterno {  // Solo visible en su paquete
    // ...
}
```

### 4. **Distribución de Software**
Facilita empaquetar y distribuir código (archivos `.jar`)

---

## Convenciones de Nomenclatura

### Reglas Generales

| Elemento | Convención | Ejemplo |
|----------|------------|---------|
| **Paquetes** | Todo en minúsculas | `com.agencia.modelo` |
| **Sin guiones** | Usar palabras juntas | `com.agencia.gestionreservas` |
| **Dominio inverso** | Empezar con dominio | `com.miempresa.proyecto` |
| **Subcategorías** | Puntos como separadores | `com.agencia.modelo.dto` |

### Ejemplos por Tipo de Organización

```
com.empresa.proyecto.modelo        → Clases de datos (POJOs, DTOs)
com.empresa.proyecto.servicio      → Lógica de negocio
com.empresa.proyecto.repositorio   → Acceso a datos
com.empresa.proyecto.controlador   → Controladores (MVC)
com.empresa.proyecto.excepciones   → Excepciones personalizadas
com.empresa.proyecto.util          → Utilidades
com.empresa.proyecto.constantes    → Constantes del sistema
```

### ⚠️ Nombres a Evitar

```java
// ❌ MAL
package MiPaquete;          // No usar mayúsculas
package mi-paquete;         // No usar guiones
package 123paquete;         // No empezar con números
package package;            // No usar palabras reservadas
```

```java
// ✅ BIEN
package mipaquete;
package com.agencia;
package com.agencia.modelo;
```

---

## Declaración de Paquetes

### Sintaxis

```java
package nombre.del.paquete;

public class MiClase {
    // ...
}
```

### Reglas Importantes

1. **Primera línea del archivo** (excepto comentarios)
2. **Solo una declaración** de paquete por archivo
3. **Obligatorio** si quieres usar paquetes

### Ejemplo Completo

```java
package com.agencia.modelo;

/**
 * Representa un cliente de la agencia de viajes
 */
public class Cliente {
    private String nombre;
    private String email;
    
    // Constructores, getters, setters...
}
```

### Sin Declaración de Paquete

Si NO declaras paquete, la clase pertenece al **paquete por defecto** (default package):

```java
// Sin package declarado
public class MiClase {
    // Pertenece al paquete por defecto
}
```

⚠️ **No recomendado** para proyectos reales.

---

## Importación de Clases

### ¿Por qué Importar?

Para usar clases de otros paquetes necesitas **importarlas**:

```java
package com.agencia.servicio;

import com.agencia.modelo.Cliente;   // Importar clase específica
import com.agencia.modelo.Reserva;
import java.util.ArrayList;          // Importar de Java

public class GestorReservas {
    private ArrayList<Reserva> reservas;
    
    public void agregarReserva(Cliente cliente) {
        // ...
    }
}
```

### Tipos de Import

#### 1. Import Específico (Recomendado)

```java
import com.agencia.modelo.Cliente;
import com.agencia.modelo.Reserva;
```

#### 2. Import con Asterisco (Wildcard)

```java
import com.agencia.modelo.*;  // Importa TODAS las clases del paquete
import java.util.*;
```

⚠️ **Nota**: Solo importa clases del paquete directo, NO de subpaquetes.

```java
import com.agencia.*;          // NO importa com.agencia.modelo.*
import com.agencia.modelo.*;   // Necesitas importar cada subpaquete
```

#### 3. Import Estático

Para métodos y constantes estáticas:

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Calculadora {
    public double areaCirculo(double radio) {
        return PI * radio * radio;  // Usas PI directamente
    }
}
```

### Clases que NO Necesitan Import

#### 1. Clases del mismo paquete

```java
package com.agencia.modelo;

// Cliente y Reserva están en el mismo paquete
public class Cliente {
    private Reserva reservaActual;  // No necesita import
}
```

#### 2. Clases de `java.lang`

```java
// String, System, Integer, etc. están en java.lang
public class Ejemplo {
    private String nombre;        // No necesita import
    private Integer edad;         // No necesita import
    
    public static void main(String[] args) {
        System.out.println("Hola");  // No necesita import
    }
}
```

---

## Estructura de Directorios

### Correspondencia entre Paquetes y Carpetas

```
Declaración:  package com.agencia.modelo;
Ubicación:    src/com/agencia/modelo/Cliente.java
```

### Ejemplo Completo de Proyecto

```
proyecto-agencia/
├── src/
│   └── com/
│       └── agencia/
│           ├── Main.java
│           ├── modelo/
│           │   ├── Cliente.java
│           │   ├── Reserva.java
│           │   ├── Destino.java
│           │   └── Paquete.java
│           ├── servicio/
│           │   ├── GestorReservas.java
│           │   ├── GestorClientes.java
│           │   └── GestorPagos.java
│           ├── excepciones/
│           │   ├── ReservaInvalidaException.java
│           │   ├── ClienteNoEncontradoException.java
│           │   └── PagoRechazadoException.java
│           └── util/
│               ├── Validador.java
│               └── Formateador.java
└── bin/  (o build/)
    └── com/
        └── agencia/
            └── ... (archivos .class compilados)
```

---

## Ejemplos Prácticos

### Ejemplo 1: Estructura Básica

#### Archivo: `src/com/agencia/modelo/Cliente.java`

```java
package com.agencia.modelo;

public class Cliente {
    private String nombre;
    private String email;
    private String telefono;
    
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString() {
        return "Cliente{nombre='" + nombre + "', email='" + email + "'}";
    }
}
```

#### Archivo: `src/com/agencia/modelo/Reserva.java`

```java
package com.agencia.modelo;

import java.time.LocalDate;

public class Reserva {
    private String codigo;
    private Cliente cliente;  // Mismo paquete, no necesita import
    private LocalDate fecha;  // Necesita import de java.time
    private double precio;
    
    public Reserva(String codigo, Cliente cliente, LocalDate fecha, double precio) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.precio = precio;
    }
    
    // Getters y setters...
    
    @Override
    public String toString() {
        return "Reserva{codigo='" + codigo + "', cliente=" + cliente + 
               ", fecha=" + fecha + ", precio=" + precio + "}";
    }
}
```

#### Archivo: `src/com/agencia/servicio/GestorReservas.java`

```java
package com.agencia.servicio;

import com.agencia.modelo.Cliente;    // Import necesario
import com.agencia.modelo.Reserva;    // Import necesario
import java.util.ArrayList;           // Import necesario
import java.time.LocalDate;

public class GestorReservas {
    private ArrayList<Reserva> reservas;
    
    public GestorReservas() {
        this.reservas = new ArrayList<>();
    }
    
    public void agregarReserva(String codigo, Cliente cliente, double precio) {
        Reserva nueva = new Reserva(codigo, cliente, LocalDate.now(), precio);
        reservas.add(nueva);
        System.out.println("Reserva agregada: " + nueva);
    }
    
    public void listarReservas() {
        System.out.println("\n=== LISTA DE RESERVAS ===");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }
}
```

#### Archivo: `src/com/agencia/Main.java`

```java
package com.agencia;

import com.agencia.modelo.Cliente;
import com.agencia.servicio.GestorReservas;

public class Main {
    public static void main(String[] args) {
        // Crear gestor
        GestorReservas gestor = new GestorReservas();
        
        // Crear clientes
        Cliente cliente1 = new Cliente("Ana García", "ana@mail.com");
        Cliente cliente2 = new Cliente("Carlos Pérez", "carlos@mail.com");
        
        // Agregar reservas
        gestor.agregarReserva("R001", cliente1, 1500000);
        gestor.agregarReserva("R002", cliente2, 2300000);
        
        // Listar reservas
        gestor.listarReservas();
    }
}
```

### Compilación y Ejecución

#### Compilar desde la raíz del proyecto:

```bash
# Compilar todas las clases
javac -d bin src/com/agencia/*.java src/com/agencia/modelo/*.java src/com/agencia/servicio/*.java

# O más simple:
javac -d bin src/com/agencia/**/*.java
```

#### Ejecutar:

```bash
# Ejecutar Main (desde la raíz del proyecto)
java -cp bin com.agencia.Main
```

### Ejemplo 2: Con Excepciones Personalizadas

#### Archivo: `src/com/agencia/excepciones/ReservaInvalidaException.java`

```java
package com.agencia.excepciones;

public class ReservaInvalidaException extends Exception {
    
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
    
    public ReservaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
```

#### Uso en servicio:

```java
package com.agencia.servicio;

import com.agencia.modelo.*;
import com.agencia.excepciones.ReservaInvalidaException;
import java.util.ArrayList;
import java.time.LocalDate;

public class GestorReservas {
    private ArrayList<Reserva> reservas;
    
    public GestorReservas() {
        this.reservas = new ArrayList<>();
    }
    
    public void agregarReserva(String codigo, Cliente cliente, double precio) 
            throws ReservaInvalidaException {
        
        // Validaciones
        if (codigo == null || codigo.isEmpty()) {
            throw new ReservaInvalidaException("El código no puede estar vacío");
        }
        
        if (precio <= 0) {
            throw new ReservaInvalidaException("El precio debe ser mayor a 0");
        }
        
        // Verificar código duplicado
        for (Reserva r : reservas) {
            if (r.getCodigo().equals(codigo)) {
                throw new ReservaInvalidaException("Ya existe una reserva con código: " + codigo);
            }
        }
        
        // Si todo está bien, agregar
        Reserva nueva = new Reserva(codigo, cliente, LocalDate.now(), precio);
        reservas.add(nueva);
        System.out.println("✅ Reserva agregada: " + nueva);
    }
}
```

---

## 🎯 Buenas Prácticas

### ✅ DO (Hacer)

1. **Usa paquetes siempre** (excepto en ejercicios muy simples)
2. **Sigue convenciones de nomenclatura** (minúsculas, dominio inverso)
3. **Organiza lógicamente** (modelo, servicio, excepciones, util)
4. **Importa clases específicas** cuando sea posible
5. **Documenta la estructura** en un README

### ❌ DON'T (No hacer)

1. **No uses el paquete por defecto** en proyectos reales
2. **No mezcles clases no relacionadas** en el mismo paquete
3. **No uses nombres genéricos** (util, helper, manager)
4. **No abuses de import con ***

---

## 📝 Resumen

| Concepto | Descripción |
|----------|-------------|
| **Package** | Agrupa clases relacionadas |
| **Convención** | Todo en minúsculas, dominio inverso |
| **Declaración** | `package com.agencia.modelo;` (primera línea) |
| **Import** | `import com.agencia.modelo.Cliente;` |
| **Estructura** | Carpetas reflejan el nombre del paquete |

---

**Siguiente**: [02 - Manejo de Excepciones](./02-manejo-excepciones.md)
