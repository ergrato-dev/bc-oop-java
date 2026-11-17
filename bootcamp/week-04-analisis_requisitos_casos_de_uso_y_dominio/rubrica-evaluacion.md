# Rúbrica de Evaluación — Semana 04: Análisis: requisitos, casos de uso y objetos del dominio

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 3 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Qué diferencia hay entre un requisito funcional, uno no funcional y una regla de negocio? Pon un ejemplo de cada uno de tu dominio | 10 |
| 2 | Reescribe "El sistema debe ser rápido al buscar" para que se pueda comprobar. ¿Qué prueba usas para saber si un requisito está bien escrito? | 10 |
| 3 | En un caso de uso, ¿qué es un flujo alternativo, cómo se numera y qué debe decir siempre al final? | 10 |
| 4 | ¿Por qué "El bibliotecario pulsa el botón Buscar" no es un buen paso de caso de uso? | 10 |
| 5 | Escribe la historia de usuario y un criterio Dado-Cuando-Entonces para "dar de baja un libro". ¿Qué parte del criterio es el *Arrange* del test? | 10 |
| 6 | ¿Qué hace `@DisplayName` y por qué en el ejercicio 02 se usa además `.as(criterion)`? | 10 |
| 7 | En "Cada libro tiene un código, un título y varios ejemplares", ¿qué sustantivos son objetos y cuáles atributos? ¿Por qué "préstamo" es un objeto si en el enunciado aparece como verbo? | 10 |
| 8 | ¿Qué responde la regla "quien tiene los datos, hace el trabajo"? Aplícala: ¿quién calcula los días de retraso, `Loan` o `Member`? | 10 |
| 9 | En el ejercicio 03, ¿por qué `Arrays.sort(titles)` corrompe el catálogo sin dar ningún error? ¿Qué lo resuelve en la semana 05? | 10 |
| 10 | ¿Por qué `Catalog.add` llama a `Stock.isValidCode` y a `Stock.indexOf` en lugar de validar y buscar por su cuenta? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. Funcional: algo que el sistema hace ("El sistema debe registrar un préstamo"). No funcional: cómo de bien o con qué límites ("responde en menos de 1 segundo con 1 000 libros"). Regla de negocio: una decisión del cliente que el sistema aplica y que puede cambiar ("el préstamo dura 14 días"); por eso entra como argumento en `Rules.overdueDays` y no escrita dentro.
2. "Una búsqueda en un catálogo de 1 000 libros responde en menos de 1 segundo." La prueba: si puedes escribir un test que diga si se cumple, está bien escrito; si no, falta concretar y se pregunta al cliente.
3. Lo que pasa cuando un paso del flujo principal no va bien. Se numera con el número del paso y una letra (3a). Debe decir cómo termina: vuelve a un paso o acaba el caso de uso.
4. Describe la interfaz (un botón), no el problema. Un caso de uso dice "el bibliotecario indica el texto a buscar": sirve igual para la terminal de hoy que para una web mañana.
5. "Como bibliotecario quiero dar de baja un libro perdido para que no aparezca en las búsquedas." "Dado un catálogo con BK-042, BK-107 y BK-311, cuando doy de baja BK-107, entonces quedan BK-042 y BK-311." El "Dado" (el catálogo) es el *Arrange*.
6. Da al test un nombre legible, con el identificador del criterio, que se ve en el editor. Maven no lo muestra en la consola; `.as(...)` pone el criterio en el mensaje de fallo, que sí aparece: `[CA-02 última renovación] expected: false`.
7. "Libro" es un objeto; "código", "título" y "ejemplares" son atributos de libro. "Préstamo" es un objeto porque deja datos que recordar (qué libro, qué socio, desde qué día): sin ellos no se puede calcular el retraso.
8. Dónde va cada responsabilidad: la hace el objeto que tiene los datos para hacerla. Los días de retraso necesitan el día de inicio y el plazo, que los sabe `Loan`.
9. `Arrays.sort` solo ordena el array que recibe: los títulos cambian de posición y los códigos y autores no, así que la posición `i` deja de hablar del mismo libro. Para Java son tres arrays sueltos. En la semana 05 el libro será un objeto con sus datos dentro, y ordenar libros los mueve enteros.
10. Porque ya existen y tienen sus tests: reescribirlos duplicaría código y, si un día cambia la regla de los códigos, habría que cambiarla en dos sitios. Es la misma idea que el glosario: una sola definición para cada cosa.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El primer commit de la rama trae los archivos del starter sin cambios; el análisis llega en un commit `docs:` antes que los métodos de `Catalog` | 8 |
| Commits con sentido | Commits pequeños con Conventional Commits (`docs:`, `feat:`, `test:`), en la rama `week-04` creada desde un `main` con la semana 03 | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test`, `./mvnw test -Dtest=AnalysisTest` y `./mvnw -q compile exec:java` | 10 |
| Explica su análisis | Recorre en voz alta uno de sus casos de uso con sus tarjetas CRC: qué tarjeta hace cada paso y por qué | 8 |
| Analiza en el momento | El instructor añade una frase nueva al enunciado; el aprendiz dice qué requisito, regla u objeto sale de ella y dónde iría en su análisis | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 3

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Análisis | `docs/analisis.md` completo y de su dominio: requisitos que se pueden comprobar, casos de uso con alternativos que dicen cómo terminan, objetos filtrados (sin atributos ni actores como objetos), tarjetas CRC sin una que lo haga todo | 35 |
| Catálogo | Los 3 métodos de `Catalog` pasan los 21 tests de `CatalogTest`, reutilizando `Fields` y `Stock` | 25 |
| Trazabilidad | Al menos 4 tests en `MyDomainTest` con `@DisplayName("CA-0N ...")`, cada uno con su fila en la tabla de criterios y el nombre del test en la columna **Test** | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio, con los tests de las semanas 01 a 03 intactos | 10 |
| Dominio | `App.java` muestra el catálogo con títulos y códigos del dominio, con `titles` y `codes` del mismo tamaño | 10 |
| Pull request | Rama `week-04`, descripción con lo pedido en el paso 13 | 5 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | Semana 05 |
