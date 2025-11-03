# Arrays vs Colecciones en Java

## 📚 Introducción

Tanto los **arrays** como las **colecciones** son estructuras de datos que permiten almacenar múltiples elementos. Sin embargo, tienen diferencias fundamentales que determinan cuándo usar cada una.

---

## 🔍 ¿Qué es un Array?

Un **array** es una estructura de datos de **tamaño fijo** que almacena elementos del **mismo tipo** en posiciones de memoria contiguas.

### Características de los Arrays

```java
// Declaración e inicialización de un array
int[] numeros = new int[5];  // Array de tamaño fijo (5 elementos)
String[] nombres = {"Ana", "Luis", "María"};  // Inicialización con valores
```

**Propiedades clave:**
- ✅ **Tamaño fijo**: Se define en la creación y no puede cambiar
- ✅ **Acceso rápido**: Acceso directo por índice en O(1)
- ✅ **Eficiencia de memoria**: Estructura simple y eficiente
- ❌ **Sin métodos de utilidad**: No tiene métodos para agregar, eliminar, buscar
- ❌ **Tipos primitivos y objetos**: Puede almacenar ambos

### Ejemplo Práctico - Arrays

```java
public class EjemploArrays {
    public static void main(String[] args) {
        // Crear array de estudiantes
        String[] estudiantes = new String[3];
        
        // Agregar elementos
        estudiantes[0] = "Carlos";
        estudiantes[1] = "Ana";
        estudiantes[2] = "Luis";
        
        // Acceder a elementos
        System.out.println("Primer estudiante: " + estudiantes[0]);
        
        // Recorrer array
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i]);
        }
        
        // Problema: No se puede agregar un cuarto estudiante
        // estudiantes[3] = "María";  // ERROR: ArrayIndexOutOfBoundsException
    }
}
```

---

## 🔍 ¿Qué es una Colección?

Una **colección** es un objeto que agrupa múltiples elementos y proporciona operaciones para manipularlos. Son parte del **Java Collections Framework**.

### Características de las Colecciones

```java
import java.util.ArrayList;
import java.util.List;

// Declaración e inicialización de una colección
List<String> nombres = new ArrayList<>();  // Tamaño dinámico
nombres.add("Ana");
nombres.add("Luis");
nombres.add("María");
```

**Propiedades clave:**
- ✅ **Tamaño dinámico**: Crecen y decrecen automáticamente
- ✅ **Métodos de utilidad**: add(), remove(), contains(), size(), etc.
- ✅ **Type Safety con Generics**: `List<String>` solo acepta Strings
- ✅ **Implementaciones variadas**: List, Set, Map con diferentes comportamientos
- ❌ **Solo objetos**: No pueden almacenar tipos primitivos directamente (usa wrappers)

### Ejemplo Práctico - Colecciones

```java
import java.util.ArrayList;
import java.util.List;

public class EjemploColecciones {
    public static void main(String[] args) {
        // Crear colección de estudiantes
        List<String> estudiantes = new ArrayList<>();
        
        // Agregar elementos (tamaño dinámico)
        estudiantes.add("Carlos");
        estudiantes.add("Ana");
        estudiantes.add("Luis");
        estudiantes.add("María");  // ✅ Sin problema, crece automáticamente
        
        // Acceder a elementos
        System.out.println("Primer estudiante: " + estudiantes.get(0));
        
        // Métodos de utilidad
        System.out.println("Cantidad: " + estudiantes.size());
        System.out.println("¿Contiene 'Ana'? " + estudiantes.contains("Ana"));
        
        // Eliminar elemento
        estudiantes.remove("Luis");
        
        // Recorrer colección (for-each)
        for (String estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
```

---

## ⚖️ Comparación: Arrays vs Colecciones

| Característica | Arrays | Colecciones |
|----------------|--------|-------------|
| **Tamaño** | Fijo | Dinámico |
| **Tipos de datos** | Primitivos y objetos | Solo objetos (wrappers para primitivos) |
| **Type Safety** | Sí (pero sin generics) | Sí (con generics) |
| **Métodos de utilidad** | No | Sí (add, remove, contains, etc.) |
| **Rendimiento** | Más rápido (estructura simple) | Ligeramente más lento (overhead) |
| **Memoria** | Más eficiente | Usa más memoria (objetos adicionales) |
| **Sintaxis** | `tipo[] nombre` | `Collection<Tipo> nombre` |
| **Acceso por índice** | `array[i]` | `list.get(i)` |
| **Multidimensional** | Sí (int[][]) | Sí (pero más complejo) |

---

## 🎯 ¿Cuándo Usar Arrays?

### Usa Arrays cuando:

1. **Tamaño conocido y fijo**
   ```java
   // Los días de la semana siempre son 7
   String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", 
                          "Viernes", "Sábado", "Domingo"};
   ```

2. **Necesitas máxima eficiencia**
   ```java
   // Procesamiento intensivo de datos numéricos
   double[] temperaturas = new double[1000000];
   ```

3. **Trabajas con tipos primitivos**
   ```java
   // Gran cantidad de números enteros
   int[] numeros = new int[10000];  // Más eficiente que ArrayList<Integer>
   ```

4. **Interoperabilidad con APIs que requieren arrays**
   ```java
   // Muchas bibliotecas esperan arrays
   String[] argumentos = {"arg1", "arg2"};
   miMetodo(argumentos);
   ```

---

## 🎯 ¿Cuándo Usar Colecciones?

### Usa Colecciones cuando:

1. **Tamaño desconocido o variable**
   ```java
   // Número de usuarios puede cambiar constantemente
   List<Usuario> usuarios = new ArrayList<>();
   usuarios.add(new Usuario("Carlos"));
   usuarios.add(new Usuario("Ana"));
   ```

