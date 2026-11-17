# Glosario — Semana 08

| Término | Definición |
|---|---|
| ***Cast*** | Conversión de tipo escrita entre paréntesis: `(RareBook) book`. No cambia el objeto, sino la variable con la que lo miras |
| **`ClassCastException`** | La excepción que lanza la JVM cuando un *cast* promete un tipo que el objeto no tiene: `(RareBook)` sobre un `Book` normal |
| ***Downcasting*** | Bajar de una variable del padre a una de la hija con un *cast*. Hay que pedirlo y puede fallar al ejecutar |
| **`instanceof`** | Operador que comprueba si un objeto es de un tipo o de una hija suya: `book instanceof RareBook`. Con `null` da `false` |
| **Ligadura dinámica** | Elegir qué cuerpo de un método se ejecuta al ejecutarse, según la clase del objeto, buscando desde su clase hacia arriba (*dynamic binding*) |
| **Método oculto** | Un método `static` de la hija con el mismo nombre que uno del padre. No lo sobrescribe: lo oculta, y se elige por el tipo de la variable |
| ***Pattern matching* de `instanceof`** | `book instanceof RareBook rareBook`: comprueba el tipo y, si coincide, declara una variable ya convertida. Desde Java 16 |
| **Polimorfismo** | Que una misma llamada ejecute código distinto según el objeto que la recibe: `book.describe()` en un array con varias clases |
| **Sobrecarga** | Varios métodos con el mismo nombre y distintos parámetros. La elige el compilador por los tipos de los argumentos (*overloading*) |
| **Sustituir condicional por polimorfismo** | Refactorización que cambia una cadena de `if` o `instanceof` sobre el tipo por un método sobrescrito en cada clase |
| **Tipo dinámico** | La clase del objeto, la que se escribió en el `new`. Decide qué cuerpo de un método se ejecuta |
| **Tipo estático** | El tipo de la variable, el que se escribió al declararla. Decide qué métodos se pueden llamar |
| ***Upcasting*** | Guardar una hija en una variable del padre: `Book b = new RareBook(...)`. Es automático y siempre seguro |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
