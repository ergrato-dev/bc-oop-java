# 03 - Interfaces en Java

## 🎯 Objetivos

Al finalizar este tema, serás capaz de:
- Definir interfaces usando `interface`
- Implementar múltiples interfaces en una clase
- Usar métodos default y static (Java 8+)
- Comprender las constantes en interfaces

---

## 📖 ¿Qué es una Interface?

### Definición

Una **interface** es un contrato que define:
- **QUÉ** debe hacer una clase (métodos abstractos)
- **NO CÓMO** lo hace (sin implementación)
- Es 100% abstracta (antes de Java 8)

> **Analogía:** Una interface es como un contrato laboral que especifica las responsabilidades (métodos) que debes cumplir, pero no cómo las cumplirás.

### Sintaxis Básica

```java
public interface NombreInterface {
    // Constantes (implícitamente public static final)
    int CONSTANTE = 100;
    
    // Métodos abstractos (implícitamente public abstract)
    void metodo1();
    int metodo2(String param);
}
```

---

## 🔑 Características de las Interfaces

### 1. Todos los Métodos Son Públicos y Abstractos*

```java
public interface Volador {
    // Implícitamente: public abstract
    void volar();
    void aterrizar();
    
    // ❌ ERROR: No puede tener métodos privados (antes de Java 9)
    // private void metodoPrivado() { }
}
```

*Excepto métodos `default` y `static` desde Java 8

### 2. Solo Puede Tener Constantes

```java
public interface Configuracion {
    // Implícitamente: public static final
    int MAX_USUARIOS = 100;
    String NOMBRE_APP = "MiApp";
    
    // ❌ ERROR: No puede tener atributos de instancia
    // String nombre; // No compila
}
```

### 3. No Tiene Constructores

```java
public interface Dibujable {
    // ❌ ERROR: Las interfaces no tienen constructores
    // public Dibujable() { } // No compila
    
    void dibujar();
}
```

### 4. Implementación Múltiple

```java
// ✅ Una clase puede implementar MÚLTIPLES interfaces
public class Avion implements Volador, Motorizado, Transportable {
    // Debe implementar métodos de las 3 interfaces
}
```

---

## 🛠️ Definir una Interface

### Sintaxis Completa

```java
/**
 * Interface que define capacidades de vuelo
 */
public interface Volador {
    // Constante
    int ALTURA_MAXIMA = 10000; // metros
    
    // Métodos abstractos
    void volar();
    void aterrizar();
    int obtenerAltitudActual();
    
    // Método default (Java 8+)
    default void despegar() {
        System.out.println("Preparando despegue...");
        volar();
    }
    
    // Método static (Java 8+)
    static void mostrarInfo() {
        System.out.println("Altura máxima: " + ALTURA_MAXIMA);
    }
}
```

---

## 📦 Implementar una Interface

### Palabra Clave `implements`

```java
public class Avion implements Volador {
    private int altitudActual;
    
    // DEBE implementar todos los métodos abstractos
    @Override
    public void volar() {
        altitudActual = 5000;
        System.out.println("Avión volando a " + altitudActual + "m");
    }
    
    @Override
    public void aterrizar() {
        altitudActual = 0;
        System.out.println("Avión aterrizando");
    }
    
    @Override
    public int obtenerAltitudActual() {
        return altitudActual;
    }
    
    // Puede usar el método default (o sobrescribirlo)
    // despegar() está disponible
}
```

### Uso

```java
public class Main {
    public static void main(String[] args) {
        Volador miAvion = new Avion();
        
        // Métodos implementados
        miAvion.despegar();  // Método default
        miAvion.volar();
        System.out.println("Altitud: " + miAvion.obtenerAltitudActual());
        miAvion.aterrizar();
        
        // Método estático
        Volador.mostrarInfo();
        
        // Constante
        System.out.println("Máximo: " + Volador.ALTURA_MAXIMA);
    }
}
```

---

## 🔄 Implementación Múltiple

### Ejemplo: Clase con Múltiples Interfaces

```java
// Interfaces
public interface Dibujable {
    void dibujar();
    void borrar();
}

public interface Redimensionable {
    void cambiarTamanio(double factor);
}

public interface Rotable {
    void rotar(double grados);
}

// Clase implementa 3 interfaces
public class Circulo implements Dibujable, Redimensionable, Rotable {
    private double radio;
    private int x, y;
    
    public Circulo(double radio, int x, int y) {
        this.radio = radio;
        this.x = x;
        this.y = y;
    }
    
    // De Dibujable
    @Override
    public void dibujar() {
        System.out.println("Dibujando círculo en (" + x + "," + y + ")");
    }
    
    @Override
    public void borrar() {
        System.out.println("Borrando círculo");
    }
    
    // De Redimensionable
    @Override
    public void cambiarTamanio(double factor) {
        radio *= factor;
        System.out.println("Nuevo radio: " + radio);
    }
    
    // De Rotable
    @Override
    public void rotar(double grados) {
        System.out.println("Círculo rotado " + grados + "°");
    }
}
```

