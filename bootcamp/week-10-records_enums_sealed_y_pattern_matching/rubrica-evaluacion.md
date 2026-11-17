# Rúbrica de Evaluación — Semana 10: Records, enums, `sealed` y pattern matching

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 9 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Qué escribe Java por ti en `record Taken(String code, int left) {}`? ¿Cómo se llama el método que devuelve `left`? | 10 |
| 2 | ¿Por qué `new Taken("BK-042", 1).equals(new Taken("BK-042", 1))` da `true`, y con dos objetos de tu clase principal con los mismos datos da `false`? | 10 |
| 3 | En el constructor compacto de `Rejected`, ¿por qué no escribes `this.reason = reason`? ¿Cuándo se asignan los componentes? | 10 |
| 4 | ¿Por qué tu clase principal no es un record y `Taken` sí? | 10 |
| 5 | ¿Qué ventaja tiene `Level.LOW` sobre el texto `"bajo"`? ¿Qué pasa con `Level.valueOf("bajo")`? | 10 |
| 6 | El `switch` de `isAlert` no tiene `default`. Añades una quinta constante a `Level`. ¿Qué pasa al compilar? ¿Y si tuviera `default`? | 10 |
| 7 | ¿Qué hacen `sealed` y `permits` en `Outcome`? ¿Por qué `Taken` y `Rejected` no necesitan `final`? | 10 |
| 8 | ¿Qué hace `case Taken(String code, int left)`? ¿Y el `_` de `case Rejected(_, String reason)`? | 10 |
| 9 | En la semana 08, una cadena de `instanceof` era un error de diseño. ¿Por qué el `switch` de `Outcome.message` no lo es, si también pregunta el tipo? | 10 |
| 10 | ¿Por qué `Criterion` es una interfaz abierta y `Outcome` una sellada? ¿Qué crece en cada una? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Dos atributos `private final`, el constructor con los dos parámetros, los métodos de acceso `code()` y `left()`, y `equals`, `hashCode` y `toString` basados en los componentes. El de `left` se llama `left()`, como el componente, no `getLeft()`.
2. El `equals` de un record compara los componentes. Tu clase usa el `equals` de `Object`, que solo da `true` si es el mismo objeto. Lo cambiarás en la semana 11.
3. Porque Java asigna los componentes él mismo, al final del constructor compacto, si nada lanzó una excepción. Escribirlo da `cannot assign a value to final variable reason`. Ahí solo se valida o se cambia el parámetro.
4. Tu clase cambia después de crearse (`take()`, `restock()`), y dos entidades con los mismos datos siguen siendo dos entidades distintas. Un `Taken` no cambia: dice qué pasó, y dos con los mismos datos significan lo mismo.
5. Una errata en la constante (`Level.LWO`) no compila; en un texto (`"bjao"`) compila y falla en silencio. `Level.valueOf("bajo")` lanza `IllegalArgumentException`, porque busca el nombre de la constante (`LOW`), no su etiqueta.
6. No compila: `the switch expression does not cover all possible input values`, y te dice dónde falta el caso. Con `default`, la constante nueva caería en esa rama sin aviso.
7. `sealed` cierra la interfaz y `permits` dice qué clases pueden implementarla: solo `Taken` y `Rejected`. No necesitan `final` porque un record ya es `final`.
8. Comprueba que el objeto es un `Taken` y, si lo es, saca sus componentes a `code` y `left`. El `_` dice que el código del `Rejected` no se usa en esa rama.
9. Porque `Outcome` es sellada y el `switch` no tiene `default`: si llega un caso nuevo, el compilador obliga a tratarlo. La cadena de la semana 08 caía en el valor del final sin que nadie avisara.
10. Los criterios los escribe quien usa el inventario, y deben poder añadirse sin tocar nada: crecen las clases, y la interfaz es abierta. Los resultados son dos y casi no cambian; lo que crece son las operaciones sobre ellos (mostrar, contar, registrar), y el compilador vigila cada `switch`.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae los tests y los tipos del starter sin escribir; `tryTake`, los records, el enum y el `switch` llegan en commits posteriores | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`feat:`, `test:`), en la rama `week-10` creada desde un `main` con la semana 09 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest=OutcomeTest` y `./mvnw -q compile exec:java` | 10 |
| Explica sus decisiones | Dice por qué `Taken` y `Rejected` son records, por qué `Outcome` es sellada y por qué ningún `switch` tiene `default` | 8 |
| Predice en el momento | El instructor añade un tercer record a `permits` o una quinta constante a `Level`; el aprendiz dice qué deja de compilar y dónde antes de ejecutarlo | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 9

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Records y resultado | Los 12 tests de `OutcomeTest` pasan: `Taken` y `Rejected` validan en su constructor compacto, `Outcome` está sellada y `message` usa patrones de record sin `default` | 20 |
| Enum | Los 13 tests de `LevelTest` pasan, con `isAlert` escrito como un `switch` sin `default` | 15 |
| Inventario | Los tests de `InventoryTest` pasan: `tryTake` nunca lanza y sigue sin `instanceof` ni nombres de subclases | 15 |
| Tests propios | Al menos 3 tests nuevos en `MyDomainTest` con datos de su dominio: un rechazo de su subclase con reserva, un nivel con su capacidad y un patrón de record | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 a 09 intactos | 15 |
| Pull request | Rama `week-10`, descripción con lo pedido en el paso 12 | 20 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | Semana 11 |
