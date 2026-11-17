# Proyecto — Gestión, capa 5: entidad encapsulada e inventario

⏱️ 3 h

## Qué construyes

Tu clase de la semana 05 (`Bicycle` en el servicio de bicicletas) funciona, pero no se protege: cualquier línea de tu programa puede escribir `bicycle.quantity = -5` o crear una bicicleta con código `"???"`. Esta semana la **encapsulas**, y le das un dueño a la colección: un `Inventory` que guarda tus objetos y pone las reglas que un objeto solo no puede cumplir.

| Cambio | Qué hace | Dónde |
|---|---|---|
| `private` y `final` | Atributos `private`; `code` y `name`, además, `final` | Tu clase |
| Constructor que valida | Rechaza un código mal formado, un nombre en blanco y unidades negativas | Tu clase |
| Segundo constructor | `new Bicycle(code, name)`, sin unidades, con `this(code, name, 0)` | Tu clase |
| *Getters* | `getCode()`, `getName()`, `getQuantity()`. Ningún *setter* | Tu clase |
| `Inventory` | Un objeto que **tiene** tus objetos: añade sin repetir códigos, busca, delega `take` y entrega una copia de su array | Clase nueva |

El starter trae cuatro archivos:

| Archivo | Qué es | Qué haces con él |
|---|---|---|
| `src/test/java/gestion/EntityTest.java` | Los 27 tests de la semana 05 y 14 nuevos | Lo copias **encima** de tu test de la semana 05 |
| `src/test/java/gestion/InventoryTest.java` | 14 tests del inventario | Lo copias |
| `src/main/java/gestion/Inventory.java` | El inventario, con los métodos sin escribir | Lo copias |
| `src/main/java/gestion/Entity.java` | La referencia de lo que cambia en tu clase, marcado con `// SEMANA 06` | **No** lo copias: lo lees |

Los tests usan datos de la Biblioteca; los tuyos, en el paso 11, usarán los de tu dominio.

## Pasos

### 1. Parte de la semana 05

Tu *pull request* `week-05` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-06
```

### 2. Copia los tests y el inventario

Usa el mismo nombre de clase que en la semana 05 (en Windows, desde Git Bash):

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-06-encapsulacion_constructores_y_composicion/3-proyecto/starter
CLASS=Bicycle
sed "s/Entity/$CLASS/g" $STARTER/src/test/java/gestion/EntityTest.java > src/test/java/gestion/${CLASS}Test.java
sed "s/Entity/$CLASS/g" $STARTER/src/test/java/gestion/InventoryTest.java > src/test/java/gestion/InventoryTest.java
sed "s/Entity/$CLASS/g" $STARTER/src/main/java/gestion/Inventory.java > src/main/java/gestion/Inventory.java
git status --short
```

Debes ver un archivo cambiado y dos nuevos:

```
 M src/test/java/gestion/BicycleTest.java
?? src/main/java/gestion/Inventory.java
?? src/test/java/gestion/InventoryTest.java
```

El primero sustituye a tu test de la semana 05: los 27 tests de entonces siguen ahí, y debajo vienen los nuevos. Comprueba que no queda ningún `Entity`:

```bash
grep -c Entity src/test/java/gestion/${CLASS}Test.java src/test/java/gestion/InventoryTest.java src/main/java/gestion/Inventory.java
```

Esperado: `:0` al final de las tres líneas. Haz un commit antes de tocar nada:

```bash
git add src/test/java/gestion/${CLASS}Test.java src/test/java/gestion/InventoryTest.java src/main/java/gestion/Inventory.java
git commit -m "test: add encapsulation and inventory tests with starter"
```

En el resto del README, donde ponga `Bicycle`, usa tu clase.

### 3. Rojo: el compilador te dice qué falta

```bash
./mvnw test
```

Esta vez no hay tests en rojo: el proyecto **no compila**. Entre los errores verás estos:

```
[ERROR] .../BicycleTest.java:[175,24] cannot find symbol
  symbol:   method getCode()
  location: variable item of type gestion.Bicycle
```

Los tests nuevos llaman a métodos que tu clase aún no tiene: `getCode()`, `getName()`, `getQuantity()` y el constructor de dos parámetros. Un error de compilación también es rojo, y te dice exactamente qué escribir.

### 4. *Getters* y segundo constructor

Abre el `Entity.java` del starter **al lado** de tu `Bicycle.java` y busca los comentarios `// SEMANA 06`. Añade a tu clase:

1. Los tres *getters*, debajo del constructor. Cada uno devuelve su atributo, nada más: `public String getCode() { return code; }`.
2. El constructor de dos parámetros, `public Bicycle(String code, String name)`, cuya única línea es `this(code, name, 0);`. No repitas nada del otro constructor: lo llamas.

```bash
./mvnw test -Dtest=BicycleTest
```

Ya compila. Esperado:

```
[ERROR] Tests run: 41, Failures: 10, Errors: 0, Skipped: 0
```

