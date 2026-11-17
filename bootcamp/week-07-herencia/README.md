# Semana 07 — Herencia

> Tu clase ya se protege sola y vive en un inventario. Esta semana le das una hija: una variante de tu entidad que **es** tu entidad, hereda todo lo que ya funciona y cambia solo lo que la hace distinta. Y aprendes a decir que no a la herencia cuando la relación no es "es un", sino "tiene un".

Es la puerta del polimorfismo de la semana 08: una vez que una subclase cabe donde cabe su padre y cada objeto ejecuta su propia versión de un método, el resto del bootcamp lo da por hecho.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Escribir** una subclase con `extends` y explicar qué hereda y qué no puede tocar de su clase padre
- **Construir** una subclase con `super(...)`, reutilizando la validación del padre y comprobando sus propios datos antes de `super(...)`
- **Sobrescribir** un método con `@Override` y reutilizar la versión del padre con `super.metodo()`
- **Sobrescribir** `toString()`, el método que toda clase hereda de `Object`
- **Distinguir** qué abre `protected` y qué cierra `final` en un método y en una clase
- **Decidir** entre herencia y composición con la pregunta "¿es un o tiene un?" y comprobar que la subclase cumple lo que promete su padre

---

## 📋 Prerrequisitos

- [Semana 06](../week-06-encapsulacion_constructores_y_composicion/README.md): encapsulación, constructores que validan, `final` y composición.
- Tu *pull request* `week-06` fusionado en `main`, con tu clase encapsulada, `Inventory` y al menos 172 tests en verde.

---

## 🗂️ Estructura de la Semana

```
week-07-herencia/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 6 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Herencia y `extends`](1-teoria/01-herencia-y-extends.md) | Subclase y superclase, qué se hereda, lo `private` del padre, "un `RareBook` es un `Book`", `Object` en la raíz | 50 min |
| [02 · Constructores y `super`](1-teoria/02-constructores-y-super.md) | Los constructores no se heredan, `super(...)`, construcción de arriba abajo, el `super()` implícito, comprobar antes de `super(...)` | 45 min |
| [03 · Sobrescritura y `@Override`](1-teoria/03-sobrescritura-y-override.md) | Sobrescribir, `super.metodo()`, `@Override`, sus reglas, sobrecarga frente a sobrescritura, `toString()` | 50 min |
| [04 · `protected` y `final`](1-teoria/04-protected-y-final.md) | Los cuatro niveles con subclases, la trampa de `protected`, métodos y clases `final` | 45 min |
| [05 · Cuándo heredar y cuándo componer](1-teoria/05-cuando-heredar-y-cuando-componer.md) | "Es un" o "tiene un", la herencia que no tiene sentido, la subclase que rompe las promesas del padre | 50 min |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Extender una clase](2-practicas/ejercicio-01-extender-una-clase/README.md) | Un libro raro que hereda de `Book`: lo que recibe, lo que añade, lo que no puede tocar y su `super(...)` | 1 h 30 min |
| [02 · Sobrescribir métodos](2-practicas/ejercicio-02-sobrescribir-metodos/README.md) | `describe()` con `super`, `@Override` contra las erratas, un `lend()` que se niega y `toString()` | 2 h |
| [03 · `protected`, `final` y cuándo no heredar](2-practicas/ejercicio-03-protected-final-y-cuando-no-heredar/README.md) | Un `protected` que deja entrar a todos, `final` en método y clase, un préstamo que no es un libro y una subclase que miente | 2 h |

### Proyecto

Sobrescribes `toString()` en tu clase y escribes una subclase con **reserva** (unas últimas unidades que no se sacan nunca) que hereda todo y sobrescribe `isAvailable`, `take` y `describe`.
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
| Sobrescribir sin escribir la firma | En VS Code, dentro de la subclase, clic derecho → *Source Action...* → *Override/Implement Methods...*: marca los métodos y los escribe con su `@Override` |
| Generar `toString()` | En la misma *Source Action*, *Generate toString()...*. En tu proyecto no lo uses: el tuyo devuelve `describe()` |
| Ver la jerarquía de una clase | Clic derecho sobre el nombre de la clase → *Show Type Hierarchy* |
| Ir a la versión del padre | `Ctrl+clic` sobre `super.take()` te lleva al `take()` de tu clase |
| Ejecutar solo los tests de la subclase | `./mvnw test -Dtest=ReservedBicycleTest` (con tu clase) |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-07` con el `toString()` de tu clase, tu subclase con reserva y sus tests, sin ningún `Entity`, y `./mvnw test` en verde
2. ✅ Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio, y `App.java` con tu subclase en el inventario
3. ✅ Pull request `week-07` → `main` con la descripción del paso 11

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 194 tests y `Failures: 0, Errors: 0`; el segundo, mostrar al final el rechazo de la reserva y las dos líneas que imprime tu `toString()`. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 06](../week-06-encapsulacion_constructores_y_composicion/README.md) | **Semana 07** | [Semana 08](../week-08-polimorfismo/README.md) |

← [Volver al inicio del bootcamp](../../README.md)
