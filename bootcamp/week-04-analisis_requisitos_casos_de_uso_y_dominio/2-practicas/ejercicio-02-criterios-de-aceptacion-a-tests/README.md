# Ejercicio 02 — De criterios de aceptación a tests

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-historias-y-criterios-de-aceptacion.md)

## Objetivo

Convertir los criterios de aceptación de una historia de usuario en tests, uno por uno, y comprobar que un criterio con su test detecta una regla que el programador olvidó. Es un ejercicio **guiado**: los tests vienen comentados por pasos en `RenewalTest.java`. No se entrega.

## La historia

```
Como   socio
quiero renovar un préstamo
para   quedarme el libro 7 días más sin tener que devolverlo y volver a pedirlo.

CA-01  Dado un préstamo sin renovar, sin reservas y a tiempo,
       cuando el socio lo renueva, entonces puede.
CA-02  Dado un préstamo ya renovado 2 veces,
       cuando el socio lo renueva, entonces no puede.
CA-03  Dado que otro socio ha reservado el libro,
       cuando el socio lo renueva, entonces no puede.
CA-04  Dado un préstamo con días de retraso,
       cuando el socio lo renueva, entonces no puede.
CA-05  Dado un préstamo que vence el día 15,
       cuando el socio lo renueva, entonces vence el día 22.
```

Las reglas están en `src/main/java/practica/Renewal.java`: `canRenew(renewals, reservations, overdueDays)` y `newDueDay(dueDay)`. El programador las escribió leyendo la historia, sin tests.

## Antes de empezar

```bash
cd bootcamp/week-04-analisis_requisitos_casos_de_uso_y_dominio/2-practicas/ejercicio-02-criterios-de-aceptacion-a-tests/starter
./mvnw test
```

Termina en:

```
[INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

Cero tests y `BUILD SUCCESS`: sin tests, Maven no tiene nada que decirte, ni bueno ni malo. Abre `RenewalTest.java`: cada paso es un criterio.

## Pasos

### 1. CA-01: el flujo principal

Descomenta el **PASO 1** y ejecuta `./mvnw test`. Esperado: `Tests run: 1, Failures: 0`.

Compara el test con el criterio: el "Dado" son los tres ceros (sin renovar, sin reservas, sin retraso); el "Cuando", la llamada a `canRenew`; el "Entonces", `isTrue()`. `@DisplayName` repite el criterio con su identificador: es el nombre que verás en el panel *Testing* de tu editor. Maven sigue mostrando el nombre del método, por eso también debe decir algo.

### 2. CA-02: el límite de renovaciones

Descomenta el **PASO 2** y ejecuta. Esperado: `Tests run: 2, Failures: 0`.

### 3. CA-03: el criterio olvidado

Descomenta el **PASO 3** y ejecuta:

```
[ERROR]   RenewalTest.reservedBookCannotBeRenewed:43 
Expecting value to be false but was true
[ERROR] Tests run: 3, Failures: 1, Errors: 0, Skipped: 0
```

Un libro reservado por otro socio se renueva. Lee la línea 16 de `Renewal.java`: el Javadoc habla de reservas, pero el código no mira `reservations`. El programador leyó la historia, escribió el método y nadie lo comprobó contra CA-03.

Cámbiala por:

```java
        return renewals < 2 && reservations == 0 && overdueDays == 0;
```

Ejecuta: `Tests run: 3, Failures: 0`. Esto es lo que aporta escribir un test por criterio: si un criterio no tiene test, nadie sabe si se cumple.

### 4. CA-04: el retraso

Descomenta el **PASO 4** y ejecuta. Esperado: `Tests run: 4, Failures: 0`.

### 5. CA-05: la nueva fecha

Descomenta el **PASO 5** y ejecuta. Esperado: `Tests run: 5, Failures: 0`.

### 6. Todos los criterios en una tabla

Los criterios CA-01 a CA-04 prueban el mismo método con datos distintos: son filas de un `@ParameterizedTest`. La primera columna es el nombre del criterio. Dos detalles:

- `@ParameterizedTest(name = "{0}")` usa ese primer valor como nombre de cada fila en tu editor.
- `.as(criterion)` lo pone delante del mensaje de fallo, que sí lo muestra Maven.

La fila `CA-02 última renovación` es un valor límite: con 1 renovación todavía se puede.

Descomenta el **PASO 6** y ejecuta. Esperado: `Tests run: 11, Failures: 0`: los 5 de antes y 6 filas.

Ahora rompe una fila a propósito para ver el mensaje: en la línea 77 cambia el `true` final por `false` y ejecuta:

```
[ERROR]   RenewalTest.canRenew:86 [CA-02 última renovación] 
expected: false
 but was: true
```

El criterio aparece entre corchetes: sin abrir el test sabes qué promesa se ha roto. Deja la fila como estaba (`true`) y comprueba de nuevo `Tests run: 11, Failures: 0`.

### 7. Tu turno, en papel

Escribe dos criterios Dado-Cuando-Entonces más para esta historia (por ejemplo, ¿se puede renovar el día exacto en que vence? ¿y un préstamo con 0 días de retraso y 1 reserva propia?). Para cada uno, escribe la fila de `@CsvSource` que lo probaría. Si alguno no se puede probar con `canRenew` tal como está, anota qué dato le falta: es un requisito que la historia no recogía.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol ... DisplayName` | Falta `import org.junit.jupiter.api.DisplayName;` arriba: no borres los `import` |
| En el paso 3 sale `Tests run: 3, Failures: 0` sin haber cambiado nada | Ya habías tocado la línea 16: compárala con la del paso 3 |
| `Tests run: 6` en el paso 6 | Descomentaste la tabla, pero no los pasos 1 a 5 |
| `Failed to convert String "0 1" to type int` | Al descomentar, una fila del `@CsvSource` perdió una coma: cada fila lleva 5 valores |
| El editor no muestra los nombres de `@DisplayName` | Usa el panel *Testing* (el matraz de la barra lateral), no la terminal |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Casos de uso](../ejercicio-01-casos-de-uso/README.md) | **Ejercicio 02 · Criterios de aceptación a tests** | [Ejercicio 03 · Sustantivos, verbos y CRC](../ejercicio-03-sustantivos-verbos-y-crc/README.md) |