Los 10 que fallan son los que piden que el constructor rechace datos y los tres **tests de diseño**: `attributesArePrivate`, `textAttributesAreFinal` y `hasNoSetters`. No prueban un objeto, sino la clase: miran qué atributos declara y con qué modificadores. No necesitas entender cómo lo hacen (usan *reflection*, que no verás en este bootcamp); solo leer su mensaje, como `[el atributo code debe ser private]`.

Haz un commit: `feat: add Bicycle getters and constructor without units`.

### 5. `private` y `final`

En tu clase:

1. Pon `private` delante de los tres atributos.
2. Pon `final` delante de `code` y de `name`: no cambian nunca. `quantity` no lleva `final`, porque `take()` y `restock()` la cambian.

```bash
./mvnw test
```

Si algo de tu proyecto usaba un atributo directamente, ahora no compila:

```
[ERROR] .../App.java:[<línea>,<columna>] quantity has private access in gestion.Bicycle
```

Cámbialo por su *getter* (`item.getQuantity()`) o, mejor, por un método que ya tenga tu clase (`item.describe()`, `item.isAvailable()`). `indexOf` y `total` sí pueden seguir usando `items[i].code`: son métodos de tu clase, y `private` es "solo dentro de la clase".

Si no te sale ningún error de este tipo, tu código ya pasaba por los métodos. Comprueba los tests de diseño:

```bash
./mvnw test -Dtest="BicycleTest#attributes*+text*+hasNo*"
```

Esperado: `Tests run: 3, Failures: 0`.

### 6. El constructor valida

Antes de las tres asignaciones de tu constructor, añade tres comprobaciones, en este orden:

1. Guarda el código normalizado en una variable local (`String normalized = Fields.normalizeCode(code);`). Si `Stock.isValidCode(normalized)` es `false`, lanza `new IllegalArgumentException("Código no válido: " + normalized)`. **No reescribas la regla**: ya tienes `Stock.isValidCode` de la semana 02.
2. Si `name` es `null` o está en blanco (`isBlank()`), lanza `new IllegalArgumentException("Nombre vacío")`.
3. Si `quantity` es negativo, lanza `new IllegalArgumentException("Unidades no válidas: " + quantity)`.

Después asigna `this.code = normalized`, sin normalizar dos veces. El orden importa: **se comprueba todo y después se asigna**. Con `final`, Java además exige que cada atributo `final` reciba su valor exactamente una vez en el constructor.

```bash
./mvnw test -Dtest=BicycleTest
```

Esperado: `Tests run: 41, Failures: 0, Errors: 0`. Haz un commit: `feat: encapsulate Bicycle and validate its constructor`.

```bash
./mvnw test
```

Si ahora falla algún test **de semanas anteriores** con `Código no válido` o `Unidades no válidas`, ese test creaba un objeto que no debería existir. Corrige el dato del test, no la validación.

### 7. El inventario: constructor y `add`

Abre `Inventory.java`. Tiene dos atributos `private`, `items` (el array, `final`) y `size` (cuántos hay), y sus métodos sin escribir. Es una **composición**: el inventario tiene objetos de tu clase y es el único que toca su array.

1. Constructor: si `capacity` no es positiva, `new IllegalArgumentException("Capacidad no válida: " + capacity)`; si no, `this.items = new Bicycle[capacity];`. `size` empieza en 0 sin que hagas nada.
2. `items()`: devuelve `Arrays.copyOf(items, size)`. Es una **copia defensiva**: quien la recibe puede cambiarla sin tocar el inventario. El `import java.util.Arrays;` ya está arriba.
3. Un método `private int position(String code)` que devuelva `Bicycle.indexOf(items(), code)`. Reutiliza tu `indexOf` de la semana 05 sobre la copia, que no tiene posiciones `null`.
4. `contains(code)`: `position(code) >= 0`.
5. `add(item)`: si `contains(item.getCode())`, `"Código repetido: " + item.getCode()`; si `size == items.length`, `new IllegalStateException("Inventario lleno: " + items.length)`. Si no, `items[size] = item;` y `size++`. Comprueba las dos cosas **antes** de cambiar nada.
6. `size()`: devuelve `size`.

```bash
./mvnw test -Dtest="InventoryTest#aNew*+capacity*+add*+contains*+items*+attributes*"
```

Esperado: `Tests run: 9, Failures: 0, Errors: 2`. Los dos errores, `aNewInventoryIsEmpty` e `itemsReturnsACopy`, dicen `UnsupportedOperation Por escribir`: también llaman a `total()`, que escribes en el paso 8.

### 8. `find`, `take` y `total`

- `find(code)`: si `position(code)` es `-1`, `new IllegalArgumentException("No existe: " + Fields.normalizeCode(code))`; si no, devuelve `items[i]`. Devuelve **el mismo objeto** que guarda el inventario, no una copia.
- `take(code)`: una línea, `find(code).take();`. El inventario no resta nada: **delega** en el objeto, que ya sabe sacar una unidad y negarse si no le queda ninguna.
- `total()`: una línea, que llama a `Bicycle.total` con `items()`.

```bash
./mvnw test -Dtest=InventoryTest
```

