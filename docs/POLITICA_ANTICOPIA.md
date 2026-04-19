# Política Anticopia: Asignación de Dominios Únicos - Bootcamp POO Java

## 📋 Resumen Ejecutivo

Esta política establece un sistema de asignación de **dominios únicos y aleatorios** a cada aprendiz del bootcamp de Diseño y Programación Orientada a Objetos con Java para garantizar:

1. ✅ **Comprensión real** de los conceptos de POO (no copia-pega)
2. ✅ **Aprendizaje personalizado** contextualizado a negocios reales
3. ✅ **Integridad académica** del bootcamp
4. ✅ **Evaluación justa** e individual de competencias en Java

---

## 🎯 Problema que Resuelve

### Escenario Tradicional (Sin la Política)

**Problema**: Aprendiz A completa la práctica, comparte el código con Aprendices B, C, D...

**Resultado**:

- ❌ Código idéntico entre múltiples aprendices
- ❌ No hay evidencia de comprensión real
- ❌ Aprendices aprueban sin aprender
- ❌ Dificultad para detectar copias
- ❌ Injusticia para quien sí estudia

**Ejemplo real**:

```java
// Todos entregan exactamente esto:
public class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Getters y setters...
}
```

---

### Con Política de Dominios Únicos

**Solución**: Cada aprendiz trabaja sobre un dominio de negocio diferente.

**Resultado**:

- ✅ Código único por aprendiz (diferente contexto)
- ✅ Evidencia clara de comprensión
- ✅ Imposible copiar sin adaptar (requiere entender)
- ✅ Detección automática de copias
- ✅ Evaluación justa

**Ejemplo con dominios**:

**Aprendiz A (Restaurante)**:

```java
// ¿Qué? Clase para platos del menú
// ¿Para qué? Modelar elementos del catálogo gastronómico
public class Dish {
    private String dishName;
    private double price;
    private String category;
    
    public Dish(String dishName, double price, String category) {
        this.dishName = dishName;
        this.price = price;
        this.category = category;
    }
    
    // Getters y setters...
}
```

**Aprendiz B (Biblioteca)**:

```java
// ¿Qué? Clase para libros del catálogo
// ¿Para qué? Modelar elementos del inventario bibliográfico
public class Book {
    private String title;
    private String author;
    private String isbn;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    // Getters y setters...
}
```

**Aprendiz C (Gimnasio)**:

```java
// ¿Qué? Clase para miembros del gimnasio
// ¿Para qué? Modelar clientes con membresía activa
public class Member {
    private String name;
    private String membershipType;
    private LocalDate registrationDate;
    
    public Member(String name, String membershipType, LocalDate registrationDate) {
        this.name = name;
        this.membershipType = membershipType;
        this.registrationDate = registrationDate;
    }
    
    // Getters y setters...
}
```

**Detección**: Si dos aprendices entregan código idéntico, es **copia evidente**.

---

## 🏗️ Arquitectura del Sistema

### 1. Pool de Dominios (50+ únicos)

Categorías de dominios:

#### A. Comercio y Retail

- Restaurante, Cafetería, Panadería
- Tienda de Ropa, Zapatería, Joyería
- Supermercado, Farmacia, Ferretería

#### B. Servicios Profesionales

- Clínica Veterinaria, Consultorio Médico, Clínica Dental
- Bufete de Abogados, Notaría, Agencia de Seguros
- Salón de Belleza, Spa, Barbería

#### C. Educación y Cultura

- Biblioteca, Academia de Música, Centro Educativo
- Museo, Galería de Arte, Teatro

#### D. Entretenimiento y Deporte

- Gimnasio, Club Deportivo, Escuela de Natación
- Cine, Bolera, Arcade

#### E. Inmobiliario y Automotriz

- Inmobiliaria, Constructora, Arquitectos
- Taller Mecánico, Concesionario, Parqueadero

#### F. Logística y Turismo

- Agencia de Viajes, Hotel, Hostal
- Agencia de Mudanzas, Courier, Almacén

