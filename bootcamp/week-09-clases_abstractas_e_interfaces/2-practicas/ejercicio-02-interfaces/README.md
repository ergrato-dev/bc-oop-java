# Ejercicio 02 — Interfaces

⏱️ 2 h · Teoría previa: [03](../../1-teoria/03-interfaces.md)

## Objetivo

Usar una interfaz como **contrato**: un libro y un portátil no tienen nada en común salvo que la biblioteca los presta, y una sola interfaz deja tratarlos igual. Ves que la variable de tipo interfaz solo deja llamar a lo que el contrato promete, que una clase puede firmar varios contratos y que el compilador no deja pasar una clase que no firmó el que se le pide. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-09-clases_abstractas_e_interfaces/2-practicas/ejercicio-02-interfaces/starter
java Main.java
```

No imprime nada. Lee las piezas de debajo de `Main`:

- Dos interfaces: `Loanable` (`code()` y `loanDays()`) y `Searchable` (`matches(text)`). Sus métodos no tienen cuerpo.
- `Book implements Loanable, Searchable`: firma los dos contratos.
- `Laptop implements Loanable`: solo el de préstamo. No hereda de `Book` ni `Book` de él.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Dos clases sin parentesco, un mismo contrato

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-042: 14 días
PC-003: 2 días
```

El array es de `Loanable`, una interfaz, y tiene un libro y un portátil. Las dos clases no comparten padre (las dos heredan directamente de `Object`), pero las dos **implementan** `Loanable`, y eso basta para meterlas en el mismo array y recorrerlas con un solo bucle. Cada una responde con su `loanDays()`, como en la semana 08.

### 2. La variable decide qué se puede llamar

Descomenta la línea del **PASO 2** y ejecuta:

```
Main.java:22: error: cannot find symbol
        IO.println(desk[0].author());
                          ^
  symbol:   method author()
  location: interface Loanable
```

`desk[0]` es un `Book`, y `Book` tiene `author()`. Pero la variable es `Loanable`, y el compilador solo deja llamar a lo que **promete el contrato**: `code()` y `loanDays()`. Es la misma regla del tipo estático de la semana 08, ahora con una interfaz. Vuelve a comentar la línea 22.

### 3. Una clase, dos contratos

Descomenta el **PASO 3** y ejecuta. Las dos últimas líneas:

```
cortázar: encontrado
borges: no encontrado
```

`find` recibe un `Searchable`. `Book` lo es, porque su cabecera dice `implements Loanable, Searchable`. Una clase solo puede heredar (`extends`) de **una** clase, pero puede implementar **varias** interfaces. El mismo `rayuela` cabe en una variable `Loanable`, en una `Searchable` o en una `Book`; en cada una, el compilador te deja llamar a métodos distintos.

### 4. Un contrato que la clase no firmó

Descomenta la línea del **PASO 4** y ejecuta:

```
Main.java:36: error: method find in class Main cannot be applied to given types;
        IO.println(find(new Laptop("PC-004", "Portátil del aula 3"), "aula"));
                   ^
  required: Searchable,String
  found:    Laptop,String
  reason: argument mismatch; Laptop cannot be converted to Searchable
```

`Laptop` no dice `implements Searchable`, así que no lo es. Da igual que tuviera un método `matches`: lo que cuenta es el contrato firmado en la cabecera. Vuelve a comentar la línea 36.

### 5. Los métodos de una interfaz son `public`

Descomenta la clase `Projector`, al final del archivo (líneas 121 a 134), y la línea del **PASO 5** en `main`. Ejecuta:

```
Main.java:131: error: loanDays() in Projector cannot implement loanDays() in Loanable
    int loanDays() {
        ^
  attempting to assign weaker access privileges; was public
```

En `Loanable`, `int loanDays();` no lleva `public`, pero lo es: los métodos de una interfaz son `public` aunque no lo escribas. La clase que lo implementa no puede hacerlo menos visible. Añade `public` delante de `int loanDays()` en la línea 131 y ejecuta. La última línea:

```
PR-001: 3 días
```

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `cannot find symbol ... method author() ... location: interface Loanable` | Es la prueba del paso 2: vuelve a comentar la línea 22 |
| `Laptop cannot be converted to Searchable` | Es la prueba del paso 4: vuelve a comentar la línea 36 |
| `attempting to assign weaker access privileges; was public` | Es el error del paso 5: añade `public` delante de `int loanDays()` en `Projector` |
| `cannot find symbol ... class Projector` | Descomentaste la línea del paso 5 sin la clase `Projector` del final del archivo |
| `Projector is not abstract and does not override abstract method code()` | Dejaste comentado el método `code()` de `Projector`: descomenta toda la clase |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 01 · Clases abstractas](../ejercicio-01-clases-abstractas/README.md) | **Ejercicio 02 · Interfaces** | [Ejercicio 03 · Métodos `default` y `static`](../ejercicio-03-metodos-default-y-static/README.md) |
