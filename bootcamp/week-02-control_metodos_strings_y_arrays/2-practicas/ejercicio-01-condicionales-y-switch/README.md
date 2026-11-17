# Ejercicio 01 — Condicionales y `switch`

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-condicionales-y-switch.md)

## Objetivo

Decidir qué hace el programa según los datos: `if / else if / else`, los operadores lógicos con cortocircuito, el `switch` moderno como expresión, `yield`, el ternario y un error de lógica que compila sin avisar. Es un ejercicio **guiado**: el código está en `Main.java`, comentado por pasos. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-02-control_metodos_strings_y_arrays/2-practicas/ejercicio-01-condicionales-y-switch/starter
java Main.java
```

Salida esperada:

```
Ejercicio 01 · Condicionales y switch
```

En cada paso descomentas un bloque y ejecutas `java Main.java`. La salida **acumula** la de los pasos anteriores; abajo solo se muestran las líneas nuevas. Predice cada línea antes de ejecutar.

## Pasos

### 1. `if / else if / else`

Descomenta el **PASO 1**:

```
Quedan pocas: 3
```

Java evalúa las condiciones de arriba abajo y ejecuta **solo** el primer bloque cuya condición es `true`; el resto ni se mira. Cambia `copies` a `0` y luego a `8`, y ejecuta cada vez: verás `Agotado` y `Hay de sobra`. Déjalo en `3` antes de seguir.

### 2. Operadores lógicos

Descomenta el **PASO 2**:

```
¿En oferta? true
¿Revisar? false
¿Retirado? false
¿Código válido? false
```

`&&` exige las dos condiciones; `||` se conforma con una; `!` invierte. La última línea es la importante: `code` es `null` (no apunta a ningún texto) y `code.length()` haría fallar el programa, pero `&&` **para** en cuanto la primera parte es `false` y nunca llega a la segunda. Eso se llama **cortocircuito**. Cambia `&&` por `&` en esa línea, ejecuta y verás:

```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "<local5>" is null
```

`&` evalúa los dos lados siempre. Vuelve a `&&`.

### 3. `switch` con flechas

Descomenta el **PASO 3**:

```
SAT: 10:00-14:00
```

El `switch` moderno es una **expresión**: devuelve un valor que guardas en `schedule`. Cada caso lleva `->` y no hace falta `break`; varias etiquetas van separadas por comas. Borra la línea `default -> ...` y ejecuta:

```
error: the switch expression does not cover all possible input values
```

Con un `String` puede llegar cualquier texto, así que el compilador te obliga a decir qué pasa con los demás. Restaura el `default`.

### 4. Bloques y `yield`

Descomenta el **PASO 4**:

```
Febrero: depende del año
Días del mes 2: 28
```

Si un caso necesita más de una sentencia, va entre llaves y devuelve su valor con `yield`. Cambia `month` a `4` y a `7`: `30` y `31`, sin la línea de febrero.

### 5. El ternario

Descomenta el **PASO 5**:

```
1 copia
4 copias
```

`condición ? siVerdad : siFalso` elige entre **dos** valores en una expresión. Para tres o más, un `switch` o un `if` se leen mejor.

### 6. El orden de las condiciones

Descomenta el **PASO 6**:

```
Quedan pocas: 0
```

Compila y se ejecuta, pero está mal: `0 < 5` es `true`, así que el primer bloque gana y `left == 0` nunca se evalúa. El compilador no puede detectar este error: solo un test o una lectura atenta. Arréglalo poniendo primero la condición más estrecha (`left == 0`) y ejecuta:

```
Agotado
```

Es la misma regla que usarás en `level` del proyecto.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: cannot find symbol ... price` | Descomentaste una línea suelta de otro paso; descomenta el bloque completo |
| `error: incompatible types: int cannot be converted to boolean` | Escribiste `if (copies = 0)`: `=` asigna; para comparar, `==` |
| `error: 'else' without 'if'` | Te dejaste una llave `}` comentada o sobra un `;` tras el `if (...)` |
| `error: variable copies is already defined` | Pegaste dos veces el mismo paso |
| El `if` "no hace caso" | Mira si hay un `;` justo después del paréntesis: `if (x > 0);` termina el `if` ahí |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · Arrays](../../1-teoria/05-arrays.md) | **Ejercicio 01 · Condicionales y `switch`** | [Ejercicio 02 · Bucles y arrays](../ejercicio-02-bucles-y-arrays/README.md) |
