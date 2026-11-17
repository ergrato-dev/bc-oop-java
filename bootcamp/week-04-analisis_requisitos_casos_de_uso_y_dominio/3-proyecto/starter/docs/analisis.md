# Análisis del sistema de gestión — TODO tu dominio

Sustituye cada marca pendiente por tu contenido: `AnalysisTest` falla mientras quede alguna. Los identificadores (`RF-01`, `CU-01`...) los cuenta `AnalysisTest`: numéralos con dos dígitos y sin repetir. Añade todas las filas y secciones que necesites.

## 1. Enunciado

TODO: entre 5 y 8 líneas que cuenten el problema con las palabras del cliente: qué hace el negocio, qué datos maneja, qué reglas tiene y quién usa el sistema.

## 2. Requisitos funcionales

Al menos 6. "El sistema debe..." y que se puedan comprobar.

| Id | Requisito |
|---|---|
| RF-01 | TODO El sistema debe ... |

## 3. Requisitos no funcionales

Al menos 2, medibles.

| Id | Requisito |
|---|---|
| RNF-01 | TODO |

## 4. Reglas de negocio

Al menos 3: los números de tu dominio (plazos, tarifas, topes, capacidades). Indica qué método de tu proyecto las usa.

| Id | Regla | Dónde se usa |
|---|---|---|
| RN-01 | TODO | TODO `Rules.overdueDays` |

## 5. Casos de uso

Al menos 2, cada uno con al menos dos flujos alternativos.

### CU-01 TODO Verbo y objeto

```
Actor:          TODO
Requisitos:     TODO RF-..
Precondición:   TODO

Flujo principal
  1. TODO
  2. TODO
  3. TODO

Flujos alternativos
  TODO 2a. ...: el sistema ... y ...

Postcondición:  TODO
```

## 6. Historias de usuario y criterios de aceptación

Al menos 1 historia con 4 criterios. Si un criterio tiene test en `MyDomainTest`, pon el nombre del test.

```
Como   TODO
quiero TODO
para   TODO
```

| Id | Dado | Cuando | Entonces | Test |
|---|---|---|---|---|
| CA-01 | TODO | TODO | TODO | TODO |

## 7. Objetos del dominio

Los sustantivos que quedan tras filtrar el enunciado, y los verbos repartidos.

| Objeto | Atributos | Operaciones | Viene de |
|---|---|---|---|
| TODO `Book` | TODO `code`, `title` | TODO `lend()` | TODO "Cada libro tiene..." |

Arrays paralelos de tu proyecto que son atributos de uno de estos objetos: TODO.

## 8. Tarjetas CRC

Al menos 3, una por objeto. El encabezado debe ser exactamente `### CRC: <Clase>`.

### CRC: TODO

| Responsabilidades | Colaboradores |
|---|---|
| TODO Sabe ... | TODO |
| TODO Calcula ... | |

Recorrido de CU-01 con las tarjetas:

| Paso | Tarjeta | Responsabilidad |
|---|---|---|
| 1 | TODO | TODO |

## 9. Glosario del dominio

Al menos 5 términos.

| Término | Significado | En el código |
|---|---|---|
| TODO | TODO | TODO |
