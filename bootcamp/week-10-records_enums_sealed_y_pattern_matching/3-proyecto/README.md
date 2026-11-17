# Proyecto — Gestión, capa 9: resultados sellados y niveles con nombre

⏱️ 3 h

## Qué construyes

Hasta ahora, cuando tu inventario no podía sacar una unidad, lanzaba una excepción, y quien lo llamaba tenía que acordarse de atraparla. El nivel de unidades era un texto, `"agotado"` o `"bajo"`, y un texto mal escrito compila igual. Esta semana cambias las dos cosas por **tipos**: un resultado que solo puede ser de dos formas y un nivel que solo puede tener cuatro valores. El compilador comprueba por ti que tratas todos los casos.

| Cambio | Qué hace | Dónde |
|---|---|---|
| `record Taken(String code, int left)` | Salió una unidad y quedan `left` | *Record* nuevo |
| `record Rejected(String code, String reason)` | No salió, por un motivo | *Record* nuevo |
| `sealed interface Outcome permits Taken, Rejected` | Un resultado es un `Taken` o un `Rejected`, y nada más; `message` lo convierte en texto con un `switch` sin `default` | Interfaz nueva |
| `enum Level` | Los cuatro niveles de unidades (`SOLD_OUT`, `LOW`, `NORMAL`, `FULL`), cada uno con su etiqueta, y si hay que reponer | *Enum* nuevo |
| `tryTake(String code)` | Saca una unidad y devuelve un `Outcome` en lugar de lanzar una excepción | Tu `Inventory` |

Ninguno de los cuatro tipos nuevos lleva tu clase en el nombre ni en el código: sirven igual en cualquier dominio.

El starter trae catorce archivos:

| Archivo | Qué es | Qué haces con él |
|---|---|---|
| `src/test/java/gestion/InventoryTest.java` | Los tests de las semanas 06, 08 y 09 y 4 nuevos | Lo copias **encima** del tuyo |
| `src/test/java/gestion/OutcomeTest.java` | 12 tests de los dos *records* y de `Outcome` | Lo copias |
| `src/test/java/gestion/LevelTest.java` | 13 tests de `Level` | Lo copias |
| `src/main/java/gestion/Taken.java` y `Rejected.java` | Los dos *records*, con el constructor compacto sin escribir | Los copias |
| `src/main/java/gestion/Outcome.java` | La interfaz, todavía sin sellar, con `message` sin escribir | Lo copias |
| `src/main/java/gestion/Level.java` | El *enum* con sus cuatro constantes, con los métodos sin escribir | Lo copias |
| `src/main/java/gestion/Inventory.java` | La referencia de lo que cambia en tu inventario, marcado con `// SEMANA 10` | **No** lo copias: lo lees |
| `src/main/java/gestion/Entity.java`, `ReservedEntity.java`, `TrackedEntity.java`, `Criterion.java`, `AvailableCriterion.java` y `NameCriterion.java` | Tu clase, tus subclases y tus criterios, para que el starter compile | **No** los copias |

## Pasos

### 1. Parte de la semana 09

Tu *pull request* `week-09` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-10
```

### 2. Copia los tests y los tipos nuevos

Usa el mismo nombre de clase que en las semanas anteriores (en Windows, desde Git Bash). Solo `InventoryTest.java` lleva `Entity` dentro, pero el bucle pasa `sed` por todos y no estropea nada:

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-10-records_enums_sealed_y_pattern_matching/3-proyecto/starter
CLASS=Bicycle
for f in test/java/gestion/InventoryTest test/java/gestion/OutcomeTest test/java/gestion/LevelTest main/java/gestion/Taken main/java/gestion/Rejected main/java/gestion/Outcome main/java/gestion/Level; do
  sed "s/Entity/$CLASS/g" $STARTER/src/$f.java > src/$f.java
done
git status --short
```

Debes ver un archivo cambiado y seis nuevos:

```
 M src/test/java/gestion/InventoryTest.java
?? src/main/java/gestion/Level.java
?? src/main/java/gestion/Outcome.java
?? src/main/java/gestion/Rejected.java
?? src/main/java/gestion/Taken.java
?? src/test/java/gestion/LevelTest.java
?? src/test/java/gestion/OutcomeTest.java
```

