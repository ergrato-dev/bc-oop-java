# Rúbrica de Evaluación - Semana 06: Abstracción e Interfaces

## 📋 Información General

**Semana:** 06 - Abstracción e Interfaces  
**Total de Puntos:** 100  
**Porcentaje del Bootcamp:** 10%  
**Fecha de Evaluación:** Domingo (Semana 06)

---

## 🎯 Distribución de la Evaluación

| Tipo de Evidencia | Peso | Puntos |
|-------------------|------|--------|
| Conocimiento | 30% | 30 |
| Desempeño | 30% | 30 |
| Producto | 40% | 40 |
| **TOTAL** | **100%** | **100** |

---

## 📚 Evidencias de Conocimiento (30 puntos)

### Criterio 1: Comprensión del Concepto de Abstracción (10 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 9-10 | Explica claramente qué es abstracción, sus ventajas y diferencias con encapsulación. Proporciona ejemplos del mundo real precisos. |
| **Bueno** | 7-8 | Explica el concepto de abstracción y menciona ventajas. Ejemplos adecuados pero no siempre precisos. |
| **Suficiente** | 5-6 | Comprende el concepto básico de abstracción. Ejemplos simples o genéricos. |
| **Insuficiente** | 0-4 | No comprende el concepto de abstracción o lo confunde con otros conceptos. |

**Evidencia:** Cuestionario teórico o exposición oral

---

### Criterio 2: Diferencias entre Clases Abstractas e Interfaces (10 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 9-10 | Identifica correctamente 5+ diferencias clave. Explica cuándo usar cada una con criterios de diseño sólidos. |
| **Bueno** | 7-8 | Identifica 3-4 diferencias principales. Explica casos de uso básicos para cada una. |
| **Suficiente** | 5-6 | Identifica 2-3 diferencias. Comprende que se usan en contextos diferentes. |
| **Insuficiente** | 0-4 | No distingue entre clase abstracta e interface o tiene confusiones fundamentales. |

**Evidencia:** Preguntas escritas o análisis comparativo

---

### Criterio 3: Herencia Múltiple y Contratos (10 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 9-10 | Explica por qué Java no permite herencia múltiple de clases pero sí de interfaces. Comprende el concepto de contrato. |
| **Bueno** | 7-8 | Explica la implementación múltiple de interfaces y sus ventajas. |
| **Suficiente** | 5-6 | Sabe que se pueden implementar múltiples interfaces pero no explica completamente por qué. |
| **Insuficiente** | 0-4 | No comprende la diferencia entre herencia de clase e implementación de interface. |

**Evidencia:** Resolución de problemas teóricos

---

## 🛠️ Evidencias de Desempeño (30 puntos)

### Criterio 4: Implementación de Clase Abstracta (10 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 9-10 | Clase abstracta con 3+ métodos (abstractos y concretos). Constructor bien definido. Subclases implementan correctamente. JavaDoc completo. |
| **Bueno** | 7-8 | Clase abstracta con mínimo 2 métodos. Subclases funcionales. JavaDoc en mayoría de métodos. |
| **Suficiente** | 5-6 | Clase abstracta básica con 1 método abstracto. Subclases implementan correctamente. JavaDoc parcial. |
| **Insuficiente** | 0-4 | Clase abstracta incorrecta, no compila, o subclases no implementan correctamente. |

**Evidencia:** Código fuente del ejercicio de figuras geométricas

---

### Criterio 5: Definición e Implementación de Interfaces (10 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 9-10 | Define 2+ interfaces con 3+ métodos cada una. Implementa múltiples interfaces en una clase. Código limpio y funcional. |
| **Bueno** | 7-8 | Define 1-2 interfaces con métodos adecuados. Implementa correctamente en clases. |
| **Suficiente** | 5-6 | Define 1 interface simple. Implementación básica funcional. |
| **Insuficiente** | 0-4 | Interface mal definida, no compila, o implementación incorrecta. |

**Evidencia:** Código fuente del ejercicio de interfaces

---

