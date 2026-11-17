# Semana 02 — Control de flujo, métodos, `String` y arrays

> La semana 01 trataba un registro, de arriba abajo y sin decisiones. Esta semana tu programa decide (`if`, `switch`), repite (`while`, `for`), se organiza en métodos propios y maneja varios registros a la vez en arrays. Son las piezas con las que se escribe el cuerpo de cualquier método durante el resto del curso.

Todavía no hay clases propias: los datos de varios registros viajan en arrays paralelos. Su fragilidad es justo lo que resolverán los objetos de la semana 05.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Escribir** condiciones con `if / else if / else`, operadores lógicos y `switch` como expresión, en el orden correcto
- **Elegir** entre `while`, `for` y for-each, y **aplicar** los patrones acumulador, contador y búsqueda lineal
- **Declarar y llamar** métodos con parámetros y retorno, **sobrecargarlos** y **explicar** por qué Java pasa copias
- **Buscar, trocear y construir** texto con los métodos de `String` y con `StringBuilder`
- **Crear, recorrer y copiar** arrays sin salirte de sus límites, y **distinguir** copiar de asignar

---

## 📋 Prerrequisitos

- [Semana 01](../week-01-entorno_jdk_maven_jshell_y_tipos/README.md): entorno, `./mvnw` y tipos.
- Tu *pull request* `week-01` fusionado en `main`.

---

## 🗂️ Estructura de la Semana

```
week-02-control_metodos_strings_y_arrays/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 4 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 1 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Condicionales y `switch`](1-teoria/01-condicionales-y-switch.md) | `if / else`, orden de las condiciones, operadores lógicos, cortocircuito, `switch` expresión, `yield`, ternario | 45 min |
| [02 · Bucles](1-teoria/02-bucles.md) | `while`, `for`, for-each, `break`, `continue`, acumulador, contador y búsqueda | 45 min |
| [03 · Métodos](1-teoria/03-metodos.md) | Firma, retorno, sobrecarga, paso por valor, ámbito | 45 min |
| [04 · `String` y `StringBuilder`](1-teoria/04-string-y-stringbuilder.md) | Posiciones, `substring`, `split`, `char`, inmutabilidad, `StringBuilder`, bloques de texto | 45 min |
| [05 · Arrays](1-teoria/05-arrays.md) | Crear, leer, límites, referencias, `java.util.Arrays`, arrays paralelos, `args` | 1 h |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Condicionales y `switch`](2-practicas/ejercicio-01-condicionales-y-switch/README.md) | `if`, cortocircuito con `null`, `switch` con flechas y `yield`, ternario, un error de orden | 1 h 30 min |
| [02 · Bucles y arrays](2-practicas/ejercicio-02-bucles-y-arrays/README.md) | `while`, `for`, for-each, `break`, `continue`, copiar frente a asignar, salirse del array | 2 h |
| [03 · Métodos y `String`](2-practicas/ejercicio-03-metodos-y-string/README.md) | Métodos propios, sobrecarga, paso por valor, `split`, `substring`, `StringBuilder`, `charAt` | 2 h |

### Proyecto

Añades a tu sistema de gestión la clase `Stock`: leer una lista de códigos, validarlos, buscarlos, sumar y clasificar cantidades y sacar un informe del inventario de tu dominio.
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
| ----- | ---- |
| Probar un `substring` o un `split` antes de escribirlo | `jshell` y `"BK-042".substring(0, 2)` |
| Ver un array en JShell | `jshell` muestra `int[3] { 4, 0, 7 }` al evaluarlo; en código, `Arrays.toString` |
| Parar un bucle infinito | `Ctrl+C` |
| Ejecutar los tests de un método | `./mvnw test -Dtest="StockTest#level*"` |
| Ejecutar los tests de varias clases | `./mvnw test -Dtest="FieldsTest+MyDomainTest"` |
| Ver la variable `i` en cada vuelta | Añade un `IO.println("i=" + i)` temporal y bórralo después; la semana 03 te enseña el depurador |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-02` con `Stock.java` completo y `./mvnw test` en verde
2. ✅ Al menos 5 tests nuevos en `MyDomainTest.java` y `App.java` con el inventario de tu dominio
3. ✅ Pull request `week-02` → `main` con la descripción del paso 11

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 40 tests y `Failures: 0, Errors: 0`; el segundo, mostrar tus registros de la semana 01 y el informe de tu inventario. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 01](../week-01-entorno_jdk_maven_jshell_y_tipos/README.md) | **Semana 02** | [Semana 03](../week-03-tests_junit_assertj_y_depuracion/README.md) |

← [Volver al inicio del bootcamp](../../README.md)
