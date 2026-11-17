# Proyecto — Gestión, capa 4: tu entidad como objeto

⏱️ 3 h

## Qué construyes

Hasta ahora tu entidad principal vivía repartida en arrays paralelos: `codes[i]`, `titles[i]` y `quantities[i]` hablaban de lo mismo, y solo tú sabías que era así. Esta semana la conviertes en una **clase** de tu dominio (`Bicycle` en el servicio de bicicletas de la semana 04), y cada registro pasa a ser un objeto con sus datos dentro.

La clase llega en el starter con un nombre provisional, `Entity`, y la renombras al copiarla. Tiene tres atributos (`code`, `name`, `quantity`) y estos métodos, todos sin escribir:

| Método | Qué hace | Tipo |
|---|---|---|
| Constructor | Crea el objeto con el código normalizado y el nombre sin espacios en los extremos | — |
| `describe()` | `"BK-042 · Ficciones · disponibles: 2"` | Instancia |
| `isAvailable()` | Si queda al menos una unidad | Instancia |
| `take()` | Saca una unidad; sin unidades, `IllegalStateException` | Instancia |
| `restock(units)` | Suma unidades; si no son positivas, `IllegalArgumentException` | Instancia |
| `matches(query)` | Si el nombre contiene un texto, como `Catalog.search` | Instancia |
| `level(capacity)` | El nivel de sus unidades, como `Stock.level` | Instancia |
| `indexOf(items, code)` | Posición en un array de objetos, o `-1` | `static` |
| `total(items)` | Suma de las unidades de un array de objetos | `static` |

Los 27 tests de `EntityTest` usan datos de la Biblioteca, como los de semanas anteriores; los tuyos, en el paso 10, usarán los de tu dominio.

## Pasos

### 1. Parte de la semana 04

Tu *pull request* `week-04` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-05
```

### 2. Elige el nombre y copia los archivos

Abre `docs/analisis.md` y busca tu objeto principal en la tabla de objetos y en tus tarjetas CRC: el que tiene código, nombre y unidades. Su nombre en inglés, en singular y con mayúscula inicial, es el de tu clase. Por ejemplo, `Bicycle` en el servicio de bicicletas.

Copia los dos archivos cambiando `Entity` por ese nombre (en Windows, desde Git Bash):

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-05-clases_y_objetos/3-proyecto/starter
CLASS=Bicycle
sed "s/Entity/$CLASS/g" $STARTER/src/main/java/gestion/Entity.java > src/main/java/gestion/$CLASS.java
sed "s/Entity/$CLASS/g" $STARTER/src/test/java/gestion/EntityTest.java > src/test/java/gestion/${CLASS}Test.java
git status --short
```

Debes ver tus dos archivos nuevos, con el nombre de tu clase:

```
?? src/main/java/gestion/Bicycle.java
?? src/test/java/gestion/BicycleTest.java
```

En un archivo `.java`, el nombre de la clase pública y el del archivo deben coincidir: `sed` cambia los dos a la vez. Comprueba que no queda ningún `Entity`:

```bash
grep -c Entity src/main/java/gestion/$CLASS.java src/test/java/gestion/${CLASS}Test.java
```

Esperado: `:0` al final de las dos líneas. Haz un commit antes de tocar nada:

```bash
git add src/main/java/gestion/$CLASS.java src/test/java/gestion/${CLASS}Test.java
git commit -m "test: add $CLASS tests with starter"
```

En el resto del README, donde ponga `Bicycle`, usa tu clase.

### 3. Tests en rojo

```bash
./mvnw test -Dtest=BicycleTest
```

Esperado:

```
[ERROR]   BicycleTest.<init>:16 » UnsupportedOperation Por escribir
[ERROR] Tests run: 27, Failures: 0, Errors: 27, Skipped: 0
```

Los 27 caen en la misma línea, y no es la de ningún test. `<init>` es la creación del objeto de test: la línea 16 de `BicycleTest` crea un objeto de tu clase, y el constructor lanza la excepción. Sin constructor, no se puede probar nada más. Por ahí se empieza.

