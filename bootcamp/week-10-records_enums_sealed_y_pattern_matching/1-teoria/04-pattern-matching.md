# 04 · Pattern matching

⏱️ 55 min

## 1. Comprobar y extraer en un paso

En la semana 08 viste el primer **patrón**: `instanceof` con una variable.

```java
if (item instanceof RareBook rareBook) {
    IO.println(rareBook.getRoom());
}
```

Hace dos cosas: comprueba el tipo y, si encaja, declara la variable ya convertida. Un patrón es eso: una forma que el objeto puede tener o no, y que, si la tiene, te da sus partes. Esta semana ves dos patrones más y un `switch` que los usa.

## 2. Patrones de record

Un record dice en su cabecera de qué está hecho. Por eso puedes **desmontarlo** en el mismo `instanceof`:

```java
record Taken(String code, int left) implements Outcome {}

if (outcome instanceof Taken(String code, int left)) {
    IO.println(code + ": quedan " + left);
}
```

`Taken(String code, int left)` es un **patrón de record**. Si `outcome` es un `Taken`, Java llama a `code()` y `left()` y guarda los valores en dos variables nuevas, que solo existen dentro del `if`. Los componentes van en el orden de la cabecera del record, y con su tipo; si no, no compila (`incorrect number of nested patterns`, o `incompatible types`).

Con `var` no hace falta repetir los tipos: `instanceof Taken(var code, var left)`.

## 3. `switch` con patrones

Desde la semana 02 usas `switch` con valores: números, textos, constantes de un enum. Desde Java 21, cada `case` puede ser también un patrón:

```java
static String message(Outcome outcome) {
    return switch (outcome) {
        case Taken(String code, int left) -> code + ": sale una, quedan " + left;
        case Rejected(String code, String reason) -> "Rechazado: " + reason;
    };
}
```

Java prueba los `case` en orden, y ejecuta el primero cuyo patrón encaja con el objeto. Es una cadena de `instanceof` escrita de forma compacta, con una diferencia que importa mucho: el compilador la **revisa**.

## 4. Exhaustividad: todos los casos o no compila

Un `switch` que devuelve un valor tiene que tener respuesta para todo lo que puede llegar. Con un enum, eso eran todas sus constantes. Con un tipo sellado, todas las clases de `permits`:

| Lo que recibe el `switch` | El compilador sabe que puede llegar | Sin `default` |
|---|---|---|
| Un `Level`, enum | `SOLD_OUT`, `LOW`, `NORMAL` o `FULL` | Compila si hay un `case` para cada uno |
| Un `Outcome`, interfaz sellada | Un `Taken` o un `Rejected` | Compila si hay un `case` para cada uno |
| Un `Criterion`, interfaz abierta | Cualquier clase, también las que no existen | No compila nunca: `the switch expression does not cover all possible input values` |

Esa es la razón de sellar `Outcome`. Sin `sealed`, el compilador no puede saber que dos casos bastan, y te obliga a poner un `default` que nunca se ejecutará. Con `sealed`, el `switch` sin `default` compila, y el día que añadas un tercer resultado a `permits`, deja de compilar **en cada `switch` que no lo trate**. El compilador te da la lista de lo que tienes que revisar.

## 5. Condiciones con `when`

Un `case` puede llevar una condición después del patrón, con `when`:

```java
static int loanDays(Item item) {
    return switch (item) {
        case Book book when book.pages() > 1000 -> 30;
        case Book book -> 21;
        case Magazine magazine -> 7;
        case Dvd dvd -> 3;
    };
}
```

El primer `case` solo encaja con los libros de más de 1000 páginas; el resto de libros cae en el segundo. El orden importa: si `case Book book` fuera primero, aceptaría todos los libros y el de `when` no se ejecutaría nunca. El compilador lo detecta: `this case label is dominated by a preceding case label`. El caso más concreto va primero.

Un `case` con `when` no cuenta para la exhaustividad, porque la condición puede ser falsa: sigue haciendo falta un `case Book` sin condición.

## 6. `_`: lo que no te hace falta

A veces el patrón solo te interesa por el tipo, o por una parte. El guion bajo, `_`, dice "aquí hay algo, pero no lo voy a usar":

```java
    case Rejected(_, String reason) -> "Rechazado: " + reason;   // el código no hace falta
    case Magazine _ -> 7;                                        // solo importa que es revista
```

Así quien lee sabe que no se te ha olvidado usar el código: no lo necesitas.

## 7. ¿Y `null`?

Si `outcome` es `null`, un `switch` con patrones lanza `NullPointerException`, como antes. Puedes tratarlo con `case null -> ...`, pero en tu proyecto no hace falta: `tryTake` nunca devuelve `null`. Es una ventaja de devolver un resultado en lugar de "nada".

## ✅ Comprueba que lo entendiste

1. ¿Qué hace `outcome instanceof Taken(String code, int left)` si `outcome` es un `Rejected`? ¿Existen `code` y `left` después?
2. ¿Por qué el `switch` de `message` compila sin `default` cuando `Outcome` es `sealed`, y no compila si no lo es?
3. En `loanDays`, ¿qué pasa si intercambias las dos primeras líneas? ¿Por qué?
4. ¿Qué dice `_` en `case Rejected(_, String reason)`?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [03 · Tipos sellados](03-tipos-sellados.md) | **04 · Pattern matching** | [05 · Polimorfismo o pattern matching](05-polimorfismo-o-pattern-matching.md) |
