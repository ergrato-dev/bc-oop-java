# Semana 09 - Proyecto Final Aplicado

## 🎯 Objetivo General

Integrar todos los principios de la Programación Orientada a Objetos mediante el desarrollo de un sistema completo que demuestre el dominio de: **encapsulación, herencia, polimorfismo, abstracción, manejo de excepciones y colecciones**.

---

## 📋 Descripción

Esta semana representa la **culminación del bootcamp**. Los estudiantes diseñarán, implementarán y documentarán un **mini sistema funcional** que integre todos los conceptos aprendidos durante las 8 semanas anteriores.

**Duración**: 4 horas presenciales + trabajo autónomo

---

## 🎓 Competencias a Desarrollar

### Conocimiento
- Explicar la aplicación de los 4 pilares de POO en el proyecto
- Justificar decisiones de diseño orientado a objetos
- Documentar la arquitectura del sistema con UML

### Desempeño
- Implementar un sistema con jerarquías de clases coherentes
- Aplicar polimorfismo en métodos y colecciones
- Manejar excepciones personalizadas apropiadamente
- Utilizar colecciones genéricas según el caso de uso

### Producto
- Sistema funcional con menú interactivo
- Código documentado y organizado en paquetes
- Diagramas UML (clases y casos de uso)
- Informe técnico del proyecto

---

## 📚 Estructura de la Semana

```
semana-09/
├── README.md
├── RUBRICA_EVALUACION.md
├── rubrica_evaluacion.json
├── rubrica_evaluacion.yaml
├── 0-assets/
│   ├── README.md
│   └── [diagramas SVG]
├── 1-teoria/
│   ├── 01-repaso-poo.md
│   ├── 02-patrones-diseno-basicos.md
│   ├── 03-buenas-practicas.md
│   └── 04-documentacion-uml.md
├── 2-practica/
│   ├── proyecto-final/
│   │   ├── enunciado/
│   │   │   ├── ENUNCIADO.md
│   │   │   └── requisitos.md
│   │   ├── ejemplos/
│   │   │   ├── sistema-biblioteca/
│   │   │   ├── sistema-hospital/
│   │   │   └── sistema-tienda/
│   │   └── plantilla/
│   │       ├── README.md
│   │       └── estructura-proyecto.md
│   └── taller-preparatorio/
│       ├── ENUNCIADO.md
│       └── solucion/
├── 3-recursos/
│   ├── glosario.md
│   ├── referencias.md
│   ├── videos.md
│   └── checklist-proyecto.md
└── 4. asignación_dominios/
    ├── asignacion-ficha-3228970A.md
    ├── asignacion-ficha-3228970B.md
    └── asignacion-ficha-3228973A.md
```

---

## 🗓️ Cronograma de la Sesión (4 horas)

### **Hora 1: Repaso y Diseño (60 min)**

#### Minutos 0-20: Repaso Conceptual
- Revisión de los 4 pilares de POO
- Patrones de diseño básicos aplicables
- Mejores prácticas en Java

#### Minutos 20-40: Presentación del Proyecto Final
- Análisis de requisitos
- Opciones de dominios (según asignación)
- Criterios de evaluación

#### Minutos 40-60: Diseño UML
- Diagrama de casos de uso
- Diagrama de clases inicial
- Identificación de relaciones

---

### **Hora 2: Implementación - Parte 1 (60 min)**

#### Minutos 60-80: Estructura Base
- Creación de paquetes
- Clases del modelo de dominio
- Implementación de encapsulación

#### Minutos 80-100: Herencia y Abstracción
- Diseño de jerarquías
- Clases abstractas e interfaces
- Métodos abstractos vs concretos

#### Minutos 100-120: Pruebas Iniciales
- Creación de objetos
- Validación de constructores
- Testing manual básico

---

### **Hora 3: Implementación - Parte 2 (60 min)**

#### Minutos 120-140: Polimorfismo y Colecciones
- Implementación de métodos polimórficos
- Uso de ArrayList, HashMap según caso
- Operaciones CRUD básicas

#### Minutos 140-160: Excepciones Personalizadas
- Creación de excepciones del dominio
- Manejo de try-catch-finally
- Validaciones robustas

#### Minutos 160-180: Lógica de Negocio
- Servicios y operaciones complejas
- Búsquedas y filtros
- Cálculos y procesamientos

---

### **Hora 4: Integración y Presentación (60 min)**

#### Minutos 180-200: Interfaz de Usuario
- Menú interactivo con Scanner
- Navegación entre opciones
- Manejo de entrada del usuario

#### Minutos 200-220: Documentación
- Comentarios Javadoc
- README del proyecto
- Actualización de diagramas UML

