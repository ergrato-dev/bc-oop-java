# 05 - Diseño con Abstracción

## 🎯 Objetivos

Al finalizar este tema, serás capaz de:
- Aplicar principios SOLID usando abstracción
- Reconocer patrones de diseño basados en abstracción
- Refactorizar código hacia mejor abstracción
- Diseñar sistemas extensibles y mantenibles

---

## 🏗️ Principios SOLID con Abstracción

### 1. **S** - Single Responsibility Principle (Responsabilidad Única)

Cada clase debe tener una única razón para cambiar.

**❌ Problema: Múltiples Responsabilidades**
```java
class Empleado {
    private String nombre;
    private double salario;
    
    // Responsabilidad 1: Gestión de datos
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    // Responsabilidad 2: Cálculos
    public double calcularSalarioAnual() {
        return salario * 12;
    }
    
    // Responsabilidad 3: Persistencia
    public void guardarEnBaseDatos() {
        // Código de BD
    }
    
    // Responsabilidad 4: Presentación
    public void imprimirReporte() {
        System.out.println("Empleado: " + nombre);
    }
}
```

**✅ Solución: Separar Responsabilidades**
```java
// Responsabilidad única: Datos del empleado
class Empleado {
    private String nombre;
    private double salario;
    
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
    
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
}

// Responsabilidad única: Cálculos
class CalculadoraSalario {
    public double calcularAnual(Empleado emp) {
        return emp.getSalario() * 12;
    }
    
    public double calcularQuincenal(Empleado emp) {
        return emp.getSalario() / 2;
    }
}

// Responsabilidad única: Persistencia
interface RepositorioEmpleado {
    void guardar(Empleado emp);
    Empleado buscar(String nombre);
}

// Responsabilidad única: Presentación
class GeneradorReportes {
    public void generarReporte(Empleado emp) {
        System.out.println("=== REPORTE ===");
        System.out.println("Empleado: " + emp.getNombre());
        System.out.println("Salario: " + emp.getSalario());
    }
}
```

### 2. **O** - Open/Closed Principle (Abierto/Cerrado)

Abierto a extensión, cerrado a modificación.

**❌ Problema: Modificar Código Existente**
```java
class CalculadoraDescuento {
    public double calcular(String tipoCliente, double monto) {
        if (tipoCliente.equals("REGULAR")) {
            return monto * 0.95; // 5%
        } else if (tipoCliente.equals("VIP")) {
            return monto * 0.90; // 10%
        } else if (tipoCliente.equals("PREMIUM")) {
            return monto * 0.80; // 20%
        }
        return monto;
    }
    // Cada nuevo tipo requiere modificar este método
}
```

**✅ Solución: Abstracción y Polimorfismo**
```java
// Cerrado a modificación
interface EstrategiaDescuento {
    double aplicarDescuento(double monto);
}

// Abierto a extensión
class DescuentoRegular implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.95; // 5%
    }
}

class DescuentoVIP implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.90; // 10%
    }
}

class DescuentoPremium implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.80; // 20%
    }
}

// Nuevo tipo sin modificar código existente
class DescuentoEmpleado implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.70; // 30%
    }
}

class CalculadoraDescuento {
    public double calcular(EstrategiaDescuento estrategia, double monto) {
        return estrategia.aplicarDescuento(monto);
    }
}
```

### 3. **L** - Liskov Substitution Principle (Sustitución de Liskov)

Los objetos deben poder reemplazarse por instancias de sus subtipos sin alterar el funcionamiento.

**❌ Violación del Principio**
```java
class Ave {
    public void volar() {
        System.out.println("Volando...");
    }
}

class Pinguino extends Ave {
    @Override
    public void volar() {
        throw new UnsupportedOperationException("Los pingüinos no vuelan");
    }
}

// Problema: Pinguino NO puede sustituir a Ave
void hacerVolarAve(Ave ave) {
    ave.volar(); // Falla con Pinguino
}
```

**✅ Solución: Mejor Abstracción**
```java
abstract class Ave {
    protected String nombre;
    
    public abstract void moverse();
}

class AveVoladora extends Ave {
    @Override
    public void moverse() {
        System.out.println("Volando...");
    }
}

class Pinguino extends Ave {
    @Override
    public void moverse() {
        System.out.println("Nadando...");
    }
}

// Ahora todas las aves pueden sustituirse correctamente
void moverAve(Ave ave) {
    ave.moverse(); // Funciona para todas
}
```

