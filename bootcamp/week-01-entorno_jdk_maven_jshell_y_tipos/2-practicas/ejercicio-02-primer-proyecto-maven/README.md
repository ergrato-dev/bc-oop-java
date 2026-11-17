# Ejercicio 02 — Primer proyecto Maven

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-maven-y-el-wrapper.md)

## Objetivo

Recorrer un proyecto Maven de punta a punta: que el wrapper descargue Maven, compilar, ejecutar los tests, leer un fallo, ejecutar el programa y empaquetarlo en un `.jar`. Es la misma estructura que tendrá tu proyecto de la semana. Es un ejercicio **guiado**: los tests nuevos vienen comentados por pasos en `GreeterTest.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-01-entorno_jdk_maven_jshell_y_tipos/2-practicas/ejercicio-02-primer-proyecto-maven/starter
ls -A
```

Debes ver: `.mvn  mvnw  mvnw.cmd  pom.xml  src`.

## Pasos

### 1. El wrapper descarga Maven

```bash
./mvnw --version
```

La primera vez descarga Maven 3.10.0 en `~/.m2/wrapper/` (tarda un poco). Salida esperada (la primera línea):

```
Apache Maven 3.10.0 (c43a36b8d67be7e0805a411bc0898af1a51f5472)
```

La versión no la elige tu máquina: la fija `.mvn/wrapper/maven-wrapper.properties`. Ábrelo y busca `3.10.0`.

### 2. Lee la estructura

```bash
find . -name "*.java"
```

Salida esperada:

```
./src/main/java/hola/App.java
./src/main/java/hola/Greeter.java
./src/test/java/hola/GreeterTest.java
```

`src/main/java` es el programa; `src/test/java`, los tests. `hola` es el **paquete**: la primera línea de cada archivo dice `package hola;` y la carpeta se llama igual. Abre `pom.xml` y localiza las coordenadas (`groupId`, `artifactId`, `version`), la versión de Java (`maven.compiler.release`) y las dos dependencias de test.

### 3. Compila

```bash
./mvnw compile
ls target/classes/hola
```

La primera vez descarga los plugins. Al final debe decir `BUILD SUCCESS`, y `ls` mostrar `App.class  Greeter.class`. `target/` es lo que genera Maven: no se edita ni se sube a Git.

### 4. Ejecuta los tests

```bash
./mvnw test
```

Busca estas líneas al final:

```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

`test` incluye `compile`: Maven ejecuta las fases del ciclo de vida en orden hasta la que pides.

### 5. Un test que falla

En `src/test/java/hola/GreeterTest.java`, descomenta el **PASO 5** (incluida la línea `@Test`) y ejecuta:

```bash
./mvnw test
```

Salida esperada (el fragmento que importa):

```
[ERROR] hola.GreeterTest.trimsSpaces -- Time elapsed: 0.011 s <<< FAILURE!
org.opentest4j.AssertionFailedError: 

expected: "Hola, ANA"
 but was: "Hola, Ana"
	at hola.GreeterTest.trimsSpaces(GreeterTest.java:22)
```

y al final `Tests run: 2, Failures: 1` y `BUILD FAILURE`. AssertJ dice qué esperabas (`expected`), qué obtuvo (`but was`) y en qué línea. Aquí el error está en el test, no en el código: corrige `"Hola, ANA"` por `"Hola, Ana"` y vuelve a ejecutar hasta ver `Tests run: 2, Failures: 0`.

### 6. Otro caso

Descomenta el **PASO 6** y ejecuta `./mvnw test`. Esperado: `Tests run: 3, Failures: 0`.

### 7. Ejecuta el programa

```bash
./mvnw -q compile exec:java
```

Salida esperada:

```
Hola, Ana
Hola, mundo
```

`-q` (*quiet*) oculta los mensajes de Maven y deja solo la salida del programa. `exec:java` ejecuta la clase que indica `<mainClass>` en el `pom.xml`.

### 8. Empaqueta

```bash
./mvnw -q package
ls target/*.jar
java -cp target/hola-0.1.0.jar hola.App
```

`package` compila, pasa los tests y crea `target/hola-0.1.0.jar` (nombre = `artifactId-version`). Un `.jar` es un zip con los `.class`; `java -cp` lo usa como *classpath* y `hola.App` es el nombre completo de la clase (paquete + clase). La salida es la del paso 7.

Prueba a romper un test (cambia `"Hola, Ana"` por `"Hola"` en `greetsByName`) y repite `./mvnw package`: termina en `BUILD FAILURE` sin llegar a la fase `package`, porque Maven no empaqueta código con tests en rojo. Deshaz el cambio.

### 9. Limpia

```bash
./mvnw -q clean
ls
```

`target/` desaparece. Todo lo que había dentro se regenera desde `src/` y `pom.xml`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `./mvnw: Permission denied` | `chmod +x mvnw` |
| `The JAVA_HOME environment variable is not defined correctly` | Abre otra terminal; si sigue, revisa SDKMAN en [`docs/setup.md`](../../../../docs/setup.md) |
| `release version 25 not supported` | Tu `java -version` no es 25: `sdk default java 25.0.5-tem` |
| `Tests run: 0` | El método de test no tiene `@Test` encima: descomentaste sin esa línea |
| `cannot find symbol ... assertThat` | Falta o se borró el `import static org.assertj...` del principio del test |
| Descarga muy lenta o `Could not transfer artifact` | Problema de red: repite el comando; Maven retoma lo que ya bajó en `~/.m2/` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Hola, Java](../ejercicio-01-hola-java/README.md) | **Ejercicio 02 · Primer proyecto Maven** | [Ejercicio 03 · Tipos y conversiones](../ejercicio-03-tipos-y-conversiones/README.md) |