**Total**: 50+ dominios únicos garantizando **cero repeticiones** por cohorte.

---

### 2. Asignación Aleatoria

**Proceso**:

```bash
# Pseudocódigo del proceso de asignación

1. Leer lista de aprendices (APRENDICES-3147234.md)
2. Generar lista de dominios disponibles
3. Para cada aprendiz:
   a. Seleccionar dominio aleatorio (sin repetir)
   b. Crear carpeta: 4-asignación_dominios_aprendiz/aprendiz-XXX-[nombre]/
   c. Generar dominio.md con contexto detallado
   d. Generar asignaciones semanales contextualizadas
4. Marcar dominios como asignados
5. Generar reporte de asignaciones (solo para instructor)
```

**Garantías**:

- ✅ Un dominio = Un aprendiz
- ✅ Aleatorio (no hay favoritismos)
- ✅ Registrado y auditable
- ✅ Inmutable durante el bootcamp

---

### 3. Estructura de Asignación Individual

```
4. asignación_dominios/
├── README.md (política y guía)
├── fichas/
│   └── ficha-XXXXXX/
│       └── aprendiz-001-[nombre]/
│           ├── dominio.md                    # Contexto del negocio
│           ├── asignacion-semana-00.md       # Ejercicios semana 0 (Fundamentos Java)
│           ├── asignacion-semana-01.md       # Ejercicios semana 1 (Intro POO)
│           ├── asignacion-semana-02.md       # Ejercicios semana 2 (Clases y Objetos)
│           ├── asignacion-semana-03.md       # Ejercicios semana 3 (Encapsulación)
│           ├── asignacion-semana-04.md       # Ejercicios semana 4 (Herencia)
│           ├── asignacion-semana-05.md       # Ejercicios semana 5 (Polimorfismo)
│           ├── asignacion-semana-06.md       # Ejercicios semana 6 (Abstracción)
│           ├── asignacion-semana-07.md       # Ejercicios semana 7 (Paquetes y Excepciones)
│           ├── asignacion-semana-08.md       # Ejercicios semana 8 (Colecciones)
│           ├── asignacion-semana-09.md       # Proyecto Final Integrador
│           └── rubrica-general.md            # Criterios de evaluación
```

---

### 4. Ejemplo Completo de Dominio

**Archivo: `dominio.md`**

```markdown
# Dominio Asignado: Restaurante "La Trattoria"

## Contexto de Negocio

**Tipo**: Restaurante de comida italiana  
**Ubicación**: Bogotá, Zona T  
**Tamaño**: 15 mesas (60 personas capacidad)  
**Horario**: Martes a Domingo, 12:00 - 22:00

## Descripción

La Trattoria es un restaurante familiar que ofrece comida italiana
auténtica. Cuenta con un menú de 40 platos entre entradas, pastas,
pizzas, carnes y postres. El restaurante tiene 8 empleados y atiende
aproximadamente 100 clientes al día.

## Entidades Principales (Clases POO)

### 1. Table (Mesa)

- Atributos: `number`, `capacity`, `location`, `status`
- Métodos: `reserve()`, `releaseTable()`, `changeStatus()`
- Relaciones: tiene muchos `Order`, tiene muchas `Reservation`

### 2. Dish (Plato del Menú)

- Atributos: `name`, `category`, `price`, `ingredients`, `available`
- Métodos: `calculateDiscountedPrice()`, `changeAvailability()`
- Categorías: `APPETIZER`, `PASTA`, `PIZZA`, `MEAT`, `DESSERT`, `BEVERAGE` (enum)

### 3. Employee (Empleado)

- Atributos: `name`, `position`, `shift`, `salary`, `hireDate`
- Métodos: `calculateSalary()`, `changeShift()`, `getSeniority()`
- Puestos: `CHEF`, `SOUS_CHEF`, `WAITER`, `CASHIER`, `HOSTESS` (enum)
- **Herencia**: `KitchenEmployee extends Employee`, `HallEmployee extends Employee`

### 4. Order (Pedido)

- Atributos: `table`, `employee`, `itemList`, `total`, `status`, `date`
- Métodos: `addItem()`, `calculateTotal()`, `changeStatus()`
- Estados: `PENDING`, `IN_PREPARATION`, `SERVED`, `PAID` (enum)
- Relaciones: pertenece a `Table`, atendido por `Employee`, contiene múltiples `Dish`

### 5. Reservation (Reserva)

- Atributos: `customerName`, `phone`, `table`, `dateTime`, `numberOfPeople`
- Métodos: `confirmReservation()`, `cancelReservation()`, `modifyReservation()`

### 6. InventoryItem (Item de Inventario)

- Atributos: `ingredient`, `quantity`, `unitOfMeasure`, `minimumStock`, `supplier`
- Métodos: `restock()`, `checkStock()`, `updateQuantity()`

## Ejemplo de Implementación POO

### Clase Dish (con encapsulación)

```java
package com.trattoria.model;

