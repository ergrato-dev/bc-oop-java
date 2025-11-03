# 📚 Prácticas - Semana 06: Abstracción e Interfaces

## 🎯 Objetivos

Aplicar los conceptos de abstracción e interfaces mediante ejercicios prácticos progresivos que consoliden tu comprensión de:
- Clases abstractas y métodos abstractos
- Interfaces y múltiple implementación
- Diseño orientado a objetos con abstracción
- Principios SOLID aplicados

---

## 📋 Estructura de las Prácticas

### Ejercicio 01: Sistema de Figuras Geométricas ⭐
**Nivel:** Básico  
**Duración:** 30-40 minutos  
**Conceptos:** Clase abstracta, métodos abstractos, herencia simple

Implementa un sistema de figuras geométricas usando una clase abstracta `Figura` con subclases concretas.

**Archivo:** `ejercicio-01-figuras/`

---

### Ejercicio 02: Capacidades con Interfaces ⭐⭐
**Nivel:** Intermedio  
**Duración:** 40-50 minutos  
**Conceptos:** Interfaces, implementación múltiple, polimorfismo

Diseña un sistema donde objetos gráficos implementan múltiples interfaces para diferentes capacidades.

**Archivo:** `ejercicio-02-interfaces/`

---

### Ejercicio 03: Sistema de Empleados ⭐⭐
**Nivel:** Intermedio  
**Duración:** 40-50 minutos  
**Conceptos:** Clases abstractas, interfaces, combinación de ambas

Implementa un sistema de gestión de empleados que combine clases abstractas e interfaces.

**Archivo:** `ejercicio-03-empleados/`

---

### Ejercicio 04: Proyecto Integrador ⭐⭐⭐
**Nivel:** Avanzado  
**Duración:** 60-90 minutos  
**Conceptos:** Diseño completo, SOLID, múltiples interfaces y jerarquías

Diseña un sistema completo de comercio electrónico aplicando todos los conceptos aprendidos.

**Archivo:** `ejercicio-04-integracion/`

---

## 🚀 Cómo Realizar las Prácticas

### 1. Lee las Instrucciones Completas
Antes de escribir código, lee todo el enunciado y requisitos del ejercicio.

### 2. Planifica tu Diseño
- Identifica las abstracciones necesarias
- Decide cuándo usar clases abstractas vs interfaces
- Dibuja un diagrama simple de clases

### 3. Implementa Progresivamente
- Comienza con la clase/interface base
- Implementa una clase concreta a la vez
- Prueba cada clase antes de continuar

### 4. Verifica tu Solución
Cada ejercicio incluye casos de prueba. Tu código debe:
- ✅ Compilar sin errores
- ✅ Ejecutar correctamente
- ✅ Producir la salida esperada

### 5. Compara con la Solución
Después de tu implementación, revisa la solución proporcionada y compara:
- Diferencias de diseño
- Optimizaciones posibles
- Mejores prácticas aplicadas

---

## 📊 Criterios de Evaluación

Cada ejercicio será evaluado según:

| Criterio | Peso | Descripción |
|----------|------|-------------|
| **Funcionalidad** | 40% | El código funciona correctamente |
| **Diseño** | 30% | Uso apropiado de abstracción |
| **Código Limpio** | 20% | Legibilidad, nombres descriptivos |
| **Buenas Prácticas** | 10% | Convenciones Java, comentarios |

---

## 🎯 Ejercicio 01: Figuras Geométricas

### 📝 Enunciado

Implementa un sistema de figuras geométricas que permita calcular áreas y perímetros de diferentes formas.

### Requisitos

1. **Clase Abstracta `Figura`:**
   - Atributo protegido: `color` (String)
   - Constructor que recibe el color
   - Método concreto: `obtenerColor()`
   - Método abstracto: `calcularArea()`
   - Método abstracto: `calcularPerimetro()`
   - Método concreto: `mostrarInfo()` que imprime color, área y perímetro

2. **Clase Concreta `Circulo`:**
   - Extiende `Figura`
   - Atributo privado: `radio` (double)
   - Constructor que recibe color y radio
   - Implementa `calcularArea()`: π × radio²
   - Implementa `calcularPerimetro()`: 2 × π × radio

3. **Clase Concreta `Rectangulo`:**
   - Extiende `Figura`
   - Atributos privados: `base` y `altura` (double)
   - Constructor que recibe color, base y altura
   - Implementa `calcularArea()`: base × altura
   - Implementa `calcularPerimetro()`: 2 × (base + altura)

4. **Clase Concreta `Triangulo`:**
   - Extiende `Figura`
   - Atributos privados: `base`, `altura`, `lado1`, `lado2`, `lado3` (double)
   - Constructor que recibe color, base, altura y los 3 lados
   - Implementa `calcularArea()`: (base × altura) / 2
   - Implementa `calcularPerimetro()`: lado1 + lado2 + lado3

### Casos de Prueba

```java
public class TestFiguras {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[3];
        
        figuras[0] = new Circulo("Rojo", 5.0);
        figuras[1] = new Rectangulo("Azul", 4.0, 6.0);
        figuras[2] = new Triangulo("Verde", 3.0, 4.0, 3.0, 4.0, 5.0);
        
        for (Figura figura : figuras) {
            figura.mostrarInfo();
            System.out.println("---");
        }
    }
}
```

### Salida Esperada

