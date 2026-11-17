# Proyecto — Gestión, capa 3: el análisis y el catálogo

⏱️ 3 h

## Qué construyes

Hasta ahora has programado reglas sueltas de tu dominio. Esta semana te paras a **analizarlo**: escribes en `docs/analisis.md` qué debe hacer tu sistema, cómo lo usan sus actores y qué objetos tiene. Es el plano de lo que programarás desde la semana 05.

Y tu sistema gana un **catálogo** con tres operaciones que salen de sus casos de uso:

| Método | Qué hace | Caso de uso |
|---|---|---|
| `Catalog.search(titles, query)` | Posiciones de los títulos que contienen un texto | Buscar por título |
| `Catalog.add(codes, code)` | Array nuevo con el código normalizado al final | Dar de alta |
| `Catalog.remove(codes, code)` | Array nuevo sin ese código | Dar de baja |

Los tres llegan sin escribir. Los tests de `CatalogTest` son sus criterios de aceptación: cada uno empieza por `CA-` en su `@DisplayName`. Y `AnalysisTest` comprueba que tu análisis está completo: no puede juzgar si es bueno (eso lo hace el instructor), pero sí que no falta ninguna sección.

## Pasos

### 1. Parte de la semana 03

Tu *pull request* `week-03` debe estar fusionado en `main`:

```bash
cd ~/proyectos/oop-java-<nombre>-<apellido>
git switch main
git pull
git switch -c week-04
```

### 2. Copia los archivos de la semana

```bash
STARTER=<ruta-al-bootcamp>/bootcamp/week-04-analisis_requisitos_casos_de_uso_y_dominio/3-proyecto/starter
cp $STARTER/src/main/java/gestion/Catalog.java src/main/java/gestion/
cp $STARTER/src/test/java/gestion/CatalogTest.java src/test/java/gestion/
cp $STARTER/src/test/java/gestion/AnalysisTest.java src/test/java/gestion/
mkdir -p docs
cp $STARTER/docs/analisis.md docs/
git status --short
```

Debes ver:

```
?? docs/
?? src/main/java/gestion/Catalog.java
?? src/test/java/gestion/AnalysisTest.java
?? src/test/java/gestion/CatalogTest.java
```

Haz un commit antes de tocar nada:

```bash
git add docs src/main/java/gestion/Catalog.java src/test/java/gestion/AnalysisTest.java src/test/java/gestion/CatalogTest.java
git commit -m "test: add catalog and analysis tests with starter"
```

### 3. Tests en rojo

```bash
./mvnw test -Dtest="CatalogTest+AnalysisTest"
```

Esperado:

```
[ERROR] Tests run: 29, Failures: 18, Errors: 10, Skipped: 0
```

Solo pasa `documentExists`: el archivo está, pero es una plantilla. Los otros 7 de `AnalysisTest` fallan porque faltan secciones o quedan marcas `TODO`; los 21 de `CatalogTest`, porque los métodos lanzan `UnsupportedOperationException`.

Empieza por el análisis: es lo que te dice qué programar.

### 4. Enunciado, requisitos y reglas

Abre `docs/analisis.md`. Con el enunciado de tu dominio que te dio el instructor, rellena las secciones 1 a 4 siguiendo las teorías [01](../1-teoria/01-del-problema-a-los-requisitos.md) y [02](../1-teoria/02-casos-de-uso.md):

1. **Enunciado**: cuéntalo con tus palabras, entre 5 y 8 líneas. Lo que el enunciado no diga, decídelo tú y escríbelo como regla.
2. **Requisitos funcionales**: al menos 6, con "El sistema debe..." y que se puedan comprobar. Incluye dar de alta, dar de baja y buscar, que programarás hoy.
3. **No funcionales**: al menos 2, medibles.
4. **Reglas de negocio**: al menos 3, con los números que ya usas en `App.java` (tu rango válido, tu capacidad, tu plazo, tu tarifa, tu tope) y el método que las aplica.

Comprueba cómo vas:

```bash
./mvnw test -Dtest=AnalysisTest
```

Cada test que pasa a verde es una sección completa. `noTodoLeft` muestra las líneas que aún tienen `TODO`.

### 5. Casos de uso

