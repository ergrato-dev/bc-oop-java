# ⚠️ Errores Comunes en Abstracción e Interfaces

## 🎯 Objetivo

Identificar y evitar los errores más frecuentes al trabajar con clases abstractas e interfaces en Java.

---

## ❌ Errores con Clases Abstractas

### Error 1: Intentar Instanciar una Clase Abstracta

**❌ Código Incorrecto:**
```java
abstract class Animal {
    abstract void hacerSonido();
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(); // ❌ ERROR DE COMPILACIÓN
    }
}
```

**Error del Compilador:**
```
Animal is abstract; cannot be instantiated
```

**✅ Solución:**
```java
class Perro extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("Guau!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Perro(); // ✅ Correcto
        animal.hacerSonido();
    }
}
```

**📝 Explicación:** Las clases abstractas son plantillas, solo se pueden instanciar sus subclases concretas.

---

### Error 2: Olvidar Implementar Métodos Abstractos

**❌ Código Incorrecto:**
```java
abstract class Figura {
    abstract double calcularArea();
    abstract double calcularPerimetro();
}

class Circulo extends Figura {
    private double radio;
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    // ❌ Falta calcularPerimetro()
}
```

**Error del Compilador:**
```
Circulo is not abstract and does not override abstract method calcularPerimetro() in Figura
```

**✅ Solución:**
```java
class Circulo extends Figura {
    private double radio;
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double calcularPerimetro() { // ✅ Implementado
        return 2 * Math.PI * radio;
    }
}
```

**📝 Explicación:** Toda subclase concreta DEBE implementar TODOS los métodos abstractos del padre.

---

### Error 3: Constructores en Clases Abstractas Mal Usados

**❌ Código Incorrecto:**
```java
abstract class Empleado {
    private String nombre;
    
    // Constructor público (innecesario)
    public Empleado(String nombre) {
        this.nombre = nombre;
    }
}

class Main {
    public static void main(String[] args) {
        Empleado e = new Empleado("Juan"); // ❌ No compila
    }
}
```

**⚠️ Confusión Común:** "Si tiene constructor, puedo instanciarlo" - FALSO

**✅ Código Correcto:**
```java
abstract class Empleado {
    private String nombre;
    
    // Constructor protected (mejor práctica)
    protected Empleado(String nombre) {
        this.nombre = nombre;
    }
}

class EmpleadoPlanta extends Empleado {
    public EmpleadoPlanta(String nombre) {
        super(nombre); // ✅ Usa el constructor del padre
    }
}
```

**📝 Explicación:** Los constructores de clases abstractas son para que las subclases los usen con `super()`.

---

### Error 4: Métodos Abstractos con Cuerpo

**❌ Código Incorrecto:**
```java
abstract class Animal {
    abstract void comer() { // ❌ ERROR
        System.out.println("Comiendo...");
    }
}
```

**Error del Compilador:**
```
abstract methods cannot have a body
```

**✅ Solución:**
```java
abstract class Animal {
    // Opción 1: Método abstracto SIN cuerpo
    abstract void comer();
    
    // Opción 2: Método concreto CON cuerpo
    void dormir() {
        System.out.println("Durmiendo...");
    }
}
```

**📝 Explicación:** `abstract` = sin implementación. Si tiene cuerpo, quita `abstract`.

---

## ❌ Errores con Interfaces

### Error 5: Olvidar Implementar Métodos de Interface

**❌ Código Incorrecto:**
```java
interface Volador {
    void volar();
    void aterrizar();
}

class Avion implements Volador {
    @Override
    public void volar() {
        System.out.println("Volando...");
    }
    // ❌ Falta aterrizar()
}
```

**Error del Compilador:**
```
Avion is not abstract and does not override abstract method aterrizar() in Volador
```

**✅ Solución:**
```java
class Avion implements Volador {
    @Override
    public void volar() {
        System.out.println("Volando...");
    }
    
    @Override
    public void aterrizar() { // ✅ Implementado
        System.out.println("Aterrizando...");
    }
}
```

**📝 Explicación:** Todas las clases concretas deben implementar TODOS los métodos de las interfaces.

---

### Error 6: Métodos de Interface con Modificador de Acceso Incorrecto

**❌ Código Incorrecto:**
```java
interface Calculable {
    void calcular();
}

class Calculadora implements Calculable {
    @Override
    private void calcular() { // ❌ ERROR: private
        // ...
    }
}
```

**Error del Compilador:**
```
calcular() in Calculadora cannot implement calcular() in Calculable
  attempting to assign weaker access privileges; was public
```

**✅ Solución:**
```java
class Calculadora implements Calculable {
    @Override
    public void calcular() { // ✅ Debe ser public
        // ...
    }
}
```

**📝 Explicación:** Métodos de interfaces son implícitamente `public`, las implementaciones DEBEN ser `public`.

---

### Error 7: Intentar Instanciar una Interface

**❌ Código Incorrecto:**
```java
interface Dibujable {
    void dibujar();
}

public class Main {
    public static void main(String[] args) {
        Dibujable d = new Dibujable(); // ❌ ERROR
    }
}
```

**Error del Compilador:**
```
Dibujable is abstract; cannot be instantiated
```

**✅ Solución:**
```java
class Circulo implements Dibujable {
    @Override
    public void dibujar() {
        System.out.println("Dibujando círculo");
    }
}

public class Main {
    public static void main(String[] args) {
        Dibujable d = new Circulo(); // ✅ Correcto
        d.dibujar();
    }
}
```

**📝 Explicación:** Las interfaces son contratos, no implementaciones. Solo se pueden instanciar sus implementaciones.

---

### Error 8: Atributos de Instancia en Interfaces

