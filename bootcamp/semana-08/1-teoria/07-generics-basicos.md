# Generics en Java - Introducción

## 📚 ¿Qué son los Generics?

Los **Generics** (tipos genéricos o parametrizados) permiten crear clases, interfaces y métodos que operan sobre **tipos especificados** como parámetros. Introducidos en **Java 5**, proporcionan **type safety** en tiempo de compilación.

---

## 🎯 ¿Por Qué Usar Generics?

### Sin Generics (Java 4 y anterior)

```java
// Sin generics - NO SEGURO
List lista = new ArrayList();
lista.add("Hola");
lista.add(42);  // ¡Acepta cualquier tipo!

String texto = (String) lista.get(0);  // Cast manual necesario
String numero = (String) lista.get(1); // ❌ ClassCastException en runtime!
```

### Con Generics (Java 5+)

```java
// Con generics - SEGURO
List<String> lista = new ArrayList<>();
lista.add("Hola");
// lista.add(42);  // ❌ Error de compilación - type safety!

String texto = lista.get(0);  // ✅ Sin cast necesario
```

---

## ✅ Ventajas de los Generics

1. **Type Safety**: Errores detectados en compilación, no en runtime
2. **Eliminación de casts**: No necesitas castear
3. **Código más legible**: Intención clara del tipo de datos
4. **Reutilización**: Código genérico para múltiples tipos

---

## 📖 Sintaxis Básica

### Declaración con un Tipo Genérico

```java
// Sintaxis: NombreClase<TipoParametrizado>
List<String> nombres = new ArrayList<>();
Set<Integer> numeros = new HashSet<>();
Map<String, Usuario> usuarios = new HashMap<>();
```

### Convenciones de Nombres

| Letra | Significado | Uso |
|-------|-------------|-----|
| **E** | Element | Colecciones (`List<E>`) |
| **K** | Key | Mapas - Clave (`Map<K, V>`) |
| **V** | Value | Mapas - Valor (`Map<K, V>`) |
| **T** | Type | Tipo genérico general |
| **N** | Number | Números |
| **S, U** | Tipos adicionales | Múltiples parámetros |

---

## 🔧 Clases Genéricas

### Crear una Clase Genérica

```java
// Clase genérica simple
public class Caja<T> {
    private T contenido;
    
    public void guardar(T elemento) {
        this.contenido = elemento;
    }
    
    public T obtener() {
        return contenido;
    }
}

// Uso
public class PruebaCaja {
    public static void main(String[] args) {
        // Caja de Strings
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.guardar("Hola");
        String texto = cajaTexto.obtener();  // Sin cast
        
        // Caja de Integers
        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.guardar(42);
        Integer numero = cajaNumero.obtener();
        
        // Caja de objetos personalizados
        Caja<Producto> cajaProducto = new Caja<>();
        cajaProducto.guardar(new Producto("Laptop", 1000.0));
    }
}
```

### Clase con Múltiples Parámetros de Tipo

```java
public class Par<K, V> {
    private K clave;
    private V valor;
    
    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }
    
    public K getClave() { return clave; }
    public V getValor() { return valor; }
    
    public void setClave(K clave) { this.clave = clave; }
    public void setValor(V valor) { this.valor = valor; }
}

// Uso
Par<String, Integer> edad = new Par<>("Carlos", 25);
Par<Integer, String> usuario = new Par<>(1, "admin");
```

---

## 🔧 Métodos Genéricos

### Método Genérico en Clase No Genérica

```java
public class Utilidades {
    
    // Método genérico
    public static <T> void imprimir(T elemento) {
        System.out.println(elemento);
    }
    
    // Método genérico que retorna un valor
    public static <T> T obtenerPrimero(T[] array) {
        if (array != null && array.length > 0) {
            return array[0];
        }
        return null;
    }
    
    // Uso
    public static void main(String[] args) {
        imprimir("Hola");           // T = String
        imprimir(42);               // T = Integer
        imprimir(3.14);             // T = Double
        
        String[] nombres = {"Ana", "Luis", "Carlos"};
        String primero = obtenerPrimero(nombres);  // "Ana"
        
        Integer[] numeros = {1, 2, 3};
        Integer primerNumero = obtenerPrimero(numeros);  // 1
    }
}
```

---

## 🌟 Bounded Type Parameters (Tipos Acotados)

### Upper Bound (extends)

Limita los tipos a una clase específica o sus subclases.

```java
// Solo acepta Number o sus subclases (Integer, Double, etc.)
public class CalculadoraGenerica<T extends Number> {
    
    public double suma(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
    
    public double multiplicar(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }
}

// Uso
CalculadoraGenerica<Integer> calcInt = new CalculadoraGenerica<>();
double resultado1 = calcInt.suma(5, 10);  // 15.0

CalculadoraGenerica<Double> calcDouble = new CalculadoraGenerica<>();
double resultado2 = calcDouble.suma(5.5, 10.3);  // 15.8

// CalculadoraGenerica<String> calc = new CalculadoraGenerica<>();  // ❌ Error!
```

### Múltiples Bounds

```java
// T debe implementar ambas interfaces
public class Procesador<T extends Comparable<T> & Serializable> {
    public T mayorDe(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}
```

---

## 🔮 Wildcards (Comodines)

