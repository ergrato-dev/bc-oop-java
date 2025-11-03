# Ejercicios Semanales - Semana 06: Abstracción e Interfaces

## 📋 Información General

**Semana:** 06 - Abstracción e Interfaces  
**Puntuación Total:** 100 puntos  
**Peso en la Evaluación:** 40% (Producto) de la nota semanal  
**Modalidad:** Individual  
**Entrega:** Repositorio GitHub personal

---

## 🎯 Objetivo General

Refactorizar y expandir tu sistema del dominio asignado aplicando **abstracción mediante clases abstractas e interfaces**, mejorando el diseño y aplicando principios SOLID.

---

## ⚠️ IMPORTANTE: Continuidad del Proyecto

**NO inicias un proyecto nuevo.**  
**Continúas trabajando con el MISMO dominio asignado en Semana 01.**

### Progresión de tu Proyecto

```
Semana 01 → Clases básicas con atributos y métodos
Semana 02 → Más objetos y relaciones
Semana 03 → Encapsulación y constructores
Semana 04 → Herencia y jerarquías
Semana 05 → Polimorfismo (sobrecarga/sobrescritura)
Semana 06 → Abstracción (clases abstractas + interfaces) ⬅️ ESTÁS AQUÍ
```

---

## 📦 Estructura de Entrega

Tu repositorio debe seguir esta estructura acumulativa:

```
bc-oop-java-[ficha]-[apellido]/
├── README.md (actualizado con descripción de semana 06)
├── semana-01/
├── semana-02/
├── semana-03/
├── semana-04/
├── semana-05/
└── semana-06/                              ⬅️ NUEVA CARPETA
    ├── README.md                           (Descripción de cambios)
    ├── abstractas/                         (Clases abstractas)
    │   ├── [TuClaseAbstracta1].java
    │   └── [TuClaseAbstracta2].java (opcional)
    ├── interfaces/                         (Interfaces)
    │   ├── [Interface1].java
    │   ├── [Interface2].java
    │   └── [Interface3].java (opcional)
    ├── implementaciones/                   (Clases concretas)
    │   ├── [ClaseConcreta1].java
    │   ├── [ClaseConcreta2].java
    │   └── [ClaseConcreta3].java
    ├── Main.java                           (Programa de demostración)
    ├── ANALISIS.md                         (Documento de diseño)
    └── diagramas/                          (Opcional)
        └── jerarquia.png/jpg
```

---

## 📝 Ejercicios Obligatorios

### Ejercicio 1: Crear Clase Abstracta (25 puntos)

#### 📌 Descripción

Identifica en tu dominio una clase que represente un concepto general con comportamiento común pero implementación variable. Conviértela en una **clase abstracta**.

#### ✅ Requisitos Técnicos

1. **Clase abstracta con:**
   - Palabra clave `abstract class`
   - Mínimo 2 atributos protegidos (`protected`)
   - Constructor que inicialice los atributos
   - Al menos 1 método abstracto
   - Al menos 1 método concreto (con implementación)

2. **Mínimo 2 subclases concretas que:**
   - Extiendan la clase abstracta con `extends`
   - Implementen TODOS los métodos abstractos
   - Usen `@Override` correctamente
   - Llamen al constructor padre con `super()`

#### 💡 Ejemplos por Dominio

<details>
<summary><strong>Agencia de Viajes</strong></summary>

