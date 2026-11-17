# Ejercicio 01 — Hola, Java

⏱️ 1 h 30 min · Teoría previa: [02](../../1-teoria/02-del-codigo-a-la-jvm.md) y [04](../../1-teoria/04-jshell-y-el-primer-programa.md)

## Objetivo

Comprobar que tienes Java 25, ejecutar tu primer programa, compilarlo a bytecode y provocar a propósito los dos tipos de error: el que detecta el compilador y el que solo aparece al ejecutar. Es un ejercicio **guiado**: el código ya está escrito en `Main.java`, comentado por pasos; tú lo descomentas, lo ejecutas y compruebas la salida. No se entrega.

## Antes de empezar

Abre una terminal (en Windows, la de Ubuntu en WSL2) y entra en el starter. Todos los comandos de este ejercicio se escriben **dentro de `starter/`**:

```bash
cd bootcamp/week-01-entorno_jdk_maven_jshell_y_tipos/2-practicas/ejercicio-01-hola-java/starter
ls
```

Debes ver: `Main.java`.

**Cómo se descomenta**: en VS Code (`code .`), selecciona las líneas del paso y pulsa `Ctrl+K Ctrl+U` (en macOS `Cmd+K Cmd+U`). Quita solo el `// ` del principio de cada línea; la sangría que queda (4 espacios dentro de `main`) es la del código.

## Pasos

### 1. Comprueba la toolchain

```bash
java -version
javac -version
```

Salida esperada (la primera línea de cada uno):

```
openjdk version "25.0.5" 2026-10-20 LTS
javac 25.0.5
```

Si ves otra versión, vuelve a [`docs/setup.md`](../../../../docs/setup.md).

### 2. Ejecuta el programa tal como viene

```bash
java Main.java
```

Salida esperada:

```
Ejercicio 01 · Hola, Java
```

`java Main.java` compila el archivo **en memoria** y lo ejecuta en un solo paso. Abre `Main.java`: `void main()` es el punto de entrada e `IO.println` escribe una línea. No hay `class` ni `public static`: desde Java 25, un archivo así es un programa completo (teoría 04).

### 3. Un método propio

Descomenta el **PASO 3** en sus dos partes: las dos líneas dentro de `main` y el método `greet` al final del archivo.

```bash
java Main.java
```

Salida esperada:

```
Ejercicio 01 · Hola, Java
Hola, Ana
Hola, mundo
```

`greet` recibe un `String` y devuelve otro. Con `"   "`, `strip()` deja el texto vacío e `isEmpty()` da `true`.

### 4. Qué Java te ejecuta

Descomenta el **PASO 4** y ejecuta:

```bash
java Main.java
```

Salida esperada (en macOS dirá `Mac OS X`):

```
Ejercicio 01 · Hola, Java
Hola, Ana
Hola, mundo
Java 25
Sistema: Linux
```

### 5. Compilar y ejecutar por separado

Lo que `java Main.java` hizo en un paso, ahora en dos:

```bash
javac Main.java
ls
java Main
```

Después de `javac` verás `Main.class` junto a `Main.java`: es el **bytecode**, lo que la JVM ejecuta. Fíjate en que `java Main` va **sin** `.java`: le pasas el nombre de la clase, no el archivo. La salida es la misma del paso 4. Borra el `.class` al terminar:

```bash
rm Main.class
```

### 6. Error de compilación

Borra el `;` del final de `IO.println("Ejercicio 01 · Hola, Java");` (línea 7) y ejecuta:

```bash
java Main.java
```

Salida esperada:

```
Main.java:7: error: ';' expected
    IO.println("Ejercicio 01 · Hola, Java")
                                           ^
1 error
error: compilation failed
```

**No se ejecutó nada**: ni la primera línea. El compilador revisa todo el archivo antes de ejecutar. Vuelve a poner el `;`.

### 7. Error en ejecución

Descomenta el **PASO 6** y ejecuta:

```bash
java Main.java
```

Salida esperada (las líneas pueden salir mezcladas, porque la salida normal y la de errores van por canales distintos):

```
Ejercicio 01 · Hola, Java
Hola, Ana
Hola, mundo
Java 25
Sistema: Linux
Exception in thread "main" java.lang.NumberFormatException: For input string: "doce"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:565)
	at java.base/java.lang.Integer.parseInt(Integer.java:662)
	at Main.main(Main.java:31)
```

Esta vez **sí se ejecutó** todo lo anterior: el programa compiló bien y falló al llegar a la línea 31. Así se lee un *stack trace*: la primera línea dice **qué** pasó; la última línea con **tu** archivo (`Main.java:31`) dice **dónde**. Las de `java.base` son código de Java, no el tuyo.

Cambia `"doce"` por `"12"` y comprueba que la última línea es `Copias: 12`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: class, interface, enum, or record expected` | Descomentaste a medias el método `greet`: revisa que no quede ningún `//` en sus líneas |
| `error: cannot find symbol ... greet` | Descomentaste las líneas de `main` del PASO 3 pero no el método del final |
| `error: unnamed classes are a preview feature and are disabled by default.` | Ejecutas con Java 21 o anterior: `java -version` debe decir 25 |
| Caracteres raros en `·` o tildes | Tu terminal no está en UTF-8: en WSL2, `export LANG=C.UTF-8` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Teoría 05 · Variables y tipos](../../1-teoria/05-variables-y-tipos.md) | **Ejercicio 01 · Hola, Java** | [Ejercicio 02 · Primer proyecto Maven](../ejercicio-02-primer-proyecto-maven/README.md) |
