# 04 - Diferencias y Comparación: Clases Abstractas vs Interfaces

## 🎯 Objetivos

Al finalizar este tema, serás capaz de:
- Identificar las diferencias clave entre clases abstractas e interfaces
- Decidir cuándo usar cada una
- Aplicar criterios de diseño apropiados
- Evitar errores comunes de decisión

---

## 📊 Tabla Comparativa Completa

| Característica | Clase Abstracta | Interface |
|----------------|----------------|-----------|
| **Palabra clave** | `abstract class` | `interface` |
| **Implementación** | `extends` (herencia simple) | `implements` (múltiple) |
| **Métodos abstractos** | ✅ Puede tener | ✅ Todos son abstractos* |
| **Métodos concretos** | ✅ Puede tener | ✅ Solo `default` y `static` (Java 8+) |
| **Constructores** | ✅ Puede tener | ❌ No permitidos |
| **Atributos de instancia** | ✅ Puede tener (cualquier tipo) | ❌ Solo constantes (`public static final`) |
| **Modificadores de acceso** | ✅ public, protected, private | ❌ Solo public (implícito) |
| **Herencia múltiple** | ❌ No (solo extends una clase) | ✅ Sí (implements múltiples interfaces) |
| **Variables de instancia** | ✅ Puede tener | ❌ No puede tener |
| **Inicialización de estado** | ✅ En constructor | ❌ No aplica |
| **Relación conceptual** | "ES-UN" (is-a) | "PUEDE-HACER" (can-do) |
| **Versión Java** | Desde Java 1.0 | Desde Java 1.0 (mejoradas en 8+) |

*Excepto métodos `default` y `static` desde Java 8

---

## 🔍 Diferencias Fundamentales

### 1. Propósito Conceptual

**Clase Abstracta:**
```java
// Representa una relación "ES-UN"
abstract class Vehiculo {
    protected String marca; // Estado compartido
    
    // Comportamiento común
    public void apagar() {
        System.out.println("Vehículo apagado");
    }
    
    // Comportamiento variable
    public abstract void arrancar();
}

class Auto extends Vehiculo { } // Auto ES-UN Vehiculo
```

**Interface:**
```java
// Representa una capacidad "PUEDE-HACER"
interface Volador {
    void volar();
}

class Avion implements Volador { } // Avion PUEDE volar
class Pajaro implements Volador { } // Pajaro PUEDE volar
// No están relacionados jerárquicamente
```

### 2. Herencia

**Clase Abstracta (Simple):**
```java
// ❌ NO se puede heredar de múltiples clases
class Empleado extends Persona, Animal { } // ERROR

// ✅ Solo una clase padre
class Empleado extends Persona { }
```

**Interface (Múltiple):**
```java
// ✅ Se pueden implementar múltiples interfaces
class Empleado implements Trabajador, Estudiante, Deportista {
    // Implementa métodos de las 3 interfaces
}
```

### 3. Estado (Atributos)

**Clase Abstracta:**
```java
abstract class Cuenta {
    // ✅ Puede tener estado
    protected double saldo;
    protected String titular;
    
    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }
}
```

**Interface:**
```java
interface Operable {
    // ❌ NO puede tener estado
    // String nombre; // ERROR
    
    // ✅ Solo constantes
    int MAX_OPERACIONES = 100;
    
    void operar();
}
```

### 4. Constructores

**Clase Abstracta:**
```java
abstract class Animal {
    private String nombre;
    
    // ✅ Puede tener constructor
    public Animal(String nombre) {
        this.nombre = nombre;
    }
}

class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre); // Llama constructor padre
    }
}
```

**Interface:**
```java
interface Dibujable {
    // ❌ NO puede tener constructor
    // public Dibujable() { } // ERROR
    
    void dibujar();
}
```

---

## 🎯 Cuándo Usar Cada Una

### Usa Clase Abstracta Cuando:

#### 1. Tienes Comportamiento Común a Compartir
```java
abstract class Figura {
    protected String color;
    
    // Método concreto común
    public void establecerColor(String color) {
        this.color = color;
    }
    
    // Método abstracto
    public abstract double calcularArea();
}
```

#### 2. Necesitas Mantener Estado
```java
abstract class JugadorEquipo {
    private String nombre;
    private int numero;
    private double salario; // Estado privado
    
    public JugadorEquipo(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
}
```