#### Minutos 220-235: Pruebas Finales
- Testing de funcionalidades completas
- Corrección de errores
- Validación de requisitos

#### Minutos 235-240: Cierre y Entrega
- Instrucciones de entrega
- Fecha límite y formato
- Sesión de preguntas y respuestas

---

## 📖 Contenido Teórico

### [01. Repaso de POO](1-teoria/01-repaso-poo.md)
- Los 4 pilares revisitados con ejemplos
- Cuándo aplicar cada principio
- Errores comunes a evitar

### [02. Patrones de Diseño Básicos](1-teoria/02-patrones-diseno-basicos.md)
- Singleton (instancia única)
- Factory (creación de objetos)
- Strategy (comportamientos intercambiables)

### [03. Buenas Prácticas en Java](1-teoria/03-buenas-practicas.md)
- Convenciones de código
- SOLID (introducción)
- Code smells y refactoring

### [04. Documentación y UML](1-teoria/04-documentacion-uml.md)
- Diagramas de clases detallados
- Diagramas de casos de uso
- Herramientas: draw.io, PlantUML, Lucidchart

---

## 💻 Práctica

### Taller Preparatorio
**Objetivo**: Practicar integración de conceptos en un ejercicio guiado antes del proyecto final.

**Sistema de ejemplo**: Gestión de Vehículos
- Jerarquía: Vehiculo → Auto, Moto, Camion
- Uso de polimorfismo para calcular costos
- HashMap para registro de vehículos
- Excepciones personalizadas

### Proyecto Final

**Opciones de Dominios** (según asignación por ficha):

1. **Sistema de Biblioteca**
2. **Sistema de Hospital**
3. **Sistema de Tienda Online**
4. **Sistema de Universidad**
5. **Sistema de Restaurante**
6. **Sistema de Gimnasio**
7. **Sistema de Banco**
8. **Sistema de Hotel**
9. **Sistema de Veterinaria**
10. **Sistema de Transporte**

Cada estudiante tiene un dominio asignado con requisitos específicos.

---

## 🎯 Requisitos Mínimos del Proyecto

### Orientación a Objetos (40%)
- ✅ Mínimo 5 clases del dominio
- ✅ Al menos 1 jerarquía de herencia (clase padre + 2 hijos)
- ✅ Uso de clase abstracta o interface
- ✅ Polimorfismo aplicado (sobrecarga y sobrescritura)
- ✅ Encapsulación completa (atributos privados, getters/setters)

### Colecciones y Excepciones (30%)
- ✅ Uso de ArrayList o LinkedList
- ✅ Uso de HashMap o TreeMap
- ✅ Iteración con for-each o Iterator
- ✅ Mínimo 2 excepciones personalizadas
- ✅ Manejo apropiado de try-catch

### Funcionalidad (20%)
- ✅ Menú interactivo funcional
- ✅ Operaciones CRUD completas (crear, leer, actualizar, eliminar)
- ✅ Mínimo 6 funcionalidades distintas
- ✅ Validaciones de datos
- ✅ Búsquedas y filtros

### Documentación (10%)
- ✅ README con instrucciones de ejecución
- ✅ Diagrama de clases UML
- ✅ Comentarios en código
- ✅ Informe técnico breve

---

## 📊 Evidencias de Evaluación

### Conocimiento (30%)
- Presentación oral del proyecto (10 minutos)
- Explicación de decisiones de diseño OO
- Respuestas a preguntas técnicas sobre implementación

### Desempeño (40%)
- Código fuente organizado y funcional
- Aplicación correcta de POO
- Uso apropiado de colecciones y excepciones
- Implementación de requisitos mínimos

### Producto (30%)
- Sistema completamente funcional
- Documentación técnica completa
- Diagramas UML actualizados
- Código limpio y comentado

**Ver**: [RUBRICA_EVALUACION.md](RUBRICA_EVALUACION.md) para criterios detallados

---

## 🛠️ Herramientas Recomendadas

### Desarrollo
- **IDE**: IntelliJ IDEA Community / Eclipse / VS Code
- **JDK**: 11 o superior
- **Control de versiones**: Git (opcional pero recomendado)

### Diseño UML
- **draw.io** (online, gratuito)
- **Lucidchart** (online)
- **PlantUML** (text-based)
- **StarUML** (desktop)

### Documentación
- **Markdown** para README
- **Javadoc** para documentación de código
- **PDF** para informe final

---

## 📦 Entrega del Proyecto

### Formato de Entrega
Carpeta comprimida (.zip) con la siguiente estructura:

```
ApellidoNombre-ProyectoFinal/
├── src/
│   └── [código fuente organizado en paquetes]
├── docs/
│   ├── diagrama-clases.png
│   ├── diagrama-casos-uso.png
│   └── informe-tecnico.pdf
├── README.md
└── ejecutar.sh (opcional)
```

### Contenido Obligatorio
1. **Código fuente** compilable y ejecutable
2. **README.md** con:
   - Descripción del sistema
   - Instrucciones de compilación y ejecución
   - Requisitos (JDK version)
   - Autor y fecha
3. **Diagrama de clases** (imagen PNG/JPG o PDF)
4. **Informe técnico** (1-2 páginas) explicando:
   - Decisiones de diseño OO
   - Principios de POO aplicados
   - Dificultades encontradas y soluciones

### Criterios de Aceptación
- ✅ Compila sin errores
- ✅ Ejecuta sin excepciones no manejadas
- ✅ Cumple requisitos mínimos de POO
- ✅ Documentación completa
- ✅ Entrega en plazo establecido

---

## 🌟 Consejos para el Éxito

### Antes de Codificar
1. 📝 **Analiza bien los requisitos** antes de escribir código
2. 🎨 **Diseña el diagrama de clases** primero
3. 🤔 **Identifica las relaciones** entre entidades
4. 📋 **Lista las funcionalidades** CRUD necesarias

### Durante el Desarrollo
1. 💾 **Guarda frecuentemente** tu trabajo
2. 🧪 **Prueba cada funcionalidad** conforme la implementas
3. 📝 **Comenta tu código** mientras escribes
4. 🔄 **Refactoriza** cuando veas código duplicado

### Gestión del Tiempo
- **Hora 1**: Diseño y estructura base (30% del proyecto)
- **Horas 2-3**: Implementación core (60% del proyecto)
- **Hora 4**: Testing, documentación y pulido (10% del proyecto)

### Si Te Atoras
1. 🔍 Revisa el material de semanas anteriores
2. 💬 Pregunta al instructor o compañeros
3. 🌐 Consulta la documentación oficial de Java
4. 🎯 Simplifica: mejor un proyecto simple funcional que uno complejo incompleto

---

## 📚 Material de Apoyo

- [📖 Glosario Completo](3-recursos/glosario.md)
- [🔗 Referencias y Enlaces](3-recursos/referencias.md)
- [📹 Videos Tutoriales](3-recursos/videos.md)
- [✅ Checklist de Proyecto](3-recursos/checklist-proyecto.md)

---

## 🎓 Contexto del Bootcamp

Esta semana cierra el bootcamp de **Diseño y Programación Orientada a Objetos con Java**:

| Semana | Tema | Integrado en Proyecto Final |
|--------|------|----------------------------|
| 00 | Fundamentos de Java | ✅ Sintaxis, variables, estructuras |
| 01 | Introducción a POO | ✅ Clases y objetos |
| 02 | Clases y Objetos | ✅ Modelado de entidades |
| 03 | Encapsulación | ✅ Atributos privados, getters/setters |
| 04 | Herencia | ✅ Jerarquías de clases |
| 05 | Polimorfismo | ✅ Sobrecarga y sobrescritura |
| 06 | Abstracción | ✅ Clases abstractas e interfaces |
| 07 | Excepciones | ✅ Manejo robusto de errores |
| 08 | Colecciones | ✅ ArrayList, HashMap, iteradores |
| **09** | **Proyecto Final** | **🎯 Integración total** |

---

## 🏆 Criterio de Aprobación

Para aprobar el bootcamp, el proyecto final debe:

- **Mínimo 70%** en la rúbrica de evaluación
- **Cumplir todos los requisitos mínimos** obligatorios
- **Ser entregado en el plazo** establecido
- **Demostrar funcionalidad** en presentación

---

## 📅 Fechas Importantes

- **Inicio del proyecto**: Semana 09, sesión presencial
- **Asesorías**: Durante la semana (horario a confirmar)
- **Entrega**: [Fecha límite según calendario institucional]
- **Presentaciones**: [Fecha según calendario institucional]

---

## 💡 Mensaje Final

Este proyecto es tu oportunidad de demostrar todo lo aprendido. **No busques la perfección, busca la funcionalidad**. Es mejor un sistema sencillo pero completo y funcional, que uno ambicioso pero incompleto.

Recuerda: **El código se aprende escribiendo código**. ¡Manos a la obra! 💻🚀

---

**Duración**: 4 horas presenciales + trabajo autónomo  
**Nivel**: Integrador - Semana 09 de 10  
**Requisito**: Haber cursado semanas 00-08

---

> "La programación orientada a objetos no es solo una forma de organizar código, es una forma de pensar sobre problemas y soluciones." - Anónimo
