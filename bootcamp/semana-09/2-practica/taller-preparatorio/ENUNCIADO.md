# Taller Preparatorio: Sistema de Gestión de Vehículos

## 🎯 Objetivo

Practicar todos los conceptos de POO antes de iniciar el proyecto final mediante un ejercicio guiado paso a paso.

---

## 📋 Descripción del Problema

Desarrollar un sistema básico de gestión de vehículos para un taller mecánico que permita:

1. Registrar vehículos (Autos, Motos, Camiones)
2. Calcular costos de mantenimiento según tipo
3. Gestionar historial de servicios
4. Buscar vehículos por placa

---

## 🔧 Requisitos Técnicos

### Conceptos POO a Aplicar

- ✅ Encapsulación (atributos privados, getters/setters)
- ✅ Herencia (Vehiculo → Auto, Moto, Camion)
- ✅ Polimorfismo (calcularCostoMantenimiento())
- ✅ Abstracción (clase abstracta Vehiculo)
- ✅ Colecciones (HashMap de vehículos)
- ✅ Excepciones personalizadas

---

## 📁 Estructura del Proyecto

```
taller-vehiculos/
├── src/
│   ├── modelo/
│   │   ├── Vehiculo.java
│   │   ├── Auto.java
│   │   ├── Moto.java
│   │   └── Camion.java
│   ├── servicio/
│   │   └── VehiculoServicio.java
│   ├── excepciones/
│   │   ├── VehiculoNoEncontradoException.java
│   │   └── PlacaDuplicadaException.java
│   └── Main.java
└── docs/
    └── diagrama-clases.png
```

---

## 🛠️ Pasos de Desarrollo

### Paso 1: Crear Clase Abstracta Vehiculo

```java
package modelo;

public abstract class Vehiculo {
    private String placa;
    private String marca;
    private int año;
    
    public Vehiculo(String placa, String marca, int año) {
        this.placa = placa;
        this.marca = marca;
        this.año = año;
    }
    
    // Método abstracto (polimorfismo)
    public abstract double calcularCostoMantenimiento();
    
    // Getters/setters con validación
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("Placa no puede estar vacía");
        }
        this.placa = placa;
    }
    
    // ... otros getters/setters
}
```

### Paso 2: Crear Clases Hijas

```java
package modelo;

public class Auto extends Vehiculo {
    private int numeroPuertas;
    
    public Auto(String placa, String marca, int año, int numeroPuertas) {
        super(placa, marca, año);
        this.numeroPuertas = numeroPuertas;
    }
    
    @Override
    public double calcularCostoMantenimiento() {
        return 150000; // Costo base para autos
    }
}
```

### Paso 3: Crear Excepciones Personalizadas

```java
package excepciones;

public class VehiculoNoEncontradoException extends Exception {
    public VehiculoNoEncontradoException(String placa) {
        super("Vehículo con placa " + placa + " no encontrado");
    }
}
```

### Paso 4: Crear Servicio con Colecciones

```java
package servicio;

import modelo.*;
import excepciones.*;
import java.util.*;

public class VehiculoServicio {
    private Map<String, Vehiculo> vehiculos;
    
    public VehiculoServicio() {
        this.vehiculos = new HashMap<>();
    }
    
    public void agregar(Vehiculo vehiculo) throws PlacaDuplicadaException {
        if (vehiculos.containsKey(vehiculo.getPlaca())) {
            throw new PlacaDuplicadaException(vehiculo.getPlaca());
        }
        vehiculos.put(vehiculo.getPlaca(), vehiculo);
    }
    
    public Vehiculo buscar(String placa) throws VehiculoNoEncontradoException {
        if (!vehiculos.containsKey(placa)) {
            throw new VehiculoNoEncontradoException(placa);
        }
        return vehiculos.get(placa);
    }
    
    public void listar() {
        for (Vehiculo v : vehiculos.values()) {
            System.out.println(v.getPlaca() + " - " + v.getMarca());
        }
    }
}
```

### Paso 5: Crear Menú Principal

```java
import servicio.*;
import modelo.*;
import java.util.Scanner;

public class Main {
    private static VehiculoServicio servicio = new VehiculoServicio();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1: registrarVehiculo(); break;
                case 2: buscarVehiculo(); break;
                case 3: listarVehiculos(); break;
                case 0: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE VEHÍCULOS ===");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Buscar vehículo");
        System.out.println("3. Listar vehículos");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }
    
    // ... implementar métodos de CRUD
}
```

---

## ✅ Tareas para el Estudiante

### Parte 1: Completar Clases

1. Implementar `Moto.java` y `Camion.java`
2. Agregar más atributos relevantes
3. Implementar todos los getters/setters con validaciones

### Parte 2: Completar Servicio

1. Implementar método `actualizar()`
2. Implementar método `eliminar()`
3. Agregar validaciones adicionales

### Parte 3: Menú Interactivo

1. Completar el método `registrarVehiculo()` con Scanner
2. Implementar manejo de excepciones en el menú
3. Agregar opción para ver costo de mantenimiento

---

## 📊 Criterios de Evaluación

- [ ] Clase abstracta implementada correctamente
- [ ] 3 clases hijas funcionando
- [ ] HashMap usado para almacenar vehículos
- [ ] 2 excepciones personalizadas funcionando
- [ ] Menú CRUD completo
- [ ] Validaciones en setters
- [ ] Código limpio y comentado

---

## 🎯 Entrega

**Formato**: Carpeta comprimida `taller-vehiculos-[TuNombre].zip`

**Contenido**:
- Código fuente completo
- README.md breve
- Captura de pantalla de ejecución

**Fecha**: Entregar antes de iniciar el proyecto final

---

## 💡 Tips

- Reutiliza este código como base para tu proyecto final
- Observa cómo se estructuran los paquetes
- Nota cómo se manejan las excepciones
- Presta atención a las validaciones

