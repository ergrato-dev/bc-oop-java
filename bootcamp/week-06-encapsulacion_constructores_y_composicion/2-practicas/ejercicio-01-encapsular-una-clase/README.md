# Ejercicio 01 — Encapsular una clase

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-encapsulacion-y-private.md) y [02](../../1-teoria/02-getters-setters-y-comportamiento.md)

## Objetivo

Ver qué pasa cuando cualquiera puede escribir en los atributos de un objeto, y cómo `private` y unos métodos con reglas lo impiden. Comparas tres versiones del mismo libro: una abierta, una encapsulada y una que parece encapsulada pero no lo está. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-06-encapsulacion_constructores_y_composicion/2-practicas/ejercicio-01-encapsular-una-clase/starter
java Main.java
```

No imprime nada. Este `Main.java` es distinto a los de la semana 05: empieza con `class Main { ... }` y las demás clases van **después y fuera** de `Main`. No es un capricho: dentro de una misma clase, `private` no oculta nada, y en los archivos de la semana 05 todas las clases quedaban dentro de una `Main` invisible. Para que `private` proteja de verdad, cada clase va por su cuenta.

Debajo de `Main` hay tres clases. Léelas antes de seguir:

- `OpenBook`: tres atributos sin `private`.
- `Book`: los mismos datos, con `private`, dos *getters* (`getCode`, `getCopies`) y `lend()`. Guarda cuántos ejemplares tiene (`copies`) y cuántos están prestados (`lent`).
- `SetterBook`: atributos `private` y un `setCopies` que acepta cualquier número.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Un atributo abierto acepta cualquier valor

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
[] · Ficciones · ejemplares: -5
```

Un libro con código vacío y −5 ejemplares. Java no se queja: `copies` es un `int`, y −5 es un `int`. La regla "los ejemplares no son negativos" solo vive en tu cabeza, y cualquier línea de cualquier clase puede saltársela. En un programa de miles de líneas, encontrar quién puso el −5 es una tarde entera de depuración.

### 2. `private` cierra la puerta

Descomenta el **PASO 2** y ejecuta:

```
Main.java:25: error: copies has private access in Book
        ficciones.copies = -5;
                 ^
1 error
error: compilation failed
```

`private` significa "solo el código de esta clase lo ve". `Main` no es `Book`, así que no puede ni leer ni escribir `copies`. El error sale **al compilar**, antes de que exista ningún libro con −5: es el mejor momento posible para que salga un error.

Vuelve a comentar la línea 25 (`ficciones.copies = -5;`) y deja descomentada la 24, donde se crea `ficciones`.

### 3. *Getters* para leer

Descomenta el **PASO 3** y ejecuta. Las dos últimas líneas:

```
BK-042 tiene 2 ejemplares
BK-042 · Ficciones · en estantería: 2 de 2
```

`getCode()` y `getCopies()` devuelven el valor del atributo: se puede **leer** el estado, pero no cambiarlo desde fuera. Fíjate en que `Book` no tiene *getter* de `lent`: nadie de fuera lo necesita, porque `describe()` ya calcula cuántos quedan en la estantería. Lo que no se publica se puede cambiar mañana sin romper a nadie.

### 4. El estado cambia con métodos que conocen las reglas

Descomenta el **PASO 4** y ejecuta. Las dos últimas líneas:

```
Rechazado: No quedan ejemplares de BK-042
BK-042 · Ficciones · en estantería: 0 de 2
```

Los dos primeros `lend()` prestan; el tercero se niega con `IllegalStateException`, y el libro queda como estaba (0 de 2, no −1 de 2). Desde fuera **no hay otra forma** de cambiar `lent`: si mañana aparece un libro con préstamos de más, el culpable solo puede estar dentro de `Book`. Eso es encapsular: los datos y las reglas que los protegen, juntos y en un solo sitio.

### 5. Un *setter* sin reglas no protege nada

Descomenta el **PASO 5** y ejecuta. La última línea:

```
BK-311 · Rayuela · ejemplares: -5
```

`SetterBook` tiene sus atributos `private` y, aun así, acaba con −5 ejemplares. `setCopies` es una puerta abierta con otro nombre: deja escribir cualquier valor, como el atributo abierto del paso 1. Que un IDE genere *getters* y *setters* para todos los atributos no es encapsular. La pregunta no es "¿cómo cambio este atributo?", sino "¿qué **hace** este objeto en mi dominio?": prestar, devolver, reponer.

### 6. Devolver, con su propia regla

El paso 6 tiene dos partes:

1. Dentro de la clase `Book`, descomenta el método `giveBack()` (debajo del comentario `// PASO 6: descomenta este método.`).
2. En `main`, descomenta el **PASO 6**.

Ejecuta. Las tres últimas líneas:

```
BK-042 · Ficciones · en estantería: 1 de 2
Rechazado: No hay préstamos de BK-042
BK-042 · Ficciones · en estantería: 2 de 2
```

El primer `giveBack()` devuelve uno de los dos préstamos; el segundo, el otro; el tercero se niega, porque no se puede devolver un libro que nadie se llevó. Cada orden comprueba **antes** de cambiar, como `take()` en la semana 05.

### 7. Tu turno

Sin ejecutar, responde en papel:

1. ¿Qué línea del paso 1 sería imposible con `Book`? ¿Y con `SetterBook`?
2. Añade a `Book` un *getter* `getAvailable()` que devuelva cuántos ejemplares quedan en la estantería, y úsalo en `main`. ¿Hace falta un atributo nuevo?
3. Si mañana decides guardar `available` en lugar de `lent`, ¿qué líneas de `main` tendrías que cambiar?

Después hazlo y compruébalo. Respuesta a la 3: ninguna, porque `main` solo usa métodos de `Book`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: cannot find symbol ... variable ficciones` | Comentaste la línea 24 en lugar de la 25: `ficciones` se crea en la 24 |
| Sigue saliendo `copies has private access in Book` | No volviste a comentar la línea 25 después del paso 2 |
| `error: cannot find symbol ... method giveBack()` | Falta la primera parte del paso 6: descomentar el método dentro de `Book` |
| `error: reached end of file while parsing` | Descomentaste a medias el método `giveBack()`: revisa que su `}` final también esté descomentado |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · Composición y delegación](../../1-teoria/05-composicion-y-delegacion.md) | **Ejercicio 01 · Encapsular una clase** | [Ejercicio 02 · Constructores que validan](../ejercicio-02-constructores-que-validan/README.md) |