```java
// Clase abstracta
public abstract class ServicioTuristico {
    protected String nombre;
    protected double precio;
    protected String proveedor;
    
    public ServicioTuristico(String nombre, double precio, String proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
    }
    
    // Método abstracto: cada servicio calcula costo diferente
    public abstract double calcularCostoTotal();
    
    // Método abstracto: cada servicio tiene descripción diferente
    public abstract String obtenerDescripcion();
    
    // Método concreto: común a todos los servicios
    public void mostrarInformacion() {
        System.out.println("=== " + nombre + " ===");
        System.out.println("Proveedor: " + proveedor);
        System.out.println("Costo: $" + calcularCostoTotal());
    }
}

// Subclase concreta 1
public class Vuelo extends ServicioTuristico {
    private String origen;
    private String destino;
    private int numeroEscalas;
    
    public Vuelo(String nombre, double precio, String aerolinea, 
                 String origen, String destino, int numeroEscalas) {
        super(nombre, precio, aerolinea);
        this.origen = origen;
        this.destino = destino;
        this.numeroEscalas = numeroEscalas;
    }
    
    @Override
    public double calcularCostoTotal() {
        // Costo base + impuestos 19% + cargo por escalas
        double impuestos = precio * 0.19;
        double cargoEscalas = numeroEscalas * 50000;
        return precio + impuestos + cargoEscalas;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Vuelo de " + origen + " a " + destino + 
               " con " + numeroEscalas + " escala(s)";
    }
}

// Subclase concreta 2
public class Hotel extends ServicioTuristico {
    private String ciudad;
    private int numeroNoches;
    private int estrellas;
    
    public Hotel(String nombre, double precioPorNoche, String cadena,
                 String ciudad, int numeroNoches, int estrellas) {
        super(nombre, precioPorNoche, cadena);
        this.ciudad = ciudad;
        this.numeroNoches = numeroNoches;
        this.estrellas = estrellas;
    }
    
    @Override
    public double calcularCostoTotal() {
        // Precio por noche * número de noches + IVA
        double subtotal = precio * numeroNoches;
        double iva = subtotal * 0.19;
        return subtotal + iva;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Hotel " + estrellas + " estrellas en " + ciudad + 
               " por " + numeroNoches + " noche(s)";
    }
}
```
</details>

<details>
<summary><strong>Restaurante</strong></summary>

```java
public abstract class Platillo {
    protected String nombre;
    protected double precioBase;
    protected String categoria;
    
    public Platillo(String nombre, double precioBase, String categoria) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }
    
    public abstract double calcularPrecioFinal();
    public abstract int obtenerTiempoPreparacion();
    
    public void mostrarInfo() {
        System.out.println(nombre + " - $" + calcularPrecioFinal());
    }
}

public class PlatilloCaliente extends Platillo {
    private String temperatura;
    private boolean esGourmet;
    
    // Constructor, métodos @Override...
}

public class Postre extends Platillo {
    private boolean esFrio;
    private int calorias;
    
    // Constructor, métodos @Override...
}
```
</details>

<details>
<summary><strong>Biblioteca</strong></summary>

```java
public abstract class Material {
    protected String titulo;
    protected String codigo;
    protected boolean disponible;
    
    public Material(String titulo, String codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.disponible = true;
    }
    
    public abstract int calcularDiasPrestamo();
    public abstract double calcularMultaPorDia();
    
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println(titulo + " prestado exitosamente");
        }
    }
}

public class Libro extends Material { /* ... */ }
public class Revista extends Material { /* ... */ }
public class DVD extends Material { /* ... */ }
```
</details>

#### 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| Identificación correcta | 5 | La abstracción es apropiada para el dominio |
| Métodos abstractos | 8 | Al menos 1 método abstracto bien definido |
| Métodos concretos | 5 | Al menos 1 método concreto reutilizable |
| Subclases | 5 | Mínimo 2 subclases correctamente implementadas |
| Uso de `super()` | 2 | Constructores usan `super()` apropiadamente |

---

### Ejercicio 2: Crear Interfaces (25 puntos)

#### 📌 Descripción

Define al menos **2 interfaces** que representen capacidades o comportamientos que pueden ser compartidos por clases no relacionadas jerárquicamente en tu dominio.

#### ✅ Requisitos Técnicos

1. **Mínimo 2 interfaces diferentes:**
   - Palabra clave `interface`
   - Nombres descriptivos (capacidad/comportamiento)
   - 2-4 métodos por interface
   - Sin atributos de instancia (solo constantes si necesario)

2. **Implementación:**
   - Al menos 1 clase debe implementar múltiples interfaces
   - Todas las clases deben implementar TODOS los métodos
   - Métodos `public` en implementaciones
   - Uso de `@Override`

#### 💡 Ejemplos por Dominio

<details>
<summary><strong>Agencia de Viajes</strong></summary>