public class Dish {
    private String name;
    private DishCategory category;
    private double price;
    private List<String> ingredients;
    private boolean available;
    
    // Constructor
    public Dish(String name, DishCategory category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.ingredients = new ArrayList<>();
        this.available = true;
    }
    
    // Método de negocio
    public double calculateDiscountedPrice(double percentage) {
        return this.price * (1 - percentage / 100);
    }
    
    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // ... otros getters/setters
}

// Enum para categorías
enum DishCategory {
    APPETIZER, PASTA, PIZZA, MEAT, DESSERT, BEVERAGE
}
```

### Jerarquía de Herencia

```java
// Clase abstracta base
public abstract class Employee {
    protected String name;
    protected double salary;
    protected LocalDate hireDate;
    
    public abstract double calculateSalary();
    public abstract String getResponsibilities();
}

// Clase derivada
public class KitchenEmployee extends Employee {
    private String specialty;
    private int yearsOfExperience;
    
    @Override
    public double calculateSalary() {
        return salary + (yearsOfExperience * 100000);
    }
    
    @Override
    public String getResponsibilities() {
        return "Preparar platillos y gestionar cocina";
    }
}
```

## Datos de Ejemplo (Objetos Instanciados)

### Menú (10 platos - objetos Dish)

```java
// Ejemplo de instanciación de objetos
Dish dish1 = new Dish("Bruschetta al Pomodoro", DishCategory.APPETIZER, 18000);
Dish dish2 = new Dish("Carpaccio di Manzo", DishCategory.APPETIZER, 25000);
Dish dish3 = new Dish("Spaghetti Carbonara", DishCategory.PASTA, 32000);
Dish dish4 = new Dish("Fettuccine Alfredo", DishCategory.PASTA, 30000);
Dish dish5 = new Dish("Pizza Margherita", DishCategory.PIZZA, 28000);
Dish dish6 = new Dish("Pizza Quattro Stagioni", DishCategory.PIZZA, 35000);
Dish dish7 = new Dish("Osso Buco", DishCategory.MEAT, 48000);
Dish dish8 = new Dish("Saltimbocca", DishCategory.MEAT, 42000);
Dish dish9 = new Dish("Tiramisu", DishCategory.DESSERT, 15000);
Dish dish10 = new Dish("Panna Cotta", DishCategory.DESSERT, 14000);
```

### Empleados (8 personas - objetos Employee con polimorfismo)

```java
// Polimorfismo: ArrayList de tipo Employee con diferentes subclases
List<Employee> employees = new ArrayList<>();

