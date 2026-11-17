# Ejercicio 02 — Sobrescribir métodos

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-sobrescritura-y-override.md)

## Objetivo

Dar a un método heredado otro cuerpo en la subclase: un `describe()` que añade la sala reutilizando el del padre con `super.describe()`, un `lend()` que se niega, y `toString()`, el método de `Object` que todos los objetos tienen. Por el camino, `@Override` te avisa de las erratas, y verás que el método que se ejecuta lo decide el objeto, no la variable. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-07-herencia/2-practicas/ejercicio-02-sobrescribir-metodos/starter
java Main.java
```

No imprime nada. `Book` y `RareBook` son los del ejercicio 01, sin los métodos de prueba. Casi todos los pasos descomentan un método **dentro** de una clase, además de (o en lugar de) líneas en `main`: cada paso dice dónde. Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Sin sobrescribir, `RareBook` usa el `describe()` de `Book`

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042 · Ficciones · ejemplares: 2
BK-001 · Crónica de Núremberg · ejemplares: 1
```

El libro raro se describe como un libro cualquiera: el `describe()` heredado no sabe nada de salas.

### 2. `RareBook` sobrescribe `describe()`

Descomenta el método `describe()` dentro de `RareBook` (líneas 110 a 113) y ejecuta:

```
BK-042 · Ficciones · ejemplares: 2
BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo
```

`main` no cambió, y la segunda línea sí. `RareBook` declara un método con el mismo nombre y los mismos parámetros que uno de `Book`: lo **sobrescribe**. Desde ahora, un `RareBook` usa su `describe()`; un `Book` normal, el de siempre.

Fíjate en `super.describe()`: llama al `describe()` **de `Book`**, que ya sabe montar el código, el título y los ejemplares. La subclase solo añade la sala. Prueba a quitar `super.` y ejecutar: el método se llama a sí mismo sin parar y el programa termina con `java.lang.StackOverflowError`. Vuelve a poner `super.`.

### 3. `@Override` te avisa de las erratas

Descomenta el método `descrbe()` dentro de `RareBook` (líneas 116 a 119) y ejecuta:

```
Main.java:116: error: method does not override or implement a method from a supertype
    @Override
    ^
1 error
error: compilation failed
```

Vuelve a comentarlo. Le faltaba una `i`. Sin `@Override`, Java lo aceptaría como un método **nuevo** de `RareBook`, y tú creerías que sobrescribiste `describe()` cuando no: el programa seguiría usando el de `Book`. Con `@Override` le dices al compilador "esto sobrescribe algo", y él comprueba que sea verdad. Ponlo siempre.

### 4. El método que se ejecuta lo decide el objeto

Descomenta el método `lend()` dentro de `RareBook` (líneas 122 a 125) y el **PASO 4** en `main`, y ejecuta. Las dos últimas líneas:

```
Prestado: BK-042
Rechazado: BK-001 no sale de la Sala de fondo antiguo
```

El bucle recorre un array de `Book` y llama a `book.lend()` con la misma línea para los dos. Pero cada objeto ejecuta **su** `lend()`: el `Book`, el que presta; el `RareBook`, el sobrescrito, que se niega. En el ejercicio 01, la variable decidía qué métodos se podían **llamar**; aquí ves que el objeto decide **qué cuerpo** se ejecuta. Es la idea central de la semana 08.

### 5. `toString()`, el método de `Object` que todos tienen

Descomenta el **PASO 5** en `main` y ejecuta. Las dos últimas líneas serán parecidas a estas (los números cambian en cada ejecución):

```
Book@2ea227af
En la sala: RareBook@4386f16
```

`IO.println(objeto)` y `"texto" + objeto` llaman al `toString()` del objeto. Ni `Book` ni `RareBook` lo escribieron: es el de `Object`, que devuelve el nombre de la clase, una `@` y un número. Descomenta ahora `toString()` dentro de `Book` (líneas 91 a 94) y ejecuta otra vez:

```
BK-042 · Ficciones · ejemplares: 1
En la sala: BK-001 · Crónica de Núremberg · ejemplares: 1 · Sala de fondo antiguo
```

`Book` sobrescribe el `toString()` de `Object`, y lo hace devolviendo `describe()`. `RareBook` no escribió `toString()`: lo hereda de `Book`... y ese `toString()` llama a `describe()`, que en un `RareBook` es **el de `RareBook`**. Por eso sale la sala. Va `public` porque en `Object` es `public`: al sobrescribir no puedes dar menos acceso (lo verás en la teoría 03).

### 6. Tu turno

1. Sobrescribe `getTitle()` en `RareBook` para que devuelva el título entre comillas latinas (`«Crónica de Núremberg»`). Sin tocar `describe()` de `Book`, ¿cambia lo que imprime el paso 1? ¿Por qué?
2. Quita `@Override` del `lend()` de `RareBook` y cámbiale el nombre a `lendd`. ¿Compila? ¿Qué imprime el paso 4? Escribe en una frase qué te habría ahorrado `@Override`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| Sigue saliendo `method does not override or implement a method from a supertype` | No volviste a comentar el método `descrbe()` del paso 3 |
| `toString() in Book cannot override toString() in Object` con `attempting to assign weaker access privileges; was public` | Quitaste el `public` de `toString()`: en `Object` es `public`, y al sobrescribir no se puede dar menos acceso |
| `java.lang.StackOverflowError` con muchas líneas `at RareBook.describe` | El `describe()` de `RareBook` se llama a sí mismo: usa `super.describe()` |
| El paso 4 imprime `Prestado: BK-001` | No descomentaste el `lend()` de `RareBook`: el libro raro usa el de `Book` |
| `cannot find symbol ... variable ficciones` | Descomentaste el paso 4 o 5 sin el paso 1, que crea los dos libros |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Extender una clase](../ejercicio-01-extender-una-clase/README.md) | **Ejercicio 02 · Sobrescribir métodos** | [Ejercicio 03 · `protected`, `final` y cuándo no heredar](../ejercicio-03-protected-final-y-cuando-no-heredar/README.md) |
