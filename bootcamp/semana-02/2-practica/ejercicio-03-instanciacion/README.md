# Ejercicio 03 - Instanciación de Objetos

## 🎯 Objetivo
Comprender el concepto de instanciación, la diferencia entre clase y objeto, y trabajar con múltiples objetos y constructores.

**Duración estimada:** 35 minutos  
**Dificultad:** ⭐⭐ Básico

---

## 📚 Conceptos a Practicar

- Diferencia entre clase (molde) y objeto (instancia)
- Palabra clave `new`
- Crear múltiples instancias de una misma clase
- Constructores básicos
- Referencias a objetos

---

## 📝 Enunciado

Crea una clase llamada `Libro` que represente un libro con información básica. Luego crea una clase `Biblioteca` que gestione una colección de libros.

### Requisitos

**La clase `Libro` debe tener:**

1. **Atributos:**
   - `titulo` (String)
   - `autor` (String)
   - `numeroPaginas` (int)
   - `anioPublicacion` (int)
   - `disponible` (boolean)

2. **Constructor:**
   - Constructor que inicialice todos los atributos
   - Por defecto, el libro debe estar disponible

3. **Métodos:**
   - `mostrarInfo()`: Muestra información del libro
   - `prestar()`: Marca el libro como no disponible
   - `devolver()`: Marca el libro como disponible
   - `esVoluminoso()`: Retorna true si tiene más de 500 páginas

**La clase `Main` debe:**
- Crear al menos 5 objetos Libro diferentes
- Realizar operaciones de préstamo y devolución
- Mostrar cuántos libros están disponibles
- Encontrar el libro más antiguo y el más nuevo

---

## 💻 Código Inicial

### Estructura de archivos:

```
ejercicio-03-instanciacion/
├── src/
│   ├── Libro.java
│   └── Main.java
└── README.md
```

---

## 🔨 Paso a Paso

### Paso 1: Crear la clase Libro con constructor

```java
/**
 * Clase que representa un libro
 * @author Tu Nombre
 */
public class Libro {
    // Atributos
    String titulo;
    String autor;
    int numeroPaginas;
    int anioPublicacion;
    boolean disponible;
    
    // Constructor
    public Libro(String titulo, String autor, int numeroPaginas, int anioPublicacion) {
        // TODO: Inicializar los atributos
        // TODO: Establecer disponible = true por defecto
    }
    
    // TODO: Implementar los métodos
}
```

### Paso 2: Crear múltiples objetos en Main

```java
public class Main {
    public static void main(String[] args) {
        // TODO: Crear 5 libros diferentes usando el constructor
        
        // TODO: Prestar algunos libros
        
        // TODO: Devolver algunos libros
        
        // TODO: Mostrar información de todos los libros
        
        // TODO: Contar cuántos libros están disponibles
        
        // TODO: Encontrar el libro más antiguo
    }
}
```

---

## ✅ Ejemplo de Salida Esperada

```
=== BIBLIOTECA - Gestión de Libros ===

Agregando libros a la biblioteca...
✓ 5 libros agregados

========== CATÁLOGO COMPLETO ==========
📖 Cien años de soledad
   Autor: Gabriel García Márquez
   Páginas: 471
   Año: 1967
   Estado: ✓ Disponible
   Voluminoso: No

📖 Don Quijote de la Mancha
   Autor: Miguel de Cervantes
   Páginas: 863
   Año: 1605
   Estado: ✓ Disponible
   Voluminoso: Sí

📖 El Principito
   Autor: Antoine de Saint-Exupéry
   Páginas: 96
   Año: 1943
   Estado: ✓ Disponible
   Voluminoso: No

[... más libros ...]

========================================

=== PRÉSTAMOS ===
Prestando 'Cien años de soledad'...
✓ Libro prestado exitosamente

Prestando 'El Principito'...
✓ Libro prestado exitosamente

=== ESTADO ACTUAL ===
Libros disponibles: 3/5
Libros prestados: 2/5

=== DEVOLUCIONES ===
Devolviendo 'Cien años de soledad'...
✓ Libro devuelto exitosamente

=== ESTADO FINAL ===
Libros disponibles: 4/5

=== ESTADÍSTICAS ===
Libro más antiguo: Don Quijote de la Mancha (1605)
Libro más nuevo: 1984 (1949)
Libros voluminosos: 2
```

---

## 🧪 Casos de Prueba

### Crear los siguientes libros:

