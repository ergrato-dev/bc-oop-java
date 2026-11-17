# Glosario — Semana 05

| Término | Definición |
|---|---|
| **Alias** | Dos o más variables que apuntan al mismo objeto: un cambio por una se ve por las otras |
| **Atributo** | Variable declarada dentro de una clase y fuera de sus métodos; cada objeto tiene la suya. También se llama campo |
| **Clase** | Descripción de un tipo de objeto: qué datos tiene cada uno (atributos) y qué sabe hacer (métodos) |
| **Constructor** | Bloque que se ejecuta al crear un objeto con `new` y da valor a sus atributos. Se llama como la clase y no tiene tipo de retorno |
| **Constructor por defecto** | Constructor vacío que Java añade a una clase sin ninguno; deja de existir en cuanto escribes uno |
| **Estado** | Los valores de los atributos de un objeto en un momento dado |
| **`IllegalStateException`** | Excepción para cuando el objeto, tal como está, no puede hacer lo que se le pide: `take()` sin unidades |
| **Instancia** | Sinónimo de objeto: una instancia de `Book` es un libro concreto |
| **Método de instancia** | Método sin `static`: se llama sobre un objeto y trabaja con sus atributos |
| **Método `static`** | Método de la clase, no de un objeto: se llama con el nombre de la clase y no tiene `this` |
| **`new`** | Operador que crea un objeto, ejecuta su constructor y devuelve una referencia a él |
| **`null`** | Valor de una variable de referencia que no apunta a ningún objeto |
| **`NullPointerException`** | Excepción al usar un método o un atributo a través de `null`; su mensaje dice qué expresión era `null` |
| **Objeto** | Un ejemplar concreto de una clase, con sus propios valores en los atributos |
| **Paso por valor** | Java siempre pasa a los métodos una copia: del número si es primitivo, de la referencia si es un objeto |
| **Recolector de basura** | Parte de Java que libera la memoria de los objetos a los que ya no apunta ninguna variable. En inglés, *garbage collector* |
| **Referencia** | Lo que guarda una variable de tipo objeto: la dirección del objeto, no el objeto |
| **Tipo primitivo** | `int`, `double`, `boolean`, `char` y otros cuatro (`byte`, `short`, `long`, `float`): la variable guarda el valor, no una referencia |
| **Tipo referencia** | Cualquier clase o array: la variable guarda una referencia o `null` |
| **`this`** | Dentro de un método de instancia o un constructor, el objeto actual. `this.code` es el atributo cuando un parámetro se llama igual |
| **Valor por defecto** | Valor que tiene un atributo sin asignar: `0`, `false` o `null` según su tipo |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
