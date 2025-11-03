# Glosario - Semana 06: Abstracción e Interfaces

## 📚 Términos Clave

### A

**Abstracción (Abstraction)**
> Principio de POO que consiste en ocultar los detalles de implementación complejos y exponer solo la funcionalidad esencial.

```java
// Abstrae la complejidad del cálculo de salarios
abstract class Empleado {
    abstract double calcularSalario();
}
```

**Clase Abstracta (Abstract Class)**
> Clase que no puede ser instanciada directamente y puede contener métodos abstractos (sin implementación) y métodos concretos (con implementación).

```java
public abstract class Vehiculo {
    abstract void arrancar(); // abstracto
    void apagar() { /* ... */ } // concreto
}
```

**abstract**
> Palabra clave de Java para declarar clases o métodos abstractos que deben ser implementados por las subclases.

---

### B

**Binding Dinámico (Dynamic Binding)**
> Proceso donde la JVM determina en tiempo de ejecución qué método invocar basándose en el tipo real del objeto.

```java
Animal animal = new Perro(); // Binding dinámico
animal.hacerSonido(); // Llama al método de Perro
```

---

### C

**Contrato (Contract)**
> Conjunto de métodos que una clase debe implementar, definido por una interfaz.

```java
interface Dibujable {
    void dibujar(); // Contrato
}
```

**Clase Concreta (Concrete Class)**
> Clase que puede ser instanciada porque implementa todos los métodos abstractos heredados.

```java
class Perro extends Animal { // Concreta
    @Override
    void hacerSonido() { /* implementado */ }
}
```

---

### D

**default (método default)**
> Método en una interface (desde Java 8) que tiene una implementación por defecto.

```java
interface Calculable {
    default double calcular() {
        return 0.0; // Implementación por defecto
    }
}
```

---

### E

**Encapsulación (Encapsulation) vs Abstracción**
> - **Encapsulación:** CÓMO proteger los datos (private, getters/setters)
> - **Abstracción:** QUÉ hace un objeto (ocultar complejidad)

**extends**
> Palabra clave para heredar de una clase abstracta o concreta.

```java
class Auto extends Vehiculo { /* ... */ }
```

---

### H

**Herencia Múltiple (Multiple Inheritance)**
> Capacidad de una clase de heredar de múltiples fuentes. En Java:
> - ❌ No permitida para clases (solo extends una clase)
> - ✅ Permitida para interfaces (implements múltiples interfaces)

```java
class Circulo implements Dibujable, Redimensionable {
    // Implementa múltiples interfaces ✓
}
```

---

### I

**implements**
> Palabra clave para implementar una o más interfaces.

```java
class Avion implements Volador, Motorizado {
    // Debe implementar métodos de ambas interfaces
}
```

**Interface**
> Contrato que define un conjunto de métodos que una clase debe implementar. No puede tener atributos de instancia (solo constantes).

```java
public interface Comparable<T> {
    int compareTo(T otro);
}
```

**Implementación (Implementation)**
> Código concreto que define el comportamiento de un método abstracto.

```java
@Override
public void volar() {
    // Esta es la implementación
    System.out.println("Volando...");
}
```

---

### M

**Método Abstracto (Abstract Method)**
> Método declarado sin cuerpo (solo la firma) que debe ser implementado por las subclases.

```java
abstract double calcularArea(); // Sin cuerpo
```

**Método Concreto (Concrete Method)**
> Método con implementación completa.

```java
public void mostrarInfo() {
    System.out.println("Info"); // Con cuerpo
}
```

**Método Default (Default Method)**
> Método en una interface que tiene implementación por defecto (desde Java 8).

---

### O

**@Override**
> Anotación que indica que un método sobrescribe un método de la superclase o implementa un método de una interface.

```java
@Override
public double calcularSalario() {
    return salarioBase * 1.2;
}
```

---

### P

**Polimorfismo (Polymorphism)**
> Capacidad de tratar objetos de diferentes clases a través de una interfaz común.

