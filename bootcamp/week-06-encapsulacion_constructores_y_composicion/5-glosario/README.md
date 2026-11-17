# Glosario — Semana 06

| Término | Definición |
|---|---|
| **Acceso de paquete** | El nivel de acceso de un miembro sin modificador: lo pueden usar las clases del mismo paquete |
| **Composición** | Relación en la que un objeto tiene otros objetos en sus atributos: un inventario tiene entidades. Responde a "¿tiene un...?" |
| **Copia defensiva** | Copia de un dato mutable (un array) que un objeto devuelve en lugar del original, para que nadie de fuera pueda cambiar su estado |
| **Delegar** | Pasarle una orden al objeto que sabe cumplirla, en lugar de hacerla uno mismo: `inventory.take(code)` llama a `take()` de la entidad |
| **Encapsulación** | Juntar en una clase los datos y las reglas que los protegen, y esconder los datos para que solo cambien a través de esas reglas |
| ***Fail fast*** | Fallar en cuanto aparece un dato que no vale, en la línea que lo trajo, en lugar de dejar que el error se manifieste más tarde y en otro sitio |
| **`final`** | En un atributo o una variable: solo recibe valor una vez. En una variable de tipo objeto fija la referencia, no el objeto |
| ***Getter*** | Método que devuelve el valor de un atributo: `getCode()`. Para un `boolean`, `isAvailable()` |
| **`IllegalArgumentException`** | Excepción para un argumento que no vale: un código mal formado que se pasa al constructor |
| **Inmutable** | Un objeto cuyo estado no puede cambiar después de creado, como un `String` |
| **Invariante** | Algo que es verdad para cualquier objeto de una clase, en cualquier momento: "las unidades nunca son negativas" |
| **Modificador de acceso** | La palabra que dice quién puede usar un atributo, un método o un constructor: `private`, `protected`, `public` o ninguna |
| **`private`** | Modificador de acceso: solo el código de la propia clase puede usar ese miembro |
| **`public`** | Modificador de acceso: cualquier clase puede usar ese miembro |
| ***Setter*** | Método que asigna un atributo: `setCopies(n)`. Si no valida, deja la puerta tan abierta como un atributo sin `private` |
| **Sobrecarga** | Varios constructores (o métodos) con el mismo nombre y distintos parámetros |
| ***Tell, don't ask*** | "Dile, no le preguntes": pedirle al objeto que haga algo (`take()`) en lugar de leer sus datos y decidir fuera |
| **`this(...)`** | Llamada desde un constructor a otro constructor de la misma clase |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
