# Proyecto — Gestión, capa 7: una jerarquía y un inventario que no pregunta

⏱️ 3 h

## Qué construyes

Tu clase (`Bicycle` en el servicio de bicicletas) ya tiene una hija, la de la reserva. Esta semana le das **una segunda hija**, que cuenta sus salidas, y le enseñas a tu `Inventory` dos cosas nuevas que funcionan con las tres clases **sin preguntar de cuál es cada objeto**. En la Biblioteca, la segunda hija es el libro del que se quiere saber cuántas veces se prestó; en tu dominio, lo que tenga sentido (cuántas veces se alquiló una bicicleta, cuántas noches se vendió una habitación).

| Cambio | Qué hace | Dónde |
|---|---|---|
| `TrackedBicycle extends Bicycle` | Hereda todo y declara solo `taken`, el número de salidas | Clase nueva |
| `take`, `describe` | Sobrescritos: `take()` saca la unidad con `super.take()` y cuenta la salida; `describe()` añade `· salidas: N` | Clase nueva |
| `availableCount()` | Cuántas entidades están disponibles, preguntándole a cada una con `isAvailable()` | Tu `Inventory` |
| `report()` | Una línea por entidad con su `toString()` | Tu `Inventory` |

La regla de la semana: **tu `Inventory` no escribe `instanceof`, `getClass` ni el nombre de ninguna subclase**. Llama a `isAvailable()` y a `toString()`, y cada objeto responde con su versión. Un test lo comprueba leyendo el código de `Inventory.java`.

El starter trae seis archivos:

| Archivo | Qué es | Qué haces con él |
|---|---|---|
| `src/test/java/gestion/InventoryTest.java` | Los tests de la semana 06 y 6 nuevos | Lo copias **encima** del tuyo |
| `src/test/java/gestion/TrackedEntityTest.java` | 12 tests de la segunda subclase | Lo copias |
| `src/main/java/gestion/TrackedEntity.java` | La subclase, con los métodos sin escribir | Lo copias |
| `src/main/java/gestion/Inventory.java` | La referencia de lo que cambia en tu inventario, marcado con `// SEMANA 08` | **No** lo copias: lo lees |
| `src/main/java/gestion/Entity.java` y `ReservedEntity.java` | Tu clase y tu subclase, para que el starter compile | **No** los copias |

## Pasos

### 1. Parte de la semana 07

Tu *pull request* `week-07` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-08
```

### 2. Copia los tests y la subclase

Usa el mismo nombre de clase que en las semanas anteriores (en Windows, desde Git Bash):

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-08-polimorfismo/3-proyecto/starter
CLASS=Bicycle
sed "s/Entity/$CLASS/g" $STARTER/src/test/java/gestion/InventoryTest.java > src/test/java/gestion/InventoryTest.java
sed "s/Entity/$CLASS/g" $STARTER/src/test/java/gestion/TrackedEntityTest.java > src/test/java/gestion/Tracked${CLASS}Test.java
sed "s/Entity/$CLASS/g" $STARTER/src/main/java/gestion/TrackedEntity.java > src/main/java/gestion/Tracked${CLASS}.java
git status --short
```

Debes ver un archivo cambiado y dos nuevos:

```
 M src/test/java/gestion/InventoryTest.java
?? src/main/java/gestion/TrackedBicycle.java
?? src/test/java/gestion/TrackedBicycleTest.java
```

Comprueba que no queda ningún `Entity`:

```bash
grep -c Entity src/test/java/gestion/InventoryTest.java src/test/java/gestion/Tracked${CLASS}Test.java src/main/java/gestion/Tracked${CLASS}.java
```

Esperado: `:0` al final de las tres líneas. Haz un commit antes de tocar nada:

```bash
git add src/test/java/gestion/InventoryTest.java src/test/java/gestion/Tracked${CLASS}Test.java src/main/java/gestion/Tracked${CLASS}.java
git commit -m "test: add polymorphism tests with starter"
```

En el resto del README, donde ponga `Bicycle`, usa tu clase.

### 3. Rojo: no compila

```bash
./mvnw test
```

