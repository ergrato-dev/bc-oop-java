# 04 · `final` e inmutabilidad

⏱️ 45 min

## 1. Un atributo que no cambia nunca

El código de un libro es su identidad. Si `BK-042` pasara a llamarse `BK-043`, el préstamo que apuntaba a `BK-042` se quedaría hablando de un libro que ya no existe. Esa regla ("el código no cambia") se puede escribir en Java:

```java
private final String code;
```

Un atributo **`final`** recibe su valor **una sola vez**, en el constructor, y después no se puede reasignar. Ni desde fuera ni desde un método de la propia clase:

```
Main.java:114: error: cannot assign a value to final variable code
        this.code = newCode;
            ^
```

Como `private`, es un error de compilación: el compilador hace cumplir la regla por ti.

## 2. Lo que exige `final`

Java comprueba dos cosas de un atributo `final`:

1. Que **todo** constructor le dé valor. Si un camino del constructor termina sin asignarlo, no compila: `variable code might not have been initialized`.
2. Que no se le dé valor **dos veces**.

Por eso encaja tan bien con el constructor que valida de la teoría 03: comprueba todo, y al final asigna cada atributo una vez.

¿Qué atributos de tu clase son `final`? Los que tu dominio dice que no cambian. En tu entidad, `code` y `name`. `quantity` no: `take()` y `restock()` la cambian, y eso es justo lo que se espera de ella.

## 3. `final` en una variable

`final` también vale para variables locales y parámetros: la variable no se puede reasignar.

```java
final Book fixed = new Book("BK-107", "El túnel", 1);
fixed.restock(2);                         // compila: cambia el objeto
fixed = new Book("BK-108", "Otro", 1);    // no compila: mueve la flecha
```

Esto sorprende siempre: `final` en una variable de tipo objeto fija **la referencia** (la flecha), no el objeto. `fixed` siempre apuntará a El túnel, pero El túnel puede cambiar por dentro. Es el paso 6 del ejercicio 02.

Lo mismo pasa con un atributo `final` que es un array:

```java
private final Book[] items;
```

`items` siempre será el mismo array, pero lo que hay **dentro** del array puede cambiar: `items[0] = otroLibro` compila. `final` protege la variable; para proteger el contenido hace falta algo más (lo verás en la teoría 05).

## 4. Objetos inmutables

Un objeto es **inmutable** si, una vez creado, su estado no puede cambiar de ninguna forma. Para eso hacen falta tres cosas:

1. Todos los atributos `private` y `final`.
2. Ningún método que cambie el estado (ningún *setter*, ninguna orden).
3. Si algún atributo apunta a algo mutable (un array, por ejemplo), no dejarlo escapar.

Ya usas un objeto inmutable todos los días: `String`. Ningún método de `String` lo cambia; `strip()` o `toUpperCase()` **devuelven un `String` nuevo** y dejan el original como estaba. Por eso escribes `name = name.strip()` y no solo `name.strip()`.

Los objetos inmutables son más fáciles de razonar: si nadie puede cambiarlos, no importa cuántas variables los compartan. No hay sorpresas de alias como las de la semana 05.

Tu entidad **no** es inmutable, y no debe serlo: sus unidades cambian, porque así es tu dominio. Pero tiene partes inmutables (`code`, `name`), y cuantas más tenga, menos cosas pueden salir mal. En la semana 10 verás los `record`, la forma corta que tiene Java de escribir clases inmutables.

## 5. `final` en todas partes

Un buen hábito: empieza poniendo `final` en todos los atributos y quítalo solo de los que de verdad cambian. Así cada atributo sin `final` es una decisión, no un olvido. En tu proyecto, `Inventory` tiene `private final Book[] items` (el inventario no cambia de array) y `private int size` (cambia con cada `add`).

## ✅ Comprueba que lo entendiste

1. ¿Por qué `code` es `final` y `quantity` no?
2. Con `final Book b = new Book(...)`, ¿compila `b.take()`? ¿Y `b = null`? Explica la diferencia con flechas.
3. `String` es inmutable. ¿Qué imprime `String s = " hola "; s.strip(); System.out.println("[" + s + "]");`?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [03 · Constructores que validan](03-constructores-que-validan.md) | **04 · `final` e inmutabilidad** | [05 · Composición y delegación](05-composicion-y-delegacion.md) |
