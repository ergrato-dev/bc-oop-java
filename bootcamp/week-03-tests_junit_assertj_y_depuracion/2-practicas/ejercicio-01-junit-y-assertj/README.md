# Ejercicio 01 — JUnit y AssertJ

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-que-es-un-test.md) y [02](../../1-teoria/02-assertj.md)

## Objetivo

Escribir y ejecutar tus primeros tests con JUnit y AssertJ: comparar valores, textos, arrays y decimales, comprobar que un método lanza una excepción y leer el mensaje cuando algo falla. El código que pruebas, `Shelf.java`, ya funciona: aquí solo se tocan los tests. Es un ejercicio **guiado**: los tests vienen comentados por pasos en `ShelfTest.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-03-tests_junit_assertj_y_depuracion/2-practicas/ejercicio-01-junit-y-assertj/starter
find . -name "*.java"
```

Salida esperada:

```
./src/main/java/practica/Shelf.java
./src/test/java/practica/ShelfTest.java
```

Abre los dos archivos. `Shelf` tiene cuatro métodos: `normalize`, `codes`, `free` y `occupancy`; lee su Javadoc para saber qué deben devolver.

## Pasos

Para cada paso: descomenta el bloque en `ShelfTest.java` (incluida la línea `@Test`, sin tocar los comentarios de explicación) y ejecuta `./mvnw test`.

### 1. Un test que ya funciona

```bash
./mvnw test
```

Salida esperada, al final:

```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

Identifica en `normalizesSpacesAndCase` las tres partes: datos (`" bk-042 "`), llamada (`Shelf.normalize`) y comprobación (`isEqualTo("BK-042")`).

### 2. La misma comprobación con `assertEquals`

Descomenta el **PASO 2**. Esperado: `Tests run: 2`. Fíjate en el orden de `assertEquals`: primero el esperado y después el real. Es fácil confundirlos, y por eso en el bootcamp usamos `assertThat`.

### 3. Un test que falla

Descomenta el **PASO 3** y ejecuta. Esperado:

```
[ERROR] Failures: 
[ERROR]   ShelfTest.freeRoom:39 
expected: 3
 but was: 7
[ERROR] Tests run: 3, Failures: 1, Errors: 0, Skipped: 0
```

Calcula a mano `free(10, 3)`: 10 huecos menos 3 ocupados. ¿Quién se equivoca, el código o el test? Corrige el valor esperado en la línea 39 y repite: `Tests run: 3` sin fallos.

### 4. Textos y arrays

Descomenta el **PASO 4** (son dos tests). Esperado: `Tests run: 5`. Cambia `"BK-311"` por `"BK-999"` en `splitsAndNormalizesCodes`, ejecuta y lee cómo `containsExactly` te dice qué elemento sobra y cuál falta. Deshaz el cambio.

### 5. Decimales con margen

Descomenta el **PASO 5**. Esperado: `Tests run: 6`. Cambia `.isCloseTo(33.33, within(0.01))` por `.isEqualTo(33.33)` y ejecuta:

```
expected: 33.33
 but was: 33.333333333333336
```

Un `double` calculado casi nunca coincide al último decimal. Vuelve a `isCloseTo`.

### 6. Comprobar que lanza una excepción

Descomenta el **PASO 6**. Esperado: `Tests run: 7`. Ahora haz dos pruebas:

1. Cambia `Shelf.free(10, 12)` por `Shelf.free(10, 2)`. El método ya no lanza nada y el test falla con `Expecting code to raise a throwable.`
2. Deja `Shelf.free(10, 12)` y quita la lambda: `assertThatThrownBy(Shelf.free(10, 12))`. No compila: `no suitable method found for assertThatThrownBy(int)`. Sin lambda, Java ejecuta `free` primero y le pasa el `int` que devuelve, cuando `assertThatThrownBy` necesita código que ejecutar.

Deshaz los cambios.

### 7. Preparar, actuar, comprobar

Descomenta el **PASO 7**. Esperado: `Tests run: 8, Failures: 0, Errors: 0`. Si abres el proyecto en VS Code, el panel *Testing* muestra el nombre de `@DisplayName`, "un estante lleno no tiene huecos", en lugar del nombre del método.

### 8. Ejecuta solo una parte

```bash
./mvnw test -Dtest="ShelfTest#free*"
```

Esperado: `Tests run: 2`, solo `freeRoom` y `freeRejectsOverflow`. Para terminar, `./mvnw -q clean`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `Tests run` no sube al descomentar | Descomentaste el método pero no la línea `@Test` |
| `cannot find symbol ... assertThat` o `within` | Se borró un `import static` del principio del archivo |
| `class, interface, enum, or record expected` | Descomentaste de más o de menos: cada `@Test` debe quedar dentro de las llaves de `class ShelfTest` |
| `reached end of file while parsing` | Falta la `}` que cierra el método o la clase |
| `Tests run: 0` con `-Dtest` | El patrón no coincide con ningún método: respeta mayúsculas y ponlo entre comillas |
| `./mvnw: Permission denied` | `chmod +x mvnw` |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · El depurador](../../1-teoria/05-el-depurador.md) | **Ejercicio 01 · JUnit y AssertJ** | [Ejercicio 02 · Tests parametrizados](../ejercicio-02-tests-parametrizados/README.md) |