Esta vez el rojo es un error de compilación. Entre las primeras líneas:

```
[ERROR] /.../src/test/java/gestion/InventoryTest.java:[145,29] cannot find symbol
  symbol:   method availableCount()
  location: variable inventory of type gestion.Inventory
```

Los tests nuevos llaman a dos métodos que tu `Inventory` todavía no tiene. `TrackedBicycle` sí compila: el starter ya trae su constructor, que solo llama a `super(...)`.

### 4. Dos métodos que no preguntan el tipo

Abre el `Inventory.java` del starter **al lado** del tuyo y busca el comentario `// SEMANA 08`. Añade a tu `Inventory`, encima de `items()`:

1. `availableCount()`: recorre `items()` y cuenta las entidades para las que `item.isAvailable()` es `true`.
2. `report()`: empieza con `String text = "";`, recorre `items()` sumando `item + "\n"` a `text` y lo devuelve.

En ninguno de los dos preguntes de qué clase es `item`. La variable es `Bicycle`, pero el objeto puede ser una `Bicycle`, una `ReservedBicycle` o una `TrackedBicycle`, y `isAvailable()` y `toString()` ejecutan la versión **del objeto**: con reserva, la que respeta la reserva; con salidas, el `describe()` que las muestra.

```bash
./mvnw test -Dtest=InventoryTest
```

Esperado: `Tests run: 20, Failures: 0, Errors: 1`. El error es de `reportUsesTheDescribeOfEachObject` y dice `UnsupportedOperation Por escribir`: hace un `take()` sobre una `TrackedBicycle`, que aún no lo tiene escrito. Haz un commit: `feat: add availableCount and report`.

### 5. La subclase cuenta sus salidas

Abre `TrackedBicycle.java`. Declara `private int taken` (sin `final`: cambia con cada salida) y su constructor ya llama a tu constructor. Escribe:

1. `getTaken()`: devuelve `taken`.
2. `take()`: primero `super.take();`, después `taken++;`. El orden importa: si no quedan unidades, `super.take()` lanza la excepción de tu clase y la línea de `taken++` no llega a ejecutarse, así que una salida fallida no se cuenta.

```bash
./mvnw test -Dtest=TrackedBicycleTest
```

Esperado: `Tests run: 12, Failures: 0, Errors: 3`. Los tres errores son de `describe()`.

### 6. `describe()` con las salidas

`return super.describe() + " · salidas: " + taken;`, como hiciste con la reserva.

```bash
./mvnw test -Dtest=TrackedBicycleTest
```

Esperado: `Tests run: 12, Failures: 0, Errors: 0`. Fíjate en `theSameLoopRunsThreeDifferentTakes`: un array de `Bicycle` con una de cada clase y **una sola línea** `item.take()` en el bucle. Cada objeto ejecuta su `take()`: el de tu clase saca la unidad, el de la reserva se niega y el de las salidas la saca y la cuenta. Haz un commit: `feat: add TrackedBicycle`.

### 7. Todo en verde

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con `Failures: 0, Errors: 0` y al menos 212 tests: los tuyos de las semanas 01 a 07 (al menos 194) y los 18 nuevos.

### 8. Compara con la referencia

Abre otra vez el `Inventory.java` del starter: tu inventario debe tener los dos métodos que marca `// SEMANA 08`. Busca en tu `Inventory.java` las palabras `instanceof`, `getClass`, `Reserved` y `Tracked`: no debe aparecer ninguna. Si alguna aparece, el test `theInventoryNeverAsksForTheType` ya te lo habrá dicho.

### 9. Tus reglas, en tests

En `MyDomainTest.java`, debajo de los de semanas anteriores, escribe **al menos 3 tests** con datos de tu dominio:

1. Uno en el que tu `TrackedBicycle` cuente varias salidas, con un caso real de tu dominio.
2. Uno con un array de `Bicycle` que mezcle tus dos subclases y recorra el array con un solo bucle.
3. Uno con `report()` o `availableCount()` en un `Inventory` que tenga una `ReservedBicycle`.

Por ejemplo:

