# 03 · Sobrecarga frente a sobrescritura

⏱️ 40 min

## 1. Dos cosas con nombres parecidos

En la semana 07 viste la diferencia en una tabla. Esta semana importa **quién elige** y **cuándo**:

| | Sobrecarga (*overloading*) | Sobrescritura (*overriding*) |
|---|---|---|
| Qué es | Varios métodos con el mismo nombre y **distintos** parámetros | Una hija redefine un método heredado con los **mismos** parámetros |
| Quién elige | El **compilador** | La **JVM** |
| Cuándo | Al compilar | Al ejecutar |
| Con qué | Los tipos **estáticos** de los argumentos | El tipo **dinámico** del objeto |

## 2. La trampa

```java
static String kind(Book book) {
    return "un libro";
}

static String kind(RareBook book) {
    return "un libro raro";
}
```

Dos `kind` **sobrecargados**. Con un `RareBook` en una variable `Book`:

```java
Book chronicle = new RareBook(...);
IO.println(kind(chronicle));    // un libro
```

"Un libro", aunque el objeto sea un libro raro. Al compilar, el compilador tiene que decidir a cuál de los dos `kind` llama, y lo único que sabe de `chronicle` es que es `Book`. Elige `kind(Book)` y esa decisión queda escrita en el programa compilado. Al ejecutarse, nadie vuelve a mirar el objeto.

Compáralo con un método **sobrescrito**:

```java
class Book     { String kind() { return "un libro"; } }
class RareBook extends Book { @Override String kind() { return "un libro raro"; } }

IO.println(chronicle.kind());   // un libro raro
```

Aquí el compilador solo comprueba que `Book` tiene `kind()`. Cuál se ejecuta lo decide el objeto, al ejecutarse.

## 3. La regla práctica

Si quieres que el comportamiento dependa **del objeto**, escribe un método **en el objeto** y sobrescríbelo en las hijas. Un método de fuera sobrecargado por tipo (`kind(Book)`, `kind(RareBook)`) parece hacer lo mismo, pero mira la variable, no el objeto, y con una variable del padre siempre elige la versión del padre.

La sobrecarga sigue siendo útil para lo que es: ofrecer la misma operación con argumentos distintos. Tus dos constructores de la semana 06, `Bicycle(code, name, quantity)` y `Bicycle(code, name)`, son sobrecarga, y ahí no hay ninguna trampa: no hay objeto todavía.

## 4. Sobrecargar sin querer

Un error clásico es querer sobrescribir y acabar sobrecargando:

```java
class RareBook extends Book {
    String describe(String prefix) {      // otros parámetros: sobrecarga
        return prefix + super.describe() + " · " + room;
    }
}
```

`RareBook` tiene ahora **dos** `describe`: el heredado, sin parámetros, y uno nuevo. `card()` sigue llamando al `describe()` sin parámetros, que es el de `Book`, y la sala no sale. Con `@Override` no compila (`method does not override or implement a method from a supertype`), y te enteras en el momento. Una razón más para escribirlo siempre.

## ✅ Comprueba que lo entendiste

1. `Book b = new RareBook(...)`. ¿Qué imprime `kind(b)` con los dos `kind` estáticos? ¿Y `b.kind()` con el método sobrescrito? ¿Quién decide cada uno?
2. ¿Por qué tus dos constructores son sobrecarga y no sobrescritura?
3. Escribes `String describe(String prefix)` en una hija con `@Override` encima. ¿Qué pasa al compilar? ¿Y sin `@Override`?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [02 · Ligadura dinámica](02-ligadura-dinamica.md) | **03 · Sobrecarga frente a sobrescritura** | [04 · `instanceof` y *casting*](04-instanceof-y-casting.md) |
