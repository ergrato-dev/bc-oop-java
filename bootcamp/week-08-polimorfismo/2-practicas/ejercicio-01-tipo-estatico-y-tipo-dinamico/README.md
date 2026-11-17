# Ejercicio 01 — Tipo estático y tipo dinámico

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-una-variable-muchas-formas.md)

## Objetivo

Separar dos tipos que hasta ahora parecían el mismo: el de la **variable** (lo que sabe el compilador) y el del **objeto** (lo que se creó con `new`). Guardas un libro raro en una variable `Book`, ves qué te deja llamar el compilador y qué ejecuta el objeto, metes tres clases en un mismo array y escribes un método que acepta cualquiera de ellas. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-08-polimorfismo/2-practicas/ejercicio-01-tipo-estatico-y-tipo-dinamico/starter
java Main.java
```

No imprime nada. Debajo de `Main` hay tres clases: `Book`, y sus dos hijas, `RareBook` (con sala) y `AudioBook` (con minutos). Las dos sobrescriben `describe()`. Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Una variable `Book` con un `RareBook` dentro

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo
La variable es Book; el objeto es RareBook
```

`Book chronicle = new RareBook(...)` compila porque un `RareBook` **es un** `Book` (semana 07). Hay dos tipos en esa línea: el **tipo estático** de la variable, `Book`, que es el que escribiste a la izquierda, y el **tipo dinámico** del objeto, `RareBook`, el que creó `new`. `getClass()` te dice el del objeto. Y `describe()` ejecuta el del objeto: por eso sale la sala.

### 2. La variable decide qué se puede llamar

Descomenta la línea del **PASO 2** (línea 18) y ejecuta:

```
Main.java:18: error: cannot find symbol
        IO.println(chronicle.getRoom());
                            ^
  symbol:   method getRoom()
  location: variable chronicle of type Book
1 error
error: compilation failed
```

Vuelve a comentarla. El objeto **sí** tiene `getRoom()`, pero el compilador no mira el objeto: mira la variable, que es `Book`, y un `Book` no tiene sala. El compilador solo deja llamar a los métodos del tipo estático. Lo que se ejecuta después lo decide el tipo dinámico.

### 3. Un array de `Book` con tres clases dentro

Descomenta el **PASO 3** y ejecuta. Las tres últimas líneas:

```
BK-042 · Ficciones · ejemplares: 2
BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo
BK-500 · Pedro Páramo · ejemplares: 3 · 241 min
```

Un array de `Book` puede guardar cualquier objeto que **sea un** `Book`. El bucle llama a `book.describe()` con la misma línea para los tres, y cada uno ejecuta **su** `describe()`: el de `Book`, el de la sala y el de los minutos. Eso es el **polimorfismo**: una misma llamada, varias formas de responder.

### 4. Un parámetro `Book` acepta cualquier hija

Descomenta el método `label()` de `Main` (líneas 50 a 52) y las líneas del **PASO 4** en `main`, y ejecuta. Las tres últimas líneas:

```
Ficha de BK-042: BK-042 · Ficciones · ejemplares: 2
Ficha de BK-001: BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo
Ficha de BK-500: BK-500 · Pedro Páramo · ejemplares: 3 · 241 min
```

`label(Book book)` no sabe que existen `RareBook` ni `AudioBook`, y no le hace falta: recibe "un `Book`" y le pide su código y su descripción. Si mañana escribes una cuarta hija, `label()` la acepta sin cambiar una línea.

### 5. Al revés no se puede

Descomenta la línea del **PASO 5** (línea 46) y ejecuta:

```
Main.java:46: error: incompatible types: Book cannot be converted to RareBook
        RareBook fake = new Book("BK-002", "Códice", 1);
                        ^
1 error
error: compilation failed
```

Vuelve a comentarla. Todo `RareBook` es un `Book`, pero no todo `Book` es un `RareBook`: un libro cualquiera no tiene sala, y una variable `RareBook` promete que la tiene. Subir de la hija al padre (*upcasting*) es automático; bajar del padre a la hija lo verás en el ejercicio 03.

### 6. Tu turno

1. Cambia la línea del paso 1 a `RareBook chronicle = new RareBook(...)`. ¿Compila ahora el paso 2? ¿Y el paso 3, que mete `chronicle` en un array de `Book`?
2. Escribe una cuarta clase, `Magazine extends Book`, con un número (`issue`) y un `describe()` que lo añada. Métela en el array del paso 3. ¿Cuántas líneas cambiaste en el bucle y en `label()`?

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| Sigue saliendo `cannot find symbol ... method getRoom()` | No volviste a comentar la línea del paso 2 |
| Sigue saliendo `incompatible types: Book cannot be converted to RareBook` | No volviste a comentar la línea del paso 5 |
| `cannot find symbol ... variable chronicle` o `variable shelf` | Descomentaste un paso sin los anteriores: el 3 usa `chronicle` (paso 1) y el 4 usa `shelf` (paso 3) |
| `cannot find symbol ... method label(Book)` | Descomentaste el paso 4 en `main` sin el método `label()` de más abajo |
| `illegal start of expression` en el array | Te dejaste comentada la línea `};` que cierra el array del paso 3 |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · Polimorfismo en lugar de condicionales](../../1-teoria/05-polimorfismo-en-lugar-de-condicionales.md) | **Ejercicio 01 · Tipo estático y tipo dinámico** | [Ejercicio 02 · Ligadura dinámica y sobrecarga](../ejercicio-02-ligadura-dinamica-y-sobrecarga/README.md) |
