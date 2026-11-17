# 05 · Polimorfismo o pattern matching

⏱️ 45 min

## 1. ¿No era malo preguntar el tipo?

En la semana 08 aprendiste a **no** preguntar el tipo. Una cadena de `instanceof` que devolvía los días de préstamo tenía un problema grave: cuando llegaba `Magazine`, una clase nueva, caía en el valor del final sin que nadie avisara. La solución fue el polimorfismo: un `loanDays()` en cada clase, y quien llama no pregunta nada.

Esta semana has escrito un `switch` que pregunta el tipo de un `Outcome`. No es una contradicción. Lo que fallaba en la semana 08 no era preguntar el tipo: era que **nadie revisaba** si faltaba un caso. Con una jerarquía sellada y un `switch` sin `default`, el compilador lo revisa.

| | Cadena de `instanceof` (semana 08) | `switch` sobre un tipo sellado |
|---|---|---|
| Llega una clase nueva | Cae en el valor del final, en silencio | No compila hasta que la trates |
| Quién vigila que estén todos los casos | Nadie | El compilador |
| Qué tipos pueden llegar | Cualquiera | Solo los de `permits` |

## 2. Dos formas de añadir

Las dos herramientas sirven, y cada una facilita una cosa distinta:

- **Polimorfismo**: cada clase lleva su versión del método. Añadir una **clase** es fácil: la escribes con su método y nadie más cambia. Añadir una **operación** es caro: hay que escribir un método nuevo en cada clase.
- **Pattern matching sobre un tipo sellado**: las clases solo llevan datos, y cada operación es un `switch` en un sitio. Añadir una **operación** es fácil: un `switch` nuevo, y ninguna clase cambia. Añadir una **clase** es caro, pero el compilador te lleva a cada `switch` que tienes que cambiar.

La pregunta que decide: **¿qué va a crecer más, las clases o las operaciones?**

## 3. En tu proyecto

| Jerarquía | Qué crece | Herramienta |
|---|---|---|
| Tu clase y sus subclases | Las clases: mañana puede haber otra forma de entidad, con su `take()` y su `isAvailable()` | Polimorfismo |
| `Criterion` | Las clases, y las escribe quien usa el inventario | Polimorfismo con una interfaz abierta |
| `Outcome` | Las operaciones: mostrar un resultado, guardarlo en un registro, contar los rechazos... Los casos son dos y casi nunca cambian | Interfaz sellada, records y `switch` |
| `Level` | Nada: son cuatro valores fijos | Enum |

Fíjate en que `Taken` y `Rejected` no tienen comportamiento: son datos. No tiene sentido que un `Taken` sepa mostrarse en pantalla, guardarse en un archivo y contarse en un informe, todo dentro del record. Cada una de esas cosas es una operación que vive donde se usa, con un `switch` que trata los dos casos.

Tu `Inventory`, en cambio, sigue sin preguntar el tipo de tus entidades: el test `theInventoryNeverAsksForTheType` sigue ahí, y `tryTake` cumple esa regla. Llama a `take()` y deja que cada objeto decida.

## 4. Un resultado en lugar de una excepción

`tryTake` es el otro cambio de diseño de la semana. Antes, `take` lanzaba una excepción si no podía sacar, y quien llamaba tenía que acordarse del `try`/`catch`. Ahora devuelve un `Outcome`:

```java
// Antes: si olvidas el catch, el programa se rompe
try {
    inventory.take(code);
    IO.println("Sale una");
} catch (IllegalStateException e) {
    IO.println("Rechazado: " + e.getMessage());
}

// Ahora: el tipo de lo que devuelve dice que hay dos casos
IO.println(Outcome.message(inventory.tryTake(code)));
```

No sustituye a las excepciones: tu clase sigue lanzándolas cuando alguien la usa mal, y `tryTake` las convierte en un resultado. Un resultado conviene cuando "no se pudo" es un caso **normal**, que pasará a menudo y que quien llama tiene que tratar (un libro prestado, una bicicleta alquilada). Una excepción conviene cuando es un error que no debería pasar. En la semana 16 verás las excepciones a fondo.

## 5. Las herramientas de la semana, juntas

| Herramienta | Para qué | En tu proyecto |
|---|---|---|
| Record | Datos que no cambian, con `equals` y `toString` gratis | `Taken`, `Rejected` |
| Enum | Unos pocos valores fijos, cada uno con sus datos | `Level` |
| Tipo sellado | Una lista cerrada de clases | `Outcome` |
| Patrón de record | Comprobar el tipo y desmontar el record en un paso | `case Taken(String code, int left)` |
| `switch` sin `default` | Que el compilador vigile que tratas todos los casos | `Outcome.message`, `Level.isAlert` |

## ✅ Comprueba que lo entendiste

1. ¿Qué diferencia hay entre la cadena de `instanceof` de la semana 08 y el `switch` de `Outcome.message`, si los dos preguntan el tipo?
2. Quieres añadir a `Outcome` una operación que cuente los rechazos de un array de resultados. ¿Qué tienes que cambiar en `Taken` y `Rejected`?
3. ¿Por qué tus subclases de entidad no se convierten en un tipo sellado con un `switch`?
4. ¿Cuándo conviene devolver un resultado y cuándo lanzar una excepción?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [04 · Pattern matching](04-pattern-matching.md) | **05 · Polimorfismo o pattern matching** | [Ejercicio 01 · Records](../2-practicas/ejercicio-01-records/README.md) |
