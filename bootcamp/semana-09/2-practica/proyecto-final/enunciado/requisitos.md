# Requisitos Detallados - Proyecto Final

## 📊 Distribución de Puntos

| Criterio | Peso | Puntos |
|----------|------|--------|
| **Conocimiento (Presentación Oral)** | 30% | 1.5 |
| **Desempeño (Código POO)** | 40% | 2.0 |
| **Producto (Sistema Funcional)** | 30% | 1.5 |
| **TOTAL** | 100% | 5.0 |

---

## 1. CONOCIMIENTO - Presentación Oral (30% = 1.5 pts)

### 1.1 Presentación Individual (15% = 0.75 pts)

**Duración**: 10-15 minutos

**Estructura Obligatoria**:
1. Introducción (2 min): Dominio, problema, objetivos
2. Demostración funcional (5 min): Ejecutar CRUD completo
3. Explicación técnica (5 min): UML, jerarquías, colecciones
4. Conclusiones (2 min): Desafíos y aprendizajes

**Rúbrica**:
- **Excelente (0.60-0.75)**: Presentación clara, dominio técnico, responde todo
- **Bueno (0.45-0.59)**: Presentación coherente, responde la mayoría
- **Suficiente (0.30-0.44)**: Presentación básica, responde con ayuda
- **Insuficiente (0.00-0.29)**: No presenta o no sabe explicar su código

### 1.2 Defensa Técnica (15% = 0.75 pts)

**Preguntas del Instructor**:
- Explica cómo funciona la herencia en tu sistema
- ¿Por qué elegiste HashMap en lugar de ArrayList aquí?
- Muestra un ejemplo de polimorfismo en tu código
- ¿Qué hace esta excepción personalizada?
- ¿Cómo validas los datos de entrada?

**Rúbrica**:
- **Excelente (0.60-0.75)**: Responde correctamente, explica decisiones
- **Bueno (0.45-0.59)**: Responde la mayoría con apoyo visual
- **Suficiente (0.30-0.44)**: Responde parcialmente, dudas
- **Insuficiente (0.00-0.29)**: No puede explicar su código

---

## 2. DESEMPEÑO - Código POO (40% = 2.0 pts)

### 2.1 Encapsulación (8% = 0.40 pts)

**Requisitos**:
- ✅ Todos los atributos `private`
- ✅ Getters y setters implementados
- ✅ Mínimo 5 validaciones en setters

**Ejemplos de Validaciones**:
```java
public void setEdad(int edad) {
    if (edad < 0 || edad > 120) {
        throw new IllegalArgumentException("Edad inválida");
    }
    this.edad = edad;
}

public void setEmail(String email) {
    if (!email.contains("@")) {
        throw new IllegalArgumentException("Email inválido");
    }
    this.email = email;
}
```

**Rúbrica**:
- **Excelente (0.32-0.40)**: Todos privados, 5+ validaciones robustas
- **Bueno (0.24-0.31)**: Todos privados, 3-4 validaciones
- **Suficiente (0.16-0.23)**: Algunos públicos, 1-2 validaciones
- **Insuficiente (0.00-0.15)**: Sin encapsulación o sin validaciones

### 2.2 Herencia (10% = 0.50 pts)

**Requisitos**:
- ✅ 1 clase padre (abstracta o concreta)
- ✅ Mínimo 2 clases hijas
- ✅ Uso de `super()` en constructores
- ✅ Atributos compartidos en padre

**Ejemplo Mínimo**:
```java
public class Producto {
    private String codigo;
    private String nombre;
    // Constructores, getters, setters
}

public class ProductoFisico extends Producto {
    private double peso;
    public ProductoFisico(String codigo, String nombre, double peso) {
        super(codigo, nombre);
        this.peso = peso;
    }
}

public class ProductoDigital extends Producto {
    private double tamañoMB;
    public ProductoDigital(String codigo, String nombre, double tamañoMB) {
        super(codigo, nombre);
        this.tamañoMB = tamañoMB;
    }
}
```

**Rúbrica**:
- **Excelente (0.40-0.50)**: Jerarquía bien diseñada, 3+ hijas, lógica compartida
- **Bueno (0.30-0.39)**: Jerarquía correcta, 2 hijas, super() usado
- **Suficiente (0.20-0.29)**: Jerarquía básica, 1-2 hijas
- **Insuficiente (0.00-0.19)**: Sin herencia o mal implementada

