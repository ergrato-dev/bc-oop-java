# Semana 06 — Encapsulación, constructores y composición

> Tu clase de la semana 05 funciona, pero cualquiera puede escribir `item.quantity = -5`. Esta semana cierra la puerta: atributos `private`, un constructor que no deja nacer objetos en mal estado y un inventario que guarda tus objetos y pone las reglas que uno solo no puede cumplir.

Es la semana en que tus clases dejan de ser cajas de datos y empiezan a proteger sus propias reglas. La herencia, el polimorfismo y las interfaces de las próximas semanas dan por hecho que cada clase se protege sola.

---

## 🎯 Objetivos de la Semana

Al finalizar esta semana serás capaz de:

- **Encapsular** una clase: atributos `private`, *getters* solo donde hacen falta y órdenes del dominio en lugar de *setters*
- **Escribir** un constructor que valida todos sus datos antes de asignar y rechaza los que no valen con `IllegalArgumentException`
- **Sobrecargar** un constructor y reutilizar el otro con `this(...)`
- **Distinguir** qué fija `final` en un atributo y en una variable de tipo objeto, y qué hace inmutable a un objeto
- **Construir** una clase por composición que delega en sus objetos y entrega copias defensivas de su array

---

## 📋 Prerrequisitos

- [Semana 05](../week-05-clases_y_objetos/README.md): clases, objetos, constructores, referencias y `static`.
- Tu *pull request* `week-05` fusionado en `main`, con tu clase y sus 27 tests en verde.

---

## 🗂️ Estructura de la Semana

```
week-06-encapsulacion_constructores_y_composicion/
├── README.md                    # este archivo
├── rubrica-evaluacion.md        # cómo se evalúa la semana
├── 0-assets/                    # 3 diagramas SVG
├── 1-teoria/                    # 5 archivos, un concepto cada uno
├── 2-practicas/                 # 3 ejercicios guiados con starter/
├── 3-proyecto/                  # la capa 5 de tu sistema de gestión
├── 4-recursos/                  # webgrafía, ebooks, vídeos
└── 5-glosario/                  # los términos de la semana, A-Z
```

---

## 📝 Contenidos

### Teoría

| Archivo | Tema | Duración |
| ------- | ---- | -------- |
| [01 · Encapsulación y `private`](1-teoria/01-encapsulacion-y-private.md) | Encapsular, `private`, los cuatro niveles de acceso, la `Main` invisible de los archivos sueltos | 50 min |
| [02 · *Getters*, *setters* y comportamiento](1-teoria/02-getters-setters-y-comportamiento.md) | *Getters*, el *setter* que lo deshace todo, *tell, don't ask*, invariantes | 45 min |
| [03 · Constructores que validan](1-teoria/03-constructores-que-validan.md) | Rechazar en el constructor, *fail fast*, comprobar antes de asignar, sobrecarga y `this(...)` | 50 min |
| [04 · `final` e inmutabilidad](1-teoria/04-final-e-inmutabilidad.md) | Atributos y variables `final`, la referencia frente al objeto, objetos inmutables, `String` | 45 min |
| [05 · Composición y delegación](1-teoria/05-composicion-y-delegacion.md) | Un objeto que tiene otros, reglas de la colección, delegar, el array que se escapa y la copia defensiva | 50 min |

### Prácticas

Guiadas y sin entrega: el código viene comentado por pasos, lo descomentas, lo ejecutas y comparas con la salida esperada. Preparan el proyecto.

| Ejercicio | Qué haces | Duración |
| --------- | --------- | -------- |
| [01 · Encapsular una clase](2-practicas/ejercicio-01-encapsular-una-clase/README.md) | Un libro abierto, uno encapsulado y uno con un *setter* que lo deshace todo | 1 h 30 min |
| [02 · Constructores que validan](2-practicas/ejercicio-02-constructores-que-validan/README.md) | Rechazar datos, comprobar antes de asignar, `this(...)` y `final` en atributos y variables | 2 h |
| [03 · Composición y copias defensivas](2-practicas/ejercicio-03-composicion-y-copias-defensivas/README.md) | Una estantería que tiene libros, delega en ellos y no deja escapar su array | 2 h |

### Proyecto

Encapsulas tu entidad (`private`, `final`, *getters*, constructor que valida y un segundo constructor) y escribes `Inventory`, que guarda tus objetos sin repetir códigos y delega en ellos.
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
| Generar los *getters* | En VS Code, clic derecho en la clase → *Source Action...* → *Generate Getters...*. Desmarca los que nadie necesita y no generes *setters* |
| Ver qué usaba un atributo antes de hacerlo `private` | `grep -rn "\.quantity" src/` antes de cambiarlo: cada línea que salga dejará de compilar |
| Ejecutar solo los tests de diseño | `./mvnw test -Dtest="BicycleTest#attributes*+text*+hasNo*"` |
| Probar un constructor que valida sin escribir un test | `jshell --class-path target/classes`, `import gestion.*;` y `new Bicycle("??", "x", 1)`: verás la excepción con su mensaje |
| Ver los dos constructores de tu clase | En VS Code, escribe `new Bicycle(` y pulsa `Ctrl+Shift+Espacio`: aparecen las dos listas de parámetros |

---

## 📌 Entregables

El único entregable es el **proyecto**, en tu dominio asignado:

1. ✅ Rama `week-06` con tu clase encapsulada, `Inventory` y sus tests, sin ningún `Entity`, y `./mvnw test` en verde
2. ✅ Al menos 3 tests nuevos en `MyDomainTest.java` con datos de tu dominio, y `App.java` con un inventario de tus objetos
3. ✅ Pull request `week-06` → `main` con la descripción del paso 13

El cuestionario de la [rúbrica](rubrica-evaluacion.md) es tu autoevaluación: respóndelo antes de mirar las respuestas.

---

## ✅ Verificación

En tu proyecto:

```bash
./mvnw test
./mvnw -q compile exec:java
```

El primero debe terminar en `BUILD SUCCESS` con al menos 172 tests y `Failures: 0, Errors: 0`; el segundo, mostrar al final los dos rechazos y el resumen del inventario. En los ejercicios, cada paso descomentado debe dar la salida que muestra su README.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 05](../week-05-clases_y_objetos/README.md) | **Semana 06** | [Semana 07](../week-07-herencia/README.md) |

← [Volver al inicio del bootcamp](../../README.md)