### Criterio 6: Uso de Métodos Abstractos y Concretos (10 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 9-10 | Combina inteligentemente métodos abstractos (comportamiento variable) con concretos (comportamiento común). Usa `super` correctamente. |
| **Bueno** | 7-8 | Usa métodos abstractos y concretos apropiadamente. Llamadas a `super` cuando es necesario. |
| **Suficiente** | 5-6 | Implementa métodos abstractos y concretos básicos. Uso limitado de `super`. |
| **Insuficiente** | 0-4 | No distingue entre métodos abstractos y concretos. Uso incorrecto de `super`. |

**Evidencia:** Revisión de código durante la sesión

---

## 📦 Evidencias de Producto (40 puntos)

### Criterio 7: Proyecto de Figuras Geométricas (15 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 14-15 | Clase abstracta `Figura` con métodos abstractos (`calcularArea`, `calcularPerimetro`) y concretos (`mostrarInfo`). 3+ subclases (Circulo, Rectangulo, Triangulo) con implementaciones correctas. Validaciones robustas. |
| **Bueno** | 11-13 | Clase abstracta `Figura` con métodos requeridos. 3 subclases funcionales. Validaciones básicas. |
| **Suficiente** | 8-10 | Clase abstracta básica. 2 subclases funcionales. Validaciones mínimas o ausentes. |
| **Insuficiente** | 0-7 | Proyecto incompleto, no compila, o no cumple requisitos mínimos. |

**Evidencia:** Repositorio GitHub con estructura completa

**Requisitos mínimos:**
- Clase abstracta `Figura` con al menos 1 método abstracto
- Mínimo 2 subclases concretas (ej: `Circulo`, `Rectangulo`)
- Métodos `calcularArea()` y `calcularPerimetro()` implementados
- Clase `Main` con demostración de uso
- Código compila sin errores

---

### Criterio 8: Sistema con Múltiples Interfaces (15 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 14-15 | Define 3+ interfaces (`Dibujable`, `Redimensionable`, `Comparable`). Implementa múltiples interfaces en clases. Métodos bien diseñados y funcionales. |
| **Bueno** | 11-13 | Define 2 interfaces relevantes. Implementación múltiple en al menos 1 clase. Funcionalidad correcta. |
| **Suficiente** | 8-10 | Define 1 interface. Implementación básica funcional. |
| **Insuficiente** | 0-7 | Interfaces mal definidas, no compila, o implementación incorrecta. |

**Evidencia:** Repositorio GitHub con interfaces implementadas

**Requisitos mínimos:**
- Mínimo 1 interface con 2+ métodos
- Mínimo 1 clase que implemente la interface
- Métodos implementados funcionalmente
- Clase `Main` demostrando el uso
- Código compila sin errores

---

### Criterio 9: Documentación y Diseño (10 puntos)

| Nivel | Puntos | Descripción |
|-------|--------|-------------|
| **Excelente** | 9-10 | Diagrama UML completo (clases abstractas, interfaces, relaciones). README con explicación del diseño. JavaDoc en todos los métodos. Comentarios claros. |
| **Bueno** | 7-8 | Diagrama UML básico. README con descripción general. JavaDoc en métodos principales. |
| **Suficiente** | 5-6 | Diagrama simple o README básico. JavaDoc mínimo. |
| **Insuficiente** | 0-4 | Sin documentación, diagrama incompleto o ausente. |

**Evidencia:** Archivos README.md, diagramas y comentarios en código

**Requisitos mínimos:**
- README.md explicando el diseño
- Diagrama de clases (puede ser hecho a mano y fotografiado, o digital)
- JavaDoc en métodos principales
- Comentarios explicativos en código complejo

---

## 🎯 Criterios Transversales (Aplicados en todo el código)

### Buenas Prácticas de Programación

| Aspecto | Descripción | Impacto en Nota |
|---------|-------------|-----------------|
| **Nombres descriptivos** | Variables, métodos y clases con nombres claros | -5 pts si no cumple |
| **Indentación** | Código correctamente indentado y legible | -3 pts si no cumple |
| **Sin código duplicado** | Reutilización mediante herencia/interfaces | -5 pts si hay duplicación excesiva |
| **Manejo de null** | Validaciones en constructores y métodos | -3 pts si causa NullPointerException |
| **Convenciones Java** | CamelCase, PascalCase, constantes en mayúsculas | -2 pts si no cumple |

