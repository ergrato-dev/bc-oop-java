# 05 · Depurar: de imprimir al depurador

⏱️ 1 h

## 1. Un método, no suerte

Depurar no es cambiar cosas hasta que funcione. Son cinco pasos:

1. **Reproducir**: un comando o un test que muestre el fallo siempre.
2. **Leer** el error: tipo, mensaje, línea (teoría 04).
3. **Formular una hipótesis**: "el bucle se salta el primer elemento".
4. **Observar** el programa por dentro para confirmarla o descartarla.
5. **Arreglar y proteger**: corregir y dejar un test que falle si el error vuelve.

Los pasos 3 y 4 se repiten hasta que la hipótesis se confirma. Esta teoría trata del paso 4: cómo mirar dentro de un programa que se ejecuta.

## 2. Imprimir

La forma más directa: un `IO.println` temporal que enseñe las variables en el punto sospechoso.

```java
for (int i = 1; i < days.length; i++) {
    IO.println("i=" + i + " days[i]=" + days[i]);   // temporal: bórralo después
    ...
}
```

Funciona en cualquier sitio y no requiere herramientas. Sus límites: hay que editar, ejecutar y volver a editar por cada pregunta nueva, y los `println` olvidados acaban en la entrega. Úsalo para una pregunta rápida; para más, el depurador.

## 3. `assert`: una comprobación que se enciende

```java
int totalCents = lots * 900_000_000;
assert totalCents >= 0 : "total negativo: " + totalCents;
```

`assert condición : mensaje;` no hace nada salvo que ejecutes con `-ea` (*enable assertions*). Entonces, si la condición es falsa, lanza `AssertionError` con el mensaje:

```bash
java -ea Main.java
```

```
Exception in thread "main" java.lang.AssertionError: total negativo: -1594967296
```

Sirve para dejar escritas las cosas que **crees** que siempre se cumplen y enterarte si no. No la uses para validar datos de entrada: en producción va apagada. Para eso, `IllegalArgumentException` (teoría 02).

## 4. El depurador

Un **depurador** ejecuta tu programa y lo para donde le digas. Con el programa parado puedes leer todas las variables y avanzar línea a línea.

| Concepto | Qué hace | VS Code | `jdb` |
|---|---|---|---|
| **Punto de ruptura** (*breakpoint*) | Para el programa al llegar a una línea o método | Clic a la izquierda del número de línea o `F9` | `stop in Main.lateCount` / `stop at Main:20` |
| Arrancar | Ejecuta hasta el primer punto de ruptura | `F5` o *Debug* sobre `main` | `run` |
| **Paso por encima** (*step over*) | Ejecuta la línea actual entera y para en la siguiente | `F10` | `next` |
| **Paso adentro** (*step into*) | Si la línea llama a un método, entra en él | `F11` | `step` |
| **Paso afuera** (*step out*) | Termina el método actual y vuelve a quien lo llamó | `Shift+F11` | `step up` |
| Continuar | Sigue hasta el siguiente punto de ruptura | `F5` | `cont` |
| Ver variables | Valores de los parámetros y las variables locales | Panel *Variables* | `locals`, `print i` |
| Pila de llamadas | Qué métodos están en curso, como un *stack trace* en vivo | Panel *Call Stack* | `where` |

En VS Code, con la extensión de Java de [`docs/setup.md`](../../../docs/setup.md), encima de `main` y de cada test aparecen los enlaces *Run* y *Debug*. *Debug* ejecuta con el depurador y para en tus puntos de ruptura. En IntelliJ es el icono del insecto.

## 5. `jdb`, el depurador del JDK

`jdb` viene con el JDK y funciona en cualquier terminal. Es incómodo comparado con un editor, pero hace lo mismo y te enseña qué ocurre por debajo. Necesita el programa compilado con `-g`, que guarda los nombres de las variables:

```bash
javac -g Main.java          # genera Main.class
jdb Main
```

```
> stop in Main.lateCount
> run
Breakpoint hit: "thread=main", Main.lateCount(), line=20 bci=0
20        int count = 0;

main[1] next
Step completed: "thread=main", Main.lateCount(), line=21 bci=2
21        for (int i = 1; i < days.length; i++) {

main[1] next
Step completed: "thread=main", Main.lateCount(), line=22 bci=12
22            if (days[i] > limit) {

main[1] locals
Method arguments:
days = instance of int[5] (id=631)
limit = 14
Local variables:
count = 0
i = 1
main[1] print days[0]
 days[0] = 20
main[1] cont
```

`i = 1` en la primera vuelta y `days[0] = 20`, que supera el límite: el bucle se salta el primer préstamo. La hipótesis se confirma sin añadir un solo `println`. `quit` sale de `jdb`. Borra después el `Main.class` generado.

## 6. Depurar un test de Maven

Con Maven, el test se ejecuta en otra JVM. Le pides que espere al depurador:

```bash
./mvnw test -Dtest="RulesTest#penalty" -Dmaven.surefire.debug
```

Maven compila, escribe `Listening for transport dt_socket at address: 5005` y se queda esperando. En **otra terminal**:

```bash
jdb -attach 5005
```

```
> stop in gestion.Rules.penalty
> cont
Breakpoint hit: "thread=main", gestion.Rules.penalty(), line=25 bci=0
main[1] locals
Method arguments:
overdueDays = 0
dailyRate = 0.5
maxPenalty = 10.0
```

Cada `cont` lleva a la siguiente llamada a `penalty`, que en un test parametrizado es la siguiente fila. Al terminar, la primera terminal muestra el resultado de los tests. En VS Code es más simple: punto de ruptura en `Rules.java` y *Debug Test* sobre el test.

## 7. Arreglar y proteger

Encontrado el error, el test que lo mostraba pasa a verde con el arreglo. Si el error lo encontraste sin test (con un `println` o en `App`), escribe primero el test que lo reproduce, comprueba que está en rojo y después arregla. Así no vuelve.

## ✅ Comprueba que lo entendiste

1. ¿Qué diferencia hay entre *step over* y *step into* cuando la línea es `return sum(values) / values.length;`?
2. ¿Por qué un `assert` no sirve para rechazar una cantidad negativa que escribe el usuario?
3. ¿Qué tienes que hacer en `jdb` para ver la fila 3 de un test parametrizado que llama a `penalty`?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [04 · Leer errores](04-leer-errores.md) | **05 · El depurador** | [Ejercicio 01 · JUnit y AssertJ](../2-practicas/ejercicio-01-junit-y-assertj/README.md) |
