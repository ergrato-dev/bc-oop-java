# Semana 10 — Records, enums, `sealed` y pattern matching

> Tu inventario ya trabaja con contratos. Esta semana aprendes las herramientas modernas de Java para modelar **datos**: records que no cambian, enums con valores fijos, jerarquías selladas que el compilador conoce de memoria y un `switch` que desmonta cada caso. Tu `Inventory` deja de lanzar una excepción cuando no puede sacar una unidad: devuelve un resultado, y el compilador comprueba que lo tratas entero.

Cierras la fase de jerarquías. Ves cuándo una clase es solo datos, cómo cambiar un texto con pocos valores posibles por un tipo, cómo cerrar una jerarquía y por qué preguntar el tipo con un `switch` sellado no tiene el problema de la cadena de `instanceof` de la semana 08. La semana 11 cierra la fase 2 con el contrato de `Object`: `equals`, `hashCode` y `Comparable` escritos a mano para tu clase.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Declarar** un record con sus componentes y validarlo con un constructor compacto
- **Explicar** qué escribe Java en un record y cuándo una clase debe ser un record y cuándo no
- **Definir** un enum con atributos, constructor y métodos, y convertir texto en constantes con `valueOf`
- **Cerrar** una jerarquía con `sealed` y `permits`, y elegir entre una interfaz abierta y una sellada
- **Usar** patrones de record en `instanceof` y en `switch`, con `when` y `_`, sin `default`
- **Devolver** un resultado en lugar de lanzar una excepción cuando "no se pudo" es un caso normal

---

## 📋 Prerrequisitos

- [Semana 09](../week-09-clases_abstractas_e_interfaces/README.md): interfaces, la interfaz como tipo y métodos `default` y `static`.
- [Semana 08](../week-08-polimorfismo/README.md): el patrón de `instanceof` y por qué una cadena de `instanceof` es frágil.
- Tu *pull request* `week-09` fusionado en `main`, con `Criterion`, sus dos criterios, `select` y `count`, y al menos 235 tests en verde.

---

## 🗂️ Estructura de la Semana

```
week-10-records_enums_sealed_y_pattern_matching/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 9 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Records](1-teoria/01-records.md) | Clases de datos en una línea, componentes, constructor compacto, lo que un record puede y no puede | 50 min |
| [02 · Enums](1-teoria/02-enums.md) | Valores fijos como tipo, `values` y `valueOf`, constantes con datos, `switch` sin `default` | 50 min |
| [03 · Tipos sellados](1-teoria/03-tipos-sellados.md) | `sealed` y `permits`, `final`, `sealed` y `non-sealed` en las hijas, jerarquía abierta o cerrada | 40 min |
| [04 · Pattern matching](1-teoria/04-pattern-matching.md) | Patrones de record, `switch` con patrones, exhaustividad, `when`, `_` | 55 min |
| [05 · Polimorfismo o pattern matching](1-teoria/05-polimorfismo-o-pattern-matching.md) | Qué crece, las clases o las operaciones; un resultado en lugar de una excepción | 45 min |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Records](2-practicas/ejercicio-01-records/README.md) | Una clase de datos a mano frente a un record, componentes que no cambian y un constructor compacto | 1 h 30 min |
| [02 · Enums](2-practicas/ejercicio-02-enums/README.md) | Un formato como texto y como enum, `valueOf`, constantes con días y un `switch` que las cubre todas | 2 h |
| [03 · Sealed y pattern matching](2-practicas/ejercicio-03-sealed-y-pattern-matching/README.md) | Desmontar records con `instanceof` y `switch`, casos con `when` y una clase nueva que el compilador persigue | 2 h |

### Proyecto

Escribes dos records, `Taken` y `Rejected`, una interfaz sellada `Outcome` que los trata con un `switch`, un enum `Level` con los niveles de unidades y un `tryTake` en tu `Inventory` que devuelve un resultado en lugar de lanzar.
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
| Completar los casos de un `switch` | Escribe `switch (outcome) {}`, pon el cursor en el error y usa la acción rápida que añade los casos que faltan (`Ctrl+.` en VS Code, `Alt+Enter` en IntelliJ) |
| Ver lo que Java escribe en un record | En IntelliJ, *Navigate* → *File Structure* (`Ctrl+F12`) sobre `Taken`: aparecen `code()`, `left()`, `equals`... |
| Encontrar cada `switch` que trata un tipo | Clic derecho sobre `Outcome` → *Find Usages* (`Alt+F7` en IntelliJ, `Shift+F12` en VS Code) |
| Ejecutar solo los tests del resultado | `./mvnw test -Dtest=OutcomeTest` |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-10` con `Taken`, `Rejected`, `Outcome`, `Level` y sus tests, `tryTake` en tu `Inventory`, sin ningún `Entity`, y `./mvnw test` en verde
2. ✅ Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio, uno con un patrón de record, y `App.java` con el bloque de resultados y niveles
3. ✅ Pull request `week-10` → `main` con la descripción del paso 12

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 267 tests y `Failures: 0, Errors: 0`; el segundo, mostrar al final una línea por cada intento de `tryTake` (una que sale y dos rechazadas, ninguna desde un `catch`) y el nivel de cada entidad del `shelf`. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 09](../week-09-clases_abstractas_e_interfaces/README.md) | **Semana 10** | Semana 11 |

← [Volver al inicio del bootcamp](../../README.md)