#### 3. Relación "ES-UN" Clara
```java
abstract class Empleado { }

class EmpleadoPlanta extends Empleado { } // ES-UN
class EmpleadoContrato extends Empleado { } // ES-UN
```

#### 4. Necesitas Diferentes Niveles de Acceso
```java
abstract class BaseDatos {
    protected void conectar() { } // protected
    private void validar() { } // private
    public abstract void consultar(); // public
}
```

### Usa Interface Cuando:

#### 1. Defines una Capacidad Sin Relación Jerárquica
```java
interface Volador {
    void volar();
}

class Avion implements Volador { }
class Pajaro implements Volador { }
class Superman implements Volador { }
// Todos PUEDEN volar, pero no están relacionados
```

#### 2. Necesitas Implementación Múltiple
```java
class Smartphone implements Telefono, Camara, Reproductor {
    // Tiene múltiples capacidades
}
```

#### 3. Defines un Contrato/API
```java
interface RepositorioDatos {
    void guardar(Object obj);
    Object buscar(int id);
    void eliminar(int id);
}
// Define QUÉ debe hacer, no CÓMO
```

#### 4. Independencia de Jerarquía
```java
interface Serializable { } // Capacidad aplicable a cualquier clase

class Persona implements Serializable { }
class Producto implements Serializable { }
class Pedido implements Serializable { }
```

---

## 💡 Ejemplos Prácticos

### Ejemplo 1: Sistema de Figuras Geométricas

**Decisión:** Clase Abstracta

**Razón:** Relación "es-un" + comportamiento común

```java
abstract class Figura {
    protected String color;
    
    // Constructor
    public Figura(String color) {
        this.color = color;
    }
    
    // Método concreto común
    public String getColor() {
        return color;
    }
    
    public void mostrarInfo() {
        System.out.println("Figura de color: " + color);
        System.out.println("Área: " + calcularArea());
    }
    
    // Métodos abstractos
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

class Circulo extends Figura {
    private double radio;
    
    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}
```

### Ejemplo 2: Sistema de Dispositivos Electrónicos

**Decisión:** Interfaces

**Razón:** Múltiples capacidades independientes

```java
interface Encendible {
    void encender();
    void apagar();
}

interface Conectable {
    void conectar(String red);
    void desconectar();
}

interface Recargable {
    void cargar();
    int obtenerNivelBateria();
}

// Smartphone tiene las 3 capacidades
class Smartphone implements Encendible, Conectable, Recargable {
    private boolean encendido;
    private String redConectada;
    private int bateria;
    
    @Override
    public void encender() {
        encendido = true;
        System.out.println("Smartphone encendido");
    }
    
    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Smartphone apagado");
    }
    
    @Override
    public void conectar(String red) {
        redConectada = red;
        System.out.println("Conectado a " + red);
    }
    
    @Override
    public void desconectar() {
        redConectada = null;
        System.out.println("Desconectado");
    }
    
    @Override
    public void cargar() {
        bateria = 100;
        System.out.println("Cargando...");
    }
    
    @Override
    public int obtenerNivelBateria() {
        return bateria;
    }
}
```

### Ejemplo 3: Combinando Ambas

```java
// Clase abstracta: jerarquía base
abstract class Vehiculo {
    protected String marca;
    protected int anio;
    
    public Vehiculo(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }
    
    public abstract void arrancar();
    
    public void mostrarInfo() {
        System.out.println(marca + " " + anio);
    }
}

// Interfaces: capacidades opcionales
interface Volador {
    void volar();
    void aterrizar();
}

interface Acuatico {
    void navegar();
}

// Auto: solo vehiculo terrestre
class Auto extends Vehiculo {
    public Auto(String marca, int anio) {
        super(marca, anio);
    }
    
    @Override
    public void arrancar() {
        System.out.println("Auto arrancando...");
    }
}

// Avion: vehiculo + volador
class Avion extends Vehiculo implements Volador {
    public Avion(String marca, int anio) {
        super(marca, anio);
    }
    
    @Override
    public void arrancar() {
        System.out.println("Avión encendiendo motores...");
    }
    
    @Override
    public void volar() {
        System.out.println("Avión volando");
    }
    
    @Override
    public void aterrizar() {
        System.out.println("Avión aterrizando");
    }
}

// Hidroavion: vehiculo + volador + acuático
class Hidroavion extends Vehiculo implements Volador, Acuatico {
    public Hidroavion(String marca, int anio) {
        super(marca, anio);
    }
    
    @Override
    public void arrancar() {
        System.out.println("Hidroavión listo");
    }
    
    @Override
    public void volar() {
        System.out.println("Hidroavión volando");
    }
    
    @Override
    public void aterrizar() {
        System.out.println("Hidroavión amerizando");
    }
    
    @Override
    public void navegar() {
        System.out.println("Hidroavión navegando");
    }
}
```

