# Glosario — Semana 03

| Término | Definición |
|---|---|
| **Arrange, Act, Assert** | Las tres partes de un test: preparar los datos, hacer la llamada que se prueba y comprobar el resultado |
| **Aserción** | Comprobación dentro de un test: `assertThat(room).isZero()`. Si no se cumple, el test falla |
| **`assert`** | Sentencia de Java que lanza `AssertionError` si su condición es falsa; solo actúa si ejecutas con `-ea` |
| **AssertJ** | Biblioteca de aserciones que se leen de izquierda a derecha: `assertThat(real).isEqualTo(esperado)` |
| **`assertThatThrownBy`** | Aserción de AssertJ que ejecuta una lambda y comprueba que lanza una excepción |
| **Clase de equivalencia** | Grupo de entradas que el código trata igual; basta con probar un representante de cada una |
| **Depurador** | Herramienta que ejecuta tu programa, lo para donde le indicas y te deja ver sus variables y avanzar línea a línea |
| **Error (de un test)** | Resultado de un test que lanza una excepción inesperada: no llega a comparar nada. Surefire lo cuenta en `Errors` |
| **Especificación** | Lo que un método debe hacer, escrito antes de programarlo; en el proyecto, su Javadoc |
| **Excepción** | Objeto que Java lanza cuando algo impide seguir; si nadie la captura, el programa termina y muestra su *stack trace* |
| **Failure** | Resultado de un test en el que una aserción no se cumple: el código devolvió otra cosa |
| **`IllegalArgumentException`** | Excepción estándar para rechazar un argumento no válido: `throw new IllegalArgumentException("...")` |
| **`jdb`** | El depurador de línea de comandos que viene con el JDK |
| **JUnit** | La biblioteca de tests estándar de Java; su motor actual se llama Jupiter |
| **Lambda** | Trozo de código que se pasa sin ejecutarlo: `() -> Shelf.free(10, 12)` |
| **Paso adentro** (*step into*) | En el depurador, entrar en el método que llama la línea actual |
| **Paso afuera** (*step out*) | En el depurador, terminar el método actual y volver a quien lo llamó |
| **Paso por encima** (*step over*) | En el depurador, ejecutar la línea actual entera y parar en la siguiente |
| **Pila de llamadas** | Los métodos en curso en un momento dado, del último llamado al primero |
| **Punto de ruptura** (*breakpoint*) | Línea o método donde el depurador para el programa |
| **Stack trace** | Lista de llamadas en curso que Java imprime con una excepción: tipo, mensaje y una línea `at` por método |
| **Stub** | Método que existe pero aún no hace su trabajo: en los starters, lanza `UnsupportedOperationException` |
| **Surefire** | Plugin de Maven que ejecuta los tests en la fase `test` y resume el resultado |
| **Test** | Método que llama a tu código con datos conocidos y comprueba el resultado |
| **Test parametrizado** | Test que JUnit ejecuta una vez por cada fila de datos: `@ParameterizedTest` con `@CsvSource` |
| **`throw`** | Sentencia que lanza una excepción y corta el método en ese punto |
| **Valor límite** | Primer o último valor de una clase de equivalencia; es donde aparecen los errores de `<` frente a `<=` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
