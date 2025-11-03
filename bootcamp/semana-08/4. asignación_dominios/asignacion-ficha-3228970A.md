# 🎯 Asignación de Dominios - Ficha 3228970A
## Semana 8: Colecciones y Programación Genérica

---

## 📋 Instrucciones Generales

Cada estudiante debe implementar un **sistema completo usando colecciones** basado en el dominio asignado. El proyecto debe demostrar:

- ✅ Uso correcto de **HashMap, ArrayList y Set**
- ✅ Implementación de **generics** con type safety
- ✅ **Operaciones CRUD** completas (Create, Read, Update, Delete)
- ✅ **Búsqueda y filtrado** eficientes
- ✅ **Validaciones** apropiadas
- ✅ **Menú interactivo** de consola
- ✅ **Código limpio** y documentado

---

## 👥 Asignación por Estudiante

### Estudiante 1: Sistema de Gestión de Biblioteca

**Dominio:** Biblioteca con libros, autores y préstamos

**Entidades:**
- `Libro`: ISBN, título, autor, editorial, año, categoría, disponible
- `Usuario`: ID, nombre, email, teléfono, tipo (estudiante/profesor)
- `Prestamo`: ID, libro, usuario, fechaPrestamo, fechaDevolucion, estado

**Estructuras de datos requeridas:**
- `Map<String, Libro>` - Libros por ISBN (búsqueda rápida)
- `Map<String, Usuario>` - Usuarios por ID
- `List<Prestamo>` - Historial de préstamos
- `Set<String>` - Categorías de libros

**Funcionalidades:**
1. Agregar/eliminar libros
2. Registrar usuarios
3. Realizar préstamo (verificar disponibilidad)
4. Devolver libro
5. Buscar libros por categoría/autor
6. Listar préstamos activos
7. Estadísticas (libros más prestados, usuarios activos)

---

### Estudiante 2: Sistema de Gestión de Hospital

**Dominio:** Hospital con pacientes, médicos y citas

**Entidades:**
- `Paciente`: ID, nombre, edad, email, teléfono, historialMedico
- `Medico`: ID, nombre, especialidad, email, horario
- `Cita`: ID, paciente, medico, fecha, hora, motivo, estado

**Estructuras de datos requeridas:**
- `Map<String, Paciente>` - Pacientes por ID
- `Map<String, Medico>` - Médicos por ID
- `List<Cita>` - Registro de citas
- `Map<String, List<Cita>>` - Citas agrupadas por médico

**Funcionalidades:**
1. Registrar pacientes y médicos
2. Agendar citas (verificar disponibilidad)
3. Buscar médicos por especialidad
4. Listar citas de un paciente
5. Listar agenda de un médico
6. Cancelar/reprogramar citas
7. Estadísticas (especialidades más demandadas)

---

### Estudiante 3: Sistema de Gestión de Tienda Online

**Dominio:** Tienda con productos, clientes y pedidos

**Entidades:**
- `Producto`: código, nombre, precio, stock, categoría, marca
- `Cliente`: ID, nombre, email, teléfono, dirección
- `Pedido`: ID, cliente, productos, total, fecha, estado

**Estructuras de datos requeridas:**
- `Map<String, Producto>` - Productos por código
- `Map<String, Cliente>` - Clientes por ID
- `List<Pedido>` - Historial de pedidos
- `Set<String>` - Marcas disponibles

**Funcionalidades:**
1. Agregar/actualizar productos (gestión de stock)
2. Registrar clientes
3. Crear pedido (validar stock)
4. Buscar productos por categoría/marca
5. Listar pedidos de un cliente
6. Calcular ventas totales
7. Productos con bajo stock (alerta)

---

### Estudiante 4: Sistema de Gestión de Universidad

**Dominio:** Universidad con estudiantes, cursos y matrículas

**Entidades:**
- `Estudiante`: código, nombre, programa, semestre, email
- `Curso`: código, nombre, créditos, profesor, cupo
- `Matricula`: ID, estudiante, curso, fechaMatricula, nota

**Estructuras de datos requeridas:**
- `Map<String, Estudiante>` - Estudiantes por código
- `Map<String, Curso>` - Cursos por código
- `List<Matricula>` - Registro de matrículas
- `Map<String, Set<String>>` - Estudiantes por programa

**Funcionalidades:**
1. Registrar estudiantes y cursos
2. Matricular estudiante (verificar cupo)
3. Asignar notas
4. Buscar cursos disponibles
5. Listar estudiantes de un curso
6. Calcular promedio de un estudiante
7. Estadísticas (cursos más demandados)

---

### Estudiante 5: Sistema de Gestión de Restaurante

**Dominio:** Restaurante con menú, pedidos y mesas

