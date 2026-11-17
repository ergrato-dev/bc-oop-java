# Ejercicio 03 — `protected`, `final` y cuándo no heredar

⏱️ 2 h · Teoría previa: [04](../../1-teoria/04-protected-y-final.md) y [05](../../1-teoria/05-cuando-heredar-y-cuando-componer.md)

## Objetivo

Ver los límites de la herencia. `protected` abre un atributo a las subclases y a todo el paquete. `final` impide sobrescribir un método o heredar de una clase. Y hay dos errores de diseño que compilan sin quejarse: heredar de una clase que no tiene nada que ver ("un préstamo es un libro") y sobrescribir un método sin cumplir lo que prometía el padre. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-07-herencia/2-practicas/ejercicio-03-protected-final-y-cuando-no-heredar/starter
java Main.java
```

No imprime nada. Lee antes de seguir; hay más clases que en los ejercicios anteriores:

- `Book`: esta vez `copies` es `protected`, no `private`, y `getCode()` es `final`.
- `RareBook extends Book`: con un método `restore()` que escribe en `copies` directamente.
- `Isbn`: una clase `final`.
- `Loan extends Book` y `BookLoan`: dos formas de escribir un préstamo.
- `GhostBook extends Book`: un libro cuyo `lend()` no hace nada.

Los pasos 2 y 3 descomentan código fuera de `main`. Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. `protected` deja entrar a la subclase... y al resto del paquete

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-001 · Crónica de Núremberg · ejemplares: 1
BK-001 · Crónica de Núremberg · ejemplares: -7
```

La primera línea es lo esperado: `restore()` de `RareBook` puede escribir en `copies` porque es `protected`, y `protected` deja entrar a las subclases. La segunda es la sorpresa: **`Main`**, que no es ninguna subclase, también escribió en `copies` y dejó el libro con −7 ejemplares.

`protected` significa "las subclases **y** las clases del mismo paquete". Aquí todas las clases están en el mismo archivo, así que están en el mismo paquete; en tu proyecto, todo `gestion` también lo está. Un atributo `protected` está casi tan abierto como uno sin modificador. Por eso, en tus clases, los atributos siguen siendo `private`, y las subclases usan los *getters* y las órdenes del padre, como harás en el proyecto.

### 2. Un método `final` no se sobrescribe

Descomenta el método `getCode()` dentro de `RareBook` (líneas 117 a 120) y ejecuta:

```
Main.java:118: error: getCode() in RareBook cannot override getCode() in Book
    String getCode() {
           ^
  overridden method is final
1 error
error: compilation failed
```

Vuelve a comentarlo. `getCode()` es `final` en `Book`: ninguna subclase puede cambiar cómo se lee el código. Es útil cuando un método es parte de una regla que nadie debe torcer (aquí, que el código de un libro sea siempre el que validó su constructor).

### 3. De una clase `final` no se hereda

Descomenta la clase `FakeIsbn`, al final del archivo (líneas 179 a 183), y ejecuta:

```
Main.java:179: error: cannot inherit from final Isbn
class FakeIsbn extends Isbn {
                       ^
1 error
error: compilation failed
```

Vuelve a comentarla. Con `final class Isbn`, nadie puede escribir una subclase de `Isbn` que se haga pasar por un ISBN de verdad. `String` es una clase `final` por lo mismo: si escribes `class MyString extends String`, el error es `cannot inherit from final String`.

### 4. Una herencia que no tiene sentido

Descomenta el **PASO 4** y ejecuta. La última línea:

```
BK-042 · Ficciones · ejemplares: 6 · socio: Ana
```

`Loan extends Book` "reutiliza" el código, el título y `describe()`. Compila y funciona... y no tiene sentido. Un préstamo no **es** un libro: con la herencia recibe `restock(5)`, y ahora es un préstamo con 6 ejemplares. Todo lo público de `Book` es público en `Loan`, lo quieras o no.

### 5. La misma idea, por composición

Descomenta el **PASO 5** y ejecuta. Las dos últimas líneas:

```
Ana tiene Ficciones (BK-042)
BK-042 · Ficciones · ejemplares: 1
```

`BookLoan` **tiene** un libro y un socio. Solo ofrece lo que tiene sentido en un préstamo (`describe()`), no se puede reponer, y el préstamo de verdad lo hace el libro: el constructor llama a `book.lend()` y por eso a Ficciones le queda 1 ejemplar. Es la composición de la semana 06. La pregunta que decide: ¿un préstamo **es un** libro, o **tiene un** libro?

### 6. Una subclase que rompe la promesa de su padre

Descomenta el **PASO 6** y ejecuta. La última línea:

```
BK-666 · Libro fantasma · ejemplares: 1
```

Tres préstamos de un libro con 1 ejemplar, y ni un error ni un ejemplar menos. Quien recibe un `Book` cuenta con lo que promete `lend()`: "presto un ejemplar o lanzo `IllegalStateException`". `GhostBook` compila, cabe en una variable `Book`... y no cumple ninguna de las dos cosas. Un programa que lleva la cuenta de los préstamos con `Book` falla en silencio en cuanto le llega un `GhostBook`. Una subclase puede **añadir** reglas (el `RareBook` del ejercicio 02 se negaba, con la excepción que `Book` ya anunciaba), pero no puede dejar de cumplir las del padre.

### 7. Tu turno

1. Cambia `copies` a `private` en `Book`. ¿Qué líneas dejan de compilar? Arregla `restore()` sin tocar `copies`: que use `restock`. ¿Qué pasa ahora con `chronicle.copies = -7`?
2. Escribe el `lend()` de `GhostBook` para que cumpla la promesa de `Book` y, además, imprima `"Préstamo de un libro fantasma"`. Pista: `super.lend()`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| Sigue saliendo `overridden method is final` | No volviste a comentar el `getCode()` de `RareBook` del paso 2 |
| Sigue saliendo `cannot inherit from final Isbn` | No volviste a comentar la clase `FakeIsbn` del paso 3 |
| `copies has private access in Book` | Cambiaste `copies` a `private` (es el paso 7): arregla `restore()` y borra la línea de `main` que escribe en `copies` |
| `cannot find symbol ... variable chronicle` | Descomentaste a medias el paso 1, que crea `chronicle` |
| `error: reached end of file while parsing` | Descomentaste a medias un método o la clase `FakeIsbn`: revisa que su `}` final también esté descomentado |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Sobrescribir métodos](../ejercicio-02-sobrescribir-metodos/README.md) | **Ejercicio 03 · `protected`, `final` y cuándo no heredar** | [Proyecto · Gestión, capa 6](../../3-proyecto/README.md) |
