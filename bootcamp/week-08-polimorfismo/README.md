# Semana 08 — Polimorfismo

> Tu clase ya tiene una hija. Esta semana le das otra, y descubres por qué la herencia merece la pena: el código que trabaja con tu clase funciona con todas sus hijas, también con las que todavía no existen, sin preguntar nunca de qué clase es cada objeto. Una misma llamada, muchas formas de responder.

Separas dos tipos que hasta ahora parecían el mismo (el de la variable y el del objeto), ves quién elige el método que se ejecuta y cuándo, y aprendes a sospechar de cada `instanceof`. La semana 09 da el paso siguiente: clases abstractas e interfaces.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Distinguir** el tipo estático (el de la variable) del tipo dinámico (el del objeto) y decir qué decide cada uno
- **Explicar** la ligadura dinámica: cómo encuentra Java el método que ejecuta, también cuando la llamada está escrita en la clase padre
- **Predecir** qué método se ejecuta con sobrecarga, con sobrescritura y con métodos `static`
- **Usar** un *cast* hacia abajo y `instanceof` con patrón, y explicar cuándo falla un *cast*
- **Sustituir** una cadena de condicionales sobre el tipo por un método sobrescrito
- **Escribir** código que trabaja con una jerarquía entera sin preguntar el tipo de ningún objeto

---

## 📋 Prerrequisitos

- [Semana 07](../week-07-herencia/README.md): herencia, `super`, sobrescritura con `@Override` y `toString()`.
- Tu *pull request* `week-07` fusionado en `main`, con tu subclase con reserva y al menos 194 tests en verde.

---

## 🗂️ Estructura de la Semana

```
week-08-polimorfismo/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 7 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Una variable, muchas formas](1-teoria/01-una-variable-muchas-formas.md) | Tipo estático y tipo dinámico, qué decide el compilador y qué la JVM, *upcasting*, arrays y parámetros del tipo padre | 50 min |
| [02 · Ligadura dinámica](1-teoria/02-ligadura-dinamica.md) | Cómo se busca el método, el padre que llama a un método sobrescrito, abierto a clases nuevas, los `static` que se ocultan | 50 min |
| [03 · Sobrecarga frente a sobrescritura](1-teoria/03-sobrecarga-frente-a-sobrescritura.md) | Quién elige y cuándo, la trampa de la sobrecarga por tipo, sobrecargar sin querer | 40 min |
| [04 · `instanceof` y *casting*](1-teoria/04-instanceof-y-casting.md) | *Downcasting*, `ClassCastException`, `instanceof` con patrón, por qué sospechar de cada `instanceof` | 45 min |
| [05 · Polimorfismo en lugar de condicionales](1-teoria/05-polimorfismo-en-lugar-de-condicionales.md) | La cadena de `if` que falla en silencio, la regla dentro de cada clase, cuándo un `if` sí es la respuesta | 55 min |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Tipo estático y tipo dinámico](2-practicas/ejercicio-01-tipo-estatico-y-tipo-dinamico/README.md) | Un libro raro en una variable `Book`, lo que el compilador deja llamar, un array con tres clases y un parámetro que las acepta todas | 1 h 30 min |
| [02 · Ligadura dinámica y sobrecarga](2-practicas/ejercicio-02-ligadura-dinamica-y-sobrecarga/README.md) | Un método del padre que usa el de la hija, la sobrecarga que elige el compilador, un `static` que no se sobrescribe y una clase nueva sin tocar nada | 2 h |
| [03 · `instanceof` y polimorfismo en lugar de condicionales](2-practicas/ejercicio-03-instanceof-y-polimorfismo-en-lugar-de-condicionales/README.md) | Un *cast* que funciona y otro que revienta, `instanceof` con patrón y una regla con `if` que falla en silencio hasta que la llevas a cada clase | 2 h |

### Proyecto

Escribes una segunda subclase de tu clase, que cuenta sus salidas, y dos métodos en tu `Inventory` que funcionan con las tres clases sin preguntar de cuál es cada objeto.
→ [3-proyecto/README.md](3-proyecto/README.md)

---

## ⏱️ Distribución del Tiempo (14 horas)

| Actividad | Tiempo |
| --------- | ------ |
| Teoría (5 archivos) | 4 h |
| Ejercicio 01 | 1 h 30 min |
| Ejercicio 02 | 2 h |
| Ejercicio 03 | 2 h |
| Proyecto | 3 h |
| Recursos y glosario | 30 min |
| Autoevaluación (cuestionario de la rúbrica) | 1 h |
| **Total** | **14 h** |

---

## 🎩 Trucos y atajos

| Truco | Cómo |
|---|---|
| Ver todas las versiones de un método | Clic derecho sobre `take()` → *Go to Implementations* (`Ctrl+F12`): salen el de tu clase y los de tus dos subclases |
| Ver quién hereda de tu clase | Clic derecho sobre el nombre de la clase → *Show Type Hierarchy* |
| Escribir un `instanceof` con patrón | Escribe `if (item instanceof Reserved` y deja que el autocompletado proponga la variable. En tu `Inventory`, no lo uses |
| Saber la clase del objeto mientras depuras | En el depurador, la vista *Variables* muestra la clase real del objeto al lado de cada variable |
| Ejecutar solo los tests del inventario | `./mvnw test -Dtest=InventoryTest` |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-08` con tu subclase que cuenta salidas y sus tests, `availableCount()` y `report()` en tu `Inventory`, sin ningún `Entity`, y `./mvnw test` en verde
2. ✅ Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio, y `App.java` con el inventario de las tres clases
3. ✅ Pull request `week-08` → `main` con la descripción del paso 11

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 215 tests y `Failures: 0, Errors: 0`; el segundo, mostrar al final el rechazo de la reserva, las tres líneas del informe y `Disponibles: 1 de 3`. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 07](../week-07-herencia/README.md) | **Semana 08** | [Semana 09](../week-09-clases_abstractas_e_interfaces/README.md) |

← [Volver al inicio del bootcamp](../../README.md)
