# Ejercicio 03 — Depuración

⏱️ 2 h · Teoría previa: [04](../../1-teoria/04-leer-errores.md) y [05](../../1-teoria/05-el-depurador.md)

## Objetivo

Encontrar y arreglar cuatro errores con cuatro técnicas distintas: leer un *stack trace*, leer el mensaje de un `NullPointerException`, imprimir variables y usar `assert` y el depurador `jdb`. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-03-tests_junit_assertj_y_depuracion/2-practicas/ejercicio-03-depuracion/starter
java Main.java
```

No imprime nada: todos los pasos están comentados. Arriba de `main` hay tres métodos ya escritos, `average`, `sum` y `lateCount`. Léelos antes de empezar.

Los números de línea de este README cuentan con que arreglas cada error **sin añadir ni quitar líneas**, tal como se indica.

## Pasos

### 1. Leer un *stack trace*

Descomenta el **PASO 1** y ejecuta `java Main.java`. Salida esperada:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Main.average(Main.java:7)
	at Main.main(Main.java:36)
```

Responde antes de arreglar: ¿qué tipo de excepción es? ¿En qué método y línea saltó? ¿Desde qué línea se llamó a ese método? En la 36, `main` pasa un array vacío; en la 7, `average` divide entre `values.length`, que vale 0.

Arréglalo en `average` para que la media de un array vacío sea 0. Cambia la línea 7 por:

```java
    return values.length == 0 ? 0 : sum(values) / values.length;
```

Ejecuta: `Media: 0`.

### 2. El mensaje de `NullPointerException`

Descomenta el **PASO 2** y ejecuta. Salida esperada:

```
Media: 0
RAYUELA
FICCIONES
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "<local6>" is null
	at Main.main(Main.java:47)
```

El array tiene 3 posiciones y solo se rellenan 2: la tercera es `null`. `<local6>` es la variable `title`: `java Main.java` no guarda los nombres de las variables (teoría 04). Cambia la línea 47 por:

```java
        IO.println(title == null ? "(sin título)" : title.toUpperCase());
```

Ejecuta: la última línea es `(sin título)`.

### 3. Imprimir para ver qué pasa

Descomenta el **PASO 3** y ejecuta. La última línea es `Retrasados: 2`, pero en `{20, 3, 15, 30, 7}` hay **tres** valores mayores que 14: 20, 15 y 30. No hay excepción: el programa da un resultado incorrecto sin avisar.

Hipótesis: el bucle de `lateCount` no recorre lo que crees. Para comprobarlo, añade justo debajo del `for` de la línea 21 una línea temporal:

```java
        IO.println("i=" + i + " days[i]=" + days[i]);
```

Ejecuta:

```
i=1 days[i]=3
i=2 days[i]=15
i=3 days[i]=30
i=4 days[i]=7
Retrasados: 2
```

¿Qué posición falta? Anota tu respuesta, **borra la línea temporal** y no arregles todavía: en el paso 5 lo confirmarás con el depurador.

### 4. `assert` con `-ea`

Descomenta el **PASO 4** y ejecuta dos veces:

```bash
java Main.java
java -ea Main.java
```

Sin `-ea`, la última línea es `Total en céntimos: -1594967296`: el `assert` está apagado y el número negativo pasa sin avisar. Con `-ea`:

```
Exception in thread "main" java.lang.AssertionError: total negativo: -1594967296
	at Main.main(Main.java:65)
```

3 × 900 000 000 = 2 700 000 000 no cabe en un `int` (máximo 2 147 483 647): se desborda (semana 01). Cambia la línea 64 por:

```java
    long totalCents = lots * 900_000_000L;
```

La `L` hace que la multiplicación se haga en `long`. `java -ea Main.java` termina en `Total en céntimos: 2700000000`.

### 5. El depurador `jdb`

Compila con información de depuración y abre `jdb`:

```bash
javac -g Main.java
jdb Main
```

Escribe estos comandos uno a uno, pulsando Enter después de cada uno:

```
stop in Main.lateCount
run
next
next
locals
print days[0]
```

Lo que debes ver (resumido; `id=` cambia en cada ejecución):

```
Breakpoint hit: "thread=main", Main.lateCount(), line=20 bci=0
20        int count = 0;
...
22            if (days[i] > limit) {
...
Local variables:
count = 0
i = 1
main[1]  days[0] = 20
```

El programa está parado en la primera vuelta del bucle y `i` ya vale 1: `days[0]`, que es 20 y supera el límite, nunca se compara. Es lo que viste en el paso 3, ahora sin editar el código. Escribe `cont` para que termine y `quit` si `jdb` no sale solo.

Arregla la línea 21 (`int i = 0`), borra el `.class` generado y ejecuta:

```bash
rm Main.class
java -ea Main.java
```

Salida final esperada:

```
Media: 0
RAYUELA
FICCIONES
(sin título)
Retrasados: 3
Total en céntimos: 2700000000
```

### 6. Con tu editor

Repite el paso 5 en VS Code sin `jdb`: vuelve a poner `int i = 1`, haz clic a la izquierda de la línea 20 para crear un punto de ruptura y pulsa *Debug* encima de `void main()`. Avanza con `F10` y mira el panel *Variables*. Deja `int i = 0` al terminar.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| Las líneas de los errores no coinciden | Añadiste o quitaste líneas al arreglar: deja el archivo con la misma longitud, o busca por el contenido de la línea |
| `jdb: command not found` | Tu `PATH` no tiene el `bin` del JDK; `sdk current java` debe mostrar 25 |
| `jdb` dice `Deferring breakpoint` | Es normal: el punto de ruptura se activa al cargar la clase, después de `run` |
| `Unable to set deferred breakpoint Main.latecount : No method latecount in Main` | El nombre debe ser exacto: `Main.lateCount`, con mayúscula |
| `Local variable information not available. Compile with -g` | Compilaste sin `-g`: sal con `quit` y repite `javac -g Main.java` |
| `java -ea Main.java` no lanza el `AssertionError` | `-ea` va **antes** del nombre del archivo |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Tests parametrizados](../ejercicio-02-tests-parametrizados/README.md) | **Ejercicio 03 · Depuración** | [Proyecto](../../3-proyecto/README.md) |
