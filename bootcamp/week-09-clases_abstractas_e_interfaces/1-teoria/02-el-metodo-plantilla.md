# 02 · El método plantilla

⏱️ 40 min

## 1. El esqueleto en el padre, los huecos en las hijas

En la semana 08, `card()` de `Book` llamaba a `describe()`, y cada hija sobrescribía `describe()`. Con una clase abstracta, ese patrón se vuelve más fuerte: el padre escribe el esqueleto de una operación y **declara** los pasos que faltan como métodos abstractos.

```java
abstract class LibraryItem {
    ...
    final String loanSlip(String member) {
        return "Préstamo de " + code + " a " + member
                + " · devolver en " + loanDays() + " días"
                + notes();
    }

    abstract int loanDays();

    String notes() {
        return "";
    }
}
```

`loanSlip` es un **método plantilla** (*template method*): fija el orden y el formato del recibo, y deja dos huecos:

| Hueco | Tipo | Qué hace la hija |
|---|---|---|
| `loanDays()` | Abstracto | **Tiene** que escribirlo: el padre no sabe la respuesta |
| `notes()` | Con cuerpo, vacío | **Puede** sobrescribirlo si tiene algo que añadir |

```java
class Dvd extends LibraryItem {
    @Override
    int loanDays() {
        return 3;
    }

    @Override
    String notes() {
        return " · con su carátula";
    }
}
```

Un libro escribe solo `loanDays()`; un DVD, los dos. El recibo sale con el mismo formato para todos, y nadie lo copia.

## 2. `final`: que nadie cambie el esqueleto

`loanSlip` lleva `final`. Un método `final` **no se puede sobrescribir**:

```java
class Magazine extends LibraryItem {
    @Override
    String loanSlip(String member) { ... }
    // error: loanSlip(String) in Magazine cannot override loanSlip(String) in LibraryItem
    //   overridden method is final
}
```

Sin `final`, una hija podría cambiar el recibo entero y saltarse el formato común. Con `final`, el padre dice: "esto es fijo; lo que podéis cambiar son los huecos". Ya conoces `final` en atributos (no se reasignan); en métodos, no se sobrescriben. Una **clase** `final` no puede tener hijas: es el caso de `String`.

## 3. Por qué el padre puede llamar a un método sin cuerpo

`loanSlip()` llama a `loanDays()`, que en `LibraryItem` no tiene cuerpo. Aun así compila y funciona, por las dos reglas que ya conoces:

1. Nunca habrá un objeto que sea solo `LibraryItem`: es abstracta.
2. Toda hija concreta **tiene** el método: el compilador lo exige.

Así que cuando el programa ejecute `loanDays()`, el objeto siempre tendrá uno, y la ligadura dinámica lo encontrará.

## 4. Cuidado con llamarlo desde el constructor

Hay un sitio donde el hueco puede no estar listo: el constructor del padre.

```java
abstract class LibraryItem {
    LibraryItem(String code, String title) {
        ...
        IO.println(loanSlip("nadie"));   // mala idea
    }
}
```

Cuando se crea un `Dvd`, el constructor de `LibraryItem` se ejecuta **antes** que el resto del de `Dvd`. Si el `loanDays()` del `Dvd` usara un atributo del `Dvd`, todavía valdría `0` o `null`. La regla: no llames a métodos que las hijas sobrescriben desde un constructor.

## ✅ Comprueba que lo entendiste

1. En `loanSlip`, ¿qué diferencia hay entre el hueco `loanDays()` y el hueco `notes()`?
2. ¿Qué pasaría sin el `final` de `loanSlip`? ¿Quién podría romper el formato del recibo?
3. ¿Por qué `loanSlip` puede llamar a `loanDays()`, si en `LibraryItem` no tiene cuerpo?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [01 · Clases abstractas](01-clases-abstractas.md) | **02 · El método plantilla** | [03 · Interfaces](03-interfaces.md) |
