# 01 · Del problema a los requisitos

⏱️ 45 min

## 1. Antes del código, el problema

Hasta ahora te daban el método hecho o su especificación (el Javadoc) y tú lo programabas. En un proyecto real nadie te da el Javadoc: te dan un **problema**, contado por alguien que no programa. "Los socios se llevan libros y a veces no los devuelven" no dice qué métodos escribir.

Desarrollar software tiene tres actividades que se repiten en ciclos cortos:

| Actividad | Pregunta | Resultado |
|---|---|---|
| **Análisis** | ¿Qué problema resolvemos y qué debe hacer el sistema? | Requisitos, casos de uso, objetos del dominio |
| **Diseño** | ¿Cómo lo organizamos en clases y responsabilidades? | Clases, relaciones, diagramas (semanas 17 a 20) |
| **Programación** | ¿Cómo se escribe y se comprueba? | Código y tests |

Esta semana es de análisis. No hace falta tenerlo todo antes de programar: basta con entender lo bastante para escribir la siguiente capa sin adivinar.

## 2. El enunciado

Todo empieza con un **enunciado**: unas líneas que cuentan el problema con las palabras del cliente. El de la Biblioteca que usa el material:

> La biblioteca del barrio presta libros a sus socios. Cada libro tiene un código, un título, un autor y varios ejemplares. Un socio puede llevarse hasta tres libros durante 14 días. Si devuelve tarde, paga una multa de 0.30 USD por día, con un máximo de 6 USD, y no puede llevarse más libros hasta pagarla. El bibliotecario da de alta los libros nuevos y busca libros por el título.

Léelo con lápiz. Cada frase esconde algo que el sistema debe hacer, un dato que debe guardar o una regla que debe cumplir.

## 3. Requisitos funcionales

Un **requisito funcional** dice algo que el sistema debe **hacer**. Se escribe con una forma fija, para que se pueda comprobar:

```
RF-01  El sistema debe permitir al bibliotecario dar de alta un libro con su código, título, autor y ejemplares.
RF-02  El sistema debe permitir buscar libros por una parte de su título, sin distinguir mayúsculas.
RF-03  El sistema debe registrar el préstamo de un libro a un socio.
RF-04  El sistema debe calcular los días de retraso de una devolución.
RF-05  El sistema debe calcular la multa de una devolución tardía.
RF-06  El sistema debe impedir un préstamo si el socio tiene una multa pendiente o ya tiene tres libros.
```

Cada uno lleva un **identificador** (`RF-01`). Sirve para citarlo: en un caso de uso, en un test, en un *pull request*. Si un día alguien pregunta "¿por qué existe este método?", la respuesta es un identificador.

## 4. Reglas de negocio

Los números del enunciado (14 días, 0.30 USD, 6 USD, tres libros) son **reglas de negocio**: decisiones del cliente que el sistema aplica, pero que podrían cambiar mañana. Conviene escribirlas aparte:

```
RN-01  El préstamo dura 14 días.
RN-02  La multa es de 0.30 USD por día de retraso, con un tope de 6 USD.
RN-03  Un socio tiene como máximo 3 préstamos activos.
```

Ya programaste estas reglas en la semana 03: `Rules.overdueDays(1, 17, 14)`, `Rules.penalty(late, 0.30, 6.0)` y `Rules.canReserve(2, 3, fine)`. Los números entraban como argumentos y no dentro del método precisamente porque son reglas que cambian.

## 5. Requisitos no funcionales

Un **requisito no funcional** no dice qué hace el sistema, sino **cómo de bien** lo hace o con qué límites: rendimiento, facilidad de uso, plataforma, seguridad.

```
RNF-01  El sistema se ejecuta en Java 25 desde la terminal con ./mvnw -q compile exec:java.
RNF-02  Una búsqueda en un catálogo de 1 000 libros responde en menos de 1 segundo.
RNF-03  Los importes se muestran siempre con dos decimales y punto decimal.
```

## 6. Un requisito que se puede comprobar

La prueba de un buen requisito: ¿podrías escribir un test que diga si se cumple? Si no, está mal escrito.

| Mal | Por qué | Bien |
|---|---|---|
| El sistema debe ser rápido | ¿Cuánto es rápido? | Responde en menos de 1 segundo con 1 000 libros |
| El sistema gestiona los préstamos | "Gestionar" no dice qué hace | Registra un préstamo; calcula el retraso de una devolución |
| El sistema debe buscar bien | "Bien" no se mide | Encuentra los libros cuyo título contiene el texto, sin distinguir mayúsculas |
| Los socios no pueden abusar | ¿Abusar es qué? | Un socio tiene como máximo 3 préstamos activos |

Cuando no sabes cómo concretar un requisito, la respuesta no la inventas tú: **se la preguntas al cliente**. En el proyecto, tu cliente es el enunciado de tu dominio, que te asigna el instructor; lo que no diga, lo decides tú y lo escribes como regla de negocio.

## ✅ Comprueba que lo entendiste

1. "El sistema debe permitir renovar un préstamo una vez por 7 días más": ¿es funcional o no funcional? ¿Qué parte es una regla de negocio?
2. Reescribe "La aplicación debe ser fácil de usar" para que se pueda comprobar.
3. ¿Por qué `Rules.penalty` recibe la tarifa como argumento en lugar de tener `0.30` escrito dentro?

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Semana 04](../README.md) | **01 · Del problema a los requisitos** | [02 · Casos de uso](02-casos-de-uso.md) |
