# 02 · Métodos de instancia

⏱️ 50 min

## 1. Un método que es de cada objeto

La tarjeta CRC decía que un libro "se describe en una línea". Esa responsabilidad es un método **dentro** de la clase:

```java
class Book {
    String code;
    String title;
    int copies;

    String describe() {
        return code + " · " + title + " · ejemplares: " + copies;
    }
}
```

`describe()` no lleva `static` y no recibe parámetros, pero usa `code`, `title` y `copies`. ¿Los de qué libro? Los del objeto sobre el que se llama:

```java
IO.println(rayuela.describe());    // BK-311 · Rayuela · ejemplares: 1
IO.println(ficciones.describe());  // BK-042 · Ficciones · ejemplares: 2
```

Un método sin `static` es un **método de instancia**: solo se puede llamar con un objeto delante del punto, y trabaja con los datos de ese objeto. El mismo código da resultados distintos según el objeto.

## 2. Antes y después

Compara con lo que hacías con arrays paralelos:

```java
// Semana 04: el método recibe una posición y busca en tres arrays
String describe(int i) {
    return codes[i] + " · " + titles[i] + " · " + authors[i];
}

// Semana 05: el método ya sabe de qué libro habla
String describe() {
    return code + " · " + title + " · " + author;
}
```

Es la regla de la tarjeta CRC, "quien tiene los datos, hace el trabajo", escrita en Java: los datos y el método que los usa viven en el mismo sitio.

## 3. `this`: el objeto actual

Dentro de un método de instancia, `this` es el objeto sobre el que se ha llamado. Cuando escribes `code`, Java entiende `this.code`:

```java
String describe() {
    return this.code + " · " + this.title;   // lo mismo que code + " · " + title
}
```

En `rayuela.describe()`, `this` es Rayuela; en `ficciones.describe()`, Ficciones. Normalmente no hace falta escribirlo. Hace falta cuando un parámetro se llama igual que un atributo: lo verás en la [teoría 03](03-constructores.md).

## 4. Métodos que cambian el estado

Un método de instancia también puede **cambiar** los atributos de su objeto:

```java
String lend() {
    if (copies == 0) {
        return "No quedan ejemplares de " + code;
    }
    copies--;
    return "Prestado " + code + ", quedan " + copies;
}
```

```java
IO.println(rayuela.lend());   // Prestado BK-311, quedan 0
IO.println(rayuela.lend());   // No quedan ejemplares de BK-311
```

La segunda llamada da otro resultado porque la primera cambió el estado de Rayuela. Es la diferencia con los métodos `static` de semanas anteriores, que siempre daban el mismo resultado con los mismos argumentos: un método de instancia depende también del estado del objeto.

Hay dos tipos de métodos de instancia, y conviene que cada método sea de uno solo:

| Tipo | Qué hace | Ejemplos |
|---|---|---|
| **Consulta** | Responde algo sobre el objeto sin cambiarlo | `describe()`, `isAvailable()` |
| **Orden** | Cambia el estado del objeto | `take()`, `restock(units)` |

`lend()` mezcla los dos: cambia el estado y además devuelve un texto. Sirve para un ejercicio, pero en el proyecto separarás las dos cosas.

## 5. Cuando la orden no se puede cumplir

¿Qué debe hacer `take()` si no quedan unidades? Devolver un texto obliga a quien llama a leerlo. Mejor que el método **se niegue** con una excepción:

```java
void take() {
    if (quantity == 0) {
        throw new IllegalStateException("No quedan unidades de " + code);
    }
    quantity--;
}
```

En la semana 03 usaste `IllegalArgumentException` cuando un **argumento** no es válido. Aquí no hay argumentos: lo que impide cumplir la orden es el **estado** del objeto. Para eso existe `IllegalStateException`.

| Excepción | Cuándo | Ejemplo |
|---|---|---|
| `IllegalArgumentException` | El argumento no vale | `restock(-1)` |
| `IllegalStateException` | El objeto, tal como está, no puede hacerlo | `take()` con 0 unidades |

Fíjate en el orden: se comprueba **antes** de cambiar nada. Si `take()` restara primero y comprobara después, un error dejaría el objeto con `-1` unidades.

## 6. Métodos que reciben otros datos

Un método de instancia también puede recibir parámetros, y combinarlos con los atributos:

```java
boolean matches(String query) {
    return title.toLowerCase(Locale.ROOT).contains(query.strip().toLowerCase(Locale.ROOT));
}

String level(int capacity) {
    return Stock.level(copies, capacity);
}
```

`level` muestra algo importante: un método de instancia puede **llamar** a los métodos `static` que ya tienes. Las reglas de `Fields`, `Stock` y `Rules` siguen valiendo; ahora las llama el objeto, con sus propios datos.

## ✅ Comprueba que lo entendiste

1. ¿Qué diferencia hay entre `Stock.level(copies, 8)` y `rayuela.level(8)`? ¿De dónde sale `copies` en el segundo?
2. ¿Por qué `rayuela.lend()` puede dar dos resultados distintos con los mismos argumentos (ninguno)?
3. `take()` con 0 unidades: ¿por qué `IllegalStateException` y no `IllegalArgumentException`? ¿Por qué se comprueba antes de restar?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [01 · De la tarjeta a la clase](01-de-la-tarjeta-a-la-clase.md) | **02 · Métodos de instancia** | [03 · Constructores](03-constructores.md) |
