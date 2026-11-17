# Proyecto — Gestión, capa 1: el inventario

⏱️ 3 h

## Qué construyes

La semana 01 trataba **un** registro; esta trata **varios**. Añades a tu proyecto la clase `Stock`, con las reglas del inventario de tu dominio: leer una lista de códigos, validarlos, buscarlos, sumar cantidades, clasificarlas y sacar un informe. Los datos viajan en dos **arrays paralelos**: `codes[i]` tiene `quantities[i]` unidades. En la semana 05 cada par será un objeto; en la 13, una colección. Lo que aprendes hoy (recorrer, buscar, acumular) es lo que esas versiones hacen por dentro.

| Método | Ejemplo | Devuelve |
|---|---|---|
| `parseCodes("bk-042, ,BK-107")` | Una línea con códigos separados por comas | `["BK-042", "BK-107"]`: normalizados, sin vacíos |
| `isValidCode("BK-042")` | Un código | `true` si son letras mayúsculas, un guion y dígitos, nada más |
| `total(new int[] {4, 0, 7})` | Las cantidades | `11` |
| `indexOf(codes, " bk-107 ")` | Los códigos y uno a buscar | Su posición (`1`), o `-1` si no está |
| `level(2, 8)` | Cantidad y capacidad | `"agotado"`, `"bajo"`, `"normal"` o `"completo"` |
| `report(codes, quantities, 10)` | Códigos, cantidades y capacidad | Una línea por código: `"BK-042: 0/10 (agotado)\n"` |
| `missing(new int[] {4, 12}, 10)` | Cantidades y capacidad | Un array **nuevo**: `[6, 0]` |

## Pasos

### 1. Parte de la semana 01

Tu *pull request* `week-01` debe estar fusionado en `main`. Desde tu repositorio:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-02
```

### 2. Copia los archivos de la semana

El starter de esta semana es un proyecto Maven completo para que puedas probarlo aparte, pero a tu repositorio solo llevas **dos archivos**: la clase y sus tests. Tu `pom.xml`, tu `Fields.java` y tus tests de la semana 01 no se tocan.

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-02-control_metodos_strings_y_arrays/3-proyecto/starter
cp $STARTER/src/main/java/gestion/Stock.java src/main/java/gestion/
cp $STARTER/src/test/java/gestion/StockTest.java src/test/java/gestion/
git status --short
```

Debes ver:

```
?? src/main/java/gestion/Stock.java
?? src/test/java/gestion/StockTest.java
```

### 3. Tests en rojo

```bash
./mvnw test -Dtest=StockTest
```

Salida esperada al final:

```
[ERROR] Tests run: 18, Failures: 0, Errors: 18, Skipped: 0
[ERROR] BUILD FAILURE
```

Los 18 tests de `StockTest.java` fallan con `UnsupportedOperationException: TODO`. Tus tests de la semana 01 siguen pasando: compruébalo con `./mvnw test -Dtest="FieldsTest+MyDomainTest"`.

### 4. `parseCodes`

Tres piezas del ejercicio 03 y del 02: `split(",")` trocea la línea; un bucle descarta las partes en blanco (`isBlank()`) y normaliza las demás; el resultado tiene que tener **exactamente** el tamaño justo. Como no sabes cuántas partes válidas hay hasta recorrerlas, crea un array del tamaño de `parts`, llévalo lleno hasta `count` y devuelve `Arrays.copyOf(codes, count)`.

```bash
./mvnw test -Dtest="StockTest#parseCodes*"
```

Esperado: `Tests run: 3, Failures: 0, Errors: 0`. Fíjate en `parseCodesOfEmptyLineIsEmpty`: `"".split(",")` da un array con un elemento vacío, no un array vacío.

### 5. `isValidCode`

Busca la posición del guion con `indexOf('-')`. Si no hay guion, si está en la posición 0 o si es el último carácter, el código no vale. Después recorre los caracteres con `charAt(i)` (ejercicio 03, paso 6): antes del guion, cada uno debe estar entre `'A'` y `'Z'`; después, cada uno debe ser un dígito (`Character.isDigit`). Al primer carácter que no cumpla, `return false`.

```bash
./mvnw test -Dtest="StockTest#isValidCode*"
```

Esperado: `Tests run: 3, Failures: 0, Errors: 0`. `"BK--042"` es el caso que más falla: el segundo guion está **después** del primero y no es un dígito.

### 6. `total` e `indexOf`

`total` acumula con un for-each (ejercicio 02, paso 3). `indexOf` necesita la posición, así que va con el for clásico: normaliza el código buscado **una vez**, antes del bucle, y compara con `equals`, nunca con `==`. Si el bucle termina sin encontrarlo, `return -1`.

```bash
./mvnw test -Dtest="StockTest#total*+indexOf*"
```

Esperado: `Tests run: 4, Failures: 0, Errors: 0`.

### 7. `level`

Una cadena de `if / else if` (ejercicio 01, paso 1). El orden importa (paso 6 del mismo ejercicio): primero el 0, después "hasta un cuarto", después "por debajo de la capacidad". Para "un cuarto" evita dividir: `quantity * 4 <= capacity` dice lo mismo sin decimales.

