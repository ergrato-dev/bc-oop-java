# Repaso de Programación Orientada a Objetos

## 🎯 Los 4 Pilares Revisitados

Esta semana integrarás todos los conceptos aprendidos. Revisemos los fundamentos.

---

## 1️⃣ Encapsulación

### Concepto
Ocultar los detalles internos de implementación y exponer solo lo necesario mediante una interfaz pública.

### Aplicación en el Proyecto
```java
public class Cliente {
    // ❌ MAL: Atributo público
    // public String nombre;
    
    // ✅ BIEN: Atributo privado con acceso controlado
    private String nombre;
    private String email;
    
    public String getNombre() {
        return nombre;
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            throw new DatoInvalidoException("Email inválido");
        }
    }
}
```

### Checklist
- [ ] Todos los atributos son `private`
- [ ] Getters públicos para leer
- [ ] Setters públicos con validaciones
- [ ] No expones estructuras internas (colecciones)

---

## 2️⃣ Herencia

### Concepto
Crear nuevas clases basadas en clases existentes, heredando atributos y métodos.

### Aplicación en el Proyecto
```java
// Clase padre
public class Producto {
    private String id;
    private String nombre;
    private double precioBase;
    
    public Producto(String id, String nombre, double precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }
    
    public double calcularPrecioFinal() {
        return precioBase;
    }
}

// Clases hijas
public class ProductoFisico extends Producto {
    private double pesoKg;
    
    public ProductoFisico(String id, String nombre, double precio, double peso) {
        super(id, nombre, precio);
        this.pesoKg = peso;
    }
    
    @Override
    public double calcularPrecioFinal() {
        return super.calcularPrecioFinal() + (pesoKg * 2); // Costo de envío
    }
}

public class ProductoDigital extends Producto {
    private double tamanoMB;
    
    public ProductoDigital(String id, String nombre, double precio, double tamano) {
        super(id, nombre, precio);
        this.tamanoMB = tamano;
    }
    
    @Override
    public double calcularPrecioFinal() {
        return super.calcularPrecioFinal(); // Sin costo adicional
    }
}
```

### Checklist
- [ ] Jerarquía con 1 padre + 2+ hijos
- [ ] Relación "es-un" tiene sentido lógico
- [ ] Uso de `super()` en constructores
- [ ] Aprovecho métodos heredados

---

## 3️⃣ Polimorfismo

### Concepto
Objetos de diferentes clases responden al mismo mensaje de forma específica.

### Tipos de Polimorfismo

#### Sobrecarga (Overload)
```java
public class Calculadora {
    // Mismo nombre, diferentes parámetros
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public double sumar(double a, double b) {
        return a + b;
    }
    
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
}
```

#### Sobrescritura (Override)
```java
public class Vehiculo {
    public void mostrarInfo() {
        System.out.println("Vehículo genérico");
    }
}

public class Auto extends Vehiculo {
    @Override
    public void mostrarInfo() {
        System.out.println("Auto de 4 ruedas");
    }
}
```

#### Polimorfismo en Colecciones
```java
List<Producto> carrito = new ArrayList<>();
carrito.add(new ProductoFisico("P1", "Laptop", 1000, 2.5));
carrito.add(new ProductoDigital("P2", "Ebook", 15, 2.5));

// Polimorfismo en acción
for (Producto p : carrito) {
    System.out.println(p.calcularPrecioFinal()); // Llama al método correcto
}
```

### Checklist
- [ ] Implemento sobrecarga de métodos
- [ ] Implemento sobrescritura con `@Override`
- [ ] Uso polimorfismo en colecciones

---

## 4️⃣ Abstracción

### Concepto
Modelar conceptos esenciales ocultando detalles de implementación.

### Clases Abstractas
```java
public abstract class Figura {
    private String color;
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
    // Método concreto
    public void mostrarInfo() {
        System.out.println("Área: " + calcularArea());
    }
}

public class Circulo extends Figura {
    private double radio;
    
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

### Interfaces
```java
public interface Pagable {
    void procesarPago(double monto);
    boolean verificarFondos();
}

public class TarjetaCredito implements Pagable {
    @Override
    public void procesarPago(double monto) {
        // Implementación específica
    }
    
    @Override
    public boolean verificarFondos() {
        // Verificación con banco
        return true;
    }
}
```

### Checklist
- [ ] Uso al menos 1 clase abstracta O 1 interface
- [ ] Las clases hijas implementan todos los métodos abstractos
- [ ] La abstracción tiene sentido conceptual

---

## 🔗 Integración de los 4 Pilares

### Ejemplo Completo
```java
// ABSTRACCIÓN: Interface define contrato
public interface Almacenable {
    void guardar();
    void cargar();
}

// HERENCIA + ENCAPSULACIÓN: Clase padre
public abstract class Entidad implements Almacenable {
    private String id;
    private LocalDateTime fechaCreacion;
    
    // ENCAPSULACIÓN: Constructor y getters
    public Entidad(String id) {
        this.id = id;
        this.fechaCreacion = LocalDateTime.now();
    }
    
    public String getId() { return id; }
    
    // ABSTRACCIÓN: Método abstracto
    public abstract void validar();
}

// HERENCIA: Clase hija
public class Cliente extends Entidad {
    private String nombre;
    private String email;
    
    public Cliente(String id, String nombre, String email) {
        super(id);
        this.nombre = nombre;
        this.email = email;
    }
    
    // POLIMORFISMO: Sobrescritura
    @Override
    public void validar() {
        if (email == null || !email.contains("@")) {
            throw new DatoInvalidoException("Email inválido");
        }
    }
    
    @Override
    public void guardar() {
        validar();
        // Lógica de persistencia
    }
    
    @Override
    public void cargar() {
        // Lógica de carga
    }
}
```

---

## 💡 Errores Comunes a Evitar

### ❌ Romper Encapsulación
```java
// MAL
public List<Cliente> getClientes() {
    return clientes; // Expone colección interna
}

// BIEN
public List<Cliente> getClientes() {
    return new ArrayList<>(clientes); // Retorna copia
}
```

### ❌ Herencia Forzada
```java
// MAL: No tiene sentido lógico
public class Empleado extends ArrayList<String> { }

// BIEN: Composición
public class Empleado {
    private List<String> habilidades = new ArrayList<>();
}
```

### ❌ No Usar @Override
```java
// MAL: Typo no detectado
public void mostarInfo() { } // Debería ser mostrarInfo()

// BIEN
@Override
public void mostrarInfo() { } // Compilador verifica
```

---

## 🎯 Aplicación en el Proyecto Final

1. **Encapsulación**: Todas tus entidades deben tener atributos privados
2. **Herencia**: Al menos una jerarquía (Usuario → Admin, Cliente)
3. **Polimorfismo**: Sobrecarga de constructores, sobrescritura de métodos
4. **Abstracción**: Interface o clase abstracta para contratos comunes

Ver diagrama: [`0-assets/1-integracion-poo.svg`](../0-assets/1-integracion-poo.svg)

---

**Próximo tema**: [Patrones de Diseño Básicos](02-patrones-diseno-basicos.md)
