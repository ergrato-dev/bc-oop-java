# Rúbrica de Evaluación — Semana 03: Tests con JUnit y AssertJ; depuración

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 2 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Qué tres partes tiene un test? Señálalas en `assertThat(Shelf.free(10, 3)).isEqualTo(7);` | 10 |
| 2 | ¿Qué diferencia hay entre un *failure* y un *error* en el resumen de Surefire? Pon un ejemplo de cada uno | 10 |
| 3 | ¿Por qué `assertThat(1 * 100.0 / 3).isEqualTo(33.33)` falla y cómo lo escribes bien? | 10 |
| 4 | ¿Por qué `assertThatThrownBy` recibe `() -> Rules.parseQuantity("12a")` y no `Rules.parseQuantity("12a")`? | 10 |
| 5 | Una regla dice "de 8 a 30 días, grave". ¿Qué valores límite pruebas y por qué no basta con el 20? | 10 |
| 6 | ¿Qué valor recibe el parámetro con las filas `"' 12 ', 12"` y `", 0"` de un `@CsvSource`? | 10 |
| 7 | En `at Main.average(Main.java:7)` seguido de `at Main.main(Main.java:36)`, ¿dónde saltó la excepción y quién llamó? ¿El error está siempre en la línea 7? | 10 |
| 8 | ¿Qué hace `assert x >= 0 : "negativo";` si ejecutas sin `-ea`? ¿Por qué no sirve para validar datos del usuario? | 10 |
| 9 | En el depurador, ¿qué diferencia hay entre *step over* y *step into*? ¿Y qué hace *continue*? | 10 |
| 10 | ¿Por qué `Math.round(250.0) / 100` da `2` y cómo lo arreglas? ¿Por qué los tests de `penalty` con resultado entero no lo detectaban? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Preparar (los datos: `10` y `3`), actuar (la llamada: `Shelf.free(10, 3)`) y comprobar (`isEqualTo(7)`). En un test corto caben en una línea.
2. Un *failure* es una aserción que no se cumple: `expected: 3 but was: 7`. Un *error* es una excepción inesperada que impide llegar a comparar: un `UnsupportedOperationException` de un *stub* o un `NullPointerException`. Los dos ponen el *build* en rojo.
3. El resultado es `33.333333333333336`, no `33.33`: un `double` calculado casi nunca coincide al último decimal. Se compara con margen: `isCloseTo(33.33, within(0.01))`.
4. Sin lambda, Java ejecutaría `parseQuantity` antes de llamar a `assertThatThrownBy` y le pasaría el `int` que devuelve; ni siquiera compila (`no suitable method found for assertThatThrownBy(int)`). Con la lambda, AssertJ recibe código sin ejecutar, lo ejecuta él y captura la excepción.
5. Los dos lados de cada frontera: 7 y 8, 30 y 31. El 20 está en el centro: con un `<` donde iba `<=`, el 20 sigue pasando y el borde falla.
6. `" 12 "`, con los espacios, porque las comillas simples los conservan; y `null`, porque un valor vacío sin comillas es `null`.
7. Saltó en `average`, línea 7; la llamó `main` desde la línea 36. No: la 7 es donde se manifiesta. La causa puede estar en quien pasó los datos (un array vacío desde la 36) o en que `average` no contempla ese caso.
8. Nada: sin `-ea` los `assert` están apagados y en producción suelen estarlo. Para rechazar datos del usuario hay que lanzar siempre una excepción, como `IllegalArgumentException`.
9. *Step over* ejecuta la línea entera (incluidas las llamadas que haga) y para en la siguiente; *step into* entra en el método que llama la línea. *Continue* sigue hasta el siguiente punto de ruptura o hasta el final.
10. `Math.round` devuelve un `long` y `/ 100` divide dos enteros: se descartan los decimales. Se arregla dividiendo entre `100.0`. Con resultados enteros (`2.0`, `10.0`) no hay decimales que perder, así que esos tests pasaban; solo las filas con decimales lo destapan.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae `Rules.java` y `RulesTest.java` del starter sin cambios; los siguientes, un arreglo o un método cada uno | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`fix:` para los errores, `feat:` para los métodos, `test:` para los tests), en la rama `week-03` creada desde un `main` con la semana 02 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest="RulesTest#penalty*"` y `./mvnw -q compile exec:java` | 10 |
| Explica sus tests | Justifica las filas de su parametrizado: qué clase de equivalencia o qué límite cubre cada una | 8 |
| Depura en el momento | El instructor introduce un error en `Rules`; el aprendiz lo localiza con el test que falla y el depurador o un `println`, y lo arregla | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 2

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Reglas | Los 4 métodos de `Rules` pasan los 32 tests de `RulesTest`, con los dos errores del starter corregidos | 30 |
| Tests propios | Al menos 6 ejecuciones nuevas con valores del dominio calculados a mano: un parametrizado con el último día del plazo y el primero de retraso, una penalización con decimales, una en el tope y una excepción con `assertThatThrownBy` | 30 |
| Dominio | `App.java` muestra las reglas con un plazo, una tarifa y un tope que tienen sentido en el dominio | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 y 02 intactos | 10 |
| Código | `parseQuantity` comprueba `null` antes de usar el texto; `canReserve` es una expresión `boolean` sin `if` innecesarios; sin `println` ni `assert` olvidados | 10 |
| Pull request | Rama `week-03`, descripción con lo pedido en el paso 11, incluida la técnica usada para cada error | 5 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | [Semana 04](../week-04-analisis_requisitos_casos_de_uso_y_dominio/README.md) |