employees.add(new KitchenEmployee("Giovanni Rossi", "Chef", 3500000));
employees.add(new KitchenEmployee("Marco Bianchi", "Sous Chef", 2800000));
employees.add(new HallEmployee("Laura Conti", "Mesera", 1500000, "Cena"));
employees.add(new HallEmployee("Sofia Marino", "Mesera", 1500000, "Almuerzo"));
employees.add(new HallEmployee("Luca Romano", "Mesero", 2000000, "Completo"));
employees.add(new AdministrativeEmployee("Giulia Ferrari", "Cajera", 2200000));
employees.add(new HallEmployee("Alessandro Ricci", "Mesero", 1500000, "Cena"));
employees.add(new HallEmployee("Francesca Greco", "Hostess", 1800000, "Completo"));
```

## Requisitos Técnicos (Constantes para todos)

- **JDK 17+** (Java Development Kit)
- **IntelliJ IDEA** o VS Code con Extension Pack for Java
- **Git y GitHub** para control de versiones
- **Maven o Gradle** para gestión de dependencias (semanas finales)
- **JUnit 5** para pruebas unitarias (opcional en semanas finales)

## Adaptación Semanal al Dominio

### Semana 0: Fundamentos de Java (Nivelación)

- Ejercicios con variables del dominio (ej: `dishPrice`, `customerName`)
- Estructuras de control aplicadas al contexto (ej: validar `customerAge`)
- Arrays con datos del negocio (ej: `String[] dishNames`)
- Métodos que resuelvan problemas del dominio

### Semana 1: Introducción a POO

- Identificar objetos del mundo real en "La Trattoria"
- Crear primera clase simple del dominio (ej: Plato, Mesa)
- Comparar enfoque estructurado vs POO con ejemplos del restaurante

### Semana 2: Clases y Objetos

- Modelar entidades principales del restaurante
- Crear clases con atributos y métodos del negocio
- Instanciar múltiples objetos (varios `Dish`, `Employee`, `Table`)

### Semana 3: Encapsulación y Constructores

- Aplicar modificadores de acceso a clases del dominio
- Crear constructores para objetos del restaurante
- Implementar getters/setters con validaciones del negocio

### Semana 4: Herencia

- Crear jerarquía de clases (ej: `Employee` → `KitchenEmployee`, `HallEmployee`)
- Reutilizar código mediante herencia
- Usar `super` y `extends` en contexto del dominio

### Semana 5: Polimorfismo

- Sobrecarga de métodos (ej: `calculatePrice` con diferentes parámetros)
- Sobrescritura de métodos (ej: `calculateSalary()` por tipo de empleado)
- Colecciones polimórficas (`List<Employee>` con diferentes subclases)

### Semana 6: Abstracción e Interfaces

- Crear clases abstractas para el dominio (ej: `abstract class Employee`)
- Definir interfaces (ej: `interface Payable`, `interface Reservable`)
- Implementar contratos en clases concretas

### Semana 7: Paquetes y Excepciones

- Organizar clases en paquetes (`com.trattoria.model`, `com.trattoria.service`)
- Crear excepciones personalizadas (ej: `TableNotAvailableException`)
- Manejar errores del negocio con try-catch

### Semana 8: Colecciones y Genéricos

- Usar `ArrayList` para gestionar listas de platos, empleados, pedidos
- Implementar `HashMap` para búsquedas (ej: menú por categoría)
- Operaciones CRUD sobre colecciones del dominio

### Semana 9: Proyecto Final Integrador

- Sistema completo de gestión del restaurante
- Aplicar todos los principios POO
- Incluir manejo de excepciones y colecciones
- Documentar con diagramas UML
```

---

## 📊 Evaluación con Dominios

### Rúbrica Adaptada

| Criterio                   | Peso | Evaluación                                              |
| -------------------------- | ---- | ------------------------------------------------------- |
| **Requisitos Técnicos**    | 40%  | Código compila, ejecuta, aplica conceptos POO correctos |
| **Adaptación al Dominio**  | 30%  | Nombres coherentes, lógica del negocio apropiada        |
| **Comprensión Demostrada** | 20%  | Comentarios apropiados, explicación clara               |
| **Originalidad**           | 10%  | No es copia de otro aprendiz                            |

### Detección de Copia

**Señales de alerta**:

