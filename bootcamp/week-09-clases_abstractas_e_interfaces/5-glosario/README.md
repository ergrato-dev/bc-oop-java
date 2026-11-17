# Glosario — Semana 09

| Término | Definición |
|---|---|
| **`abstract`** | En una clase, que no se pueden crear objetos de ella, solo de sus hijas. En un método, que no tiene cuerpo y cada hija concreta tiene que escribirlo |
| **Clase abstracta** | Una clase padre que guarda atributos, constructor y métodos comunes, y deja métodos sin cuerpo para sus hijas: `abstract class LibraryItem` |
| **Clase concreta** | Una clase de la que sí se crean objetos: tiene escritos todos sus métodos, también los abstractos que hereda |
| **Clase local** | Una clase escrita dentro de un método. Solo existe dentro de él: `class OutOfStock implements Criterion` en un test |
| **Contrato** | Lo que una clase promete al firmar `implements` o heredar de una abstracta: tener ciertos métodos públicos, con ciertos parámetros. El compilador lo comprueba |
| **`default`** | Método de una interfaz con cuerpo. Lo heredan las clases que la implementan, que pueden sobrescribirlo |
| **`final` (método)** | Un método que las hijas no pueden sobrescribir. Protege el esqueleto de un método plantilla |
| **`implements`** | Palabra con la que una clase firma una o varias interfaces: `class Laptop implements Loanable` |
| **Interfaz** | Un tipo que declara qué métodos se pueden pedir, sin atributos ni constructor: `interface Criterion`. Una clase puede implementar varias |
| **Interfaz funcional** | Una interfaz con un solo método abstracto, como `Criterion`. Se puede implementar con una *lambda*, que verás más adelante |
| **`Interfaz.super.metodo()`** | Llama al `default` de una interfaz concreta. Sirve para elegir cuando una clase hereda dos `default` con el mismo nombre |
| **Método abstracto** | Un método sin cuerpo, que termina en `;`: `abstract int loanDays();`. En una interfaz no hace falta escribir `abstract` |
| **Método plantilla** | Un método del padre que fija los pasos de una operación y llama a métodos que escriben las hijas (*template method*) |
| **`static` (en una interfaz)** | Método de la interfaz, no de los objetos. Se llama solo con el nombre de la interfaz: `Criterion.any(...)` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
