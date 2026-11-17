# bc-oop-java

Bootcamp de análisis, diseño y programación orientada a objetos con Java y UML, de cero a profesional. 24 semanas x 14 h = 336 h. Molde: `../bc-python`. Plan: `~/.claude/plans/revisar-que-este-bootcamp-shimmying-gray.md`. ADR: `docs/decision-semanas.md`.

Reglas duras:
- 14 h por semana: la tabla de tiempos de cada README de semana suma exactamente 14 h; si suma más, se recorta alcance.
- Tuteo siempre, nunca voseo. Prosa en español; código, identificadores, nombres técnicos y commits en inglés (Conventional Commits).
- Java 25 LTS (Temurin) y Maven con Maven Wrapper (`./mvnw`). PostgreSQL siempre, nunca MySQL. Docker solo donde haga falta un servicio.
- Versiones completas pinadas, nunca `latest`; verificar tag y CVEs antes de fijar (`docs/stack-versions.md`, con fecha y fuente).
- Carpeta de semana: `week-NN-slug_snake_case/{README.md,rubrica-evaluacion.md,0-assets,1-teoria,2-practicas,3-proyecto,4-recursos,5-glosario}`.
- Prácticas: `2-practicas/ejercicio-NN-slug/{README.md,starter/}`. Sin `solution/`. Son guiadas y **no se entregan**: un `Main.java` (archivo único) comentado por pasos (`// PASO N`); el aprendiz descomenta, ejecuta (`java Main.java`) y compara con la salida esperada del README.
- Único entregable semanal: el proyecto en el dominio asignado, en el repo `oop-java-<nombre>-<apellido>` del aprendiz, rama `week-NN` → PR a `main`. Starter Maven (`pom.xml` + wrapper) con JUnit 5 y AssertJ; `./mvnw test` arranca en rojo y termina en verde.
- Solución del proyecto: en `ergrato-dev/bc-instructor`, `bc-oop-java/week-NN-slug/3-proyecto/`, nunca en este repo.
- Dominios: el catálogo vive en `ergrato-dev/bc-dominios` (`catalogos/bc-oop-java.md`). Aquí no hay `docs/dominios.md`; los textos dicen que el dominio lo asigna el instructor. Ejemplos del material: Biblioteca (`Book`), reservado.
- Ejercicios paso a paso, sin dar nada por sabido: comando exacto, salida esperada y tabla "🧯 Si algo sale mal".
- Comentarios de código: qué / para qué / impacto, solo donde aportan, sin repetirse.
- SVG según necesidad real de la teoría; cada SVG se referencia desde una teoría. Tema oscuro, colores planos (sin degradados), solo fuentes sans-serif (nada de monospace).
- Todo `.md` de semana termina con tabla `## 🔗 Navegación` (Anterior | Actual | Siguiente).
- Rúbrica 30/40/30 (conocimiento/desempeño/producto), mínimo 70% por evidencia.
- Un proyecto hilo conductor (`docs/proyecto-hilo-conductor.md`).
- Rediseño en bloques de 5 semanas por sesión, un commit por semana. La versión anterior (10 semanas x 4 h) vive en el tag `legacy-10w`.
- Antes de cada commit: `./scripts/verificar-enlaces.sh` en verde. Al publicar una semana, marcarla ✅ en `bootcamp/README.md`.