```java
Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 471, 1967);
Libro libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 863, 1605);
Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupéry", 96, 1943);
Libro libro4 = new Libro("1984", "George Orwell", 328, 1949);
Libro libro5 = new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 120, 1981);
```

### Operaciones a realizar:

1. Prestar libro1 y libro3
2. Intentar prestar libro1 nuevamente (debe dar error)
3. Devolver libro1
4. Contar libros disponibles
5. Listar libros voluminosos
6. Encontrar el libro más antiguo

---

## 💡 Pistas

1. **Sintaxis del constructor:**
   ```java
   public NombreClase(parametros) {
       this.atributo = parametro;
   }
   ```

2. **Crear objeto con constructor:**
   ```java
   NombreClase objeto = new NombreClase(valores);
   ```

3. **Usar this para diferenciar:**
   ```java
   public Libro(String titulo) {
       this.titulo = titulo;  // this.titulo es el atributo
   }
   ```

4. **Array de objetos:**
   ```java
   Libro[] libros = new Libro[5];
   libros[0] = new Libro(...);
   ```

5. **Iterar sobre array:**
   ```java
   for (int i = 0; i < libros.length; i++) {
       libros[i].mostrarInfo();
   }
   ```

---

## ⚠️ Errores Comunes

### Error 1: Confundir clase con objeto
```java
// ❌ INCORRECTO - Libro es una clase, no un objeto
Libro.titulo = "El Quijote";

// ✅ CORRECTO - libro1 es un objeto
Libro libro1 = new Libro(...);
libro1.titulo = "El Quijote";
```

### Error 2: No usar this en el constructor
```java
// ⚠️ AMBIGUO
public Libro(String titulo) {
    titulo = titulo;  // ¿Cuál titulo?
}

// ✅ CLARO
public Libro(String titulo) {
    this.titulo = titulo;  // this.titulo es el atributo
}
```

### Error 3: Olvidar el new
```java
// ❌ INCORRECTO - Solo declaración
Libro libro;
libro.mostrarInfo();  // NullPointerException

// ✅ CORRECTO
Libro libro = new Libro("Título", "Autor", 100, 2020);
libro.mostrarInfo();
```

### Error 4: Comparar objetos con ==
```java
// ❌ INCORRECTO - Compara referencias
if (libro1 == libro2) { }

// ✅ CORRECTO - Comparar atributos
if (libro1.titulo.equals(libro2.titulo)) { }
```

---

## 🎯 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| **Constructor** | 3 | Inicializa correctamente todos los atributos |
| **Instanciación** | 2 | Crea múltiples objetos correctamente |
| **Métodos** | 3 | Todos los métodos funcionan |
| **Operaciones** | 2 | Préstamos y devoluciones correctos |

**Total:** 10 puntos

---

## 🚀 Desafíos Adicionales

1. **Búsqueda de libros:**
   ```java
   public static Libro buscarPorTitulo(Libro[] libros, String titulo)
   ```

2. **Ordenamiento:**
   - Ordena libros por año de publicación
   - Ordena por número de páginas

3. **Estadísticas:**
   - Promedio de páginas
   - Autor con más libros
   - Década con más publicaciones

4. **Validaciones:**
   - No permitir prestar un libro ya prestado
   - No permitir devolver un libro ya disponible

---

## 📝 Preguntas de Reflexión

1. ¿Cuál es la diferencia entre la clase `Libro` y el objeto `libro1`?
2. ¿Cuántos objetos `Libro` puedes crear de una sola clase?
3. ¿Por qué es útil el constructor?
4. ¿Qué pasa si creas dos objetos con los mismos valores?
5. ¿Los objetos son independientes entre sí?

---

## 🔗 Recursos

- [Oracle: Creating Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html)
- [W3Schools: Java Constructors](https://www.w3schools.com/java/java_constructors.asp)

---

## 📤 Entrega

```
repositorio-apellido-nombre/
└── semana-02/
    └── ejercicio-03/
        ├── src/
        │   ├── Libro.java
        │   └── Main.java
        └── README.md
```

### Checklist:

- [ ] Constructor inicializa todos los atributos
- [ ] Creaste al menos 5 objetos diferentes
- [ ] Métodos de préstamo y devolución funcionan
- [ ] Contaste libros disponibles correctamente
- [ ] Encontraste el libro más antiguo

---

**¡Éxito gestionando tu biblioteca!** 📚
