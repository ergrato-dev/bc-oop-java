# Ejercicio 02 — Ligadura dinámica y sobrecarga

⏱️ 2 h · Teoría previa: [02](../../1-teoria/02-ligadura-dinamica.md) y [03](../../1-teoria/03-sobrecarga-frente-a-sobrescritura.md)

## Objetivo

Ver quién elige el método que se ejecuta. Casi siempre es el **objeto**, mientras el programa se ejecuta (ligadura dinámica), y funciona incluso cuando la llamada está escrita dentro de la clase padre. Hay dos excepciones en las que elige el **compilador** con el tipo de la variable: la sobrecarga y los métodos `static`. Al final añades una clase nueva sin tocar ni el padre ni el bucle que la usa. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-08-polimorfismo/2-practicas/ejercicio-02-ligadura-dinamica-y-sobrecarga/starter
java Main.java
```

No imprime nada. `Book` tiene un método `card()` que llama a `describe()`, y un `kind()`. `RareBook` sobrescribe `describe()` y `kind()`, pero **no** `card()`. Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. `Book` llama a un método que sus hijas sobrescriben

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
[ BK-042 · Ficciones · ejemplares: 2 ]
[ BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo ]
```

`card()` solo existe en `Book`, y su `describe()` está escrito **dentro de `Book`**. Aun así, para el libro raro sale la sala. Cuando el programa llama a `describe()`, busca el método empezando por la clase del objeto (`RareBook`), y solo si no lo encuentra sube al padre. Da igual dónde esté escrita la llamada: manda el objeto. Es la **ligadura dinámica** (*dynamic binding*).

### 2. La sobrecarga la elige el compilador

Descomenta los dos métodos `kind()` de `Main` (líneas 45 a 50) y las líneas del **PASO 2** en `main`, y ejecuta. Las dos últimas líneas:

```
kind(chronicle): un libro
chronicle.kind(): un libro raro
```

Los dos preguntan lo mismo sobre el mismo objeto, y responden distinto:

- `kind(chronicle)` elige entre dos métodos **sobrecargados** de `Main`: uno recibe `Book` y otro `RareBook`. Esa elección la hace el compilador, al compilar, y el compilador solo ve la variable: `Book`. Gana `kind(Book)`.
- `chronicle.kind()` es un método **sobrescrito** en `RareBook`. Esa elección la hace el objeto, al ejecutarse. Gana el de `RareBook`.

Sobrecarga, el tipo de la variable. Sobrescritura, el tipo del objeto.

### 3. Los métodos `static` no se sobrescriben

Descomenta el método `origin()` de `Book` (líneas 82 a 84) y el de `RareBook` (líneas 106 a 108), y las líneas del **PASO 3** en `main`. Ejecuta. Las dos últimas líneas:

```
chronicle.origin(): la clase Book
RareBook.origin(): la clase RareBook
```

`origin()` es `static`: pertenece a la clase, no al objeto, así que no hay objeto que elija. `chronicle.origin()` compila (Java deja llamar a un `static` a través de una variable), pero lo resuelve el compilador con el tipo de la variable, `Book`. El `origin()` de `RareBook` no sobrescribe el de `Book`: lo **oculta**, y solo se usa si escribes `RareBook.origin()`.

Compruébalo: añade `@Override` en la línea de encima de `static String origin()` de `RareBook` y ejecuta:

```
Main.java:106: error: static methods cannot be annotated with @Override
    @Override
    ^
1 error
```

Borra el `@Override`. Por eso llamar a un `static` con el nombre de la clase (`Book.origin()`) y no con una variable es lo honesto: deja claro que no hay polimorfismo.

### 4. Una clase nueva, sin tocar `Book` ni el bucle

Descomenta la clase `Magazine` al final del archivo (líneas 112 a 122) y las líneas del **PASO 4** en `main`, y ejecuta. Las tres últimas líneas:

```
[ BK-042 · Ficciones · ejemplares: 2 ]
[ BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo ]
[ RV-007 · Revista de Occidente · ejemplares: 4 · número 512 ]
```

`Magazine` no existía cuando se escribió `card()`, ni cuando se escribió el bucle, y los dos funcionan con ella. Con el polimorfismo, el código que trabaja con `Book` está **abierto** a clases nuevas y **cerrado** a cambios: no hay que tocarlo. En tu proyecto, tu `Inventory` funciona igual.

### 5. Tu turno

1. Añade a `Main` un tercer `kind(Magazine m)` que devuelva `"una revista"`. Con `Book rack0 = new Magazine(...)`, ¿qué imprime `kind(rack0)`? ¿Y si la variable es `Magazine`?
2. Sobrescribe `kind()` en `Magazine`. Escribe en una frase por qué el bucle del paso 4 no necesita saber de qué clase es cada objeto para llamar a `kind()`, y por qué no podría hacer lo mismo con los `kind(...)` de `Main`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `static methods cannot be annotated with @Override` | Es la prueba del paso 3: borra el `@Override` de encima de `origin()` |
| `cannot find symbol ... method kind(Book)` | Descomentaste el paso 2 en `main` sin los dos `kind()` de `Main` |
| `cannot find symbol ... method origin()` | Te falta descomentar el `origin()` de `Book`: `chronicle.origin()` lo busca en `Book` |
| `cannot find symbol ... class Magazine` | Te falta descomentar la clase `Magazine` al final del archivo |
| `reached end of file while parsing` | Dejaste comentada la `}` final de `Magazine` (línea 122) |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Tipo estático y tipo dinámico](../ejercicio-01-tipo-estatico-y-tipo-dinamico/README.md) | **Ejercicio 02 · Ligadura dinámica y sobrecarga** | [Ejercicio 03 · `instanceof` y polimorfismo en lugar de condicionales](../ejercicio-03-instanceof-y-polimorfismo-en-lugar-de-condicionales/README.md) |
