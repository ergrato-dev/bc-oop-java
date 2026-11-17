# Proyecto — Gestión, capa 8: un inventario que elige con cualquier criterio

⏱️ 3 h

## Qué construyes

Tu `Inventory` ya sabe contar las entidades disponibles. Pero mañana querrás las que tienen una palabra en el nombre, las agotadas, las de una talla... y si cada pregunta es un método nuevo en el inventario, el inventario no para de crecer. Esta semana escribes un **contrato**, la interfaz `Criterion`, y le das a tu `Inventory` dos métodos que trabajan con **cualquier** criterio, también con los que todavía no existen.

| Cambio | Qué hace | Dónde |
|---|---|---|
| `interface Criterion` | Declara `accepts(Bicycle item)` sin cuerpo y trae `count(Bicycle[] items)` escrito como método `default` | Interfaz nueva |
| `AvailableCriterion implements Criterion` | Acepta las entidades disponibles, preguntándole a cada una con `isAvailable()` | Clase nueva |
| `NameCriterion implements Criterion` | Guarda un texto y acepta las entidades cuyo nombre lo contiene | Clase nueva |
| `select(Criterion)`, `count(Criterion)` | Las entidades que cumplen el criterio, y cuántas son | Tu `Inventory` |

La regla de la semana: **tu `Inventory` solo conoce `Criterion`**. No escribe `AvailableCriterion` ni `NameCriterion`: recibe un criterio, le pregunta con `accepts` y no sabe cuál le ha llegado. Un test lo comprueba leyendo el código de `Inventory.java`, como el de la semana 08.

El starter trae nueve archivos:

| Archivo | Qué es | Qué haces con él |
|---|---|---|
| `src/test/java/gestion/InventoryTest.java` | Los tests de las semanas 06 y 08 y 5 nuevos | Lo copias **encima** del tuyo |
| `src/test/java/gestion/CriterionTest.java` | 12 tests de la interfaz y de los dos criterios | Lo copias |
| `src/main/java/gestion/Criterion.java` | La interfaz, con `count` sin escribir | Lo copias |
| `src/main/java/gestion/AvailableCriterion.java` y `NameCriterion.java` | Los dos criterios, con los métodos sin escribir | Los copias |
| `src/main/java/gestion/Inventory.java` | La referencia de lo que cambia en tu inventario, marcado con `// SEMANA 09` | **No** lo copias: lo lees |
| `src/main/java/gestion/Entity.java`, `ReservedEntity.java` y `TrackedEntity.java` | Tu clase y tus dos subclases, para que el starter compile | **No** los copias |

## Pasos

### 1. Parte de la semana 08

Tu *pull request* `week-08` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-09
```

### 2. Copia los tests y los criterios

Usa el mismo nombre de clase que en las semanas anteriores (en Windows, desde Git Bash). Los criterios no llevan tu clase en el nombre del archivo, pero sí dentro: `sed` la cambia igual.

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-09-clases_abstractas_e_interfaces/3-proyecto/starter
CLASS=Bicycle
for f in test/java/gestion/InventoryTest test/java/gestion/CriterionTest main/java/gestion/Criterion main/java/gestion/AvailableCriterion main/java/gestion/NameCriterion; do
  sed "s/Entity/$CLASS/g" $STARTER/src/$f.java > src/$f.java
done
git status --short
```

Debes ver un archivo cambiado y cuatro nuevos:

```
 M src/test/java/gestion/InventoryTest.java
?? src/main/java/gestion/AvailableCriterion.java
?? src/main/java/gestion/Criterion.java
?? src/main/java/gestion/NameCriterion.java
?? src/test/java/gestion/CriterionTest.java
```

Comprueba que no queda ningún `Entity`:

```bash
grep -c Entity src/test/java/gestion/InventoryTest.java src/test/java/gestion/CriterionTest.java src/main/java/gestion/*Criterion.java
```

Esperado: `:0` al final de las cinco líneas. Haz un commit antes de tocar nada:

```bash
git add src/test/java/gestion/InventoryTest.java src/test/java/gestion/CriterionTest.java src/main/java/gestion/*Criterion.java
git commit -m "test: add criterion tests with starter"
```

En el resto del README, donde ponga `Bicycle`, usa tu clase.

### 3. Rojo: no compila

```bash
./mvnw test
```

Entre las primeras líneas:

```
[ERROR] /.../src/test/java/gestion/InventoryTest.java:[203,29] cannot find symbol
  symbol:   method select(gestion.AvailableCriterion)
  location: variable inventory of type gestion.Inventory
```

