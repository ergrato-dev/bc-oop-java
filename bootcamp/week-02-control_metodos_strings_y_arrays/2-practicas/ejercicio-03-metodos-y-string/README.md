# Ejercicio 03 — Métodos y `String`

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-metodos.md) y [04](../../1-teoria/04-string-y-stringbuilder.md)

## Objetivo

Escribir métodos propios que reciben y devuelven valores, sobrecargarlos, comprobar que Java pasa **copias** a los parámetros, trocear un `String` en campos, construir texto con `StringBuilder` y recorrer un texto carácter a carácter. Es un ejercicio **guiado**: el código está en `Main.java`, comentado por pasos. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-02-control_metodos_strings_y_arrays/2-practicas/ejercicio-03-metodos-y-string/starter
java Main.java
```

Salida esperada:

```
Ejercicio 03 · Métodos y String
```

Los PASOS 1, 2 y 3 tienen **dos partes**: la llamada, dentro de `main`, y el método, al final del archivo, fuera de `main`. Descomenta las dos antes de ejecutar. La salida acumula la de los pasos anteriores; abajo solo se muestran las líneas nuevas.

## Pasos

### 1. Un método que devuelve un valor

Descomenta el **PASO 1** (llamada y método):

```
Con impuesto: 119.0
Con impuesto: 12.5
```

`double withTax(double price, double rate)` declara: devuelve un `double`, se llama `withTax` y recibe dos `double`. `return` entrega el resultado a quien llamó. Ahora descomenta solo la llamada de un paso y no su método, y verás el error que más vas a ver esta semana:

```
error: cannot find symbol
```

### 2. Sobrecarga

Descomenta el **PASO 2**:

```
[BK-042]
[BK-042] x3
```

Dos métodos `label` con distinto número de parámetros: Java elige por los argumentos. El segundo **llama al primero** en vez de repetir los corchetes; si mañana cambias el formato, lo cambias en un sitio.

### 3. Java pasa copias

Descomenta el **PASO 3**:

```
copies sigue en 5
stock[0] ahora es 0
```

`tryToChange` pone a 0 su `n` y la posición 0 de su `values`. Al volver, `copies` sigue en 5: el método recibió una **copia** del número. Pero `stock[0]` sí cambió: el método recibió una copia de la **flecha**, que apunta al mismo array. Por eso `missing` del proyecto crea un array nuevo en lugar de escribir en el que recibe.

### 4. Trocear y buscar en un `String`

Descomenta el **PASO 4**:

```
Campos: 3
Título: Cien años de soledad
Prefijo: BK
Número: 042
¿Empieza por BK? true
¿Habla de soledad? true
BK-042 | Cien años de soledad | 12.5
```

`split(";")` corta la línea en un array de campos. `indexOf('-')` da la posición del guion (2). `substring(0, dash)` va de la posición 0 a la 2 **sin incluirla**; `substring(dash + 1)`, desde la 3 hasta el final. `String.join` hace lo contrario de `split`.

### 5. `StringBuilder`

Descomenta el **PASO 5**:

```
1. BK-042
2. BK-107
3. BK-311
```

Un `String` no cambia nunca: `text = text + "..."` en un bucle crea un texto nuevo en cada vuelta. `StringBuilder` acumula en el mismo objeto y `append` se encadena. `'\n'` es el salto de línea; por eso aquí se imprime con `IO.print`, sin otro salto al final. Es la forma de `report` en el proyecto.

### 6. Recorrer los caracteres

Descomenta el **PASO 6**:

```
BK-042: 2 letras, 3 dígitos
```

`charAt(i)` devuelve el `char` de la posición `i`; `Character.isLetter` y `Character.isDigit` lo clasifican. El guion no es ni lo uno ni lo otro, así que no cuenta. Cambia `code` a `"HAB-1017"`: `3 letras, 4 dígitos`. Con este recorrido, más la posición del guion del paso 4, tienes todo lo que necesita `isValidCode`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: cannot find symbol` con `symbol: method withTax(double,double)` | Descomentaste la llamada y no el método, al final del archivo |
| `error: missing return statement` | Un método que no es `void` tiene un camino sin `return` |
| `error: method label(String) is already defined` | Dos métodos con el mismo nombre **y** los mismos parámetros: la sobrecarga exige parámetros distintos |
| `StringIndexOutOfBoundsException` | Un `substring` o `charAt` con una posición mayor que `length() - 1` |
| `ArrayIndexOutOfBoundsException` en `parts[1]` | Separaste por `","` y la línea usa `";"` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Bucles y arrays](../ejercicio-02-bucles-y-arrays/README.md) | **Ejercicio 03 · Métodos y `String`** | [Proyecto · Gestión, capa 1](../../3-proyecto/README.md) |