### 2.3 Polimorfismo (10% = 0.50 pts)

**Requisitos**:
- ✅ Sobrecarga: 2+ métodos con mismo nombre, diferentes parámetros
- ✅ Sobrescritura: 2+ métodos con `@Override`
- ✅ Colecciones polimórficas: Usar tipo padre

**Ejemplos**:
```java
// Sobrecarga
public double calcular(double precio) { ... }
public double calcular(double precio, int cantidad) { ... }

// Sobrescritura
@Override
public double calcularDescuento() {
    // Implementación específica de ClienteVIP
}

// Colección polimórfica
List<Persona> personas = new ArrayList<>();
personas.add(new Cliente(...));
personas.add(new Empleado(...));
```

**Rúbrica**:
- **Excelente (0.40-0.50)**: 3+ sobrecargas, 3+ overrides, colecciones polimórficas
- **Bueno (0.30-0.39)**: 2 sobrecargas, 2 overrides, colecciones básicas
- **Suficiente (0.20-0.29)**: 1 sobrecarga o 1 override
- **Insuficiente (0.00-0.19)**: Sin polimorfismo

### 2.4 Abstracción (6% = 0.30 pts)

**Requisitos (AL MENOS UNO)**:
- ✅ Opción A: 1 clase abstracta con método abstracto
- ✅ Opción B: 1 interface con implementación

**Ejemplo Clase Abstracta**:
```java
public abstract class Figura {
    public abstract double calcularArea();
}

public class Circulo extends Figura {
    @Override
    public double calcularArea() { ... }
}
```

**Ejemplo Interface**:
```java
public interface Almacenable {
    void guardar();
    void cargar();
}

public class Cliente implements Almacenable {
    @Override
    public void guardar() { ... }
    @Override
    public void cargar() { ... }
}
```

**Rúbrica**:
- **Excelente (0.24-0.30)**: Clase abstracta + interface, bien integrados
- **Bueno (0.18-0.23)**: Clase abstracta O interface correctos
- **Suficiente (0.12-0.17)**: Abstracción básica pero funcional
- **Insuficiente (0.00-0.11)**: Sin abstracción

### 2.5 Excepciones (6% = 0.30 pts)

**Requisitos**:
- ✅ 2+ excepciones personalizadas
- ✅ 3+ bloques try-catch-finally
- ✅ Mensajes descriptivos

**Ejemplo**:
```java
public class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException(String id) {
        super("Cliente con ID '" + id + "' no encontrado");
    }
}

// Uso
try {
    Cliente c = servicio.buscar("123");
} catch (ClienteNoEncontradoException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("Búsqueda finalizada");
}
```

**Rúbrica**:
- **Excelente (0.24-0.30)**: 3+ excepciones, manejo completo, finally usado
- **Bueno (0.18-0.23)**: 2 excepciones, try-catch en lugares clave
- **Suficiente (0.12-0.17)**: 1-2 excepciones básicas
- **Insuficiente (0.00-0.11)**: Sin excepciones personalizadas

### 2.6 Colecciones (30% = 1.5 pts - evaluado en Producto)

Ver sección 3.2

---

## 3. PRODUCTO - Sistema Funcional (30% = 1.5 pts)

### 3.1 Sistema Funcional (15% = 0.75 pts)

**Requisitos**:
- ✅ Compila sin errores
- ✅ Ejecuta sin crashes
- ✅ Menú interactivo funcional
- ✅ Navegación fluida

**Funcionalidades Mínimas**:
1. Agregar registros
2. Buscar por criterio
3. Listar todos
4. Actualizar registros
5. Eliminar registros
6. Salir

**Rúbrica**:
- **Excelente (0.60-0.75)**: 6+ funcionalidades, sin errores, UX fluida
- **Bueno (0.45-0.59)**: 5 funcionalidades, errores menores
- **Suficiente (0.30-0.44)**: 3-4 funcionalidades básicas
- **Insuficiente (0.00-0.29)**: No compila o no funciona

### 3.2 Uso de Colecciones (8% = 0.40 pts)

**Requisitos**:
- ✅ ArrayList para listas ordenadas/historial
- ✅ HashMap para búsquedas por clave
- ✅ Operaciones CRUD implementadas

