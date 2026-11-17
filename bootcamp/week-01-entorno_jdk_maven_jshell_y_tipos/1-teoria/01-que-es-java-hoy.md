# 01 · Qué es Java hoy

⏱️ 40 min

## 1. Lenguaje, plataforma y distribución

Cuando alguien dice "Java" puede referirse a tres cosas:

| Término | Qué es |
|---|---|
| **El lenguaje** | Las reglas para escribir programas: `class`, `if`, tipos, métodos. Lo define la *Java Language Specification* |
| **La JVM** (*Java Virtual Machine*) | El programa que ejecuta el bytecode. Es lo que hace que el mismo `.class` funcione en Linux, macOS y Windows |
| **El JDK** (*Java Development Kit*) | Lo que instalas para programar: el compilador `javac`, la JVM, el lanzador `java`, `jshell` y la biblioteca estándar |

El JDK lo publican varios proveedores a partir del mismo código abierto, **OpenJDK**. En este bootcamp usas **Eclipse Temurin**, una distribución gratuita, sin licencias de pago y con builds verificados. Oracle, Amazon (Corretto) o Microsoft publican otras; para lo que harás aquí, son equivalentes.

## 2. Versiones y LTS

Java publica una versión nueva cada seis meses (marzo y septiembre). Cada dos años, una es **LTS** (*Long-Term Support*): recibe parches de seguridad durante años. Las empresas trabajan con LTS.

| Versión | Año | Qué trajo que usarás |
|---|---|---|
| 8 | 2014 | Lambdas y streams (semana 15) |
| 17 LTS | 2021 | Records y clases `sealed` (semana 10) |
| 21 LTS | 2023 | Pattern matching en `switch` (semana 10) |
| **25 LTS** | 2025 | Archivos de código compactos con `void main()` e `IO.println` (teoría 04) |

El curso usa **Java 25 LTS** y una versión de parche exacta, `25.0.5` (ver [`docs/stack-versions.md`](../../../docs/stack-versions.md)). Fijar la versión completa evita el clásico "en mi máquina funciona": todos compilan con lo mismo.

Java es **compatible hacia atrás**: un programa escrito para Java 8 compila y corre en Java 25. Lo contrario no: si escribes `void main()` sin clase y lo ejecutas con Java 21, falla (lo provocas en el ejercicio 01).

## 3. Dónde se usa

- **Backend empresarial**: bancos, aseguradoras, comercio electrónico. Spring Boot (`bc-javaweb-sb`) es el framework dominante.
- **Android**: el SDK está en Java y Kotlin, y Kotlin corre sobre la JVM.
- **Datos a gran escala**: Kafka, Elasticsearch, Hadoop y Spark están escritos en Java o en lenguajes de la JVM.
- **Herramientas**: IntelliJ IDEA, Maven, Gradle.

Lo que tienen en común: sistemas grandes que viven muchos años y que mantienen equipos que cambian. Para eso se diseñó la **programación orientada a objetos**, que es el centro de este bootcamp a partir de la semana 05.

## 4. Lo que no es

- **No es JavaScript**. Comparten cuatro letras y una época (1995); nada más.
- **No es lento**. La JVM compila en caliente el código que más se usa (*JIT*) a código máquina optimizado.
- **No es solo "verboso"**. El Java de 2014 lo era; el de 2025 tiene `var`, records, pattern matching y archivos compactos. Este curso enseña el actual.

## ✅ Comprueba que lo entendiste

1. ¿Qué diferencia hay entre el JDK y la JVM? ¿Cuál necesitas para compilar?
2. ¿Por qué el curso fija `25.0.5` y no "la última de Java"?
3. Un programa compilado con Java 25 usa `void main()`. ¿Qué pasa si lo ejecutas con Java 21?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 01](../README.md) | **01 · Qué es Java hoy** | [02 · Del código a la JVM](02-del-codigo-a-la-jvm.md) |
