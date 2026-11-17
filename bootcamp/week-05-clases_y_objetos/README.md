# Semana 05 — Clases y objetos

> Cuatro semanas guardando tu entidad en arrays paralelos y en métodos `static`. Esta semana empieza la orientación a objetos: la tarjeta CRC de tu análisis se convierte en una clase, y cada registro de tu dominio, en un objeto con sus datos y su comportamiento dentro.

Es la semana en que cambia la forma de pensar el código: ya no preguntas "¿qué posición del array?", sino "¿qué objeto?". El resto de la fase 2 (encapsulación, herencia, polimorfismo, interfaces) se construye sobre lo que aprendes aquí.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Escribir** una clase con atributos, constructor y métodos de instancia a partir de una tarjeta CRC
- **Crear** objetos con `new` y explicar su estado y los valores por defecto de sus atributos
- **Usar** `this` para distinguir un atributo de un parámetro con el mismo nombre
- **Predecir** el efecto de asignar, comparar con `==` y pasar a un método una variable de tipo objeto
- **Distinguir** lo que es de cada objeto de lo que es de la clase (`static`), y sustituir arrays paralelos por un array de objetos

---

## 📋 Prerrequisitos

- [Semana 04](../week-04-analisis_requisitos_casos_de_uso_y_dominio/README.md): análisis del dominio, objetos y tarjetas CRC.
- Tu *pull request* `week-04` fusionado en `main`, con `docs/analisis.md` completo.

---

## 🗂️ Estructura de la Semana

```
week-05-clases_y_objetos/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 4 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · De la tarjeta a la clase](1-teoria/01-de-la-tarjeta-a-la-clase.md) | Clase, atributo, objeto, `new`, valores por defecto, estado | 50 min |
| [02 · Métodos de instancia](1-teoria/02-metodos-de-instancia.md) | Métodos que usan y cambian el estado, `this`, consultas y órdenes, `IllegalStateException` | 50 min |
| [03 · Constructores](1-teoria/03-constructores.md) | Constructor, `this.code = code`, preparar los datos, constructor por defecto | 45 min |
| [04 · Referencias y `null`](1-teoria/04-referencias-y-null.md) | Primitivos y referencias, alias, `==`, paso por valor, `null` y `NullPointerException` | 50 min |
| [05 · `static` y arrays de objetos](1-teoria/05-static-y-arrays-de-objetos.md) | De clase o de cada objeto, métodos `static` sobre varios objetos, de arrays paralelos a un `Book[]` | 45 min |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Clases y objetos](2-practicas/ejercicio-01-clases-y-objetos/README.md) | Tu primera clase: objetos, valores por defecto, métodos y un constructor con un `this` olvidado | 1 h 30 min |
| [02 · Referencias y `null`](2-practicas/ejercicio-02-referencias-y-null/README.md) | Alias, `==`, qué puede cambiar un método y un array lleno de `null` | 2 h |
| [03 · De arrays paralelos a objetos](2-practicas/ejercicio-03-de-arrays-paralelos-a-objetos/README.md) | El catálogo de la semana 04 con objetos: sin libros a medias ni datos descuadrados; `static` | 2 h |

### Proyecto

Conviertes tu entidad principal en una clase de tu dominio, con constructor, métodos que cambian su estado y métodos `static` sobre un array de objetos. Tu programa pasa de arrays paralelos a objetos.
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
| Copiar la clase del starter con tu nombre | `sed "s/Entity/Bicycle/g" Entity.java > Bicycle.java` |
| Ejecutar solo los tests de unos métodos | `./mvnw test -Dtest="BicycleTest#take*+restock*"` |
| Probar un objeto sin escribir un `main` | `jshell`, pega la clase entera y después `new Bicycle("BI-7", "Urbana", 1).describe()` |
| Generar el constructor | En VS Code, clic derecho en la clase → *Source Action...* → *Generate Constructors...* (y revisa que use `this.`) |
| Ver qué era `null` | Lee el `because "..." is null` del mensaje de `NullPointerException` antes de tocar nada |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-05` con tu clase y su test, sin ningún `Entity`, y `./mvnw test` en verde
2. ✅ Al menos 3 tests nuevos en `MyDomainTest.java` con objetos de tu clase, y `App.java` con un array de objetos de tu dominio
3. ✅ Pull request `week-05` → `main` con la descripción del paso 12

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 141 tests y `Failures: 0, Errors: 0`; el segundo, mostrar al final tus objetos descritos, el total y la posición del código buscado. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 04](../week-04-analisis_requisitos_casos_de_uso_y_dominio/README.md) | **Semana 05** | Semana 06 |

← [Volver al inicio del bootcamp](../../README.md)
