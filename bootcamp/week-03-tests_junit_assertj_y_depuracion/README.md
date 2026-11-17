# Semana 03 — Tests con JUnit y AssertJ; depuración

> Desde la semana 01 pones en verde tests que otros escribieron. Esta semana aprendes a escribirlos tú: elegir los casos, calcular lo esperado, cubrir los bordes y leer lo que dicen cuando fallan. Y cuando un programa da un resultado incorrecto sin avisar, a encontrar la causa con método: leer el error, imprimir, `assert` y el depurador.

A partir de aquí, cada semana tu proyecto crece con tests escritos por ti, y tu nota depende de que esos tests detecten errores de verdad.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Escribir** tests con JUnit y AssertJ en tres partes (preparar, actuar, comprobar), para valores, textos, arrays, decimales y excepciones
- **Ejecutar** todos los tests, una clase o un método con `./mvnw test -Dtest`, y **distinguir** un *failure* de un *error*
- **Diseñar** tests parametrizados con clases de equivalencia y valores límite
- **Leer** un *stack trace* y un mensaje de fallo hasta la línea que importa
- **Depurar** con `println`, `assert` y un depurador (`jdb` o el de tu editor): puntos de ruptura, pasos y variables

---

## 📋 Prerrequisitos

- [Semana 02](../week-02-control_metodos_strings_y_arrays/README.md): métodos, `String` y arrays.
- Tu *pull request* `week-02` fusionado en `main`.

---

## 🗂️ Estructura de la Semana

```
week-03-tests_junit_assertj_y_depuracion/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 2 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Qué es un test](1-teoria/01-que-es-un-test.md) | Para qué sirve, preparar-actuar-comprobar, `@Test`, Surefire, `-Dtest`, *failure* frente a *error* | 45 min |
| [02 · AssertJ](1-teoria/02-assertj.md) | `assertThat`, textos, arrays, decimales con margen, `throw`, `assertThatThrownBy`, leer un fallo | 45 min |
| [03 · Tests parametrizados y casos límite](1-teoria/03-tests-parametrizados-y-casos-limite.md) | `@ParameterizedTest`, `@CsvSource`, `@ValueSource`, clases de equivalencia, valores límite | 45 min |
| [04 · Leer errores](1-teoria/04-leer-errores.md) | Compilación, ejecución y test; anatomía de un *stack trace*; NPE; un test rojo en Maven | 45 min |
| [05 · El depurador](1-teoria/05-el-depurador.md) | Método de depuración, `println`, `assert`, puntos de ruptura y pasos, `jdb`, depurar un test de Maven | 1 h |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · JUnit y AssertJ](2-practicas/ejercicio-01-junit-y-assertj/README.md) | Tus primeros tests: valores, textos, arrays, decimales, excepciones; leer un fallo | 1 h 30 min |
| [02 · Tests parametrizados](2-practicas/ejercicio-02-tests-parametrizados/README.md) | De tres tests a uno con `@CsvSource`; valores límite que encuentran un error | 2 h |
| [03 · Depuración](2-practicas/ejercicio-03-depuracion/README.md) | Cuatro errores, cuatro técnicas: *stack trace*, NPE, `println`, `assert` y `jdb` | 2 h |

### Proyecto

Añades a tu sistema de gestión la clase `Rules`: retrasos, penalizaciones, cantidades y reservas. Dos de sus métodos llegan con errores que encuentras depurando; los otros dos los escribes tú, y añades tests parametrizados con los valores límite de tu dominio.
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
| Ejecutar un solo test | `./mvnw test -Dtest="RulesTest#penalty"` |
| Ejecutar los tests que empiezan por algo | `./mvnw test -Dtest="RulesTest#overdueDays*"` |
| Ver el informe completo de un test rojo | `cat target/surefire-reports/gestion.RulesTest.txt` |
| Probar una cuenta antes de escribir el esperado | `jshell` y `Math.round(2.5 * 100) / 100.0` |
| Activar los `assert` | `java -ea Main.java` |
| Depurar un test de Maven con `jdb` | `./mvnw test -Dtest="..." -Dmaven.surefire.debug` y en otra terminal `jdb -attach 5005` |
| Depurar en VS Code | `F9` pone un punto de ruptura, *Debug Test* arranca, `F10` avanza, `F5` continúa |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-03` con `Rules.java` corregido y completo, y `./mvnw test` en verde
2. ✅ Al menos 6 ejecuciones nuevas en `MyDomainTest.java` (un parametrizado y una excepción comprobada) y `App.java` con las reglas de tu dominio
3. ✅ Pull request `week-03` → `main` con la descripción del paso 11

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 78 tests y `Failures: 0, Errors: 0`; el segundo, mostrar tus registros, tu inventario y tus reglas. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 02](../week-02-control_metodos_strings_y_arrays/README.md) | **Semana 03** | Semana 04 |

← [Volver al inicio del bootcamp](../../README.md)