```java
// Interface 1: Capacidad de ser reservado
public interface Reservable {
    boolean verificarDisponibilidad(String fecha);
    void realizarReserva(String cliente, String fecha);
    void cancelarReserva(String codigoReserva);
    String obtenerCodigoReserva();
}

// Interface 2: Capacidad de ser calificado
public interface Calificable {
    void agregarCalificacion(int estrellas, String comentario);
    double obtenerPromedioCalificaciones();
    int obtenerNumeroCalificaciones();
}

// Interface 3: Capacidad de tener descuentos
public interface Descuentable {
    double aplicarDescuento(double porcentaje);
    boolean esElegibleDescuento();
}

// Clase que implementa múltiples interfaces
public class PaqueteTuristico implements Reservable, Calificable, Descuentable {
    private String nombre;
    private double precio;
    private List<String> reservas;
    private List<Integer> calificaciones;
    
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        // Implementación
        return true;
    }
    
    @Override
    public void realizarReserva(String cliente, String fecha) {
        // Implementación
    }
    
    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        calificaciones.add(estrellas);
    }
    
    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        int suma = calificaciones.stream().mapToInt(Integer::intValue).sum();
        return (double) suma / calificaciones.size();
    }
    
    @Override
    public double aplicarDescuento(double porcentaje) {
        return precio - (precio * porcentaje / 100);
    }
    
    // Implementar resto de métodos...
}
```
</details>

<details>
<summary><strong>Restaurante</strong></summary>

```java
public interface Preparable {
    void iniciarPreparacion();
    void finalizarPreparacion();
    int obtenerTiempoEstimado();
}

public interface Entregable {
    void prepararParaEntrega();
    boolean estaListoParaEntregar();
    String obtenerDireccionEntrega();
}

public interface Facturable {
    double calcularSubtotal();
    double calcularImpuestos();
    double calcularTotal();
    String generarFactura();
}

public class Pedido implements Preparable, Entregable, Facturable {
    // Implementación de todos los métodos...
}
```
</details>

<details>
<summary><strong>Tienda Online</strong></summary>

```java
public interface Vendible {
    double obtenerPrecio();
    boolean verificarStock();
    void reducirStock(int cantidad);
}

public interface Enviabl {
    double calcularCostoEnvio(String destino);
    int obtenerDiasEntrega(String destino);
    String obtenerNumeroRastreo();
}

public interface Retornable {
    boolean esRetornable();
    int obtenerDiasGarantia();
    double calcularCostoDevolucion();
}

public class ProductoFisico implements Vendible, Enviabl, Retornable {
    // Implementación completa...
}
```
</details>

#### 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| Número de interfaces | 5 | Mínimo 2 interfaces diferentes |
| Nombres apropiados | 5 | Nombres descriptivos de capacidades |
| Métodos coherentes | 8 | Métodos relacionados con la capacidad |
| Implementación múltiple | 5 | Al menos 1 clase con múltiples interfaces |
| Código sin errores | 2 | Compila y ejecuta correctamente |

---

### Ejercicio 3: Programa de Demostración (25 puntos)

#### 📌 Descripción

Crea un programa `Main.java` que demuestre el uso de abstracción, polimorfismo y las interfaces implementadas.

#### ✅ Requisitos Técnicos

1. **Demostrar polimorfismo con clase abstracta:**
   - Array/List de tipo abstracto
   - Almacenar diferentes subclases concretas
   - Invocar métodos polimórficos

2. **Demostrar interfaces:**
   - Usar referencias de tipo interface
   - Demostrar múltiple implementación
   - Invocar métodos de diferentes interfaces

3. **Salida clara:**
   - Imprimir información organizada
   - Mostrar resultados de métodos
   - Usar separadores visuales

