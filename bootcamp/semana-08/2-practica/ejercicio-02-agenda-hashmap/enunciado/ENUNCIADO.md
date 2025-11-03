# 📱 Ejercicio 2: Agenda de Contactos con HashMap

## 🎯 Objetivo

Crear un sistema de **agenda de contactos** utilizando `HashMap` para almacenar y gestionar información de contactos con búsqueda rápida por ID o nombre.

---

## 📋 Requisitos Funcionales

### 1. Modelo de Datos

Crear una clase `Contacto` con los siguientes atributos:
- `id` (String): Identificador único (ej: "C001")
- `nombre` (String): Nombre completo del contacto
- `telefono` (String): Número de teléfono
- `email` (String): Correo electrónico
- `categoria` (String): Categoría (ej: "Familia", "Trabajo", "Amigos")

### 2. Sistema de Gestión

Implementar una clase `AgendaContactos` que permita:

**Operaciones básicas:**
- ✅ Agregar un nuevo contacto
- ✅ Buscar contacto por ID
- ✅ Buscar contactos por nombre (puede haber varios con el mismo nombre)
- ✅ Actualizar información de un contacto
- ✅ Eliminar un contacto por ID
- ✅ Listar todos los contactos

**Operaciones avanzadas:**
- ✅ Buscar contactos por categoría
- ✅ Verificar si un email ya está registrado
- ✅ Contar contactos por categoría
- ✅ Exportar contactos a formato legible (toString mejorado)

### 3. Menú Interactivo

Crear un menú de consola con las siguientes opciones:

```
=== AGENDA DE CONTACTOS ===
1. Agregar contacto
2. Buscar por ID
3. Buscar por nombre
4. Actualizar contacto
5. Eliminar contacto
6. Listar todos
7. Buscar por categoría
8. Estadísticas
9. Salir
Opción: _
```

---

## 💻 Estructura de Clases

```
ejercicio-02-agenda-hashmap/
├── enunciado/
│   └── ENUNCIADO.md (este archivo)
└── solucion/
    └── src/
        ├── modelo/
        │   └── Contacto.java
        ├── servicio/
        │   └── AgendaContactos.java
        ├── util/
        │   └── Validador.java
        └── Main.java
```

---

## 🔧 Especificaciones Técnicas

### Clase Contacto

```java
public class Contacto {
    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String categoria;
    
    // Constructor completo
    // Getters y setters
    // toString() personalizado
    // equals() y hashCode() basados en id
}
```

### Clase AgendaContactos

Debe usar las siguientes estructuras de datos:

1. **HashMap principal**: `Map<String, Contacto>` para búsqueda rápida por ID
2. **ArrayList auxiliar**: `List<Contacto>` para listar en orden de inserción (opcional)

**Métodos requeridos:**

```java
public class AgendaContactos {
    private Map<String, Contacto> contactosPorId;
    
    public void agregarContacto(Contacto contacto)
    public Contacto buscarPorId(String id)
    public List<Contacto> buscarPorNombre(String nombre)
    public boolean actualizarContacto(String id, Contacto nuevosDatos)
    public boolean eliminarContacto(String id)
    public List<Contacto> listarTodos()
    public List<Contacto> buscarPorCategoria(String categoria)
    public boolean existeEmail(String email)
    public Map<String, Integer> contarPorCategoria()
    public int cantidadContactos()
}
```

---

## ✅ Validaciones Requeridas

1. **ID único**: No permitir IDs duplicados
2. **Email único**: No permitir emails duplicados
3. **Campos obligatorios**: nombre, telefono y email no pueden estar vacíos
4. **Formato de email**: Validación básica (contiene @ y .)
5. **Formato de teléfono**: Solo números y guiones

---

## 📊 Casos de Prueba

### Caso 1: Agregar Contactos

```
Entrada: 
  ID: C001
  Nombre: Carlos Pérez
  Teléfono: 555-1234
  Email: carlos@email.com
  Categoría: Trabajo
  
Salida: "Contacto agregado exitosamente"
```

### Caso 2: Buscar por Nombre

```
Entrada: "María"
Salida: Lista de todos los contactos que contengan "María" en el nombre
```

### Caso 3: Actualizar Contacto

```
Entrada: 
  ID: C001
  Nuevo teléfono: 555-5678
  
Salida: "Contacto actualizado exitosamente"
```