- ❌ Nombres de clases/atributos/métodos idénticos entre aprendices de diferentes dominios
- ❌ Comentarios palabra por palabra iguales
- ❌ Estructura de código idéntica (incluso con nombres cambiados)
- ❌ Lógica de métodos idéntica sin adaptación al contexto
- ❌ Errores idénticos en múltiples entregas

**Acción**: Entrevista individual para verificar comprensión.

---

## 🔒 Confidencialidad

### Archivo de Aprendices

**Ubicación**: `docs/APRENDICES-3147234.md`

**Contenido**:

```markdown
# Aprendices Ficha 3147234

## Cohorte 2025-2

| ID  | Nombre Completo | Dominio Asignado | Email             |
| --- | --------------- | ---------------- | ----------------- |
| 001 | [Nombre]        | Restaurante      | email@sena.edu.co |
| 002 | [Nombre]        | Biblioteca       | email@sena.edu.co |
| 003 | [Nombre]        | Gimnasio         | email@sena.edu.co |
| ... | ...             | ...              | ...               |
```

**Seguridad**:

- ❌ Ignorado en git (`.gitignore`)
- ✅ Visible en proyecto (acceso local)
- 🔐 Solo instructor tiene acceso
- 📝 Usado para generar asignaciones

---

## 🚫 Reglas Estrictas

### Material Compartido (Teoría y Prácticas)

#### ✅ PERMITIDO:

- Ejemplos genéricos: "Clase `Person`", "Clase `Product`", "Sistema de gestión"
- Clases abstractas: `Entity`, `Item`, `Record`
- Conceptos universales: encapsulación, herencia, polimorfismo, abstracción
- Estructuras de datos genéricas: `ArrayList`, `HashMap`

#### ❌ PROHIBIDO:

- Mencionar nombres de aprendices: "Como hizo Juan..."
- Mencionar dominios específicos: "Para el restaurante..."
- Dar ejemplos de dominios asignados
- Mostrar código de entregas anteriores con contexto específico

### Comunicación con Aprendices

**Correcto**:

> "Adapta este ejemplo a tu dominio de negocio. Donde dice '`Entity`',
> usa el nombre correspondiente de tu contexto (ej: si tu dominio es
> una tienda, podría ser '`Product`'; si es un gimnasio, '`Member`')."

**Incorrecto**:

> "Pedro, en tu restaurante debes crear la clase '`Dish`'..."  
> _(Expone el dominio de Pedro a otros aprendices)_

---

## 🎓 Beneficios Pedagógicos

### Para el Aprendiz

1. **Aprendizaje Activo**: Debe entender para adaptar
2. **Contextualización**: Conecta con realidad empresarial
3. **Portfolio Único**: Proyecto diferenciado
4. **Pensamiento Crítico**: Resuelve problemas específicos
5. **Preparación Laboral**: Simula proyecto real

### Para el Instructor

1. **Detección Fácil**: Copias son evidentes
2. **Evaluación Justa**: Cada quien según su trabajo
3. **Retroalimentación**: Específica al contexto
4. **Seguimiento**: Evolución individual clara
5. **Calidad Educativa**: Garantizada

### Para el SENA

1. **Integridad Académica**: Protegida
2. **Reputación**: Formación seria y rigurosa
3. **Egresados Competentes**: Saben hacer, no copiar
4. **Innovación Pedagógica**: Metodología diferenciadora
5. **Trazabilidad**: Auditable y demostrable

---

## 📈 Métricas de Éxito

### Indicadores

- **Tasa de originalidad**: > 95% (< 5% copias detectadas)
- **Comprensión demostrada**: > 85% aprendices explican su código
- **Satisfacción del aprendiz**: > 4.0/5.0 (sienten que aprenden de verdad)
- **Empleabilidad**: Portfolio personalizado aumenta contratación

### Seguimiento

- **Semana 3**: Primera verificación (encapsulación y constructores)
- **Semana 6**: Verificación media (abstracción e interfaces completas)
- **Semana 9**: Evaluación final (proyecto integrador POO completo)

---

