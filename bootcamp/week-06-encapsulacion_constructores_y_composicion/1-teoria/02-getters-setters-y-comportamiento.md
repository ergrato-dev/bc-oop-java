# 02 · *Getters*, *setters* y comportamiento

⏱️ 45 min

## 1. Leer sin poder escribir

Con los atributos `private`, nadie de fuera puede leer el código de un libro. A veces hace falta: un test que comprueba que el constructor lo normalizó, un inventario que busca por código. Para eso está el ***getter***, un método que devuelve el valor de un atributo:

```java
public String getCode() {
    return code;
}

public int getCopies() {
    return copies;
}
```

Por convención, se llama `get` + el nombre del atributo con mayúscula. Para un `boolean`, se usa `is`: `isAvailable()`. Muchas herramientas de Java (y tu IDE) cuentan con esos nombres.

Un *getter* da acceso de **lectura**. `book.getCopies()` devuelve una copia del número; cambiarla no cambia el libro:

```java
int n = ficciones.getCopies();
n = -5;   // ficciones sigue con 2
```

## 2. El *setter* que lo deshace todo

El ***setter*** es el método que escribe un atributo:

```java
public void setCopies(int copies) {
    this.copies = copies;
}
```

Con este *setter*, `ficciones.setCopies(-5)` hace lo mismo que `ficciones.copies = -5`. El atributo es `private`, pero la puerta sigue abierta con otro nombre. Es la trampa más común: el IDE ofrece "generar *getters* y *setters*" para todos los atributos, y la clase acaba tan desprotegida como antes, con el doble de líneas. Lo verás en el paso 5 del ejercicio 01.

No todos los *setters* son malos: uno que valida (`if (copies < 0) throw ...`) protege la regla. Pero antes de escribirlo, pregúntate si ese cambio tiene sentido en tu dominio.

## 3. Pregunta qué hace el objeto, no qué datos tiene

En una biblioteca nadie "pone los ejemplares a 7". Se **presta** un libro, se **devuelve**, se **reponen** ejemplares. Cada una de esas acciones es un método con su regla:

| En vez de... | Mejor | Su regla |
|---|---|---|
| `setCopies(getCopies() - 1)` | `take()` | Si no quedan, se niega |
| `setCopies(getCopies() + n)` | `restock(n)` | `n` tiene que ser positivo |
| `if (book.getCopies() > 0)` | `book.isAvailable()` | La definición de "disponible" vive en `Book` |

La segunda columna son métodos de tu clase de la semana 05. Ya estabas encapsulando sin saberlo: solo faltaba cerrar la puerta (`private`).

Esta idea tiene nombre: ***tell, don't ask***, "dile, no le preguntes". En lugar de **preguntarle** al objeto sus datos y decidir fuera qué hacer con ellos, le **dices** lo que quieres y él decide. Así la regla está en un solo sitio.

## 4. ¿Qué *getters* pongo?

Los que alguien necesite, y ninguno más. Cada *getter* es una promesa: si mañana cambias cómo guardas ese dato, tienes que seguir devolviéndolo igual.

- `getCode()` y `getName()`: sí. El código es la identidad de tu objeto; un inventario lo necesita para buscar.
- `getQuantity()`: sí, para los tests y para sumar. Pero antes de usarlo, mira si ya hay un método que haga lo que quieres (`isAvailable()`, `level(capacity)`).
- `getLent()` en el ejercicio 01: no. Nadie de fuera lo necesita; `describe()` ya calcula lo que hay en la estantería.

## 5. Consultas y órdenes, otra vez

En la semana 05 viste que un método es una **consulta** (devuelve algo y no cambia el objeto: `describe()`, `isAvailable()`) o una **orden** (cambia el objeto: `take()`, `restock()`). Los *getters* son consultas. Las órdenes son las únicas puertas por las que el estado cambia, y cada una comprueba su regla **antes** de cambiar nada.

Con atributos `private` y órdenes que comprueban, se cumple lo que se llama un **invariante**: algo que es verdad para cualquier objeto, en cualquier momento. "Las unidades nunca son negativas" es un invariante de tu clase: se cumple al crear el objeto (lo verás en la teoría 03) y cada orden lo mantiene.

## ✅ Comprueba que lo entendiste

1. ¿Qué diferencia hay, para la seguridad del objeto, entre `public int copies` y `private int copies` con un `setCopies` que no valida?
2. Reescribe `if (book.getCopies() > 0) { book.setCopies(book.getCopies() - 1); }` con un método de la clase. ¿Dónde queda la regla?
3. ¿Qué es un invariante? Escribe uno de tu dominio.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [01 · Encapsulación y `private`](01-encapsulacion-y-private.md) | **02 · *Getters*, *setters* y comportamiento** | [03 · Constructores que validan](03-constructores-que-validan.md) |
