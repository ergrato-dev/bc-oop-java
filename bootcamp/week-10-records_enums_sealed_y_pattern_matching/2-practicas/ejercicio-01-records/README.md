# Ejercicio 01 — Records

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-records.md)

## Objetivo

Comparar una clase de datos escrita a mano con un **record** que lleva los mismos datos en una sola línea. Ves lo que Java escribe por ti (los accesos, `toString` y `equals`), lo que un record no deja hacer (cambiar un componente, llamar a un *getter*) y cómo validar con un constructor compacto. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-10-records_enums_sealed_y_pattern_matching/2-practicas/ejercicio-01-records/starter
java Main.java
```

No imprime nada. Lee las dos piezas de debajo de `Main`:

- `LoanCard`: un préstamo escrito a mano. Tres atributos `private final`, un constructor y tres *getters*: veinte líneas.
- `record Loan(String code, String member, int days)`: el mismo préstamo como record, con un constructor compacto comentado y un método `extended`.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Una clase de datos escrita a mano

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042 para Ana
LoanCard@25b485ba
false
```

Los números después de `@` cambian en cada ejecución. `a` y `b` tienen los mismos datos, pero `println` no los muestra y `equals` dice `false`: `LoanCard` no sobrescribe `toString` ni `equals`, así que usa los de `Object`, que solo saben si es **el mismo objeto**. Para arreglarlo habría que escribir dos métodos más.

### 2. El mismo dato, como record

Descomenta el **PASO 2** y ejecuta. Las tres últimas líneas:

```
BK-042 para Ana
Loan[code=BK-042, member=Ana, days=14]
true
```

`Loan` no tiene ni una línea dentro para eso, y tiene todo: un método por componente, que se llama **como el componente** (`code()`, no `getCode()`), un `toString` que muestra los datos y un `equals` que compara los datos. Dos records con los mismos componentes son iguales.

### 3. Los componentes no cambian

Descomenta la línea del **PASO 3** y ejecuta:

```
Main.java:30: error: days has private access in Loan
        first.days = 21;
             ^
```

Los componentes de un record son atributos `private final`, y el record no trae ningún `setDays`. Un `Loan` no cambia después de crearse, como el código de tu clase. Vuelve a comentar la línea 30.

### 4. Un record no tiene getters

Descomenta la línea del **PASO 4** y ejecuta:

```
Main.java:36: error: cannot find symbol
        IO.println(first.getCode());
                        ^
  symbol:   method getCode()
  location: variable first of type Loan
```

La costumbre de `getCode()` viene de tus clases. En un record, el acceso lleva el nombre exacto del componente: `first.code()`. Vuelve a comentar la línea 36.

### 5. Un constructor compacto que valida

Descomenta las líneas del **PASO 5** en `main` y ejecuta. No sale `Rechazado`: el record acepta un préstamo de 0 días sin quejarse.

Ahora descomenta el constructor compacto de `Loan` (líneas 90 a 94) y ejecuta. La última línea:

```
Rechazado: Días no válidos: 0
```

`Loan {` no lleva paréntesis ni asigna nada: recibe los mismos parámetros que el record, los comprueba y, si nada falla, Java los asigna al final. Es la misma regla del constructor de tu clase en la semana 06: un objeto mal construido no llega a existir.

### 6. Cambiar un record es crear otro

Descomenta el **PASO 6** y ejecuta. Las dos últimas líneas:

```
Loan[code=BK-042, member=Ana, days=21]
Loan[code=BK-042, member=Ana, days=14]
```

`extended(7)` no cambia `first`: devuelve un `Loan` nuevo con 21 días. `first` sigue con 14. Un record puede tener métodos propios, pero ninguno puede cambiarlo.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `days has private access in Loan` | Es la prueba del paso 3: vuelve a comentar la línea 30 |
| `cannot find symbol ... method getCode() ... location: variable first of type Loan` | Es la prueba del paso 4: vuelve a comentar la línea 36 |
| `cannot find symbol ... variable first` | Descomentaste un paso sin el 2: el paso 2 declara `first` y `second` |
| Después del paso 5 no sale `Rechazado` | Te falta descomentar el constructor compacto de `Loan` (líneas 90 a 94) |
| `constructor is not canonical, so it must invoke another constructor of class Loan` | Escribiste `Loan() {` con paréntesis: el constructor compacto es `Loan {` |
| `cannot assign a value to final variable days` | Escribiste `this.days = ...` dentro del constructor compacto: ahí solo se valida, Java asigna al final |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · Polimorfismo o pattern matching](../../1-teoria/05-polimorfismo-o-pattern-matching.md) | **Ejercicio 01 · Records** | [Ejercicio 02 · Enums](../ejercicio-02-enums/README.md) |
