# 02 - Clases Abstractas

## 🎯 Objetivos

Al finalizar este tema, serás capaz de:
- Declarar clases abstractas usando `abstract`
- Crear métodos abstractos y concretos
- Implementar constructores en clases abstractas
- Extender clases abstractas correctamente

---

## 📖 ¿Qué es una Clase Abstracta?

### Definición

Una **clase abstracta** es una clase que:
- **No puede ser instanciada** directamente
- Puede contener **métodos abstractos** (sin implementación)
- Puede contener **métodos concretos** (con implementación)
- Sirve como **base** para otras clases

### Sintaxis Básica

```java
public abstract class NombreClase {
    // Atributos
    // Constructores
    // Métodos abstractos
    // Métodos concretos
}
```

---

## 🔑 Características Principales

### 1. No Se Puede Instanciar

```java
abstract class Animal {
    abstract void hacerSonido();
}

// ❌ ERROR: No se puede instanciar
Animal animal = new Animal(); // Error de compilación

// ✅ CORRECTO: Instanciar subclase concreta
Animal animal = new Perro(); // OK
```

### 2. Puede Tener Métodos Abstractos y Concretos

```java
public abstract class Empleado {
    protected String nombre;
    protected double salarioBase;
    
    // Constructor
    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    
    // Método ABSTRACTO (sin implementación)
    public abstract double calcularSalario();
    
    // Método CONCRETO (con implementación)
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Salario: $" + calcularSalario());
    }
    
    // Getter concreto
    public String getNombre() {
        return nombre;
    }
}
```

### 3. Subclases Deben Implementar Métodos Abstractos

```java
public class EmpleadoPlanta extends Empleado {
    private double bonificacion;
    
    public EmpleadoPlanta(String nombre, double salarioBase, double bonificacion) {
        super(nombre, salarioBase);
        this.bonificacion = bonificacion;
    }
    
    // DEBE implementar el método abstracto
    @Override
    public double calcularSalario() {
        return salarioBase + bonificacion;
    }
}
```

---

## 🛠️ Métodos Abstractos

### Declaración

```java
public abstract class Figura {
    // Método abstracto: solo la firma, sin cuerpo
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
    // ❌ ERROR: método abstracto no puede tener cuerpo
    // public abstract void metodo() { } // No compila
}
```

### Reglas

1. **Solo la firma:** No tienen implementación ({})
2. **Palabra clave `abstract`:** Debe usarse
3. **No pueden ser `private`:** Deben ser heredados
4. **No pueden ser `final`:** Deben ser sobrescritos
5. **No pueden ser `static`:** Requieren instancia

---

## 🏗️ Constructores en Clases Abstractas

Aunque no puedes instanciar directamente una clase abstracta, **SÍ puede tener constructores**.

### Ejemplo

```java
public abstract class Vehiculo {
    private String marca;
    private int anio;
    
    // Constructor de clase abstracta
    public Vehiculo(String marca, int anio) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("Marca inválida");
        }
        this.marca = marca;
        this.anio = anio;
    }
    
    public abstract void arrancar();
    
    // Método concreto
    public String getMarca() {
        return marca;
    }
}

// Subclase usa super() para llamar constructor
public class Auto extends Vehiculo {
    public Auto(String marca, int anio) {
        super(marca, anio); // Llama constructor de Vehiculo
    }
    
    @Override
    public void arrancar() {
        System.out.println("Auto " + getMarca() + " arrancando...");
    }
}
```

**Uso:**
```java
Vehiculo miAuto = new Auto("Toyota", 2023);
miAuto.arrancar(); // "Auto Toyota arrancando..."
```

---

## 📊 Jerarquía con Clases Abstractas

### Ejemplo Completo: Sistema de Empleados

```java
/**
 * Clase base abstracta para todos los empleados
 */
public abstract class Empleado {
    protected String nombre;
    protected String id;
    protected double salarioBase;
    
    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }
    
    // Método abstracto: cada tipo calcula diferente
    public abstract double calcularSalario();
    
    // Método abstracto: cada tipo tiene diferentes beneficios
    public abstract String obtenerBeneficios();
    
    // Método concreto: común para todos
    public void mostrarInformacion() {
        System.out.println("=== Información del Empleado ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Salario: $" + calcularSalario());
        System.out.println("Beneficios: " + obtenerBeneficios());
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getId() { return id; }
}
```

```java
/**
 * Empleado de planta (indefinido)
 */
public class EmpleadoPlanta extends Empleado {
    private double bonificacion;
    private double auxilioTransporte;
    
    public EmpleadoPlanta(String nombre, String id, double salarioBase,
                          double bonificacion, double auxilioTransporte) {
        super(nombre, id, salarioBase);
        this.bonificacion = bonificacion;
        this.auxilioTransporte = auxilioTransporte;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + bonificacion + auxilioTransporte;
    }
    
    @Override
    public String obtenerBeneficios() {
        return "Seguro médico completo, pensión, cesantías";
    }
}
```

```java
/**
 * Empleado por contrato (temporal)
 */
public class EmpleadoContrato extends Empleado {
    private int horasTrabajadas;
    private double valorHora;
    
    public EmpleadoContrato(String nombre, String id, double salarioBase,
                            int horasTrabajadas, double valorHora) {
        super(nombre, id, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }
    
    @Override
    public double calcularSalario() {
        return horasTrabajadas * valorHora;
    }
    
    @Override
    public String obtenerBeneficios() {
        return "Seguro médico básico (sin pensión ni cesantías)";
    }
}
```

