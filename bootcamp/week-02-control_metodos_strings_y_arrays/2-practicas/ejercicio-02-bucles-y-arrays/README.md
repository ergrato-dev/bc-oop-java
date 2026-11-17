# Ejercicio 02 — Bucles y arrays

⏱️ 2 h · Teoría previa: [02](../../1-teoria/02-bucles.md) y [05](../../1-teoria/05-arrays.md)

## Objetivo

Repetir con `while` y `for`, guardar varios valores en un array, recorrerlo con y sin índice, buscar con `break` y saltar con `continue`, ver por qué `=` no copia un array y provocar el error más típico: salirse de él. Es un ejercicio **guiado**: el código está en `Main.java`, comentado por pasos. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-02-control_metodos_strings_y_arrays/2-practicas/ejercicio-02-bucles-y-arrays/starter
java Main.java
```

Salida esperada:

```
Ejercicio 02 · Bucles y arrays
```

En cada paso descomentas un bloque y ejecutas `java Main.java`. La salida **acumula** la de los pasos anteriores; abajo solo se muestran las líneas nuevas.

## Pasos

### 1. `while`

Descomenta el **PASO 1**:

```
Presto una, quedan 2
Presto una, quedan 1
Presto una, quedan 0
```

El cuerpo se repite mientras `copies > 0`. `copies--` resta 1 en cada vuelta: sin esa línea la condición no cambia nunca y el programa no termina (páralo con `Ctrl+C` si te pasa).

### 2. `for` clásico

Descomenta el **PASO 2**:

```
Suma de 1 a 10: 55
```

`for (int i = 1; i <= 10; i++)` junta en una línea el inicio, la condición y el paso. `i` solo existe dentro del bucle. `sum += i` es `sum = sum + i`: el patrón **acumulador**, el mismo de `total` en tu proyecto.

### 3. Arrays y for-each

Descomenta el **PASO 3**:

```
Hay 3 códigos; el primero es BK-042
Total en stock: 11
[4, 0, 7]
```

`codes` y `stock` son **arrays paralelos**: la posición `i` de uno corresponde a la `i` del otro. Las posiciones empiezan en `0`. `for (int q : stock)` recorre los valores sin índice. `Arrays.toString` es la forma de imprimir un array: prueba `IO.println(stock)` y verás algo como `[I@1b6d3586`, la dirección del objeto, no su contenido.

### 4. Buscar: `break` y `continue`

Descomenta el **PASO 4**:

```
Agotado: BK-107 (posición 1)
Disponible: BK-042
Disponible: BK-311
```

Cuando necesitas la **posición**, usas el `for` clásico. `break` sale del bucle en cuanto encuentra el primero agotado. `continue` salta el resto de la vuelta y pasa a la siguiente. Así funciona `indexOf` del proyecto, con `return i` en lugar de `break`.

### 5. Copiar no es asignar

Descomenta el **PASO 5**:

```
stock: [4, 99, 7]
copy:  [4, 0, 7]
copy ordenada: [0, 4, 7]
```

Cambiaste `alias[1]`, no `stock[1]`, y sin embargo `stock` cambió. Un array es un **objeto**: `alias = stock` copia la flecha (teoría 05 de la semana 01), y las dos variables apuntan al mismo array. `Arrays.copyOf` crea uno nuevo. `Arrays.sort` ordena **ese** array en su sitio.

### 6. Salirse del array

Descomenta el **PASO 6**:

```
0: BK-042
1: BK-107
2: BK-311
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Main.main(Main.java:89)
```

Un array de 3 tiene las posiciones 0, 1 y 2. El bucle usa `<=` y en la cuarta vuelta pide `codes[3]`. Compila sin problema: el error aparece al ejecutar. Cambia `<=` por `<` en la línea 88 y vuelve a ejecutar: las tres líneas, sin excepción.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| El programa no termina | Bucle infinito: `Ctrl+C`, y revisa que algo cambia la condición (`copies--`, `i++`) |
| `error: cannot find symbol ... stock` | Descomentaste el PASO 4 o 5 sin el PASO 3 |
| `error: cannot find symbol ... Arrays` | Borraste `import java.util.Arrays;` de arriba |
| `error: illegal start of expression` y `not a statement` en `{4, 0, 7}` | Las llaves solas solo valen al declarar; después, `stock = new int[] {4, 0, 7};` |
| `[I@1b6d3586` en la salida | Imprimiste el array directamente; usa `Arrays.toString(stock)` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Condicionales y `switch`](../ejercicio-01-condicionales-y-switch/README.md) | **Ejercicio 02 · Bucles y arrays** | [Ejercicio 03 · Métodos y `String`](../ejercicio-03-metodos-y-string/README.md) |
