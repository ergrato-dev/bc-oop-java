# Buenas Prácticas en Java

## 📝 Convenciones de Nombres

### Clases
```java
public class ClienteServicio { }  // PascalCase
```

### Métodos y Variables
```java
private String nombreCompleto;  // camelCase
public void calcularTotal() { }
```

### Constantes
```java
public static final int MAX_INTENTOS = 3;  // UPPER_SNAKE_CASE
```

---

## 🎯 Principios SOLID (Introducción)

### Single Responsibility Principle (SRP)
Una clase debe tener una única responsabilidad.

```java
// ❌ MAL
public class Cliente {
    private String nombre;
    
    public void guardarEnBaseDatos() { }  // No es responsabilidad del Cliente
    public void enviarEmail() { }         // No es responsabilidad del Cliente
}

// ✅ BIEN
public class Cliente {
    private String nombre;
    // Solo datos y comportamiento del cliente
}

public class ClienteRepositorio {
    public void guardar(Cliente cliente) { }
}

public class EmailServicio {
    public void enviar(String destinatario) { }
}
```

### Open/Closed Principle (OCP)
Abierto para extensión, cerrado para modificación.

```java
// ✅ BIEN: Usa herencia para extender comportamiento
public abstract class Descuento {
    public abstract double calcular(double precio);
}

public class DescuentoPorcentaje extends Descuento {
    private double porcentaje;
    
    @Override
    public double calcular(double precio) {
        return precio * (1 - porcentaje/100);
    }
}
```

---

## 🧹 Código Limpio

### Métodos Pequeños
```java
// ❌ MAL: Método muy largo
public void procesarPedido() {
    // 100 líneas de código...
}

// ✅ BIEN: Dividir en métodos pequeños
public void procesarPedido() {
    validarPedido();
    calcularTotal();
    aplicarDescuentos();
    generarFactura();
}
```

### Nombres Descriptivos
```java
// ❌ MAL
int d; // días?
String fn; // ??

// ✅ BIEN
int diasTranscurridos;
String nombreCompleto;
```

### Comentarios Significativos
```java
// ❌ MAL: Comentario obvio
i++; // incrementa i

// ✅ BIEN: Explica el "por qué"
// Usamos HashMap para búsquedas O(1) por ID
Map<String, Cliente> clientes = new HashMap<>();
```

---

## ⚠️ Code Smells (Malos Olores)

### Duplicación de Código
```java
// ❌ MAL
public void crearCliente() {
    if (nombre == null || nombre.isEmpty()) {
        throw new DatoInvalidoException();
    }
}

public void actualizarCliente() {
    if (nombre == null || nombre.isEmpty()) {
        throw new DatoInvalidoException();
    }
}

// ✅ BIEN
private void validarNombre(String nombre) {
    if (nombre == null || nombre.isEmpty()) {
        throw new DatoInvalidoException();
    }
}
```

---

## 📐 Organización del Proyecto

```
src/
├── modelo/          ← Entidades del dominio
├── servicio/        ← Lógica de negocio
├── excepciones/     ← Excepciones personalizadas
├── util/            ← Utilidades
└── Main.java        ← Punto de entrada
```

**Próximo**: [Documentación y UML](04-documentacion-uml.md)
