# Ejercicio 03 — `instanceof` y polimorfismo en lugar de condicionales

⏱️ 2 h · Teoría previa: [04](../../1-teoria/04-instanceof-y-casting.md) y [05](../../1-teoria/05-polimorfismo-en-lugar-de-condicionales.md)

## Objetivo

Bajar de una variable `Book` a un `RareBook` con un *cast*, ver cómo revienta un *cast* equivocado y protegerlo con `instanceof`. Después escribes una regla con una cadena de `instanceof`, llega una clase nueva y la regla falla **sin avisar**. La arreglas como se arregla de verdad: llevando la regla a cada clase con un método sobrescrito. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-08-polimorfismo/2-practicas/ejercicio-03-instanceof-y-polimorfismo-en-lugar-de-condicionales/starter
java Main.java
```

No imprime nada. Hay cuatro clases: `Book` y tres hijas, `RareBook` (con sala), `AudioBook` (con minutos) y `Magazine`. La regla de préstamo: un libro se presta 14 días; un libro raro, 0 (no sale); un audiolibro, 21; una revista, 7. Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Bajar de `Book` a `RareBook` con un *cast*

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
Sala: Sala de fondo antiguo
```

En el ejercicio 01, `chronicle.getRoom()` no compilaba porque la variable es `Book`. `(RareBook) chronicle` es un ***cast*** (conversión de tipo) hacia abajo, un *downcast*: le dices al compilador "créeme, aquí dentro hay un `RareBook`". El compilador te cree y te deja guardarlo en una variable `RareBook`, que sí tiene `getRoom()`.

### 2. Un *cast* equivocado compila y revienta al ejecutar

Descomenta la línea del **PASO 2** (línea 20) y ejecuta. La última línea de tu programa y el error:

```
Sala: Sala de fondo antiguo
Exception in thread "main" java.lang.ClassCastException: class Book cannot be cast to class RareBook (Book and RareBook are in unnamed module of loader com.sun.tools.javac.launcher.MemoryClassLoader @6f3b5d16)
	at Main.main(Main.java:20)
```

El número después de `@` cambia en cada ejecución. Vuelve a comentar la línea. El compilador te creyó, porque una variable `Book` **podría** tener un `RareBook` dentro; pero `ficciones` es un `Book` normal, y al ejecutarse Java comprueba el objeto y lanza `ClassCastException`. Un *cast* es una promesa que el compilador no puede comprobar.

### 3. `instanceof` antes de bajar

Descomenta el **PASO 3** y ejecuta. Las tres últimas líneas:

```
BK-042: se presta
BK-001: solo en la Sala de fondo antiguo
BK-500: se presta
```

`book instanceof RareBook rareBook` hace dos cosas: comprueba si el objeto **es un** `RareBook` y, si lo es, te lo da ya convertido en la variable `rareBook`, que solo existe dentro del `if`. Es el *pattern matching* de `instanceof`: comprobar y convertir en un paso, sin *cast* a mano y sin `ClassCastException` posible.

### 4. Una regla escrita con `instanceof`

Descomenta el método `loanDays(Book)` de `Main` (líneas 63 a 70) y las líneas del **PASO 4** en `main`, y ejecuta. Las tres últimas líneas:

```
BK-042: 14 días
BK-001: 0 días
BK-500: 21 días
```

Funciona. `loanDays` pregunta de qué clase es cada libro y responde según el caso.

### 5. Llega una clase nueva

Descomenta el **PASO 5** y ejecuta. La última línea:

```
RV-007: 14 días
```

Mal: las revistas se prestan 7 días. Pero no hay ningún error, ni al compilar ni al ejecutar. `loanDays` no tiene rama para `Magazine`, así que cae en el `return 14` del final, en silencio. En un programa real habría una cadena así en cada sitio que dependa del tipo (los días, la multa, el texto del aviso...), y cada clase nueva obliga a encontrarlas **todas**.

### 6. La regla, dentro de cada clase

Descomenta el método `loanDays()` de `Book` (líneas 89 a 91), el de `RareBook` (107 a 110), el de `AudioBook` (122 a 125) y el de `Magazine` (135 a 138), y las líneas del **PASO 6** en `main`. Ejecuta. Las cuatro últimas líneas:

```
BK-042: 14 días, sin instanceof
BK-001: 0 días, sin instanceof
BK-500: 21 días, sin instanceof
RV-007: 7 días, sin instanceof
```

Ahora cada clase sabe sus días, y el bucle solo llama a `book.loanDays()`: el objeto elige su versión. Una clase nueva que se olvide de su regla hereda la de `Book`, que es un valor por defecto **escrito a propósito** en un único sitio, no el final de una cadena de `if` que alguien olvidó completar. El `loanDays(Book)` de `Main` ya no hace falta: en un programa real lo borrarías.

### 7. Tu turno

1. Borra el método `getRoom()` de `RareBook` y añade a cada clase un `String loanNotice()` sobrescrito (`"Se presta 14 días"`, `"No sale de la sala"`...). ¿Hace falta todavía el `instanceof` del paso 3?
2. Añade `class Score extends Book` (una partitura: 3 días). ¿Cuántos sitios tocas con la versión del paso 4 y cuántos con la del paso 6?

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `java.lang.ClassCastException: class Book cannot be cast to class RareBook` | Es la prueba del paso 2: vuelve a comentar la línea 20 |
| `cannot find symbol ... method getRoom()` dentro del `if` | Escribiste `book.getRoom()`: usa la variable del patrón, `rareBook.getRoom()` |
| `method does not override or implement a method from a supertype` en el paso 6 | Descomentaste el `loanDays()` de una hija sin el de `Book`: sin él no hay nada que sobrescribir |
| `cannot find symbol ... method loanDays()` en el bucle del paso 6 | Te falta el `loanDays()` de `Book`: la variable es `Book`, y el compilador lo busca ahí |
| `cannot find symbol ... variable shelf` o `variable magazine` | Descomentaste un paso sin los anteriores: el 4 usa `shelf` (paso 3) y el 6 usa `magazine` (paso 5) |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Ligadura dinámica y sobrecarga](../ejercicio-02-ligadura-dinamica-y-sobrecarga/README.md) | **Ejercicio 03 · `instanceof` y polimorfismo en lugar de condicionales** | [Proyecto · Gestión, capa 7](../../3-proyecto/README.md) |
