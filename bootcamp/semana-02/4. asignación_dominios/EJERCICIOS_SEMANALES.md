# Ejercicios Semanales - Semana 02: Clases y Objetos

## 📋 Información General

**Semana:** 02 - Fundamentos de Clases y Objetos  
**Puntuación Total:** 100 puntos  
**Modalidad:** Individual  
**Entrega:** Repositorio GitHub personal

---

## 🎯 Objetivo

Expandir tu sistema agregando más clases, creando relaciones entre objetos y usando colecciones básicas (ArrayList).

---

## 📦 Estructura de Entrega

```
bc-oop-java-[ficha]-[apellido]/
├── semana-01/
└── semana-02/
    ├── README.md
    ├── [ClaseNueva1].java
    ├── [ClaseNueva2].java
    ├── [ClaseGestora].java
    └── Main.java
```

---

## 📝 Ejercicio 1: Crear Nuevas Clases (30 puntos)

Agrega **2 nuevas clases** relacionadas con tu dominio.

**Requisitos:**
- Mínimo 3 atributos cada clase
- Constructor completo
- Getters y setters
- Al menos 1 método de negocio
- Relación con clases existentes

**Ejemplo (Agencia de Viajes):**
```java
public class Destino {
    private String nombre;
    private String pais;
    private double costoPromedio;
    private String temporada;
    
    public Destino(String nombre, String pais, double costo, String temporada) {
        this.nombre = nombre;
        this.pais = pais;
        this.costoPromedio = costo;
        this.temporada = temporada;
    }
    
    public String obtenerInformacion() {
        return nombre + ", " + pais + " - $" + costoPromedio;
    }
    
    // getters y setters...
}
```

---

## 📝 Ejercicio 2: Implementar Relaciones (25 puntos)

Crea relaciones entre tus objetos (composición/agregación).

**Ejemplo:**
```java
public class Reserva {
    private Cliente cliente;        // Relación con Cliente
    private Destino destino;        // Relación con Destino
    private String fechaViaje;
    private int numeroPasajeros;
    
    public Reserva(Cliente cliente, Destino destino, String fecha, int pasajeros) {
        this.cliente = cliente;
        this.destino = destino;
        this.fechaViaje = fecha;
        this.numeroPasajeros = pasajeros;
    }
    
    public double calcularTotal() {
        return destino.getCostoPromedio() * numeroPasajeros;
    }
}
```

---

## 📝 Ejercicio 3: Usar ArrayList (20 puntos)

Crea una clase gestora que use ArrayList para manejar colecciones.

**Ejemplo:**
```java
import java.util.ArrayList;

public class AgenciaViajes {
    private String nombre;
    private ArrayList<Reserva> reservas;
    
    public AgenciaViajes(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }
    
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    public void mostrarTodasReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva.obtenerResumen());
        }
    }
    
    public int contarReservas() {
        return reservas.size();
    }
}
```

---

## 📝 Ejercicio 4: Main Completo (25 puntos)

```java
public class Main {
    public static void main(String[] args) {
        // Crear objetos
        Cliente cliente1 = new Cliente("Juan Pérez", "juan@email.com");
        Destino cartagena = new Destino("Cartagena", "Colombia", 800000, "Verano");
        
        // Crear relación
        Reserva reserva1 = new Reserva(cliente1, cartagena, "2025-12-15", 2);
        
        // Usar ArrayList
        AgenciaViajes agencia = new AgenciaViajes("Viajes Colombia");
        agencia.agregarReserva(reserva1);
        
        // Mostrar resultados
        agencia.mostrarTodasReservas();
        System.out.println("Total reservas: " + agencia.contarReservas());
    }
}
```

---

## ✅ Criterios de Evaluación

| Criterio | Puntos |
|----------|--------|
| 2 nuevas clases completas | 30 |
| Relaciones entre objetos | 25 |
| Uso de ArrayList | 20 |
| Main funcional | 25 |

---

**Ver [FORMATO_ENTREGA.md](./FORMATO_ENTREGA.md) para detalles de estructura.**
