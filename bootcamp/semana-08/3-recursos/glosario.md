# 📖 Glosario - Colecciones y Programación Genérica

## A

**ArrayList**  
Implementación de List basada en un array dinámico. Proporciona acceso rápido por índice (O(1)) pero inserciones/eliminaciones en medio son costosas (O(n)).

**Array**  
Estructura de datos de tamaño fijo que almacena elementos del mismo tipo en posiciones contiguas de memoria.

**Autoboxing**  
Conversión automática entre tipos primitivos y sus clases wrapper (ej: int ↔ Integer).

---

## B

**Bounded Type Parameter**  
Parámetro de tipo genérico que está limitado a cierta jerarquía de clases mediante `extends` o `super`.

**Búsqueda Binaria**  
Algoritmo de búsqueda eficiente (O(log n)) que requiere que la colección esté ordenada.

---

## C

**Collection**  
Interfaz raíz de la jerarquía de colecciones. Define operaciones básicas como add(), remove(), contains().

**Collections (clase)**  
Clase de utilidades con métodos estáticos para operar sobre colecciones (sort(), reverse(), shuffle(), etc.).

**Comparable**  
Interfaz que define el orden natural de una clase mediante el método `compareTo()`.

**Comparator**  
Interfaz que permite definir múltiples formas de ordenar objetos mediante el método `compare()`.

---

## D

**Diamond Operator (`<>`)**  
Operador introducido en Java 7 que permite la inferencia de tipos genéricos, evitando repetir el tipo.
```java
List<String> lista = new ArrayList<>();  // Diamond operator
```

**Duplicate (Duplicado)**  
Elemento que aparece más de una vez en una colección. List permite duplicados, Set no.

---

## E

**Entry (Entrada)**  
Par clave-valor en un Map. Se representa mediante la interfaz `Map.Entry<K, V>`.

**equals()**  
Método que define la igualdad entre objetos. Esencial para el funcionamiento correcto de Set y Map.

---

## F

**For-each Loop**  
Bucle simplificado para iterar colecciones sin necesidad de índice o Iterator explícito.
```java
for (String elemento : coleccion) { }
```

---

## G

**Generics (Genéricos)**  
Característica que permite parametrizar tipos en clases, interfaces y métodos para lograr type safety.

---

## H

**HashMap**  
Implementación de Map basada en tabla hash. Proporciona operaciones O(1) en promedio. No mantiene orden.

**HashSet**  
Implementación de Set basada en HashMap. No permite duplicados ni mantiene orden.

**hashCode()**  
Método que retorna un código hash del objeto. Debe sobrescribirse cuando se sobrescribe equals().

---

## I

**Immutable (Inmutable)**  
Colección que no puede ser modificada después de su creación (List.of(), Collections.unmodifiableList()).

**Iterable**  
Interfaz que permite que un objeto sea iterado con for-each. Todas las colecciones la implementan.

**Iterator**  
Objeto que permite recorrer una colección y opcionalmente eliminar elementos durante la iteración.

---

## J

**Java Collections Framework (JCF)**  
Arquitectura unificada para representar y manipular colecciones en Java.

---

## K

**Key (Clave)**  
Identificador único usado en Map para asociar valores. No puede haber claves duplicadas.

---

## L

**LinkedHashMap**  
Implementación de Map que mantiene el orden de inserción de las entradas.

**LinkedHashSet**  
Implementación de Set que mantiene el orden de inserción de los elementos.

**LinkedList**  
Implementación de List basada en lista doblemente enlazada. Eficiente para inserciones/eliminaciones al inicio/fin.

**List**  
Interfaz que representa una colección ordenada que permite duplicados y acceso por índice.

**Lower Bounded Wildcard (`? super T`)**  
Wildcard que acepta T o cualquier supertipo de T. Útil para operaciones de escritura.

---

## M

**Map**  
Interfaz que representa una colección de pares clave-valor. No permite claves duplicadas.

**Mutable (Mutable)**  
Colección que puede ser modificada (agregar, eliminar, modificar elementos).

---

## N

**Natural Ordering (Orden Natural)**  
Orden definido por la implementación de Comparable de una clase (ej: orden alfabético para Strings).

---

## O