#### 💡 Ejemplo Completo

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE AGENCIA DE VIAJES ===\n");
        
        // 1. Polimorfismo con clase abstracta
        System.out.println("--- Servicios Disponibles ---");
        ServicioTuristico[] servicios = new ServicioTuristico[3];
        
        servicios[0] = new Vuelo("Vuelo BOG-MDE", 250000, "Avianca", 
                                 "Bogotá", "Medellín", 0);
        servicios[1] = new Hotel("Hotel Dann Carlton", 180000, "Dann", 
                                 "Cartagena", 3, 5);
        servicios[2] = new Tour("City Tour", 120000, "Tours Colombia",
                               "Bogotá", 8);
        
        // Invocar método polimórfico
        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println("Descripción: " + servicio.obtenerDescripcion());
            System.out.println("Costo Total: $" + servicio.calcularCostoTotal());
            System.out.println();
        }
        
        // 2. Demostrar interfaces
        System.out.println("--- Gestión de Reservas ---");
        
        // Usar referencia de tipo interface
        Reservable servicioReservable = new PaqueteTuristico(
            "Paquete Caribe", 1500000, 5);
        
        if (servicioReservable.verificarDisponibilidad("2025-12-15")) {
            servicioReservable.realizarReserva("Juan Pérez", "2025-12-15");
            System.out.println("Reserva exitosa. Código: " + 
                             servicioReservable.obtenerCodigoReserva());
        }
        
        // 3. Múltiple implementación
        System.out.println("\n--- Calificaciones ---");
        
        PaqueteTuristico paquete = new PaqueteTuristico(
            "Paquete Eje Cafetero", 800000, 3);
        
        // Usar como Calificable
        Calificable servicionCalificable = paquete;
        servicionCalificable.agregarCalificacion(5, "Excelente");
        servicionCalificable.agregarCalificacion(4, "Muy bueno");
        
        System.out.println("Promedio: " + 
                         servicionCalificable.obtenerPromedioCalificaciones() + 
                         " estrellas");
        
        // Usar como Descuentable
        Descuentable servicioDescuentable = paquete;
        if (servicioDescuentable.esElegibleDescuento()) {
            double precioConDescuento = servicioDescuentable.aplicarDescuento(15);
            System.out.println("Precio con descuento (15%): $" + 
                             precioConDescuento);
        }
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}
```

#### 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| Polimorfismo con abstracta | 10 | Array/List de tipo abstracto usado correctamente |
| Uso de interfaces | 8 | Referencias de tipo interface demostradas |
| Variedad de casos | 5 | Diferentes escenarios probados |
| Salida clara | 2 | Información bien presentada |

---

### Ejercicio 4: Documento de Análisis (25 puntos)

#### 📌 Descripción

Crea un archivo `ANALISIS.md` que explique tus decisiones de diseño y la aplicación de principios de POO.

#### ✅ Contenido Requerido

```markdown
# Análisis de Diseño - Semana 06: [Tu Dominio]

## 1. Identificación de Abstracciones

### Clase(s) Abstracta(s)
**Nombre:** [NombreClaseAbstracta]

**¿Por qué es abstracta?**
- [Explica por qué elegiste hacer esta clase abstracta]
- [Qué comportamiento común tiene]
- [Qué comportamiento varía en las subclases]

**Jerarquía:**
```
[ClaseAbstracta]
├── [SubclaseConcreta1]
├── [SubclaseConcreta2]
└── [SubclaseConcreta3]
```

## 2. Interfaces Implementadas

### Interface 1: [NombreInterface]
**Capacidad que define:** [Descripción]

**Clases que la implementan:**
- [Clase1]: [Por qué tiene sentido que implemente esta interface]
- [Clase2]: [Por qué tiene sentido que implemente esta interface]

### Interface 2: [NombreInterface]
[Similar al anterior]

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

**Elegí clase abstracta para [X] porque:**
- Hay relación "es-un" clara
- Necesitaba compartir estado (atributos)
- Había comportamiento común implementable

**Elegí interface para [Y] porque:**
- Define una capacidad independiente de jerarquía
- Necesitaba múltiple implementación
- Solo define contrato, no implementación

## 4. Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
[Explica cómo cada clase tiene una sola responsabilidad]

### Open/Closed Principle (OCP)
[Explica cómo tu diseño está abierto a extensión pero cerrado a modificación]

### Liskov Substitution Principle (LSP)
[Explica cómo las subclases pueden sustituir a la clase abstracta]