2. **Necesitas operaciones complejas**
   ```java
   List<Producto> productos = new ArrayList<>();
   productos.add(producto1);
   productos.remove(producto2);
   productos.contains(producto3);
   Collections.sort(productos);  // Ordenar fácilmente
   ```

3. **Quieres evitar duplicados**
   ```java
   Set<String> emails = new HashSet<>();
   emails.add("usuario@email.com");
   emails.add("usuario@email.com");  // No se duplica
   ```

4. **Necesitas estructura clave-valor**
   ```java
   Map<String, Usuario> usuariosPorId = new HashMap<>();
   usuariosPorId.put("U001", usuario1);
   Usuario user = usuariosPorId.get("U001");  // Búsqueda rápida
   ```

---

## 💡 Conversión entre Arrays y Colecciones

### De Array a Colección

```java
// Método 1: Arrays.asList()
String[] array = {"A", "B", "C"};
List<String> lista = Arrays.asList(array);  // Lista de tamaño fijo

// Método 2: Crear ArrayList (tamaño dinámico)
List<String> listaDinamica = new ArrayList<>(Arrays.asList(array));

// Método 3: Collections.addAll()
List<String> lista2 = new ArrayList<>();
Collections.addAll(lista2, array);
```

### De Colección a Array

```java
List<String> lista = new ArrayList<>();
lista.add("A");
lista.add("B");
lista.add("C");

// Método 1: toArray() sin argumentos (retorna Object[])
Object[] array1 = lista.toArray();

// Método 2: toArray(T[]) con array tipado (recomendado)
String[] array2 = lista.toArray(new String[0]);
```

---

## 📊 Ejemplo Comparativo Completo

```java
import java.util.*;

public class ArrayVsColeccion {
    public static void main(String[] args) {
        System.out.println("=== USANDO ARRAYS ===");
        ejemploArrays();
        
        System.out.println("\n=== USANDO COLECCIONES ===");
        ejemploColecciones();
    }
    
    // Ejemplo con Arrays
    public static void ejemploArrays() {
        String[] frutas = new String[3];
        frutas[0] = "Manzana";
        frutas[1] = "Banana";
        frutas[2] = "Naranja";
        
        // Buscar elemento (manual)
        String buscar = "Banana";
        boolean encontrado = false;
        for (int i = 0; i < frutas.length; i++) {
            if (frutas[i].equals(buscar)) {
                encontrado = true;
                break;
            }
        }
        System.out.println("Encontrado: " + encontrado);
        
        // No se puede eliminar fácilmente
        // No se puede redimensionar
    }
    
    // Ejemplo con Colecciones
    public static void ejemploColecciones() {
        List<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        
        // Buscar elemento (simple)
        boolean encontrado = frutas.contains("Banana");
        System.out.println("Encontrado: " + encontrado);
        
        // Agregar más elementos (sin límite)
        frutas.add("Uva");
        frutas.add("Fresa");
        
        // Eliminar elemento (fácil)
        frutas.remove("Banana");
        
        // Tamaño actual
        System.out.println("Cantidad: " + frutas.size());
        
        // Ordenar
        Collections.sort(frutas);
        System.out.println("Ordenadas: " + frutas);
    }
}
```

---

## 🎓 Casos de Uso Reales

### Caso 1: Sistema de Calificaciones (Array)

```java
public class SistemaCalificaciones {
    // Array porque siempre hay 4 períodos académicos
    private double[] calificaciones = new double[4];
    
    public void setCalificacion(int periodo, double nota) {
        if (periodo >= 0 && periodo < 4) {
            calificaciones[periodo] = nota;
        }
    }
    
    public double getPromedio() {
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return suma / calificaciones.length;
    }
}
```

### Caso 2: Sistema de Inventario (Colección)

```java
import java.util.*;

public class Inventario {
    // ArrayList porque el número de productos varía
    private List<Producto> productos = new ArrayList<>();
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
    }
    
    public List<Producto> buscarPorCategoria(String categoria) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equals(categoria)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    public int getCantidadProductos() {
        return productos.size();  // Método de utilidad
    }
}
```

---

## ✅ Resumen y Mejores Prácticas

### Regla General

> **Si el tamaño es fijo y conocido → usa Arrays**  
> **Si el tamaño es dinámico o desconocido → usa Colecciones**

### Mejores Prácticas

1. **Prefiere colecciones por defecto** para mayor flexibilidad
2. **Usa arrays solo cuando** tengas razones específicas (rendimiento, interoperabilidad)
3. **Aprovecha generics** en colecciones para type safety
4. **Considera el rendimiento** solo cuando sea crítico
5. **Usa la interfaz apropiada** (List, Set, Map) según el comportamiento deseado

---

## 🔗 Recursos Adicionales

- [Java Collections Framework - Oracle Docs](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)
- [Arrays - Java Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Choosing the Right Collection - Baeldung](https://www.baeldung.com/java-choosing-collection)

---

## 📝 Ejercicios de Práctica

1. **Ejercicio 1**: Convierte un array de 10 números enteros en un ArrayList y agrega 5 números más
2. **Ejercicio 2**: Crea un programa que almacene las notas de 5 estudiantes usando arrays
3. **Ejercicio 3**: Implementa un registro de asistencia usando ArrayList donde se puedan agregar y eliminar estudiantes dinámicamente
4. **Ejercicio 4**: Compara el rendimiento de buscar un elemento en un array de 1000 elementos vs un ArrayList

---

**Próximo tema**: [Framework Collections](./02-framework-collections.md)

---

*Semana 8 - Bootcamp POO Java - SENA*