```java
@Test
void aBestsellerCountsItsLoans() {
    TrackedBook bestseller = new TrackedBook("BK-777", "El nombre de la rosa", 3);
    bestseller.take();
    bestseller.take();
    assertThat(bestseller.getTaken()).isEqualTo(2);
}
```

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 215 tests.

### 10. La jerarquía en el programa

Al final de `main` en `App.java`, debajo del bloque de la semana 07, añade un inventario nuevo (el de la semana 06 ya está lleno):

```java
        // Semana 08: un mismo bucle para tres clases; cada objeto ejecuta su take().
        Inventory shelf = new Inventory(3);
        shelf.add(new Bicycle("BK-120", "La tregua", 2));
        shelf.add(new ReservedBicycle("BK-200", "Diccionario", 1, 1));
        shelf.add(new TrackedBicycle("BK-300", "Kafka en la orilla", 1));
        for (Bicycle item : shelf.items()) {
            try {
                item.take();
            } catch (IllegalStateException e) {
                System.out.println("Rechazado: " + e.getMessage());
            }
        }
        System.out.print(shelf.report());
        System.out.println("Disponibles: " + shelf.availableCount() + " de " + shelf.size());
```

Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
Rechazado: Solo queda la reserva de BK-200
BK-120 · La tregua · disponibles: 1
BK-200 · Diccionario · disponibles: 1 · reserva: 1
BK-300 · Kafka en la orilla · disponibles: 0 · salidas: 1
Disponibles: 1 de 3
```

Cambia códigos, nombres y cantidades por los de tu dominio. Va `print`, no `println`, porque cada línea de `report()` ya termina en salto de línea.

### 11. Commit y pull request

```bash
git add .
git commit -m "feat: show the hierarchy in app"
git push -u origin week-08
```

En GitHub, abre un *pull request* de `week-08` hacia `main`. En la descripción pega:

1. Tu dominio, tus tres clases y qué cuenta `taken` en tu dominio, con un ejemplo.
2. Una frase: en `for (Bicycle item : shelf.items()) item.take();`, ¿quién decide qué `take()` se ejecuta, la variable o el objeto?
3. Por qué tu `Inventory` no necesita cambiar si mañana escribes una tercera subclase.
4. Las dos últimas líneas de `./mvnw test` y las cinco últimas de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol` con `symbol: method availableCount()` o `report()` | Es el rojo del paso 3: añade los dos métodos del paso 4 a tu `Inventory` |
| `theInventoryNeverAsksForTheType`: `[Inventory no debe preguntar el tipo...]` | Tu `Inventory` escribe `instanceof`, `getClass` o el nombre de una subclase: llama a `isAvailable()` o a `toString()` y deja que decida el objeto |
| `reportHasOneLinePerEntityInOrder` falla sin saltos de línea o con uno de más | Cada línea es `item + "\n"`, también la última, y nada más |
| `aFailedTakeIsNotCounted`: `expected: 0 but was: 1` | `taken++` va antes de `super.take()`: cámbialos de orden |
| `cannot assign a value to final variable taken` | Quita el `final` de `taken`: cambia con cada salida |
| `java.lang.StackOverflowError` en `TrackedBicycle.take` | Escribiste `take()` en lugar de `super.take()`: el método se llama a sí mismo |
| `onlyDeclaresThePrivateTaken`: `Expected size: 1` | `TrackedBicycle` declara otra vez `code`, `name` o `quantity`: bórralos, los hereda |
| `extendsTheBicycleNotTheReservedOne` falla | `TrackedBicycle` hereda de `ReservedBicycle`: las dos son hijas de tu clase, hermanas entre sí |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-08` con `TrackedBicycle` y sus tests, `availableCount()` y `report()` en tu `Inventory`, y `./mvnw test` en verde.
- Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio.
- `App.java` con el inventario de las tres clases.
- *Pull request* `week-08` → `main` con la descripción del paso 11.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · `instanceof` y polimorfismo en lugar de condicionales](../2-practicas/ejercicio-03-instanceof-y-polimorfismo-en-lugar-de-condicionales/README.md) | **Proyecto · Gestión, capa 7** | [Webgrafía](../4-recursos/webgrafia/README.md) |
