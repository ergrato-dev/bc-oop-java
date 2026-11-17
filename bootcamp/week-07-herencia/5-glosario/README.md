# Glosario — Semana 07

| Término | Definición |
|---|---|
| **Anotación** | Una marca que empieza por `@` y da información al compilador sobre el código que la sigue, como `@Override` |
| **Clase `final`** | Clase de la que no se puede heredar: `final class Isbn`. `String` es una |
| **Composición** | Relación en la que un objeto tiene otros en sus atributos. Responde a "¿tiene un...?" y suele ser mejor opción que la herencia (semana 06) |
| **`extends`** | La palabra con la que una clase hereda de otra: `class RareBook extends Book` |
| **Herencia** | Relación en la que una clase recibe los atributos y métodos de otra y añade o cambia lo suyo. Responde a "¿es un...?" |
| **Jerarquía** | El árbol que forman las clases al heredar unas de otras, con `Object` en la raíz |
| **Método `final`** | Método que ninguna subclase puede sobrescribir |
| **`Object`** | La clase de la que heredan todas las demás, directa o indirectamente. Da a todo objeto métodos como `toString()`, `equals()` y `getClass()` |
| **`@Override`** | Anotación que dice que un método sobrescribe uno heredado. Si no es verdad (una errata, otros parámetros), no compila |
| **`protected`** | Nivel de acceso: la propia clase, las clases del mismo paquete y las subclases. Abre más de lo que parece |
| **Sobrecarga** (*overloading*) | Varios métodos o constructores con el mismo nombre y distintos parámetros. El compilador elige cuál por los argumentos |
| **Sobrescritura** (*overriding*) | Un método de una subclase con el mismo nombre y los mismos parámetros que uno heredado, que lo sustituye en los objetos de la subclase |
| **Subclase** | La clase que hereda: `RareBook` es subclase de `Book`. También clase hija |
| **`super(...)`** | En un constructor, la llamada al constructor de la superclase, que construye la parte del padre |
| **`super.metodo()`** | La llamada a la versión de la superclase de un método sobrescrito: `super.describe()` |
| **Superclase** | La clase de la que se hereda: `Book` es superclase de `RareBook`. También clase padre |
| **`toString()`** | Método de `Object` que da la forma de texto de un objeto. Java lo llama en `println(objeto)` y en `"texto" + objeto` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
