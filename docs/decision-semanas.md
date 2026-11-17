# ADR: duración y ritmo

- Dedicación: 14 h por semana. La tabla de tiempos de cada README de semana suma exactamente 14 h; si suma más, se recorta alcance.
- Duración: 24 semanas, 336 h, en 5 fases (la malla está en el [índice de semanas](../bootcamp/README.md)). El número de semanas lo fija el temario: Java desde cero, los cuatro pilares con las herramientas modernas del lenguaje (records, `sealed`, pattern matching), Java profesional, análisis y diseño (UML, SOLID, patrones) y una integración real con base de datos y arquitectura.
- Orden: colecciones, genéricos y lambdas (fase 3) van antes que SOLID y patrones (fase 4), porque los patrones se escriben mejor con `List`, interfaces genéricas y lambdas.
- Tests desde la semana 01: cada proyecto arranca en rojo con JUnit y AssertJ. La semana 03 profundiza; la 21 añade Mockito, TDD y cobertura.
- Solapes: UML se enseña lo justo para diseñar el proyecto y enlaza a `bc-uml`; SQL y PostgreSQL a `bc-sql` y `bc-postgresql`; Git a `bc-git-github`; testing a `bc-testing`. Spring Boot no entra: es `bc-javaweb-sb`, que sigue a este bootcamp.
- Versión anterior (10 semanas x 4 h, `semana-NN/`, dominios dentro del repo): conservada en el tag `legacy-10w`, usada solo como materia prima.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Versiones del stack](stack-versions.md) | **Decisión de ritmo** | [Proyecto hilo conductor](proyecto-hilo-conductor.md) |

← [Volver al inicio del bootcamp](../README.md)
