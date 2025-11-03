# 🎯 PROYECTO FINAL - Bootcamp POO Java

## Descripción General

Desarrollar un **sistema de información completo** aplicando todos los principios de Programación Orientada a Objetos aprendidos durante el bootcamp.

---

## 🏆 Objetivos

1. Integrar los 4 pilares de POO: Encapsulación, Herencia, Polimorfismo y Abstracción
2. Aplicar colecciones (ArrayList, HashMap) para gestionar datos
3. Implementar manejo robusto de excepciones
4. Diseñar una arquitectura modular y escalable
5. Documentar el sistema con UML y comentarios Javadoc
6. Demostrar dominio técnico mediante presentación oral

---

## 📋 Dominios Disponibles

Elige **UNO** de los siguientes dominios (ver asignaciones por ficha):

1. **Sistema de Biblioteca** - Gestión de libros, préstamos, usuarios
2. **Sistema Hospitalario** - Pacientes, médicos, citas, historias clínicas
3. **Tienda en Línea** - Productos, pedidos, clientes, inventario
4. **Universidad** - Estudiantes, profesores, cursos, inscripciones
5. **Restaurante** - Menú, pedidos, mesas, empleados
6. **Gimnasio** - Socios, rutinas, entrenadores, membresías
7. **Banco** - Cuentas, transacciones, clientes, préstamos
8. **Hotel** - Habitaciones, reservas, huéspedes, servicios
9. **Veterinaria** - Mascotas, dueños, citas, tratamientos
10. **Transporte** - Vehículos, rutas, conductores, pasajeros

---

## ⚙️ Requisitos Mínimos Obligatorios

### 1. Programación Orientada a Objetos (40%)

#### ✅ Encapsulación (8%)
- Todos los atributos deben ser `private`
- Implementar getters y setters con validaciones
- Mínimo **5 atributos validados** (no null, rangos, formatos)

#### ✅ Herencia (10%)
- Crear **1 jerarquía** con:
  - 1 clase padre (puede ser abstracta o concreta)
  - Mínimo **2 clases hijas**
  - Uso de `super()` en constructores
  - Ejemplo: `Persona` → `Cliente`, `Empleado`

#### ✅ Polimorfismo (10%)
- **Sobrecarga** (overload): Mínimo 2 métodos con mismo nombre, diferentes parámetros
- **Sobrescritura** (override): Mínimo 2 métodos con `@Override`
- **Colecciones polimórficas**: Usar tipo padre para almacenar hijos
  - Ejemplo: `List<Persona> personas` que contiene clientes y empleados

#### ✅ Abstracción (6%)
- Implementar **AL MENOS UNO** de estos:
  - **Opción A**: 1 clase abstracta con método abstracto
  - **Opción B**: 1 interface con implementación
- El método/interfaz debe ser usado en la lógica del sistema

#### ✅ Excepciones (6%)
- Crear mínimo **2 excepciones personalizadas**
  - Ejemplo: `LibroNoEncontradoException`, `PrestamoVencidoException`
- Usar `try-catch-finally` en mínimo **3 lugares**
- Validar datos con excepciones (no solo `if-else`)

### 2. Colecciones (30%)

#### ✅ ArrayList (8%)
- Usar `ArrayList<>` para almacenar objetos relacionados
- Implementar operaciones: add, remove, get, size, clear
- Ejemplo: Historial de pedidos de un cliente

#### ✅ HashMap (8%)
- Usar `HashMap<K, V>` para búsquedas rápidas por clave única
- Implementar operaciones: put, get, remove, containsKey
- Ejemplo: `HashMap<String, Producto>` para buscar por código

#### ✅ Iteración (4%)
- Recorrer colecciones con:
  - `for-each` loop
  - `Iterator` (opcional)
- Mostrar información de todos los elementos

### 3. Funcionalidad del Sistema (20%)

#### ✅ Menú Interactivo (5%)
- Menú principal con `Scanner`
- Mínimo **6 opciones** + Salir
- Navegación clara y sin errores

#### ✅ Operaciones CRUD (10%)
- **Create**: Agregar nuevos registros
- **Read**: Buscar y listar registros
- **Update**: Modificar registros existentes
- **Delete**: Eliminar registros (con confirmación)

#### ✅ Validaciones (5%)
- Validar entradas del usuario (no vacías, formatos correctos)
- Manejar errores de Scanner (InputMismatchException)
- Mensajes claros de error

### 4. Documentación (10%)

#### ✅ README.md (3%)
- Descripción del proyecto
- Instrucciones de compilación y ejecución
- Funcionalidades implementadas
- Autor y ficha

#### ✅ Diagrama UML (4%)
- Diagrama de clases mostrando:
  - Atributos y métodos
  - Relaciones de herencia
  - Asociaciones entre clases
- Formato PNG o PDF (usar draw.io, Lucidchart, etc.)

#### ✅ Comentarios Javadoc (3%)
- Javadoc en clases principales
- Javadoc en métodos públicos
- Comentarios explicativos en lógica compleja

---

## 📁 Estructura del Proyecto

