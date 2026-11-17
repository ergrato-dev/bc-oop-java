# Ejercicio 01 — Extender una clase

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-herencia-y-extends.md) y [02](../../1-teoria/02-constructores-y-super.md)

## Objetivo

Escribir una subclase y ver qué recibe de su clase padre: los métodos sin escribirlos otra vez, el tipo (un libro raro **es** un libro) y la obligación de construir primero la parte del padre con `super(...)`. También lo que **no** recibe: el acceso a sus atributos `private`. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-07-herencia/2-practicas/ejercicio-01-extender-una-clase/starter
java Main.java
```

No imprime nada. Lee antes de seguir:

- `Book`: la clase encapsulada de la semana 06, con `lend()` (prestar un ejemplar) y `describe()`.
- `RareBook extends Book`: un libro raro, que además se guarda en una sala. Solo declara lo que añade: `room`, `getRoom()` y `label()`.

Los pasos 6 y 7 descomentan código **dentro** de `RareBook`. Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. La clase padre

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042 · Ficciones · ejemplares: 1
```

Nada nuevo: un `Book` como los de la semana 06. Va a ser la **clase padre** (o superclase) del resto del ejercicio.

### 2. Una subclase hereda los métodos

Descomenta el **PASO 2** y ejecuta. Las tres últimas líneas:

```
BK-042 · Ficciones · ejemplares: 1
BK-001 · Crónica de Núremberg · ejemplares: 1
BK-001 tiene 0 ejemplares
```

Busca `describe`, `lend` o `getCode` dentro de `RareBook`: no están. `extends Book` hace que `RareBook` **herede** todos los métodos de `Book`, y un `RareBook` los usa como si fueran suyos. Sus datos también están: el código, el título y los ejemplares viven dentro de cada `RareBook`, aunque la clase no los declare.

### 3. Y añade lo suyo

Descomenta el **PASO 3** y ejecuta. Las dos últimas líneas:

```
Sala de fondo antiguo
Crónica de Núremberg (Sala de fondo antiguo)
```

Una subclase es su clase padre **más** algo: aquí, la sala. `label()` usa `getTitle()`, heredado, y `room`, propio. Un `Book` normal no tiene sala ni `label()`.

### 4. La cadena llega hasta `Object`

Descomenta el **PASO 4** y ejecuta. Las tres últimas líneas:

```
RareBook
Book
Object
```

`RareBook` hereda de `Book`. ¿Y `Book`, que no escribe `extends`? Hereda de `Object`. Toda clase de Java que no dice `extends` hereda de `Object`, la raíz de todas. Por eso cualquier objeto tiene métodos que nunca escribiste, como `toString()`: los verás en el ejercicio 02.

### 5. Un `RareBook` es un `Book`

Descomenta el **PASO 5** y ejecuta:

```
Main.java:52: error: cannot find symbol
        IO.println(asBook.getRoom());
                         ^
  symbol:   method getRoom()
  location: variable asBook of type Book
1 error
error: compilation failed
```

Vuelve a comentar la línea 52 y ejecuta otra vez. Las dos últimas líneas:

```
BK-001 · Crónica de Núremberg · ejemplares: 0
true
```

Un `RareBook` cabe en una variable `Book`, porque **es** un `Book`, e `instanceof` lo confirma. Pero la variable decide qué puedes pedirle: a través de `asBook`, el compilador solo ve los métodos de `Book`, y `Book` no tiene `getRoom()`. El objeto sigue siendo un `RareBook` con su sala; es la variable la que no la ve. Lo aprovecharás en la semana 08.

### 6. Lo `private` de `Book` no se toca desde `RareBook`

Descomenta el método `restore()` dentro de `RareBook` (líneas 130 a 132) y ejecuta:

```
Main.java:131: error: copies has private access in Book
        copies = 1;
        ^
1 error
error: compilation failed
```

Vuelve a comentarlo. Cada `RareBook` **tiene** un atributo `copies`, pero `RareBook` no puede tocarlo: `private` es "solo dentro de `Book`", y una subclase es otra clase. Para cambiar los ejemplares, `RareBook` usa lo mismo que el resto del programa: `lend()`. Así la regla "no bajar de 0" sigue en un único sitio, también para las subclases.

### 7. El constructor de la subclase llama al de la padre

Descomenta el segundo constructor de `RareBook` (líneas 117 a 119) y ejecuta:

```
Main.java:117: error: constructor Book in class Book cannot be applied to given types;
    RareBook(String code, String title) {
                                        ^
  required: String,String,int
  found:    no arguments
  reason: actual and formal argument lists differ in length
1 error
error: compilation failed
```

Vuelve a comentarlo. Ese constructor no llama a `super(...)`, así que Java pone por su cuenta `super()`, sin argumentos... y `Book` no tiene un constructor sin argumentos. Antes de construir la parte de `RareBook` hay que construir la de `Book`, con sus datos y su validación. Por eso el primer constructor empieza con `super(code, title, copies)`.

### 8. Tu turno

1. Arregla el constructor del paso 7: que cree un libro raro con 1 ejemplar en la sala `"Depósito"`. Pista: puede llamar al otro constructor de `RareBook` con `this(...)`.
2. Crea `new RareBook("BK-002", "Códice", -1, "Sala 2")`. ¿Quién lanza la excepción, `RareBook` o `Book`? ¿Por qué no hizo falta escribir la regla dos veces?

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol ... variable chronicle` | Descomentaste el paso 3, 4 o 5 sin el paso 2, que crea `chronicle` |
| Sigue saliendo `cannot find symbol ... method getRoom()` | No volviste a comentar la línea 52 después del paso 5 |
| Sigue saliendo `copies has private access in Book` | No volviste a comentar el método `restore()` del paso 6 |
| Sigue saliendo `constructor Book in class Book cannot be applied to given types` | No volviste a comentar el segundo constructor del paso 7 |
| `error: reached end of file while parsing` | Descomentaste a medias un constructor o un método de `RareBook`: revisa que su `}` final también esté descomentado |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · Cuándo heredar y cuándo componer](../../1-teoria/05-cuando-heredar-y-cuando-componer.md) | **Ejercicio 01 · Extender una clase** | [Ejercicio 02 · Sobrescribir métodos](../ejercicio-02-sobrescribir-metodos/README.md) |
