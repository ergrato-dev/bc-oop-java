# Ejercicio 03 — Sustantivos, verbos y tarjetas CRC

⏱️ 2 h · Teoría previa: [04](../../1-teoria/04-sustantivos-y-verbos.md) y [05](../../1-teoria/05-tarjetas-crc.md)

## Objetivo

Comprobar en código por qué tres arrays paralelos son un solo objeto mal guardado, y después hacer en papel el análisis que lo arregla: sustantivos, verbos y tarjetas CRC de un dominio nuevo. Es un ejercicio **guiado**: la parte de código viene comentada por pasos en `Main.java`. No se entrega.

## Antes de empezar

```bash
cd bootcamp/week-04-analisis_requisitos_casos_de_uso_y_dominio/2-practicas/ejercicio-03-sustantivos-verbos-y-crc/starter
java Main.java
```

No imprime nada. Arriba de `main` hay tres arrays: `codes`, `titles` y `authors`. La posición 0 de los tres habla de Rayuela; la 1, de Ficciones; la 2, de El túnel.

## Pasos

### 1. El catálogo

Descomenta el **PASO 1** y ejecuta `java Main.java`:

```
BK-311 · Rayuela · Cortázar
BK-042 · Ficciones · Borges
BK-107 · El túnel · Sábato
--
```

`describe(i)` necesita los tres arrays para describir **un** libro. Cualquier operación sobre un libro (describirlo, prestarlo, cambiarle el título) recibirá una posición y tendrá que acceder a los tres arrays por separado.

### 2. Dar de alta un libro

Descomenta el **PASO 2** y ejecuta. Las cinco últimas líneas:

```
BK-311 · Rayuela · Cortázar
BK-042 · Ficciones · Borges
BK-107 · El túnel · Sábato
BK-500 · Pedro Páramo · null
--
```

Los tres arrays crecen a 4, pero al libro nuevo solo se le dio código y título. El autor quedó a `null` y Java no se quejó: para él son tres arrays sueltos, no un libro.

Arréglalo añadiendo debajo de la línea 36 (`authors = Arrays.copyOf(authors, 4);`):

```java
    authors[3] = "Rulfo";
```

Ejecuta: la línea de BK-500 termina en `Rulfo`.

### 3. Ordenar por título

Descomenta el **PASO 3** y ejecuta. Las cinco últimas líneas:

```
BK-311 · El túnel · Cortázar
BK-042 · Ficciones · Borges
BK-107 · Pedro Páramo · Sábato
BK-500 · Rayuela · Rulfo
--
```

Los títulos están ordenados, pero ahora El túnel es de Cortázar con el código de Rayuela. `Arrays.sort(titles)` solo movió los títulos; los códigos y los autores se quedaron donde estaban. No hay excepción ni aviso: los datos están corruptos en silencio.

Para ordenar bien habría que mover a la vez las tres posiciones de cada libro, a mano. No lo arregles. Este es el problema que resuelve la semana 05: si el libro es **un objeto** con su código, su título y su autor dentro, ordenar los libros los mueve enteros, y es imposible crear un libro sin autor por olvido.

Responde antes de seguir: en tu proyecto, ¿qué arrays paralelos tienes ya (semanas 02 y 03) y de qué sustantivo son atributos?

### 4. Sustantivos y verbos, en papel

A partir de aquí no hay código. Usa este enunciado, de un dominio que nadie tiene asignado:

> El servicio de bicicletas de la ciudad alquila bicicletas a sus usuarios registrados. Cada bicicleta tiene un número, un estado (disponible, en uso o averiada) y está en una estación. Cada estación tiene un nombre y un número de anclajes. Un usuario saca una bicicleta de una estación y la devuelve en cualquier otra que tenga un anclaje libre. El alquiler se cobra por minutos, a 0.05 USD el minuto, y los primeros 30 minutos son gratis. Un usuario con un pago pendiente no puede sacar bicicletas. El operario retira las bicicletas averiadas.

1. Copia el enunciado y subraya los sustantivos y, con otro color, los verbos.
2. Filtra los sustantivos con la tabla de la teoría 04: sinónimos, el sistema, atributos, actores, valores de reglas.
3. Escribe la tabla de objetos del dominio: objeto (en inglés), atributos y de qué frase sale. Deberías tener entre 3 y 5 objetos. Pista: "alquila" deja datos que recordar.
4. Escribe las reglas de negocio (`RN-01`...) con los números del enunciado.
5. Escribe el glosario del dominio con al menos 5 términos.

### 5. Tarjetas CRC, en papel

1. Haz una tarjeta CRC por objeto: clase, responsabilidades (sabe... / hace...) y colaboradores.
2. Comprueba las señales de mal reparto de la teoría 05: ¿alguna tarjeta llena y otras vacías? ¿Alguna sin nada que hacer?
3. Escribe el flujo principal de "CU-01 Sacar una bicicleta" en 4 o 5 pasos y recórrelo con las tarjetas: al lado de cada paso, la tarjeta y la responsabilidad que lo hace. Si un paso no tiene dueño, añade la responsabilidad que falta.

¿Quién calcula el importe de un alquiler: el usuario, la bicicleta o el alquiler? Aplica la regla "quien tiene los datos, hace el trabajo": ¿quién sabe cuándo empezó y cuándo terminó?

Compara tus tarjetas con las de un compañero. No hay una única respuesta correcta, pero sí respuestas mejor o peor repartidas: cada diferencia es una buena pregunta para la sesión con el instructor.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| El paso 2 da `ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3` | Pusiste `authors[3] = "Rulfo";` **encima** del `copyOf` de `authors`: va debajo, cuando el array ya tiene 4 posiciones |
| `error: cannot find symbol ... Arrays` | Ejecuta con Java 25: un archivo sin `class` importa `java.base` solo desde Java 25 |
| Los nombres salen con caracteres raros (`SÃ¡bato`) | Tu terminal no está en UTF-8: en Windows, `chcp 65001` antes de ejecutar |
| En el paso 4 te salen 10 objetos | Muchos son atributos (número, estado, nombre) o valores de reglas (30 minutos): vuelve a la tabla de filtros |

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 02 · Criterios de aceptación a tests](../ejercicio-02-criterios-de-aceptacion-a-tests/README.md) | **Ejercicio 03 · Sustantivos, verbos y CRC** | [Proyecto](../../3-proyecto/README.md) |