Escribe al menos **dos** casos de uso completos, con la plantilla de la teoría 02. Uno de ellos debe ser "Dar de alta" o "Buscar" de tu entidad principal. Cada uno, con al menos **dos flujos alternativos** que digan cómo terminan. Usa las preguntas de la teoría 02: ¿y si no existe?, ¿y si está mal escrito?, ¿y si no queda?, ¿y si una regla lo impide?

### 6. Historia y criterios de aceptación

Escribe una historia de usuario con su "para" y al menos **cuatro** criterios Dado-Cuando-Entonces con datos de tu dominio (teoría 03). Deja la columna **Test** en `TODO` de momento: la rellenarás en el paso 11.

### 7. Objetos, tarjetas CRC y glosario

Haz con tu enunciado lo que hiciste en papel en el ejercicio 03:

1. **Objetos del dominio**: la tabla con atributos, operaciones y la frase de la que sale cada uno. Debajo, qué arrays paralelos de tu proyecto son atributos de qué objeto.
2. **Tarjetas CRC**: al menos tres, con el encabezado exacto `### CRC: <Clase>`, y el recorrido de tu CU-01 con ellas.
3. **Glosario**: al menos 5 términos, con su nombre en el código.

```bash
./mvnw test -Dtest=AnalysisTest
```

Esperado: `Tests run: 8, Failures: 0`. Haz un commit: `docs: add domain analysis`.

### 8. `search`

```bash
./mvnw test -Dtest="CatalogTest#search*"
```

Esperado al empezar: `Tests run: 8` en rojo. Lee el Javadoc de `search` y los criterios CA-01 a CA-04. Sustituye el `throw new UnsupportedOperationException` por la implementación:

1. Si `query` es `null` o está en blanco, lanza `IllegalArgumentException("Búsqueda vacía")`.
2. Pasa `query` a minúsculas sin los espacios de los extremos: `strip()` y `toLowerCase(Locale.ROOT)`.
3. Recorre `titles` y guarda en un `int[]` del tamaño de `titles` cada posición cuyo título, en minúsculas, contenga (`contains`) el texto buscado. Lleva la cuenta en un `count`.
4. Devuelve `Arrays.copyOf(found, count)`, como en `Stock.parseCodes` de la semana 02.

Añade arriba `import java.util.Arrays;` y `import java.util.Locale;`. Repite hasta tener los 8 en verde.

### 9. `add` y `remove`

```bash
./mvnw test -Dtest="CatalogTest#add*+remove*"
```

Esperado al empezar: `Tests run: 13` en rojo. Antes de escribir nada, mira lo que ya tienes: normalizar un código (`Fields.normalizeCode`, semana 01), validarlo (`Stock.isValidCode`) y buscarlo (`Stock.indexOf`, semana 02). **No los reescribas**: llámalos.

- `add`: normaliza; si no es válido, `IllegalArgumentException("Código no válido: " + code)` con el texto **original**; si ya está, `IllegalArgumentException("Código repetido: " + normalizado)`. Si no, `Arrays.copyOf(codes, codes.length + 1)` y el código normalizado en la última posición.
- `remove`: busca la posición con `Stock.indexOf`; si es `-1`, `IllegalArgumentException("No existe: " + code)`. Si no, crea un array de `codes.length - 1` y copia todos menos esa posición, con un segundo contador para la posición de destino.

Ninguno de los dos cambia `codes`: los tests `addKeepsOriginal` y `removeKeepsOrder` lo comprueban. Haz un commit por método, por ejemplo `feat: add catalog search`.

### 10. Todo en verde

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con `Failures: 0, Errors: 0` y al menos 107 tests: los tuyos de las semanas 01 a 03 (al menos 78), los 21 de `CatalogTest` y los 8 de `AnalysisTest`.

### 11. Tus criterios, en tests

En `MyDomainTest.java`, debajo de los de semanas anteriores, convierte en tests **los criterios de aceptación que escribiste en el paso 6**, al menos 4, con `Catalog` y los datos de tu dominio. Cada test lleva `@DisplayName` con el identificador del criterio:

```java
@Test
@DisplayName("CA-02 un código repetido se rechaza")
void duplicateBookIsRejected() {
    String[] codes = {"BK-042", "BK-107", "BK-311"};
    assertThatThrownBy(() -> Catalog.add(codes, "BK-107"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Código repetido: BK-107");
}
```

