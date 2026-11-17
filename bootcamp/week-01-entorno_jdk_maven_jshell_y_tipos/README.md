# Semana 01 — Entorno: JDK 25, Maven Wrapper, JShell y tipos

> Antes de escribir clases hay que saber qué pasa entre tu `.java` y un programa funcionando, quién compila, quién descarga las bibliotecas y por qué `0.1 + 0.2` no da `0.3`. Esta semana montas el entorno que usarás las 23 siguientes y das tus primeros pasos con los tipos.

No hay bucles, ni arrays, ni objetos propios. Hay un compilador, una JVM, un proyecto Maven con tests, los tipos básicos y los primeros métodos de tu sistema de gestión.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Distinguir** JDK, JVM y bytecode, y **leer** un error de compilación y un *stack trace*
- **Usar** JShell para probar expresiones
- **Compilar, probar, ejecutar y empaquetar** un proyecto con `./mvnw`
- **Explicar** qué fijan `pom.xml` y `.mvn/wrapper/maven-wrapper.properties`, y por qué `target/` no va a Git
- **Elegir** el tipo correcto (`int`, `long`, `double`, `boolean`, `char`, `String`) y **convertir** entre tipos de forma explícita
- **Comparar** `double` con tolerancia y `String` con `equals`

---

## 📋 Prerrequisitos

- Ninguna semana anterior: esta es la primera.
- JDK 25, Git y editor según [`docs/setup.md`](../../docs/setup.md).
- Terminal básica y Git (`bc-linux-commandline`, `bc-git-github`).
- **No hace falta saber programar.**

---

## 🗂️ Estructura de la Semana

```
week-01-entorno_jdk_maven_jshell_y_tipos/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 0 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Qué es Java hoy](1-teoria/01-que-es-java-hoy.md) | Lenguaje, JVM y JDK; Temurin; LTS y versiones fijadas | 40 min |
| [02 · Del código a la JVM](1-teoria/02-del-codigo-a-la-jvm.md) | `javac`, bytecode, JVM, errores de compilación frente a excepciones, *stack trace* | 45 min |
| [03 · Maven y el wrapper](1-teoria/03-maven-y-el-wrapper.md) | `pom.xml`, dependencias, ciclo de vida, `./mvnw`, JUnit y AssertJ | 55 min |
| [04 · JShell y el primer programa](1-teoria/04-jshell-y-el-primer-programa.md) | REPL, `void main()` de Java 25, la clase con `main` clásico, convenciones | 40 min |
| [05 · Variables y tipos](1-teoria/05-variables-y-tipos.md) | Primitivos y referencias, sorpresas, conversiones, formato, `var`, `String` | 1 h |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Hola, Java](2-practicas/ejercicio-01-hola-java/README.md) | Toolchain, primer método, `javac` y `java`, los dos tipos de error | 1 h 30 min |
| [02 · Primer proyecto Maven](2-practicas/ejercicio-02-primer-proyecto-maven/README.md) | Wrapper, `compile`, `test`, un fallo de AssertJ, `exec:java` y `package` | 2 h |
| [03 · Tipos y conversiones](2-practicas/ejercicio-03-tipos-y-conversiones/README.md) | *Overflow*, `double` inexactos, división entera, `parseInt`, `==` frente a `equals`, formato | 2 h |

### Proyecto

Con el dominio que te asignó tu instructor, creas tu repositorio y escribes la capa 0 del sistema de gestión: leer, normalizar, validar y mostrar los campos de tu entidad, con tests calculados a mano.
→ [3-proyecto/README.md](3-proyecto/README.md)

---

## ⏱️ Distribución del Tiempo (14 horas)

| Actividad | Tiempo |
| --------- | ------ |
| Teoría (5 archivos) | 4 h |
| Ejercicio 01 | 1 h 30 min |
| Ejercicio 02 | 2 h |
| Ejercicio 03 | 2 h |
| Proyecto | 3 h |
| Recursos y glosario | 30 min |
| Autoevaluación (cuestionario de la rúbrica) | 1 h |
| **Total** | **14 h** |

---

## 🎩 Trucos y atajos

| Truco | Cómo |
| ----- | ---- |
| Probar una línea sin crear archivo | `jshell` y escribe la expresión |
| Ver los métodos de un objeto en JShell | Escribe `"texto".` y pulsa `Tab` |
| Ejecutar un solo test | `./mvnw test -Dtest=FieldsTest#describeUsesTwoDecimalsAndDot` |
| Ejecutar los tests de una clase | `./mvnw test -Dtest=FieldsTest` |
| Ver solo la salida del programa | `./mvnw -q compile exec:java` |
| Empezar de cero | `./mvnw clean test` |
| Saber qué Maven y qué Java usa el proyecto | `./mvnw --version` |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Repositorio `oop-java-<nombre>-<apellido>` con tu dominio en su README
2. ✅ Rama `week-01` con al menos 5 tests propios y `./mvnw test` en verde
3. ✅ Pull request `week-01` → `main` con dominio, versiones y salidas

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con `Failures: 0, Errors: 0`; el segundo, mostrar tus tres registros. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README. Si algo falla antes de llegar a los tests (Java, wrapper), revisa la tabla de errores de [`docs/setup.md`](../../docs/setup.md) y la del [ejercicio 02](2-practicas/ejercicio-02-primer-proyecto-maven/README.md).

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Índice de semanas](../README.md) | **Semana 01** | Semana 02 |

← [Volver al inicio del bootcamp](../../README.md)
