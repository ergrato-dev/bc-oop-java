# Ejercicio 03 — De arrays paralelos a objetos

⏱️ 2 h · Teoría previa: [05](../../1-teoria/05-static-y-arrays-de-objetos.md)

## Objetivo

Rehacer el catálogo del ejercicio 03 de la semana 04 con **un array de libros** en lugar de tres arrays paralelos, y comprobar que los dos problemas de entonces desaparecen: ya no se puede crear un libro sin autor, y ordenar mueve cada libro entero. Después distinguirás lo que es de cada objeto de lo que es de la clase (`static`). Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-05-clases_y_objetos/2-practicas/ejercicio-03-de-arrays-paralelos-a-objetos/starter
java Main.java
```

No imprime nada. Abre a la vez el `Main.java` de la semana 04 (`week-04-.../2-practicas/ejercicio-03-sustantivos-verbos-y-crc/starter/Main.java`) y compáralos. Donde había `codes`, `titles` y `authors`, ahora hay una clase `Book` y un solo array, `books`. `describe(i)` recibía una posición; `describe()` es del libro y no la necesita.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. El catálogo

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-311 · Rayuela · Cortázar
BK-042 · Ficciones · Borges
BK-107 · El túnel · Sábato
--
```

La misma salida que en la semana 04, pero `books[0]` ya **es** Rayuela, con sus tres datos dentro. No hay que fiarse de que tres posiciones coincidan.

### 2. Dar de alta un libro

Descomenta el **PASO 2** y ejecuta:

```
Main.java:80: error: constructor Book in class Main.Book cannot be applied to given types;
    books[3] = new Book("BK-500", "Pedro Páramo");
               ^
  required: String,String,String
  found:    String,String
```

En la semana 04 este olvido dejaba un autor `null` en silencio. Ahora ni siquiera compila: el constructor pide código, título **y** autor, y Java no deja crear un libro a medias. El error llega antes de ejecutar, que es el mejor momento.

Arregla la línea 80:

```java
    books[3] = new Book("BK-500", "Pedro Páramo", "Rulfo");
```

Ejecuta. Las cinco últimas líneas:

```
BK-311 · Rayuela · Cortázar
BK-042 · Ficciones · Borges
BK-107 · El túnel · Sábato
BK-500 · Pedro Páramo · Rulfo
--
```

Un solo `Arrays.copyOf`, no tres.

### 3. Ordenar por título

Lee `sortByTitle()`. Recorre el array, busca el título menor de lo que queda (`compareTo` da un número negativo si el primer texto va antes en orden alfabético) y lo intercambia con la posición `i`. Descomenta el **PASO 3** y ejecuta. Las cinco últimas líneas:

```
BK-107 · El túnel · Sábato
BK-042 · Ficciones · Borges
BK-500 · Pedro Páramo · Rulfo
BK-311 · Rayuela · Cortázar
--
```

Cada libro sigue con su código y su autor. El intercambio mueve una **referencia**, y con ella el objeto entero: lo que en la semana 04 obligaba a mover tres posiciones a mano, aquí son tres líneas que no pueden descuadrarse.

### 4. Un atributo `static`

Descomenta el **PASO 4** y ejecuta. La última línea:

```
Libros creados: 4
```

Mira la línea 5: `static int created = 0;`. Un atributo `static` no es de ningún libro, sino de la **clase**: hay un solo `created` para todos, y el constructor lo sube cada vez que nace un libro. Por eso se lee con el nombre de la clase, `Book.created`, no con un libro delante.

Ahora quita la palabra `static` de la línea 5 y ejecuta:

```
Main.java:96: error: non-static variable created cannot be referenced from a static context
    IO.println("Libros creados: " + Book.created);
```

Sin `static`, cada libro tendría su propio `created`, y `Book.created` no sabe de cuál de los cuatro le hablas. Vuelve a poner `static` y comprueba que la salida vuelve a ser `Libros creados: 4`.

### 5. Buscar

Descomenta el **PASO 5** en los dos sitios: los métodos `matches` e `indexOf` dentro de `Book` y las líneas del paso 5 en `main`. Ejecuta. Las tres últimas líneas:

```
BK-107 está en la posición 0
Contiene "el": El túnel
Contiene "el": Rayuela
```

Los dos métodos buscan, pero responden preguntas distintas:

- `matches(query)` es de **instancia**: pregunta a **un** libro si su título contiene el texto. Usa `title`, el del libro sobre el que se llama.
- `indexOf(books, code)` es `static`: busca entre **varios** libros. Ningún libro ve a los demás, así que recibe el array. Es lo mismo que `Stock.indexOf` de tu proyecto, pero con objetos.

BK-107 está en la posición 0 porque el paso 3 ordenó el array.

### 6. Tu turno

Vuelve al enunciado del servicio de bicicletas del ejercicio 03 de la semana 04 y a tu tarjeta CRC de la estación. Al final del archivo, debajo de `main`, escribe una clase `Station` con:

- Atributos `name` (`String`), `docks` (anclajes, `int`) y `bikes` (bicicletas ancladas, `int`), y un constructor que reciba los tres.
- Un método `hasFreeDock()` que devuelva `true` si quedan anclajes libres.
- Un método `dock()` que ancle una bicicleta (sube `bikes`).

Al final de `main`, añade:

```java
    Station center = new Station("Centro", 2, 1);
    IO.println(center.hasFreeDock());
    center.dock();
    IO.println(center.hasFreeDock());
```

Debes ver `true` y después `false`. ¿Qué debería hacer `dock()` si no queda anclaje libre? Apúntalo: en la semana 06 aprenderás a impedirlo.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| El paso 2 sigue sin compilar con `"Rulfo"` | Comprueba las comillas y la coma: `"Pedro Páramo", "Rulfo"` son dos argumentos separados por coma |
| `error: cannot find symbol ... method matches(String)` | Descomentaste el paso 5 en `main`, pero no los métodos dentro de `Book` |
| `BK-107 está en la posición 2` | No descomentaste el paso 3: sin ordenar, BK-107 sigue en su posición original |
| `NullPointerException ... because "<local4>" is null` | Quitaste la línea 80 del paso 2: el array creció a 4 y la última posición quedó en `null`. `<local4>` es la variable `book` del bucle de `printAll`: `java Main.java` no guarda los nombres de las variables locales |
| Los nombres salen con caracteres raros (`SÃ¡bato`) | Tu terminal no está en UTF-8: en Windows, `chcp 65001` antes de ejecutar |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Referencias y `null`](../ejercicio-02-referencias-y-null/README.md) | **Ejercicio 03 · De arrays paralelos a objetos** | [Proyecto](../../3-proyecto/README.md) |
