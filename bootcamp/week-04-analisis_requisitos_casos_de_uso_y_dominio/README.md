# Semana 04 — Análisis: requisitos, casos de uso y objetos del dominio

> Tres semanas programando reglas sueltas de tu dominio. Antes de convertirlas en objetos, te paras a entender el problema: qué debe hacer el sistema, cómo lo usan sus actores y qué cosas del mundo tiene que recordar. Esta semana escribes ese análisis y aprendes a convertir sus criterios de aceptación en tests.

Lo que escribas aquí es el plano de las semanas siguientes: los objetos de tu análisis serán las clases de la semana 05.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Escribir** requisitos funcionales, no funcionales y reglas de negocio que se puedan comprobar
- **Describir** casos de uso con actor, flujo principal, flujos alternativos y postcondición
- **Convertir** una historia de usuario en criterios Dado-Cuando-Entonces, y cada criterio en un test con `@DisplayName`
- **Identificar** los objetos del dominio y sus atributos a partir de los sustantivos y verbos de un enunciado
- **Repartir** responsabilidades con tarjetas CRC y comprobarlas recorriendo un caso de uso

---

## 📋 Prerrequisitos

- [Semana 03](../week-03-tests_junit_assertj_y_depuracion/README.md): tests con JUnit y AssertJ, clases de equivalencia y valores límite.
- Tu *pull request* `week-03` fusionado en `main`.
- El enunciado de tu dominio, que te asigna el instructor.

---

## 🗂️ Estructura de la Semana

```
week-04-analisis_requisitos_casos_de_uso_y_dominio/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 4 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 3 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Del problema a los requisitos](1-teoria/01-del-problema-a-los-requisitos.md) | Análisis, diseño y programación; enunciado; requisitos funcionales y no funcionales; reglas de negocio | 45 min |
| [02 · Casos de uso](1-teoria/02-casos-de-uso.md) | Actor, objetivo, flujo principal y alternativos, pre y postcondición, tamaño justo | 45 min |
| [03 · Historias y criterios de aceptación](1-teoria/03-historias-y-criterios-de-aceptacion.md) | Como-quiero-para, Dado-Cuando-Entonces, del criterio al test, `@DisplayName` | 45 min |
| [04 · Sustantivos y verbos](1-teoria/04-sustantivos-y-verbos.md) | Objetos del dominio, filtrar candidatos, atributos, repartir operaciones, glosario | 45 min |
| [05 · Tarjetas CRC](1-teoria/05-tarjetas-crc.md) | Responsabilidades y colaboradores, quien tiene los datos hace el trabajo, recorrer un caso de uso | 1 h |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Casos de uso](2-practicas/ejercicio-01-casos-de-uso/README.md) | Un caso de uso convertido en código: cada flujo, una rama; descubres el flujo que faltaba | 1 h 30 min |
| [02 · Criterios de aceptación a tests](2-practicas/ejercicio-02-criterios-de-aceptacion-a-tests/README.md) | Cinco criterios, cinco tests; uno destapa una regla olvidada | 2 h |
| [03 · Sustantivos, verbos y CRC](2-practicas/ejercicio-03-sustantivos-verbos-y-crc/README.md) | Por qué los arrays paralelos fallan; análisis y tarjetas CRC de un dominio nuevo | 2 h |

### Proyecto

Escribes el análisis de tu dominio en `docs/analisis.md` y añades la clase `Catalog`: buscar, dar de alta y dar de baja, con tests que son criterios de aceptación. Tus propios criterios se convierten en tests.
→ [3-proyecto/README.md](3-proyecto/README.md)

---

## ⏱️ Distribución del Tiempo (14 horas)

| Actividad | Tiempo |
| --------- | ------ |
| Teoría (5 archivos) | 4 h |
| Ejercicio 01 | 1 h 30 min |
| Ejercicio 02 | 2 h |
| Ejercicio 03 | 2 h |
| Proyecto | 3 h |
| Recursos y glosario | 30 min |
| Autoevaluación (cuestionario de la rúbrica) | 1 h |
| **Total** | **14 h** |

---

## 🎩 Trucos y atajos

| Truco | Cómo |
|---|---|
| Ver qué secciones del análisis faltan | `./mvnw test -Dtest=AnalysisTest` |
| Ver qué líneas tienen aún `TODO` | `grep -n TODO docs/analisis.md` |
| Ejecutar varios grupos de tests a la vez | `./mvnw test -Dtest="CatalogTest#add*+remove*"` |
| Leer los criterios de un test sin abrirlo | `grep -n DisplayName src/test/java/gestion/CatalogTest.java` |
| Ver los nombres de `@DisplayName` | Panel *Testing* de VS Code (el matraz de la barra lateral) |
| Previsualizar `docs/analisis.md` | En VS Code, `Ctrl+Shift+V` |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-04` con `docs/analisis.md` completo, `Catalog.java` escrito y `./mvnw test` en verde
2. ✅ Al menos 4 tests nuevos en `MyDomainTest.java`, uno por criterio de aceptación de tu análisis, y `App.java` con el catálogo de tu dominio
3. ✅ Pull request `week-04` → `main` con la descripción del paso 13

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 111 tests y `Failures: 0, Errors: 0`; el segundo, mostrar tus registros, tu inventario, tus reglas y tu catálogo. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 03](../week-03-tests_junit_assertj_y_depuracion/README.md) | **Semana 04** | Semana 05 |

← [Volver al inicio del bootcamp](../../README.md)
