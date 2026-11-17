# Ejercicio 01 — Clases y objetos

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-de-la-tarjeta-a-la-clase.md), [02](../../1-teoria/02-metodos-de-instancia.md) y [03](../../1-teoria/03-constructores.md)

## Objetivo

Escribir tu primera clase y fabricar objetos con ella: ver qué valor tienen sus atributos al nacer, comprobar que cada objeto guarda sus propios datos, darle métodos que usan y cambian esos datos, y un constructor. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-05-clases_y_objetos/2-practicas/ejercicio-01-clases-y-objetos/starter
java Main.java
```

No imprime nada. Arriba de `main` hay dos clases: `Book`, con tres atributos (`code`, `title`, `copies`), y `Member`, con dos (`id`, `name`). Los pasos 3, 4 y 5 descomentan código **dentro** de esas clases y también dentro de `main`: cada paso dice dónde.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. Un objeto recién creado

Descomenta el **PASO 1** de `main` y ejecuta `java Main.java`:

```
null · null · 0
```

`new Book()` crea un objeto, pero nadie le ha dado datos: cada atributo empieza con el valor por defecto de su tipo. `null` para los `String` (no apunta a ningún texto) y `0` para el `int`. Un atributo nunca está "sin inicializar", como pasa con una variable local: Java le pone ese valor por defecto.

### 2. Dos objetos de la misma clase

Descomenta el **PASO 2** y ejecuta. La última línea:

```
Rayuela tiene 1; Ficciones tiene 2
```

Dos `new`, dos objetos. `rayuela.copies` y `ficciones.copies` se llaman igual, pero son dos cajas distintas: cada objeto guarda las suyas. El punto (`rayuela.copies`) dice de qué objeto hablas.

### 3. `describe()`

Descomenta el **PASO 3** en los dos sitios: el método `describe()` dentro de `Book` y las dos líneas del paso 3 en `main`. Ejecuta. Las dos últimas líneas:

```
BK-311 · Rayuela · ejemplares: 1
BK-042 · Ficciones · ejemplares: 2
```

Dentro de `describe()`, `code` no es ninguna variable de `main`: es el `code` del objeto que va delante del punto. `rayuela.describe()` lee los datos de Rayuela; `ficciones.describe()`, los de Ficciones. El mismo código y dos resultados.

### 4. `lend()`

Descomenta el **PASO 4** en los dos sitios: `lend()` dentro de `Book` y las tres líneas en `main`. Ejecuta. Las tres últimas líneas:

```
Prestado BK-311, quedan 0
No quedan ejemplares de BK-311
BK-042 · Ficciones · ejemplares: 2
```

`lend()` no solo lee: con `copies--` cambia el **estado** del objeto. Por eso la segunda llamada a `rayuela.lend()` da otro resultado que la primera, y Ficciones sigue con 2: no se tocó.

Compáralo con `lend(member, code)` del ejercicio 01 de la semana 04. Aquel método recibía un código y buscaba la posición en tres arrays; este ya sabe de qué libro habla.

### 5. Un constructor

Descomenta el **PASO 5** en los dos sitios: el constructor `Member(String id, String name)` dentro de `Member` y las dos líneas en `main`. Ejecuta. La última línea:

```
null · Ana
```

Esperabas `S-01 · Ana`. Mira la línea 32: `id = id;`. Dentro del constructor, `id` es el **parámetro**, que tapa al atributo del mismo nombre. La línea copia el parámetro en sí mismo, y el atributo se queda en `null`. Java no avisa.

Cámbiala por:

```java
        this.id = id;
```

`this` es el objeto que se está construyendo: `this.id` es su atributo y `id`, el parámetro. Ejecuta: la última línea es `S-01 · Ana`. La línea de `name` ya lo hacía bien.

### 6. El constructor vacío ya no existe

Descomenta la línea del **PASO 6** y ejecuta:

```
Main.java:90: error: constructor Member in class Main.Member cannot be applied to given types;
    Member nobody = new Member();
                    ^
  required: String,String
  found:    no arguments
```

`Book` no tiene constructor, y Java le da uno vacío: por eso funciona `new Book()`. En cuanto escribes uno, como en `Member`, Java deja de darlo. Para crear un socio hay que pasarle sus datos: es imposible olvidarlos. `Main.Member` es el nombre completo: en un archivo con `void main()` y sin `class`, Java mete todo en una clase `Main` invisible, y `Member` vive dentro.

Vuelve a comentar la línea y comprueba que el programa ejecuta de nuevo.

### 7. Tu turno

Añade a `Book` un método `giveBack()` que sume un ejemplar y devuelva `"Devuelto BK-311, quedan 1"`. Al final de `main`, llámalo sobre `rayuela` y después `rayuela.lend()` otra vez. Debes ver:

```
Devuelto BK-311, quedan 1
Prestado BK-311, quedan 0
```

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: cannot find symbol ... method describe()` | Descomentaste las líneas de `main` del paso 3, pero no el método dentro de `Book` |
| `error: cannot find symbol ... variable rayuela` | Descomentaste el paso 3 o 4 sin el paso 2, donde se crea `rayuela` |
| `constructor Member ... cannot be applied` sin haber tocado el paso 6 | Descomentaste el constructor del paso 5 y tienes otro `new Member()` en algún sitio: los socios se crean con dos argumentos |
| El paso 5 sigue diciendo `null · Ana` | Cambiaste la línea de `name`: la que falla es la 32, `id = id;` |
| `error: reached end of file while parsing` | Al descomentar un método se quedó comentada su `}` final: cada método abre y cierra su llave |
| Errores raros desde la primera línea | Ejecuta con Java 25 (`java -version`): un archivo con `void main()` sin `class` necesita Java 25 |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · `static` y arrays de objetos](../../1-teoria/05-static-y-arrays-de-objetos.md) | **Ejercicio 01 · Clases y objetos** | [Ejercicio 02 · Referencias y `null`](../ejercicio-02-referencias-y-null/README.md) |