**❌ Código Incorrecto:**
```java
interface Usuario {
    String nombre; // ❌ ERROR implícito
    int edad;      // ❌ ERROR implícito
    
    void mostrarInfo();
}
```

**Error del Compilador:**
```
= expected (las interfaces solo pueden tener constantes)
```

**✅ Solución Opción 1: Constantes**
```java
interface Usuario {
    // Constantes (public static final implícito)
    int EDAD_MINIMA = 18;
    int EDAD_MAXIMA = 100;
    
    void mostrarInfo();
}
```

**✅ Solución Opción 2: Getters en Interface**
```java
interface Usuario {
    String getNombre();
    int getEdad();
    void mostrarInfo();
}

class UsuarioImpl implements Usuario {
    private String nombre; // ✅ Estado en la clase
    private int edad;
    
    public UsuarioImpl(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public String getNombre() { return nombre; }
    
    @Override
    public int getEdad() { return edad; }
    
    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " - " + edad);
    }
}
```

**📝 Explicación:** Las interfaces NO pueden tener atributos de instancia, solo constantes (`public static final`).

---

## ❌ Errores de Diseño

### Error 9: Usar Interface Cuando Debería Ser Clase Abstracta

**❌ Diseño Incorrecto:**
```java
interface Animal {
    void comer();
    void dormir();
    void hacerSonido();
}

class Perro implements Animal {
    @Override
    public void comer() {
        System.out.println("El perro come"); // Duplicado
    }
    
    @Override
    public void dormir() {
        System.out.println("El perro duerme"); // Duplicado
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
    }
}

class Gato implements Animal {
    @Override
    public void comer() {
        System.out.println("El gato come"); // Duplicado
    }
    
    @Override
    public void dormir() {
        System.out.println("El gato duerme"); // Duplicado
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("Miau!");
    }
}
```

**⚠️ Problema:** Código duplicado en `comer()` y `dormir()`.

**✅ Diseño Correcto:**
```java
abstract class Animal {
    // Comportamiento común implementado
    public void comer() {
        System.out.println("El animal come");
    }
    
    public void dormir() {
        System.out.println("El animal duerme");
    }
    
    // Solo lo variable es abstracto
    public abstract void hacerSonido();
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
    }
}

class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau!");
    }
}
```

**📝 Explicación:** Si hay comportamiento común, usa clase abstracta. Si solo defines contrato, usa interface.

---

### Error 10: Interfaces Demasiado Grandes (Violación ISP)

**❌ Diseño Incorrecto:**
```java
interface Trabajador {
    void trabajar();
    void comer();
    void dormir();
    void cobrarSalario();
    void tomarVacaciones();
    void hacerReporte();
}

class Robot implements Trabajador {
    @Override
    public void trabajar() { /* OK */ }
    
    @Override
    public void comer() { 
        throw new UnsupportedOperationException(); // ❌ Mal
    }
    
    @Override
    public void dormir() {
        throw new UnsupportedOperationException(); // ❌ Mal
    }
    
    @Override
    public void tomarVacaciones() {
        throw new UnsupportedOperationException(); // ❌ Mal
    }
    // ...
}
```

**✅ Diseño Correcto (ISP - Interface Segregation Principle):**
```java
interface Trabajable {
    void trabajar();
}

interface Comestible {
    void comer();
}

interface Descansable {
    void dormir();
    void tomarVacaciones();
}

interface Pagable {
    void cobrarSalario();
}

// Robot solo implementa lo que necesita
class Robot implements Trabajable, Pagable {
    @Override
    public void trabajar() {
        System.out.println("Robot trabajando");
    }
    
    @Override
    public void cobrarSalario() {
        System.out.println("Mantenimiento pagado");
    }
}

// Humano implementa todo
class Empleado implements Trabajable, Comestible, Descansable, Pagable {
    // Implementa todos los métodos
}
```

**📝 Explicación:** Muchas interfaces pequeñas > Una interface grande (Principio ISP).

---

## 🔍 Cómo Detectar Errores

### 1. Errores de Compilación
- ✅ El compilador los detecta automáticamente
- ✅ Lee el mensaje de error cuidadosamente
- ✅ La línea indicada es donde está el problema

### 2. Errores de Diseño
- ⚠️ El código compila pero el diseño es malo
- ⚠️ Código duplicado
- ⚠️ Clases que lanzan `UnsupportedOperationException`
- ⚠️ Dificultad para extender

### 3. Herramientas de Detección
- **IntelliJ IDEA:** Warnings amarillos, sugerencias
- **SonarLint:** Plugin para detectar code smells
- **Checkstyle:** Validador de estilo y buenas prácticas

---

## ✅ Checklist de Verificación

Antes de finalizar tu código, verifica:

- [ ] ¿Todas las clases abstractas tienen al menos un método abstracto?
- [ ] ¿Todas las subclases implementan los métodos abstractos?
- [ ] ¿Los métodos de interfaces son `public` en las implementaciones?
- [ ] ¿No hay atributos de instancia en interfaces?
- [ ] ¿No intentas instanciar clases abstractas o interfaces?
- [ ] ¿El diseño usa clase abstracta cuando hay comportamiento común?
- [ ] ¿El diseño usa interfaces cuando solo defines contratos?
- [ ] ¿Las interfaces son pequeñas y específicas (ISP)?

---

## 💡 Consejos para Evitar Errores

1. **Lee los mensajes del compilador:** Son muy descriptivos
2. **Usa @Override:** Te avisa si no estás sobrescribiendo correctamente
3. **Diseña antes de codificar:** Piensa si necesitas abstracta o interface
4. **Revisa SOLID:** Especialmente ISP y DIP
5. **Prueba constantemente:** No esperes a terminar todo el código

---

**¡Evita estos errores y escribe código de calidad! ✨**
