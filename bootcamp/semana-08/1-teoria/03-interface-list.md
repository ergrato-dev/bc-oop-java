# Interface List en Java

## 📚 ¿Qué es List?

`List<E>` es una **colección ordenada** (también llamada secuencia) que permite **elementos duplicados**. Los usuarios de esta interfaz tienen control preciso sobre **dónde se insertan los elementos** en la lista y pueden acceder a ellos por su **índice**.

---

## 🔑 Características Principales

- ✅ **Orden de inserción**: Mantiene el orden en que se agregan los elementos
- ✅ **Permite duplicados**: Puede contener elementos repetidos
- ✅ **Acceso por índice**: get(index), set(index, element)
- ✅ **Búsqueda posicional**: indexOf(), lastIndexOf()
- ✅ **Permite null**: Puede contener elementos null

---

## 🏗️ Implementaciones Principales

### 1. ArrayList

**Array dinámico** que crece automáticamente.

**Características:**
- ✅ Acceso rápido por índice: O(1)
- ✅ Agregar al final: O(1) amortizado
- ❌ Insertar/eliminar en medio: O(n)
- ❌ Búsqueda lineal: O(n)

**Cuándo usarlo:**
- Acceso frecuente por índice
- Pocas inserciones/eliminaciones en medio
- Tamaño variable pero con pocos cambios estructurales

```java
import java.util.ArrayList;
import java.util.List;

public class EjemploArrayList {
    public static void main(String[] args) {
        // Crear ArrayList
        List<String> frutas = new ArrayList<>();
        
        // Agregar elementos
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        
        // Acceso por índice (rápido)
        String primera = frutas.get(0);  // "Manzana"
        
        // Modificar elemento
        frutas.set(1, "Uva");  // Reemplaza "Banana" por "Uva"
        
        // Tamaño
        System.out.println("Tamaño: " + frutas.size());
        
        // Imprimir
        System.out.println(frutas);  // [Manzana, Uva, Naranja]
    }
}
```

---

### 2. LinkedList

**Lista doblemente enlazada** donde cada elemento apunta al anterior y al siguiente.

**Características:**
- ✅ Insertar/eliminar al inicio/fin: O(1)
- ✅ Insertar/eliminar en medio: O(1) si tienes el nodo
- ❌ Acceso por índice: O(n)
- ❌ Más memoria (referencias adicionales)

**Cuándo usarlo:**
- Inserciones/eliminaciones frecuentes
- Implementación de colas o pilas
- Poco acceso por índice

```java
import java.util.LinkedList;
import java.util.List;

public class EjemploLinkedList {
    public static void main(String[] args) {
        LinkedList<String> nombres = new LinkedList<>();
        
        // Agregar al final
        nombres.add("Carlos");
        nombres.add("Ana");
        
        // Agregar al inicio (eficiente en LinkedList)
        nombres.addFirst("Luis");  // [Luis, Carlos, Ana]
        
        // Agregar al final
        nombres.addLast("María");  // [Luis, Carlos, Ana, María]
        
        // Remover del inicio
        String primero = nombres.removeFirst();  // "Luis"
        
        // Remover del final
        String ultimo = nombres.removeLast();  // "María"
        
        System.out.println(nombres);  // [Carlos, Ana]
    }
}
```

---

### 3. ArrayList vs LinkedList

| Operación | ArrayList | LinkedList |
|-----------|-----------|------------|
| **get(index)** | O(1) 🚀 | O(n) 🐌 |
| **add(element)** final | O(1)* 🚀 | O(1) 🚀 |
| **add(index, element)** | O(n) 🐌 | O(n) 🐌 |
| **addFirst(element)** | O(n) 🐌 | O(1) 🚀 |
| **remove(index)** | O(n) 🐌 | O(n) 🐌 |
| **remove First()** | O(n) 🐌 | O(1) 🚀 |
| **Memoria** | Menor 💚 | Mayor 🔴 |
| **Mejor para** | Acceso aleatorio | Inserciones al inicio/fin |

*O(1) amortizado, O(n) cuando necesita redimensionar

---

## 🔧 Métodos Principales de List

### Agregar Elementos

```java
List<String> lista = new ArrayList<>();

lista.add("A");              // Agrega al final: [A]
lista.add(0, "B");           // Inserta en posición 0: [B, A]
lista.addAll(Arrays.asList("C", "D"));  // Agrega múltiples: [B, A, C, D]
```

### Acceder y Modificar

```java
String elemento = lista.get(0);     // Obtiene elemento en posición 0
lista.set(1, "X");                  // Reemplaza elemento en posición 1
```

### Buscar

```java
int indice = lista.indexOf("C");        // Primera ocurrencia (o -1 si no existe)
int ultimoIndice = lista.lastIndexOf("A");  // Última ocurrencia
boolean contiene = lista.contains("X");     // Verifica existencia
```

### Eliminar

```java
lista.remove(0);              // Elimina por índice
lista.remove("X");            // Elimina por objeto (primera ocurrencia)
lista.clear();                // Elimina todos los elementos
```

### Sublistas

```java
List<String> sublista = lista.subList(1, 3);  // Elementos desde índice 1 hasta 2 (3 es exclusivo)
```

---

## 🔄 Recorrer una List

### 1. For tradicional (con índice)

```java
List<String> colores = Arrays.asList("Rojo", "Verde", "Azul");

for (int i = 0; i < colores.size(); i++) {
    System.out.println(i + ": " + colores.get(i));
}
```

### 2. For-each (recomendado para lectura)

```java
for (String color : colores) {
    System.out.println(color);
}
```

### 3. Iterator (permite eliminación segura)

```java
Iterator<String> iterator = colores.iterator();
while (iterator.hasNext()) {
    String color = iterator.next();
    if (color.equals("Verde")) {
        iterator.remove();  // Eliminación segura durante iteración
    }
}
```