Comprueba que no queda ningún `Entity`:

```bash
grep -c Entity src/test/java/gestion/InventoryTest.java
```

Esperado: `0`. Haz un commit antes de tocar nada:

```bash
git add src/test/java/gestion/ src/main/java/gestion/Taken.java src/main/java/gestion/Rejected.java src/main/java/gestion/Outcome.java src/main/java/gestion/Level.java
git commit -m "test: add outcome and level tests with starter"
```

En el resto del README, donde ponga `Bicycle`, usa tu clase.

### 3. Rojo: no compila

```bash
./mvnw test
```

Entre las primeras líneas:

```
[ERROR] /.../src/test/java/gestion/InventoryTest.java:[251,29] cannot find symbol
  symbol:   method tryTake(java.lang.String)
  location: variable inventory of type gestion.Inventory
```

Los tests llaman a un método que tu `Inventory` todavía no tiene. Los tipos nuevos sí compilan: el starter ya trae sus métodos, aunque solo lanzan `UnsupportedOperationException`.

### 4. Un método que devuelve un resultado

Abre el `Inventory.java` del starter **al lado** del tuyo y busca el comentario `// SEMANA 10`. Añade a tu `Inventory`, encima de `items()`, el método `public Outcome tryTake(String code)`:

1. Si `!contains(code)`, guarda `Fields.normalizeCode(code)` en una variable `normalized` y devuelve `new Rejected(normalized, "No existe: " + normalized)`.
2. Si existe, guarda `find(code)` en `Bicycle item` y llama a `item.take()` dentro de un `try`. Si lanza `IllegalStateException e`, devuelve `new Rejected(item.getCode(), e.getMessage())`: el motivo es el mensaje de tu clase, o el de tu subclase con reserva.
3. Después del `try`, devuelve `new Taken(item.getCode(), item.getQuantity())`.

`tryTake` nunca lanza: devuelve un objeto que dice qué pasó. Quien lo recibe ya no tiene que acordarse de un `catch`, porque el tipo de lo que devuelve, `Outcome`, le dice que hay dos casos.

```bash
./mvnw test -Dtest=InventoryTest
```

Esperado: `Tests run: 29, Failures: 0, Errors: 4`. Los cuatro errores son de los tests nuevos y dicen `UnsupportedOperation Por escribir`: los *records* todavía no se dejan crear. Haz un commit: `feat: add try take returning an outcome`.

### 5. Dos records

Abre `Taken.java`. La cabecera `record Taken(String code, int left)` ya lo dice todo: Java escribe por ti los dos atributos `private final`, el constructor, `code()`, `left()`, `equals`, `hashCode` y `toString`. Lo único que tienes que escribir es la validación, en el **constructor compacto** `public Taken { ... }`, que no lleva paréntesis ni asigna nada:

```java
    public Taken {
        if (left < 0) {
            throw new IllegalArgumentException("Unidades no válidas: " + left);
        }
    }
```

Haz lo mismo en `Rejected.java`: si `reason` es `null` o está en blanco, lanza `IllegalArgumentException` con el mensaje `"Motivo vacío"`.

```bash
./mvnw test -Dtest='InventoryTest,OutcomeTest'
```

Esperado: `Tests run: 41, Failures: 2, Errors: 2`. `InventoryTest` ya está en verde. Los que quedan son de `Outcome`: los dos fallos dicen que todavía no está sellada y que su `switch` no está escrito; los dos errores, que `message` lanza. Fíjate en `twoRecordsWithTheSameComponentsAreEqual` y `aRecordShowsItsComponents`: pasan sin que hayas escrito `equals` ni `toString`. Haz un commit: `feat: add taken and rejected records`.

### 6. El enum de los niveles

Abre `Level.java`. Las cuatro constantes ya están, cada una con su etiqueta entre paréntesis: `SOLD_OUT("agotado")` llama al constructor de `Level`, que la guarda en `label`. Escribe:

1. `label()`: `return label;`.
2. `of(int quantity, int capacity)`: las mismas reglas que tu `Stock.level` de la semana 02, pero devolviendo `SOLD_OUT`, `LOW`, `NORMAL` o `FULL` en lugar de un texto.

