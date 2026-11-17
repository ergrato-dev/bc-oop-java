# Ejercicio 03 — Sealed y pattern matching

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-tipos-sellados.md) y [04](../../1-teoria/04-pattern-matching.md)

## Objetivo

Recorrer una jerarquía **sellada**, en la que solo unas clases concretas pueden implementar la interfaz, con **patrones**: un `instanceof` y un `switch` que comprueban el tipo y desmontan el record en sus componentes en un solo paso. Ves que el compilador avisa cuando falta un caso, ordena los casos con condición y no deja entrar en la jerarquía a una clase que no está en la lista. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-10-records_enums_sealed_y_pattern_matching/2-practicas/ejercicio-03-sealed-y-pattern-matching/starter
java Main.java
```

No imprime nada. `main` ya crea un mostrador con dos libros (uno de 1500 páginas), una revista y un DVD. Lee las piezas de debajo:

- `sealed interface Item permits Book, Magazine, Dvd`: solo esas tres clases pueden ser un `Item`.
- Tres records que la implementan. Su `code()` cumple el `code()` de `Item`.
- `describe(Item item)`: un `switch` con un caso por clase.
- `loanDays` y `record Poster`, comentados, para los pasos 4 y 5.

Los números de línea de este README cuentan con que no añades ni quitas líneas, salvo donde el paso 5 te pide añadirlas.

## Pasos

### 1. `instanceof` con un patrón de record

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042: Ficciones, 240 páginas
BK-500: Los miserables, 1500 páginas
```

En la semana 08, `item instanceof Book book` comprobaba el tipo y declaraba `book`. `item instanceof Book(String code, String title, int pages)` va un paso más allá: si es un `Book`, saca sus tres componentes a tres variables. Es un **patrón de record**. La revista y el DVD no son `Book` y no entran en el `if`.

### 2. Un switch con un caso por clase

Descomenta el **PASO 2** y ejecuta. Las cuatro últimas líneas:

```
BK-042 · libro · Ficciones · 240 páginas
BK-500 · libro · Los miserables · 1500 páginas
RV-007 · revista · número 512
DV-010 · DVD · 153 minutos
```

Lee `describe` (líneas 54 a 61). El `switch` recibe un `Item` y cada `case` es un patrón: el primero que encaja con el objeto se ejecuta. No hay `default`, y compila: `Item` es `sealed`, así que el compilador sabe que todo `Item` es un `Book`, una `Magazine` o un `Dvd`, y que los tres casos lo cubren todo.

### 3. Un case de menos

Pon `//` delante de la línea 59, la del `case Dvd`, y ejecuta:

```
Main.java:55: error: the switch expression does not cover all possible input values
        return switch (item) {
               ^
```

Un DVD llegaría al `switch` sin respuesta, y el compilador lo ve antes de ejecutar. Compáralo con la cadena de `instanceof` de la semana 08, que caía en el valor del final sin avisar. Quita el `//` de la línea 59.

### 4. Casos con condición, `when`

Descomenta el método `loanDays` (líneas 64 a 71) y las líneas del **PASO 4** en `main`. Ejecuta. Las cuatro últimas líneas:

```
BK-042: 21 días
BK-500: 30 días
RV-007: 7 días
DV-010: 3 días
```

`case Book book when book.pages() > 1000` solo encaja si el libro es un `Book` **y** la condición se cumple: el de 1500 páginas se presta 30 días, el resto de libros cae en `case Book _`. El `_` dice que el caso no usa la variable: solo importa el tipo.

Ahora intercambia las líneas 66 y 67, para que `case Book _` vaya primero, y ejecuta:

```
Main.java:67: error: this case label is dominated by a preceding case label
            case Book book when book.pages() > 1000 -> 30;
                 ^
```

`case Book _` acepta todos los libros, así que el caso con `when` nunca se ejecutaría. Los casos se prueban en orden, y el más concreto va primero. Vuelve a dejar las dos líneas como estaban.

### 5. Una clase que no está en la lista

Descomenta el record `Poster`, al final del archivo (línea 87), y la línea del **PASO 5** en `main`. Ejecuta:

```
Main.java:87: error: class is not allowed to extend sealed class: Item (as it is not listed in its 'permits' clause)
record Poster(String code, String film) implements Item {}
^
```

`Item` dice quiénes pueden implementarla, y `Poster` no está. Añádelo a la lista de la línea 75:

```java
sealed interface Item permits Book, Magazine, Dvd, Poster {
```

Ejecuta otra vez:

```
Main.java:55: error: the switch expression does not cover all possible input values
Main.java:65: error: the switch expression does not cover all possible input values
```

Ahora `Poster` es un `Item`, y el compilador te lleva a los dos `switch` que no saben qué hacer con él. Debajo del `case Dvd` de `describe`, añade:

```java
            case Poster(String code, String film) -> code + " · cartel · " + film;
```

y debajo del `case Dvd _` de `loanDays`:

```java
            case Poster _ -> 14;
```

Ejecuta. La última línea:

```
PS-001 · cartel · Metrópolis
```

Esta es la ventaja de sellar: añadir un tipo te obliga a revisar cada sitio que decide por tipo, y el compilador te dice cuáles son.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `the switch expression does not cover all possible input values` en la línea 55, antes del paso 5 | Es la prueba del paso 3: quita el `//` de la línea 59 |
| `this case label is dominated by a preceding case label` | Es la prueba del paso 4: el `case Book book when ...` va antes que `case Book _` |
| `class is not allowed to extend sealed class: Item` | Es el error del paso 5: añade `Poster` a `permits` en la línea 75 |
| `cannot find symbol ... method loanDays(Item)` | Descomentaste las líneas del paso 4 sin el método `loanDays` |
| `incorrect number of nested patterns` | El patrón de record no tiene un componente por cada uno del record: `Book(String code, String title, int pages)` lleva tres |
| `incompatible types: int cannot be converted to String` en un patrón | Los componentes del patrón van en el orden del record y con su tipo: en `Book`, el `int` es el tercero |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Enums](../ejercicio-02-enums/README.md) | **Ejercicio 03 · Sealed y pattern matching** | [Proyecto · Gestión, capa 9](../../3-proyecto/README.md) |
