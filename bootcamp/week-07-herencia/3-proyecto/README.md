# Proyecto — Gestión, capa 6: una subclase con reserva

⏱️ 3 h

## Qué construyes

Tu clase de la semana 06 (`Bicycle` en el servicio de bicicletas) se protege sola y vive en un `Inventory`. Esta semana le das una **subclase**: una variante de tu entidad que guarda una **reserva**, unas últimas unidades que no se sacan nunca. En la Biblioteca es el ejemplar de consulta que no sale de la sala; en una farmacia, el stock mínimo de un medicamento crítico; en tu dominio, lo que tenga sentido (la bicicleta de repuesto del taller, la habitación que el hotel no vende).

| Cambio | Qué hace | Dónde |
|---|---|---|
| `toString()` | Sobrescribe el de `Object` y devuelve `describe()`: `println(item)` muestra la descripción | Tu clase |
| `ReservedBicycle extends Bicycle` | Hereda código, nombre, unidades y métodos; declara solo `reserve` | Clase nueva |
| Constructor con `super(...)` | Comprueba la reserva y deja que tu constructor valide el resto | Clase nueva |
| `isAvailable`, `take`, `describe` | Sobrescritos con `@Override`: tienen en cuenta la reserva y reutilizan los de tu clase con `super` | Clase nueva |

No escribes nada en `Inventory`: una `ReservedBicycle` **es** una `Bicycle`, así que cabe en el inventario, y `inventory.take(code)` ejecuta el `take()` sobrescrito sin saberlo.

El starter trae cinco archivos:

| Archivo | Qué es | Qué haces con él |
|---|---|---|
| `src/test/java/gestion/EntityTest.java` | Los 41 tests de la semana 06 y 2 nuevos | Lo copias **encima** de tu test de la semana 06 |
| `src/test/java/gestion/ReservedEntityTest.java` | 17 tests de la subclase | Lo copias |
| `src/main/java/gestion/ReservedEntity.java` | La subclase, con los métodos sin escribir | Lo copias |
| `src/main/java/gestion/Entity.java` | La referencia de lo que cambia en tu clase, marcado con `// SEMANA 07` | **No** lo copias: lo lees |
| `src/main/java/gestion/Inventory.java` | El inventario de la semana 06, para que el starter compile | **No** lo copias: ya tienes el tuyo |

## Pasos

### 1. Parte de la semana 06

Tu *pull request* `week-06` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-07
```

### 2. Copia los tests y la subclase

Usa el mismo nombre de clase que en la semana 06 (en Windows, desde Git Bash):

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-07-herencia/3-proyecto/starter
CLASS=Bicycle
sed "s/Entity/$CLASS/g" $STARTER/src/test/java/gestion/EntityTest.java > src/test/java/gestion/${CLASS}Test.java
sed "s/Entity/$CLASS/g" $STARTER/src/test/java/gestion/ReservedEntityTest.java > src/test/java/gestion/Reserved${CLASS}Test.java
sed "s/Entity/$CLASS/g" $STARTER/src/main/java/gestion/ReservedEntity.java > src/main/java/gestion/Reserved${CLASS}.java
git status --short
```

Debes ver un archivo cambiado y dos nuevos:

```
 M src/test/java/gestion/BicycleTest.java
?? src/main/java/gestion/ReservedBicycle.java
?? src/test/java/gestion/ReservedBicycleTest.java
```

Comprueba que no queda ningún `Entity`:

```bash
grep -c Entity src/test/java/gestion/${CLASS}Test.java src/test/java/gestion/Reserved${CLASS}Test.java src/main/java/gestion/Reserved${CLASS}.java
```

Esperado: `:0` al final de las tres líneas. Haz un commit antes de tocar nada:

```bash
git add src/test/java/gestion/${CLASS}Test.java src/test/java/gestion/Reserved${CLASS}Test.java src/main/java/gestion/Reserved${CLASS}.java
git commit -m "test: add inheritance tests with starter"
```

En el resto del README, donde ponga `Bicycle`, usa tu clase.

### 3. Rojo

```bash
./mvnw test
```

Esta vez compila: `ReservedBicycle` ya existe, con `extends Bicycle` y una llamada a tu constructor de tres parámetros. La última línea de resumen:

```
[ERROR] Tests run: <tus tests + 19>, Failures: 3, Errors: 11, Skipped: 0
```

Entre los fallos verás este, que es el primero que vas a arreglar:

```
[ERROR] gestion.BicycleTest.toStringReturnsDescribe -- Time elapsed: 0.001 s <<< FAILURE!
org.opentest4j.AssertionFailedError: 

expected: "BK-042 · Ficciones · disponibles: 2"
 but was: "gestion.Bicycle@2f94c4db"
```

Tu clase no tiene `toString()`, así que usa el que hereda de `Object`: el nombre de la clase, una `@` y un número (el tuyo será otro). Los 11 errores son de `ReservedBicycleTest` y dicen `UnsupportedOperation Por escribir`.

### 4. `toString()` en tu clase

Abre el `Entity.java` del starter **al lado** de tu `Bicycle.java` y busca el comentario `// SEMANA 07`. Añade a tu clase, debajo de `describe()`:

```java
    @Override
    public String toString() {
        return describe();
    }
```

Es tu primera **sobrescritura**: `Bicycle` hereda `toString()` de `Object` y le da otro cuerpo. Va `public` porque en `Object` es `public`, y `@Override` le pide al compilador que compruebe que de verdad sobrescribe algo.

```bash
./mvnw test -Dtest=BicycleTest
```

Esperado: `Tests run: 43, Failures: 0, Errors: 0`. Haz un commit: `feat: add Bicycle toString`.

### 5. La subclase: constructor y *getter*

Abre `ReservedBicycle.java`. Tiene un atributo `private final int reserve` (el único que declara: el código, el nombre y las unidades los hereda) y sus métodos sin escribir. Empieza por el constructor:

1. **Antes** de `super(code, name, quantity);`: si `reserve` es negativo, lanza `new IllegalArgumentException("Reserva no válida: " + reserve)`. Desde Java 25 se puede comprobar antes de `super(...)`, siempre que no uses el objeto (ni `this` ni sus métodos): así, si la reserva no vale, ni siquiera se crea la parte de `Bicycle`.
2. Deja `super(code, name, quantity);`: es tu constructor de la semana 06, que normaliza y valida el código, el nombre y las unidades. **No copies sus comprobaciones**: ya las hace él.
3. **Después** de `super(...)`, cambia el `throw` por `this.reserve = reserve;`.

Y `getReserve()`: devuelve `reserve`.

```bash
./mvnw test -Dtest=ReservedBicycleTest
```

Esperado: `Tests run: 17, Failures: 1, Errors: 8`. Ya pasan los tests de la clase y los del constructor, incluidos `theParentConstructorStillValidatesTheCode` y `...TheQuantity`: tu constructor valida por los dos.

### 6. Sobrescribe lo que cambia con la reserva

Cada método ya lleva su `@Override`. Escríbelos en este orden:

1. `describe()`: `return super.describe() + " · reserva: " + reserve;`. Con `super.describe()` reutilizas el de tu clase; sin `super.`, el método se llamaría a sí mismo hasta `StackOverflowError`.
2. `isAvailable()`: `true` si `getQuantity() > reserve`. Usa `getQuantity()`: `quantity` es `private` en tu clase, y `ReservedBicycle` no puede tocarlo.
3. `take()`: si quedan unidades (`getQuantity() > 0`) pero son la reserva (`getQuantity() <= reserve`), lanza `new IllegalStateException("Solo queda la reserva de " + getCode())`. Si no, `super.take();`, que resta la unidad o, si no queda ninguna, lanza **la misma excepción que siempre**. Así una `ReservedBicycle` sin unidades falla igual que una `Bicycle`, y quien la reciba como `Bicycle` no se lleva sorpresas.

No sobrescribas `restock`, `matches`, `level` ni `toString`: los heredados ya hacen lo correcto. `toString()` llama a `describe()`, y en una `ReservedBicycle` ese `describe()` es el tuyo, con la reserva.

```bash
./mvnw test -Dtest=ReservedBicycleTest
```

Esperado: `Tests run: 17, Failures: 0, Errors: 0`. Haz un commit: `feat: add ReservedBicycle`.

### 7. Todo en verde

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con `Failures: 0, Errors: 0` y al menos 191 tests: los tuyos de las semanas 01 a 06 (al menos 172) y los 19 nuevos. Fíjate en `theInventoryDelegatesToTheOverride`: tu `Inventory` no cambió una línea y ya respeta la reserva, porque llama a `take()` y el objeto decide qué `take()` se ejecuta.

### 8. Compara con la referencia

Abre otra vez el `Entity.java` del starter: tu clase debe tener el `toString()` que marca `// SEMANA 07`. En `ReservedBicycle.java`, borra los comentarios del starter que ya no son verdad, como `// Paso 5: comprueba reserve antes de super(...).`