---

## 📊 Tabla de Calificación Final

| Rango de Puntos | Calificación | Nivel de Logro |
|-----------------|--------------|----------------|
| 90 - 100 | Excelente | Dominio completo de abstracción e interfaces |
| 75 - 89 | Bueno | Buen manejo de conceptos con áreas de mejora |
| 60 - 74 | Suficiente | Comprensión básica, necesita reforzar |
| 0 - 59 | Insuficiente | No alcanza los objetivos mínimos |

---

## 📝 Notas Adicionales

### Penalizaciones por Errores Críticos

| Error | Penalización |
|-------|-------------|
| **Código no compila** | -20 puntos del producto |
| **Plagio detectado** | 0 puntos en toda la semana |
| **Entrega tardía** | -10 puntos por día |
| **Repositorio no accesible** | -15 puntos |
| **Sin estructura de proyecto** | -10 puntos |

### Bonificaciones

| Logro | Bonificación |
|-------|-------------|
| **Implementa métodos default en interfaces** | +5 puntos |
| **Diseño SOLID aplicado** | +5 puntos |
| **Tests unitarios incluidos** | +5 puntos |
| **Documentación excepcional** | +3 puntos |

**Nota:** Las bonificaciones no pueden exceder el puntaje máximo de 100.

---

## 🎯 Autoevaluación del Estudiante

Antes de entregar, verifica:

- [ ] ¿He creado una clase abstracta con métodos abstractos y concretos?
- [ ] ¿He implementado al menos 2 subclases concretas?
- [ ] ¿He definido e implementado al menos 1 interface?
- [ ] ¿Mi código compila sin errores?
- [ ] ¿He probado todas las funcionalidades en la clase Main?
- [ ] ¿He incluido JavaDoc en métodos principales?
- [ ] ¿He creado un README explicando el diseño?
- [ ] ¿He incluido un diagrama de clases?
- [ ] ¿Mi repositorio está organizado y accesible?
- [ ] ¿He seguido las convenciones de nomenclatura Java?

---

## 📋 Formato de Entrega

### Estructura del Repositorio

```
semana-06-abstraccion-[NOMBRE]/
├── README.md
├── diagrama-clases.png (o .jpg, .pdf)
├── src/
│   ├── figuras/
│   │   ├── Figura.java (clase abstracta)
│   │   ├── Circulo.java
│   │   ├── Rectangulo.java
│   │   └── Triangulo.java
│   ├── interfaces/
│   │   ├── Dibujable.java
│   │   ├── Redimensionable.java
│   │   └── [otras interfaces]
│   ├── implementaciones/
│   │   └── [clases que implementan interfaces]
│   └── Main.java
└── docs/
    └── [documentación adicional]
```

### Información en README.md

```markdown
# Semana 06 - Abstracción e Interfaces

**Estudiante:** [Tu Nombre]
**Ficha:** [Número de Ficha]
**Dominio:** [Tu Dominio Asignado]

## Descripción
[Explicación breve del proyecto]

## Diseño
[Explicación de clases abstractas e interfaces usadas]

## Cómo Ejecutar
[Instrucciones para ejecutar el proyecto]

## Diagrama de Clases
[Imagen o referencia al diagrama]
```

---

## 🔗 Recursos de Apoyo

- **Material teórico:** `bootcamp/semana-06/1-teoria/`
- **Ejercicios prácticos:** `bootcamp/semana-06/2-practica/`
- **Glosario:** `bootcamp/semana-06/3-recursos/glosario.md`
- **Errores comunes:** `bootcamp/semana-06/3-recursos/errores-comunes.md`

---

## 📞 Consultas

Si tienes dudas sobre la evaluación:
- 📧 Contacta al instructor
- 💬 Usa los canales de comunicación del curso
- 📚 Revisa el material de la semana

---

## ⏰ Fechas Importantes

| Actividad | Fecha |
|-----------|-------|
| Sesión presencial | [Fecha programada] |
| Entrega de ejercicios | Domingo 23:59 |
| Publicación de calificaciones | Lunes siguiente |
| Retroalimentación | Martes siguiente |

---

**¡Éxito en tu evaluación de Abstracción e Interfaces! 🎨✨**
