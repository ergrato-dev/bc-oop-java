# 📋 Rúbrica de Evaluación - Semana 8
## Colecciones y Programación Genérica

---

## 📊 Distribución de Evaluación

| Tipo de Evidencia | Peso | Actividades |
|-------------------|------|-------------|
| 🧠 **Conocimiento** | 30% | Cuestionarios, preguntas teóricas |
| 🎭 **Desempeño** | 40% | Ejercicios prácticos, talleres |
| 🎁 **Producto** | 30% | Proyecto de agenda de contactos |

**Nota de aprobación**: 3.0/5.0 (60%)

---

## 🧠 EVIDENCIAS DE CONOCIMIENTO (30%)

### 1. Cuestionario sobre Colecciones (15%)

| Criterio | Excelente (5.0) | Bueno (4.0) | Suficiente (3.0) | Insuficiente (<3.0) |
|----------|-----------------|-------------|------------------|---------------------|
| **Diferencias Arrays vs Colecciones** | Explica claramente 4+ diferencias con ejemplos concretos | Explica 3 diferencias correctamente | Identifica 2 diferencias básicas | No diferencia o explica incorrectamente |
| **Interfaces principales** | Identifica y explica List, Set, Map con casos de uso específicos | Identifica las 3 interfaces con explicación básica | Identifica 2 interfaces correctamente | Confunde las interfaces o no las identifica |
| **Cuándo usar cada colección** | Justifica correctamente 5+ escenarios de uso | Justifica 3-4 escenarios apropiadamente | Justifica 2 escenarios básicos | No justifica o lo hace incorrectamente |

**Ponderación**: 15% de la nota final

---

### 2. Evaluación de Generics (15%)

| Criterio | Excelente (5.0) | Bueno (4.0) | Suficiente (3.0) | Insuficiente (<3.0) |
|----------|-----------------|-------------|------------------|---------------------|
| **Sintaxis de Generics** | Escribe correctamente 5+ declaraciones genéricas | Escribe 3-4 declaraciones correctas | Escribe 2 declaraciones básicas | Sintaxis incorrecta o no comprende |
| **Type Safety** | Explica beneficios y prevención de errores con ejemplos | Explica beneficios básicos correctamente | Identifica al menos 1 beneficio | No comprende el concepto |
| **Wildcards y Bounds** | Explica `<?>`, `<? extends>`, `<? super>` | Explica al menos 2 conceptos | Explica wildcards básicos | No comprende wildcards |

**Ponderación**: 15% de la nota final

---

## 🎭 EVIDENCIAS DE DESEMPEÑO (40%)

### 3. Ejercicio 1: Sistema de Inventario con ArrayList (10%)

| Criterio | Excelente (5.0) | Bueno (4.0) | Suficiente (3.0) | Insuficiente (<3.0) |
|----------|-----------------|-------------|------------------|---------------------|
| **Uso de ArrayList** | Implementa todas las operaciones (add, remove, get, size) correctamente | Implementa 3-4 operaciones correctamente | Implementa 2 operaciones básicas | Implementación incorrecta o incompleta |
| **Generics** | Usa tipos genéricos apropiadamente en toda la implementación | Usa generics en la mayoría del código | Usa generics básicamente | No usa generics o uso incorrecto |
| **Funcionalidad** | Sistema completo con búsqueda, filtrado y actualización | Operaciones CRUD básicas funcionan | Funcionalidad mínima operativa | No funciona o tiene errores críticos |

**Ponderación**: 10% de la nota final

---

### 4. Ejercicio 2: Agenda de Contactos con HashMap (15%)

| Criterio | Excelente (5.0) | Bueno (4.0) | Suficiente (3.0) | Insuficiente (<3.0) |
|----------|-----------------|-------------|------------------|---------------------|
| **Uso de HashMap** | Implementa correctamente put, get, remove, containsKey | Implementa 3 métodos correctamente | Implementa 2 métodos básicos | Implementación incorrecta |
| **Clave-Valor apropiado** | Diseño óptimo de clave (ej: ID único) y objeto complejo como valor | Diseño funcional de clave-valor | Diseño básico funcional | Diseño inadecuado o confuso |
| **Búsqueda y filtrado** | Implementa búsquedas avanzadas (por nombre, teléfono, etc.) | Implementa búsqueda por clave | Búsqueda básica funcional | No implementa búsqueda |
| **Iteración** | Usa entrySet(), keySet(), values() apropiadamente | Usa 2 formas de iteración | Itera de forma básica | No itera o lo hace incorrectamente |

**Ponderación**: 15% de la nota final

---

### 5. Ejercicio 3: Gestión de Productos con Set (10%)

| Criterio | Excelente (5.0) | Bueno (4.0) | Suficiente (3.0) | Insuficiente (<3.0) |
|----------|-----------------|-------------|------------------|---------------------|
| **Uso de Set** | Implementa HashSet/TreeSet con eliminación efectiva de duplicados | Usa Set correctamente con operaciones básicas | Implementación funcional mínima | No elimina duplicados o uso incorrecto |
| **equals() y hashCode()** | Sobrescribe ambos métodos correctamente en clase personalizada | Sobrescribe correctamente uno de los métodos | Implementación básica de comparación | No implementa o implementa incorrectamente |
| **Operaciones de conjuntos** | Implementa union, intersección, diferencia | Implementa 2 operaciones de conjuntos | Implementa 1 operación básica | No implementa operaciones de conjuntos |

**Ponderación**: 10% de la nota final

---

### 6. Taller: Iteradores y Bucles (5%)

