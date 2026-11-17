# 04 · `String` y `StringBuilder`

⏱️ 45 min

## 1. Un `String` es una secuencia de caracteres

Cada carácter tiene una **posición**, empezando en 0, como en un array:

```
 B   K   -   0   4   2
 0   1   2   3   4   5      length() = 6
```

`"BK-042".charAt(2)` es `'-'`. La última posición es `length() - 1`; pedir `charAt(6)` lanza `StringIndexOutOfBoundsException`.

## 2. Buscar y trocear

| Método | Ejemplo | Resultado |
|---|---|---|
| `charAt(i)` | `"BK-042".charAt(0)` | `'B'` |
| `indexOf(c)` | `"BK-042".indexOf('-')` | `2` (o `-1` si no está) |
| `substring(a, b)` | `"BK-042".substring(0, 2)` | `"BK"`: incluye `a`, **excluye** `b` |
| `substring(a)` | `"BK-042".substring(3)` | `"042"`: de `a` al final |
| `contains(s)` | `"Cien años".contains("años")` | `true` |
| `startsWith(s)`, `endsWith(s)` | `"BK-042".startsWith("BK")` | `true` |
| `split(sep)` | `"a;b;c".split(";")` | `["a", "b", "c"]` |
| `String.join(sep, partes)` | `String.join(" \| ", parts)` | `"a \| b \| c"` |
| `isBlank()` | `" ".isBlank()` | `true` |

Y los de la semana 01: `strip()`, `toUpperCase(Locale.ROOT)`, `replace`, `equals`, `length`.

Dos detalles de `split` que muerden:

- `"".split(",")` no da un array vacío: da `[""]`, un elemento vacío.
- Las partes vacías del **final** desaparecen: `"a,b,".split(",")` es `["a", "b"]`, pero `"a,,b"` da `["a", "", "b"]`.

Por eso, al leer listas, descarta las partes en blanco una a una.

## 3. Los caracteres: `char` y `Character`

`char` es un primitivo: un solo carácter, entre comillas simples. La clase `Character` sabe clasificarlo:

```java
Character.isLetter('B')      // true
Character.isDigit('4')       // true
Character.isUpperCase('b')   // false
```

Los `char` se pueden comparar por orden: `c >= 'A' && c <= 'Z'` es "una letra mayúscula sin tilde". Recorrer un texto es un `for` con `charAt(i)`:

```java
for (int i = 0; i < code.length(); i++) {
    char c = code.charAt(i);
    ...
}
```

## 4. Inmutable

Un `String` **no cambia nunca**. Todos sus métodos devuelven un texto nuevo:

```java
String code = " bk-042 ";
code.strip();               // devuelve "bk-042"... y se pierde
code = code.strip();        // ahora sí: code apunta al nuevo
```

Si llamas a un método de `String` y no guardas el resultado, no ha pasado nada.

## 5. `StringBuilder`

Sumar textos en un bucle crea un `String` nuevo en cada vuelta y tira el anterior:

```java
String report = "";
for (String c : codes) {
    report = report + c + "\n";    // un objeto nuevo por vuelta
}
```

Con tres códigos da igual; con cien mil se nota. `StringBuilder` es un texto que **sí** cambia: acumula en el mismo objeto.

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < codes.length; i++) {
    sb.append(codes[i]).append(": ").append(quantities[i]).append('\n');
}
String report = sb.toString();
```

`append` acepta cualquier tipo y devuelve el propio `StringBuilder`, por eso se encadena. Al final, `toString()` te da el `String`. Regla: concatena con `+` en una línea; acumula con `StringBuilder` en un bucle.

## 6. Bloques de texto

Para textos de varias líneas, tres comillas:

```java
String header = """
        Informe de inventario
        ---------------------
        """;
```

Java quita la sangría común y conserva los saltos de línea. Te serán útiles en los tests de informes.

## ✅ Comprueba que lo entendiste

1. ¿Qué dan `"BK-042".substring(0, 2)` y `"BK-042".substring(3)`?
2. Escribes `code.toUpperCase(Locale.ROOT);` en una línea suelta y `code` sigue en minúsculas. ¿Por qué?
3. ¿Cuántos elementos tiene `"BK-042,, ,BK-107,".split(",")`? ¿Cuáles están en blanco?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [03 · Métodos](03-metodos.md) | **04 · `String` y `StringBuilder`** | [05 · Arrays](05-arrays.md) |
