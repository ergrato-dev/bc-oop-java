# Proyecto — Gestión, capa 2: las reglas

⏱️ 3 h

## Qué construyes

Tu sistema de gestión gana sus **reglas de negocio**: cuántos días se pasa algo de su plazo, cuánto se cobra por ello, si una cantidad escrita por el usuario es válida y si se puede abrir una reserva nueva. Viven en la clase `Rules`, con cuatro métodos estáticos:

| Método | Qué hace | Estado en el starter |
|---|---|---|
| `overdueDays(startDay, endDay, allowedDays)` | Días de retraso sobre el plazo, o 0 | Escrito, **con un error** |
| `penalty(overdueDays, dailyRate, maxPenalty)` | Penalización con tope, redondeada a 2 decimales | Escrito, **con un error** |
| `parseQuantity(text)` | Convierte `" 12 "` en `12`; lanza `IllegalArgumentException` si no es una cantidad | Por escribir |
| `canReserve(active, maxActive, pendingPenalty)` | `true` si quedan plazas y no hay penalización pendiente | Por escribir |

Los nombres son genéricos para que sirvan a cualquier dominio: en un hotel, `overdueDays` son las noches de más sobre la reserva; en un taller, los días que pasa una reparación de su fecha prometida. Tú les das el significado en tus tests.

Esta semana no solo pones tests en verde: **depuras** código que otro escribió mal y escribes tests parametrizados con tus propios valores límite.

## Pasos

### 1. Parte de la semana 02

Tu *pull request* `week-02` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-03
```

### 2. Copia los archivos de la semana

A tu repositorio llevas solo la clase y sus tests:

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-03-tests_junit_assertj_y_depuracion/3-proyecto/starter
cp $STARTER/src/main/java/gestion/Rules.java src/main/java/gestion/
cp $STARTER/src/test/java/gestion/RulesTest.java src/test/java/gestion/
git status --short
```

Debes ver:

```
?? src/main/java/gestion/Rules.java
?? src/test/java/gestion/RulesTest.java
```

Haz un commit ahora, antes de tocar nada: será la prueba de que empezaste en rojo.

```bash
git add src/main/java/gestion/Rules.java src/test/java/gestion/RulesTest.java
git commit -m "test: add rules tests and starter"
```

### 3. Tests en rojo

```bash
./mvnw test -Dtest=RulesTest
```

Esperado:

```
[ERROR] Tests run: 32, Failures: 13, Errors: 8, Skipped: 0
```

No todo está rojo: 11 tests pasan porque `overdueDays` y `penalty` ya están escritos y aciertan en algunos casos. Un error que solo aparece con ciertos datos es el más difícil de ver. Abre `RulesTest.java` y lee los `@CsvSource`: cada fila es un caso de la especificación, con su comentario.

### 4. `overdueDays`: el primer error

```bash
./mvnw test -Dtest="RulesTest#overdueDays*"
```

```
[ERROR]   RulesTest.overdueDays:26 
expected: 0
 but was: -5
[ERROR] Tests run: 7, Failures: 1, Errors: 0, Skipped: 0
```

Es la fila 1: del día 1 al 10 con 14 días de plazo. Calcula a mano lo que hace la línea 16 de `Rules.java` con esos datos. La especificación (el Javadoc) dice "0 si se devolvió o terminó a tiempo". Arréglalo con `Math.max(0, ...)`, que devuelve el mayor de sus dos argumentos, como en `missing` de la semana 02, y repite: `Tests run: 7` sin fallos.

### 5. `penalty`: depúralo

```bash
./mvnw test -Dtest="RulesTest#penalty*"
```

```
Expecting actual:
  2.0
to be close to:
  2.5
...
[ERROR] Tests run: 7, Failures: 2, Errors: 0, Skipped: 0
```

Las filas con resultado entero (`0.0`, `2.0`, `10.0`) pasan; las que tienen decimales (`2.5`, `1.05`) pierden la parte decimal. Antes de mirar el código, obsérvalo por dentro con el depurador (teoría 05). En una terminal:

```bash
./mvnw test -Dtest="RulesTest#penalty" -Dmaven.surefire.debug
```

Cuando diga `Listening for transport dt_socket at address: 5005`, en otra terminal, dentro de la carpeta del proyecto:

```bash
jdb -attach 5005
```

```
stop in gestion.Rules.penalty
cont
cont
cont
next
next
locals
print raw * 100
```

Tres `cont` llevan a la fila 3 (5 días a 0.5). `locals` muestra `raw = 2.5` y `raw * 100` es `250.0`: hasta ahí, bien. El error está en lo que se hace después con ese `250.0` en la línea 29. Compruébalo en JShell:

```
jshell> Math.round(250.0) / 100
$1 ==> 2
```

`Math.round` devuelve un entero (`long`) y `/ 100` divide dos enteros: descarta los decimales (semana 01). Escribe `cont` hasta que `jdb` termine, arregla la línea 29 para que la división sea con decimales y repite: `Tests run: 7` sin fallos.

Si prefieres tu editor: punto de ruptura en la línea 29 de `Rules.java` y *Debug Test* sobre `penalty` en `RulesTest.java`.

### 6. `parseQuantity`

```bash
./mvnw test -Dtest="RulesTest#*Quantit*"
```

Esperado al empezar: `Tests run: 13` con todos en rojo. Sustituye el `throw new UnsupportedOperationException` por la implementación, en este orden:

1. Si `text` es `null` o está en blanco (`isBlank()`), lanza `IllegalArgumentException("Cantidad vacía")`. El `null` va primero: `text.isBlank()` con `text` a `null` es un `NullPointerException`.
2. Quita los espacios de los extremos con `strip()`.
3. Si tiene más de 6 caracteres, o alguno no es un dígito (`Character.isDigit` en un bucle con `charAt`), lanza `IllegalArgumentException("Cantidad no válida: " + text)`. Usa el `text` original en el mensaje, como esperan los tests.
4. Devuelve `Integer.parseInt(...)` del texto ya limpio.

Comprobar los dígitos antes de llamar a `parseInt` evita su `NumberFormatException` y te deja dar tu propio mensaje. Limitar a 6 dígitos evita números que no caben en un `int`. Repite hasta tener los 13 en verde.

### 7. `canReserve`

```bash
./mvnw test -Dtest="RulesTest#canReserve*"
```

Esperado al empezar: `Tests run: 5` en rojo. Si `maxActive` no es positivo, lanza `IllegalArgumentException`. Si no, devuelve `true` solo si quedan plazas (`active < maxActive`) **y** no hay penalización pendiente (`pendingPenalty <= 0`). Es una sola expresión `boolean` con `&&`, sin `if`.

### 8. Todo en verde

```bash
./mvnw test
```

Esperado: `Tests run: 72, Failures: 0, Errors: 0`: los 40 que ya tenías y los 32 de `RulesTest`. Haz un commit por cada error arreglado o método escrito, por ejemplo `fix: clamp overdue days at zero`.

### 9. Las reglas en el programa

Al final de `main` en `App.java`, añade:

```java
        // Semana 03: las reglas. Cambia plazo, tarifa y tope por los de tu dominio.
        int late = Rules.overdueDays(1, 17, 14);
        double fine = Rules.penalty(late, 0.30, 6.0);
        System.out.println("Préstamo del día 1 al 17: " + late + " días de retraso · Multa: "
                + Fields.describe("Importe", fine, "USD"));
        System.out.println("¿Puede llevarse otro libro? " + Rules.canReserve(2, 3, fine));
```

Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
Préstamo del día 1 al 17: 2 días de retraso · Multa: Importe: 0.60 USD
¿Puede llevarse otro libro? false
```

Cambia los textos, el plazo, la tarifa y el tope por los de tu dominio.

### 10. Tus tests: parametrizados y con valores límite

En `MyDomainTest.java`, debajo de los de semanas anteriores, añade tests con **las reglas de tu dominio**: tu plazo, tu tarifa, tu tope. Calcula cada resultado esperado a mano antes de ejecutar. Necesitas al menos **6 ejecuciones nuevas**, con:

| Caso | Ejemplo (Biblioteca: 14 días, 0.30 USD por día, tope 6 USD) |
|---|---|
| Un `@ParameterizedTest` de `overdueDays` con al menos 4 filas, incluidos el último día del plazo y el primero de retraso | `"1, 15, 0"` y `"1, 16, 1"` con plazo 14 |
| Una penalización con decimales | `Rules.penalty(3, 0.30, 6.0)` es `0.9` (con `isCloseTo`) |
| Una penalización que llega al tope | `Rules.penalty(60, 0.30, 6.0)` es `6.0` |
| Una entrada rechazada con `assertThatThrownBy` | `Rules.parseQuantity("1,5")` lanza `IllegalArgumentException` con el mensaje `"Cantidad no válida: 1,5"` |

Añade los `import` que te falten: copia los del principio de `RulesTest.java`.

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 78 tests.

### 11. Commit y pull request

```bash
git add .
git commit -m "test: add domain rules tests"
git push -u origin week-03
```

En GitHub, abre un *pull request* de `week-03` hacia `main`. En la descripción pega:

1. Tu plazo, tu tarifa y tu tope, y qué significan en tu dominio.
2. Los dos errores del starter: qué test los mostró, qué técnica usaste para encontrarlos (lectura, `println`, depurador) y cuál era la causa.
3. Las dos últimas líneas de `./mvnw test` y la salida de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `overdueDays` sigue dando negativos | `Math.max(0, ...)`: el 0 es el mínimo, no el máximo |
| `penalty` sigue dando `2.0` | Divides entre `100` (entero): divide entre `100.0` |
| `rejectsMalformedQuantities` falla con `Expecting code to raise a throwable` | Aceptas algo que no son dígitos: revisa el bucle; `"+3"` y `"-3"` también se rechazan |
| `rejectsMissingQuantities(String)[1]` acaba en *error* con `NullPointerException` | Llamas a `strip()` o `isBlank()` antes de comprobar `null` |
| `jdb -attach 5005` da `Connection refused` | El test no espera todavía: lanza antes `./mvnw test ... -Dmaven.surefire.debug` y espera a `Listening for transport` |
| Maven se queda parado sin terminar | Está esperando al depurador: conéctate con `jdb -attach 5005` o pulsa `Ctrl+C` |
| `cannot find symbol ... ParameterizedTest` en `MyDomainTest` | Faltan los `import` de `org.junit.jupiter.params` |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-03` con `Rules.java` completo y corregido, y `./mvnw test` en verde.
- Al menos 6 ejecuciones nuevas en `MyDomainTest.java`, con un parametrizado y una excepción comprobada.
- `App.java` con las reglas de tu dominio.
- *Pull request* `week-03` → `main` con la descripción del paso 11.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · Depuración](../2-practicas/ejercicio-03-depuracion/README.md) | **Proyecto · Gestión, capa 2** | [Webgrafía](../4-recursos/webgrafia/README.md) |