### 4. **I** - Interface Segregation Principle (Segregación de Interfaces)

Muchas interfaces específicas son mejores que una interfaz general.

**❌ Interfaz Monolítica**
```java
interface Trabajador {
    void trabajar();
    void comer();
    void cobrarSalario();
    void pedirVacaciones();
}

// Robot no necesita comer ni vacaciones
class Robot implements Trabajador {
    @Override
    public void trabajar() { /* OK */ }
    
    @Override
    public void comer() { 
        throw new UnsupportedOperationException(); // ❌
    }
    
    @Override
    public void cobrarSalario() { /* OK */ }
    
    @Override
    public void pedirVacaciones() {
        throw new UnsupportedOperationException(); // ❌
    }
}
```

**✅ Interfaces Segregadas**
```java
interface Trabajable {
    void trabajar();
}

interface Comestible {
    void comer();
}

interface Pagable {
    void cobrarSalario();
}

interface ConVacaciones {
    void pedirVacaciones();
}

// Robot solo implementa lo que necesita
class Robot implements Trabajable, Pagable {
    @Override
    public void trabajar() {
        System.out.println("Robot trabajando 24/7");
    }
    
    @Override
    public void cobrarSalario() {
        System.out.println("Mantenimiento pagado");
    }
}

// Humano implementa todo
class EmpleadoHumano implements Trabajable, Comestible, Pagable, ConVacaciones {
    @Override
    public void trabajar() {
        System.out.println("Trabajando 8 horas");
    }
    
    @Override
    public void comer() {
        System.out.println("Almorzando");
    }
    
    @Override
    public void cobrarSalario() {
        System.out.println("Salario depositado");
    }
    
    @Override
    public void pedirVacaciones() {
        System.out.println("Vacaciones solicitadas");
    }
}
```

### 5. **D** - Dependency Inversion Principle (Inversión de Dependencias)

Depende de abstracciones, no de concreciones.

**❌ Dependencia de Concreciones**
```java
class MySQL {
    public void guardar(String datos) {
        System.out.println("Guardando en MySQL: " + datos);
    }
}

// Fuertemente acoplado a MySQL
class ServicioUsuario {
    private MySQL baseDatos = new MySQL();
    
    public void guardarUsuario(String nombre) {
        baseDatos.guardar(nombre);
    }
    // Si cambio a PostgreSQL, debo modificar esta clase
}
```

**✅ Depender de Abstracciones**
```java
// Abstracción
interface BaseDatos {
    void guardar(String datos);
    String obtener(String id);
}

// Implementaciones concretas
class MySQL implements BaseDatos {
    @Override
    public void guardar(String datos) {
        System.out.println("Guardando en MySQL: " + datos);
    }
    
    @Override
    public String obtener(String id) {
        return "Datos de MySQL";
    }
}

class PostgreSQL implements BaseDatos {
    @Override
    public void guardar(String datos) {
        System.out.println("Guardando en PostgreSQL: " + datos);
    }
    
    @Override
    public String obtener(String id) {
        return "Datos de PostgreSQL";
    }
}

class MongoDB implements BaseDatos {
    @Override
    public void guardar(String datos) {
        System.out.println("Guardando en MongoDB: " + datos);
    }
    
    @Override
    public String obtener(String id) {
        return "Datos de MongoDB";
    }
}

// Depende de la abstracción
class ServicioUsuario {
    private BaseDatos baseDatos;
    
    // Inyección de dependencias
    public ServicioUsuario(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }
    
    public void guardarUsuario(String nombre) {
        baseDatos.guardar(nombre);
    }
}

// Uso flexible
class Main {
    public static void main(String[] args) {
        // Puedo cambiar fácilmente la implementación
        ServicioUsuario servicio1 = new ServicioUsuario(new MySQL());
        ServicioUsuario servicio2 = new ServicioUsuario(new PostgreSQL());
        ServicioUsuario servicio3 = new ServicioUsuario(new MongoDB());
    }
}
```

---

