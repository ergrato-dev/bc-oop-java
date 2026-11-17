# Ejercicio 03 — Composición y copias defensivas

⏱️ 2 h · Teoría previa: [04](../../1-teoria/04-final-e-inmutabilidad.md) y [05](../../1-teoria/05-composicion-y-delegacion.md)

## Objetivo

Construir un objeto hecho de otros objetos: una estantería que **tiene** libros, los guarda en un array `private`, pone sus propias reglas (sin códigos repetidos, sin pasarse de capacidad) y delega en cada libro lo que es del libro. Después, ver cómo un método inocente deja escapar ese array y cómo lo evita una copia. Es lo mismo que harás en el proyecto con `Inventory`. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-06-encapsulacion_constructores_y_composicion/2-practicas/ejercicio-03-composicion-y-copias-defensivas/starter
java Main.java
```

No imprime nada. Lee las dos clases de debajo de `Main` antes de seguir:

- `Book`: encapsulado, con `lend()`, como en el ejercicio 01.
- `Shelf`: un array `private final Book[] books` y un contador `size`. Las posiciones de `0` a `size - 1` tienen libros; el resto, `null`. Tiene dos métodos que devuelven sus libros: `leakyBooks()` y `books()`. Fíjate en la diferencia.

En `Main`, `tryToAdd` intenta añadir un libro e imprime `Añadido:` o `Rechazado:`.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Una estantería tiene libros

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
2 libros, 3 ejemplares
```

`Shelf` no hereda de `Book` ni es un `Book`: **tiene** libros. Es una **composición**: un objeto construido con otros objetos dentro. `main` ya no maneja un array de libros y un contador por su cuenta, como en la semana 05; le pide a la estantería que añada y que sume.

### 2. La estantería delega en sus libros

Descomenta el **PASO 2** y ejecuta. Las dos últimas líneas:

```
2 libros, 2 ejemplares
Rechazado: No quedan ejemplares de BK-311
```

`shelf.lend("bk-311")` no resta nada por su cuenta: busca el libro y llama a **su** `lend()`. Eso es **delegar**. La regla "no se presta sin ejemplares" sigue viviendo en un solo sitio, `Book`, y la estantería la respeta sin repetirla: el mensaje de error es el del libro.

### 3. El dueño pone las reglas de la colección

Descomenta el **PASO 3** y ejecuta. Las tres últimas líneas:

```
Rechazado: Código repetido: BK-042
Añadido: BK-107 · El túnel · ejemplares: 4
Rechazado: Estantería llena: 3
```

Ningún libro puede saber si su código está repetido o si la estantería está llena: un libro no ve a los demás. Esas reglas son de `Shelf`, y como su array es `private`, nadie puede saltárselas metiendo un libro "por la puerta de atrás".

### 4. Un array que se escapa

Descomenta el **PASO 4** y ejecuta. El final de la salida:

```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Book.getCopies()" because "this.books[<local2>]" is null
	at Shelf.total(Main.java:150)
	at Main.main(Main.java:48)
```

(`<local2>` es la variable `i` del bucle de `total`: al ejecutar con `java Main.java`, Java no guarda los nombres de las variables locales.)

El array es `private`... y aun así alguien lo rompió desde `main`. `leakyBooks()` devuelve **la referencia** al array de la estantería: `leaked` y `books` son alias del mismo array, como en la semana 05. Poner `null` en `leaked[0]` lo pone en la estantería, y `total()` revienta. `private` protege la variable `books`, no el array al que apunta, si tú mismo repartes la flecha.

### 5. Una copia defensiva

Vuelve a comentar las líneas 46 a 48 (las tres del paso 4). Descomenta el **PASO 5** y ejecuta. La última línea:

```
[BK-042, BK-311, BK-107] · 6 ejemplares
```

`books()` devuelve `Arrays.copyOf(books, size)`: un array **nuevo**, con las posiciones ocupadas. Es una **copia defensiva**. `copy[0] = null` cambia la copia, y la estantería sigue con sus tres libros y sus 6 ejemplares. De paso, la copia no lleva las posiciones vacías: quien la recibe no tiene que saltar `null`.

### 6. La copia es del array, no de los libros

Descomenta el **PASO 6** y ejecuta. La última línea:

```
5 ejemplares
```

`again[2].lend()` sí cambió la estantería: de 6 a 5. `Arrays.copyOf` copia las **flechas**, no los libros: la posición 2 de la copia apunta al mismo El túnel que la estantería. Aquí no es un problema, porque `Book` se protege solo (no deja prestar sin ejemplares ni poner −5). La copia defensiva protege lo que `Shelf` controla, su array; cada libro protege lo suyo.

### 7. Tu turno

1. Añade a `Shelf` un método `available()` que devuelva cuántos libros tienen al menos un ejemplar. ¿Lo escribes con `books[i].getCopies() > 0` o le añades a `Book` un `isAvailable()`? ¿Cuál deja la regla en el sitio correcto?
2. Borra `leakyBooks()`. ¿Qué línea deja de compilar? Esa es la única que dependía del array de verdad.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol ... variable shelf` | Todos los pasos usan la `shelf` del paso 1: descoméntalo primero |
| En el paso 5 sigue saliendo `NullPointerException` | No volviste a comentar las líneas 46 a 48 del paso 4 |
| `cannot find symbol ... class Arrays` | Borraste `import java.util.Arrays;` del principio del archivo |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Constructores que validan](../ejercicio-02-constructores-que-validan/README.md) | **Ejercicio 03 · Composición y copias defensivas** | [Proyecto · Gestión, capa 5](../../3-proyecto/README.md) |
