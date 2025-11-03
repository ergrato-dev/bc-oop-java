# Patrones de Diseño Básicos

## Introducción

Los patrones de diseño son soluciones probadas a problemas comunes en desarrollo de software.

---

## 🔹 Singleton Pattern

### Problema
Necesitas garantizar que una clase tenga solo una instancia y proporcionar un punto de acceso global.

### Solución
```java
public class Configuracion {
    private static Configuracion instancia;
    
    private Configuracion() { } // Constructor privado
    
    public static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }
}

// Uso
Configuracion config = Configuracion.getInstancia();
```

### Casos de Uso
- Configuración global de la aplicación
- Conexión a base de datos
- Logger

---

## 🔹 Factory Pattern

### Problema
Crear objetos sin especificar su clase exacta.

### Solución
```java
public abstract class Producto {
    public abstract void procesar();
}

public class ProductoFisico extends Producto {
    @Override
    public void procesar() { /* ... */ }
}

public class ProductoDigital extends Producto {
    @Override
    public void procesar() { /* ... */ }
}

public class ProductoFactory {
    public static Producto crear(String tipo) {
        switch (tipo) {
            case "FISICO": return new ProductoFisico();
            case "DIGITAL": return new ProductoDigital();
            default: throw new IllegalArgumentException();
        }
    }
}

// Uso
Producto p = ProductoFactory.crear("FISICO");
```

---

## 🔹 Strategy Pattern

### Problema
Cambiar el comportamiento de un algoritmo en tiempo de ejecución.

### Solución
```java
public interface EstrategiaPago {
    void pagar(double monto);
}

public class PagoTarjeta implements EstrategiaPago {
    @Override
    public void pagar(double monto) {
        System.out.println("Pago con tarjeta: $" + monto);
    }
}

public class PagoEfectivo implements EstrategiaPago {
    @Override
    public void pagar(double monto) {
        System.out.println("Pago en efectivo: $" + monto);
    }
}

public class Pedido {
    private EstrategiaPago estrategia;
    
    public void setEstrategiaPago(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }
    
    public void procesarPago(double monto) {
        estrategia.pagar(monto);
    }
}

// Uso
Pedido pedido = new Pedido();
pedido.setEstrategiaPago(new PagoTarjeta());
pedido.procesarPago(100.0);
```

---

## 💡 Aplicación Opcional en el Proyecto

Estos patrones son **opcionales** pero pueden darte puntos bonus:

- **Singleton**: Para servicios únicos
- **Factory**: Para crear diferentes tipos de entidades
- **Strategy**: Para algoritmos intercambiables

**Próximo**: [Buenas Prácticas](03-buenas-practicas.md)
