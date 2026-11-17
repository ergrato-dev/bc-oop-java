# Ejercicio 01 — Clases abstractas

⏱️ 2 h · Teoría previa: [01](../../1-teoria/01-clases-abstractas.md) y [02](../../1-teoria/02-el-metodo-plantilla.md)

## Objetivo

Trabajar con una clase que **no se puede crear**, pero que guarda lo común de sus hijas y las obliga a escribir lo que solo ellas saben. Ves los dos errores que pone el compilador (crear el padre y olvidar el método abstracto), compruebas que el constructor del padre sí se ejecuta y proteges el esqueleto con `final`. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-09-clases_abstractas_e_interfaces/2-practicas/ejercicio-01-clases-abstractas/starter
java Main.java
```

No imprime nada. Lee las clases de debajo de `Main`:

- `LibraryItem` es `abstract`: tiene código, título y constructor, un método `loanDays()` **sin cuerpo** y un `card()` que lo usa.
- `Book` y `Magazine` heredan de `LibraryItem` y cada una escribe su `loanDays()`.

Los números de línea de este README cuentan con que no añades ni quitas líneas, salvo donde el paso 3 te pide añadirlas.

## Pasos

### 1. Las hijas sí se crean

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042 · Ficciones · 14 días
RV-007 · Revista de Occidente · 7 días
```

El array es de `LibraryItem` y tiene un `Book` y una `Magazine`. `card()` está escrito en `LibraryItem` y llama a `loanDays()`, que en `LibraryItem` **no tiene cuerpo**: lo que se ejecuta es el `loanDays()` del objeto, como en la semana 08. Una variable puede ser de una clase abstracta; lo que no puede existir es un objeto de esa clase.

### 2. El padre abstracto no se crea

Descomenta la línea del **PASO 2** y ejecuta:

```
Main.java:22: error: LibraryItem is abstract; cannot be instantiated
        LibraryItem something = new LibraryItem("XX-001", "Algo de la biblioteca");
                                ^
```

Si se pudiera crear, ¿cuántos días se prestaría "algo de la biblioteca"? Su `loanDays()` no tiene cuerpo: no hay respuesta. Por eso Java no deja crear objetos de una clase `abstract`. Vuelve a comentar la línea 22.

### 3. Una hija tiene que escribir el método abstracto

Descomenta la clase `Dvd`, al final del archivo (líneas 114 a 118), y la línea del **PASO 3** en `main`. Ejecuta:

```
Main.java:114: error: Dvd is not abstract and does not override abstract method loanDays() in LibraryItem
class Dvd extends LibraryItem {
^
```

Heredar de una clase abstracta es aceptar un contrato: o escribes sus métodos abstractos, o tu clase también es abstracta. Escribe tú el que falta, dentro de `Dvd`, debajo del constructor:

```java
    @Override
    int loanDays() {
        return 3;
    }
```

Ejecuta. Las dos últimas líneas:

```
RV-007 · Revista de Occidente · 7 días
DV-010 · Metrópolis · 3 días
```

`Dvd` no escribió `card()` y su ficha sale igual: la hereda, y dentro usa su `loanDays()`.

### 4. El constructor del padre abstracto sí se ejecuta

Descomenta el **PASO 4** y ejecuta. La última línea:

```
Rechazado: Código vacío
```

Nadie puede escribir `new LibraryItem(...)`, pero su constructor se ejecuta cada vez que se crea una hija: `Magazine` lo llama con `super(code, title)`, y es él quien rechaza el código vacío. Una clase abstracta guarda datos, los valida y los hereda, como cualquier padre.

### 5. Un método `final` no se sobrescribe

Descomenta el método `card()` de `Magazine` (líneas 107 a 110) y ejecuta:

```
Main.java:108: error: card() in Magazine cannot override card() in LibraryItem
    String card() {
           ^
  overridden method is final
```

`card()` es `final` en `LibraryItem` (línea 72): el esqueleto de la ficha es el mismo para todas las hijas, y ninguna puede cambiarlo. Solo pueden cambiar lo que el padre deja abierto, `loanDays()`.

Para ver qué protege, quita `final` de la línea 72 y ejecuta. Las tres últimas líneas:

```
BK-042 · Ficciones · 14 días
Número 512 · RV-007 · Revista de Occidente · 7 días
DV-010 · Metrópolis · 3 días
```

Ahora la revista tiene una ficha distinta a las demás. A veces eso es lo que quieres; cuando no, `final` lo impide. Vuelve a poner `final` y a comentar el `card()` de `Magazine`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `LibraryItem is abstract; cannot be instantiated` | Es la prueba del paso 2: vuelve a comentar la línea 22 |
| `Dvd is not abstract and does not override abstract method loanDays()` | Es el error del paso 3: escribe `loanDays()` dentro de `Dvd` |
| `cannot find symbol ... class Dvd` | Descomentaste la línea del paso 3 en `main` sin la clase `Dvd` del final del archivo |
| `method does not override or implement a method from a supertype` en `Dvd` | El método que escribiste no se llama `loanDays()` o tiene parámetros: debe ser `int loanDays()` sin parámetros |
| `overridden method is final` | Es la prueba del paso 5: vuelve a comentar el `card()` de `Magazine` |
| `missing method body, or declare abstract` | Borraste `abstract` de `loanDays()` en `LibraryItem` (línea 69): un método sin cuerpo tiene que ser `abstract` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · Clase abstracta o interfaz](../../1-teoria/05-clase-abstracta-o-interfaz.md) | **Ejercicio 01 · Clases abstractas** | [Ejercicio 02 · Interfaces](../ejercicio-02-interfaces/README.md) |
