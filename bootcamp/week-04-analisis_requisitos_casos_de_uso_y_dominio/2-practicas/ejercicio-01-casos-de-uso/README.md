# Ejercicio 01 — Casos de uso

⏱️ 1 h 30 min · Teoría previa: [01](../../1-teoria/01-del-problema-a-los-requisitos.md) y [02](../../1-teoria/02-casos-de-uso.md)

## Objetivo

Ver un caso de uso convertido en código: cada flujo, una rama. Recorrerás el flujo principal y los alternativos de **CU-01 Prestar un libro**, descubrirás un flujo que nadie escribió y lo añadirás al caso de uso y al código. Es un ejercicio **guiado**: el código viene comentado por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-04-analisis_requisitos_casos_de_uso_y_dominio/2-practicas/ejercicio-01-casos-de-uso/starter
java Main.java
```

No imprime nada: todos los pasos están comentados.

Ten a mano, en papel o en un archivo de texto, el CU-01 de la [teoría 02](../../1-teoria/02-casos-de-uso.md#2-un-caso-de-uso-completo). Arriba de `main` están los datos (tres libros con sus ejemplares y un socio bloqueado) y el método `lend`. Léelo y, al lado de cada `if`, apunta en tu CU-01 qué paso o qué flujo alternativo implementa.

Los números de línea de este README cuentan con que no añades ni quitas líneas.

## Pasos

### 1. El flujo principal

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
OK: S-01 se lleva BK-042, quedan 1
```

El socio no está bloqueado, el código existe y quedan ejemplares: `lend` pasa por los pasos 1, 2, 3 y 4 sin entrar en ningún `if`. Comprueba la postcondición: BK-042 tenía 2 ejemplares y ahora 1.

### 2. Flujo 2a: el código no existe

Descomenta el **PASO 2** y ejecuta. La última línea:

```
2a: no existe el libro BK-999
```

El CU-01 dice que en 2a "el sistema lo indica y **vuelve al paso 2**". El código solo lo indica: vuelve quien llama, pidiendo otro código. El caso de uso describe la conversación completa; un método implementa solo su parte.

### 3. Flujo 3a: sin ejemplares

Descomenta el **PASO 3** y ejecuta. La última línea:

```
3a: no quedan ejemplares de BK-107
```

### 4. Flujo 1a: socio bloqueado

Descomenta el **PASO 4** y ejecuta. La última línea:

```
1a: S-07 no puede llevarse más libros
```

Fíjate en el orden de `lend`: comprueba el socio **antes** de buscar el libro, como el caso de uso. Si el orden fuera otro, un socio bloqueado que pide un código inexistente recibiría el mensaje de 2a, y el caso de uso diría otra cosa.

### 5. El flujo que nadie escribió

Descomenta el **PASO 5** y ejecuta. La última línea:

```
2a: no existe el libro  bk-311 
```

BK-311 existe y le queda un ejemplar. Pero el bibliotecario lo escribió en minúsculas y con espacios, como hacía la gente en la semana 01. Ningún flujo del CU-01 contempla un código mal escrito, así que el programador no lo programó.

Primero arregla el **análisis**. Añade a tu CU-01, en los flujos alternativos:

```
2b. El código está en minúsculas o tiene espacios a los lados:
    el sistema lo normaliza y sigue en el paso 3.
```

Después, el código. Cambia la línea 30 por:

```java
    String wanted = code.strip().toUpperCase(Locale.ROOT); // paso 2 y flujo 2b
```

Ejecuta. La línea del paso 5 es ahora:

```
OK: S-03 se lleva BK-311, quedan 0
```

`Locale` no necesita `import`: un archivo como este, con `void main()` y sin `class`, importa automáticamente todo `java.base`.

### 6. La postcondición, hasta agotar

Descomenta el **PASO 6** y ejecuta. Las tres últimas líneas:

```
OK: S-03 se lleva BK-042, quedan 0
3a: no quedan ejemplares de BK-042
Ejemplares: [0, 0, 0]
```

El primer préstamo deja BK-042 a 0; el segundo cae en 3a. Cada préstamo cumple la postcondición ("un ejemplar menos") y es esa postcondición la que hace que el siguiente pueda fallar.

### 7. Tu turno, en papel

Escribe **CU-02 Devolver un libro** con la plantilla de la teoría 02: actor, requisitos, precondición, al menos 4 pasos, al menos dos flujos alternativos (¿y si el código no existe? ¿y si se devuelve tarde?) y postcondición. Señala qué paso usaría `Rules.overdueDays` y `Rules.penalty` de tu proyecto.

No hay salida que comparar: compáralo con un compañero o llévalo a la sesión con el instructor. Te servirá en el proyecto.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `error: cannot find symbol ... Locale` | Ejecuta con Java 25 (`java -version`); en versiones antiguas un archivo sin `class` no importa `java.base` |
| El paso 5 sigue diciendo `2a` | Cambiaste otra línea: la 30 es la que empieza por `String wanted` |
| El paso 6 muestra `quedan 1` en vez de `quedan 0` | No descomentaste el paso 1: ese préstamo se llevó el primer ejemplar |
| `error: class, interface, enum, or record expected` | Un `}` de más o de menos al descomentar: compara con los otros pasos |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [05 · Tarjetas CRC](../../1-teoria/05-tarjetas-crc.md) | **Ejercicio 01 · Casos de uso** | [Ejercicio 02 · Criterios de aceptación a tests](../ejercicio-02-criterios-de-aceptacion-a-tests/README.md) |
