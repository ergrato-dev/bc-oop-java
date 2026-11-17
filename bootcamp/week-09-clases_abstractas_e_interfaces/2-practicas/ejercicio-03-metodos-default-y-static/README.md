# Ejercicio 03 — Métodos `default` y `static`

⏱️ 1 h 30 min · Teoría previa: [04](../../1-teoria/04-metodos-default-y-static.md)

## Objetivo

Escribir código **dentro** de una interfaz sin romper el contrato: un método `default` que heredan todas las clases que la implementan (y que pueden sobrescribir), y un método `static` que pertenece a la interfaz. Al final ves qué pasa cuando una clase hereda dos `default` con el mismo nombre y cómo elegir. Es la interfaz `Criterion` de tu proyecto, en pequeño. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-09-clases_abstractas_e_interfaces/2-practicas/ejercicio-03-metodos-default-y-static/starter
java Main.java
```

No imprime nada. `main` ya crea una estantería de tres libros (uno sin ejemplares). Debajo de `Main` están:

- `interface Criterion`: `accepts` sin cuerpo; `count` y `label` con `default`; `any` con `static`.
- `AvailableCriterion` y `NameCriterion`, que solo escriben `accepts`.
- Dos interfaces pequeñas, `Loanable` y `Sellable`, cada una con un `default String label()`.

Los números de línea de este README cuentan con que no añades ni quitas líneas, salvo donde el paso 5 te pide añadirlas.

## Pasos

### 1. Un método `default`, escrito una vez y heredado por todos

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
Disponibles: 2
Con rayuela: 2
```

Ni `AvailableCriterion` ni `NameCriterion` escriben `count`, y los dos lo tienen: lo heredan de la interfaz, porque lleva `default` y tiene cuerpo. Dentro de `count`, `accepts(book)` es el del objeto: un mismo bucle cuenta disponibles o nombres según el criterio que lo ejecuta.

### 2. Una clase puede sobrescribir el `default`

Descomenta el método `label()` de `NameCriterion` (líneas 120 a 123) y las líneas del **PASO 2** en `main`. Ejecuta. Las dos últimas líneas:

```
un criterio
nombre con "rayuela"
```

`AvailableCriterion` no escribe `label()` y usa el de la interfaz. `NameCriterion` lo sobrescribe, como sobrescribirías un método heredado de una clase. Un `default` es una respuesta **por defecto**, no una obligación.

### 3. Un método `static` de la interfaz se llama con su nombre

Descomenta la línea del **PASO 3** y ejecuta. La última línea:

```
¿Alguno disponible? true
```

`any` es `static` (línea 93): pertenece a `Criterion`, no a cada criterio, y se llama como `Criterion.any(...)`. Recibe el criterio como parámetro. Es el sitio natural para utilidades que trabajan con cualquier criterio.

### 4. Y no a través de una variable

Descomenta la línea del **PASO 4** y ejecuta:

```
Main.java:39: error: illegal static interface method call
        IO.println(available.any(available, shelf));
                                ^
  the receiver expression should be replaced with the type qualifier 'Criterion'
```

Con una clase, Java te dejaba llamar a un `static` a través de una variable (lo viste con `chronicle.origin()` en la semana 08). Con una interfaz, no: el `static` de una interfaz solo se llama con el nombre de la interfaz, y ninguna clase que la implemente lo hereda. El propio mensaje te dice el arreglo. Vuelve a comentar la línea 39.

### 5. Dos `default` con el mismo nombre

Descomenta la clase `Duplicate`, al final del archivo (líneas 139 y 140), y la línea del **PASO 5** en `main`. Ejecuta:

```
Main.java:139: error: types Loanable and Sellable are incompatible;
class Duplicate implements Loanable, Sellable {
^
  class Duplicate inherits unrelated defaults for label() from types Loanable and Sellable
```

Un duplicado de la biblioteca se puede prestar y también vender. Las dos interfaces traen un `label()` con cuerpo, y Java no elige por ti cuál hereda la clase. La clase tiene que escribir el suyo. Dentro de `Duplicate`, entre las dos líneas, escribe:

```java
    @Override
    public String label() {
        return Loanable.super.label() + " y " + Sellable.super.label();
    }
```

`Loanable.super.label()` llama al `default` de `Loanable`, como `super.describe()` llamaba al método del padre. Ejecuta. La última línea:

```
BK-900: se presta y se vende
```

Con clases este problema no existe: una clase solo tiene un padre. Con interfaces sí puede pasar, y la regla es simple: si hay duda, la clase escribe el método.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `illegal static interface method call` | Es la prueba del paso 4: vuelve a comentar la línea 39 |
| `class Duplicate inherits unrelated defaults for label()` | Es el error del paso 5: escribe `label()` dentro de `Duplicate` |
| `cannot find symbol ... variable available` | Descomentaste un paso sin el 1: el paso 1 declara `available` y `rayuela` |
| `label() in Duplicate cannot implement label() in Loanable` y `attempting to assign weaker access privileges; was public` | Falta `public` delante de `String label()` en `Duplicate` |
| `not an enclosing class: Loanable` | Escribiste `Loanable.super.label()` en una clase que no dice `implements Loanable` |
| `interface abstract methods cannot have body` | Borraste `default` de un método con cuerpo de la interfaz |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Interfaces](../ejercicio-02-interfaces/README.md) | **Ejercicio 03 · Métodos `default` y `static`** | [Proyecto · Gestión, capa 8](../../3-proyecto/README.md) |
