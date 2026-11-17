# Proyecto — Gestión, capa 0: los campos

⏱️ 3 h

## Qué construyes

El primer archivo del proyecto que te acompaña las 24 semanas ([proyecto hilo conductor](../../../docs/proyecto-hilo-conductor.md)): una clase `Fields` con las reglas para **leer, validar y mostrar los campos** de la entidad principal de tu dominio. Todavía no hay objetos: son métodos `static`. En la semana 05 estas reglas pasan a vivir dentro de tu clase (`Room`, `Medicine`, `Book`...), y si hoy una coma decimal se lee mal, ese error viaja contigo.

| Método | Recibe | Devuelve |
|---|---|---|
| `parseAmount("  12,5 ")` | El texto de una cantidad | `12.5` (acepta coma o punto, ignora espacios) |
| `normalizeCode(" bk-042 ")` | Un código | `"BK-042"` (sin espacios, en mayúsculas) |
| `describe("Precio", 12.5, "USD")` | Etiqueta, valor y unidad | `"Precio: 12.50 USD"` (dos decimales, siempre con punto) |
| `isInRange(500.0, 0.0, 500.0)` | Valor, mínimo y máximo | `true` si está en el rango, límites incluidos |
| `fits(10, 10)` | Cantidad y capacidad | `true` si no es negativa y cabe |

## Pasos

### 1. Tu dominio

Tu instructor te asigna un dominio. Anota: tu entidad principal, su código, un campo decimal con unidad y su rango válido, y un campo entero con su capacidad.

| Ejemplo (Biblioteca) | Tu dominio |
|---|---|
| Entidad: `Book` | … |
| Código: `BK-042` | … |
| Precio en USD, de 0 a 500 | … |
| Copias, capacidad 10 por estante | … |

### 2. Crea tu repositorio

En GitHub, crea un repositorio **vacío** (sin README ni `.gitignore`) llamado `oop-java-<nombre>-<apellido>`, por ejemplo `oop-java-ana-perez`. Después, fuera de la carpeta del bootcamp:

```bash
mkdir -p ~/proyectos && cd ~/proyectos
cp -r <ruta-al-bootcamp>/bootcamp/week-01-entorno_jdk_maven_jshell_y_tipos/3-proyecto/starter oop-java-<nombre>-<apellido>
cd oop-java-<nombre>-<apellido>
ls -A
```

Debes ver: `.gitignore  .mvn  README.md  mvnw  mvnw.cmd  pom.xml  src`.

### 3. Git y la rama de la semana

```bash
git init -b main
git add .
git commit -m "chore: start gestion from week-01 starter"
git remote add origin git@github.com:<tu-usuario>/oop-java-<nombre>-<apellido>.git
git push -u origin main
git switch -c week-01
```

Desde ahora trabajas en la rama `week-01`. Cada semana tendrá su rama y su *pull request*.

### 4. Tests en rojo

```bash
./mvnw test
```

Salida esperada al final:

```
[ERROR] Tests run: 13, Failures: 0, Errors: 13, Skipped: 0
[ERROR] BUILD FAILURE
```

Fallan los 12 tests de `src/test/java/gestion/FieldsTest.java` y el de ejemplo de `MyDomainTest.java`, todos con `UnsupportedOperationException: TODO`. Ese es el punto de partida, **en rojo**; tu trabajo es dejarlos **en verde**. Abre `FieldsTest.java` y lee el primero:

```java
@Test
void parseAmountWithDot() {
    assertThat(Fields.parseAmount("12.5")).isEqualTo(12.5);
}
```

`@Test` marca el método como test; `assertThat(valor).isEqualTo(esperado)` hace fallar el test si no coinciden (ejercicio 02).

### 5. `parseAmount`

En `src/main/java/gestion/Fields.java`, sustituye cada `throw new UnsupportedOperationException(...)` por la implementación. Para `parseAmount`, una sola línea con tres llamadas encadenadas: `strip()`, `replace(',', '.')` y `Double.parseDouble(...)` (ejercicio 03, paso 4).

```bash
./mvnw test -Dtest=FieldsTest#parseAmount*
```

Esperado: `Tests run: 5, Failures: 0, Errors: 0`.

