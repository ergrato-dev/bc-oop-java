# Ejercicios Semanales - Semana 05: Polimorfismo

## 🎯 Objetivo

Aplicar **sobrecarga** y **sobrescritura** de métodos para implementar polimorfismo en tu sistema.

**RECUERDA:** Continúas con tu dominio. Mejoras el código de la Semana 04 agregando polimorfismo.

---

## 📊 Ejercicios (100 puntos)

### **Ejercicio 1: Sobrecarga de Métodos (25 puntos)**

Implementa **sobrecarga** (overloading) en una o más clases.

**Requisitos:**
- Mínimo **2 métodos con el mismo nombre** pero diferentes parámetros
- Deben estar en clases lógicas (no forzados)
- Ejemplo: búsqueda por código, por nombre, por rango de fechas

**Ejemplo (Agencia de Viajes):**
```java
public class AgenciaViajes {
    private ArrayList<Reserva> reservas;
    
    // Sobrecarga: buscar por código
    public Reserva buscarReserva(String codigo) {
        for (Reserva r : reservas) {
            if (r.getCodigo().equals(codigo)) {
                return r;
            }
        }
        return null;
    }
    
    // Sobrecarga: buscar por cliente
    public ArrayList<Reserva> buscarReserva(Cliente cliente) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getCliente().equals(cliente)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
    
    // Sobrecarga: buscar por rango de fechas
    public ArrayList<Reserva> buscarReserva(LocalDate inicio, LocalDate fin) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            LocalDate fecha = r.getFecha();
            if (fecha.isAfter(inicio) && fecha.isBefore(fin)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
}
```

**Otros ejemplos de sobrecarga:**
```java
// Restaurante: agregar platillo
public void agregarPlatillo(String nombre, double precio);
public void agregarPlatillo(String nombre, double precio, String categoria);

// Biblioteca: buscar material
public Material buscar(String codigo);
public ArrayList<Material> buscar(String campo, String valor);

// Tienda: aplicar descuento
public double aplicarDescuento(double monto);
public double aplicarDescuento(double monto, int porcentaje);
public double aplicarDescuento(Cliente cliente, double monto);  // descuento VIP
```

---

### **Ejercicio 2: Sobrescritura de Métodos con @Override (25 puntos)**

Sobrescribe métodos de la clase padre en las subclases.

**Requisitos:**
- Usa `@Override` correctamente
- Modifica el comportamiento según la subclase
- Mínimo **2 métodos sobrescritos** en diferentes subclases

**Ejemplo (Empleados):**
```java
public class Empleado {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;
    
    // Constructor
    public Empleado(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }
    
    // Método base
    public double calcularSalario() {
        return salarioBase;
    }
    
    // Método base
    public String obtenerDescripcion() {
        return "Empleado: " + nombre;
    }
    
    // Getters...
}

public class EmpleadoPlanta extends Empleado {
    private int antiguedad;  // años
    
    public EmpleadoPlanta(String nombre, String identificacion, 
                          double salarioBase, int antiguedad) {
        super(nombre, identificacion, salarioBase);
        this.antiguedad = antiguedad;
    }
    
    @Override
    public double calcularSalario() {
        // Sobrescribe: bono por antigüedad
        double bono = salarioBase * (antiguedad * 0.05);  // 5% por año
        return salarioBase + bono;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Empleado de Planta: " + nombre + " (" + antiguedad + " años)";
    }
    
    // Getter
    public int getAntiguedad() { return antiguedad; }
}

public class EmpleadoContrato extends Empleado {
    private LocalDate fechaFinContrato;
    
    public EmpleadoContrato(String nombre, String identificacion, 
                           double salarioBase, LocalDate fechaFinContrato) {
        super(nombre, identificacion, salarioBase);
        this.fechaFinContrato = fechaFinContrato;
    }
    
    @Override
    public double calcularSalario() {
        // Sobrescribe: sin bonos
        return salarioBase;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Empleado por Contrato: " + nombre + 
               " (hasta " + fechaFinContrato + ")";
    }
    
    // Getter
    public LocalDate getFechaFinContrato() { return fechaFinContrato; }
}
```