---

## 🚫 Errores Comunes de Diseño

### Error 1: Usar Interface Cuando Debería Ser Clase Abstracta

```java
// ❌ MAL: Interface sin comportamiento común
interface Animal {
    void comer(); // Cada animal come igual
    void dormir(); // Cada animal duerme igual
    void hacerSonido(); // Solo esto varía
}

// ✅ BIEN: Clase abstracta con comportamiento común
abstract class Animal {
    // Comportamiento común
    public void comer() {
        System.out.println("Comiendo...");
    }
    
    public void dormir() {
        System.out.println("Durmiendo...");
    }
    
    // Solo esto varía
    public abstract void hacerSonido();
}
```

### Error 2: Usar Clase Abstracta Cuando Debería Ser Interface

```java
// ❌ MAL: No hay relación jerárquica real
abstract class Nadador {
    abstract void nadar();
}

class Pez extends Nadador { }
class Persona extends Nadador { }
// Pez y Persona no están relacionados jerárquicamente

// ✅ BIEN: Interface para capacidad
interface Nadador {
    void nadar();
}

class Pez implements Nadador { }
class Persona implements Nadador { }
```

### Error 3: Múltiples Niveles de Abstracción Innecesarios

```java
// ❌ SOBREINGENIERÍA
abstract class EntidadBase { }
abstract class EntidadPersistente extends EntidadBase { }
abstract class EntidadNegocio extends EntidadPersistente { }
class Producto extends EntidadNegocio { }

// ✅ SIMPLE
abstract class Entidad { }
class Producto extends Entidad { }
```

---

## 📋 Checklist de Decisión

### ¿Debería Usar Clase Abstracta?

- [ ] ¿Hay relación "es-un" clara?
- [ ] ¿Necesito compartir estado (atributos)?
- [ ] ¿Necesito compartir implementación (métodos concretos)?
- [ ] ¿Necesito constructores?
- [ ] ¿Necesito diferentes niveles de acceso (private, protected)?

**Si respondiste SÍ a 2 o más:** Usa **Clase Abstracta**

### ¿Debería Usar Interface?

- [ ] ¿Defino una capacidad sin jerarquía?
- [ ] ¿Necesito implementación múltiple?
- [ ] ¿Defino solo un contrato (QUÉ, no CÓMO)?
- [ ] ¿Clases no relacionadas compartirán esta capacidad?
- [ ] ¿Es una API o estándar?

**Si respondiste SÍ a 2 o más:** Usa **Interface**

---

## 📚 Resumen

| Criterio | Clase Abstracta | Interface |
|----------|----------------|-----------|
| **Relación** | ES-UN (jerárquica) | PUEDE-HACER (capacidad) |
| **Estado** | ✅ Sí | ❌ No (solo constantes) |
| **Implementación común** | ✅ Sí (métodos concretos) | ⚠️ Solo default/static |
| **Herencia múltiple** | ❌ No | ✅ Sí |
| **Constructores** | ✅ Sí | ❌ No |
| **Cuándo usar** | Jerarquía con comportamiento común | Contrato independiente de jerarquía |

---

## 💡 Mejores Prácticas

1. **Favorece interfaces sobre clases abstractas** cuando sea posible (más flexibilidad)
2. **Combínalas** cuando tenga sentido (clase abstracta + interfaces)
3. **Usa nombres descriptivos:**
   - Clases abstractas: sustantivos (`Animal`, `Vehiculo`)
   - Interfaces: adjetivos o capacidades (`Volador`, `Comparable`)
4. **Mantén interfaces pequeñas** (Principio de Segregación de Interfaces)
5. **No abuses de la herencia** (composición sobre herencia)

---

## 🔗 Próximo Tema

En el siguiente tema veremos **Diseño con Abstracción**:
- Principios SOLID aplicados
- Patrones de diseño con abstracción
- Refactorización hacia abstracción
- Casos de estudio

---

**¡Ahora sabes cuándo usar clases abstractas e interfaces! 🎨**
