# 03 · Constructores

⏱️ 45 min

## 1. El problema

Con `new Book()` y cuatro asignaciones, nada obliga a dar todos los datos:

```java
Book pedroParamo = new Book();
pedroParamo.code = "BK-500";
pedroParamo.title = "Pedro Páramo";
// se olvidó el autor: queda null y Java no dice nada
```

Es el mismo olvido que en el ejercicio 03 de la semana 04 dejaba un autor `null` en un array paralelo. Un **constructor** lo hace imposible.

## 2. Qué es un constructor

```java
class Book {
    String code;
    String title;
    String author;

    Book(String code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
    }
}
```

Un constructor es un bloque que se ejecuta **al crear** el objeto, con `new`. Se parece a un método, con dos diferencias:

- Se llama **exactamente como la clase**: `Book`.
- **No tiene tipo de retorno**, ni siquiera `void`. Si le pones `void`, Java lo toma por un método normal que se llama `Book`, y el constructor desaparece.

Ahora el libro nace completo, en una línea:

```java
Book pedroParamo = new Book("BK-500", "Pedro Páramo", "Rulfo");
```

Y si falta un dato, no compila:

```
error: constructor Book in class Book cannot be applied to given types;
  required: String,String,String
  found:    String,String
```

Un error de compilación es el mejor error posible: aparece antes de ejecutar, en la línea exacta.

## 3. `this.code = code`

Dentro del constructor hay dos `code`: el **parámetro** (lo que se pasa a `new`) y el **atributo** (lo que guarda el objeto). Cuando se llaman igual, el nombre a secas es el parámetro, que **tapa** al atributo. Para hablar del atributo se escribe `this.`:

```java
this.code = code;   // atributo del objeto  =  parámetro
```

El error clásico es olvidarlo:

```java
Book(String code, String title, String author) {
    code = code;        // copia el parámetro en sí mismo
    ...
}
```

Compila sin avisos, y el atributo `code` se queda en `null`. Lo verás en el ejercicio 01. Ponerles el mismo nombre a parámetros y atributos es lo normal en Java: deja claro qué parámetro va a qué atributo. Solo exige no olvidar el `this.`.

## 4. El constructor puede preparar los datos

El constructor no tiene por qué copiar los datos tal cual. Puede dejarlos como deben estar:

```java
Book(String code, String title, int copies) {
    this.code = Fields.normalizeCode(code);   // " bk-042 " pasa a "BK-042"
    this.title = title.strip();
    this.copies = copies;
}
```

Así, cualquier libro que exista tiene su código en mayúsculas, sin que nadie más tenga que acordarse. Y reutiliza `Fields.normalizeCode` de la semana 01 en lugar de repetir la regla.

En la semana 06 el constructor dará un paso más: **rechazará** los datos que no valen (un código mal formado, unidades negativas) con una excepción, para que no pueda existir un objeto en mal estado.

## 5. El constructor por defecto

Si una clase no tiene ningún constructor, Java le da uno vacío y sin parámetros: por eso funcionaba `new Book()` en la [teoría 01](01-de-la-tarjeta-a-la-clase.md). Es el **constructor por defecto**.

En cuanto escribes uno, Java deja de darlo. Con el constructor de tres parámetros, `new Book()` ya no compila. Casi siempre es lo que quieres: si un libro necesita código, título y autor, que no se pueda crear sin ellos. En la semana 06 verás cómo tener más de un constructor, cuando de verdad haga falta.

## 6. Un constructor no devuelve, inicializa

Quien crea el objeto es `new`; el constructor solo le da sus primeros valores. Por eso no tiene `return` con valor. El orden al ejecutar `new Book("BK-500", "Pedro Páramo", "Rulfo")` es:

1. Java reserva un objeto `Book` con sus atributos a su valor por defecto (`null`, `null`, `null`).
2. Ejecuta el constructor, que les da valor.
3. `new` devuelve la referencia al objeto, que se guarda en la variable.

## ✅ Comprueba que lo entendiste

1. ¿Qué dos cosas distinguen un constructor de un método? ¿Qué pasa si le pones `void`?
2. En `Book(String code, ...) { code = code; }`, ¿qué valor tiene el atributo `code` después de `new`? ¿Por qué?
3. Una clase tiene un constructor con dos parámetros. ¿Compila `new Book()`? ¿Y si la clase no tuviera ningún constructor?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [02 · Métodos de instancia](02-metodos-de-instancia.md) | **03 · Constructores** | [04 · Referencias y `null`](04-referencias-y-null.md) |