### Unbounded Wildcard (`?`)

Acepta cualquier tipo.

```java
public static void imprimir Lista(List<?> lista) {
    for (Object elemento : lista) {
        System.out.println(elemento);
    }
}

// Uso
List<String> nombres = Arrays.asList("Ana", "Luis");
List<Integer> numeros = Arrays.asList(1, 2, 3);

imprimirLista(nombres);   // ✅
imprimirLista(numeros);   // ✅
```

### Upper Bounded Wildcard (`? extends Tipo`)

Acepta el tipo o sus subclases (lectura).

```java
public static double sumar(List<? extends Number> numeros) {
    double suma = 0;
    for (Number n : numeros) {
        suma += n.doubleValue();
    }
    return suma;
}

// Uso
List<Integer> enteros = Arrays.asList(1, 2, 3);
List<Double> decimales = Arrays.asList(1.5, 2.5, 3.5);

double suma1 = sumar(enteros);    // 6.0
double suma2 = sumar(decimales);  // 7.5
```

### Lower Bounded Wildcard (`? super Tipo`)

Acepta el tipo o sus superclases (escritura).

```java
public static void agregar Enteros(List<? super Integer> lista) {
    lista.add(1);
    lista.add(2);
    lista.add(3);
}

// Uso
List<Integer> enteros = new ArrayList<>();
List<Number> numeros = new ArrayList<>();
List<Object> objetos = new ArrayList<>();

agregarEnteros(enteros);  // ✅
agregarEnteros(numeros);  // ✅
agregarEnteros(objetos);  // ✅
```

---

## 💡 Ejemplo Práctico: Repository Genérico

```java
import java.util.*;

// Interface genérica para repositorios
public interface Repository<T, ID> {
    void guardar(T entidad);
    T buscarPorId(ID id);
    List<T> buscarTodos();
    void eliminar(ID id);
    boolean existe(ID id);
}

// Implementación genérica
public class RepositorioEnMemoria<T, ID> implements Repository<T, ID> {
    private Map<ID, T> almacenamiento = new HashMap<>();
    
    @Override
    public void guardar(T entidad) {
        // Asume que T tiene un método getId()
        // En un caso real, usarías reflection o una interfaz Identifiable
        almacenamiento.put(extraerId(entidad), entidad);
    }
    
    @Override
    public T buscarPorId(ID id) {
        return almacenamiento.get(id);
    }
    
    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }
    
    @Override
    public void eliminar(ID id) {
        almacenamiento.remove(id);
    }
    
    @Override
    public boolean existe(ID id) {
        return almacenamiento.containsKey(id);
    }
    
    // Método auxiliar (simplificado)
    private ID extraerId(T entidad) {
        // Implementación depende del contexto
        return null;
    }
}

// Uso específico
class Usuario {
    private Integer id;
    private String nombre;
    // Constructor, getters, setters
}

class Producto {
    private String codigo;
    private String nombre;
    // Constructor, getters, setters
}

public class Main {
    public static void main(String[] args) {
        // Repositorio de usuarios
        Repository<Usuario, Integer> repoUsuarios = new RepositorioEnMemoria<>();
        
        // Repositorio de productos
        Repository<Producto, String> repoProductos = new RepositorioEnMemoria<>();
        
        // Ambos usan la misma implementación genérica
    }
}
```

---

## 🚫 Limitaciones de los Generics

### 1. No se pueden instanciar tipos genéricos

```java
public class Caja<T> {
    // T objeto = new T();  // ❌ Error de compilación
}
```

### 2. No se pueden crear arrays de tipos genéricos

```java
// List<String>[] array = new List<String>[10];  // ❌ Error
```

### 3. No funcionan con tipos primitivos

```java
// List<int> numeros = new ArrayList<>();  // ❌ Error
List<Integer> numeros = new ArrayList<>();  // ✅ Usa wrapper
```

### 4. Type Erasure (Borrado de tipos)

En runtime, los generics se "borran" y se convierten en el tipo base.

```java
List<String> lista1 = new ArrayList<>();
List<Integer> lista2 = new ArrayList<>();

// En runtime, ambos son simplemente List (sin tipo)
System.out.println(lista1.getClass() == lista2.getClass());  // true
```

---

## ✅ Mejores Prácticas

1. **Siempre usa generics** en colecciones
   ```java
   List<String> lista = new ArrayList<>();  // ✅ Bien
   List lista = new ArrayList();            // ❌ Raw type - evitar
   ```

2. **Usa wildcards** para flexibilidad
   ```java
   public void procesar(List<? extends Animal> animales) { }
   ```

3. **Prefiere listas a arrays** con generics

4. **Usa diamond operator** (`<>`) para inferencia de tipos (Java 7+)
   ```java
   Map<String, List<Integer>> mapa = new HashMap<>();  // ✅
   ```

5. **Documenta las restricciones** de tipos

---

## 📝 Ejercicios

1. Crea una clase `Pila<T>` genérica con métodos push(), pop(), peek()
2. Implementa un método genérico que encuentre el elemento máximo en un array
3. Crea una clase `Pareja<A, B>` que almacene dos valores de diferentes tipos

---

**Próximo tema**: Aplicación práctica con ejercicios

---

*Semana 8 - Bootcamp POO Java - SENA*