### Caso 4: Email Duplicado

```
Entrada: Nuevo contacto con email ya existente
Salida: "Error: El email ya está registrado"
```

### Caso 5: Estadísticas por Categoría

```
Salida:
  Familia: 5 contactos
  Trabajo: 8 contactos
  Amigos: 12 contactos
```

---

## 🎯 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| **Uso correcto de HashMap** | 25% | Implementación eficiente con get(), put(), remove() |
| **Diseño de clases** | 20% | Separación adecuada (modelo, servicio, main) |
| **Validaciones** | 15% | Todas las validaciones implementadas |
| **Búsquedas** | 15% | Búsqueda por ID, nombre y categoría funcionales |
| **Iteración del Map** | 10% | Uso correcto de entrySet(), keySet(), values() |
| **Generics y Type Safety** | 10% | Uso apropiado de `Map<String, Contacto>` |
| **Código limpio** | 5% | Nombres descriptivos, comentarios, organización |

---

## 💡 Pistas y Consejos

### Pista 1: Iterar sobre un Map

```java
// Opción 1: Iterar sobre entradas (clave-valor)
for (Map.Entry<String, Contacto> entry : contactosPorId.entrySet()) {
    String id = entry.getKey();
    Contacto contacto = entry.getValue();
    // Procesar...
}

// Opción 2: Iterar solo sobre valores
for (Contacto contacto : contactosPorId.values()) {
    // Procesar...
}

// Opción 3: Iterar solo sobre claves
for (String id : contactosPorId.keySet()) {
    Contacto contacto = contactosPorId.get(id);
    // Procesar...
}
```

### Pista 2: Buscar por Nombre

```java
public List<Contacto> buscarPorNombre(String nombre) {
    List<Contacto> resultados = new ArrayList<>();
    
    for (Contacto contacto : contactosPorId.values()) {
        if (contacto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
            resultados.add(contacto);
        }
    }
    
    return resultados;
}
```

### Pista 3: Verificar Email Duplicado

```java
public boolean existeEmail(String email) {
    for (Contacto contacto : contactosPorId.values()) {
        if (contacto.getEmail().equalsIgnoreCase(email)) {
            return true;
        }
    }
    return false;
}
```

### Pista 4: Contar por Categoría

```java
public Map<String, Integer> contarPorCategoria() {
    Map<String, Integer> conteo = new HashMap<>();
    
    for (Contacto contacto : contactosPorId.values()) {
        String categoria = contacto.getCategoria();
        conteo.put(categoria, conteo.getOrDefault(categoria, 0) + 1);
    }
    
    return conteo;
}
```

---

## 🚀 Desafíos Opcionales (Para Estudiantes Avanzados)

1. **Persistencia**: Guardar y cargar contactos desde un archivo de texto
2. **Búsqueda avanzada**: Búsqueda por múltiples criterios simultáneos
3. **Favoritos**: Marcar contactos como favoritos usando un Set adicional
4. **Historial de llamadas**: LinkedList para registrar últimas llamadas
5. **Ordenamiento**: Ordenar contactos por nombre, fecha de creación, etc.

---

## 📚 Conceptos Clave a Aplicar

- ✅ HashMap para almacenamiento clave-valor
- ✅ Iteración de Maps (entrySet, keySet, values)
- ✅ Generics con tipos parametrizados
- ✅ Validación de datos
- ✅ Búsqueda y filtrado en colecciones
- ✅ Manejo de colecciones vacías
- ✅ Métodos auxiliares y reutilización de código

---

## 📦 Entregable

1. **Código fuente** completo y funcional
2. **Archivo README.md** con:
   - Instrucciones de compilación y ejecución
   - Descripción de las clases
   - Ejemplos de uso
3. **Casos de prueba** ejecutados exitosamente

---

## ⏱️ Tiempo Estimado

- **Nivel Básico**: 60-90 minutos
- **Nivel Intermedio**: 45-60 minutos
- **Nivel Avanzado**: 30-45 minutos (con desafíos opcionales)

---

## 📞 Soporte

Si tienes dudas, consulta:
1. Documentación de [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
2. Material teórico de la semana (archivos en `1-teoria/`)
3. Glosario en `3-recursos/glosario.md`

---

**¡Éxito en tu implementación!** 🚀

---

*Semana 8 - Bootcamp POO Java - SENA*
