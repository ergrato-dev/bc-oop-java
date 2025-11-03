# Rúbrica de Evaluación - Semana 07
## Manejo de Paquetes y Excepciones

---

## Información General

- **Semana**: 07 de 10
- **Tema**: Manejo de Paquetes y Excepciones
- **Duración**: 4 horas
- **Puntaje Total**: 100 puntos

---

## Distribución de Evidencias

| Tipo de Evidencia | Peso | Puntos |
|-------------------|------|--------|
| Conocimiento | 25% | 25 pts |
| Desempeño | 35% | 35 pts |
| Producto | 40% | 40 pts |
| **TOTAL** | **100%** | **100 pts** |

---

## 1. EVIDENCIA DE CONOCIMIENTO (25 puntos)

### Prueba Teórica sobre Jerarquía de Excepciones y Sintaxis

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Responde correctamente 18-20 preguntas. Domina jerarquía de excepciones (Throwable, Error, Exception), diferencia checked/unchecked, sintaxis try-catch-finally, y convenciones de paquetes. | 22-25 |
| **Bueno** | Responde correctamente 15-17 preguntas. Comprende jerarquía básica, try-catch, y paquetes, pero con errores menores en detalles. | 18-21 |
| **Suficiente** | Responde correctamente 12-14 preguntas. Conocimiento básico de excepciones y paquetes, pero confunde conceptos como checked vs unchecked. | 13-17 |
| **Insuficiente** | Responde correctamente menos de 12 preguntas. No comprende jerarquía de excepciones ni organización en paquetes. | 0-12 |

**Temas evaluados**:
- Jerarquía de excepciones (Throwable → Error/Exception → RuntimeException)
- Diferencia entre checked y unchecked exceptions
- Sintaxis de try-catch-finally
- Palabras clave: throw vs throws
- Convención de nombres de paquetes (com.empresa.modulo)
- Import vs import static

---

## 2. EVIDENCIA DE DESEMPEÑO (35 puntos)

### Ejercicio Práctico: Crear Paquetes, Importar Clases y Manejar Excepciones

#### 2.1 Organización en Paquetes (15 puntos)

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Crea estructura completa de paquetes (modelo, servicio, excepciones) con declaración `package` correcta en cada archivo. Imports específicos y organizados. Código compila sin errores. | 13-15 |
| **Bueno** | Crea estructura de paquetes con declaración `package` correcta. Usa imports (algunos con wildcard). Código compila con advertencias menores. | 10-12 |
| **Suficiente** | Crea algunos paquetes pero estructura incompleta o declaraciones package incorrectas. Imports desorganizados. Código compila con errores corregibles. | 7-9 |
| **Insuficiente** | No crea paquetes o estructura incorrecta. Faltan declaraciones package. Código no compila. | 0-6 |

#### 2.2 Implementación de Try-Catch-Finally (10 puntos)

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Implementa try-catch-finally correctamente. Catch específicos (no genéricos). Finally limpia recursos apropiadamente. Maneja múltiples tipos de excepciones. | 9-10 |
| **Bueno** | Implementa try-catch-finally con catch específicos. Finally presente. Maneja 2+ excepciones. | 7-8 |
| **Suficiente** | Implementa try-catch básico. Catch genérico (Exception). Finally falta o incorrecto. | 5-6 |
| **Insuficiente** | Try-catch mal implementado o ausente. No maneja excepciones apropiadamente. | 0-4 |

#### 2.3 Validaciones con Excepciones (10 puntos)

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Implementa 3+ validaciones lanzando excepciones apropiadas (IllegalArgumentException, NullPointerException). Mensajes descriptivos con contexto. Usa throw correctamente. | 9-10 |
| **Bueno** | Implementa 2-3 validaciones con excepciones. Mensajes claros. Uso correcto de throw. | 7-8 |
| **Suficiente** | Implementa 1-2 validaciones básicas. Mensajes genéricos. Throw usado con errores menores. | 5-6 |
| **Insuficiente** | No implementa validaciones o throw usado incorrectamente. Mensajes de error ausentes o confusos. | 0-4 |

---

## 3. EVIDENCIA DE PRODUCTO (40 puntos)

### Proyecto Completo con Paquetes y Excepciones Personalizadas

#### 3.1 Estructura de Paquetes y Organización (10 puntos)

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Estructura completa: com.dominio.{modelo, servicio, excepciones, util}. Mínimo 3 clases en modelo, 1 en servicio, 2 excepciones. Package declarations correctas. Imports organizados. | 9-10 |
| **Bueno** | Estructura básica con 3 paquetes. Al menos 2 clases en modelo, 1 servicio, 2 excepciones. Declaraciones correctas. | 7-8 |
| **Suficiente** | Estructura mínima con 2 paquetes. Declaraciones presentes pero con errores. | 5-6 |
| **Insuficiente** | Estructura incorrecta o incompleta. Package declarations ausentes o erróneas. | 0-4 |

