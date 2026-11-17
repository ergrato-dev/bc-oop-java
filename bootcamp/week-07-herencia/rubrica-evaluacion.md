# Rúbrica de Evaluación — Semana 07: Herencia

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 6 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Qué hereda `RareBook` de `Book`? ¿Tiene un `RareBook` el atributo `private copies`? ¿Puede el código de `RareBook` escribir `copies = 1`? | 10 |
| 2 | ¿Compila `Book b = new RareBook(...)`? ¿Y `b.getRoom()`? ¿Qué decide la variable y qué decide el objeto? | 10 |
| 3 | ¿Por qué un constructor de `RareBook` sin `super(...)` da `constructor Book in class Book cannot be applied to given types`? | 10 |
| 4 | ¿Qué puede ir antes de `super(...)` en Java 25? ¿Por qué tu subclase comprueba ahí la reserva? | 10 |
| 5 | ¿Qué diferencia hay entre sobrecargar y sobrescribir un método? ¿Quién elige cuál se ejecuta en cada caso? | 10 |
| 6 | ¿Qué hace `@Override`? ¿Qué pasa si escribes `@Override String descrbe()`? ¿Y sin `@Override`? | 10 |
| 7 | En el `describe()` de `RareBook`, ¿qué diferencia hay entre `super.describe()` y `describe()`? | 10 |
| 8 | `RareBook` no escribe `toString()`, pero `println(chronicle)` muestra la sala. ¿Por qué? | 10 |
| 9 | ¿Qué abre `protected`, además de las subclases? ¿Por qué los atributos de tu clase siguen siendo `private`? ¿Qué impide `final` en un método y en una clase? | 10 |
| 10 | ¿Por qué `Loan extends Book` es un error aunque compile? ¿Por qué tu subclase, sin unidades, debe lanzar la misma excepción que tu clase? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Hereda los atributos y los métodos (no los constructores). Sí, cada `RareBook` tiene `copies`, pero `RareBook` no puede escribirlo: `private` es "solo dentro de `Book`". Lo cambia con los métodos de `Book`, como `lend()`.
2. Sí: un `RareBook` es un `Book`. `b.getRoom()` no: el compilador solo ve los métodos del tipo de la variable, `Book`. La variable decide qué métodos se pueden **llamar**; el objeto decide **qué versión** se ejecuta.
3. Sin `super(...)` ni `this(...)`, Java pone `super()`, sin argumentos, y `Book` no tiene un constructor sin argumentos. El error habla de `Book` porque es su constructor el que no se encuentra.
4. Líneas que no lean el objeto que se está creando (ni sus atributos ni sus métodos), como comprobar un argumento. Así, si la reserva es negativa, falla antes de construir la parte del padre: *fail fast*.
5. Sobrecargar: mismo nombre, otros parámetros; elige el compilador por los argumentos. Sobrescribir: mismo nombre y mismos parámetros en una subclase; elige el objeto al ejecutarse.
6. Le dice al compilador que el método sobrescribe uno heredado, y él lo comprueba. Con la errata, no compila (`method does not override or implement a method from a supertype`). Sin `@Override` compila como un método nuevo, y se sigue usando el `describe()` heredado sin avisar.
7. `super.describe()` es el de `Book`. `describe()` es el mismo método de `RareBook`, que se llamaría a sí mismo sin fin hasta `StackOverflowError`.
8. Hereda el `toString()` de `Book`, que llama a `describe()`. En un `RareBook`, `describe()` es el sobrescrito, el de `RareBook`: se ejecuta la versión del objeto.
9. Todo el paquete. Porque `protected` dejaría a cualquier clase del paquete (y a cualquier subclase) saltarse las reglas: la subclase usa `getQuantity()` y `super.take()`. En un método, impide sobrescribirlo; en una clase, heredar de ella.
10. Un préstamo no es un libro: hereda `restock(5)` y acaba con ejemplares, y cabe en cualquier sitio que espere un libro. Porque quien la trate como tu clase cuenta con lo que promete `take()`: sacar una unidad o lanzar esa excepción con ese mensaje.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae los tests y la subclase del starter sin implementar; `toString()` y la subclase llegan en commits posteriores | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`feat:`, `test:`), en la rama `week-07` creada desde un `main` con la semana 06 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest=Reserved<Clase>Test` y `./mvnw -q compile exec:java` | 10 |
| Explica sus decisiones | Dice qué es la reserva en su dominio, por qué su subclase **es una** entidad y no la **tiene**, qué hereda sin cambiar y por qué `take()` llama a `super.take()` | 8 |
| Predice en el momento | El instructor guarda la subclase en una variable de tu clase y llama a `take()`, `describe()` o `println`; el aprendiz dice qué versión se ejecuta y qué imprime antes de ejecutarlo | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 6

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| `toString()` | Los 43 tests de su clase pasan: `toString()` sobrescrito con `@Override`, que devuelve `describe()` | 10 |
| Subclase | Los 17 tests de `Reserved<Clase>Test` pasan, con su clase en lugar de `Entity` | 30 |
| Reutilización | El constructor llama a `super(...)` sin repetir validaciones; `describe()` y `take()` usan `super`; la subclase usa `getQuantity()`, no atributos del padre | 15 |
| Tests propios | Al menos 3 tests nuevos en `MyDomainTest` con datos de su dominio: la reserva, la subclase en una variable de su clase y un inventario | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 a 06 intactos | 10 |
| Pull request | Rama `week-07`, descripción con lo pedido en el paso 11, incluida la reserva con un ejemplo de su dominio | 20 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | [Semana 08](../week-08-polimorfismo/README.md) |