## 🎨 Patrones de Diseño con Abstracción

### 1. Strategy Pattern (Estrategia)

**Problema:** Elegir algoritmo en tiempo de ejecución

```java
// Estrategia abstracta
interface EstrategiaPago {
    void pagar(double monto);
}

// Estrategias concretas
class PagoTarjetaCredito implements EstrategiaPago {
    private String numeroTarjeta;
    
    public PagoTarjetaCredito(String numero) {
        this.numeroTarjeta = numero;
    }
    
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " con tarjeta " + numeroTarjeta);
    }
}

class PagoPSE implements EstrategiaPago {
    private String banco;
    
    public PagoPSE(String banco) {
        this.banco = banco;
    }
    
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " por PSE desde " + banco);
    }
}

class PagoEfectivo implements EstrategiaPago {
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " en efectivo");
    }
}

// Contexto
class CarritoCompras {
    private double total;
    private EstrategiaPago estrategiaPago;
    
    public void setEstrategiaPago(EstrategiaPago estrategia) {
        this.estrategiaPago = estrategia;
    }
    
    public void pagar() {
        estrategiaPago.pagar(total);
    }
}
```

### 2. Template Method Pattern (Método Plantilla)

**Problema:** Algoritmo con pasos comunes y variables

```java
abstract class ProcesamientoDocumento {
    // Método plantilla (template method)
    public final void procesar() {
        abrirDocumento();
        analizarContenido();
        generarReporte();
        cerrarDocumento();
    }
    
    // Pasos comunes
    private void abrirDocumento() {
        System.out.println("Abriendo documento...");
    }
    
    private void cerrarDocumento() {
        System.out.println("Cerrando documento...");
    }
    
    // Pasos variables (abstractos)
    protected abstract void analizarContenido();
    protected abstract void generarReporte();
}

class ProcesamientoPDF extends ProcesamientoDocumento {
    @Override
    protected void analizarContenido() {
        System.out.println("Analizando PDF con Apache PDFBox");
    }
    
    @Override
    protected void generarReporte() {
        System.out.println("Generando reporte de PDF");
    }
}

class ProcesamientoWord extends ProcesamientoDocumento {
    @Override
    protected void analizarContenido() {
        System.out.println("Analizando Word con Apache POI");
    }
    
    @Override
    protected void generarReporte() {
        System.out.println("Generando reporte de Word");
    }
}
```

### 3. Factory Method Pattern (Método Fábrica)

**Problema:** Crear objetos sin especificar clase exacta

```java
// Producto abstracto
abstract class Notificacion {
    public abstract void enviar(String mensaje);
}

// Productos concretos
class NotificacionEmail extends Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("📧 Email: " + mensaje);
    }
}

class NotificacionSMS extends Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("📱 SMS: " + mensaje);
    }
}

class NotificacionPush extends Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("🔔 Push: " + mensaje);
    }
}

// Creador abstracto
abstract class CreadorNotificacion {
    // Factory method
    public abstract Notificacion crearNotificacion();
    
    // Método que usa el factory
    public void notificar(String mensaje) {
        Notificacion notif = crearNotificacion();
        notif.enviar(mensaje);
    }
}

// Creadores concretos
class CreadorEmail extends CreadorNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionEmail();
    }
}

class CreadorSMS extends CreadorNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionSMS();
    }
}

// Uso
class Main {
    public static void main(String[] args) {
        CreadorNotificacion creador = new CreadorEmail();
        creador.notificar("Bienvenido al sistema");
        
        creador = new CreadorSMS();
        creador.notificar("Código de verificación: 1234");
    }
}
```

---

## 🔄 Refactorización hacia Abstracción

### Antes: Código Acoplado

```java
class SistemaVentas {
    public void procesarVenta(String tipoPago, double monto) {
        if (tipoPago.equals("TARJETA")) {
            System.out.println("Procesando tarjeta...");
            double comision = monto * 0.03;
            double total = monto + comision;
            System.out.println("Total con comisión: " + total);
        } else if (tipoPago.equals("PSE")) {
            System.out.println("Procesando PSE...");
            double comision = monto * 0.02;
            double total = monto + comision;
            System.out.println("Total con comisión: " + total);
        } else if (tipoPago.equals("EFECTIVO")) {
            System.out.println("Procesando efectivo...");
            System.out.println("Total: " + monto);
        }
        
        // Guardar en base de datos
        System.out.println("Guardando venta en BD...");
    }
}
```

