# Rúbrica de Evaluación — Semana 02: Control de flujo, métodos, `String` y arrays

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 1 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | Una cadena `if` pregunta primero `copies < 5` y después `copies == 0`. ¿Qué imprime con `copies = 0` y cómo la arreglas? | 10 |
| 2 | ¿Por qué `code != null && code.length() == 6` es seguro con `code = null` y con `&` no lo es? | 10 |
| 3 | ¿Qué ventajas tiene el `switch` con `->` frente al antiguo con `case X:` y `break`? ¿Cuándo necesitas `yield`? | 10 |
| 4 | ¿Cuándo eliges `while`, `for` clásico o for-each? Pon un ejemplo de tu proyecto para cada uno de los dos últimos. | 10 |
| 5 | Un `for` usa `i <= codes.length`. ¿Qué pasa y por qué? | 10 |
| 6 | `int[] b = a; b[0] = 9;` ¿Cambia `a[0]`? ¿Cómo copias un array de verdad? | 10 |
| 7 | Un método recibe un `int` y un `int[]` y pone ambos a 0. ¿Qué ve quien lo llamó, y por qué? | 10 |
| 8 | ¿Qué es la sobrecarga? ¿Compilan juntos `int total(int[] a)` y `double total(int[] a)`? | 10 |
| 9 | ¿Qué dan `"BK-042".substring(0, 2)`, `"BK-042".indexOf('-')` y `"".split(",").length`? | 10 |
| 10 | ¿Por qué `report` usa `StringBuilder` en lugar de `+` dentro del bucle? ¿Por qué `code.strip();` en una línea suelta no hace nada? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Imprime el mensaje de "quedan pocas", porque `0 < 5` es `true` y gana el primer bloque que se cumple. Se arregla poniendo primero la condición más estrecha, `copies == 0`.
2. `&&` hace cortocircuito: si `code != null` es `false`, no evalúa la parte derecha y `code.length()` no se llama. `&` evalúa siempre los dos lados, llama a `length()` sobre `null` y lanza `NullPointerException`.
3. Es una expresión que devuelve un valor, no se cuela al caso siguiente (no hay `break` que olvidar), admite varias etiquetas con comas y el compilador exige que cubra todos los casos. `yield` hace falta cuando un caso es un bloque `{ }` con varias sentencias y tiene que devolver un valor.
4. `while` cuando no sabes cuántas vueltas habrá. `for` clásico cuando necesitas la posición: `indexOf`, `report` (dos arrays con el mismo índice) o `missing` (escribe en una posición). for-each cuando solo necesitas los valores: `total`.
5. En la última vuelta `i` vale `length` y `codes[length]` no existe: `ArrayIndexOutOfBoundsException`. Las posiciones van de `0` a `length - 1`, así que la condición es `i < codes.length`.
6. Sí: `b = a` copia la flecha y las dos variables apuntan al mismo array. Para copiar los datos: `Arrays.copyOf(a, a.length)`, que crea un array nuevo.
7. El `int` no cambia: el método recibió una copia del número. El array sí: el método recibió una copia de la flecha, que apunta al mismo array. Java pasa siempre por valor, y el valor de una referencia es la flecha.
8. Varios métodos con el mismo nombre y distintos parámetros (en número o tipo); Java elige por los argumentos. No compilan: tienen los mismos parámetros y el tipo de retorno no basta para distinguirlos.
9. `"BK"` (de 0 a 2 sin incluir el 2), `2` y `1`: `"".split(",")` da un array con un elemento vacío, `[""]`.
10. Un `String` es inmutable: `+` en un bucle crea un texto nuevo en cada vuelta; `StringBuilder` acumula en el mismo objeto. `strip()` no modifica `code`: devuelve un texto nuevo, y si no lo guardas (`code = code.strip()`) se pierde.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El historial muestra `Stock.java` del starter en rojo y después los commits que lo ponen en verde | 8 |
| Commits con sentido | Commits pequeños, con Conventional Commits, en la rama `week-02` creada desde un `main` con la semana 01 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test` y `./mvnw -q compile exec:java` | 10 |
| Explica su código | Recorre en voz alta `isValidCode` con `"BK--042"` y `level` con un cuarto exacto de su capacidad | 8 |
| Depura en el momento | El instructor cambia un `<` por `<=` en un bucle; lee el *stack trace* o el test que falla y lo arregla | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 1

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Métodos | Los 7 métodos de `Stock` pasan los 18 tests de `StockTest` | 30 |
| Tests propios | Al menos 5 tests nuevos con códigos y cantidades del dominio, calculados a mano, que cubren los casos del paso 10 | 30 |
| Dominio | `App.java` muestra el informe del inventario del dominio, con una capacidad que tiene sentido en él | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de la semana 01 intactos | 10 |
| Código | `missing` no modifica su entrada; `report` reutiliza `level`; sin código repetido entre métodos | 10 |
| Pull request | Rama `week-02`, descripción con lo pedido en el paso 11 | 5 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | [Semana 03](../week-03-tests_junit_assertj_y_depuracion/README.md) |
