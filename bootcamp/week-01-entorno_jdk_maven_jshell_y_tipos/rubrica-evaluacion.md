# Rúbrica de Evaluación — Semana 01: Entorno, Maven, JShell y tipos

## 📊 Distribución de Evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30% | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40% | Proceso en el proyecto: historial de Git, ejecución y sustentación ante el instructor |
| Producto 📦 | 30% | Proyecto semanal: gestión, capa 0 |

**Nota mínima para aprobar**: 70% en cada tipo de evidencia.

---

## 🧠 Conocimiento (30%)

Responde por escrito **antes** de abrir las respuestas.

| # | Pregunta | Puntaje |
| - | -------- | ------- |
| 1 | ¿Qué diferencia hay entre el JDK y la JVM? ¿Qué contiene un `.class`? | 10 |
| 2 | Un programa imprime dos líneas y en la tercera tiene un `;` olvidado. ¿Cuántas líneas ves al ejecutarlo? ¿Y si en la tercera hubiera un `Integer.parseInt("doce")`? | 10 |
| 3 | En un *stack trace*, ¿qué te dice la primera línea y cómo encuentras la línea de tu código que falló? | 10 |
| 4 | ¿Qué fija `.mvn/wrapper/maven-wrapper.properties` y qué problema evita usar `./mvnw` en vez de un `mvn` instalado? | 10 |
| 5 | ¿Por qué `./mvnw package` no genera el `.jar` si un test falla? ¿Por qué `target/` no va a Git? | 10 |
| 6 | ¿Qué significa `<scope>test</scope>` en la dependencia de AssertJ? | 10 |
| 7 | ¿Qué dan `Integer.MAX_VALUE + 1`, `7 / 2` y `(int) 4.99`? | 10 |
| 8 | ¿Por qué `0.1 + 0.2 == 0.3` es `false` y cómo comparas dos `double`? | 10 |
| 9 | `String a = new String("BK-042");` ¿Qué dan `a == "BK-042"` y `a.equals("BK-042")`, y por qué? | 10 |
| 10 | ¿Por qué `describe` usa `String.format(Locale.ROOT, ...)` y qué pasaría en los tests sin `Locale.ROOT`? | 10 |

**Total**: 100 puntos → 30% de la nota final.

<details>
<summary>Respuestas</summary>

1. El JDK es el kit para programar: compilador `javac`, JVM, `jshell` y la biblioteca estándar. La JVM es solo la máquina que ejecuta. Un `.class` contiene bytecode: instrucciones para la JVM, iguales en cualquier sistema operativo.
2. Con el `;` olvidado, ninguna: es un error de compilación y no se ejecuta nada. Con `parseInt("doce")`, ves las dos primeras y después la excepción, porque el programa compila y falla al llegar a esa línea.
3. La primera línea dice qué pasó: el tipo de excepción y su mensaje. La línea de tu código es la primera línea `at` que nombra tu archivo (no las de `java.base/`).
4. La versión exacta de Maven (3.10.0). Evita que cada persona construya con una versión distinta: cualquiera que clone el proyecto usa el mismo Maven sin instalarlo.
5. Porque `package` incluye la fase `test` y Maven se detiene en la primera fase que falla: no se empaqueta código con tests en rojo. `target/` lo regenera Maven desde `src/` y `pom.xml`; subirlo solo añade ruido y conflictos.
6. Que AssertJ solo está disponible para compilar y ejecutar los tests; el programa no la lleva ni puede usarla.
7. `-2147483648` (*overflow*: da la vuelta sin error), `3` (división entera) y `4` (el casting trunca).
8. `double` guarda los números en binario y `0.1` no tiene representación exacta, así que la suma arrastra un error de redondeo (`0.30000000000000004`). Se comparan con tolerancia: `Math.abs(a - b) < 1e-9`, o en los tests con `isCloseTo(..., within(...))`.
9. `false` y `true`. `==` compara referencias (si son el mismo objeto) y `new String` crea un objeto nuevo; `equals` compara el contenido.
10. Para que el separador decimal sea siempre un punto. Sin `Locale.ROOT`, Java usa el idioma del sistema: en un equipo en español daría `12,50` y el test que espera `12.50` fallaría en esa máquina y pasaría en otra.

</details>

---

## 💪 Desempeño (40%)

Se evalúa **cómo** construiste el proyecto, con evidencia del repositorio y una sustentación corta (10 min) con el instructor. Los ejercicios guiados no se evalúan.

| Criterio | Evidencia | Puntaje |
| -------- | --------- | ------- |
| Rojo antes que verde | El historial muestra el starter con tests en rojo y después los commits que los ponen en verde | 8 |
| Commits con sentido | Commits pequeños, con Conventional Commits, sin `target/` ni `.class` | 6 |
| Ejecución en vivo | Ante el instructor, desde un clon limpio: `./mvnw test` y `./mvnw -q compile exec:java` | 10 |
| Explica su código | Explica cada llamada de `parseAmount` y por qué el orden importa (`replace` antes de `parseDouble`) | 8 |
| Explica su entorno | Dice qué fijan `pom.xml` y el wrapper, y lee en voz alta un *stack trace* provocado en el momento | 8 |
| **Total** | | **40** |

**Total Desempeño**: 40 puntos → 40% de la nota final.

---

## 📦 Producto (30%)

### Proyecto Semanal — Gestión, capa 0

| Criterio | Descripción | Puntaje |
| -------- | ----------- | ------- |
| Métodos | `parseAmount`, `normalizeCode`, `describe`, `isInRange` y `fits` pasan los 12 tests de `FieldsTest` | 30 |
| Tests propios | Al menos 5 tests con valores del dominio calculados a mano, que cubren los 5 casos del paso 9 | 30 |
| Dominio | `App.java` con 3 registros reales del dominio (uno con coma decimal) y `README.md` completado | 15 |
| Construcción | `./mvnw test` en verde desde un clon limpio | 10 |
| Git | Repositorio `oop-java-<nombre>-<apellido>`, rama `week-01`, Conventional Commits, sin `target/` en el repositorio | 10 |
| Pull request | Descripción con dominio, versiones y salidas pedidas en el paso 10 | 5 |
| **Total** | | **100** |

**Total Producto**: 100 puntos → 30% de la nota final.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Glosario](5-glosario/README.md) | **Rúbrica de evaluación** | Semana 02 |
