# Rúbrica de Evaluación — Semana 05: Clases y objetos

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 4 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Qué diferencia hay entre una clase y un objeto? ¿Cuántos objetos crea `Book a = new Book(); Book b = a;`? | 10 |
| 2 | ¿Qué valor tienen `code` (`String`) y `copies` (`int`) en un objeto creado con `new Book()` sin constructor? ¿Por qué un atributo compila sin valor y una variable local no? | 10 |
| 3 | ¿Qué hace `this` en `this.code = code`? ¿Qué pasa si escribes solo `code = code`? | 10 |
| 4 | Una clase tiene un constructor `Book(String code, String title)`. ¿Compila `new Book()`? ¿Por qué? | 10 |
| 5 | ¿Por qué `take()` con 0 unidades lanza `IllegalStateException` y no `IllegalArgumentException`? ¿Por qué comprueba antes de restar? | 10 |
| 6 | Después de `Book alias = original; alias.copies = 0;`, ¿cuánto vale `original.copies`? Dibuja variables y objetos | 10 |
| 7 | ¿Qué compara `==` entre dos objetos? ¿Qué da `new Book("BK-1", "A", 1) == new Book("BK-1", "A", 1)`? | 10 |
| 8 | ¿Por qué un método puede poner a 0 las unidades de un libro que recibe, pero no puede hacer que la variable de quien lo llamó apunte a otro libro? | 10 |
| 9 | ¿Qué contiene `new Book[3]` al crearlo? Lee este mensaje y di qué falló: `Cannot invoke "Book.describe()" because "books[2]" is null` | 10 |
| 10 | En tu clase, ¿por qué `describe()` es de instancia e `indexOf(items, code)` es `static`? ¿Qué problema de los arrays paralelos resuelve un array de objetos? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. La clase es la descripción de un tipo (qué atributos y métodos tiene); un objeto es un ejemplar concreto, con sus propios valores. Crea **un** objeto: `b = a` copia la referencia, y las dos variables apuntan al mismo libro.
2. `null` y `0`: los atributos toman el valor por defecto de su tipo. Una variable local no tiene valor por defecto, y Java no deja usarla hasta que se le asigna uno.
3. `this.code` es el atributo del objeto que se construye; `code` a secas es el parámetro, que tapa al atributo. `code = code` copia el parámetro en sí mismo y el atributo se queda en `null`, sin aviso.
4. No. Java solo da el constructor vacío por defecto a una clase sin ningún constructor; en cuanto escribes uno, deja de darlo.
5. Porque no falla ningún argumento (no tiene): falla el estado del objeto, que no tiene unidades. Comprueba antes para que, si lanza la excepción, el objeto quede como estaba y no con `-1`.
6. 0. `alias = original` copia la flecha: hay un solo objeto con dos variables apuntándolo.
7. Si las dos variables apuntan al mismo objeto, no si tienen los mismos datos. Da `false`: son dos objetos distintos.
8. Java pasa una copia de la referencia: el método apunta al mismo objeto y puede cambiarlo por dentro, pero si reasigna el parámetro solo cambia su copia, no la variable de quien lo llamó.
9. Tres referencias a `null`, ningún libro. Falló llamar a `describe()` sobre la posición 2 del array `books`, que no apunta a ningún libro: nadie le asignó un objeto.
10. `describe()` usa los datos de un objeto; `indexOf` busca entre varios, y ningún objeto ve a los demás, así que recibe el array y no tiene `this`. Con objetos, cada posición guarda el registro entero: no se puede crear a medias (el constructor pide todo) y ordenar o crecer el array no descuadra sus datos.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae la clase y el test del starter ya renombrados, sin implementar; los métodos llegan en commits posteriores | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`feat:`, `test:`), en la rama `week-05` creada desde un `main` con la semana 04 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest=<Clase>Test` y `./mvnw -q compile exec:java` | 10 |
| Explica su clase | Recorre su clase y dice, para cada método, si es consulta u orden, de instancia o `static`, y qué responsabilidad de su tarjeta CRC cumple | 8 |
| Predice en el momento | El instructor escribe tres líneas con alias, `==` o un método que reasigna su parámetro; el aprendiz dice qué imprimen antes de ejecutarlas | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 4

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Clase | Los 27 tests del starter pasan con la clase renombrada al objeto principal de su análisis, en inglés y en singular, sin ningún `Entity` | 30 |
| Reutilización | El constructor usa `Fields.normalizeCode` y `level` usa `Stock.level`, en lugar de repetir esas reglas | 15 |
| Tests propios | Al menos 3 tests en `MyDomainTest` con objetos de su clase y datos de su dominio, uno con dos o más objetos | 20 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 a 04 intactos | 10 |
| Dominio | `App.java` crea un array de objetos de su dominio, cambia el estado de alguno y los describe | 15 |
| Pull request | Rama `week-05`, descripción con lo pedido en el paso 12, incluida su tarjeta CRC con el método de cada responsabilidad | 10 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | Semana 06 |
