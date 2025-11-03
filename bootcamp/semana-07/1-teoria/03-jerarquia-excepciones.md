# Jerarquía de Excepciones en Java

## 📋 Índice
1. [Clase Throwable](#clase-throwable)
2. [Error vs Exception](#error-vs-exception)
3. [Checked vs Unchecked](#checked-vs-unchecked)
4. [Excepciones Comunes](#excepciones-comunes)
5. [Diagrama Completo](#diagrama-completo)

---

## Clase Throwable

**`Throwable`** es la clase **raíz** de todas las excepciones y errores en Java.

```
                    Object
                      |
                  Throwable
                  /       \
              Error     Exception
```

### Métodos Principales de Throwable

```java
try {
    // código que lanza excepción
} catch (Exception e) {
    e.getMessage();           // Mensaje del error
    e.printStackTrace();      // Stack trace completo
    e.getCause();            // Causa original
    e.toString();            // Representación string
}
```

---

## Error vs Exception

### Error

**Errores graves** del sistema, **NO deben ser capturados**.

```java
// ❌ NO hacer esto
try {
    // código
} catch (Error e) {  // MAL
    // Los Error no deben capturarse
}
```

**Ejemplos de Error:**
- `OutOfMemoryError`: Memoria insuficiente
- `StackOverflowError`: Desbordamiento de pila
- `VirtualMachineError`: Error de la JVM

### Exception

**Excepciones** que pueden y **DEBEN ser manejadas**.

```java
// ✅ BIEN
try {
    // código que puede fallar
} catch (IOException e) {
    // Manejo apropiado
}
```

---

## Checked vs Unchecked

### Checked Exceptions (Verificadas)

**Deben ser manejadas** en tiempo de compilación.

```java
// ❌ NO compila sin try-catch o throws
public void leerArchivo(String ruta) {
    FileReader reader = new FileReader(ruta);  // Error de compilación
}

// ✅ Opción 1: try-catch
public void leerArchivo(String ruta) {
    try {
        FileReader reader = new FileReader(ruta);
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado");
    }
}

// ✅ Opción 2: throws
public void leerArchivo(String ruta) throws FileNotFoundException {
    FileReader reader = new FileReader(ruta);
}
```

**Ejemplos comunes:**
- `IOException` - Errores de entrada/salida
- `SQLException` - Errores de base de datos
- `ClassNotFoundException` - Clase no encontrada
- `FileNotFoundException` - Archivo no encontrado

### Unchecked Exceptions (No verificadas)

**NO requieren** manejo obligatorio (subclases de `RuntimeException`).

```java
// ✅ Compila sin problemas (aunque puede fallar en ejecución)
public void dividir(int a, int b) {
    int resultado = a / b;  // Puede lanzar ArithmeticException
}
```

**Ejemplos comunes:**
- `NullPointerException` - Referencia nula
- `ArrayIndexOutOfBoundsException` - Índice fuera de rango
- `ArithmeticException` - Error aritmético
- `IllegalArgumentException` - Argumento inválido
- `NumberFormatException` - Formato de número inválido

### Tabla Comparativa

| Aspecto | Checked | Unchecked |
|---------|---------|-----------|
| **Herencia** | Extienden `Exception` | Extienden `RuntimeException` |
| **Verificación** | Tiempo de compilación | Tiempo de ejecución |
| **Manejo obligatorio** | Sí (try-catch o throws) | No |
| **Cuándo usarlas** | Situaciones recuperables | Errores de programación |
| **Ejemplos** | IOException, SQLException | NullPointerException, ArithmeticException |

---

## Excepciones Comunes

### RuntimeException (Unchecked)

#### 1. NullPointerException

```java
String texto = null;
int longitud = texto.length();  // ❌ NullPointerException
```

**Solución:**
```java
if (texto != null) {
    int longitud = texto.length();  // ✅
}
```

#### 2. ArrayIndexOutOfBoundsException

```java
int[] numeros = {1, 2, 3};
int valor = numeros[5];  // ❌ ArrayIndexOutOfBoundsException
```

**Solución:**
```java
if (index >= 0 && index < numeros.length) {
    int valor = numeros[index];  // ✅
}
```

#### 3. ArithmeticException

```java
int resultado = 10 / 0;  // ❌ ArithmeticException
```

**Solución:**
```java
if (divisor != 0) {
    int resultado = dividendo / divisor;  // ✅
}
```

#### 4. IllegalArgumentException

```java
public void setEdad(int edad) {
    if (edad < 0) {
        throw new IllegalArgumentException("Edad no puede ser negativa");
    }
    this.edad = edad;
}
```

#### 5. NumberFormatException

```java
int numero = Integer.parseInt("abc");  // ❌ NumberFormatException
```

**Solución:**
```java
try {
    int numero = Integer.parseInt(texto);
} catch (NumberFormatException e) {
    numero = 0;  // Valor por defecto
}
```

### Checked Exceptions

#### 1. IOException

```java
import java.io.*;

public void leerArchivo() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
    String linea = reader.readLine();
    reader.close();
}
```

#### 2. FileNotFoundException (subclase de IOException)

```java
import java.io.*;

public void abrirArchivo(String ruta) {
    try {
        FileReader reader = new FileReader(ruta);
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado: " + ruta);
    }
}
```

#### 3. SQLException

```java
import java.sql.*;

public void consultarBD() throws SQLException {
    Connection conn = DriverManager.getConnection(url, user, password);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
}
```

---

## Diagrama Completo

```
                        Throwable
                       /          \
                    Error        Exception
                      |         /         \
                      |    IOException  RuntimeException
                      |        |              |
              OutOfMemoryError |              ├── NullPointerException
              StackOverflowError              ├── ArrayIndexOutOfBoundsException
              VirtualMachineError             ├── ArithmeticException
                                             ├── IllegalArgumentException
                      FileNotFoundException  ├── NumberFormatException
                      SQLException           └── ClassCastException
                      InterruptedException
```

### Desglose Visual

```
Throwable (Raíz)
│
├─ Error (NO capturar)
│  ├─ OutOfMemoryError
│  ├─ StackOverflowError
│  └─ VirtualMachineError
│
└─ Exception (Capturar)
   │
   ├─ CHECKED (Obligatorio manejar)
   │  ├─ IOException
   │  │  └─ FileNotFoundException
   │  ├─ SQLException
   │  └─ ClassNotFoundException
   │
   └─ RuntimeException (UNCHECKED)
      ├─ NullPointerException
      ├─ ArrayIndexOutOfBoundsException
      ├─ ArithmeticException
      ├─ IllegalArgumentException
      ├─ NumberFormatException
      └─ ClassCastException
```

---

## 🎯 Cuándo Usar Cada Tipo

### Usa Checked Exceptions cuando:

✅ **La situación es recuperable**
```java
public void guardarArchivo() throws IOException {
    // Si falla, el usuario puede intentar de nuevo
}
```

✅ **El código cliente debe estar consciente del problema**
```java
public void conectarBD() throws SQLException {
    // El cliente debe saber que la conexión puede fallar
}
```

### Usa Unchecked Exceptions cuando:

✅ **Es un error de programación**
```java
if (edad < 0) {
    throw new IllegalArgumentException("Edad inválida");
}
```

✅ **No tiene sentido recuperarse**
```java
String texto = null;
texto.length();  // NullPointerException - error del programador
```

---

## 📝 Ejemplo Integrador

```java
import java.io.*;

public class GestorArchivos {
    
    // Checked: DEBE declarar IOException
    public static String leerArchivo(String ruta) throws IOException {
        if (ruta == null) {
            // Unchecked: Error de programación
            throw new IllegalArgumentException("Ruta no puede ser null");
        }
        
        // Checked: Puede lanzar FileNotFoundException
        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        StringBuilder contenido = new StringBuilder();
        String linea;
        
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea).append("\n");
        }
        
        reader.close();
        return contenido.toString();
    }
    
    public static void main(String[] args) {
        try {
            // Intento 1: Con archivo válido
            String contenido = leerArchivo("datos.txt");
            System.out.println("✅ Archivo leído correctamente");
            
        } catch (FileNotFoundException e) {
            // Checked: Captura específica
            System.out.println("❌ Archivo no encontrado");
            
        } catch (IOException e) {
            // Checked: Captura más general
            System.out.println("❌ Error de lectura: " + e.getMessage());
            
        } catch (IllegalArgumentException e) {
            // Unchecked: Pero podemos capturarla si queremos
            System.out.println("❌ Argumento inválido: " + e.getMessage());
        }
    }
}
```

---

## 🎯 Buenas Prácticas

### ✅ DO

1. **Usa checked** para condiciones externas (archivos, red, BD)
2. **Usa unchecked** para errores de programación
3. **Captura específico** antes que genérico
4. **Documenta** excepciones checked con `@throws`

### ❌ DON'T

1. **No captures Error**
2. **No uses checked** para validaciones simples
3. **No captures Exception** genérico sin razón
4. **No silencies** excepciones con catch vacío

---

## 📝 Resumen

| Tipo | Hereda de | Manejo | Uso |
|------|-----------|--------|-----|
| **Error** | Throwable | ❌ No capturar | Errores JVM |
| **Checked** | Exception | ✅ Obligatorio | Situaciones recuperables |
| **Unchecked** | RuntimeException | ⚪ Opcional | Errores de programación |

---

**Siguiente**: [04 - Excepciones Personalizadas](./04-excepciones-personalizadas.md)