**O notation (Notación Big O)**  
Notación que describe la complejidad temporal o espacial de un algoritmo (O(1), O(n), O(log n), etc.).

---

## P

**Primitive Types (Tipos Primitivos)**  
Tipos de datos básicos en Java (int, double, boolean, etc.). Las colecciones solo aceptan objetos, no primitivos.

**PriorityQueue**  
Implementación de Queue donde los elementos se procesan según su prioridad (orden natural o Comparator).

---

## Q

**Queue**  
Interfaz que representa una cola (FIFO - First In, First Out) para procesamiento de elementos.

---

## R

**Raw Type (Tipo Crudo)**  
Uso de una clase genérica sin especificar el tipo de parámetro. Se debe evitar.
```java
List lista = new ArrayList();  // Raw type - evitar
```

---

## S

**Set**  
Interfaz que representa una colección sin elementos duplicados.

**Stream API**  
API introducida en Java 8 para procesamiento funcional de colecciones.

---

## T

**TreeMap**  
Implementación de Map que mantiene las claves ordenadas (orden natural o Comparator). Operaciones O(log n).

**TreeSet**  
Implementación de Set que mantiene los elementos ordenados. Operaciones O(log n).

**Type Erasure (Borrado de Tipos)**  
Proceso mediante el cual el compilador remueve información de tipos genéricos en runtime.

**Type Parameter (Parámetro de Tipo)**  
Variable de tipo usada en definiciones genéricas (T, E, K, V, etc.).

**Type Safety**  
Garantía de que las operaciones sobre tipos son verificadas en tiempo de compilación.

---

## U

**Unbounded Wildcard (`?`)**  
Wildcard que acepta cualquier tipo. Útil cuando no importa el tipo específico.

**Unmodifiable Collection**  
Colección de solo lectura creada con Collections.unmodifiableXXX().

**Upper Bounded Wildcard (`? extends T`)**  
Wildcard que acepta T o cualquier subtipo de T. Útil para operaciones de lectura.

---

## V

**Value (Valor)**  
Objeto asociado a una clave en un Map. Puede haber valores duplicados.

---

## W

**Wildcard (`?`)**  
Tipo especial usado en generics para representar un tipo desconocido.

**Wrapper Classes**  
Clases que encapsulan tipos primitivos como objetos (Integer, Double, Boolean, etc.).

---

## Operaciones Comunes

**O(1) - Tiempo Constante**  
La operación toma el mismo tiempo independientemente del tamaño de la colección.

**O(n) - Tiempo Lineal**  
El tiempo de la operación crece proporcionalmente al tamaño de la colección.

**O(log n) - Tiempo Logarítmico**  
El tiempo crece logarítmicamente con el tamaño (más eficiente que O(n)).

---

## Términos en Código

```java
// Collection<E>: E es el tipo de elemento
List<String> lista = new ArrayList<>();

// Map<K, V>: K es clave, V es valor
Map<Integer, String> mapa = new HashMap<>();

// Bounded type: T extiende Number
class Calculadora<T extends Number> { }

// Wildcard: ? representa cualquier tipo
void metodo(List<?> lista) { }

// Upper bound: acepta Number o subclases
void metodo(List<? extends Number> numeros) { }

// Lower bound: acepta Integer o superclases
void metodo(List<? super Integer> lista) { }
```

---

## Acrónimos y Abreviaturas

- **API**: Application Programming Interface
- **CRUD**: Create, Read, Update, Delete
- **FIFO**: First In, First Out
- **JCF**: Java Collections Framework
- **JDK**: Java Development Kit
- **LIFO**: Last In, First Out

---

## Ejemplos de Uso

### List
```java
List<String> nombres = new ArrayList<>();
nombres.add("Ana");
String primero = nombres.get(0);
```

### Set
```java
Set<Integer> numeros = new HashSet<>();
numeros.add(1);
numeros.add(1);  // No se duplica
```

### Map
```java
Map<String, Integer> edades = new HashMap<>();
edades.put("Carlos", 25);
Integer edad = edades.get("Carlos");
```

### Generics
```java
public class Caja<T> {
    private T contenido;
    public void guardar(T item) { this.contenido = item; }
    public T obtener() { return contenido; }
}
```

---

*Semana 8 - Bootcamp POO Java - SENA*