### Ventajas de Implementación Múltiple

```java
public class DemoMultiple {
    public static void main(String[] args) {
        Circulo c = new Circulo(5.0, 10, 20);
        
        // Usar como Dibujable
        Dibujable d = c;
        d.dibujar();
        
        // Usar como Redimensionable
        Redimensionable r = c;
        r.cambiarTamanio(1.5);
        
        // Usar como Rotable
        Rotable rot = c;
        rot.rotar(45);
        
        // ✅ ¡Un objeto con múltiples capacidades!
    }
}
```

---

## 🆕 Métodos Default (Java 8+)

### ¿Por Qué Métodos Default?

Permiten agregar nuevos métodos a interfaces sin romper implementaciones existentes.

### Sintaxis

```java
public interface Calculable {
    // Método abstracto
    double calcular();
    
    // Método default: tiene implementación
    default void mostrarResultado() {
        System.out.println("Resultado: " + calcular());
    }
    
    default boolean esPositivo() {
        return calcular() > 0;
    }
}
```

### Implementación

```java
public class Suma implements Calculable {
    private double a, b;
    
    public Suma(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public double calcular() {
        return a + b;
    }
    
    // mostrarResultado() y esPositivo() heredados
    // Puede sobrescribirlos si necesita
}
```

### Uso

```java
Suma s = new Suma(10, 5);
s.mostrarResultado();  // "Resultado: 15.0"
System.out.println(s.esPositivo()); // true
```

---

## 🔧 Métodos Static (Java 8+)

### Utilidad

Métodos de utilidad relacionados con la interface.

```java
public interface Convertible {
    double convertir(double valor);
    
    // Método estático: no pertenece a instancias
    static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
```

### Llamada

```java
// Se llama desde la interface, no desde instancias
double f = Convertible.celsiusAFahrenheit(25);
System.out.println("25°C = " + f + "°F");

// ❌ NO se puede llamar desde instancia
// objeto.celsiusAFahrenheit(25); // Error
```

---

## 📊 Ejemplo Completo: Sistema de Pagos

```java
/**
 * Interface para métodos de pago
 */
public interface MetodoPago {
    // Constantes
    double COMISION_BASE = 0.02; // 2%
    
    // Métodos abstractos
    boolean procesarPago(double monto);
    String obtenerTipo();
    
    // Método default
    default double calcularComision(double monto) {
        return monto * COMISION_BASE;
    }
    
    default void mostrarDetalles(double monto) {
        System.out.println("=== Detalles de Pago ===");
        System.out.println("Tipo: " + obtenerTipo());
        System.out.println("Monto: $" + monto);
        System.out.println("Comisión: $" + calcularComision(monto));
        System.out.println("Total: $" + (monto + calcularComision(monto)));
    }
    
    // Método static
    static boolean validarMonto(double monto) {
        return monto > 0 && monto <= 10000000;
    }
}
```

```java
/**
 * Pago con tarjeta de crédito
 */
public class TarjetaCredito implements MetodoPago {
    private String numeroTarjeta;
    private String titular;
    
    public TarjetaCredito(String numeroTarjeta, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
    }
    
    @Override
    public boolean procesarPago(double monto) {
        if (!MetodoPago.validarMonto(monto)) {
            System.out.println("Monto inválido");
            return false;
        }
        
        System.out.println("Procesando pago con tarjeta...");
        System.out.println("Tarjeta: **** **** **** " + 
                           numeroTarjeta.substring(numeroTarjeta.length() - 4));
        System.out.println("Titular: " + titular);
        return true;
    }
    
    @Override
    public String obtenerTipo() {
        return "Tarjeta de Crédito";
    }
    
    // Sobrescribir método default si necesita comisión diferente
    @Override
    public double calcularComision(double monto) {
        return monto * 0.03; // 3% para tarjetas
    }
}
```

```java
/**
 * Pago con PSE (Colombia)
 */
public class PagoPSE implements MetodoPago {
    private String banco;
    private String cuenta;
    
    public PagoPSE(String banco, String cuenta) {
        this.banco = banco;
        this.cuenta = cuenta;
    }
    
    @Override
    public boolean procesarPago(double monto) {
        if (!MetodoPago.validarMonto(monto)) {
            System.out.println("Monto inválido");
            return false;
        }
        
        System.out.println("Redirigiendo a PSE...");
        System.out.println("Banco: " + banco);
        System.out.println("Cuenta: ****" + cuenta.substring(cuenta.length() - 4));
        return true;
    }
    
    @Override
    public String obtenerTipo() {
        return "PSE - Pago Seguro en Línea";
    }
    
    // Usa comisión por defecto (2%)
}
```

