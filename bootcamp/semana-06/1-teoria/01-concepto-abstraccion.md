# 01 - Concepto de Abstracción

## 🎯 Objetivos

Al finalizar este tema, serás capaz de:
- Comprender qué es la abstracción en POO
- Distinguir entre abstracción y encapsulación
- Identificar los beneficios de la abstracción
- Aplicar abstracción en el diseño de clases

---

## 📖 ¿Qué es la Abstracción?

### Definición

La **abstracción** es el proceso de ocultar los detalles complejos de implementación y exponer solo la funcionalidad esencial. Es uno de los cuatro pilares fundamentales de la Programación Orientada a Objetos.

> **Analogía del mundo real:** 
> Cuando conduces un automóvil, usas el volante, pedales y palanca de cambios sin necesidad de saber cómo funciona el motor, la transmisión o el sistema eléctrico internamente. El automóvil te **abstrae** esa complejidad.

### Ejemplo Visual

```
┌────────────────────────────────────────┐
│     MUNDO REAL - Sistema Complejo     │
│                                        │
│  Automóvil con:                        │
│  • Motor (4 cilindros, inyección...)  │
│  • Transmisión (engranajes, clutch...)│
│  • Sistema eléctrico (batería, ECU...)│
│  • +50 componentes más...             │
└────────────────────────────────────────┘
              │
              │ ABSTRACCIÓN
              ▼
┌────────────────────────────────────────┐
│  MODELO ABSTRACTO - Solo lo Esencial  │
│                                        │
│  class Vehiculo {                      │
│    + String marca                      │
│    + int velocidad                     │
│    + acelerar()                        │
│    + frenar()                          │
│  }                                     │
└────────────────────────────────────────┘
```

---

## 🔑 Características de la Abstracción

### 1. Oculta la Complejidad
No necesitas entender cómo funciona internamente algo para usarlo.

### 2. Muestra lo Esencial
Solo expone las características y operaciones relevantes para el usuario.

### 3. Simplifica el Diseño
Reduce la carga cognitiva al trabajar con sistemas complejos.

### 4. Facilita el Mantenimiento
Los cambios internos no afectan a quienes usan la abstracción.

---

## 🆚 Abstracción vs Encapsulación

Aunque están relacionados, son conceptos diferentes:

| Aspecto | Abstracción | Encapsulación |
|---------|-------------|---------------|
| **Enfoque** | ¿QUÉ hace un objeto? | ¿CÓMO proteger los datos? |
| **Propósito** | Ocultar complejidad | Proteger integridad de datos |
| **Implementación** | Clases abstractas, interfaces | Modificadores de acceso (private) |
| **Nivel** | Diseño conceptual | Implementación técnica |
| **Ejemplo** | "Vehiculo puede acelerar" | "velocidad es private" |

### Ejemplo Comparativo

```java
// ABSTRACCIÓN: Define QUÉ puede hacer un empleado
public abstract class Empleado {
    public abstract double calcularSalario(); // QUÉ
}

// ENCAPSULACIÓN: Protege CÓMO se almacena el salario
public class EmpleadoPlanta extends Empleado {
    private double salarioBase; // CÓMO (protegido)
    
    @Override
    public double calcularSalario() {
        return salarioBase * 1.2; // Implementación
    }
}
```

---

## 🌟 Beneficios de la Abstracción

### 1. **Reducción de Complejidad**
```java
// Sin abstracción: muchos detalles
Motor motor = new Motor(4, "inyeccion", 2000);
motor.encender();
motor.calentarBujias();
motor.activarInyectores();
// ... 20 líneas más

// Con abstracción: simple
Vehiculo auto = new Auto();
auto.encender(); // Todo lo complejo ocurre internamente
```

### 2. **Reutilización de Código**
Define comportamiento común en clases abstractas:
```java
abstract class Figura {
    abstract double calcularArea(); // Común a todas
}

class Circulo extends Figura { /* ... */ }
class Rectangulo extends Figura { /* ... */ }
// Ambas comparten el concepto "área"
```

### 3. **Mantenibilidad**
Los cambios internos no rompen código externo:
```java
// Cambias la implementación interna
public abstract class Empleado {
    public abstract double calcularSalario();
    // Implementación puede cambiar sin afectar usuarios
}
```

### 4. **Flexibilidad y Escalabilidad**
Fácil agregar nuevos tipos sin modificar código existente:
```java
// Nueva figura sin cambiar código existente
class Triangulo extends Figura {
    @Override
    double calcularArea() { return base * altura / 2; }
}
```

---

## 📊 Niveles de Abstracción

En sistemas complejos, trabajamos con múltiples niveles:

```
Nivel 1 (Alto)     →  Usuario interactúa con UI
                      ↓
Nivel 2 (Medio)    →  Lógica de negocio (Empleado, Producto)
                      ↓
Nivel 3 (Bajo)     →  Acceso a base de datos
                      ↓
Nivel 4 (Muy Bajo) →  Sistema operativo, hardware
```

Cada nivel abstrae la complejidad del nivel inferior.

---

## 🛠️ Cómo Implementar Abstracción en Java

Java proporciona dos mecanismos principales:

### 1. Clases Abstractas
```java
public abstract class Animal {
    protected String nombre;
    
    // Método abstracto (sin implementación)
    public abstract void hacerSonido();
    
    // Método concreto (con implementación)
    public void dormir() {
        System.out.println(nombre + " está durmiendo");
    }
}
```

### 2. Interfaces
```java
public interface Volador {
    void volar();
    void aterrizar();
}
```

> **Veremos ambos en detalle en los siguientes temas.**

---