### 4. El constructor

Sustituye el `throw` del constructor por tres asignaciones, con `this.` delante de cada atributo:

1. `this.code`: el código normalizado. **No lo reescribas**: ya tienes `Fields.normalizeCode` de la semana 01.
2. `this.name`: el nombre con `strip()`.
3. `this.quantity`: tal cual.

```bash
./mvnw test -Dtest=BicycleTest
```

Ya no hay errores en `<init>`: ahora cada test falla en su propio método, porque los demás siguen sin escribir. Si `describeShowsCodeNameAndQuantity` dice `but was: "null · ...`, revisa el `this.` del código.

### 5. `describe` e `isAvailable`

Los dos leen los atributos del objeto: `code`, `name` y `quantity` son los del objeto sobre el que se llama el método, sin parámetros.

```bash
./mvnw test -Dtest="BicycleTest#describe*+available*+notAvailable*"
```

Esperado: `Tests run: 3, Failures: 0`. Haz un commit: `feat: add Bicycle constructor and describe`.

### 6. `take` y `restock`

Estos dos **cambian** el estado del objeto:

- `take()`: si `quantity` es 0, lanza `new IllegalStateException("No quedan unidades de " + code)`; si no, resta 1. `IllegalStateException` y no `IllegalArgumentException`, porque el problema no está en un argumento (no hay ninguno): está en el estado del objeto.
- `restock(units)`: si `units` no es positivo, lanza `new IllegalArgumentException("Unidades no válidas: " + units)`; si no, suma.

Comprueba **antes** de cambiar: los tests `takeWithoutUnitsFailsAndChangesNothing` y `restockRejectsUnitsThatAreNotPositive` exigen que, si hay error, la cantidad quede como estaba.

```bash
./mvnw test -Dtest="BicycleTest#take*+taking*+restock*+eachObject*+anAlias*"
```

Esperado: `Tests run: 8, Failures: 0`. `eachObjectKeepsItsOwnData` comprueba que sacar una unidad de un objeto no toca otro; `anAliasChangesTheSameObject`, que dos variables pueden ser el mismo objeto.

### 7. `matches` y `level`

Los dos repiten reglas que ya tienes:

- `matches(query)`: la misma búsqueda de `Catalog.search` (vacía, `strip`, minúsculas con `Locale.ROOT`, `contains`), pero sobre **un** nombre, el del objeto. Devuelve un `boolean`. Añade `import java.util.Locale;` arriba.
- `level(capacity)`: una línea, que llama a `Stock.level` con la cantidad del objeto.

```bash
./mvnw test -Dtest="BicycleTest#matches*+doesNotMatch*+level*"
```

Esperado: `Tests run: 10, Failures: 0`.

### 8. `indexOf` y `total`

Son `static`: no hablan de un objeto, sino de un array de ellos. Se llaman con el nombre de la clase, `Bicycle.indexOf(items, "BK-311")`, y dentro no hay `this`.

- `indexOf`: normaliza el código buscado con `Fields.normalizeCode` y recorre `items` comparando con `items[i].code` (con `equals`, no `==`).
- `total`: suma `item.quantity` de cada objeto, con un `for` mejorado.

```bash
./mvnw test -Dtest="BicycleTest#indexOf*+total*"
```

Esperado: `Tests run: 5, Failures: 0`. Haz un commit: `feat: add Bicycle behaviour`.

### 9. Todo en verde

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con `Failures: 0, Errors: 0` y al menos 138 tests: los tuyos de las semanas 01 a 04 (al menos 111) y los 27 de `BicycleTest`.

### 10. Tus objetos, en tests

En `MyDomainTest.java`, debajo de los de semanas anteriores, escribe **al menos 3 tests** con objetos de tu clase y datos de tu dominio: tus códigos, tus nombres, tu capacidad. Que cada uno pruebe una situación real de tu sistema, por ejemplo:

```java
@Test
void lendingEveryCopyLeavesTheBookUnavailable() {
    Book pedroParamo = new Book("BK-500", "Pedro Páramo", 2);
    pedroParamo.take();
    pedroParamo.take();
    assertThat(pedroParamo.isAvailable()).isFalse();
}
```

