# Semana 09 — Clases abstractas e interfaces

> Tu inventario ya trata igual a todas las hijas de tu clase. Esta semana aprendes a escribir **contratos**: clases que no se pueden crear pero obligan a sus hijas a completar lo que falta, e interfaces que unen clases sin ningún parentesco. Tu `Inventory` aprende a elegir entidades con cualquier criterio, también con los que todavía no existen.

Conviertes en código una idea que la semana 08 dejó apuntada (un padre que no sabe qué responder), separas lo que una clase **es** de lo que **puede hacer**, y escribes código dentro de una interfaz con métodos `default` y `static`. La semana 10 cierra la fase de jerarquías con *records*, *enums*, `sealed` y *pattern matching*.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Declarar** una clase abstracta con métodos abstractos y explicar por qué no se pueden crear objetos de ella
- **Escribir** un método plantilla: un esqueleto `final` en el padre con huecos que completan las hijas
- **Definir** una interfaz e implementarla en clases sin parentesco, y usarla como tipo de variables, arrays y parámetros
- **Usar** métodos `default` y `static` en una interfaz, y resolver dos `default` con el mismo nombre
- **Elegir** entre una clase abstracta y una interfaz según lo que compartan las clases
- **Escribir** código que recibe un contrato en lugar de una clase concreta, y que funciona con implementaciones nuevas sin cambiar

---

## 📋 Prerrequisitos

- [Semana 08](../week-08-polimorfismo/README.md): tipo estático y dinámico, ligadura dinámica y polimorfismo en lugar de condicionales.
- Tu *pull request* `week-08` fusionado en `main`, con tus dos subclases, `availableCount()` y `report()`, y al menos 215 tests en verde.

---

## 🗂️ Estructura de la Semana

```
week-09-clases_abstractas_e_interfaces/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 8 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Clases abstractas](1-teoria/01-clases-abstractas.md) | Un padre sin objetos, métodos sin cuerpo, lo que impide el compilador y lo que una clase abstracta sí tiene | 50 min |
| [02 · El método plantilla](1-teoria/02-el-metodo-plantilla.md) | El esqueleto en el padre y los huecos en las hijas, métodos `final`, cuidado con el constructor | 40 min |
| [03 · Interfaces](1-teoria/03-interfaces.md) | Un contrato sin familia, `implements`, la interfaz como tipo, varias interfaces en una clase | 55 min |
| [04 · Métodos `default` y `static`](1-teoria/04-metodos-default-y-static.md) | Código dentro de una interfaz, constantes y ausencia de estado, dos `default` con el mismo nombre | 45 min |
| [05 · Clase abstracta o interfaz](1-teoria/05-clase-abstracta-o-interfaz.md) | Qué puede tener cada una, la pregunta que decide, las dos juntas, por qué `Criterion` es una interfaz | 50 min |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Clases abstractas](2-practicas/ejercicio-01-clases-abstractas/README.md) | Un padre que no se crea, una hija que olvida su método, un constructor abstracto que valida y un esqueleto `final` | 2 h |
| [02 · Interfaces](2-practicas/ejercicio-02-interfaces/README.md) | Un libro y un portátil en el mismo array, una clase con dos contratos y uno que no firmó | 2 h |
| [03 · Métodos `default` y `static`](2-practicas/ejercicio-03-metodos-default-y-static/README.md) | Un `count` heredado por todos los criterios, un `static` de interfaz y dos `default` en conflicto | 1 h 30 min |

### Proyecto

Escribes la interfaz `Criterion` con un método `default`, dos criterios que la implementan y dos métodos en tu `Inventory` que eligen entidades con cualquier criterio sin saber cuál le llega.
→ [3-proyecto/README.md](3-proyecto/README.md)

---

## ⏱️ Distribución del Tiempo (14 horas)

| Actividad | Tiempo |
| --------- | ------ |
| Teoría (5 archivos) | 4 h |
| Ejercicio 01 | 2 h |
| Ejercicio 02 | 2 h |
| Ejercicio 03 | 1 h 30 min |
| Proyecto | 3 h |
| Recursos y glosario | 30 min |
| Autoevaluación (cuestionario de la rúbrica) | 1 h |
| **Total** | **14 h** |

---

## 🎩 Trucos y atajos

| Truco | Cómo |
|---|---|
| Escribir los métodos de una interfaz | Escribe `class X implements Criterion`, pon el cursor en el error y usa la acción rápida *Implement methods* (`Ctrl+.` en VS Code, `Alt+Enter` en IntelliJ) |
| Ver quién implementa una interfaz | Clic derecho sobre `Criterion` → *Go to Implementations* (`Ctrl+F12`) |
| Saber si un método viene de una interfaz | Pasa el ratón por encima de `count`: el editor dice dónde está declarado |
| Ejecutar solo los tests de los criterios | `./mvnw test -Dtest=CriterionTest` |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-09` con `Criterion`, `AvailableCriterion`, `NameCriterion` y sus tests, `select` y `count` en tu `Inventory`, sin ningún `Entity`, y `./mvnw test` en verde
2. ✅ Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio, uno con un criterio propio, y `App.java` con el bloque de los criterios
3. ✅ Pull request `week-09` → `main` con la descripción del paso 12

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 235 tests y `Failures: 0, Errors: 0`; el segundo, mostrar al final las entidades que contienen el texto que buscas y `Disponibles según el criterio`, con el mismo número que el `Disponibles` de la semana 08. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 08](../week-08-polimorfismo/README.md) | **Semana 09** | [Semana 10](../week-10-records_enums_sealed_y_pattern_matching/README.md) |

← [Volver al inicio del bootcamp](../../README.md)