Esperado: `Tests run: 14, Failures: 0, Errors: 0`. Haz un commit: `feat: add Inventory`.

### 9. Todo en verde

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con `Failures: 0, Errors: 0` y al menos 169 tests: los tuyos de las semanas 01 a 05 (al menos 141) y los 28 nuevos (14 en `BicycleTest` y 14 en `InventoryTest`).

### 10. Compara con la referencia

Abre otra vez el `Entity.java` del starter. Tu clase debe tener lo mismo que marcan los `// SEMANA 06`, con tu nombre y tu código. Borra los comentarios de la semana 05 que ya no son verdad (por ejemplo, "los atributos todavía no son `private`").

### 11. Tus reglas, en tests

En `MyDomainTest.java`, debajo de los de semanas anteriores, escribe **al menos 3 tests** con datos de tu dominio:

1. Uno que compruebe que tu constructor rechaza un dato que en tu dominio no tiene sentido: un código con el formato de otro sistema, un nombre vacío.
2. Uno con el constructor de dos parámetros.
3. Uno con un `Inventory` de tus objetos que use `add` y `take` o `find`.

Por ejemplo:

```java
@Test
void theCatalogLendsThroughTheInventory() {
    Inventory catalog = new Inventory(10);
    catalog.add(new Book("BK-042", "Ficciones", 2));
    catalog.add(new Book("BK-311", "Rayuela", 1));
    catalog.take("bk-311");
    assertThat(catalog.find("BK-311").isAvailable()).isFalse();
    assertThat(catalog.total()).isEqualTo(2);
}
```

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 172 tests.

### 12. El inventario en el programa

Al final de `main` en `App.java`, debajo del bloque de la semana 05 (usa su array `items`), añade:

```java
        // Semana 06: el inventario guarda tus objetos y rechaza los que no valen.
        Inventory inventory = new Inventory(5);
        for (Bicycle item : items) {
            inventory.add(item);
        }
        inventory.add(new Bicycle("BK-500", "Pedro Páramo"));
        inventory.take("bk-311");
        try {
            inventory.add(new Bicycle("BK-107", "Otro título", 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }
        try {
            new Bicycle("BK-9", "Sin unidades", -2);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }
        System.out.println(inventory.size() + " en el inventario, " + inventory.total()
                + " unidades · " + inventory.find("BK-311").describe());
```

Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
Rechazado: Código repetido: BK-107
Rechazado: Unidades no válidas: -2
4 en el inventario, 10 unidades · BK-311 · Rayuela · disponibles: 6
```

Cambia códigos, nombres y cantidades por los de tu dominio. Fíjate en que `inventory.take("bk-311")` cambió el objeto que también está en `items[2]`: el inventario guarda **referencias** a tus objetos, no copias.

### 13. Commit y pull request

```bash
git add .
git commit -m "feat: show Bicycle inventory in app"
git push -u origin week-06
```

En GitHub, abre un *pull request* de `week-06` hacia `main`. En la descripción pega:

1. Tu dominio y el nombre de tu clase.
2. Las tres reglas que valida tu constructor y, para cada una, un dato de tu dominio que rechaza.
3. Una frase: qué regla cumple `Inventory` que tu clase sola no puede cumplir, y por qué.
4. Las dos últimas líneas de `./mvnw test` y las tres últimas de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol ... method getCode()` | Es el rojo del paso 3: añade los *getters* del paso 4 |
| `constructor Bicycle in class Bicycle cannot be applied to given types` con `found: String,String` | Falta el constructor de dos parámetros del paso 4 |
| `quantity has private access in gestion.Bicycle` | Alguna clase usa el atributo directamente: cámbialo por `getQuantity()` o por un método de tu clase (paso 5) |
| `variable code might not have been initialized` | Un atributo `final` no recibe valor en algún camino del constructor: las tres asignaciones van al final, después de las comprobaciones |
| `cannot assign a value to final variable name` | Algún método reasigna `name` o `code`: un atributo `final` solo se asigna en el constructor |
| `constructorRejectsInvalidCodes`: `Expecting message ... "Código no válido: BK-4A"` | El mensaje usa el código **normalizado** (`normalized`), no el que llegó como parámetro |
| `[las unidades cambian con take y restock, no con un setter]` | Tu clase tiene un `setQuantity` u otro `set...`: bórralo y usa `take`/`restock` |
| `NullPointerException ... because "items[i]" is null` en `Inventory` | Buscas sobre el array `items` entero, con posiciones vacías: usa `items()`, que solo trae las ocupadas |
| `itemsReturnsACopy` falla | `items()` devuelve el propio array: devuelve `Arrays.copyOf(items, size)` |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-06` con tu clase encapsulada, `Inventory` y sus tests, y `./mvnw test` en verde.
- Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio.
- `App.java` con un inventario de tus objetos.
- *Pull request* `week-06` → `main` con la descripción del paso 13.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · Composición y copias defensivas](../2-practicas/ejercicio-03-composicion-y-copias-defensivas/README.md) | **Proyecto · Gestión, capa 5** | [Webgrafía](../4-recursos/webgrafia/README.md) |