### 6. `normalizeCode` y `describe`

`normalizeCode`: `strip()` y `toUpperCase(Locale.ROOT)`. `describe`: concatena la etiqueta, `": "`, el valor con `String.format(Locale.ROOT, "%.2f", amount)`, un espacio y la unidad (ejercicio 03, paso 6).

```bash
./mvnw test -Dtest="FieldsTest#normalizeCode*+describe*"
```

Esperado: `Tests run: 3, Failures: 0, Errors: 0`. Fíjate en `describeRoundsHalfUp`: `1.005` se muestra `1.01`.

### 7. `isInRange` y `fits`

Cada una es un solo `return` con dos comparaciones unidas por `&&`: el valor es mayor o igual que el mínimo **y** menor o igual que el máximo.

```bash
./mvnw test -Dtest=FieldsTest
```

Esperado: `Tests run: 12, Failures: 0, Errors: 0`.

### 8. Tu dominio en el programa

En `src/main/java/gestion/App.java`, cambia los tres registros de la Biblioteca por tres de tu dominio: códigos, etiqueta, valores (uno con coma decimal) y unidad. Ejecuta:

```bash
./mvnw -q compile exec:java
```

Ejemplo de salida para la Biblioteca:

```
BK-042 · Precio: 12.50 USD
BK-107 · Precio: 8.99 USD
BK-311 · Precio: 30.00 USD
¿Precio válido? true
```

### 9. Tus tests, calculados a mano

En `MyDomainTest.java`, sustituye el test de ejemplo por **al menos 5 tests tuyos** con códigos, valores, unidades y rangos de tu dominio. Calcula el resultado esperado **antes** de ejecutarlos. Cubre al menos:

| Caso | Ejemplo (Biblioteca) |
|---|---|
| Un valor con coma decimal | `Fields.parseAmount("35,2")` es `35.2` |
| Un código mal escrito | `Fields.normalizeCode(" bk-7 ")` es `"BK-7"` |
| El redondeo a dos decimales | `Fields.describe("Precio", 9.999, "USD")` es `"Precio: 10.00 USD"` |
| Un valor fuera de rango | `Fields.isInRange(612.0, 0.0, 500.0)` es `false` |
| Un límite exacto | `Fields.fits(10, 10)` es `true` |

Cada test es un método con `@Test` y un `assertThat`, como los de `FieldsTest.java`.

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos `Tests run: 17, Failures: 0, Errors: 0`.

### 10. README, commit y pull request

Completa la tabla de `README.md`. Después:

```bash
git add .
git commit -m "feat: parse, normalize, describe and validate fields"
git push -u origin week-01
```

En GitHub, abre un *pull request* de `week-01` hacia `main`. En la descripción pega:

1. Tu dominio, entidad, campos y rangos.
2. La salida de `java -version` y `./mvnw --version` (primera línea de cada uno).
3. Las dos últimas líneas de `./mvnw test` y la salida de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `NumberFormatException: For input string: "12,5"` | Falta el `replace(',', '.')`, o va **después** de `parseDouble` |
| `describeUsesTwoDecimalsAndDot` falla con `12,50` | Te falta `Locale.ROOT` en `String.format` |
| `cannot find symbol ... Locale` | Falta `import java.util.Locale;` arriba de `Fields.java` (el starter ya lo trae: no lo borres) |
| `No tests matching pattern` | Las comillas: en zsh, `-Dtest="FieldsTest#parseAmount*"` |
| `git push` pide usuario y contraseña | Configura una clave SSH en GitHub (`bc-git-github`) |

## Entrega

El proyecto es el **único entregable** de la semana:

- Repositorio `oop-java-<nombre>-<apellido>` con el `README.md` completado.
- Rama `week-01` con `./mvnw test` en verde, al menos 5 tests propios en `MyDomainTest.java` y `App.java` con datos de tu dominio.
- *Pull request* `week-01` → `main` con la descripción del paso 10.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · Tipos y conversiones](../2-practicas/ejercicio-03-tipos-y-conversiones/README.md) | **Proyecto · Gestión, capa 0** | [Webgrafía](../4-recursos/webgrafia/README.md) |
