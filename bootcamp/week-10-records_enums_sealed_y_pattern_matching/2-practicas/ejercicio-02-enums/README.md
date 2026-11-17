# Ejercicio 02 — Enums

⏱️ 2 h · Teoría previa: [02](../../1-teoria/02-enums.md)

## Objetivo

Cambiar un dato que solo puede tomar unos pocos valores, guardado como texto, por un **enum**: un tipo con sus valores escritos en la declaración y ninguno más. Ves que un valor mal escrito deja de compilar, que cada constante guarda sus propios datos, cómo convertir un texto en constante y cómo el compilador vigila que un `switch` cubra todas. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-10-records_enums_sealed_y_pattern_matching/2-practicas/ejercicio-02-enums/starter
java Main.java
```

No imprime nada. Lee las piezas de `Main.java`:

- `daysFor(String format)`: los días de préstamo de un formato escrito como texto.
- `enum Format`: los tres formatos de la biblioteca, `PAPER`, `EBOOK` y `AUDIO`. Cada constante lleva entre paréntesis sus días, que guarda el constructor.
- Un método `place`, comentado, que usarás en el paso 5.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Un formato como texto

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
papel: 21 días
Papel: 14 días
pdf: 14 días
```

`"Papel"` con mayúscula no es `"papel"`, y `"pdf"` no es ningún formato de la biblioteca, pero los dos compilan y los dos reciben 14 días sin que nadie avise. Con un `String`, el compilador no sabe qué textos valen.

### 2. El mismo formato, como enum

Descomenta el **PASO 2** y ejecuta. Las cuatro últimas líneas:

```
PAPER: 21 días
0 · PAPER · 21 días
1 · EBOOK · 7 días
2 · AUDIO · 14 días
```

`Format.PAPER` es un objeto, el único `PAPER` que existe, y tiene sus días: `PAPER(21)` llamó al constructor de `Format` con un 21. `Format.values()` devuelve las tres constantes en el orden en que se declararon, y `ordinal()` dice la posición de cada una. `println` muestra su nombre.

### 3. Un valor que no existe no compila

Descomenta la línea del **PASO 3** y ejecuta:

```
Main.java:28: error: cannot find symbol
        Format wrong = Format.PAPPER;
                             ^
  symbol:   variable PAPPER
  location: class Format
```

Es el error que el paso 1 no podía darte. Una variable `Format` solo puede guardar una de las tres constantes, y el compilador las conoce. Vuelve a comentar la línea 28.

### 4. De texto a enum, con `valueOf`

Descomenta el **PASO 4** y ejecuta. Las últimas líneas:

```
EBOOK: 7 días
Exception in thread "main" java.lang.IllegalArgumentException: No enum constant Format.ebook
	at java.base/java.lang.Enum.valueOf(Enum.java:293)
	at Format.valueOf(Main.java:76)
	at Main.main(Main.java:35)
```

Los datos que llegan de fuera (un archivo, lo que escribe un usuario) son texto. `Format.valueOf("EBOOK")` busca la constante con ese nombre **exacto**. `"ebook"` no es ninguno, y en lugar de devolver un valor por defecto, como `daysFor`, lanza una excepción: el error sale en cuanto entra el dato malo. Vuelve a comentar la línea 35.

### 5. Un switch que cubre todos los valores

Descomenta el método `place` (líneas 67 a 72) y las líneas del **PASO 5** en `main`. Ejecuta:

```
Main.java:68: error: the switch expression does not cover all possible input values
        return switch (format) {
               ^
```

El `switch` devuelve un valor, así que tiene que tener una respuesta para cada constante, y falta `AUDIO`. Cambia la línea 70 por:

```java
            case EBOOK, AUDIO -> "el servidor";
```

Ejecuta. Las tres últimas líneas:

```
PAPER se guarda en la estantería
EBOOK se guarda en el servidor
AUDIO se guarda en el servidor
```

Con `default -> "el servidor"` también compilaría, y saldría lo mismo. Pero si mañana añades una constante `VINYL`, el `default` la mandaría al servidor en silencio; sin él, el compilador te avisa en cada `switch` que no la trate.

### 6. Cada constante existe una sola vez

Descomenta el **PASO 6** y ejecuta. Las dos últimas líneas:

```
true
AUDIO es largo
```

`valueOf("AUDIO")` no crea un objeto nuevo: devuelve la constante `AUDIO` que ya existe. Por eso dos constantes se comparan con `==`, sin `equals`. `name()` devuelve el nombre de la constante como texto, el camino de vuelta de `valueOf`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol ... variable PAPPER ... location: class Format` | Es la prueba del paso 3: vuelve a comentar la línea 28 |
| `IllegalArgumentException: No enum constant Format.ebook` | Es la prueba del paso 4: vuelve a comentar la línea 35 |
| `the switch expression does not cover all possible input values` | Es el error del paso 5: añade `AUDIO` a la línea 70 |
| `cannot find symbol ... method place(Format)` | Descomentaste las líneas del paso 5 sin el método `place` |
| `duplicate case label` | Escribiste `AUDIO` en dos ramas del `switch`: cada constante va en una sola |
| `enum classes may not be instantiated` | Escribiste `new Format(...)`: las constantes ya existen, se usan como `Format.PAPER` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Records](../ejercicio-01-records/README.md) | **Ejercicio 02 · Enums** | [Ejercicio 03 · Sealed y pattern matching](../ejercicio-03-sealed-y-pattern-matching/README.md) |
