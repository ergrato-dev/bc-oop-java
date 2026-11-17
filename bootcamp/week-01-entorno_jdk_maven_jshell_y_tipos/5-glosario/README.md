# Glosario — Semana 01

| Término | Definición |
|---|---|
| **Archivo de código compacto** | Desde Java 25, un `.java` con `void main()` y otros métodos sin declarar clase. Para programas pequeños |
| **AssertJ** | Biblioteca de aserciones: `assertThat(actual).isEqualTo(esperado)` |
| **BOM** | *Bill of materials*: dependencia especial que fija las versiones de un grupo de bibliotecas |
| **Bytecode** | Instrucciones que genera `javac` en los `.class` y que ejecuta la JVM |
| **Casting** | Conversión explícita entre tipos: `(int) 4.99`. Puede perder información |
| **Ciclo de vida** | Fases de Maven en orden fijo: `validate`, `compile`, `test`, `package`... Cada una incluye las anteriores |
| **Coordenadas** | `groupId`, `artifactId` y `version`: el nombre único de un proyecto o dependencia Maven |
| **Dependencia** | Biblioteca externa que el proyecto usa; Maven la descarga de Maven Central |
| **Error de compilación** | Fallo que detecta `javac` antes de ejecutar nada |
| **Excepción** | Fallo durante la ejecución: `NumberFormatException`, `ArithmeticException` |
| **JDK** | *Java Development Kit*: compilador, JVM, `jshell` y biblioteca estándar |
| **JIT** | *Just in time*: la JVM compila a código máquina los métodos que más se usan |
| **JShell** | REPL de Java: evalúa expresiones sin crear archivos |
| **JUnit** | *Framework* que encuentra y ejecuta los métodos `@Test` |
| **JVM** | *Java Virtual Machine*: ejecuta bytecode en cada sistema operativo |
| **LTS** | *Long-Term Support*: versión con parches durante años. Java 25 lo es |
| **Locale** | Configuración regional; `Locale.ROOT` fija el punto decimal al formatear |
| **Maven Wrapper** | Scripts `mvnw` que descargan y usan la versión de Maven fijada en el proyecto |
| **Método `static`** | Método que pertenece a la clase; se llama con su nombre: `Fields.describe(...)` |
| **Overflow** | Un entero que supera su máximo da la vuelta al mínimo sin error |
| **Paquete** | Agrupación de clases; coincide con la carpeta: `package gestion;` |
| **`pom.xml`** | Archivo que describe un proyecto Maven |
| **Primitivo** | Tipo cuyo valor se guarda en la variable: `int`, `double`, `boolean`, `char`... |
| **Referencia** | Variable que apunta a un objeto, como un `String` |
| **Stack trace** | Pila de llamadas que muestra una excepción; la primera línea con tu archivo dice dónde falló |
| **Temurin** | Distribución gratuita del JDK de Eclipse Adoptium, la del curso |
| **`var`** | Deja que el compilador deduzca el tipo de una variable local; el tipo sigue siendo fijo |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Videografía](../4-recursos/videografia/README.md) | **Glosario** | [Rúbrica de evaluación](../rubrica-evaluacion.md) |