```
Figura de color: Rojo
Área: 78.54
Perímetro: 31.42
---
Figura de color: Azul
Área: 24.0
Perímetro: 20.0
---
Figura de color: Verde
Área: 6.0
Perímetro: 12.0
---
```

---

## 🎯 Ejercicio 02: Interfaces de Capacidades

### 📝 Enunciado

Diseña un sistema donde objetos gráficos tienen múltiples capacidades definidas por interfaces.

### Requisitos

1. **Interface `Dibujable`:**
   - Método `dibujar()`: imprime representación visual
   - Método `obtenerColor()`: retorna el color
   - Método `establecerColor(String color)`: cambia el color

2. **Interface `Redimensionable`:**
   - Método `redimensionar(double factor)`: escala el objeto
   - Método `obtenerTamaño()`: retorna el tamaño actual

3. **Interface `Rotable`:**
   - Método `rotar(double grados)`: rota el objeto
   - Método `obtenerAngulo()`: retorna el ángulo actual

4. **Clase `Circulo`:**
   - Implementa `Dibujable`, `Redimensionable`, `Rotable`
   - Atributos: `radio`, `color`, `angulo`
   - Implementa todos los métodos de las interfaces

5. **Clase `Cuadrado`:**
   - Implementa `Dibujable`, `Redimensionable`
   - Atributos: `lado`, `color`
   - NO implementa `Rotable`

### Casos de Prueba

```java
public class TestInterfaces {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5.0, "Rojo");
        circulo.dibujar();
        circulo.redimensionar(1.5);
        circulo.rotar(45);
        circulo.dibujar();
        
        System.out.println("---");
        
        Cuadrado cuadrado = new Cuadrado(4.0, "Azul");
        cuadrado.dibujar();
        cuadrado.redimensionar(2.0);
        cuadrado.dibujar();
    }
}
```

---

## 🎯 Ejercicio 03: Sistema de Empleados

### 📝 Enunciado

Implementa un sistema de gestión de empleados que combine clases abstractas e interfaces.

### Requisitos

1. **Interface `Trabajador`:**
   - Método `trabajar()`: describe la actividad laboral
   - Método `tomarDescanso()`: simula descanso

2. **Interface `Bonificable`:**
   - Método `calcularBonificacion()`: retorna monto de bonificación

3. **Clase Abstracta `Empleado`:**
   - Atributos protegidos: `nombre`, `salarioBase`
   - Constructor
   - Método abstracto: `calcularSalarioTotal()`
   - Método concreto: `mostrarInfo()`

4. **Clase `EmpleadoPlanta`:**
   - Extiende `Empleado`
   - Implementa `Trabajador` y `Bonificable`
   - Atributo: `anosAntiguedad`
   - Salario total = salarioBase + (salarioBase × 0.05 × años)

5. **Clase `EmpleadoContrato`:**
   - Extiende `Empleado`
   - Implementa `Trabajador`
   - NO implementa `Bonificable`
   - Atributo: `mesesContrato`
   - Salario total = salarioBase

---

## 🎯 Ejercicio 04: Proyecto Integrador

### 📝 Enunciado

Diseña un sistema completo de comercio electrónico con productos, pagos y envíos.

### Requisitos Principales

1. **Jerarquía de Productos:**
   - Clase abstracta `Producto`
   - Subclases: `ProductoFisico`, `ProductoDigital`, `Servicio`

2. **Interfaces de Pago:**
   - `MetodoPago` con implementaciones múltiples
   - Calcular comisiones según método

3. **Sistema de Envío:**
   - Interface `Enviabl` (solo productos físicos)
   - Calcular costos de envío

4. **Carrito de Compras:**
   - Manejar múltiples productos
   - Calcular total con impuestos
   - Procesar pago y envío

### Desafío Adicional (Opcional)

- Implementa descuentos por cupón (10%)
- Agrega sistema de inventario
- Implementa historial de compras

---

## 📚 Recursos Adicionales

### Documentación
- [Oracle Java Tutorials - Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Oracle Java Tutorials - Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

### Videos Recomendados
- Programación ATS - Clases Abstractas en Java
- Píldoras Informáticas - Interfaces Java

### Herramientas
- IntelliJ IDEA para autocompletado
- Draw.io para diagramas UML

---

## 🔍 Autoevaluación

Antes de continuar, verifica:

- [ ] ¿Entiendes cuándo usar clase abstracta vs interface?
- [ ] ¿Puedes implementar múltiples interfaces en una clase?
- [ ] ¿Sabes usar `abstract` y `@Override` correctamente?
- [ ] ¿Tu código compila y ejecuta sin errores?
- [ ] ¿Aplicaste principios de diseño (SOLID)?

---

## 💡 Consejos

1. **Comienza Simple:** Implementa primero la funcionalidad básica
2. **Prueba Constantemente:** Ejecuta tu código después de cada cambio
3. **Usa Nombres Descriptivos:** `calcularArea()` es mejor que `calc()`
4. **Comenta tu Código:** Explica decisiones de diseño
5. **No Copies y Pegues:** Escribe cada línea entendiendo qué hace

---

## 📞 ¿Necesitas Ayuda?

- Revisa la teoría en `1-teoria/`
- Consulta el glosario en `3-recursos/glosario.md`
- Pregunta al instructor durante la sesión
- Usa el foro de discusión del curso

---

**¡Éxito en tus prácticas! 💪**
