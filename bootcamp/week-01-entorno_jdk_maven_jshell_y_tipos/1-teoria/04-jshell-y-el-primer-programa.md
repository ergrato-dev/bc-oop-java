# 04 · JShell y el primer programa

⏱️ 40 min

## 1. JShell: probar sin crear archivos

`jshell` viene con el JDK. Es un **REPL** (*read-eval-print loop*): escribes una expresión, la evalúa y te muestra el resultado. Es la forma más rápida de comprobar qué hace una línea antes de escribirla en tu proyecto.

```
$ jshell
jshell> 7 / 2
$1 ==> 3

jshell> "Ana".length()
$2 ==> 3

jshell> int copies = 3
copies ==> 3

jshell> copies * 2
$4 ==> 6

jshell> Integer.parseInt("doce")
|  Exception java.lang.NumberFormatException: For input string: "doce"
|        at Integer.parseInt (Integer.java:565)
|        at (#5:1)

jshell> /exit
```

- `$1`, `$2`... son variables que JShell crea para cada resultado; puedes usarlas después (`$1 + 1`).
- No hace falta `;` al final de una línea suelta.
- Comandos útiles: `/vars` (variables definidas), `/list` (lo que escribiste), `/exit` (salir). `Tab` autocompleta: escribe `"Ana".` y pulsa `Tab` para ver los métodos de `String`.

Pruébalo ahora con las expresiones de la [teoría 05](05-variables-y-tipos.md).

## 2. El programa más corto: Java 25

Desde Java 25, esto es un programa completo en `Main.java`:

```java
void main() {
    IO.println("Hola, Java");
}
```

```bash
java Main.java
```

- `void main()` es el **punto de entrada**: la JVM empieza a ejecutar aquí. `void` significa que no devuelve nada.
- `IO.println(...)` escribe una línea en la consola. `IO.print` lo hace sin salto de línea.
- Las llaves `{ }` delimitan un bloque; cada **sentencia** termina en `;`.
- Puedes declarar otros métodos en el mismo archivo, fuera de `main`, y llamarlos desde ella (ejercicio 01, paso 3).

A esto se le llama **archivo de código compacto** (*compact source file*). Es para programas pequeños y para aprender: sin clase visible.

## 3. El programa clásico

Tu proyecto Maven usa la forma que verás en todo el código Java real, porque cada archivo pertenece a un **paquete** y tiene una **clase** con nombre:

```java
package gestion;

public class App {

    public static void main(String[] args) {
        System.out.println("Hola, Java");
    }
}
```

| Pieza | Qué significa (por ahora) |
|---|---|
| `package gestion;` | El archivo vive en la carpeta `gestion/`, y la clase se llama en total `gestion.App` |
| `public class App` | Una clase llamada `App`; el archivo **debe** llamarse `App.java` |
| `public static void main(String[] args)` | El punto de entrada clásico. `args` son los argumentos de la línea de comandos |
| `System.out.println` | La forma clásica de `IO.println` |

`public` y `static` los entenderás a fondo en las semanas 05 y 06. De momento, una regla: **un método `static` se llama con el nombre de la clase delante**: `Fields.parseAmount("12,5")`. Así son los métodos de tu proyecto de esta semana.

## 4. Convenciones de nombres

El compilador acepta casi cualquier nombre, pero el código Java del mundo entero sigue estas convenciones, y el curso también:

| Qué | Estilo | Ejemplo |
|---|---|---|
| Clases | `PascalCase` | `Fields`, `BookCatalog` |
| Métodos y variables | `camelCase` | `parseAmount`, `pricePerNight` |
| Constantes | `UPPER_SNAKE_CASE` | `MAX_COPIES` |
| Paquetes | minúsculas, sin guiones | `gestion` |

Identificadores en **inglés**, como en el resto de la industria. Los textos que ve el usuario (`"Precio"`) pueden ir en español.

## ✅ Comprueba que lo entendiste

1. En JShell escribes `10 / 4` y te responde `$1 ==> 2`. ¿Por qué no `2.5`? ¿Qué escribirías para obtenerlo?
2. ¿Por qué el archivo de `public class App` tiene que llamarse `App.java`?
3. ¿Cómo llamas, desde `App`, al método `static` `describe` de la clase `Fields`?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [03 · Maven y el wrapper](03-maven-y-el-wrapper.md) | **04 · JShell y el primer programa** | [05 · Variables y tipos](05-variables-y-tipos.md) |