Añade `import org.junit.jupiter.api.DisplayName;` arriba. Si un criterio tuyo no se puede probar con `Catalog` (por ejemplo, uno de préstamos), escribe otro que sí, y deja aquel para cuando exista la clase que lo cumpla. Después rellena la columna **Test** de la tabla de criterios con el nombre de cada método: `MyDomainTest.duplicateBookIsRejected`.

```bash
./mvnw test
```

Esperado: `BUILD SUCCESS` con al menos 111 tests.

### 12. El catálogo en el programa

Al final de `main` en `App.java`, añade:

```java
        // Semana 04: el catálogo. Cambia títulos, búsqueda y código por los de tu dominio.
        String[] titles = {"Rayuela", "Ficciones", "El túnel"};
        System.out.println("Buscar \"el\": " + java.util.Arrays.toString(Catalog.search(titles, "el")));
        String[] more = Catalog.add(codes, " bk-500 ");
        System.out.println("Alta: " + java.util.Arrays.toString(more));
        System.out.println("Baja: " + java.util.Arrays.toString(Catalog.remove(more, "BK-107")));
```

`codes` es el array de la semana 02. Con los valores de la Biblioteca, `./mvnw -q compile exec:java` termina en:

```
Buscar "el": [0, 2]
Alta: [BK-042, BK-107, BK-311, BK-500]
Baja: [BK-042, BK-311, BK-500]
```

Cambia títulos, búsqueda y códigos por los de tu dominio. `titles` debe tener tantas posiciones como `codes`: son arrays paralelos.

### 13. Commit y pull request

```bash
git add .
git commit -m "feat: show catalog in app"
git push -u origin week-04
```

En GitHub, abre un *pull request* de `week-04` hacia `main`. En la descripción pega:

1. Tu dominio y el enlace a `docs/analisis.md` en tu rama.
2. Los objetos del dominio que darán clases en la semana 05 y qué arrays paralelos de tu proyecto se convertirán en atributos de cada uno.
3. Las dos últimas líneas de `./mvnw test` y la salida de `./mvnw -q compile exec:java`.

## 🧯 Si algo sale mal

| Síntoma | Qué hacer |
|---|---|
| `NoSuchFile docs/analisis.md` en `AnalysisTest` | El archivo debe estar en `docs/` en la raíz del proyecto, junto a `pom.xml`, y ejecutas `./mvnw` desde esa raíz |
| `sixFunctionalRequirements` falla con 6 requisitos escritos | Los identificadores deben ser distintos y con dos dígitos: `RF-01`... `RF-06`, no `RF-1` ni dos `RF-03` |
| `threeCrcCards` falla con tres tarjetas | El encabezado debe ser exactamente `### CRC: Book`, con `###`, dos puntos y un espacio |
| `noTodoLeft` falla y no ves ningún `TODO` | Mira la lista del mensaje: suele quedar uno en el título o en un bloque de código |
| `addRejectsMalformedCodes` falla por el mensaje | Usa el texto original en `"Código no válido: " + code`, no el normalizado |
| `searchIgnoresCaseAndOuterSpaces` da `[]` | Te falta `strip()`: con los espacios, `"  ficc "` no está dentro de ningún título |
| `remove` da `ArrayIndexOutOfBoundsException` | Usas `i` como posición de destino: lleva otro contador que solo avanza cuando copias |
| `cannot find symbol ... DisplayName` en `MyDomainTest` | Falta `import org.junit.jupiter.api.DisplayName;` |

## Entrega

El proyecto es el **único entregable** de la semana:

- Rama `week-04` con `docs/analisis.md` completo, `Catalog.java` escrito y `./mvnw test` en verde.
- Al menos 4 tests nuevos en `MyDomainTest.java`, uno por criterio de aceptación de tu análisis, con `@DisplayName`.
- `App.java` con el catálogo de tu dominio.
- *Pull request* `week-04` → `main` con la descripción del paso 13.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Ejercicio 03 · Sustantivos, verbos y CRC](../2-practicas/ejercicio-03-sustantivos-verbos-y-crc/README.md) | **Proyecto · Gestión, capa 3** | [Webgrafía](../4-recursos/webgrafia/README.md) |
