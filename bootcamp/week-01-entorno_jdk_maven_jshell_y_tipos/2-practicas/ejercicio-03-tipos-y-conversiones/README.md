# Ejercicio 03 — Tipos y conversiones

⏱️ 2 h · Teoría previa: [05](../../1-teoria/05-variables-y-tipos.md)

## Objetivo

Ver con tus ojos los comportamientos de los tipos que más errores causan: el *overflow* de `int`, los `double` inexactos, la división entera, el casting que trunca, la conversión de texto a número y la diferencia entre `==` y `equals`. Es un ejercicio **guiado**: el código está en `Main.java`, comentado por pasos. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-01-entorno_jdk_maven_jshell_y_tipos/2-practicas/ejercicio-03-tipos-y-conversiones/starter
java Main.java
```

Salida esperada:

```
Ejercicio 03 · Tipos y conversiones
```

En cada paso descomentas un bloque y ejecutas `java Main.java`. La salida **acumula** la de los pasos anteriores; abajo solo se muestran las líneas nuevas. Antes de ejecutar, **predice** cada línea en voz alta o en un papel: los fallos de predicción son lo que aprendes.

## Pasos

### 1. Los límites de `int`

Descomenta el **PASO 1**. Líneas nuevas:

```
int máximo: 2147483647
int máximo + 1: -2147483648
long: 2147483648
```

Sumar 1 al máximo **no da error**: el valor da la vuelta al mínimo. Es un fallo silencioso, el peor tipo. Con `1L` la suma se hace en `long` (64 bits) y cabe. Para contar copias o unidades, `int` sobra; para importes grandes o milisegundos, `long`.

### 2. `double` no es exacto

Descomenta el **PASO 2**:

```
0.1 + 0.2 = 0.30000000000000004
¿== 0.3? false
¿casi 0.3? true
```

`double` guarda el número en binario y `0.1` no tiene representación exacta. Nunca compares dos `double` con `==`: compara la diferencia con una tolerancia. (Para dinero de verdad, Java tiene `BigDecimal`; lo verás cuando tu dominio lo necesite.)

### 3. División entera y casting

Descomenta el **PASO 3**:

```
7 / 2 = 3
7 % 2 = 1
(double) 7 / 2 = 3.5
(int) 4.99 = 4
Math.round(4.5) = 5
```

Entre dos `int`, `/` da un `int` y descarta los decimales; `%` es el resto. `(double) 7` convierte **antes** de dividir. `(int)` trunca hacia cero; si quieres redondear, `Math.round`.

### 4. De texto a número

Descomenta el **PASO 4**:

```
Año + 1: 1968
Precio x 2: 25.0
Texto + número: 19671
```

`Double.parseDouble` solo entiende el punto decimal: por eso se cambia la coma antes. Mira la última línea: `"1967" + 1` concatena, no suma, porque si uno de los dos lados de `+` es un `String`, el otro se convierte a texto.

Ahora cambia `"1967"` por `"mil"` en `Integer.parseInt("1967")` (línea 50) y ejecuta:

```
Exception in thread "main" java.lang.NumberFormatException: For input string: "mil"
```

Compila bien y falla al ejecutar. Vuelve a poner `"1967"`.

### 5. `char`, `boolean` y `var`

Descomenta el **PASO 5** (usa `price` y `year` del paso 4):

```
Siguiente letra: C
¿Disponible? true
Letras: 20
```

`char` es un carácter y también un número: `'B' + 1` da `67`, y `(char)` lo vuelve letra. `&&` exige que las dos condiciones sean verdaderas. `var title = "..."` no quita el tipo: `title` es `String` para siempre; prueba a añadir `title = 5;` y verás el error de compilación (bórralo después).

### 6. `String`: comparar y formatear

Descomenta el **PASO 6**:

```
¿== ? false
¿equals? true
Precio: 12.50 USD
00042
```

Con texto, `==` pregunta si son **el mismo objeto**, no si dicen lo mismo: compara siempre con `equals`. `String.format` rellena plantillas: `%s` texto, `%.2f` decimal con dos cifras, `%05d` entero con ceros a la izquierda. `Locale.ROOT` fija el punto decimal; prueba a quitar `Locale.ROOT, ` y, si tu sistema está en español, verás `12,50`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: cannot find symbol ... price` | Descomentaste el PASO 5 o 6 sin el PASO 4 |
| `error: incompatible types: possible lossy conversion from double to int` | Asignaste un `double` a un `int` sin casting: es justo lo que el compilador protege |
| `error: integer number too large` | Escribiste un literal mayor que el máximo de `int` sin la `L` final |
| `¿== ? true` | Quitaste el `new String(...)`: los literales iguales comparten objeto, por eso `==` a veces "funciona" y luego falla |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Primer proyecto Maven](../ejercicio-02-primer-proyecto-maven/README.md) | **Ejercicio 03 · Tipos y conversiones** | [Proyecto · Gestión, capa 0](../../3-proyecto/README.md) |
