# 04 · `protected` y `final`

⏱️ 45 min

## 1. Los cuatro niveles, ahora con subclases

En la semana 06 viste los cuatro niveles de acceso. Con la herencia aparece la columna que faltaba:

| Modificador | La propia clase | Mismo paquete | Subclase en otro paquete | Cualquiera |
|---|---|---|---|---|
| `private` | Sí | No | No | No |
| sin modificador | Sí | Sí | No | No |
| `protected` | Sí | Sí | Sí | No |
| `public` | Sí | Sí | Sí | Sí |

`protected` es "el paquete y, además, las subclases, estén donde estén". Fíjate en la segunda columna: **`protected` también abre la puerta a todo el paquete**. No es "solo para mis hijas".

## 2. La trampa de `protected`

Parece el término medio perfecto: los atributos de `Book` como `protected`, y así `RareBook` puede tocarlos sin *getters*. El ejercicio 03 lo prueba:

```java
class Book {
    protected int copies;
    ...
}

// En Main, que no es ninguna subclase:
chronicle.copies = -7;    // compila
```

```
BK-001 · Crónica de Núremberg · ejemplares: -7
```

`Main` está en el mismo paquete que `Book`, así que `protected` le deja entrar. Es la puerta abierta de la semana 06 otra vez. Y aunque no hubiera nadie más en el paquete, cualquiera puede escribir una subclase de `Book` y, desde ella, poner los ejemplares que quiera.

La regla práctica: **los atributos, `private`**, también en una clase pensada para tener subclases. Las subclases usan lo mismo que todos: los *getters* y las órdenes del padre (`getQuantity()`, `take()`, `restock(n)`), que conocen las reglas. Si una subclase de verdad necesita algo que el resto no debe ver, lo razonable es un **método** `protected` que cumpla las reglas, no un atributo.

En el proyecto, tu subclase lee las unidades con `getQuantity()` y las cambia con `super.take()`. La regla "no bajar de 0" sigue en un solo sitio.

## 3. Un método `final` no se sobrescribe

En la semana 06, `final` en un atributo impedía reasignarlo. En un método impide **sobrescribirlo**:

```java
class Book {
    final String getCode() {
        return code;
    }
}

class RareBook extends Book {
    @Override
    String getCode() {           // no compila
        return "RARO-" + super.getCode();
    }
}
```

```
Main.java:118: error: getCode() in RareBook cannot override getCode() in Book
    String getCode() {
           ^
  overridden method is final
```

Úsalo cuando un método es parte de una regla que ninguna subclase debe torcer. Aquí, que el código de un libro sea el que validó su constructor, sin prefijos.

## 4. De una clase `final` no se hereda

`final` en una clase impide que nadie la extienda:

```java
final class Isbn { ... }

class FakeIsbn extends Isbn { ... }   // error: cannot inherit from final Isbn
```

Ya conoces una: **`String` es `final`**. Si se pudiera escribir `class MyString extends String` y sobrescribir sus métodos, un "`String`" podría cambiar después de creado, y la inmutabilidad de la semana 06 dejaría de ser una garantía. Con `final`, cualquier `String` es un `String` de verdad.

## 5. Tres `final`, tres significados

| `final` en... | Impide | Lo viste en |
|---|---|---|
| Un atributo o una variable | Reasignarlo | Semana 06 |
| Un método | Sobrescribirlo | Esta teoría, paso 2 del ejercicio 03 |
| Una clase | Heredar de ella | Esta teoría, paso 3 del ejercicio 03 |

¿Hay que poner `final` a tus clases? En el proyecto, no: tu clase va a tener una subclase. Pero muchos equipos marcan `final` las clases que **no** se diseñaron para tener hijas. Diseñar una clase para la herencia exige pensar qué métodos se pueden sobrescribir sin romper nada, y cuando nadie lo ha pensado, `final` es lo honesto.

## ✅ Comprueba que lo entendiste

1. `copies` es `protected` en `Book`. ¿Puede `Main`, que no hereda de `Book`, escribir en él? ¿De qué depende?
2. ¿Por qué, en tu proyecto, los atributos de tu clase siguen siendo `private` aunque vaya a tener una subclase? ¿Cómo lee las unidades la subclase?
3. ¿Qué impide `final` en un atributo, en un método y en una clase? ¿Por qué `String` es `final`?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [03 · Sobrescritura y `@Override`](03-sobrescritura-y-override.md) | **04 · `protected` y `final`** | [05 · Cuándo heredar y cuándo componer](05-cuando-heredar-y-cuando-componer.md) |