Los tests llaman a dos métodos que tu `Inventory` todavía no tiene. Los criterios sí compilan: el starter ya trae sus métodos, aunque solo lanzan `UnsupportedOperationException`.

### 4. Dos métodos que reciben un `Criterion`

Abre el `Inventory.java` del starter **al lado** del tuyo y busca el comentario `// SEMANA 09`. Añade a tu `Inventory`, encima de `items()`:

1. `select(Criterion criterion)`: crea un array `Bicycle[] found = new Bicycle[size]` y un contador. Recorre `items()` y, si `criterion.accepts(item)`, guarda `item` en `found[count]` y suma uno al contador. Devuelve `Arrays.copyOf(found, count)`, sin las posiciones vacías, como hace `items()`.
2. `count(Criterion criterion)`: `return criterion.count(items());`. Cuenta el criterio, no el inventario.

El parámetro es de tipo `Criterion`, una interfaz. Nunca existe un objeto "solo `Criterion`": lo que llega es un `AvailableCriterion`, un `NameCriterion` o cualquier otra clase que lo implemente, y `accepts` ejecuta la versión de ese objeto.

```bash
./mvnw test -Dtest=InventoryTest
```

Esperado: `Tests run: 25, Failures: 0, Errors: 4`. Los cuatro errores son de tests nuevos y dicen `UnsupportedOperation Por escribir`: los criterios todavía no están escritos. Haz un commit: `feat: add select and count by criterion`.

### 5. `count`, un método con cuerpo dentro de la interfaz

Abre `Criterion.java`. `accepts` no tiene cuerpo: termina en `;` y cada criterio escribe el suyo. `count` es distinto: lleva `default` delante y tiene cuerpo, así que lo heredan todas las clases que implementen `Criterion`.

Escribe el cuerpo de `count`: recorre `items` y cuenta las entidades para las que `accepts(item)` es `true`. Ese `accepts` es el del objeto: en un `NameCriterion`, el que busca el texto.

```bash
./mvnw test -Dtest=CriterionTest
```

Esperado: `Tests run: 12, Failures: 1, Errors: 6`. Los errores son de los criterios, todavía sin escribir; el fallo, de `nameRejectsAnEmptyQueryWhenCreated`.

### 6. El criterio de las disponibles

Abre `AvailableCriterion.java`. Fíjate en la cabecera: `implements Criterion`, no `extends`. Escribe `accepts`: `return item.isAvailable();`. Nada más: `count` ya lo tiene, heredado de la interfaz.

```bash
./mvnw test -Dtest=CriterionTest
```

Esperado: `Tests run: 12, Failures: 1, Errors: 3`. Quedan los de `NameCriterion`.

### 7. El criterio del nombre

Abre `NameCriterion.java`. Este criterio tiene un dato propio, el texto que busca, en `private final String query`. Escribe:

1. El constructor: si `query` es `null` o está en blanco, lanza `IllegalArgumentException` con el mensaje `"Búsqueda vacía"`; si no, guárdalo en `this.query`.
2. `accepts`: `return item.matches(query);`. Tu clase ya sabe buscar en su nombre desde la semana 06.

```bash
./mvnw test -Dtest=CriterionTest
```

Esperado: `Tests run: 12, Failures: 0, Errors: 0`. Fíjate en `anyNewCriterionInheritsCount`: escribe un criterio nuevo dentro del propio test, con solo `accepts`, y `count` le funciona sin escribirlo. Haz un commit: `feat: add available and name criteria`.

### 8. Todo en verde

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con `Failures: 0, Errors: 0` y al menos 232 tests: los tuyos de las semanas 01 a 08 (al menos 215) y los 17 nuevos.

### 9. Compara con la referencia

Abre otra vez el `Inventory.java` del starter: tu inventario debe tener los dos métodos que marca `// SEMANA 09`. Busca en tu `Inventory.java` las palabras `AvailableCriterion` y `NameCriterion`: no debe aparecer ninguna. Si alguna aparece, el test `theInventoryOnlyKnowsTheInterface` ya te lo habrá dicho.

### 10. Tus reglas, en tests

En `MyDomainTest.java`, debajo de los de semanas anteriores, escribe **al menos 3 tests** con datos de tu dominio:

1. Uno con `select(new NameCriterion(...))` que encuentre varias entidades de tu dominio.
2. Uno con `AvailableCriterion` en un `Inventory` que tenga una de tus subclases con reserva.
3. Uno con **un criterio tuyo**: una clase que implemente `Criterion`, escrita dentro del test, con una regla de tu dominio (las agotadas, las de un código concreto, las que tienen muchas unidades).

