# 04 · Métodos `default` y `static`

⏱️ 45 min

## 1. Código dentro de un contrato

Hasta Java 8, una interfaz solo tenía métodos sin cuerpo. Eso planteaba un problema: si querías añadir un método a una interfaz que ya implementaban cien clases, las cien dejaban de compilar. Desde Java 8, una interfaz puede traer métodos **con cuerpo**, de dos clases:

| | `default` | `static` |
|---|---|---|
| Qué es | Un método de cada objeto, con una respuesta por defecto | Un método de la interfaz, no de los objetos |
| Lo heredan las clases | Sí, y pueden sobrescribirlo | No |
| Cómo se llama | `criterion.count(items)` | `Criterion.any(criterion, items)` |

## 2. `default`: escrito una vez, heredado por todos

```java
interface Criterion {

    boolean accepts(Book book);

    default int count(Book[] books) {
        int count = 0;
        for (Book book : books) {
            if (accepts(book)) {
                count++;
            }
        }
        return count;
    }
}
```

Cada criterio escribe `accepts`, y `count` lo tiene gratis. Dentro de `count`, `accepts(book)` es `this.accepts(book)`: el del objeto, por ligadura dinámica. Es el método plantilla de la teoría 02, pero dentro de una interfaz.

Un `default` es una respuesta **por defecto**: la clase que tenga una mejor la sobrescribe con `@Override`, como cualquier método heredado.

```java
class NameCriterion implements Criterion {
    ...
    @Override
    public String label() {
        return "nombre con \"" + query + "\"";
    }
}
```

## 3. `static`: utilidades de la interfaz

```java
interface Criterion {
    ...
    static boolean any(Criterion criterion, Book[] books) {
        return criterion.count(books) > 0;
    }
}

Criterion.any(new AvailableCriterion(), shelf);
```

Un `static` de interfaz se llama **siempre** con el nombre de la interfaz. A diferencia de los de una clase, no se puede llamar a través de una variable:

```java
available.any(available, shelf);
// error: illegal static interface method call
```

## 4. Lo que una interfaz no tiene: estado

Una interfaz no guarda datos de cada objeto. Puede declarar campos, pero todos son `public static final` aunque no lo escribas: **constantes** de la interfaz, iguales para todos.

```java
interface Loanable {
    int MAX_DAYS = 30;          // public static final: una constante
    int loanDays();
}
```

No hay atributos de instancia ni constructor. Por eso los métodos `default` solo pueden trabajar con otros métodos de la interfaz (`accepts`, `loanDays`), nunca con campos de la clase que la implementa: no sabe cuáles tiene. Si una interfaz necesita repetir código entre sus `default`, puede tener métodos `private` (Java 9), que solo ven los demás métodos de la interfaz.

## 5. Dos `default` con el mismo nombre

Una clase implementa varias interfaces, así que puede heredar dos `default` iguales:

```java
interface Loanable { default String label() { return "se presta"; } }
interface Sellable { default String label() { return "se vende"; } }

class Duplicate implements Loanable, Sellable { }
// error: types Loanable and Sellable are incompatible;
//   class Duplicate inherits unrelated defaults for label() from types Loanable and Sellable
```

Java no elige por ti. La clase escribe el suyo, y puede usar cualquiera de los dos con `Interfaz.super.metodo()`:

```java
class Duplicate implements Loanable, Sellable {
    @Override
    public String label() {
        return Loanable.super.label() + " y " + Sellable.super.label();
    }
}
```

Con dos clases padre este problema sería mucho peor (¿de quién son los atributos?), y por eso Java no deja heredar de dos clases. Con interfaces no hay atributos que pelear, solo métodos, y la regla es simple: si hay duda, la clase decide.

## ✅ Comprueba que lo entendiste

1. ¿Qué tiene que escribir una clase que implementa `Criterion`: `accepts`, `count` o los dos? ¿Puede escribir los dos?
2. ¿Por qué `available.any(...)` no compila y `Criterion.any(...)` sí?
3. ¿Por qué un método `default` no puede usar un atributo de la clase que implementa la interfaz?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [03 · Interfaces](03-interfaces.md) | **04 · Métodos `default` y `static`** | [05 · Clase abstracta o interfaz](05-clase-abstracta-o-interfaz.md) |