```bash
./mvnw test -Dtest=LevelTest
```

Esperado: `Tests run: 13, Failures: 0, Errors: 2`. Quedan los de `isAlert`.

### 7. Un switch que cubre las cuatro constantes

Escribe `isAlert()` con un `switch` sobre `this`, el nivel que recibe la llamada. Empieza **sin** una de las constantes:

```java
    public boolean isAlert() {
        return switch (this) {
            case SOLD_OUT, LOW -> true;
            case NORMAL -> false;
        };
    }
```

```bash
./mvnw test -Dtest=LevelTest
```

No compila:

```
[ERROR] /.../src/main/java/gestion/Level.java:[32,16] the switch expression does not cover all possible input values
```

Falta `FULL`. El compilador conoce las cuatro constantes del *enum* y sabe que un `switch` que devuelve un valor tiene que cubrirlas todas. Cambia la última rama a `case NORMAL, FULL -> false;` y vuelve a ejecutar. Esperado: `Tests run: 13, Failures: 0, Errors: 0`. Haz un commit: `feat: add level enum`.

No pongas `default` para callar al compilador: si un día añades una quinta constante, el `switch` sin `default` no compila hasta que decidas qué hacer con ella; con `default`, la constante nueva cae en esa rama sin que nadie se entere.

### 8. Sella el resultado y desmonta cada caso

Abre `Outcome.java`. Escribe `message` con un `switch` que **desmonte** cada *record* en sus componentes:

```java
    static String message(Outcome outcome) {
        return switch (outcome) {
            case Taken(String code, int left) -> code + ": sale una, quedan " + left;
            case Rejected(_, String reason) -> "Rechazado: " + reason;
        };
    }
```

`case Taken(String code, int left)` comprueba que el objeto es un `Taken` y, si lo es, saca sus dos componentes a dos variables. En `Rejected(_, String reason)`, el `_` dice que el código no te hace falta. Ejecuta:

```bash
./mvnw test -Dtest=OutcomeTest
```

No compila:

```
[ERROR] /.../src/main/java/gestion/Outcome.java:[16,16] the switch expression does not cover all possible input values
```

Es el mismo error del paso 7 por otra razón: `Outcome` es una interfaz normal, y mañana cualquier clase podría implementarla. El compilador no sabe que solo hay dos casos. **Díselo**: cambia la cabecera a

```java
public sealed interface Outcome permits Taken, Rejected {
```

y vuelve a ejecutar. Esperado: `Tests run: 12, Failures: 0, Errors: 0`. Haz un commit: `feat: seal outcome and match its records`.

### 9. Todo en verde

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con `Failures: 0, Errors: 0` y al menos 264 tests: los tuyos de las semanas 01 a 09 (al menos 235) y los 29 nuevos.

Abre otra vez el `Inventory.java` del starter: tu inventario debe tener el `tryTake` que marca `// SEMANA 10`, sin `instanceof` ni nombres de tus subclases. El test `theInventoryNeverAsksForTheType` de la semana 08 sigue vigilándolo.

### 10. Tus reglas, en tests

En `MyDomainTest.java`, debajo de los de semanas anteriores, escribe **al menos 3 tests** con datos de tu dominio:

1. Uno con `tryTake` sobre tu subclase con reserva, que compruebe el texto de `Outcome.message`.
2. Uno con `Level.of` y la capacidad de tu dominio (los 10 sitios de una estantería, las 20 bicicletas de una estación), y `isAlert()`.
3. Uno que desmonte un `Taken` con `instanceof` y un patrón de *record*.

Por ejemplo, el tercero en la Biblioteca:

```java
@Test
void aLoanTellsHowManyCopiesAreLeft() {
    Inventory catalog = new Inventory(1);
    catalog.add(new TrackedBook("BK-777", "El nombre de la rosa", 3));
    if (catalog.tryTake("BK-777") instanceof Taken(String code, int left)) {
        assertThat(code).isEqualTo("BK-777");
        assertThat(left).isEqualTo(2);
    } else {
        throw new AssertionError("El préstamo debía salir");
    }
}
```

`instanceof Taken(String code, int left)` hace lo mismo que el `case` del paso 8, pero con un solo caso: si el resultado es un `Taken`, `code` y `left` existen dentro del `if`.

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 267 tests.

