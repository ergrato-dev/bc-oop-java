# Ejercicio 02 — Tests parametrizados y casos límite

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-tests-parametrizados-y-casos-limite.md)

## Objetivo

Convertir tests repetidos en uno parametrizado, elegir los casos con clases de equivalencia y valores límite, y encontrar con ellos un error escondido en `Fine.java`. Es un ejercicio **guiado**: los tests vienen comentados por pasos en `FineTest.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-03-tests_junit_assertj_y_depuracion/2-practicas/ejercicio-02-tests-parametrizados/starter
```

Abre `src/main/java/practica/Fine.java` y lee el Javadoc de `category`: es la **especificación**. Antes de seguir, escribe en un papel qué categoría corresponde a 0, 1, 7, 8, 30 y 31 días.

## Pasos

Para cada paso: descomenta el bloque en `src/test/java/practica/FineTest.java` (con su `@ParameterizedTest` y sus anotaciones de datos) y ejecuta `./mvnw test`.

### 1. Tres tests casi iguales

```bash
./mvnw test
```

Esperado: `Tests run: 3, Failures: 0, Errors: 0`. Mira los tres métodos del PASO 1: solo cambian el número y la palabra esperada.

### 2. Un test, varias filas

Descomenta el **PASO 2**. Esperado: `Tests run: 7`. Un método con cuatro filas cuenta como cuatro tests. Los tres del PASO 1 sobran ahora: ya están en la tabla. Puedes borrarlos, pero los pasos siguientes cuentan con ellos.

### 3. Los valores límite encuentran un error

Descomenta el **PASO 3**. Esperado:

```
[ERROR] practica.FineTest.categoryAtBoundaries(int, String)[2] -- Time elapsed: ... <<< FAILURE!
expected: "leve"
 but was: "grave"
...
[ERROR] Tests run: 12, Failures: 1, Errors: 0, Skipped: 0
```

`[2]` es la segunda fila del `@CsvSource`: `"7, leve"`. Los representantes del PASO 2 (3 y 20) pasaban; el borde, no. Compara la línea 19 de `Fine.java` con la especificación ("de 1 a 7 leve") y corrige el operador. Repite: `Tests run: 12` sin fallos.

Este es el error más frecuente en condiciones: `<` donde iba `<=`. Solo un caso en el borde lo detecta.

### 4. Las entradas no válidas

Descomenta el **PASO 4**. Esperado: `Tests run: 14`. `@ValueSource(ints = {-1, -30})` da dos ejecuciones con un solo parámetro cada una. `-1` es el valor límite de la clase "no válido"; `-30`, un representante.

### 5. Válidos y no válidos

Descomenta el **PASO 5**. Esperado: `Tests run: 21`. Para cada texto de `rejectsInvalidCodes`, di qué regla de `isValidCode` lo rechaza. Ninguno se repite: cada uno prueba una forma distinta de equivocarse.

### 6. `null`, vacío y en blanco

Descomenta el **PASO 6**. Esperado: `Tests run: 24, Failures: 0, Errors: 0`. `@NullAndEmptySource` añade dos ejecuciones (`null` y `""`) a la de `"   "`.

Ahora prueba qué hace la comprobación de `null`: en `Fine.java`, borra `code == null || ` del primer `if` de `isValidCode` y ejecuta. Una ejecución acaba en *error* (no en *failure*):

```
[ERROR]   FineTest.rejectsMissingCodes:105 » NullPointer Cannot invoke "String.length()" because "code" is null
[ERROR] Tests run: 24, Failures: 0, Errors: 1, Skipped: 0
```

Con `null`, `code.length()` lanza `NullPointerException` antes de que el test pueda comparar nada. Restaura la comprobación.

### 7. Tu propio caso

Añade al `@CsvSource` del PASO 3 la fila `"0, sin multa"` y al `@ValueSource` del PASO 5 un código que debería ser rechazado y todavía no está probado, como `"BK-0420"`. ¿Pasan? Si un test nuevo no falla nunca, pregúntate qué error detectaría. Para terminar, `./mvnw -q clean`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol ... ParameterizedTest` o `CsvSource` | Se borró un `import org.junit.jupiter.params...` del principio |
| `Configuration error: You must configure at least one arguments source` | Descomentaste `@ParameterizedTest` pero no la línea `@CsvSource` o `@ValueSource` que va debajo |
| `No ParameterResolver registered for parameter` | El método tiene más parámetros que columnas la fila: revisa las comas |
| `Failed to convert String "siete" to type int` | Un valor no se convierte al tipo del parámetro |
| Un parametrizado aparece como `[1]`, `[2]`... | Es lo normal: el número es la fila, empezando en 1 |
| `Tests run` no cambia | Revisa que las anotaciones de datos quedaron descomentadas |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · JUnit y AssertJ](../ejercicio-01-junit-y-assertj/README.md) | **Ejercicio 02 · Tests parametrizados** | [Ejercicio 03 · Depuración](../ejercicio-03-depuracion/README.md) |