### Después: Código con Abstracción

```java
// 1. Abstraer el método de pago
interface MetodoPago {
    double calcularTotal(double monto);
    void procesar();
}

class PagoTarjeta implements MetodoPago {
    @Override
    public double calcularTotal(double monto) {
        return monto * 1.03; // 3% comisión
    }
    
    @Override
    public void procesar() {
        System.out.println("Procesando tarjeta...");
    }
}

class PagoPSE implements MetodoPago {
    @Override
    public double calcularTotal(double monto) {
        return monto * 1.02; // 2% comisión
    }
    
    @Override
    public void procesar() {
        System.out.println("Procesando PSE...");
    }
}

class PagoEfectivo implements MetodoPago {
    @Override
    public double calcularTotal(double monto) {
        return monto; // Sin comisión
    }
    
    @Override
    public void procesar() {
        System.out.println("Procesando efectivo...");
    }
}

// 2. Abstraer la persistencia
interface RepositorioVentas {
    void guardar(Venta venta);
}

// 3. Sistema refactorizado
class SistemaVentas {
    private RepositorioVentas repositorio;
    
    public SistemaVentas(RepositorioVentas repositorio) {
        this.repositorio = repositorio;
    }
    
    public void procesarVenta(MetodoPago metodoPago, double monto) {
        metodoPago.procesar();
        double total = metodoPago.calcularTotal(monto);
        System.out.println("Total: " + total);
        
        Venta venta = new Venta(monto, total);
        repositorio.guardar(venta);
    }
}
```

**Beneficios:**
- ✅ Fácil agregar nuevos métodos de pago
- ✅ Fácil cambiar repositorio (BD, archivo, memoria)
- ✅ Código más testeable
- ✅ Responsabilidades separadas

---

## 📝 Mejores Prácticas de Diseño

### 1. Programa hacia Interfaces, no Implementaciones

```java
// ❌ Mal
ArrayList<String> lista = new ArrayList<>();

// ✅ Bien
List<String> lista = new ArrayList<>();
```

### 2. Composición sobre Herencia

```java
// ❌ Herencia rígida
class Empleado extends Persona {
    private Direccion direccion;
}

// ✅ Composición flexible
class Empleado {
    private Persona persona;
    private Direccion direccion;
}
```

### 3. Mantén las Interfaces Pequeñas

```java
// ❌ Interfaz grande
interface Servicio {
    void metodo1();
    void metodo2();
    void metodo3();
    void metodo4();
}

// ✅ Interfaces específicas
interface ServicioLectura {
    void leer();
}

interface ServicioEscritura {
    void escribir();
}
```

### 4. Usa Nombres Descriptivos

```java
// ❌ Nombres vagos
interface Cosa {
    void hacer();
}

// ✅ Nombres claros
interface Calculable {
    double calcular();
}
```

---

## 📚 Resumen

### Principios SOLID
1. **S**: Una clase, una responsabilidad
2. **O**: Extensión sin modificación
3. **L**: Subtipos sustituibles
4. **I**: Interfaces específicas
5. **D**: Depender de abstracciones

### Patrones Comunes
- **Strategy**: Intercambiar algoritmos
- **Template Method**: Plantilla con pasos variables
- **Factory Method**: Crear sin especificar clase

### Refactorización
- Identifica código duplicado
- Extrae abstracciones
- Aplica inyección de dependencias
- Separa responsabilidades

---

## 🎯 Checklist de Diseño

- [ ] ¿Cada clase tiene una sola responsabilidad?
- [ ] ¿Puedo agregar funcionalidad sin modificar código existente?
- [ ] ¿Uso interfaces en lugar de clases concretas?
- [ ] ¿Las interfaces son específicas y pequeñas?
- [ ] ¿Dependo de abstracciones, no de implementaciones?
- [ ] ¿El código es fácil de testear?
- [ ] ¿Es fácil agregar nuevas implementaciones?

---

**¡Diseña sistemas robustos y extensibles con abstracción! 🏗️**