| Criterio | Excelente (5.0) | Bueno (4.0) | Suficiente (3.0) | Insuficiente (<3.0) |
|----------|-----------------|-------------|------------------|---------------------|
| **For-each loop** | Usa for-each en todos los casos apropiados | Usa for-each en la mayoría de los casos | Usa for-each básicamente | No usa for-each o uso incorrecto |
| **Iterator explícito** | Implementa Iterator para operaciones de eliminación segura | Usa Iterator correctamente | Uso básico de Iterator | No usa Iterator o uso incorrecto |
| **Comparación de métodos** | Compara rendimiento y casos de uso de 3+ formas de iteración | Compara 2 formas de iteración | Identifica diferencias básicas | No comprende diferencias |

**Ponderación**: 5% de la nota final

---

## 🎁 EVIDENCIAS DE PRODUCTO (30%)

### 7. Proyecto: Agenda de Contactos Completa (30%)

| Criterio | Excelente (5.0) | Bueno (4.0) | Suficiente (3.0) | Insuficiente (<3.0) |
|----------|-----------------|-------------|------------------|---------------------|
| **Arquitectura** | Usa ArrayList para historial + HashMap para búsqueda rápida | Usa 2 colecciones apropiadamente | Usa 1 colección adecuada | Estructura de datos inadecuada |
| **Operaciones CRUD** | Implementa Create, Read, Update, Delete completamente | Implementa 3 operaciones correctamente | Implementa 2 operaciones básicas | Funcionalidad incompleta o errónea |
| **Búsqueda y filtrado** | Múltiples criterios de búsqueda (nombre, teléfono, email) | 2 criterios de búsqueda | 1 criterio de búsqueda | No implementa búsqueda |
| **Generics y Type Safety** | Código 100% type-safe con generics apropiados | Mayoría del código usa generics | Uso básico de generics | No usa generics o uso incorrecto |
| **Manejo de excepciones** | Valida entradas y maneja excepciones apropiadamente | Manejo básico de excepciones | Validación mínima | No valida o maneja excepciones |
| **Documentación** | Javadoc completo + README con instrucciones de uso | Javadoc básico + comentarios | Comentarios mínimos | Sin documentación |
| **Código limpio** | Nombres descriptivos, métodos pequeños, buena organización | Código generalmente limpio | Código funcional pero desorganizado | Código difícil de leer o mantener |
| **Testing** | Incluye casos de prueba para operaciones principales | Prueba funcionalidad básica manualmente | Prueba mínima | No prueba o no funciona |

**Ponderación**: 30% de la nota final

---

## 📈 Cálculo de Nota Final

```
Nota Final = (Conocimiento × 0.30) + (Desempeño × 0.40) + (Producto × 0.30)
```

### Ejemplo de Cálculo:

| Evidencia | Nota | Peso | Subtotal |
|-----------|------|------|----------|
| Cuestionario Colecciones | 4.5 | 15% | 0.675 |
| Evaluación Generics | 4.0 | 15% | 0.600 |
| Ejercicio ArrayList | 4.2 | 10% | 0.420 |
| Ejercicio HashMap | 4.5 | 15% | 0.675 |
| Ejercicio Set | 4.0 | 10% | 0.400 |
| Taller Iteradores | 4.3 | 5% | 0.215 |
| Proyecto Final | 4.6 | 30% | 1.380 |
| **TOTAL** | | **100%** | **4.365** |

**Nota Final**: 4.4/5.0 ✅

---

## ✅ Criterios de Aprobación

- **Aprobado**: Nota ≥ 3.0
- **No Aprobado**: Nota < 3.0

### Requisitos Mínimos para Aprobar:

1. ✅ Completar al menos 4 de los 5 ejercicios prácticos
2. ✅ Entregar el proyecto final de agenda de contactos funcional
3. ✅ Demostrar comprensión de List, Set y Map
4. ✅ Usar generics apropiadamente en el código
5. ✅ Asistir al 80% de la sesión práctica

---

## 🔄 Plan de Mejoramiento

Si no apruebas (nota < 3.0):

1. **Semana de recuperación**: Repasa los conceptos de colecciones con tutoriales
2. **Ejercicios adicionales**: Completa ejercicios de refuerzo proporcionados
3. **Tutoría personalizada**: Sesión 1:1 con el instructor (30 min)
4. **Evaluación de recuperación**: Nuevo proyecto integrador similar

---

## 📚 Recursos de Apoyo

- [Java Collections Framework - Oracle Docs](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)
- [ArrayList vs LinkedList - GeeksforGeeks](https://www.geeksforgeeks.org/arraylist-vs-linkedlist-java/)
- [HashMap Internal Working - Baeldung](https://www.baeldung.com/java-hashmap)
- Videos en carpeta `3-recursos/videos-recomendados.md`

---

## 💡 Recomendaciones para Obtener Excelente

1. 🎯 **Práctica constante**: Crea pequeños proyectos personales usando colecciones
2. 📖 **Lee documentación oficial**: Familiarízate con métodos de la API
3. 🔍 **Analiza el rendimiento**: Usa la colección adecuada según el caso (O notation)
4. 💬 **Explica tu código**: Si puedes enseñarlo, lo has comprendido
5. 🤝 **Code review**: Pide a compañeros que revisen tu código

---

## 📞 Contacto

**Instructor**: [Nombre del Instructor]  
**Email**: [correo@sena.edu.co]  
**Horario de atención**: [Horario disponible]

---

*Rúbrica actualizada: Noviembre 2024 - SENA*
