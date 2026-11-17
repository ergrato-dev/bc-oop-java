# Versiones del stack

Versiones completas y fijadas. Antes de subir una, comprueba el tag en la fuente y los avisos de
seguridad en [OSV](https://osv.dev). Última revisión: **2026-11-16**.

| Herramienta | Versión | Dónde se fija | Fuente |
|---|---|---|---|
| JDK (Eclipse Temurin) | 25.0.5+8 LTS | `docs/setup.md` (instalación) y `maven.compiler.release` = 25 | [Adoptium API](https://api.adoptium.net/v3/assets/latest/25/hotspot) |
| Maven | 3.10.0 | `.mvn/wrapper/maven-wrapper.properties` de cada starter | [Maven Central](https://repo1.maven.org/maven2/org/apache/maven/apache-maven/) |
| Maven Wrapper | 3.3.4 | `./mvnw` de cada starter | [Maven Central](https://repo1.maven.org/maven2/org/apache/maven/wrapper/maven-wrapper/) |
| JUnit (BOM) | 6.1.3 | `pom.xml` | [Maven Central](https://repo1.maven.org/maven2/org/junit/junit-bom/) |
| AssertJ | 3.27.7 | `pom.xml` | [Maven Central](https://repo1.maven.org/maven2/org/assertj/assertj-core/) |
| maven-compiler-plugin | 3.16.0 | `pom.xml` | [Maven Central](https://repo1.maven.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/) |
| maven-surefire-plugin | 3.6.1 | `pom.xml` | [Maven Central](https://repo1.maven.org/maven2/org/apache/maven/plugins/maven-surefire-plugin/) |
| exec-maven-plugin | 3.7.0 | `pom.xml` | [Maven Central](https://repo1.maven.org/maven2/org/codehaus/mojo/exec-maven-plugin/) |
| Imagen Maven (verificación en CI y Docker) | `maven:3.10.0-eclipse-temurin-25-noble` | `.github/workflows/verificar.yml` | [Docker Hub](https://hub.docker.com/_/maven) |

Se añaden cuando la semana los use: Mockito y JaCoCo (semana 21), driver JDBC de PostgreSQL y
PostgreSQL 18 (semana 22).

JUnit 6 es la versión actual de JUnit Jupiter (la API `org.junit.jupiter` de JUnit 5 sin
cambios para lo que usa el curso); el material dice "JUnit" a secas.

---

## 🔗 Navegación

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [Preparar el entorno](setup.md) | **Versiones del stack** | [Decisión de ritmo](decision-semanas.md) |

← [Volver al inicio del bootcamp](../README.md)