**Ejemplo**:
```java
// ArrayList para historial
private List<Pedido> historialPedidos = new ArrayList<>();

// HashMap para búsqueda rápida
private Map<String, Producto> catalogo = new HashMap<>();
```

**Rúbrica**:
- **Excelente (0.32-0.40)**: ArrayList + HashMap bien usados, iteraciones eficientes
- **Bueno (0.24-0.31)**: ArrayList O HashMap correcto
- **Suficiente (0.16-0.23)**: Una colección básica
- **Insuficiente (0.00-0.15)**: Sin colecciones o mal usadas

### 3.3 Documentación (7% = 0.35 pts)

**Requisitos**:
- ✅ README.md con instrucciones
- ✅ Diagrama UML (PNG/PDF)
- ✅ Comentarios Javadoc en clases principales

**README.md Debe Incluir**:
- Descripción del sistema
- Funcionalidades
- Instrucciones de compilación y ejecución
- Autor y ficha

**Rúbrica**:
- **Excelente (0.28-0.35)**: README completo, UML detallado, Javadoc
- **Bueno (0.21-0.27)**: README y UML correctos
- **Suficiente (0.14-0.20)**: README básico o UML simple
- **Insuficiente (0.00-0.13)**: Sin documentación

---

## 🎯 Requisitos Mínimos para Aprobar (3.5+)

**OBLIGATORIO cumplir TODO**:

- [ ] ✅ 5+ clases de dominio (entidades)
- [ ] ✅ 1 jerarquía: 1 padre + 2 hijas
- [ ] ✅ 1 clase abstracta O 1 interface
- [ ] ✅ ArrayList + HashMap usados
- [ ] ✅ 2+ excepciones personalizadas
- [ ] ✅ CRUD completo (Create, Read, Update, Delete)
- [ ] ✅ Menú interactivo funcional
- [ ] ✅ README.md con instrucciones
- [ ] ✅ Diagrama UML (PNG/PDF)
- [ ] ✅ Presentación oral de 10-15 min
- [ ] ✅ Sistema compila y ejecuta sin errores críticos

**Si falta CUALQUIERA de estos → Nota < 3.5**

---

## 🏅 Criterios para Excelencia (4.6 - 5.0)

**Opcional - Puntos Bonus**:

- [ ] 🌟 Implementar patrón Singleton para servicio único
- [ ] 🌟 Implementar patrón Factory para crear objetos
- [ ] 🌟 Implementar patrón Strategy para algoritmos intercambiables
- [ ] 🌟 Usar Generics (`<T>`) en al menos 1 clase
- [ ] 🌟 Informe técnico (PDF) con decisiones de diseño
- [ ] 🌟 Testing básico con casos de prueba
- [ ] 🌟 Exportar/importar datos a archivo (opcional)
- [ ] 🌟 Código limpio siguiendo convenciones Java
- [ ] 🌟 Presentación profesional con slides (opcional)
- [ ] 🌟 Defensa técnica impecable (responde todo)

---

## ⚠️ Tabla de Penalizaciones

| Falta | Penalización |
|-------|--------------|
| Código no compila | -0.5 |
| Sin README o UML | -0.3 |
| Sin manejo de excepciones | -0.2 |
| Atributos públicos (sin encapsulación) | -0.2 |
| Sin herencia o polimorfismo | -0.5 |
| Sin colecciones (ArrayList/HashMap) | -0.3 |
| No presenta oralmente | -1.5 |
| Plagio detectado | 1.0 (reprobado) |
| Entrega fuera de plazo | -0.1 por día |

---

## 📅 Cronograma Sugerido

| Actividad | Duración | Fecha |
|-----------|----------|-------|
| Diseño UML inicial | 1 día | Semana 9 |
| Crear clases modelo | 2 días | Semana 9-10 |
| Implementar servicios | 2 días | Semana 10 |
| Crear menú y excepciones | 1 día | Semana 10 |
| Testing y debugging | 1 día | Semana 10 |
| Documentación | 1 día | Semana 10 |
| Preparar presentación | 1 día | Semana 10 |
| **TOTAL** | **9 días** | **2 semanas** |

---

**Ver también**:
- [Enunciado Principal](ENUNCIADO.md)
- [Checklist de Proyecto](../../3-recursos/checklist-proyecto.md)
- [Ejemplos de Sistemas](../ejemplos/)