## 🧩 Ejemplo Completo: Sistema Bancario

### Sin Abstracción (Código Duplicado)
```java
class CuentaAhorros {
    private double saldo;
    
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso");
        }
    }
    
    public double consultarSaldo() { return saldo; }
}

class CuentaCorriente {
    private double saldo;
    
    // MISMO CÓDIGO repetido
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso");
        }
    }
    
    public double consultarSaldo() { return saldo; }
}
```

### Con Abstracción (Código Reutilizable)
```java
public abstract class Cuenta {
    protected double saldo;
    
    // Comportamiento común (concreto)
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso");
        }
    }
    
    public double consultarSaldo() { return saldo; }
    
    // Comportamiento específico (abstracto)
    public abstract void aplicarIntereses();
}

class CuentaAhorros extends Cuenta {
    @Override
    public void aplicarIntereses() {
        saldo += saldo * 0.05; // 5% interés
    }
}

class CuentaCorriente extends Cuenta {
    @Override
    public void aplicarIntereses() {
        // Cuenta corriente no genera intereses
    }
}
```

**Ventajas:**
- ✅ Elimina duplicación
- ✅ Fácil agregar nuevos tipos de cuenta
- ✅ Cambios en `depositar()` se aplican automáticamente

---

## 🎓 Principios de Diseño Relacionados

### Principio de Abstracción
> "Un cliente no debería depender de detalles de implementación, solo de abstracciones."

### Ejemplo:
```java
// ❌ MAL: Depende de implementación concreta
EmpleadoPlanta empleado = new EmpleadoPlanta("Juan");
double salario = empleado.calcularSalario();

// ✅ BIEN: Depende de abstracción
Empleado empleado = new EmpleadoPlanta("Juan");
double salario = empleado.calcularSalario();
// Puedo cambiar a EmpleadoContrato sin modificar este código
```

---

## 🌍 Ejemplos del Mundo Real

### 1. **Control Remoto de TV**
- **Abstracción:** Botones de encendido, volumen, canales
- **Complejidad oculta:** Circuitos, señales infrarrojas, procesamiento

### 2. **Cajero Automático**
- **Abstracción:** Pantalla táctil, opciones (retirar, consultar)
- **Complejidad oculta:** Conexión a banco, validación, dispensador de billetes

### 3. **Java Collections**
```java
// Abstracción: interfaz List
List<String> nombres = new ArrayList<>();
nombres.add("Juan");
nombres.get(0);

// Complejidad oculta: arrays dinámicos, redimensionamiento, manejo de memoria
```

---

## ✅ Checklist: ¿Cuándo Usar Abstracción?

Usa abstracción cuando:

- ✅ Tienes comportamiento común entre varias clases
- ✅ Quieres definir un "contrato" que otras clases deben cumplir
- ✅ Necesitas ocultar detalles de implementación complejos
- ✅ Quieres permitir múltiples implementaciones de un concepto
- ✅ El sistema es complejo y necesitas simplificar la interfaz

---

## 🚫 Errores Comunes

### 1. Confundir Abstracción con Encapsulación
```java
// ❌ Esto es ENCAPSULACIÓN, no abstracción
class Usuario {
    private String password; // Solo proteger datos
}

// ✅ Esto es ABSTRACCIÓN
abstract class Usuario {
    abstract void autenticar(); // Define QUÉ hacer
}
```

### 2. Abstraer Demasiado Pronto
No crees clases abstractas si solo tienes una implementación.

```java
// ❌ Innecesario si solo hay una implementación
abstract class ProductoUnico {
    abstract void vender();
}

// ✅ Espera a tener 2+ implementaciones
class Producto {
    void vender() { /* ... */ }
}
```

### 3. No Documentar la Abstracción
```java
// ❌ Sin documentar el propósito
abstract class Base {
    abstract void proceso();
}

// ✅ Documentado
/**
 * Representa el flujo base de procesamiento de pagos.
 * Las subclases deben implementar la validación específica.
 */
abstract class ProcesadorPago {
    abstract boolean validar();
}
```

---

## 📚 Resumen

| Concepto | Descripción |
|----------|-------------|
| **Abstracción** | Ocultar complejidad, mostrar lo esencial |
| **Diferencia con Encapsulación** | Abstracción: QUÉ / Encapsulación: CÓMO |
| **Beneficios** | Simplicidad, reutilización, mantenibilidad |
| **Implementación** | Clases abstractas, interfaces |
| **Cuándo usar** | Comportamiento común, múltiples implementaciones |

---

## 🎯 Ejercicio de Reflexión

Piensa en tu dominio asignado (Agencia de Viajes, Restaurante, etc.):

1. **Identifica 3 objetos** que podrían beneficiarse de abstracción
2. **¿Qué comportamiento común** tienen?
3. **¿Qué detalles** se pueden ocultar?

**Ejemplo para Restaurante:**
- **Objetos:** Pizza, Hamburguesa, Ensalada
- **Común:** Todos son "Platillos" que se preparan
- **Abstracción:** `abstract class Platillo { abstract void preparar(); }`

---

## 🔗 Próximo Tema

En el siguiente tema veremos **Clases Abstractas** en detalle:
- Sintaxis `abstract class`
- Métodos abstractos vs concretos
- Constructores en clases abstractas
- Ejemplos prácticos

---

## 📖 Referencias

- Oracle Java Tutorials: [Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- Effective Java (Joshua Bloch) - Item 20: Prefer interfaces to abstract classes
- Head First Design Patterns - Capítulo sobre Abstracción

---

**¡Ahora sabes qué es la abstracción y por qué es importante! 🎨**
