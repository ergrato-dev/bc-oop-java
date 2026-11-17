# Rúbrica de Evaluación — Semana 08: Polimorfismo

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 7 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | En `Book b = new AudioBook(...)`, ¿cuál es el tipo estático y cuál el dinámico? ¿Qué decide cada uno? | 10 |
| 2 | ¿Por qué `b.getMinutes()` no compila si el objeto tiene ese método? | 10 |
| 3 | ¿Por qué `Book b = new RareBook(...)` compila y `RareBook r = new Book(...)` no? | 10 |
| 4 | `card()` solo está en `Book` y llama a `describe()`. ¿Qué `describe()` se ejecuta con un `RareBook`? Explica la búsqueda | 10 |
| 5 | Con `kind(Book)` y `kind(RareBook)` sobrecargados y `Book b = new RareBook(...)`, ¿qué método elige `kind(b)`? ¿Y `b.kind()` si `kind()` está sobrescrito? | 10 |
| 6 | ¿Por qué un método `static` no tiene polimorfismo? ¿Qué pasa si le pones `@Override`? | 10 |
| 7 | ¿Por qué `(RareBook) ficciones` compila y lanza `ClassCastException` al ejecutar? | 10 |
| 8 | ¿Qué dos cosas hace `book instanceof RareBook rareBook`? ¿Dónde existe `rareBook`? | 10 |
| 9 | Una cadena de `instanceof` devuelve los días de préstamo. Llega `Magazine`. ¿Qué pasa, y por qué no avisa nadie? ¿Cómo lo arreglas con polimorfismo? | 10 |
| 10 | ¿Por qué tu `Inventory` no necesita cambiar si escribes una tercera subclase? ¿Qué método de cada objeto usa `availableCount()`? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Estático, `Book` (la variable); dinámico, `AudioBook` (el objeto). El estático decide qué métodos se pueden llamar, al compilar; el dinámico, qué cuerpo se ejecuta, al ejecutar.
2. El compilador mira la variable, y `Book` no tiene `getMinutes()`. No sabe qué objeto habrá dentro al ejecutar.
3. Todo `RareBook` es un `Book` (*upcasting*, automático). Un `Book` cualquiera no es un `RareBook`: no tiene sala, y la variable `RareBook` promete que la tiene.
4. El de `RareBook`. Dentro de `card()`, `describe()` es `this.describe()`, y la búsqueda empieza por la clase del objeto, `RareBook`, donde está sobrescrito.
5. `kind(b)` elige `kind(Book)`: la sobrecarga la decide el compilador con el tipo de la variable. `b.kind()` ejecuta el de `RareBook`: la sobrescritura la decide el objeto.
6. Porque pertenece a la clase, no al objeto: no hay objeto que elija, y se resuelve con el tipo de la variable. El de la hija oculta al del padre. Con `@Override` no compila: `static methods cannot be annotated with @Override`.
7. El compilador acepta el *cast* porque una variable `Book` podría tener un `RareBook` dentro. Al ejecutar, la JVM ve que el objeto es un `Book` normal y lanza la excepción.
8. Comprueba si el objeto es un `RareBook` y, si lo es, declara `rareBook` ya convertida. Solo existe donde la comprobación es verdadera, dentro del `if`.
9. `Magazine` no tiene rama y cae en el valor del final (14) en silencio: ni el compilador ni la JVM saben que faltaba una rama. Se arregla con un `loanDays()` en `Book` sobrescrito en cada hija; `Magazine` escribe el suyo y nadie más cambia.
10. Porque solo llama a métodos de tu clase (`isAvailable()`, `toString()`) y cada objeto responde con su versión. `availableCount()` usa el `isAvailable()` del objeto: con reserva, el de la subclase; con salidas, el heredado de tu clase.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae los tests y la subclase del starter sin implementar; los métodos del inventario y la subclase llegan en commits posteriores | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`feat:`, `test:`), en la rama `week-08` creada desde un `main` con la semana 07 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest=Tracked<Clase>Test` y `./mvnw -q compile exec:java` | 10 |
| Explica sus decisiones | Dice qué cuenta `taken` en su dominio, por qué `take()` cuenta después de `super.take()` y por qué su `Inventory` no pregunta el tipo | 8 |
| Predice en el momento | El instructor mezcla las tres clases en un array de su clase y llama a `take()`, `isAvailable()` o `println`; el aprendiz dice qué versión se ejecuta y qué imprime antes de ejecutarlo | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 7

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Inventario | Los tests de `InventoryTest` pasan: `availableCount()` y `report()` escritos sin `instanceof`, `getClass` ni nombres de subclases | 20 |
| Subclase | Los 12 tests de `Tracked<Clase>Test` pasan, con su clase en lugar de `Entity` | 20 |
| Reutilización | `take()` y `describe()` usan `super`; la subclase con salidas hereda de su clase, no de la subclase con reserva, y no repite atributos | 15 |
| Tests propios | Al menos 3 tests nuevos en `MyDomainTest` con datos de su dominio: las salidas, un array con las dos subclases y el inventario | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 a 07 intactos | 10 |
| Pull request | Rama `week-08`, descripción con lo pedido en el paso 11 | 20 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | [Semana 09](../week-09-clases_abstractas_e_interfaces/README.md) |
