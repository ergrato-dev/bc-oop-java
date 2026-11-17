# Ejercicio 02 — Referencias y `null`

⏱️ 2 h · Teoría previa: [04](../../1-teoria/04-referencias-y-null.md)

## Objetivo

Comprobar qué guarda de verdad una variable de tipo `Book`: una **referencia** al objeto, no el objeto. Lo verás en las cuatro situaciones donde más sorprende: al asignar, al comparar con `==`, al pasar un objeto a un método y al crear un array de objetos. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-05-clases_y_objetos/2-practicas/ejercicio-02-referencias-y-null/starter
java Main.java
```

No imprime nada. Arriba de `main` están la clase `Book`, ya con constructor y `describe()`, un array `shelf` y tres métodos que reciben un libro o un número: `emptyShelf`, `replace` y `addOne`. Léelos antes de seguir y apunta qué crees que hará cada uno.

Ten a mano papel: en cada paso dibuja las variables como cajas y los objetos como nubes, con flechas de la caja a la nube, como en la [teoría 04](../../1-teoria/04-referencias-y-null.md).

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Dos variables, un objeto

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042 · Ficciones · ejemplares: 0
```

Se cambió `alias.copies`, y `original` también tiene 0. `alias = original` no copia el libro: copia la flecha. Hay **un** objeto con dos variables que apuntan a él; las dos son **alias** del mismo libro.

### 2. `==` compara referencias

Descomenta el **PASO 2** y ejecuta. Las dos últimas líneas:

```
original == alias: true
original == twin: false
```

`twin` tiene los mismos datos que `original`, pero es otro objeto, fruto de otro `new`. Con objetos, `==` pregunta "¿es la misma flecha?", no "¿tienen lo mismo?". Para comparar contenidos los objetos tienen `equals`, que escribirás para tus clases en la semana 11. Con `String` usas `equals` desde la semana 02 por esta misma razón.

### 3. Pasar un objeto a un método

Descomenta el **PASO 3** y ejecuta. La última línea:

```
BK-311 · Rayuela · ejemplares: 0
```

Rayuela tenía 3 y `emptyShelf` la dejó a 0. Java pasa a los métodos una **copia** de lo que tiene la variable: aquí, una copia de la flecha. El parámetro `book` apunta al mismo libro que `rayuela`, y lo que el método cambia con `book.copies` lo ve quien lo llamó.

### 4. Lo que un método no puede cambiar

Descomenta el **PASO 4** y ejecuta. Las dos últimas líneas:

```
BK-311 · Rayuela · ejemplares: 0
copies: 5
```

Ni `replace` ni `addOne` cambiaron nada fuera:

- `replace` hace que **su copia** de la flecha apunte a un libro nuevo. `rayuela` sigue apuntando a Rayuela, y el libro nuevo se pierde al terminar el método.
- `addOne` recibe una copia del número 5 y la sube a 6. El `copies` de `main` no se entera.

La regla es una sola: Java siempre pasa copias. Con un `int` se copia el número; con un objeto, la flecha. Por eso un método puede cambiar **el objeto** que recibe, pero nunca qué objeto tiene la variable de quien lo llama.

### 5. Un array de objetos nace lleno de `null`

Descomenta el **PASO 5** y ejecuta. El final de la salida:

```
[Main$Book@6a400542, null, null]
BK-311 · Rayuela · ejemplares: 0
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Main$Book.describe()" because "this.shelf[1]" is null
	at Main.main(Main.java:81)
```

El número después de `@` cambia en cada ejecución: es lo que Java imprime de un objeto que no sabe describirse (lo arreglarás con `toString` en la semana 11).

`new Book[3]` crea tres **referencias**, todas `null`, no tres libros. La posición 0 apunta a Rayuela; la 1 y la 2, a nada. Llamar a un método sobre `null` lanza `NullPointerException`, y el mensaje dice exactamente qué era `null`: `this.shelf[1]`, en la línea 81.

### 6. Comprobar `null` antes de usar

Vuelve a comentar la línea 81 (`IO.println(shelf[1].describe());`), descomenta el **PASO 6** y ejecuta. La última línea:

```
En la estantería: BK-311 · Rayuela · ejemplares: 0
```

El bucle recorre las tres posiciones y salta las vacías con `book != null`. Es la forma de recorrer un array a medio llenar. En la semana 13 cambiarás los arrays por listas, que solo guardan lo que añades.

### 7. Tu turno, en papel

Sin ejecutar, escribe qué imprime este código y dibuja las flechas. Después cópialo al final de `main` y compruébalo:

```java
    Book a = new Book("BK-500", "Pedro Páramo", 1);
    Book b = a;
    b = new Book("BK-501", "El llano en llamas", 4);
    b.copies--;
    IO.println(a.describe());
    IO.println(b.describe());
```

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: cannot find symbol ... variable original` | Descomentaste el paso 2 sin el paso 1, donde se crea `original` |
| `error: cannot find symbol ... variable rayuela` | El paso 4 y el 5 usan `rayuela`, que se crea en el paso 3 |
| En el paso 6 sigue saliendo `NullPointerException` | No volviste a comentar la línea 81 del paso 5 |
| El número después de `@` no coincide con el del README | Es normal: cambia en cada ejecución |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Clases y objetos](../ejercicio-01-clases-y-objetos/README.md) | **Ejercicio 02 · Referencias y `null`** | [Ejercicio 03 · De arrays paralelos a objetos](../ejercicio-03-de-arrays-paralelos-a-objetos/README.md) |