Al menos uno debe crear **dos o más objetos** y comprobar algo sobre los dos (que son independientes, o con `indexOf` o `total`).

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 141 tests.

### 11. Los objetos en el programa

Al final de `main` en `App.java`, añade:

```java
        // Semana 05: tus objetos. Cambia la clase y los datos por los de tu dominio.
        Bicycle[] items = {
            new Bicycle(" bk-042 ", "Ficciones", 0),
            new Bicycle("bk-107", "El túnel", 2),
            new Bicycle("BK-311", "Rayuela", 7)
        };
        items[0].restock(3);
        items[1].take();
        for (Bicycle item : items) {
            System.out.println(item.describe() + " (" + item.level(8) + ")");
        }
        System.out.println("Total: " + Bicycle.total(items) + " · BK-311 en la posición "
                + Bicycle.indexOf(items, "bk-311"));
```

Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
BK-042 · Ficciones · disponibles: 3 (normal)
BK-107 · El túnel · disponibles: 1 (bajo)
BK-311 · Rayuela · disponibles: 7 (normal)
Total: 11 · BK-311 en la posición 2
```

Cambia códigos, nombres, cantidades, capacidad y el código buscado por los de tu dominio. Compara este bloque con el de la semana 02 en el mismo `main`: allí, `codes` y `copies` iban por separado y `Stock.report` los recibía a los dos; aquí cada objeto se describe solo.

Los arrays paralelos de semanas anteriores se quedan: sus tests siguen protegiendo esas reglas. En la semana 13 los cambiarás por colecciones de objetos.

### 12. Commit y pull request

```bash
git add .
git commit -m "feat: show Bicycle objects in app"
git push -u origin week-05
```

En GitHub, abre un *pull request* de `week-05` hacia `main`. En la descripción pega:

1. Tu dominio y el nombre de tu clase.
2. La tarjeta CRC de tu entidad en `docs/analisis.md` y, al lado de cada responsabilidad, el método que la cumple ahora, o "pendiente" si todavía no existe.
3. Las dos últimas líneas de `./mvnw test` y la salida de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `class Bicycle is public, should be declared in a file named Bicycle.java` | El nombre del archivo y el de la clase no coinciden: repite la copia del paso 2 con el mismo `CLASS` en las dos líneas |
| `sed: can't read ...Entity.java` | `STARTER` apunta mal: debe terminar en `3-proyecto/starter`, sin `/` final |
| Siguen los 27 errores en `<init>:16` | El constructor aún lanza `UnsupportedOperationException`: borra el `throw` al escribirlo |
| `but was: "null · Ficciones · disponibles: 2"` | Falta `this.` en `this.code = ...`: sin él, asignas al parámetro y el atributo se queda en `null` |
| `NullPointer ... because "items[i].code" is null` en `indexOf` | El mismo problema del constructor: el atributo `code` se quedó en `null` |
| `takeWithoutUnitsFailsAndChangesNothing`: `Expecting code to raise a throwable` | `take()` resta sin comprobar: con 0 unidades debe lanzar la excepción antes de restar |
| `cannot find symbol ... Locale` | Falta `import java.util.Locale;` arriba de tu clase |
| `cannot find symbol ... class Entity` en `MyDomainTest` o `App` | Copiaste el ejemplo sin cambiar `Entity` o `Book` por tu clase |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-05` con tu clase y su test (sin ningún `Entity`), y `./mvnw test` en verde.
- Al menos 3 tests nuevos en `MyDomainTest.java` con objetos de tu clase y datos de tu dominio.
- `App.java` con un array de objetos de tu dominio.
- *Pull request* `week-05` → `main` con la descripción del paso 12.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · De arrays paralelos a objetos](../2-practicas/ejercicio-03-de-arrays-paralelos-a-objetos/README.md) | **Proyecto · Gestión, capa 4** | [Webgrafía](../4-recursos/webgrafia/README.md) |