**Otros ejemplos de sobrescritura:**
```java
// Agencia: ServicioTuristico
@Override
public double calcularCosto();  // Vuelo: precio base, Hotel: precio/noche, Tour: precio/persona

// Restaurante: Platillo
@Override
public int calcularTiempoPreparacion();  // Entrada: 10 min, Plato fuerte: 30 min

// Biblioteca: Material
@Override
public double calcularMulta(int diasRetraso);  // Libro: $5/día, DVD: $10/día
```

---

### **Ejercicio 3: Métodos Polimórficos (25 puntos)**

Crea métodos que acepten la clase **padre** y funcionen con cualquier **subclase**.

**Requisitos:**
- Métodos que aceptan clase padre como parámetro
- Funcionalidad que usa polimorfismo
- Demostración de **dynamic binding** (enlace dinámico)

**Ejemplo (Sistema de RH):**
```java
public class SistemaRH {
    private ArrayList<Empleado> empleados;
    
    public SistemaRH() {
        this.empleados = new ArrayList<>();
    }
    
    // Método polimórfico: acepta cualquier Empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.obtenerDescripcion());
    }
    
    // Método polimórfico: procesa nómina
    public void procesarNomina(Empleado empleado) {
        double salario = empleado.calcularSalario();  // Polimorfismo
        System.out.println("Procesando pago para: " + empleado.getNombre());
        System.out.println("Salario: $" + salario);
    }
    
    // Método polimórfico: procesa todos
    public void procesarNominaCompleta() {
        System.out.println("\n=== NÓMINA MENSUAL ===");
        double total = 0;
        for (Empleado emp : empleados) {
            procesarNomina(emp);  // Funciona con EmpleadoPlanta y EmpleadoContrato
            total += emp.calcularSalario();
            System.out.println("---");
        }
        System.out.println("TOTAL: $" + total);
    }
    
    // Método polimórfico: genera reporte
    public void generarReporte() {
        System.out.println("\n=== REPORTE DE EMPLEADOS ===");
        for (Empleado emp : empleados) {
            System.out.println(emp.obtenerDescripcion());  // Polimorfismo
            System.out.println("Salario: $" + emp.calcularSalario());
        }
    }
}
```

**Otros ejemplos de métodos polimórficos:**
```java
// Agencia: procesar servicios
public void facturar(ServicioTuristico servicio) {
    double costo = servicio.calcularCosto();  // Polimorfismo
    System.out.println("Factura: $" + costo);
}

// Restaurante: cocinar platillos
public void preparar(Platillo platillo) {
    int tiempo = platillo.calcularTiempoPreparacion();  // Polimorfismo
    System.out.println("Preparando " + platillo.getNombre() + " (" + tiempo + " min)");
}

// Biblioteca: calcular multas
public double aplicarMulta(Material material, int dias) {
    return material.calcularMulta(dias);  // Polimorfismo
}
```

---

### **Ejercicio 4: Demostración Completa en Main (25 puntos)**

Crea un `Main.java` que demuestre polimorfismo en acción.

**Requisitos:**
- Usa **ArrayList polimórfico** (almacena objetos de tipo padre)
- Demuestra **dynamic binding** (llamada a métodos sobrescritos)
- Incluye bucles que recorren la colección

**Ejemplo Completo:**
```java
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Crear sistema de RH
        SistemaRH sistema = new SistemaRH();
        
        // 2. Crear empleados de diferentes tipos
        EmpleadoPlanta emp1 = new EmpleadoPlanta(
            "Ana García", "E001", 3000000, 5
        );
        
        EmpleadoContrato emp2 = new EmpleadoContrato(
            "Carlos Pérez", "E002", 2500000, 
            LocalDate.of(2024, 12, 31)
        );
        
        EmpleadoPlanta emp3 = new EmpleadoPlanta(
            "María López", "E003", 3500000, 10
        );
        
        // 3. Agregar empleados (método polimórfico)
        sistema.agregarEmpleado(emp1);
        sistema.agregarEmpleado(emp2);  // Diferentes subclases
        sistema.agregarEmpleado(emp3);
        
        // 4. Procesar nómina completa (polimorfismo)
        sistema.procesarNominaCompleta();
        
        // 5. Generar reporte (polimorfismo)
        sistema.generarReporte();
        
        // 6. Demostración de ArrayList polimórfico
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(emp1);
        empleados.add(emp2);  // Mismo ArrayList para diferentes subclases
        empleados.add(emp3);
        
        System.out.println("\n=== DEMOSTRACIÓN POLIMORFISMO ===");
        for (Empleado e : empleados) {
            System.out.println(e.obtenerDescripcion());  // Dynamic binding
            System.out.println("Salario: $" + e.calcularSalario());  // Dynamic binding
            System.out.println("Tipo real: " + e.getClass().getSimpleName());
            System.out.println("---");
        }
        
        // 7. Demostración de sobrecarga
        AgenciaViajes agencia = new AgenciaViajes();
        
        System.out.println("\n=== DEMOSTRACIÓN SOBRECARGA ===");
        // Buscar por código
        Reserva r1 = agencia.buscarReserva("R001");
        
        // Buscar por cliente
        Cliente cliente = new Cliente("Juan", "juan@mail.com");
        ArrayList<Reserva> r2 = agencia.buscarReserva(cliente);
        
        // Buscar por rango de fechas
        ArrayList<Reserva> r3 = agencia.buscarReserva(
            LocalDate.now(), 
            LocalDate.now().plusDays(30)
        );
    }
}
```