## 🔄 Proceso de Implementación

### Fase 1: Preparación (Antes del bootcamp)

1. ✅ Generar pool de 50+ dominios
2. ✅ Obtener lista de aprendices
3. ✅ Asignar dominios aleatoriamente
4. ✅ Crear carpetas individuales
5. ✅ Generar documentos de contexto

### Fase 2: Inducción (Semana 0 - Día 1)

1. ✅ Explicar la política a los aprendices
2. ✅ Entregar dominio individual a cada uno
3. ✅ Aclarar beneficios y reglas (trabajo en contextos diferentes)
4. ✅ Responder preguntas

### Fase 3: Seguimiento (Semanas 0-9)

1. ✅ Verificar adaptación al dominio en entregas
2. ✅ Detectar posibles copias
3. ✅ Entrevistar si hay sospechas
4. ✅ Retroalimentación contextualizada

### Fase 4: Evaluación Final (Semana 9)

1. ✅ Proyecto completo en dominio asignado
2. ✅ Presentación y defensa
3. ✅ Verificación de comprensión
4. ✅ Certificación

---

## 🛠️ Herramientas de Soporte

### Script de Asignación

```python
# asignar_dominios.py
# ¿Qué? Script para asignar dominios aleatorios a aprendices del bootcamp POO Java
# ¿Para qué? Automatizar el proceso de asignación garantizando unicidad

import random
import os

# Lista de dominios disponibles
dominios = [
    "Restaurante", "Biblioteca", "Gimnasio",
    "Inmobiliaria", "Clínica Veterinaria", "Cafetería",
    "Tienda de Ropa", "Farmacia", "Hotel", "Salón de Belleza",
    # ... 50+ dominios
]

# Leer lista de aprendices por ficha
ficha = "3147234"
aprendices_file = f"docs/fichas/APRENDICES-{ficha}.md"

with open(aprendices_file, "r") as f:
    aprendices = [line.strip() for line in f if line.strip()]

# Asignar aleatoriamente
random.shuffle(dominios)
asignaciones = {}

for i, aprendiz in enumerate(aprendices):
    if i < len(dominios):
        asignaciones[aprendiz] = dominios[i]
        # Crear carpeta individual
        carpeta = f"bootcamp/semana-01/4. asignación_dominios/fichas/ficha-{ficha}/aprendiz-{i+1:03d}-{aprendiz}"
        os.makedirs(carpeta, exist_ok=True)
        
        # Generar dominio.md y asignaciones semanales (0-9)
        # ...código para generar archivos...

print(f"Asignaciones completadas para ficha {ficha}!")
```

### Detector de Similitud

```python
# detectar_copias.py
# ¿Qué? Herramienta para detectar código Java similar entre aprendices
# ¿Para qué? Identificar posibles copias en ejercicios POO

from difflib import SequenceMatcher
import os

def similitud(texto1, texto2):
    """Calcula el porcentaje de similitud entre dos textos"""
    return SequenceMatcher(None, texto1, texto2).ratio()

def analizar_entregas(ruta_semana):
    """Analiza todas las entregas de una semana"""
    umbral = 0.85  # 85% de similitud = sospechoso
    
    # Obtener todos los archivos .java de los aprendices
    entregas = []
    for root, dirs, files in os.walk(ruta_semana):
        for file in files:
            if file.endswith('.java'):
                with open(os.path.join(root, file), 'r') as f:
                    entregas.append({
                        'aprendiz': root.split('/')[-2],  # Nombre carpeta aprendiz
                        'archivo': file,
                        'contenido': f.read()
                    })
    
    # Comparar pares de entregas
    for i, entrega1 in enumerate(entregas):
        for entrega2 in entregas[i+1:]:
            sim = similitud(entrega1['contenido'], entrega2['contenido'])
            if sim >= umbral:
                print(f"⚠️ ALERTA: {entrega1['aprendiz']} y {entrega2['aprendiz']}")
                print(f"   Similitud: {sim*100:.1f}%")
                print(f"   Archivos: {entrega1['archivo']} vs {entrega2['archivo']}")

# Uso
analizar_entregas("bootcamp/semana-03/entregas/")
```