```
tu-proyecto/
├── src/
│   ├── modelo/              ← Clases del dominio (entidades)
│   │   ├── Persona.java
│   │   ├── Cliente.java
│   │   ├── Empleado.java
│   │   └── ...
│   ├── servicio/            ← Lógica de negocio (CRUD)
│   │   ├── ClienteServicio.java
│   │   └── ...
│   ├── excepciones/         ← Excepciones personalizadas
│   │   ├── ClienteNoEncontradoException.java
│   │   └── ...
│   ├── util/                ← Utilidades (validadores, helpers)
│   │   └── Validador.java
│   └── Main.java            ← Punto de entrada con menú
├── docs/
│   ├── diagrama-clases.png  ← UML
│   └── informe-tecnico.pdf  ← Opcional: reporte de decisiones
└── README.md
```

---

## 📦 Entrega

### Formato
- **Archivo**: `proyecto-final-[NombreApellido]-[Ficha].zip`
- **Ejemplo**: `proyecto-final-JuanPerez-3228970A.zip`

### Contenido del ZIP
```
proyecto-final-JuanPerez-3228970A/
├── src/                     ← Código fuente completo
├── docs/
│   └── diagrama-clases.png
└── README.md
```

### Fecha de Entrega
- **Plazo**: [CONSULTAR CON INSTRUCTOR]
- **Medio**: Plataforma LMS del SENA o correo institucional

---

## 🎤 Presentación Oral (30% Conocimiento)

### Duración: 10-15 minutos

### Estructura
1. **Introducción** (2 min)
   - Dominio elegido
   - Problema que resuelve el sistema

2. **Demostración** (5 min)
   - Ejecutar el programa
   - Mostrar funcionalidades principales
   - Crear, buscar, actualizar, eliminar registros

3. **Explicación Técnica** (5 min)
   - Mostrar diagrama UML
   - Explicar jerarquía de clases
   - Ejemplos de polimorfismo en código
   - Cómo se usan las colecciones
   - Manejo de excepciones

4. **Conclusiones** (2 min)
   - Desafíos enfrentados
   - Aprendizajes clave

### Criterios de Evaluación
- Claridad en la explicación
- Dominio técnico (responde preguntas sobre su código)
- Funcionamiento correcto del sistema
- Capacidad de explicar decisiones de diseño

---

## 🏅 Criterios de Aprobación

### Para obtener 3.5 o más:
- ✅ Cumplir **TODOS** los requisitos mínimos obligatorios
- ✅ Sistema funcional sin errores críticos
- ✅ Presentación oral coherente

### Para obtener 4.0 - 4.5:
- ✅ Cumplir requisitos mínimos
- ✅ Implementar validaciones avanzadas
- ✅ Código limpio y bien organizado
- ✅ Presentación con explicación técnica sólida

### Para obtener 4.6 - 5.0:
- ✅ Todo lo anterior
- ✅ Implementar patrones de diseño (Factory, Singleton, Strategy)
- ✅ Genéricos (`<T>`) en al menos 1 clase
- ✅ Informe técnico detallado (PDF)
- ✅ Testing básico con casos de prueba
- ✅ Presentación profesional y defensa técnica impecable

---

## ⚠️ Penalizaciones

- **-0.5**: Código no compila
- **-0.3**: Falta README o UML
- **-0.2**: No maneja excepciones adecuadamente
- **-0.2**: Atributos públicos (sin encapsulación)
- **-0.5**: No cumple requisitos mínimos de POO (herencia, polimorfismo, abstracción)
- **-1.0**: Plagio detectado (ver Política Anticopia)

---

## 💡 Recomendaciones

1. **Inicia con el Taller Preparatorio** para practicar la estructura
2. **Diseña antes de programar**: Boceto UML en papel
3. **Avanza incremental**: Primero modelo, luego servicio, luego menú
4. **Prueba constantemente**: Compila y ejecuta después de cada cambio
5. **Consulta el [Checklist de Proyecto](../../3-recursos/checklist-proyecto.md)**
6. **Revisa los [ejemplos de sistemas](../ejemplos/)**
7. **Pide retroalimentación** durante las tutorías

---

## 📚 Recursos de Apoyo

- [Repaso de POO](../../1-teoria/01-repaso-poo.md)
- [Buenas Prácticas](../../1-teoria/03-buenas-practicas.md)
- [Documentación UML](../../1-teoria/04-documentacion-uml.md)
- [Glosario de Términos](../../3-recursos/glosario.md)
- [Checklist Completo](../../3-recursos/checklist-proyecto.md)

---

## ❓ Preguntas Frecuentes

### ¿Puedo usar un dominio diferente?
Sí, pero debe ser aprobado previamente por el instructor.

### ¿Necesito base de datos?
No, usa colecciones en memoria (ArrayList, HashMap).

### ¿Puedo trabajar en equipo?
Este es un proyecto **individual**.

### ¿Cuántas clases debo crear?
Mínimo 5 clases de dominio + servicios + excepciones.

### ¿Es obligatorio el patrón Strategy/Factory?
No, son opcionales para puntos bonus (4.6+).

---

## 📞 Contacto y Soporte

- **Instructor**: [Nombre del Instructor]
- **Tutorías**: [Horarios y plataforma]
- **Dudas técnicas**: [Canal de Slack/Teams/Discord]

---

**¡Éxito en tu proyecto final! 🚀**

Ver también:
- [Requisitos Detallados](requisitos.md)
- [Ejemplos de Sistemas](../ejemplos/)
- [Plantilla de Proyecto](../plantilla/)