```java
/**
 * Practicante
 */
public class Practicante extends Empleado {
    private double auxilioEducativo;
    
    public Practicante(String nombre, String id, double auxilioEducativo) {
        super(nombre, id, 0); // Sin salario base
        this.auxilioEducativo = auxilioEducativo;
    }
    
    @Override
    public double calcularSalario() {
        return auxilioEducativo;
    }
    
    @Override
    public String obtenerBeneficios() {
        return "Carta de recomendación, experiencia laboral";
    }
}
```

### Uso del Sistema

```java
public class SistemaEmpleados {
    public static void main(String[] args) {
        // Array polimórfico de empleados
        Empleado[] empleados = new Empleado[3];
        
        empleados[0] = new EmpleadoPlanta(
            "Ana García", 
            "E001", 
            2500000,  // salario base
            500000,   // bonificación
            120000    // auxilio transporte
        );
        
        empleados[1] = new EmpleadoContrato(
            "Carlos Ruiz",
            "E002",
            0,       // sin salario base
            160,     // horas trabajadas
            25000    // valor hora
        );
        
        empleados[2] = new Practicante(
            "María López",
            "P001",
            900000   // auxilio educativo
        );
        
        // Calcular nómina total
        double nominaTotal = 0;
        for (Empleado emp : empleados) {
            emp.mostrarInformacion();
            nominaTotal += emp.calcularSalario();
            System.out.println();
        }
        
        System.out.println("Nómina Total: $" + nominaTotal);
    }
}
```

**Salida:**
```
=== Información del Empleado ===
Nombre: Ana García
ID: E001
Salario: $3120000.0
Beneficios: Seguro médico completo, pensión, cesantías

=== Información del Empleado ===
Nombre: Carlos Ruiz
ID: E002
Salario: $4000000.0
Beneficios: Seguro médico básico (sin pensión ni cesantías)

=== Información del Empleado ===
Nombre: María López
ID: P001
Salario: $900000.0
Beneficios: Carta de recomendación, experiencia laboral

Nómina Total: $8020000.0
```

---

## ✅ Ventajas de Clases Abstractas

### 1. **Reutilización de Código**
```java
// Comportamiento común en la clase abstracta
public abstract class Cuenta {
    protected double saldo;
    
    // Método común (no repetir en cada subclase)
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
    
    // Comportamiento específico
    public abstract void aplicarIntereses();
}
```

### 2. **Polimorfismo**
```java
Empleado[] equipo = {
    new EmpleadoPlanta("Ana", "E001", 2500000, 500000, 120000),
    new EmpleadoContrato("Carlos", "E002", 0, 160, 25000),
    new Practicante("María", "P001", 900000)
};

for (Empleado emp : equipo) {
    System.out.println(emp.calcularSalario()); // Polimorfismo
}
```

### 3. **Diseño Robusto**
```java
// Garantiza que todas las figuras implementen calcularArea
public abstract class Figura {
    public abstract double calcularArea();
}

// Circulo DEBE implementar calcularArea
public class Circulo extends Figura {
    @Override
    public double calcularArea() { /* ... */ }
}
```

---

## 🚫 Errores Comunes

### 1. Intentar Instanciar Clase Abstracta

```java
abstract class Animal {
    abstract void hacerSonido();
}

// ❌ ERROR
Animal a = new Animal(); // No compila
```

### 2. No Implementar Métodos Abstractos

```java
abstract class Figura {
    abstract double calcularArea();
}

// ❌ ERROR: Debe ser abstracta o implementar calcularArea
class Circulo extends Figura {
    // Falta @Override calcularArea()
}

// ✅ CORRECTO: Opción 1 - Implementar
class Circulo extends Figura {
    @Override
    double calcularArea() { return 3.14 * radio * radio; }
}

// ✅ CORRECTO: Opción 2 - Declarar abstracta
abstract class Circulo extends Figura {
    // OK, sigue siendo abstracta
}
```

### 3. Métodos Abstractos con Modificadores Incorrectos

```java
abstract class Base {
    // ❌ ERROR: abstracto no puede ser private
    private abstract void metodo1();
    
    // ❌ ERROR: abstracto no puede ser final
    final abstract void metodo2();
    
    // ❌ ERROR: abstracto no puede ser static
    static abstract void metodo3();
    
    // ✅ CORRECTO
    public abstract void metodo4();
    protected abstract void metodo5();
}
```

---

## �� Cuándo Usar Clases Abstractas

Usa clases abstractas cuando:

✅ Quieres compartir código entre clases relacionadas  
✅ Tienes una relación "es-un" clara  
✅ Necesitas campos no-static o no-final  
✅ Quieres definir métodos con diferentes niveles de acceso  
✅ Tienes comportamiento común + comportamiento variable

**Ejemplo:**
```java
// ✅ BIEN: Relación "es-un", comportamiento común
abstract class Vehiculo {
    protected String marca;
    
    public abstract void arrancar(); // Variable
    
    public void apagar() { // Común
        System.out.println("Vehículo apagado");
    }
}
```

---

## 📚 Resumen

| Característica | Descripción |
|----------------|-------------|
| **Palabra clave** | `abstract class` |
| **Instanciación** | ❌ No se puede instanciar directamente |
| **Métodos abstractos** | ✅ Puede tener (sin cuerpo) |
| **Métodos concretos** | ✅ Puede tener (con cuerpo) |
| **Constructores** | ✅ Puede tener |
| **Atributos** | ✅ Puede tener (cualquier tipo) |
| **Herencia** | Solo herencia simple (extends) |

---

## 🔗 Próximo Tema

En el siguiente tema veremos **Interfaces**:
- Diferencias con clases abstractas
- Sintaxis `interface`
- Implementación múltiple
- Métodos default y static

---

**¡Ahora dominas las clases abstractas! 🎨**