---

## 📄 Documento POLIMORFISMO.md

Crea un archivo `POLIMORFISMO.md` con:

### 1. Sobrecarga (Overloading)
- **Métodos**: Lista de métodos sobrecargados
- **Justificación**: Por qué tiene sentido en tu dominio

### 2. Sobrescritura (Overriding)
- **Métodos**: Lista de métodos sobrescritos con `@Override`
- **Tabla comparativa**:

| Método | Clase Padre | Subclase 1 | Subclase 2 |
|--------|-------------|------------|------------|
| `calcularSalario()` | return salarioBase | return salarioBase + bono | return salarioBase |

### 3. Polimorfismo Dinámico
- **Ejemplo**: Código que demuestra dynamic binding
- **Explicación**: Cómo funciona en tu sistema

### 4. Beneficios
- ¿Qué ventajas obtienes con polimorfismo?
- ¿Qué sería difícil sin polimorfismo?

---

## 🎯 Criterios de Evaluación

### Ejercicio 1: Sobrecarga (25 puntos)
- ✅ Mínimo 2 métodos sobrecargados (10 pts)
- ✅ Diferentes tipos/cantidades de parámetros (10 pts)
- ✅ Lógica coherente con el dominio (5 pts)

### Ejercicio 2: Sobrescritura (25 puntos)
- ✅ Uso correcto de @Override (10 pts)
- ✅ Comportamiento diferente por subclase (10 pts)
- ✅ Mínimo 2 métodos sobrescritos (5 pts)

### Ejercicio 3: Métodos Polimórficos (25 puntos)
- ✅ Métodos que aceptan clase padre (10 pts)
- ✅ Funciona con cualquier subclase (10 pts)
- ✅ Demostración de dynamic binding (5 pts)

### Ejercicio 4: Main Completo (25 puntos)
- ✅ ArrayList polimórfico (10 pts)
- ✅ Bucle recorriendo objetos polimórficos (10 pts)
- ✅ Salida clara demostrando polimorfismo (5 pts)

---

## 📊 Ejemplo de Salida Esperada

```
Empleado agregado: Empleado de Planta: Ana García (5 años)
Empleado agregado: Empleado por Contrato: Carlos Pérez (hasta 2024-12-31)
Empleado agregado: Empleado de Planta: María López (10 años)

=== NÓMINA MENSUAL ===
Procesando pago para: Ana García
Salario: $3750000.0
---
Procesando pago para: Carlos Pérez
Salario: $2500000.0
---
Procesando pago para: María López
Salario: $5250000.0
---
TOTAL: $11500000.0

=== REPORTE DE EMPLEADOS ===
Empleado de Planta: Ana García (5 años)
Salario: $3750000.0
Empleado por Contrato: Carlos Pérez (hasta 2024-12-31)
Salario: $2500000.0
Empleado de Planta: María López (10 años)
Salario: $5250000.0

=== DEMOSTRACIÓN POLIMORFISMO ===
Empleado de Planta: Ana García (5 años)
Salario: $3750000.0
Tipo real: EmpleadoPlanta
---
Empleado por Contrato: Carlos Pérez (hasta 2024-12-31)
Salario: $2500000.0
Tipo real: EmpleadoContrato
---
Empleado de Planta: María López (10 años)
Salario: $5250000.0
Tipo real: EmpleadoPlanta
---
```

---

**¡El polimorfismo permite código flexible y extensible!** 🚀
