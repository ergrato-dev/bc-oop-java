# Proyecto hilo conductor: el sistema de gestión de tu dominio

Durante 24 semanas construyes **un solo proyecto**: un sistema de gestión en Java para el dominio que te asigna el instructor (un hotel, una farmacia, un taller...). Cada semana añade una capa y el proyecto de la semana siguiente parte del de la anterior. Los ejemplos del bootcamp usan una **Biblioteca** (`Book`), que no se asigna a nadie.

| Fase | Semanas | Qué gana tu sistema |
|---|---|---|
| 1 · Java base | 01-04 | Validar y formatear datos de tu entidad con métodos estáticos y tests; el análisis del dominio (requisitos, sustantivos y verbos) |
| 2 · POO | 05-11 | La entidad principal como clase encapsulada, relaciones por composición, una jerarquía con polimorfismo, interfaces, records, enums y tipos `sealed`, igualdad y orden |
| 3 · Java profesional | 12-16 | Excepciones propias, paquetes, un repositorio en memoria con colecciones y genéricos, consultas con streams, guardar y cargar en JSON |
| 4 · Diseño | 17-21 | Diagramas UML del sistema, refactor con SOLID, patrones donde resuelven un problema real, tests con dobles y cobertura |
| 5 · Integración | 22-24 | Persistencia en PostgreSQL con JDBC, arquitectura hexagonal y la versión 1.0.0 |

Reglas:

- Repositorio `oop-java-<nombre>-<apellido>`, una rama `week-NN` por semana y un *pull request* hacia `main`.
- Nombres de clases, métodos y atributos en inglés y del dominio: `Room`, `pricePerNight`, no `Item` ni `precio`.
- `./mvnw test` en verde en cada entrega. Copiar el proyecto de otro dominio es 0 en Producto esa semana.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Decisión de ritmo](decision-semanas.md) | **Proyecto hilo conductor** | [Índice de semanas](../bootcamp/README.md) |

← [Volver al inicio del bootcamp](../README.md)