### 9. Tus reglas, en tests

En `MyDomainTest.java`, debajo de los de semanas anteriores, escribe **al menos 3 tests** con datos de tu dominio:

1. Uno en el que tu `ReservedBicycle` se niegue a sacar la reserva, con un caso real de tu dominio.
2. Uno que guarde una `ReservedBicycle` en una variable `Bicycle` y compruebe su `toString()`.
3. Uno con un `Inventory` que tenga una `ReservedBicycle` y use `take`.

Por ejemplo:

```java
@Test
void theReadingRoomCopyIsNeverLent() {
    ReservedBook atlas = new ReservedBook("BK-900", "Atlas universal", 1, 1);
    assertThatThrownBy(atlas::take).hasMessage("Solo queda la reserva de BK-900");
}
```

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 194 tests.

### 10. La subclase en el programa

Al final de `main` en `App.java`, debajo del bloque de la semana 06 (usa su `inventory`, en el que queda un hueco), añade:

```java
        // Semana 07: una subclase con reserva cabe donde cabe tu clase.
        inventory.add(new ReservedBicycle("BK-900", "Atlas universal", 2, 1));
        inventory.take("BK-900");
        try {
            inventory.take("BK-900");
        } catch (IllegalStateException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }
        System.out.println(inventory.find("BK-900"));
        System.out.println(inventory.find("BK-042"));
```

Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
Rechazado: Solo queda la reserva de BK-900
BK-900 · Atlas universal · disponibles: 1 · reserva: 1
BK-042 · Ficciones · disponibles: 3
```

Cambia códigos, nombres y cantidades por los de tu dominio. Las dos últimas líneas pasan objetos a `println` sin llamar a `describe()`: lo hace tu `toString()`. Y cada objeto usa **su** `describe()`: con reserva el de la subclase, sin ella el de tu clase.

### 11. Commit y pull request

```bash
git add .
git commit -m "feat: show ReservedBicycle in app"
git push -u origin week-07
```

En GitHub, abre un *pull request* de `week-07` hacia `main`. En la descripción pega:

1. Tu dominio, el nombre de tu clase y qué es la reserva en tu dominio, con un ejemplo.
2. Una frase: por qué `ReservedBicycle` **es una** `Bicycle` (herencia) y no **tiene una** (composición).
3. Qué hereda tu subclase sin cambiarlo y qué sobrescribe, y por qué `take()` llama a `super.take()`.
4. Las dos últimas líneas de `./mvnw test` y las tres últimas de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `toStringReturnsDescribe`: `but was: "gestion.Bicycle@..."` | Es el rojo del paso 3: añade el `toString()` del paso 4 |
| `toString() in gestion.Bicycle cannot override toString() in java.lang.Object` con `attempting to assign weaker access privileges; was public` | Falta `public` delante de `toString()` |
| `method does not override or implement a method from a supertype` | El método con `@Override` no se llama igual que el de tu clase o tiene otros parámetros: revisa el nombre (`isAvailable`, no `isAvaliable`) |
| `quantity has private access in gestion.Bicycle` | `ReservedBicycle` usa el atributo de tu clase: usa `getQuantity()` |
| `cannot inherit from final gestion.Bicycle` | Tu clase es `final`: quítale el `final` a la clase (los atributos sí lo llevan) |
| `onlyDeclaresThePrivateFinalReserve`: `Expected size: 1` | `ReservedBicycle` declara otra vez `code`, `name` o `quantity`: bórralos, los hereda |
| `java.lang.StackOverflowError` en `ReservedBicycle.describe` | Escribiste `describe()` en lugar de `super.describe()` |
| `withoutUnitsTakeFailsLikeTheParent`: `Expecting message ... "No quedan unidades de BK-042"` | Tu `take()` lanza el mensaje de la reserva también sin unidades: comprueba `getQuantity() > 0` y deja que `super.take()` lance el suyo |
| `takeStopsAtTheReserve`: la cantidad es `0` | Tu `take()` llama a `super.take()` antes de comprobar la reserva: primero la comprobación |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-07` con el `toString()` de tu clase, `ReservedBicycle` y sus tests, y `./mvnw test` en verde.
- Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio.
- `App.java` con una `ReservedBicycle` en el inventario.
- *Pull request* `week-07` → `main` con la descripción del paso 11.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · `protected`, `final` y cuándo no heredar](../2-practicas/ejercicio-03-protected-final-y-cuando-no-heredar/README.md) | **Proyecto · Gestión, capa 6** | [Webgrafía](../4-recursos/webgrafia/README.md) |
