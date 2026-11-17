# Ejercicio 02 — Constructores que validan

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-constructores-que-validan.md) y [04](../../1-teoria/04-final-e-inmutabilidad.md)

## Objetivo

Hacer que un libro en mal estado no pueda existir: un constructor que prepara los datos, rechaza los que no valen y lo comprueba todo **antes** de asignar. Después, dos constructores que comparten la misma validación y `final` en un atributo y en una variable. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-06-encapsulacion_constructores_y_composicion/2-practicas/ejercicio-02-constructores-que-validan/starter
java Main.java
```

No imprime nada. Como en el ejercicio 01, `class Main` va primero y las demás clases después. Lee antes de seguir:

- En `Main`, el método `tryToCreate`: intenta crear un libro e imprime `Creado:` o `Rechazado:` con el mensaje de la excepción.
- `Book`: un constructor que normaliza el código, comprueba tres reglas y solo después asigna. Su comprobación de código, `normalized.matches("[A-Z]+-[0-9]+")`, es la regla de `Stock.isValidCode` escrita en una línea: letras, un guion y dígitos.
- `HalfBook`: un método `change` que asigna primero y comprueba después.

Los pasos 4 y 5 descomentan código **dentro** de `Book`, además de en `main`: cada paso dice dónde. Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. El constructor prepara los datos

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042 · Ficciones · ejemplares: 2
```

Le pasaste `" bk-042 "` y `"  Ficciones "`, y el libro guarda `BK-042` y `Ficciones`. Lo hizo el constructor: cualquier libro que exista tiene sus datos en la forma correcta, sin que quien lo crea tenga que acordarse.

### 2. El constructor rechaza lo que no vale

Descomenta el **PASO 2** y ejecuta. Las cuatro últimas líneas:

```
Rechazado: Título vacío
Rechazado: Código no válido: BK042
Rechazado: Ejemplares no válidos: -1
Creado: BK-500 · Pedro Páramo · ejemplares: 1
```

Fíjate en el primer bloque: si el constructor lanza la excepción, `new` no devuelve nada y `broken` nunca recibe un libro. Por eso no se imprime `Creado:`. Un constructor que valida **no deja nacer** al objeto en mal estado; no hay un libro "a medias" que limpiar después.

Las dos excepciones son `IllegalArgumentException`: el problema está en un argumento que se pasó a `new`, no en el estado de un objeto que ya existe (ese sería `IllegalStateException`, como en `lend()`).

### 3. Validar antes de asignar

Descomenta el **PASO 3** y ejecuta. Las dos últimas líneas:

```
Rechazado: Ejemplares no válidos: -4
BK-312 · Rayuela, 2.ª ed. · ejemplares: 3
```

`change` se negó... después de cambiar el código y el título. El libro queda con el código nuevo y los ejemplares viejos: una mezcla que nadie pidió. Es el error de comprobar al final. Compara con el constructor de `Book`: guarda el código normalizado en una variable local, comprueba **todo**, y solo entonces asigna. Si algo falla, nada cambió.

### 4. Dos constructores, una sola validación

El paso 4 tiene dos partes:

1. Dentro de `Book`, descomenta el constructor de dos parámetros (debajo de `// PASO 4: descomenta este constructor.`).
2. En `main`, descomenta el **PASO 4**.

Ejecuta. Las dos últimas líneas:

```
BK-777 · El Aleph · ejemplares: 0
Rechazado: Código no válido: BK 777
```

Una clase puede tener varios constructores si sus parámetros son distintos: es la **sobrecarga**. `Book(code, title)` no repite ninguna regla: su única línea, `this(code, title, 0)`, llama al constructor de tres parámetros. Por eso `"bk 777"` también se rechaza. Si mañana añades una regla, la escribes en un solo sitio.

Lo normal es que `this(...)` sea la primera línea del constructor. Desde Java 25 puede llevar líneas antes, siempre que no usen el objeto que se está creando (JEP 513), pero no las necesitarás esta semana. No lo confundas con `this.code`: `this.` es "el atributo de este objeto"; `this(...)`, "el otro constructor de esta clase".

### 5. `final`, un atributo que no cambia

Dentro de `Book`, descomenta el método `rename` (debajo de `// PASO 5: descomenta este método, ejecuta y vuelve a comentarlo.`). Ejecuta:

```
Main.java:114: error: cannot assign a value to final variable code
        this.code = newCode;
            ^
1 error
error: compilation failed
```

`code` es `final`: recibe su valor una vez, en el constructor, y ya no cambia. Ni siquiera un método de la propia clase puede reasignarlo. El código de un libro es su identidad; si cambiara, el préstamo que apunta a `BK-042` se quedaría hablando de otro libro.

Vuelve a comentar el método `rename` entero.

### 6. `final` en una variable de referencia

Descomenta el **PASO 6** y ejecuta:

```
Main.java:72: error: cannot assign a value to final variable fixed
        fixed = new Book("BK-108", "Otro", 1);
        ^
1 error
error: compilation failed
```

Vuelve a comentar la línea 72 y ejecuta otra vez. La última línea:

```
BK-107 · El túnel · ejemplares: 3
```

`final` en una variable de tipo objeto fija **la flecha**, no el objeto: `fixed` siempre apuntará a El túnel, pero El túnel puede cambiar por dentro (`restock(2)` lo subió de 1 a 3). `final` no hace inmutable al objeto; lo inmutable es lo que **no tiene** ninguna forma de cambiar: atributos `final` y ningún método que modifique.

### 7. Tu turno

1. Añade a `Book` una regla más: el título no puede pasar de 60 caracteres (`"Título demasiado largo: " + title.length()`). ¿En cuántos sitios la escribes? Pruébala con los dos constructores.
2. Arregla `HalfBook.change` para que, si falla, el libro quede como estaba. Vuelve a ejecutar el paso 3: la última línea debe ser `BK-311 · Rayuela · ejemplares: 3`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `constructor Book in class Book cannot be applied to given types ... required: String,String,int` | Descomentaste el paso 4 en `main` sin el constructor de dos parámetros dentro de `Book` |
| Sigue saliendo `cannot assign a value to final variable code` | No volviste a comentar el método `rename` después del paso 5 |
| Sigue saliendo `cannot assign a value to final variable fixed` | No volviste a comentar la línea 72 |
| `error: reached end of file while parsing` | Descomentaste a medias un constructor o un método de `Book`: revisa que su `}` final también esté descomentado |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Encapsular una clase](../ejercicio-01-encapsular-una-clase/README.md) | **Ejercicio 02 · Constructores que validan** | [Ejercicio 03 · Composición y copias defensivas](../ejercicio-03-composicion-y-copias-defensivas/README.md) |
