# Rúbrica de Evaluación — Semana 09: Clases abstractas e interfaces

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 8 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Por qué no se puede escribir `new LibraryItem(...)` si `LibraryItem` tiene constructor? ¿Quién lo llama? | 10 |
| 2 | Una clase hereda de una abstracta y no escribe su método abstracto. ¿Qué dice el compilador y qué dos salidas tienes? | 10 |
| 3 | En un método plantilla, ¿para qué sirve el `final`? ¿Qué diferencia hay entre un hueco abstracto y uno con cuerpo vacío? | 10 |
| 4 | ¿Por qué `Laptop` implementa `Loanable` en lugar de heredar de `LibraryItem`? | 10 |
| 5 | Con `Loanable l = new Book(...)`, ¿por qué `l.author()` no compila si el objeto tiene ese método? | 10 |
| 6 | ¿Por qué una clase puede implementar varias interfaces y solo heredar de una clase? | 10 |
| 7 | ¿Qué diferencia hay entre un método `default` y uno `static` de una interfaz? ¿Cómo se llama cada uno? | 10 |
| 8 | Una clase implementa dos interfaces con un `default String label()`. ¿Qué pasa al compilar y cómo lo arreglas? | 10 |
| 9 | Escribes `int loanDays()` sin `public` en una clase que implementa `Loanable`. ¿Qué pasa y por qué? | 10 |
| 10 | ¿Por qué `Criterion` es una interfaz y no una clase abstracta? ¿Qué gana tu `Inventory` al recibir un `Criterion`? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Porque es `abstract`: no pueden existir objetos que sean solo `LibraryItem`, que tiene métodos sin cuerpo. Su constructor lo llaman las hijas con `super(...)`, cada vez que se crea una.
2. `X is not abstract and does not override abstract method m() in Padre`. O la hija escribe el método, o la hija también se declara `abstract`.
3. Impide que las hijas sobrescriban el esqueleto, así que el formato es el mismo para todas. Un hueco abstracto **hay** que escribirlo (el padre no sabe la respuesta); uno con cuerpo vacío **se puede** sobrescribir si la hija tiene algo que añadir.
4. Porque un portátil no es un artículo de la biblioteca (no tiene título, no comparte sus datos): solo comparte la capacidad de prestarse. Eso es una interfaz.
5. El compilador mira la variable, y `Loanable` solo promete `code()` y `loanDays()`.
6. Una clase padre trae atributos y constructor; con dos padres habría atributos y constructores en conflicto. Una interfaz no tiene estado, así que firmar varias no crea ese problema.
7. Un `default` es un método de cada objeto con una respuesta por defecto: se hereda, se puede sobrescribir y se llama con un objeto (`criterion.count(items)`). Un `static` es de la interfaz: no se hereda y se llama con su nombre (`Criterion.any(...)`), nunca a través de una variable.
8. No compila: `class X inherits unrelated defaults for label() from types A and B`. La clase escribe su propio `label()` y, si quiere, usa `A.super.label()` o `B.super.label()`.
9. No compila: `attempting to assign weaker access privileges; was public`. Los métodos de una interfaz son `public` aunque no se escriba, y la clase no puede hacerlos menos visibles.
10. Los criterios no comparten datos ni forman una familia, solo la capacidad de aceptar o no una entidad; el código común (`count`) cabe en un `default`. El inventario funciona con cualquier criterio, también con los que se escriban después, sin cambiar.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae los tests y los criterios del starter sin implementar; `select`, `count` y los criterios llegan en commits posteriores | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`feat:`, `test:`), en la rama `week-09` creada desde un `main` con la semana 08 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest=CriterionTest` y `./mvnw -q compile exec:java` | 10 |
| Explica sus decisiones | Dice qué regla de su dominio expresa su criterio propio, por qué `Criterion` es una interfaz y por qué `count` es `default` | 8 |
| Diseña en el momento | El instructor propone un criterio nuevo de su dominio; el aprendiz dice qué clase escribiría, qué método, y por qué su `Inventory` no cambia | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 8

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Inventario | Los tests de `InventoryTest` pasan: `select` y `count` reciben un `Criterion`, sin nombrar ningún criterio concreto | 20 |
| Criterios | Los 12 tests de `CriterionTest` pasan, con su clase en lugar de `Entity` | 20 |
| Interfaz | `Criterion` es una interfaz con `accepts` sin cuerpo y `count` como `default`; los dos criterios la implementan y solo escriben lo suyo | 15 |
| Tests propios | Al menos 3 tests nuevos en `MyDomainTest` con datos de su dominio, uno con un criterio propio escrito como clase | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 a 08 intactos | 10 |
| Pull request | Rama `week-09`, descripción con lo pedido en el paso 12 | 20 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | [Semana 10](../week-10-records_enums_sealed_y_pattern_matching/README.md) |