### 4. forEach con Lambda (Java 8+)

```java
colores.forEach(color -> System.out.println(color));

// O con method reference
colores.forEach(System.out::println);
```

---

## 💡 Ejemplos Prácticos

### Ejemplo 1: Lista de Tareas (To-Do List)

```java
import java.util.*;

public class ListaTareas {
    private List<String> tareas;
    
    public ListaTareas() {
        this.tareas = new ArrayList<>();
    }
    
    public void agregarTarea(String tarea) {
        tareas.add(tarea);
        System.out.println("Tarea agregada: " + tarea);
    }
    
    public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            String tareaCompletada = tareas.remove(indice);
            System.out.println("Tarea completada: " + tareaCompletada);
        }
    }
    
    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes");
            return;
        }
        
        System.out.println("=== TAREAS PENDIENTES ===");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }
    
    public static void main(String[] args) {
        ListaTareas lista = new ListaTareas();
        
        lista.agregarTarea("Estudiar Java Collections");
        lista.agregarTarea("Hacer ejercicios prácticos");
        lista.agregarTarea("Revisar código del proyecto");
        
        lista.mostrarTareas();
        
        lista.completarTarea(0);  // Completa primera tarea
        
        lista.mostrarTareas();
    }
}
```

### Ejemplo 2: Historial de Navegación

```java
import java.util.*;

public class HistorialNavegacion {
    private LinkedList<String> historial;
    private static final int MAX_HISTORIAL = 10;
    
    public HistorialNavegacion() {
        this.historial = new LinkedList<>();
    }
    
    public void visitarPagina(String url) {
        // Agregar al inicio (página más reciente)
        historial.addFirst(url);
        
        // Limitar tamaño del historial
        if (historial.size() > MAX_HISTORIAL) {
            historial.removeLast();  // Eliminar la más antigua
        }
        
        System.out.println("Visitando: " + url);
    }
    
    public String paginaActual() {
        return historial.isEmpty() ? "Ninguna" : historial.getFirst();
    }
    
    public String retroceder() {
        if (historial.size() > 1) {
            historial.removeFirst();  // Remover actual
            return historial.getFirst();  // Retornar anterior
        }
        return "No hay páginas anteriores";
    }
    
    public void mostrarHistorial() {
        System.out.println("=== HISTORIAL ===");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }
    
    public static void main(String[] args) {
        HistorialNavegacion nav = new HistorialNavegacion();
        
        nav.visitarPagina("google.com");
        nav.visitarPagina("github.com");
        nav.visitarPagina("stackoverflow.com");
        
        nav.mostrarHistorial();
        
        System.out.println("\nRetrocediendo...");
        String anterior = nav.retroceder();
        System.out.println("Página actual: " + anterior);
        
        nav.mostrarHistorial();
    }
}
```

---

## 🎯 Ordenamiento de Listas

### 1. Ordenamiento Natural (Comparable)

```java
List<Integer> numeros = Arrays.asList(5, 2, 8, 1, 9);
Collections.sort(numeros);  // [1, 2, 5, 8, 9]

List<String> nombres = Arrays.asList("Carlos", "Ana", "Luis");
Collections.sort(nombres);  // [Ana, Carlos, Luis] (alfabético)
```

### 2. Ordenamiento Personalizado (Comparator)

```java
List<String> palabras = Arrays.asList("casa", "automóvil", "sol", "computadora");

// Ordenar por longitud
Collections.sort(palabras, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
});

// Con Lambda (Java 8+)
palabras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

// O más simple
palabras.sort(Comparator.comparingInt(String::length));
```

---

## 🔍 Búsqueda en Listas

### Búsqueda Lineal

```java
List<String> frutas = Arrays.asList("Manzana", "Banana", "Naranja");

// contains()
boolean tiene = frutas.contains("Banana");  // true

// indexOf()
int posicion = frutas.indexOf("Naranja");  // 2
```

### Búsqueda Binaria (lista ordenada)

```java
List<Integer> numeros = Arrays.asList(1, 3, 5, 7, 9, 11);

int indice = Collections.binarySearch(numeros, 7);  // 3 (más rápido que indexOf)
// Requiere que la lista esté ordenada
```

---

## ✅ Mejores Prácticas

1. **Usa la interfaz, no la implementación**
   ```java
   // Bien
   List<String> lista = new ArrayList<>();
   
   // Evitar
   ArrayList<String> lista = new ArrayList<>();
   ```

2. **ArrayList por defecto**, LinkedList para casos específicos

3. **Especifica capacidad inicial** si conoces el tamaño aproximado
   ```java
   List<String> lista = new ArrayList<>(1000);  // Evita redimensionamientos
   ```

4. **Usa for-each** para lectura simple
   ```java
   for (String elemento : lista) {
       System.out.println(elemento);
   }
   ```

5. **Usa Iterator** para eliminación segura durante iteración

6. **Considera Collections inmutables** para seguridad
   ```java
   List<String> inmutable = List.of("A", "B", "C");  // Java 9+
   // O
   List<String> inmutable = Collections.unmodifiableList(lista);
   ```

---

## 📝 Ejercicios de Práctica

1. **Ejercicio 1**: Crea una lista de 10 números aleatorios, ordénalos y muestra solo los pares
2. **Ejercicio 2**: Implementa un carrito de compras usando ArrayList
3. **Ejercicio 3**: Crea un reproductor de música con playlist usando LinkedList
4. **Ejercicio 4**: Implementa un sistema de registro que elimine automáticamente entradas antiguas

---

**Próximo tema**: [Interface Set](./04-interface-set.md)

---

*Semana 8 - Bootcamp POO Java - SENA*
