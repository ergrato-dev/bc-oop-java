# Semana 07: Manejo de Paquetes y Excepciones

![Bootcamp Java OOP](../../assets/bootcamp-header.svg)

## 📋 Información General

- **Duración**: 4 horas
- **Modalidad**: Presencial
- **Nivel**: Intermedio-Avanzado

---

## 🎯 Objetivos de Aprendizaje

Al finalizar esta semana, serás capaz de:

1. **Organizar código** usando paquetes (`package`, `import`)
2. **Manejar excepciones** con `try-catch-finally`
3. **Crear excepciones personalizadas** para tu dominio
4. **Entender la jerarquía** de excepciones en Java
5. **Aplicar buenas prácticas** en manejo de errores

---

## 📚 Contenido

### 1. Teoría (1.5 horas)

#### 📖 [01 - Organización en Paquetes](./1-teoria/01-organizacion-paquetes.md)
- Concepto de paquete
- Convenciones de nomenclatura
- `package` e `import`
- Estructura de directorios

#### 📖 [02 - Manejo de Excepciones](./1-teoria/02-manejo-excepciones.md)
- ¿Qué son las excepciones?
- `try-catch-finally`
- `throw` vs `throws`
- Propagación de excepciones

#### 📖 [03 - Jerarquía de Excepciones](./1-teoria/03-jerarquia-excepciones.md)
- Clase `Throwable`
- `Error` vs `Exception`
- `Exception` vs `RuntimeException`
- Checked vs Unchecked

#### 📖 [04 - Excepciones Personalizadas](./1-teoria/04-excepciones-personalizadas.md)
- Crear excepciones propias
- Cuándo crear excepciones personalizadas
- Buenas prácticas de naming
- Ejemplos por dominio

#### 📖 [05 - Buenas Prácticas](./1-teoria/05-buenas-practicas.md)
- No abusar de `catch(Exception e)`
- Documentar excepciones con `@throws`
- Cerrar recursos (try-with-resources)
- Logging de excepciones

---

### 2. Práctica (2 horas)

#### 💻 [Ejercicios Prácticos](./2-practica/README.md)
- Ejercicio 1: Crear paquetes y organizar clases
- Ejercicio 2: Manejo básico de excepciones
- Ejercicio 3: Crear excepciones personalizadas
- Ejercicio 4: Sistema integrado con paquetes y excepciones

---

### 3. Recursos (Consulta)

#### 📚 [Glosario](./3-recursos/glosario.md)
Términos clave de la semana

#### 🔗 [Referencias](./3-recursos/referencias.md)
Documentación oficial y recursos externos

#### 🎥 [Videos](./3-recursos/videos.md)
Material audiovisual complementario

---

### 4. Asignación de Dominios

#### 📝 [Ejercicios Semanales](./4.%20asignación_dominios/EJERCICIOS_SEMANALES.md)
Aplica paquetes y excepciones a tu dominio asignado

#### 📋 [Formato de Entrega](./4.%20asignación_dominios/FORMATO_ENTREGA.md)
Estructura y criterios de entrega

---

## 📊 Evaluación

### Evidencias de Aprendizaje

1. **Conocimiento (25%)**
   - Prueba teórica sobre jerarquía de excepciones
   - Cuestionario sobre `package` e `import`

2. **Desempeño (35%)**
   - Ejercicio creando paquetes
   - Manejo correcto de excepciones
   - Importación de clases

3. **Producto (40%)**
   - Proyecto con estructura de paquetes
   - Mínimo 2 excepciones personalizadas
   - Manejo robusto de errores

📄 **Ver**: [Rúbrica de Evaluación](./RUBRICA_EVALUACION.md)

---

## 🗓️ Cronograma Sugerido

| Tiempo | Actividad |
|--------|-----------|
| 0:00 - 0:30 | Introducción y teoría: Paquetes |
| 0:30 - 1:00 | Teoría: Excepciones básicas |
| 1:00 - 1:30 | Teoría: Jerarquía y excepciones personalizadas |
| 1:30 - 2:00 | Ejercicio práctico 1: Organizar en paquetes |
| 2:00 - 2:30 | Ejercicio práctico 2: Manejo de excepciones |
| 2:30 - 3:00 | Ejercicio práctico 3: Excepciones personalizadas |
| 3:00 - 3:45 | Trabajo en dominio asignado |
| 3:45 - 4:00 | Cierre y dudas |

---

## 🔗 Navegación

- [← Semana 06: Abstracción e Interfaces](../semana-06/README.md)
- [Semana 08: Colecciones y Genéricos →](../semana-08/README.md)
- [📂 Volver al índice](../../README.md)

---

## 📌 Notas Importantes

⚠️ **Importante**:
- Los paquetes deben seguir la convención de nombres en minúsculas
- Siempre manejar excepciones de forma específica, evitar `catch(Exception e)` genérico
- Documentar todas las excepciones que un método puede lanzar

💡 **Tip**:
- Usa excepciones personalizadas para comunicar errores de negocio específicos
- Las excepciones checked obligan al programador a manejarlas
- Las excepciones unchecked son para errores de programación

🎯 **Objetivo Integrador**:
En esta semana refactorizarás tu proyecto agregando:
1. Estructura de paquetes lógica
2. Manejo de excepciones en operaciones críticas
3. Excepciones personalizadas para tu dominio

---

**¡Organiza tu código y hazlo robusto con manejo de excepciones!** 🚀