```bash
./mvnw test -Dtest="StockTest#level*"
```

Esperado: `Tests run: 4, Failures: 0, Errors: 0`.

### 8. `report` y `missing`

`report` recorre los dos arrays con el mismo índice y acumula en un `StringBuilder` (ejercicio 03, paso 5); cada línea **reutiliza** `level` y termina en `'\n'`. `missing` crea `new int[quantities.length]` y lo rellena con `Math.max(0, capacity - quantities[i])`: el array de entrada no se toca (ejercicio 02, paso 5).

```bash
./mvnw test -Dtest=StockTest
```

Esperado: `Tests run: 18, Failures: 0, Errors: 0`.

### 9. Tu inventario en el programa

Al final del `main` de tu `App.java`, añade:

```java
// Semana 02: el inventario. Cambia códigos, cantidades y capacidad por los de tu dominio.
String[] codes = Stock.parseCodes("bk-042, bk-107, bk-311");
int[] copies = {0, 2, 7};
System.out.print(Stock.report(codes, copies, 8));
System.out.println("Total: " + Stock.total(copies) + " · Faltan: "
        + java.util.Arrays.toString(Stock.missing(copies, 8)));
```

Cambia los códigos (escríbelos en minúsculas o con espacios: `parseCodes` los arregla), las cantidades, la capacidad y el nombre `copies` por los de tu dominio. Ejecuta:

```bash
./mvnw -q compile exec:java
```

Ejemplo para la Biblioteca (las cuatro primeras líneas son las de la semana 01):

```
BK-042 · Precio: 12.50 USD
BK-107 · Precio: 8.99 USD
BK-311 · Precio: 30.00 USD
¿Precio válido? true
BK-042: 0/8 (agotado)
BK-107: 2/8 (bajo)
BK-311: 7/8 (normal)
Total: 9 · Faltan: [8, 6, 1]
```

### 10. Tus tests, calculados a mano

En `MyDomainTest.java`, **debajo** de los de la semana 01, añade al menos **5 tests** con códigos y cantidades de tu dominio. Calcula el resultado antes de ejecutarlos. Cubre al menos:

| Caso | Ejemplo (Biblioteca) |
|---|---|
| Una línea con espacios y minúsculas | `Stock.parseCodes(" bk-042 ,bk-311 ")` da `"BK-042", "BK-311"` |
| Un código inválido de tu dominio | `Stock.isValidCode("BK-")` es `false` |
| El límite exacto de "bajo" | `Stock.level(2, 8)` es `"bajo"` |
| Buscar el último | `Stock.indexOf(new String[] {"BK-042", "BK-311"}, "bk-311")` es `1` |
| Una línea del informe | `Stock.report(new String[] {"BK-311"}, new int[] {8}, 8)` es `"BK-311: 8/8 (completo)\n"` |

Para comparar arrays, `assertThat(array).containsExactly(...)` (míralo en `StockTest.java`).

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS`, con al menos 40 tests: los 17 de la semana 01, los 18 de `StockTest` y tus 5 nuevos.

### 11. Commit y pull request

```bash
git add .
git commit -m "feat: add stock rules over parallel arrays"
git push -u origin week-02
```

En GitHub, abre un *pull request* de `week-02` hacia `main`. En la descripción pega:

1. Tus códigos, cantidades y capacidad, y por qué esa capacidad tiene sentido en tu dominio.
2. Las dos últimas líneas de `./mvnw test` y la salida de `./mvnw -q compile exec:java`.
3. Un test que fallara la primera vez y qué tenías mal.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `parseCodesSkipsBlankItems` falla con `[BK-042, null, ...]` | Devuelves el array grande; recórtalo con `Arrays.copyOf(codes, count)` |
| `expected: ["BK-042"] but was: ["bk-042"]` | Falta `toUpperCase(Locale.ROOT)` en `parseCodes` |
| `StringIndexOutOfBoundsException` en `isValidCode` | Usas `charAt(dash + 1)` sin comprobar antes que el guion no es el último |
| `indexOfFindsNormalizedCode` da `-1` | Comparas con `==`, o normalizas los elementos del array en lugar del código buscado |
| `levelUpToAQuarterIsLow` da `"normal"` | Usas `<` en lugar de `<=`: un cuarto exacto es "bajo" |
| `missingDoesNotChangeInput` falla | Escribes en `quantities[i]`: crea el array nuevo y escribe ahí |
| `git switch -c week-02` parte de un `main` sin tu semana 01 | Tu PR no estaba fusionado: fusiónalo, `git switch main && git pull`, y `git rebase main` desde `week-02` |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-02` con `Stock.java` completo, `./mvnw test` en verde y al menos 5 tests nuevos en `MyDomainTest.java`.
- `App.java` con el inventario de tu dominio.
- *Pull request* `week-02` → `main` con la descripción del paso 11.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · Métodos y `String`](../2-practicas/ejercicio-03-metodos-y-string/README.md) | **Proyecto · Gestión, capa 1** | [Webgrafía](../4-recursos/webgrafia/README.md) |
