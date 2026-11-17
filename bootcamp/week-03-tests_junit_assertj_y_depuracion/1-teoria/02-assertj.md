# 02 · AssertJ: aserciones que se leen

⏱️ 45 min

## 1. La forma

Todas las aserciones de AssertJ empiezan igual:

```java
import static org.assertj.core.api.Assertions.assertThat;

assertThat(valorReal).comprobación(valorEsperado);
```

`assertThat` recibe lo que devolvió tu código; el método que encadenas dice qué esperas de él. El `import static` permite escribir `assertThat` sin anteponer `Assertions.`. Tu editor completa las comprobaciones: escribe `assertThat(x).` y mira la lista.

## 2. Las más usadas

| Sobre | Comprobación | Ejemplo |
|---|---|---|
| Cualquier valor | `isEqualTo`, `isNotEqualTo` | `assertThat(Shelf.free(10, 3)).isEqualTo(7)` |
| | `isNull`, `isNotNull` | `assertThat(titles[2]).isNull()` |
| `boolean` | `isTrue`, `isFalse` | `assertThat(Fine.isValidCode("BK-042")).isTrue()` |
| Números | `isZero`, `isPositive`, `isNegative` | `assertThat(room).isZero()` |
| | `isGreaterThan`, `isBetween(a, b)` | `assertThat(price).isBetween(0.0, 500.0)` |
| `String` | `startsWith`, `endsWith`, `contains` | `assertThat(code).startsWith("BK")` |
| | `hasSize`, `isBlank`, `isEmpty` | `assertThat(code).hasSize(6)` |
| Arrays | `containsExactly` (mismos, mismo orden) | `assertThat(codes).containsExactly("BK-042", "BK-107")` |
| | `contains`, `hasSize`, `isEmpty` | `assertThat(missing).hasSize(3)` |

Se pueden **encadenar** sobre el mismo valor:

```java
assertThat(Shelf.normalize(" bk-042 ")).startsWith("BK").contains("-").hasSize(6);
```

Con arrays, `isEqualTo` compara contenido (AssertJ lo hace por ti), pero `containsExactly` da un mensaje de fallo más útil: dice qué elemento sobra o falta.

## 3. Decimales: con margen

`double` no guarda la mayoría de decimales de forma exacta (semana 01): `1 * 100.0 / 3` es `33.333333333333336`. Compararlo con `isEqualTo(33.33)` falla siempre:

```
expected: 33.33
 but was: 33.333333333333336
```

Para decimales calculados, compara con un margen:

```java
import static org.assertj.core.api.Assertions.within;

assertThat(Shelf.occupancy(3, 1)).isCloseTo(33.33, within(0.01));
```

`within(0.01)` acepta cualquier valor a 0.01 o menos del esperado. Elige el margen según tu dominio: céntimos (`0.001`) para dinero, más amplio para medidas.

## 4. Lanzar una excepción desde tu código

Cuando un método recibe datos imposibles (una ocupación negativa, una cantidad que no es un número), devolver un valor cualquiera esconde el problema. Es mejor **parar** con un mensaje claro:

```java
if (used < 0 || used > capacity) {
    throw new IllegalArgumentException("Ocupación fuera de rango: " + used);
}
```

`throw` corta el método en ese punto, como un `return`, pero en lugar de devolver un valor lanza una **excepción**. `IllegalArgumentException` es la de la biblioteca estándar para "este argumento no vale". Si nadie la captura, el programa termina y muestra el mensaje con su *stack trace* (teoría 04). Capturarlas y crear las tuyas llega en la semana 12; de momento basta con lanzarlas y probarlas.

## 5. Probar que se lanza

```java
import static org.assertj.core.api.Assertions.assertThatThrownBy;

assertThatThrownBy(() -> Shelf.free(10, 12))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Ocupación fuera de rango: 12");
```

La llamada va dentro de `() -> ...`, una **lambda**: un trozo de código que se pasa sin ejecutarlo. Si escribieras `assertThatThrownBy(Shelf.free(10, 12))`, Java tendría que ejecutar `free` antes de entrar en `assertThatThrownBy` y pasarle el `int` que devuelve; por eso no compila: `no suitable method found for assertThatThrownBy(int)`. Con la lambda, AssertJ recibe el código sin ejecutar, lo ejecuta él mismo y captura lo que salga. Las lambdas se estudian a fondo en la semana 15; aquí solo necesitas esta forma.

| Comprobación | Exige |
|---|---|
| `isInstanceOf(X.class)` | Que la excepción sea de tipo `X` |
| `hasMessage("...")` | Que el mensaje sea exactamente ese |
| `hasMessageContaining("...")` | Que el mensaje contenga ese trozo |

Si el código **no** lanza nada, el test falla con `Expecting code to raise a throwable.`

## 6. Leer un mensaje de fallo

AssertJ pone primero lo que esperabas y después lo que salió:

```
[ERROR]   ShelfTest.freeRoom:39 
expected: 3
 but was: 7
```

Léelo así: el test `freeRoom`, en la línea 39 de `ShelfTest.java`, esperaba `3` y el código devolvió `7`. Antes de tocar el código, pregúntate quién se equivoca: **el código o el test**. Calcula el caso a mano. Aquí `free(10, 3)` son 10 huecos menos 3 ocupados: 7. El código acierta y el test está mal.

## ✅ Comprueba que lo entendiste

1. ¿Por qué `assertThat(0.1 + 0.2).isEqualTo(0.3)` falla? ¿Cómo lo escribes para que pase?
2. ¿Por qué no compila `assertThatThrownBy(Shelf.free(10, 12))`, sin `() ->`?
3. Un test dice `expected: "leve" but was: "grave"`. ¿Cuál de los dos valores devolvió tu código?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [01 · Qué es un test](01-que-es-un-test.md) | **02 · AssertJ** | [03 · Tests parametrizados y casos límite](03-tests-parametrizados-y-casos-limite.md) |
