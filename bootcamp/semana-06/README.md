# Semana 06 - Abstracción e Interfaces 🎨

## 📋 Información General

**Duración:** 4 horas  
**Modalidad:** Presencial  
**Objetivo:** Dominar los conceptos de abstracción mediante clases abstractas e interfaces

---

## 🎯 Objetivos de Aprendizaje

Al finalizar esta semana, el estudiante será capaz de:

1. **Comprender** el concepto de abstracción y su importancia en el diseño
2. **Crear** y utilizar clases abstractas correctamente
3. **Definir** e implementar interfaces en Java
4. **Diferenciar** cuándo usar clases abstractas vs interfaces
5. **Aplicar** abstracción en el diseño de sistemas orientados a objetos
6. **Implementar** múltiples interfaces en una clase

---

## 📚 Temario

### 1. Concepto de Abstracción (30 min)
- ¿Qué es la abstracción?
- Abstracción vs Encapsulación
- Niveles de abstracción
- Ventajas de la abstracción

### 2. Clases Abstractas (60 min)
- Palabra clave `abstract`
- Métodos abstractos vs concretos
- Constructores en clases abstractas
- Uso de `super` en jerarquías abstractas
- Cuándo usar clases abstractas

### 3. Interfaces (60 min)
- Definición de interfaces
- Palabra clave `interface` e `implements`
- Métodos abstractos (antes de Java 8)
- Métodos default y static (Java 8+)
- Constantes en interfaces

### 4. Diferencias y Cuándo Usar Cada Una (30 min)
- Clases abstractas vs Interfaces
- Herencia simple vs múltiple
- Implementación múltiple de interfaces
- Casos de uso prácticos

### 5. Diseño con Abstracción (40 min)
- Principio de segregación de interfaces
- Diseño orientado a contratos
- Ejemplos prácticos del mundo real
- Ejercicio integrador

---

## 📂 Estructura de Contenidos

```
semana-06/
├── README.md (este archivo)
├── RUBRICA_EVALUACION.md
├── 0-assets/
│   ├── 1-abstraccion-concepto.svg
│   ├── 2-clases-abstractas.svg
│   ├── 3-interfaces-java.svg
│   ├── 4-abstracta-vs-interface.svg
│   ├── 5-implementacion-multiple.svg
│   └── 6-jerarquia-figuras.svg
├── 1-teoria/
│   ├── 01-concepto-abstraccion.md
│   ├── 02-clases-abstractas.md
│   ├── 03-interfaces.md
│   ├── 04-diferencias-y-comparacion.md
│   └── 05-diseno-con-abstraccion.md
├── 2-practica/
│   ├── README.md
│   ├── ejercicio-01-figuras/
│   ├── ejercicio-02-interfaces/
│   ├── ejercicio-03-empleados/
│   └── ejercicio-04-integracion/
├── 3-recursos/
│   ├── glosario.md
│   ├── referencias.md
│   └── errores-comunes.md
└── 4-ejercicios-semanales/
    ├── README.md
    └── instrucciones/
```

---

## ⏱️ Cronograma de la Sesión (4 horas)

### Bloque 1: Introducción y Clases Abstractas (90 min)
- **00:00 - 00:30** | Concepto de abstracción y motivación
- **00:30 - 01:00** | Clases abstractas: sintaxis y uso
- **01:00 - 01:30** | Ejercicio práctico: Figuras geométricas

### 🔄 Descanso (10 min)

### Bloque 2: Interfaces (90 min)
- **01:40 - 02:10** | Interfaces: definición e implementación
- **02:10 - 02:40** | Diferencias: abstractas vs interfaces
- **02:40 - 03:10** | Ejercicio práctico: Dispositivos electrónicos

### 🔄 Descanso (10 min)

### Bloque 3: Integración y Evaluación (70 min)
- **03:20 - 03:50** | Ejercicio integrador guiado
- **03:50 - 04:00** | Evaluación y cierre de sesión

---

## 🎓 Estrategias Didácticas

### Aprendizaje Basado en Problemas
- Casos del mundo real que requieren abstracción
- Diseño de sistemas escalables

### Codificación en Vivo
- Demostración paso a paso de clases abstractas
- Implementación de interfaces en tiempo real

### Pair Programming
- Ejercicios en parejas
- Revisión de código entre pares

### Debates Técnicos
- ¿Cuándo usar clase abstracta vs interface?
- Ventajas y desventajas de cada enfoque

---

## 📊 Evaluación

### Evidencias de Conocimiento (30%)
- Cuestionario sobre abstracción, clases abstractas e interfaces
- Preguntas sobre diferencias y casos de uso

### Evidencias de Desempeño (30%)
- Implementación de clase abstracta con métodos abstractos y concretos
- Creación e implementación de interfaces
- Código funcional durante la sesión

### Evidencias de Producto (40%)
- Proyecto de figuras geométricas con abstracción
- Sistema con múltiples interfaces implementadas
- Documentación del diseño (diagrama de clases)

**Consulta la [Rúbrica de Evaluación](./RUBRICA_EVALUACION.md) para criterios detallados.**

---

## 🎯 Conceptos Clave