---

## 📚 Casos de Uso

### Caso 1: Aprendiz Intenta Copiar

**Situación**: Aprendiz A (Restaurante) copia código de Aprendiz B (Biblioteca).

**Resultado**:

```java
// Aprendiz A entrega (supuestamente Restaurante):
public class Book {  // ❌ No tiene sentido en un restaurante
    private String title;
    private String author;
    private String isbn;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
```

**Detección**: Inmediata (clase `Book` en contexto de restaurante).

**Acción**:

1. Conversación individual con el aprendiz
2. Oportunidad de rehacer el ejercicio aplicando el dominio correcto
3. Si persiste, sanción académica según reglamento SENA

---

### Caso 2: Aprendiz Comparte Código

**Situación**: Aprendiz C (Gimnasio) ayuda a Aprendiz D (Farmacia) mostrando su código.

**Resultado**: Aprendiz D debe **adaptar** el código a su dominio.

**Ejemplo**:

**Código de C (Gimnasio)**:

```java
public class Member {
    private String name;
    private String membershipType;
    
    public Member(String name, String membershipType) {
        this.name = name;
        this.membershipType = membershipType;
    }
    
    public double calculateMonthlyFee() {
        if (membershipType.equals("Premium")) {
            return 150000;
        }
        return 80000;
    }
}
```

**Código de D (Farmacia)** - Adaptado correctamente:

```java
public class Customer {
    private String name;
    private String discountType;
    
    public Customer(String name, String discountType) {
        this.name = name;
        this.discountType = discountType;
    }
    
    public double calculateDiscount() {
        if (discountType.equals("Senior")) {
            return 0.15;  // 15% descuento
        }
        return 0.05;  // 5% descuento regular
    }
}
```

**Evaluación**: ✅ Permitido. D entendió el concepto y adaptó correctamente a su contexto.

---

### Caso 3: Material del Instructor

**Situación**: Instructor muestra ejemplo en clase.

**Correcto** (genérico):

```java
// Ejemplo genérico en clase sobre encapsulación
public class Entity {
    private String name;
    private int code;
    
    public Entity(String name, int code) {
        this.name = name;
        this.code = code;
    }
    
    // Getters y setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
}
```

**Aprendiz E (Hotel)** adapta:

```java
// ¿Qué? Clase para habitaciones del hotel
// ¿Para qué? Modelar las habitaciones con sus características
public class Room {
    private String number;
    private String type;
    private double pricePerNight;
    private boolean available;
    
    public Room(String number, String type, double pricePerNight) {
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.available = true;
    }
    
    // Método de negocio específico del hotel
    public double calculateStayCost(int nights) {
        return pricePerNight * nights;
    }
    
    // Getters y setters
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double price) { this.pricePerNight = price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
```

**Evaluación**: ✅ Excelente adaptación con métodos específicos del dominio.

---

## 🎯 Conclusión

Esta política garantiza:

1. ✅ **Aprendizaje real** de POO sobre memorización o copia
2. ✅ **Integridad académica** del bootcamp de Java
3. ✅ **Preparación profesional** de desarrolladores Java competentes
4. ✅ **Diferenciación** del programa SENA en formación POO
5. ✅ **Evaluación justa** e individual de competencias

**Resultado final**: Aprendices con habilidades reales de Programación Orientada a Objetos en Java, portfolios únicos con proyectos contextualizados, y capacidad demostrada de aplicar los principios de POO (encapsulación, herencia, polimorfismo, abstracción) en dominios diversos del mundo real.

---

**Última actualización**: 21 de octubre de 2025  
**Bootcamp**: Diseño y Programación Orientada a Objetos con Java (10 semanas)  
**Institución**: SENA - CGMLTI - Regional Distrito Capital  
**Duración**: 40 horas (10 semanas x 4 horas)