#### 3.2 Excepciones Personalizadas (15 puntos)

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Crea 2+ excepciones personalizadas (checked, extend Exception). Nombres descriptivos terminan en "Exception". Constructores: mensaje y mensaje+causa. Atributos contextuales cuando aplica. Documentadas con Javadoc. Usadas correctamente con throw/throws. | 13-15 |
| **Bueno** | Crea 2 excepciones personalizadas checked. Nombres descriptivos. Constructores: mensaje y mensaje+causa. Documentación básica. Uso correcto de throw/throws. | 10-12 |
| **Suficiente** | Crea 1-2 excepciones. Nombres aceptables. Solo constructor con mensaje. Documentación mínima. Throw/throws con errores menores. | 7-9 |
| **Insuficiente** | Crea menos de 2 excepciones o tipo incorrecto (unchecked para errores de negocio). Nombres genéricos. Constructores faltantes. Sin documentación. Throw/throws usado incorrectamente. | 0-6 |

#### 3.3 Implementación de Lógica de Negocio (10 puntos)

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Métodos de servicio implementan validaciones robustas. Declaran excepciones con throws. Lanzan excepciones personalizadas en situaciones apropiadas. Lógica clara y bien estructurada. | 9-10 |
| **Bueno** | Métodos implementan validaciones. Usan throws y throw correctamente. Lógica funcional con estructura aceptable. | 7-8 |
| **Suficiente** | Métodos con validaciones básicas. Throws/throw con uso limitado. Lógica funcional pero mejorable. | 5-6 |
| **Insuficiente** | Métodos sin validaciones o validaciones incorrectas. No usan throws/throw apropiadamente. Lógica deficiente o no funcional. | 0-4 |

#### 3.4 Main de Demostración (5 puntos)

| Nivel | Criterio | Puntos |
|-------|----------|--------|
| **Excelente** | Main demuestra 5+ casos: éxitos y errores. Try-catch para cada caso. Salida clara con emojis (✅/❌). Finally usado al menos 1 vez. Programa ejecuta sin errores. | 5 |
| **Bueno** | Main con 3-4 casos. Try-catch implementado. Salida clara. Programa ejecuta correctamente. | 3-4 |
| **Suficiente** | Main con 2-3 casos básicos. Try-catch presente. Salida funcional pero mejorable. | 2 |
| **Insuficiente** | Main con menos de 2 casos o no funciona. Try-catch ausente o incorrecto. Salida confusa o errores al ejecutar. | 0-1 |

---

## Resumen de Puntos por Nivel

| Evidencia | Excelente | Bueno | Suficiente | Insuficiente |
|-----------|-----------|-------|------------|--------------|
| Conocimiento (25 pts) | 22-25 | 18-21 | 13-17 | 0-12 |
| Desempeño (35 pts) | 31-35 | 24-30 | 17-23 | 0-16 |
| Producto (40 pts) | 36-40 | 28-35 | 20-27 | 0-19 |
| **TOTAL (100 pts)** | **90-100** | **70-89** | **50-69** | **0-49** |

---

## Escala de Calificación Final

| Rango de Puntos | Calificación | Nivel |
|-----------------|--------------|-------|
| 90-100 | 5.0 - 4.5 | Excelente |
| 70-89 | 4.4 - 3.5 | Bueno |
| 50-69 | 3.4 - 3.0 | Suficiente |
| 0-49 | 2.9 - 0.0 | Insuficiente |

---

## Observaciones Adicionales

### Aspectos Valorados Positivamente (+)
- Código limpio y bien comentado
- Uso de try-with-resources
- Manejo de múltiples catch con orden específico → genérico
- Creación de más de 2 excepciones personalizadas
- README.md completo y bien estructurado
- Uso de logging en vez de printStackTrace

### Penalizaciones (-)
- Código no compila: -20 puntos
- Código no ejecuta: -15 puntos
- Estructura de paquetes incorrecta: -10 puntos
- Sin excepciones personalizadas: -15 puntos
- Plagio detectado: 0 puntos + reporte académico
- Entrega tardía: -5 puntos por día

---

## Recomendaciones para el Estudiante

1. **Lee el material de teoría** antes de comenzar
2. **Revisa los ejercicios de práctica** para entender patrones
3. **Verifica que tu código compile** antes de entregar
4. **Prueba todos los casos** en el Main
5. **Documenta tu código** con comentarios claros
6. **Consulta el glosario** si tienes dudas sobre términos
7. **Pide ayuda** si te atoras (antes de la fecha límite)

---

**Versión**: 1.0  
**Fecha**: Semana 07  
**Instructor**: Bootcamp POO Java