Por ejemplo, el tercero en la Biblioteca:

```java
@Test
void aLibraryCriterionOfMyOwn() {
    class OutOfStock implements Criterion {
        @Override
        public boolean accepts(Book item) {
            return item.getQuantity() == 0;
        }
    }
    TrackedBook lent = new TrackedBook("BK-777", "El nombre de la rosa", 1);
    lent.take();
    Inventory catalog = new Inventory(2);
    catalog.add(lent);
    catalog.add(new Book("BK-778", "Pedro Páramo", 1));
    assertThat(catalog.select(new OutOfStock())).containsExactly(lent);
}
```

Una clase escrita dentro de un método es una **clase local**: solo existe dentro de ese método. Tu `Inventory` no la conoce y la usa igual.

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 235 tests.

### 11. Los criterios en el programa

Al final de `main` en `App.java`, debajo del bloque de la semana 08, añade:

```java
        // Semana 09: el inventario elige con cualquier Criterion, sin saber cuál le llega.
        Bicycle[] found = shelf.select(new NameCriterion("la"));
        System.out.println("Con \"la\" en el nombre: " + found.length);
        for (Bicycle item : found) {
            System.out.println("  " + item);
        }
        System.out.println("Disponibles según el criterio: " + shelf.count(new AvailableCriterion()));
```

Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
Con "la" en el nombre: 2
  BK-120 · La tregua · disponibles: 1
  BK-300 · Kafka en la orilla · disponibles: 0 · salidas: 1
Disponibles según el criterio: 1
```

Cambia el texto que buscas por uno que tenga sentido con los nombres de tu dominio. La última línea debe dar lo mismo que el `Disponibles` de la semana 08: los dos preguntan a cada objeto con `isAvailable()`.

### 12. Commit y pull request

```bash
git add .
git commit -m "feat: show criteria in app"
git push -u origin week-09
```

En GitHub, abre un *pull request* de `week-09` hacia `main`. En la descripción pega:

1. Tu dominio y el criterio propio del paso 10: qué regla de tu dominio expresa.
2. Una frase: ¿por qué `Criterion` es una interfaz y no una clase abstracta? Piensa en qué datos tendría en común.
3. Por qué tu `Inventory` no necesita cambiar para usar tu criterio propio.
4. Las dos últimas líneas de `./mvnw test` y las cuatro últimas de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol` con `symbol: method select(...)` o `count(...)` | Es el rojo del paso 3: añade los dos métodos del paso 4 a tu `Inventory` |
| `theInventoryOnlyKnowsTheInterface`: `[Inventory trabaja con Criterion, no con criterios concretos]` | Tu `Inventory` escribe `AvailableCriterion` o `NameCriterion`: recibe un `Criterion` y llama a `accepts` o a `count` |
| `no interface expected here` | Escribiste `extends Criterion`: una clase **implementa** una interfaz, `implements Criterion` |
| `interface abstract methods cannot have body` | Quitaste el `default` de `count`: sin él, un método de interfaz no puede tener cuerpo |
| `AvailableCriterion is not abstract and does not override abstract method accepts(...)` | El nombre o el parámetro de tu `accepts` no coinciden con los de la interfaz: debe ser `accepts(Bicycle item)` |
| `accepts(...) in AvailableCriterion cannot implement accepts(...) in Criterion` y `attempting to assign weaker access privileges; was public` | Falta `public` delante de `accepts`: los métodos de una interfaz son públicos, y la clase no puede hacerlos menos visibles |
| `Criterion is abstract; cannot be instantiated` | Escribiste `new Criterion()`: crea un `new AvailableCriterion()` o un `new NameCriterion("...")` |
| `nameOnlyDeclaresThePrivateFinalQuery`: `[el texto no cambia después de crear el criterio: final]` | Declara `query` como `private final String query` |
| `nameRejectsAnEmptyQueryWhenCreated` falla | La comprobación de `query` va en el constructor, antes de guardarlo: el criterio no debe poder crearse con una búsqueda vacía |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-09` con `Criterion`, `AvailableCriterion`, `NameCriterion` y sus tests, `select` y `count` en tu `Inventory`, y `./mvnw test` en verde.
- Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio, uno de ellos con un criterio propio.
- `App.java` con el bloque de los criterios.
- *Pull request* `week-09` → `main` con la descripción del paso 12.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · Métodos `default` y `static`](../2-practicas/ejercicio-03-metodos-default-y-static/README.md) | **Proyecto · Gestión, capa 8** | [Webgrafía](../4-recursos/webgrafia/README.md) |