```java
Empleado[] equipo = {
    new EmpleadoPlanta(...),
    new EmpleadoContrato(...),
    new Practicante(...)
};
```

---

### S

**Subclase Concreta (Concrete Subclass)**
> Clase que hereda de una clase abstracta e implementa todos sus métodos abstractos.

```java
class Circulo extends Figura { // Subclase concreta
    @Override
    double calcularArea() { return Math.PI * r * r; }
}
```

**super**
> Palabra clave para:
> 1. Llamar al constructor de la superclase
> 2. Acceder a métodos de la superclase

```java
public EmpleadoPlanta(String nombre, double salario) {
    super(nombre, salario); // Llama constructor padre
}
```

**Segregación de Interfaces (Interface Segregation)**
> Principio SOLID: "Los clientes no deberían depender de interfaces que no usan". Mejor muchas interfaces específicas que una grande.

---

### T

**Tipo de Referencia (Reference Type)**
> Tipo de la variable (puede ser abstracto o interface).

```java
Vehiculo v = new Auto(); // Tipo: Vehiculo (abstracto)
```

**Tipo Real (Actual Type)**
> Tipo del objeto instanciado.

```java
Vehiculo v = new Auto(); // Tipo real: Auto
```

---

## 🔄 Comparaciones Importantes

### Abstracción vs Encapsulación

| Abstracción | Encapsulación |
|-------------|---------------|
| Ocultar complejidad | Proteger datos |
| QUÉ hace | CÓMO lo protege |
| Clases abstractas, interfaces | private, getters/setters |

### Clase Abstracta vs Interface

| Clase Abstracta | Interface |
|-----------------|-----------|
| extends (herencia simple) | implements (múltiple) |
| Métodos abstractos + concretos | Solo abstractos* |
| Puede tener constructores | NO puede tener constructores |
| Puede tener atributos | Solo constantes |
| Relación "es-un" | Capacidad "puede-hacer" |

*Desde Java 8, interfaces pueden tener métodos default y static

---

## 💡 Ejemplos de Uso

### Cuándo Usar Clase Abstracta
```java
// ✅ Relación "es-un" + comportamiento común
abstract class Vehiculo {
    protected String marca; // Atributo común
    abstract void arrancar(); // Comportamiento variable
    void apagar() { /* común */ } // Comportamiento común
}
```

### Cuándo Usar Interface
```java
// ✅ Capacidad sin relación jerárquica
interface Volador {
    void volar();
}

class Avion implements Volador { /* ... */ }
class Pajaro implements Volador { /* ... */ }
// No están relacionados, pero ambos "pueden volar"
```

---

## 🎯 Conceptos Relacionados

**API (Application Programming Interface)**
> Conjunto de métodos públicos que expone una clase o interface para su uso.

**Contrato de Diseño**
> Acuerdo entre la abstracción y sus implementaciones sobre qué métodos deben existir y qué hacen.

**LSP (Liskov Substitution Principle)**
> Principio SOLID: "Los objetos de una superclase deberían poder ser reemplazados por objetos de sus subclases sin romper el programa".

**Acoplamiento (Coupling)**
> Grado de dependencia entre clases. La abstracción reduce el acoplamiento.

**Cohesión (Cohesion)**
> Grado en que los métodos de una clase están relacionados. Interfaces pequeñas y específicas tienen alta cohesión.

---

## 📖 Referencias

- **Oracle Java Tutorials:**
  - [Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
  - [Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

- **Effective Java (Joshua Bloch):**
  - Item 20: Prefer interfaces to abstract classes
  - Item 19: Use interfaces only to define types

- **Principios SOLID:**
  - ISP (Interface Segregation Principle)
  - DIP (Dependency Inversion Principle)

---

## 🔗 Ver También

- `1-teoria/01-concepto-abstraccion.md` - Concepto de abstracción
- `1-teoria/02-clases-abstractas.md` - Clases abstractas en detalle
- `1-teoria/03-interfaces.md` - Interfaces en Java
- `1-teoria/04-diferencias-y-comparacion.md` - Comparación detallada

---

**Última actualización:** Noviembre 2025