### 11. Resultados y niveles en el programa

Al final de `main` en `App.java`, debajo del bloque de la semana 09, añade:

```java
        // Semana 10: un resultado sellado en lugar de una excepción, y el nivel como enum.
        for (String wanted : new String[] {"BK-120", "BK-200", "bk-999"}) {
            System.out.println(Outcome.message(shelf.tryTake(wanted)));
        }
        for (Bicycle item : shelf.items()) {
            Level level = Level.of(item.getQuantity(), 2);
            System.out.println(item.getCode() + " · " + level.label()
                    + (level.isAlert() ? " · reponer" : ""));
        }
```

Cambia los tres códigos por los de tu `shelf`: dos que existan (uno de ellos tu subclase con reserva) y uno que no. Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
BK-120: sale una, quedan 0
Rechazado: Solo queda la reserva de BK-200
Rechazado: No existe: BK-999
BK-120 · agotado · reponer
BK-200 · normal
BK-300 · agotado · reponer
```

Ninguna línea viene de un `catch`: el programa ya no atrapa excepciones para sacar unidades.

### 12. Commit y pull request

```bash
git add .
git commit -m "feat: show outcomes and levels in app"
git push -u origin week-10
```

En GitHub, abre un *pull request* de `week-10` hacia `main`. En la descripción pega:

1. Tu dominio y la capacidad que usaste con `Level.of`: qué significa en tu dominio.
2. Una frase: ¿por qué `Taken` y `Rejected` son *records* y tu clase principal no? Piensa en qué cambia después de crearlos.
3. Qué pasaría en `message` si añadieras un tercer resultado a `permits` sin tocar el `switch`.
4. Las dos últimas líneas de `./mvnw test` y las seis últimas de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol` con `symbol: method tryTake(java.lang.String)` | Es el rojo del paso 3: añade el método del paso 4 a tu `Inventory` |
| `the switch expression does not cover all possible input values` en `Level.java` | Falta una constante en el `switch` de `isAlert`: cubre las cuatro, sin `default` |
| `the switch expression does not cover all possible input values` en `Outcome.java` | `Outcome` no está sellada: escribe `public sealed interface Outcome permits Taken, Rejected` |
| `class is not allowed to extend sealed class: gestion.Outcome (as it is not listed in its 'permits' clause)` | Escribiste `sealed` sin `permits`, o te falta uno de los dos *records* en la lista |
| `messageCoversEveryCaseWithoutDefault`: `[el switch de message cubre Taken y Rejected sin default]` | Quitaste el error del paso 8 con un `default`: bórralo y sella la interfaz |
| `constructor is not canonical, so it must invoke another constructor of class Taken` | Escribiste `public Taken() {`: el constructor compacto va sin paréntesis, `public Taken {` |
| `cannot assign a value to final variable left` | En un constructor compacto no se asigna con `this.left = ...`: Java asigna los componentes al final, solo tienes que validar |
| `cannot find symbol` con `symbol: method getCode()` y `location: variable taken of type gestion.Taken` | Los métodos de un *record* se llaman como sus componentes: `taken.code()`, no `taken.getCode()` |
| `outcomeIsSealedWithTwoPermittedClasses` falla | La cabecera de `Outcome` debe decir `sealed` y nombrar `Taken` y `Rejected` en `permits` |
| `tryTakeWithoutUnitsIsRejectedWithoutThrowing` da error con `IllegalStateException: No quedan unidades de BK-107` | El `take()` de `tryTake` está fuera del `try`: la excepción de tu clase escapa en lugar de convertirse en un `Rejected` |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-10` con `Taken`, `Rejected`, `Outcome`, `Level` y sus tests, `tryTake` en tu `Inventory`, y `./mvnw test` en verde.
- Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio, uno de ellos con un patrón de *record*.
- `App.java` con el bloque de resultados y niveles.
- *Pull request* `week-10` → `main` con la descripción del paso 12.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · Sealed y pattern matching](../2-practicas/ejercicio-03-sealed-y-pattern-matching/README.md) | **Proyecto · Gestión, capa 9** | [Webgrafía](../4-recursos/webgrafia/README.md) |
