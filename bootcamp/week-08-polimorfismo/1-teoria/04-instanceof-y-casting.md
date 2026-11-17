# 04 · `instanceof` y *casting*

⏱️ 45 min

## 1. Bajar de la variable del padre a la hija

Tienes un `RareBook` en una variable `Book` y necesitas su sala. La variable no te deja llamar a `getRoom()`. Un ***cast*** (conversión de tipo) hacia abajo le dice al compilador "aquí dentro hay un `RareBook`":

```java
Book chronicle = new RareBook("BK-001", "Crónica de Núremberg", 1, "Sala de fondo antiguo");
RareBook rare = (RareBook) chronicle;
IO.println(rare.getRoom());   // Sala de fondo antiguo
```

El objeto no cambia: es el mismo `RareBook` de antes. Lo que cambia es la **variable** con la que lo miras, y con ella, los métodos que el compilador te deja llamar.

## 2. Un *cast* es una promesa

El compilador acepta `(RareBook) chronicle` porque una variable `Book` **podría** tener un `RareBook` dentro. No puede saberlo seguro, así que te cree. Si mientes:

```java
Book ficciones = new Book("BK-042", "Ficciones", 2);
RareBook wrong = (RareBook) ficciones;
```

compila, y al ejecutarse:

```
Exception in thread "main" java.lang.ClassCastException: class Book cannot be cast to class RareBook (...)
```

La JVM comprueba el objeto en el momento del *cast*, ve que es un `Book` normal y lanza `ClassCastException`. Lo que el compilador no podía comprobar, lo comprueba la JVM, pero tarde: con el programa ya en marcha.

Lo que sí rechaza el compilador es el *cast* imposible, el que **nunca** podría funcionar:

```java
String text = (String) chronicle;
// error: incompatible types: Book cannot be converted to String
```

Una variable `Book` no puede tener un `String` dentro: `String` no es hija de `Book`.

## 3. `instanceof`: preguntar antes de bajar

`instanceof` comprueba si un objeto **es un** tipo dado (de esa clase o de una hija suya):

```java
for (Book book : shelf) {
    if (book instanceof RareBook rareBook) {
        IO.println(book.getCode() + ": solo en la " + rareBook.getRoom());
    } else {
        IO.println(book.getCode() + ": se presta");
    }
}
```

`book instanceof RareBook rareBook` hace dos cosas a la vez:

1. Comprueba si el objeto es un `RareBook`.
2. Si lo es, declara `rareBook`, una variable `RareBook` que apunta al mismo objeto, ya convertida. Solo existe donde Java sabe que la comprobación fue verdadera: dentro del `if`.

Es el ***pattern matching*** de `instanceof`, de Java 16. Comprueba y convierte en un paso, así que no hay *cast* a mano ni `ClassCastException` posible. Si ves código antiguo con `if (book instanceof RareBook) { RareBook r = (RareBook) book; ... }`, es lo mismo escrito en dos pasos. En la semana 10 verás patrones también en `switch`.

Con `null`, `instanceof` siempre da `false`: `null instanceof RareBook` no es un `RareBook`.

## 4. Si necesitas preguntar, sospecha

`instanceof` funciona, pero cada vez que lo escribas pregúntate **por qué** necesitas saber la clase. Casi siempre es para hacer algo distinto según el tipo, y eso es justo lo que hace la ligadura dinámica, sin preguntar:

| Si quieres... | En lugar de `instanceof`... |
|---|---|
| Un comportamiento distinto en cada clase | Un método en el padre, sobrescrito en las hijas (teoría 05) |
| Un dato que solo tienen algunas hijas | Un método en el padre que lo use, sobrescrito en esas hijas (`loanNotice()` en lugar de `getRoom()`) |

`instanceof` tiene su sitio cuando de verdad necesitas algo que solo existe en una hija y que no tiene sentido en el padre, o cuando trabajas con clases que no puedes cambiar. Pero un programa lleno de `instanceof` suele ser un programa que no aprovecha el polimorfismo. En tu proyecto, `Inventory` no escribe ninguno: un test lo comprueba.

## ✅ Comprueba que lo entendiste

1. ¿`(RareBook) chronicle` cambia el objeto o la variable? ¿Qué te deja hacer después?
2. ¿Por qué `(RareBook) ficciones` compila y falla al ejecutar, y `(String) chronicle` no compila?
3. Reescribe sin *cast* a mano: `if (b instanceof AudioBook) { AudioBook a = (AudioBook) b; IO.println(a.getMinutes()); }`.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [03 · Sobrecarga frente a sobrescritura](03-sobrecarga-frente-a-sobrescritura.md) | **04 · `instanceof` y *casting*** | [05 · Polimorfismo en lugar de condicionales](05-polimorfismo-en-lugar-de-condicionales.md) |