**Entidades:**
- `Plato`: código, nombre, precio, categoría, ingredientes
- `Mesa`: número, capacidad, estado (libre/ocupada)
- `Pedido`: ID, mesa, platos, total, fecha, estado

**Estructuras de datos requeridas:**
- `Map<String, Plato>` - Menú por código de plato
- `Map<Integer, Mesa>` - Mesas por número
- `List<Pedido>` - Registro de pedidos
- `Set<String>` - Categorías del menú

**Funcionalidades:**
1. Gestionar menú (agregar/eliminar platos)
2. Gestionar mesas
3. Crear pedido (asociar a mesa)
4. Calcular cuenta total
5. Buscar platos por categoría
6. Listar mesas disponibles
7. Estadísticas (platos más pedidos)

---

### Estudiante 6: Sistema de Gestión de Gimnasio

**Dominio:** Gimnasio con miembros, planes y asistencias

**Entidades:**
- `Miembro`: ID, nombre, edad, email, teléfono, planActivo
- `Plan`: código, nombre, duracion (meses), precio
- `Asistencia`: ID, miembro, fecha, horaEntrada, horaSalida

**Estructuras de datos requeridas:**
- `Map<String, Miembro>` - Miembros por ID
- `Map<String, Plan>` - Planes disponibles
- `List<Asistencia>` - Registro de asistencias
- `Set<Miembro>` - Miembros activos del día

**Funcionalidades:**
1. Registrar miembros y planes
2. Asignar plan a miembro
3. Registrar entrada/salida
4. Verificar membresía activa
5. Buscar miembros por plan
6. Calcular asistencias del mes
7. Estadísticas (horarios de mayor afluencia)

---

## 📦 Entregables

### 1. Código Fuente

**Estructura requerida:**
```
proyecto-dominio/
├── README.md
├── src/
│   ├── modelo/
│   │   ├── Entidad1.java
│   │   ├── Entidad2.java
│   │   └── Entidad3.java
│   ├── servicio/
│   │   └── GestorPrincipal.java
│   ├── util/
│   │   └── Validador.java
│   └── Main.java
└── docs/
    └── manual-usuario.md
```

### 2. Documentación

**README.md debe incluir:**
- Descripción del sistema
- Instrucciones de compilación y ejecución
- Capturas de pantalla del menú
- Diagrama de clases (opcional)
- Estructuras de datos utilizadas

**Javadoc:**
- Todas las clases documentadas
- Métodos principales con descripción

### 3. Casos de Prueba

**Archivo:** `PRUEBAS.md`

Documentar al menos 5 casos de prueba:
1. Agregar entidad válida
2. Búsqueda exitosa
3. Actualización de datos
4. Validación de error (duplicado, campo vacío)
5. Operación compleja (cálculo, filtrado)

---

## ✅ Criterios de Evaluación

| Criterio | Peso | Descripción |
|----------|------|-------------|
| **Uso de HashMap** | 20% | Implementación eficiente con clave-valor |
| **Uso de ArrayList/Set** | 15% | Uso apropiado según el contexto |
| **Generics** | 15% | Type safety en todas las colecciones |
| **Funcionalidad completa** | 20% | Todas las operaciones implementadas |
| **Validaciones** | 10% | Validación de datos y casos de error |
| **Código limpio** | 10% | Nombres descriptivos, organización |
| **Documentación** | 10% | README, Javadoc, comentarios |

**Nota mínima de aprobación:** 3.0/5.0

---

## 📅 Fechas Importantes

- **Inicio:** Semana 8, Día 1
- **Entrega:** Fin de Semana 8
- **Presentación:** Inicio de Semana 9

---

## 💡 Recomendaciones

1. **Comienza por el modelo**: Define bien tus clases de dominio
2. **Implementa paso a paso**: Empieza con operaciones básicas (CRUD)
3. **Prueba constantemente**: Verifica cada funcionalidad antes de continuar
4. **Usa la interfaz, no la implementación**: `Map<K,V>` en lugar de `HashMap<K,V>`
5. **Valida todo**: No asumas que los datos son correctos
6. **Documenta mientras codificas**: No dejes la documentación para el final

---

## 🚀 Desafíos Opcionales (Puntos Extra)

1. **Persistencia**: Guardar/cargar datos desde archivo
2. **Ordenamiento**: Múltiples criterios de ordenamiento
3. **Reportes**: Generar estadísticas avanzadas
4. **Interfaz mejorada**: Menú con colores/formato

---

## 📞 Soporte

- **Dudas técnicas**: Durante la sesión práctica
- **Consultas**: Foro del curso
- **Material de apoyo**: Carpeta `3-recursos/`

---

**¡Éxito en tu proyecto!** 🎓

---

*Semana 8 - Bootcamp POO Java - SENA - Ficha 3228970A*