### Sistema de Procesamiento

```java
public class SistemaPagos {
    public static void main(String[] args) {
        // Crear métodos de pago
        MetodoPago[] metodos = {
            new TarjetaCredito("1234567890123456", "Juan Pérez"),
            new PagoPSE("Bancolombia", "12345678901")
        };
        
        double monto = 100000; // $100,000
        
        // Procesar con cada método
        for (MetodoPago metodo : metodos) {
            System.out.println("\n" + "=".repeat(40));
            metodo.mostrarDetalles(monto);
            
            if (metodo.procesarPago(monto)) {
                System.out.println("✓ Pago exitoso");
            } else {
                System.out.println("✗ Pago fallido");
            }
        }
        
        // Validación estática
        System.out.println("\n¿Monto válido? " + 
                           MetodoPago.validarMonto(monto));
    }
}
```

**Salida:**
```
========================================
=== Detalles de Pago ===
Tipo: Tarjeta de Crédito
Monto: $100000.0
Comisión: $3000.0
Total: $103000.0
Procesando pago con tarjeta...
Tarjeta: **** **** **** 3456
Titular: Juan Pérez
✓ Pago exitoso

========================================
=== Detalles de Pago ===
Tipo: PSE - Pago Seguro en Línea
Monto: $100000.0
Comisión: $2000.0
Total: $102000.0
Redirigiendo a PSE...
Banco: Bancolombia
Cuenta: ****8901
✓ Pago exitoso

¿Monto válido? true
```

---

## ✅ Ventajas de las Interfaces

### 1. **Desacoplamiento**
```java
// Código depende de abstracción, no de implementación
public void procesarPago(MetodoPago metodo, double monto) {
    metodo.procesarPago(monto); // Funciona con CUALQUIER implementación
}
```

### 2. **Flexibilidad**
```java
// Fácil agregar nuevos métodos de pago
public class PayPal implements MetodoPago { /* ... */ }
public class Efectivo implements MetodoPago { /* ... */ }
```

### 3. **Contrato Claro**
```java
// La interface define QUÉ se espera
// Cada clase decide CÓMO lo hace
```

### 4. **Polimorfismo**
```java
MetodoPago pago = new TarjetaCredito(...);
pago = new PagoPSE(...); // ✓ Polimorfismo
```

---

## 🚫 Errores Comunes

### 1. Olvidar Implementar Métodos

```java
interface Volador {
    void volar();
    void aterrizar();
}

// ❌ ERROR: Falta implementar aterrizar()
class Avion implements Volador {
    @Override
    public void volar() { }
    // Falta aterrizar()
}
```

### 2. Intentar Instanciar una Interface

```java
// ❌ ERROR: No se puede instanciar
Volador v = new Volador(); // No compila
```

### 3. Atributos de Instancia

```java
interface Ejemplo {
    // ❌ ERROR: Solo constantes
    String nombre; // No compila
    
    // ✅ CORRECTO
    String NOMBRE_APP = "MiApp";
}
```

---

## 🎯 Cuándo Usar Interfaces

Usa interfaces cuando:

✅ Defines una **capacidad** ("puede hacer")  
✅ No hay relación jerárquica entre clases  
✅ Necesitas **implementación múltiple**  
✅ Quieres **desacoplar** implementación de contrato  
✅ Defines un **estándar** o **API**

**Ejemplos del mundo real:**
- `Comparable<T>` - capacidad de comparación
- `Serializable` - capacidad de serialización
- `Runnable` - capacidad de ejecutarse en thread

---

## 📚 Resumen

| Característica | Valor |
|----------------|-------|
| **Palabra clave** | `interface` |
| **Métodos** | Abstractos por defecto, default (Java 8+), static (Java 8+) |
| **Atributos** | Solo constantes (public static final) |
| **Constructores** | ❌ No permitidos |
| **Implementación** | Múltiple (implements A, B, C) |
| **Herencia entre interfaces** | ✅ Permitida (extends) |

---

## 🔗 Próximo Tema

En el siguiente tema veremos **Diferencias y Comparación**:
- Tabla comparativa clases abstractas vs interfaces
- Cuándo usar cada una
- Casos de uso prácticos
- Mejores prácticas

---

**¡Ahora dominas las interfaces en Java! 🎨**
