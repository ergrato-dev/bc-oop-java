# Rúbrica de Evaluación — Semana 06: Encapsulación, constructores y composición

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 5 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Qué es encapsular? ¿Qué ventaja tiene, cuando un objeto aparece en mal estado, que sus atributos sean `private`? | 10 |
| 2 | ¿Quién puede usar un miembro `private`? ¿Y uno sin modificador? ¿Puede un método de `Book` leer el atributo `private` de otro `Book`? | 10 |
| 3 | Una clase tiene sus atributos `private` y un `setCopies(int)` que asigna sin comprobar. ¿Está encapsulada? ¿Qué método la protegería mejor? | 10 |
| 4 | ¿Por qué el constructor de tu clase lanza `IllegalArgumentException` y `take()` lanza `IllegalStateException`? | 10 |
| 5 | Si `new Book("???", "Ficciones", 2)` lanza una excepción, ¿qué valor tiene `b` en `Book b = new Book(...)`? ¿Existe algún libro con código `"???"`? | 10 |
| 6 | ¿Por qué se comprueba todo antes de asignar nada? Pon un ejemplo de lo que pasa si un método asigna y luego comprueba | 10 |
| 7 | ¿Qué hace `this(code, name, 0)`? ¿Qué ventaja tiene sobre copiar las asignaciones en el segundo constructor? | 10 |
| 8 | Con `final Book b = new Book("BK-1", "A", 1);`, ¿compila `b.take()`? ¿Y `b = null`? ¿Qué fija `final` en una variable de tipo objeto? | 10 |
| 9 | ¿Qué es una composición? ¿Por qué "no hay dos entidades con el mismo código" es una regla de `Inventory` y no de tu clase? | 10 |
| 10 | ¿Qué diferencia hay entre `return items;` y `return Arrays.copyOf(items, size);`? Con la copia, ¿puede alguien cambiar las unidades de una entidad del inventario? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Juntar los datos y las reglas que los protegen en una clase, y esconder los datos para que solo cambien a través de sus métodos. Si un objeto aparece en mal estado, el error solo puede estar dentro de su clase: no hay que buscar en todo el programa.
2. `private`: solo la propia clase. Sin modificador: las clases del mismo paquete. Sí: la frontera de `private` es la clase, no el objeto.
3. No: `setCopies(-5)` hace lo mismo que `copies = -5`. La protegen órdenes del dominio con su regla, como `take()` y `restock(n)`, o al menos un *setter* que valide.
4. En el constructor falla un **argumento** que se pasó a `new`. En `take()` no hay argumento que falle: falla el **estado** del objeto, que no tiene unidades.
5. `b` no recibe ningún valor: la excepción sale antes de la asignación (y si nadie la captura, el programa se detiene ahí). No existe ningún libro con `"???"`: el constructor no llegó a asignar nada.
6. Para que, si algo falla, el objeto quede como estaba. Si `change` asigna el código nuevo y luego rechaza los ejemplares, el objeto se queda con el código nuevo y los ejemplares viejos: una mezcla que nadie pidió.
7. Llama al constructor de tres parámetros de la misma clase. Las comprobaciones y asignaciones están en un solo sitio: una regla nueva vale para los dos constructores.
8. `b.take()` sí: cambia el objeto. `b = null` no: `final` fija la referencia (la flecha), no el estado del objeto.
9. Un objeto que tiene otros objetos en sus atributos. Una entidad no ve a las demás: solo quien las guarda todas puede saber si un código ya está.
10. `return items` reparte la referencia al array del inventario: quien la recibe puede poner `null` o meter entidades sin pasar por `add`. La copia es otro array: cambiarla no toca el inventario. Sus posiciones apuntan a las mismas entidades, así que `copia[0].take()` sí cambia una; pero solo a través de `take()`, que no deja bajar de 0.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae los tests y el `Inventory` del starter sin implementar; los cambios de la clase y del inventario llegan en commits posteriores | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`feat:`, `test:`), en la rama `week-06` creada desde un `main` con la semana 05 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest=InventoryTest` y `./mvnw -q compile exec:java` | 10 |
| Explica sus decisiones | Dice qué atributos son `final` y por qué, qué *getters* tiene y por qué no tiene *setters*, y qué regla del dominio protege cada comprobación del constructor | 8 |
| Predice en el momento | El instructor escribe tres líneas que tocan un atributo `private`, reasignan una variable `final` o cambian la copia de `items()`; el aprendiz dice si compilan y qué imprimen antes de ejecutarlas | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 5

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Clase encapsulada | Los 41 tests de su clase pasan: atributos `private`, `code` y `name` `final`, *getters*, ningún *setter*, constructor que valida y segundo constructor con `this(...)` | 25 |
| Inventario | Los 14 tests de `InventoryTest` pasan, con su clase en lugar de `Entity` | 20 |
| Reutilización | El constructor usa `Fields.normalizeCode` y `Stock.isValidCode`; `Inventory` usa `indexOf` y `total` de su clase y delega `take` | 15 |
| Tests propios | Al menos 3 tests nuevos en `MyDomainTest` con datos de su dominio: una validación, el constructor corto y un inventario | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 a 05 intactos (o con sus datos corregidos si creaban objetos inválidos) | 10 |
| Pull request | Rama `week-06`, descripción con lo pedido en el paso 13, incluidas las reglas del constructor con datos de su dominio | 15 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | [Semana 07](../week-07-herencia/README.md) |
