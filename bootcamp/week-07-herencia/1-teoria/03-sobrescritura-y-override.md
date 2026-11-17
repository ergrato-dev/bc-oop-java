# 03 · Sobrescritura y `@Override`

⏱️ 50 min

## 1. Un método heredado que no sirve tal cual

`RareBook` hereda `describe()` de `Book`, y lo usa tal cual:

```
BK-001 · Crónica de Núremberg · ejemplares: 1
```

Falta la sala. El `describe()` de `Book` no la conoce, y no debe conocerla: `Book` no sabe que existen libros raros. Lo que necesitas es que **`RareBook` describa a su manera**.

## 2. Sobrescribir

```java
class RareBook extends Book {
    ...
    @Override
    String describe() {
        return super.describe() + " · " + room;
    }
}
```

Una subclase **sobrescribe** (*override*) un método cuando declara uno con el **mismo nombre y los mismos parámetros** que uno heredado. Desde ese momento, un `RareBook` usa su versión y un `Book` normal, la de siempre:

```
BK-042 · Ficciones · ejemplares: 2
BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo
```

## 3. `super.metodo()`: reutilizar la versión del padre

El `describe()` de `RareBook` no repite cómo se monta el código, el título y los ejemplares: llama a `super.describe()`, que es **el `describe()` de `Book`**, y añade la sala. Así, si mañana `Book` cambia su formato, `RareBook` lo sigue sin tocarla.

Cuidado con olvidar `super.`:

```java
@Override
String describe() {
    return describe() + " · " + room;   // se llama a sí mismo
}
```

`describe()` sin `super.` es el `describe()` de `RareBook`, el mismo método, que se llama a sí mismo sin fin hasta que el programa revienta con `java.lang.StackOverflowError`. Lo provocas a propósito en el paso 2 del ejercicio 02.

No siempre se reutiliza la versión del padre. Un libro raro que no sale de su sala sobrescribe `lend()` para negarse, sin `super.lend()`:

```java
@Override
void lend() {
    throw new IllegalStateException(getCode() + " no sale de la " + room);
}
```

## 4. `@Override`: el compilador comprueba por ti

`@Override` es una **anotación**: una marca para el compilador que dice "este método sobrescribe uno heredado". Si no es verdad, no compila:

```
Main.java:116: error: method does not override or implement a method from a supertype
    @Override
    ^
```

Sin `@Override`, un `descrbe()` con una errata o un `describe(String extra)` con otro parámetro serían métodos **nuevos** de `RareBook`, y el programa seguiría usando el `describe()` de `Book` sin avisarte. El error aparecería días después, como "¿por qué no sale la sala?". Con `@Override`, aparece al compilar. Escríbelo **siempre** que sobrescribas.

## 5. Las reglas de la sobrescritura

| Regla | Si no la cumples |
|---|---|
| Mismo nombre y mismos parámetros (en número, tipo y orden) | No sobrescribes: escribes otro método. Con `@Override`, no compila |
| No dar **menos** acceso que el padre | `attempting to assign weaker access privileges; was public` |
| No sobrescribir un método `final` | `overridden method is final` (teoría 04) |

Mismo nombre con **otros** parámetros es otra cosa: **sobrecarga** (*overloading*), como los dos constructores de la semana 06. Las dos conviven:

| | Sobrecarga | Sobrescritura |
|---|---|---|
| Parámetros | Distintos | Los mismos |
| Dónde | En la misma clase (o en una subclase) | En una subclase |
| Quién elige cuál se ejecuta | El compilador, por los argumentos | El objeto, al ejecutarse |

## 6. `toString()`: sobrescribir un método de `Object`

Todas las clases heredan de `Object` su `toString()`, que devuelve el nombre de la clase, una `@` y un número: `Book@2ea227af`. Java lo llama solo cuando necesita un objeto como texto: en `IO.println(book)`, en `System.out.println(book)` y en `"Ficha: " + book`.

Sobrescribirlo es lo más habitual del mundo:

```java
class Book {
    ...
    @Override
    public String toString() {
        return describe();
    }
}
```

Va `public` porque en `Object` es `public` (regla 2 de la tabla). Desde ahora, `IO.println(ficciones)` imprime `BK-042 · Ficciones · ejemplares: 2`.

## 7. Quién decide qué método se ejecuta

Mira qué pasa con un `RareBook` cuando `Book` tiene ese `toString()`:

```java
IO.println(chronicle);
// BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo
```

`RareBook` no escribió `toString()`: usa el de `Book`. Ese `toString()` llama a `describe()`... y en un `RareBook`, `describe()` es **el de `RareBook`**. Por eso sale la sala.

Es la regla que hace funcionar todo esto: **cuando se llama a un método, se ejecuta la versión del objeto**, no la de la variable ni la de la clase donde está escrita la llamada. Un array de `Book` con un `Book` y un `RareBook`, recorrido con `book.lend()`, presta el primero y rechaza el segundo (paso 4 del ejercicio 02). En la semana 08 esto tiene nombre propio: **polimorfismo**.

## ✅ Comprueba que lo entendiste

1. ¿Qué diferencia hay entre `super.describe()` y `describe()` dentro del `describe()` de `RareBook`?
2. Escribes `@Override String descripe()`. ¿Qué pasa al compilar? ¿Y si quitas `@Override`?
3. `RareBook` no tiene `toString()`, pero `IO.println(chronicle)` muestra la sala. Explica por qué, paso a paso.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [02 · Constructores y `super`](02-constructores-y-super.md) | **03 · Sobrescritura y `@Override`** | [04 · `protected` y `final`](04-protected-y-final.md) |