### Interface Segregation Principle (ISP)
[Explica cómo tus interfaces son específicas y no obligan a implementar métodos innecesarios]

### Dependency Inversion Principle (DIP)
[Si aplica, explica cómo dependes de abstracciones]

## 5. Mejoras Logradas

**Antes (Semana 05):**
- [Describe cómo estaba tu código]
- [Qué problemas tenía]

**Después (Semana 06):**
- [Describe cómo está ahora]
- [Qué mejoras lograste]
- [Qué ventajas tiene el nuevo diseño]

## 6. Diagrama de Clases

[Incluye un diagrama simple en texto o imagen]

```
        <<abstract>>
      ServicioTuristico
           |
    +------+------+
    |             |
  Vuelo         Hotel
    |
    +-- implements Reservable
    +-- implements Calificable
```

## 7. Desafíos y Soluciones

**Desafío 1:** [Describe un problema que enfrentaste]
**Solución:** [Cómo lo resolviste]

**Desafío 2:** [Otro desafío]
**Solución:** [Su solución]

## 8. Próximos Pasos

[Qué podrías mejorar o agregar en el futuro]
```

#### 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| Explicación de abstracciones | 8 | Justifica por qué eligió cada abstracción |
| Clase abstracta vs interface | 8 | Explica claramente las diferencias aplicadas |
| Principios SOLID | 6 | Identifica y explica al menos 2 principios |
| Claridad y organización | 3 | Documento bien estructurado y redactado |

---

## 📊 Resumen de Puntuación

| Ejercicio | Puntos | Descripción |
|-----------|--------|-------------|
| 1. Clase Abstracta | 25 | Jerarquía con clase abstracta y subclases |
| 2. Interfaces | 25 | Mínimo 2 interfaces implementadas |
| 3. Main de Demostración | 25 | Programa que demuestra todo |
| 4. Documento de Análisis | 25 | ANALISIS.md completo |
| **TOTAL** | **100** | |

---

## ✅ Checklist de Verificación

Antes de hacer tu commit final, verifica:

### Código
- [ ] Creé al menos 1 clase abstracta relevante
- [ ] Creé al menos 2 interfaces diferentes
- [ ] Mínimo 2 subclases concretas de la clase abstracta
- [ ] Al menos 1 clase implementa múltiples interfaces
- [ ] Usé `@Override` en todos los métodos sobrescritos
- [ ] Todo el código compila sin errores
- [ ] El programa `Main.java` ejecuta correctamente

### Documentación
- [ ] README.md de semana-06 está completo
- [ ] ANALISIS.md explica todas las decisiones de diseño
- [ ] Incluí justificación de abstracta vs interface
- [ ] Identifiqué principios SOLID aplicados

### Repositorio
- [ ] Commit con mensaje descriptivo
- [ ] Push a GitHub exitoso
- [ ] Estructura de carpetas correcta
- [ ] Todos los archivos .java están en las carpetas apropiadas

---

## 📅 Fecha de Entrega

**Fecha límite:** [Definida por el instructor]  
**Hora límite:** 23:59 hora de Colombia

**Entrega:**
- URL del repositorio GitHub
- Asegúrate que sea público o que el instructor tenga acceso

---

## 📞 Soporte

**¿Tienes dudas?**
- Consulta la teoría en `/bootcamp/semana-06/1-teoria/`
- Revisa ejemplos en `/bootcamp/semana-06/2-practica/`
- Consulta errores comunes en `/bootcamp/semana-06/3-recursos/errores-comunes.md`
- Pregunta en GitHub Discussions
- Consulta al instructor en clase

---

## 🏆 Consejos para Obtener Máxima Puntuación

1. **Lee toda la teoría antes de empezar**
2. **Planifica tu diseño en papel primero**
3. **Pregúntate: ¿clase abstracta o interface?** para cada caso
4. **Aplica al menos 2-3 principios SOLID conscientemente**
5. **Documenta tus decisiones mientras codificas**
6. **Prueba tu código constantemente**
7. **Revisa el checklist antes de entregar**

---

**¡Éxito en tu semana de abstracción e interfaces! 🚀**
