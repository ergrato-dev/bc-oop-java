# Glosario — Semana 10

| Término | Definición |
|---|---|
| **Caso dominado** | Un `case` que nunca se ejecutaría porque otro anterior ya acepta todo lo que él acepta. No compila: `this case label is dominated by a preceding case label` |
| **Componente** | Cada uno de los datos que un record declara entre paréntesis. Java crea un atributo `private final` y un método de acceso con su nombre: `code` y `code()` |
| **Constante de enum** | Cada valor de un enum: `Format.PAPER`. Es un objeto único, que se compara con `==` |
| **Constructor compacto** | Constructor de un record sin paréntesis, `Loan { ... }`, que solo valida o normaliza los parámetros. Java asigna los componentes al final |
| **Enum** | Un tipo con un número fijo de valores, escritos en su declaración: `enum Level { SOLD_OUT, LOW, NORMAL, FULL }`. Puede tener atributos, constructor y métodos |
| **Exhaustivo** | Un `switch` que tiene respuesta para todo lo que puede recibir. Si devuelve un valor y no es exhaustivo, no compila: `the switch expression does not cover all possible input values` |
| **Guarda (`when`)** | Condición que se añade a un `case` con patrón: `case Book book when book.pages() > 1000`. El caso solo encaja si se cumple |
| **`non-sealed`** | Modificador de una hija de un tipo sellado que vuelve a abrir la jerarquía por debajo de ella |
| **`ordinal()`** | La posición de una constante en su enum, desde 0. No guardes nada que dependa de ella |
| **Patrón** | Una forma que un objeto puede tener o no. Si la tiene, el patrón te da sus partes: `instanceof Book book`, `case Taken(String code, int left)` |
| **Patrón de record** | Patrón que comprueba que un objeto es de un record y lo desmonta en sus componentes: `Taken(String code, int left)` |
| **`permits`** | Lista, en la cabecera de un tipo sellado, de las clases que pueden heredar de él o implementarlo |
| **Record** | Una clase para datos que no cambian. Se declara con sus componentes, `record Taken(String code, int left)`, y Java escribe el constructor, los accesos, `equals`, `hashCode` y `toString` |
| **Resultado** | Un objeto que dice cómo terminó una operación, en lugar de lanzar una excepción: tu `Outcome`, que es un `Taken` o un `Rejected` |
| **`sealed`** | Modificador que cierra una clase o interfaz: solo pueden heredar de ella o implementarla las clases de su `permits` |
| **`valueOf(String)`** | Método de todo enum que devuelve la constante con ese nombre exacto, o lanza `IllegalArgumentException` |
| **`values()`** | Método de todo enum que devuelve un array con sus constantes, en el orden de la declaración |
| **`_` (variable sin nombre)** | Marca una parte de un patrón que no vas a usar: `case Rejected(_, String reason)`, `case Magazine _` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