| Concepto | Descripción |
|----------|-------------|
| **Abstracción** | Ocultar detalles complejos y mostrar solo lo esencial |
| **Clase Abstracta** | Clase que no puede instanciarse directamente, solo heredarse |
| **Método Abstracto** | Método sin implementación (solo firma) que debe ser implementado por subclases |
| **Interface** | Contrato que define métodos que una clase debe implementar |
| **implements** | Palabra clave para implementar una o más interfaces |
| **abstract** | Palabra clave para declarar clases o métodos abstractos |
| **Herencia Múltiple** | Una clase puede implementar múltiples interfaces (no permitido con clases) |

---

## 🔗 Relación con Semanas Anteriores

### Semana 04 - Herencia
- La abstracción extiende el concepto de herencia
- Clases abstractas como base de jerarquías

### Semana 05 - Polimorfismo
- Métodos abstractos permiten polimorfismo
- Interfaces como contratos polimórficos

### Preparación para Semana 07 - Paquetes y Excepciones
- Organización de interfaces y clases abstractas en paquetes
- Diseño modular del código

---

## 📦 Entregables de la Semana

### Trabajo Individual
1. **Ejercicios prácticos** completados durante la sesión
2. **Cuestionario teórico** sobre abstracción e interfaces

### Ejercicio Semanal (para el dominio asignado)
- Diseño con abstracción aplicado al dominio
- Ver carpeta `4-ejercicios-semanales/`

---

## 💡 Ejemplos del Mundo Real

### Clases Abstractas
- **Empleado** → EmpleadoPlanta, EmpleadoContrato
- **Cuenta** → CuentaAhorros, CuentaCorriente
- **Figura** → Circulo, Rectangulo, Triangulo

### Interfaces
- **Comparable** → Para comparar objetos
- **Serializable** → Para serializar objetos
- **Dibujable** → Para elementos que se pueden dibujar
- **Auditable** → Para registrar operaciones

---

## 🛠️ Herramientas y Recursos

### Software Necesario
- **JDK 11+** (instalado en semana 00)
- **IDE:** IntelliJ IDEA o VS Code con Extension Pack for Java

### Recursos de Apoyo
- Documentación oficial: [Oracle - Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- Documentación oficial: [Oracle - Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- Material en carpeta `1-teoria/`
- Glosario en carpeta `3-recursos/`

---

## ❓ Preguntas Frecuentes

### ¿Cuándo debo usar una clase abstracta?
Cuando tienes comportamiento común que quieres compartir entre subclases y estableces una relación "es-un".

### ¿Cuándo debo usar una interface?
Cuando defines un contrato o capacidad que pueden tener clases no relacionadas (relación "puede-hacer").

### ¿Puede una clase abstracta tener métodos concretos?
Sí, puede tener tanto métodos abstractos como métodos con implementación completa.

### ¿Puede una clase implementar múltiples interfaces?
Sí, Java permite implementar múltiples interfaces (herencia múltiple de comportamiento).

### ¿Una clase abstracta puede implementar interfaces?
Sí, y no está obligada a implementar todos sus métodos (las subclases lo harán).

---

## 📚 Lectura Preparatoria (Opcional)

Para aprovechar al máximo la sesión:

1. Repasar conceptos de **herencia** (semana 04)
2. Repasar **sobrescritura de métodos** (semana 05)
3. Leer: `1-teoria/01-concepto-abstraccion.md`

---

## 🎯 Objetivos de la Semana por Nivel

### Nivel Básico (Mínimo esperado)
✅ Crear una clase abstracta con 1 método abstracto  
✅ Crear 2 subclases concretas  
✅ Definir una interface simple  
✅ Implementar la interface en una clase

### Nivel Intermedio
✅ Todo lo anterior  
✅ Clase abstracta con métodos abstractos y concretos  
✅ Implementar 2+ interfaces en una clase  
✅ Usar abstracción en diseño de sistema

### Nivel Avanzado (Desafío)
✅ Todo lo anterior  
✅ Jerarquía compleja con múltiples niveles  
✅ Interfaces con métodos default  
✅ Diseño aplicando principios SOLID

---

## 📞 Soporte

Si tienes dudas durante la semana:
- 📧 Consulta con el instructor
- 👥 Participa en foros de discusión
- 💬 Sesión de apoyo (si aplica)

---

## 📝 Notas Importantes

⚠️ **Requerimientos previos:**
- Haber completado semanas 01-05
- Dominar conceptos de herencia y polimorfismo
- Tener ambiente de desarrollo configurado

⚠️ **Entregables obligatorios:**
- Ejercicios prácticos de la sesión
- Ejercicio semanal (según dominio asignado)
- Cuestionario teórico

⚠️ **Criterios de aprobación:**
- Mínimo 60/100 puntos en la rúbrica
- Entrega puntual de ejercicios
- Código funcional y compilable

---

## 🚀 Próxima Semana

**Semana 07 - Manejo de Paquetes y Excepciones**
- Organización del código en paquetes
- Manejo estructurado de errores
- Try-catch-finally
- Excepciones personalizadas

---

## 📖 Bibliografía

- Oracle. (2024). *The Java™ Tutorials - Abstract Classes and Interfaces*
- Bloch, J. (2018). *Effective Java* (3rd ed.). Addison-Wesley
- Sierra, K. & Bates, B. (2022). *Head First Java* (3rd ed.). O'Reilly

---

**¡Éxito en tu aprendizaje de Abstracción e Interfaces! 🎨✨**
