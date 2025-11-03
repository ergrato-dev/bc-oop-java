# Glosario - Semana 07

## Paquetes (Packages)

### Package
Mecanismo de agrupación de clases relacionadas en Java. Similar a carpetas para organizar archivos.

**Ejemplo**:
```java
package com.agencia.modelo;
```

### Import
Declaración que permite usar clases de otros paquetes sin escribir su nombre completo.

**Ejemplo**:
```java
import com.agencia.modelo.Reserva;
import java.util.*;  // Wildcard import
```

### Nombre completo calificado (Fully Qualified Name)
Nombre completo de una clase incluyendo su paquete.

**Ejemplo**: `java.util.ArrayList` o `com.agencia.modelo.Cliente`

### Import estático
Permite importar métodos y constantes estáticas para usarlos sin el nombre de clase.

**Ejemplo**:
```java
import static java.lang.Math.PI;
import static com.agencia.util.Validador.validarEmail;
```

---

## Excepciones (Exceptions)

### Exception
Evento que interrumpe el flujo normal de ejecución del programa.

**Ejemplo**: División por cero, archivo no encontrado, null pointer.

### Throw
Palabra clave para lanzar una excepción manualmente.

**Ejemplo**:
```java
throw new IllegalArgumentException("Edad inválida");
```

### Throws
Palabra clave en la firma del método para declarar qué excepciones puede lanzar.

**Ejemplo**:
```java
public void leerArchivo() throws IOException {
    // ...
}
```

### Try
Bloque donde se coloca código que puede lanzar excepciones.

**Ejemplo**:
```java
try {
    int resultado = 10 / 0;
}
```

### Catch
Bloque que captura y maneja una excepción específica.

**Ejemplo**:
```java
catch (ArithmeticException e) {
    System.err.println("Error: " + e.getMessage());
}
```

### Finally
Bloque que SIEMPRE se ejecuta, haya o no excepción. Usado para limpieza de recursos.

**Ejemplo**:
```java
finally {
    if (archivo != null) {
        archivo.close();
    }
}
```

### Checked Exception
Excepción verificada en tiempo de compilación. Debe ser capturada o declarada.

**Ejemplo**: `IOException`, `SQLException`, `ClassNotFoundException`

### Unchecked Exception
Excepción NO verificada en compilación. Hereda de `RuntimeException`.

**Ejemplo**: `NullPointerException`, `IllegalArgumentException`, `ArrayIndexOutOfBoundsException`

### Stack Trace
Seguimiento de la pila de llamadas que muestra dónde ocurrió la excepción.

**Ejemplo**:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Main.dividir(Main.java:15)
    at Main.main(Main.java:8)
```

### Throwable
Clase raíz de todas las excepciones y errores en Java.

**Jerarquía**:
```
Throwable
├── Error (errores del sistema)
└── Exception (excepciones de aplicación)
    └── RuntimeException (unchecked)
```

### Try-with-resources
Sintaxis especial que cierra automáticamente recursos que implementan `AutoCloseable`.

**Ejemplo**:
```java
try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
    // Usar reader
}  // reader.close() automático
```

### Causa (Cause)
La excepción original que causó la excepción actual. Se preserva para no perder contexto.

**Ejemplo**:
```java
try {
    // código
} catch (IOException e) {
    throw new RuntimeException("Error al procesar", e);  // e es la causa
}
```

---

## Términos de Buenas Prácticas

### Swallowing Exception (Tragar excepción)
Anti-patrón: capturar una excepción y no hacer nada con ella.

**Ejemplo malo**:
```java
try {
    operacion();
} catch (Exception e) {
    // Nada - ❌ MAL
}
```

### Fail Fast
Principio: detectar y reportar errores lo más pronto posible.

**Ejemplo**:
```java
if (precio <= 0) {
    throw new IllegalArgumentException("Precio inválido");
}
```

### Defensive Programming
Validar entradas y condiciones para prevenir errores.

**Ejemplo**:
```java
if (cliente == null) {
    throw new IllegalArgumentException("Cliente no puede ser null");
}
```

---

## Abreviaciones Comunes

- **FQN**: Fully Qualified Name (nombre completo calificado)
- **NPE**: NullPointerException
- **IOE**: IOException
- **AIOOBE**: ArrayIndexOutOfBoundsException
- **JVM**: Java Virtual Machine

---

**Total de términos**: 25
