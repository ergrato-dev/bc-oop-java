# Manejo de Excepciones en Java

## 📋 Índice
1. [¿Qué son las Excepciones?](#qué-son-las-excepciones)
2. [¿Por qué Manejar Excepciones?](#por-qué-manejar-excepciones)
3. [Estructura try-catch](#estructura-try-catch)
4. [Bloque finally](#bloque-finally)
5. [Múltiples catch](#múltiples-catch)
6. [throw: Lanzar Excepciones](#throw-lanzar-excepciones)
7. [throws: Declarar Excepciones](#throws-declarar-excepciones)
8. [Propagación de Excepciones](#propagación-de-excepciones)
9. [Ejemplos Prácticos](#ejemplos-prácticos)

---

## ¿Qué son las Excepciones?

Una **excepción** es un **evento anormal** que interrumpe el flujo normal de ejecución de un programa.

### Analogía
Imagina que estás conduciendo:
- **Flujo normal**: Conducir por la carretera
- **Excepción**: Un obstáculo inesperado (accidente, desvío)
- **Manejo de excepción**: Tomar una ruta alternativa

### Ejemplos Comunes

```java
// División por cero
int resultado = 10 / 0;  // ArithmeticException

// Índice fuera de rango
int[] numeros = {1, 2, 3};
int valor = numeros[5];  // ArrayIndexOutOfBoundsException

// Referencia nula
String texto = null;
int longitud = texto.length();  // NullPointerException

// Conversión inválida
String numero = "abc";
int valor = Integer.parseInt(numero);  // NumberFormatException
```

---

## ¿Por qué Manejar Excepciones?

### Sin Manejo de Excepciones ❌

```java
public class SinManejo {
    public static void main(String[] args) {
        System.out.println("Inicio del programa");
        
        int resultado = 10 / 0;  // ¡CRASH! El programa termina aquí
        
        System.out.println("Fin del programa");  // NUNCA se ejecuta
    }
}
```

**Salida:**
```
Inicio del programa
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at SinManejo.main(SinManejo.java:5)
```

### Con Manejo de Excepciones ✅

```java
public class ConManejo {
    public static void main(String[] args) {
        System.out.println("Inicio del programa");
        
        try {
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("⚠️ Error: No se puede dividir por cero");
        }
        
        System.out.println("Fin del programa");  // ✅ SÍ se ejecuta
    }
}
```

**Salida:**
```
Inicio del programa
⚠️ Error: No se puede dividir por cero
Fin del programa
```

---

## Estructura try-catch

### Sintaxis Básica

```java
try {
    // Código que puede lanzar excepciones
} catch (TipoExcepcion nombreVariable) {
    // Código para manejar la excepción
}
```

### Ejemplo 1: División Segura

```java
import java.util.Scanner;

public class DivisionSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese el dividendo: ");
            int dividendo = scanner.nextInt();
            
            System.out.print("Ingrese el divisor: ");
            int divisor = scanner.nextInt();
            
            int resultado = dividendo / divisor;
            System.out.println("Resultado: " + resultado);
            
        } catch (ArithmeticException e) {
            System.out.println("❌ Error: División por cero no permitida");
        }
        
        scanner.close();
    }
}
```

### Ejemplo 2: Parseo Seguro

```java
public class ParseoSeguro {
    public static int convertirAEntero(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Formato inválido: '" + texto + "' no es un número");
            return 0;  // Valor por defecto
        }
    }
    
    public static void main(String[] args) {
        System.out.println(convertirAEntero("123"));   // 123
        System.out.println(convertirAEntero("abc"));   // 0 (con mensaje de error)
        System.out.println(convertirAEntero("45.7"));  // 0 (con mensaje de error)
    }
}
```

---

## Bloque finally

El bloque `finally` **siempre se ejecuta**, haya o no excepción.

### Sintaxis

```java
try {
    // Código que puede lanzar excepciones
} catch (Exception e) {
    // Manejo de excepción
} finally {
    // Código que SIEMPRE se ejecuta
    // Útil para cerrar recursos (archivos, conexiones)
}
```

### Ejemplo: Cerrar Recursos

```java
import java.util.Scanner;

public class EjemploFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese un número: ");
            int numero = scanner.nextInt();
            System.out.println("El doble es: " + (numero * 2));
            
        } catch (Exception e) {
            System.out.println("❌ Error: Entrada inválida");
            
        } finally {
            System.out.println("🔒 Cerrando scanner...");
            scanner.close();  // ✅ Siempre se ejecuta
        }
        
        System.out.println("Fin del programa");
    }
}
```

### Casos de Ejecución de finally

```java
public class CasosFinally {
    
    // Caso 1: Sin excepción
    public static void caso1() {
        try {
            System.out.println("1. Ejecutando código");
            return;  // Sale del método
        } finally {
            System.out.println("2. Finally se ejecuta ANTES del return");
        }
    }
    
    // Caso 2: Con excepción
    public static void caso2() {
        try {
            System.out.println("1. Lanzando excepción");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("2. Capturando excepción");
        } finally {
            System.out.println("3. Finally se ejecuta siempre");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Caso 1 ===");
        caso1();
        
        System.out.println("\n=== Caso 2 ===");
        caso2();
    }
}
```

---

## Múltiples catch

Puedes capturar diferentes tipos de excepciones con múltiples bloques `catch`.

### Sintaxis

```java
try {
    // Código
} catch (TipoExcepcion1 e) {
    // Manejo específico para TipoExcepcion1
} catch (TipoExcepcion2 e) {
    // Manejo específico para TipoExcepcion2
} catch (Exception e) {
    // Manejo genérico (debe ir al final)
}
```

### Ejemplo Completo

```java
public class MultipleCatch {
    public static void main(String[] args) {
        String[] datos = {"10", "20", "abc", "30"};
        
        for (String dato : datos) {
            try {
                int numero = Integer.parseInt(dato);
                int resultado = 100 / numero;
                System.out.println("✅ " + dato + " → Resultado: " + resultado);
                
            } catch (NumberFormatException e) {
                System.out.println("❌ " + dato + " → No es un número válido");
                
            } catch (ArithmeticException e) {
                System.out.println("❌ " + dato + " → División por cero");
                
            } catch (Exception e) {
                System.out.println("❌ " + dato + " → Error desconocido: " + e.getMessage());
            }
        }
    }
}
```

**Salida:**
```
✅ 10 → Resultado: 10
✅ 20 → Resultado: 5
❌ abc → No es un número válido
✅ 30 → Resultado: 3
```

### Multi-catch (Java 7+)

Captura múltiples excepciones en un solo bloque:

```java
try {
    // Código
} catch (NumberFormatException | ArithmeticException e) {
    System.out.println("Error numérico: " + e.getMessage());
}
```

---

## throw: Lanzar Excepciones

La palabra clave `throw` se usa para **lanzar manualmente** una excepción.

### Sintaxis

```java
throw new TipoExcepcion("Mensaje de error");
```

### Ejemplo 1: Validación de Edad

```java
public class ValidadorEdad {
    
    public static void validarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (edad > 150) {
            throw new IllegalArgumentException("La edad no puede ser mayor a 150");
        }
        System.out.println("✅ Edad válida: " + edad);
    }
    
    public static void main(String[] args) {
        try {
            validarEdad(25);   // ✅ OK
            validarEdad(-5);   // ❌ Lanza excepción
            validarEdad(200);  // No se ejecuta
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
```

### Ejemplo 2: Validación de Reserva

```java
public class Reserva {
    private String codigo;
    private double precio;
    
    public Reserva(String codigo, double precio) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        
        this.codigo = codigo;
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Reserva{codigo='" + codigo + "', precio=" + precio + "}";
    }
    
    public static void main(String[] args) {
        try {
            Reserva r1 = new Reserva("R001", 1500);
            System.out.println("✅ " + r1);
            
            Reserva r2 = new Reserva("", 2000);  // ❌ Código vacío
            System.out.println(r2);
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error al crear reserva: " + e.getMessage());
        }
    }
}
```

---

## throws: Declarar Excepciones

La palabra clave `throws` se usa en la **firma del método** para indicar que puede lanzar una excepción.

### Sintaxis

```java
public void metodo() throws TipoExcepcion {
    // Código que puede lanzar TipoExcepcion
}
```

### Diferencia: throw vs throws

| `throw` | `throws` |
|---------|----------|
| **Lanza** una excepción | **Declara** que un método puede lanzar excepciones |
| Se usa **dentro** del método | Se usa en la **firma** del método |
| Seguido de una **instancia** | Seguido de un **tipo** |
| `throw new Exception()` | `throws Exception` |

### Ejemplo 1: Método que Declara Excepción

```java
import java.io.*;

public class LectorArchivo {
    
    // Método que DECLARA que puede lanzar IOException
    public static String leerArchivo(String ruta) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        String linea = reader.readLine();
        reader.close();
        return linea;
    }
    
    public static void main(String[] args) {
        try {
            String contenido = leerArchivo("datos.txt");
            System.out.println("Contenido: " + contenido);
        } catch (IOException e) {
            System.out.println("❌ Error al leer archivo: " + e.getMessage());
        }
    }
}
```

### Ejemplo 2: Múltiples Excepciones

```java
public class GestorReservas {
    
    public void agregarReserva(String codigo, double precio) 
            throws IllegalArgumentException, SQLException {
        
        // Validación
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        
        // Simular operación de base de datos
        // Si hay error, lanza SQLException
    }
}
```

---

## Propagación de Excepciones

Las excepciones se **propagan** hacia arriba en la pila de llamadas hasta ser capturadas.

### Diagrama de Flujo

```
main()
  └─> metodo1()
        └─> metodo2()
              └─> metodo3()  ← Lanza excepción
              ↑ Propaga
        ↑ Propaga
  ↑ Captura aquí
```

### Ejemplo Completo

```java
public class PropagacionExcepciones {
    
    // Nivel 3: Lanza la excepción
    public static void metodo3() {
        System.out.println("  → metodo3: Lanzando excepción...");
        throw new RuntimeException("Error en metodo3");
    }
    
    // Nivel 2: Propaga la excepción (no la captura)
    public static void metodo2() {
        System.out.println(" → metodo2: Llamando a metodo3...");
        metodo3();  // ← La excepción se propaga desde aquí
        System.out.println(" → metodo2: Fin");  // NO se ejecuta
    }
    
    // Nivel 1: Propaga la excepción
    public static void metodo1() {
        System.out.println("→ metodo1: Llamando a metodo2...");
        metodo2();  // ← La excepción se propaga desde aquí
        System.out.println("→ metodo1: Fin");  // NO se ejecuta
    }
    
    // Nivel 0: Captura la excepción
    public static void main(String[] args) {
        System.out.println("main: Inicio");
        
        try {
            metodo1();  // ← La excepción es capturada aquí
        } catch (RuntimeException e) {
            System.out.println("\n❌ Excepción capturada en main:");
            System.out.println("   Mensaje: " + e.getMessage());
        }
        
        System.out.println("main: Fin");  // ✅ SÍ se ejecuta
    }
}
```

**Salida:**
```
main: Inicio
→ metodo1: Llamando a metodo2...
 → metodo2: Llamando a metodo3...
  → metodo3: Lanzando excepción...

❌ Excepción capturada en main:
   Mensaje: Error en metodo3
main: Fin
```

---

## Ejemplos Prácticos

### Ejemplo 1: Calculadora Robusta

```java
import java.util.Scanner;

public class CalculadoraRobusta {
    
    public static double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese dividendo: ");
            double dividendo = scanner.nextDouble();
            
            System.out.print("Ingrese divisor: ");
            double divisor = scanner.nextDouble();
            
            double resultado = dividir(dividendo, divisor);
            System.out.println("Resultado: " + resultado);
            
        } catch (ArithmeticException e) {
            System.out.println("❌ Error matemático: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error de entrada: Ingrese números válidos");
        } finally {
            scanner.close();
        }
    }
}
```

### Ejemplo 2: Sistema de Reservas con Validación

```java
public class SistemaReservas {
    
    public static void crearReserva(String codigo, double precio) 
            throws IllegalArgumentException {
        
        // Validaciones
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código no puede estar vacío");
        }
        
        if (!codigo.matches("R\\d{3}")) {
            throw new IllegalArgumentException(
                "Código debe tener formato R### (ejemplo: R001)"
            );
        }
        
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio debe ser mayor a 0");
        }
        
        if (precio > 10000000) {
            throw new IllegalArgumentException("Precio excede el máximo permitido");
        }
        
        System.out.println("✅ Reserva creada: " + codigo + " - $" + precio);
    }
    
    public static void main(String[] args) {
        String[][] datos = {
            {"R001", "1500000"},
            {"", "2000000"},
            {"R002", "-500"},
            {"ABC", "3000000"},
            {"R003", "15000000"}
        };
        
        for (String[] dato : datos) {
            try {
                String codigo = dato[0];
                double precio = Double.parseDouble(dato[1]);
                crearReserva(codigo, precio);
                
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Error: " + e.getMessage() + 
                                   " [" + dato[0] + ", " + dato[1] + "]");
            } catch (NumberFormatException e) {
                System.out.println("❌ Precio inválido: " + dato[1]);
            }
        }
    }
}
```

**Salida:**
```
✅ Reserva creada: R001 - $1500000.0
❌ Error: Código no puede estar vacío [, 2000000]
❌ Error: Precio debe ser mayor a 0 [R002, -500]
❌ Error: Código debe tener formato R### (ejemplo: R001) [ABC, 3000000]
❌ Error: Precio excede el máximo permitido [R003, 15000000]
```

---

## 🎯 Buenas Prácticas

### ✅ DO (Hacer)

1. **Captura excepciones específicas** primero, genéricas al final
2. **Usa finally** para cerrar recursos
3. **Lanza excepciones** con mensajes descriptivos
4. **Documenta** las excepciones con `@throws` en Javadoc
5. **Valida entrada** del usuario

### ❌ DON'T (No hacer)

1. **No captures Exception** de forma genérica sin razón
2. **No ignores excepciones** con `catch` vacío
3. **No uses excepciones** para control de flujo normal
4. **No captures Throwable o Error**
5. **No lances excepciones genéricas** (usa específicas)

---

## 📝 Resumen

| Concepto | Sintaxis | Uso |
|----------|----------|-----|
| **try-catch** | `try { } catch (E e) { }` | Capturar excepciones |
| **finally** | `finally { }` | Código que siempre se ejecuta |
| **throw** | `throw new Exception()` | Lanzar excepción |
| **throws** | `void metodo() throws E` | Declarar excepciones |
| **Multi-catch** | `catch (E1 \| E2 e)` | Capturar múltiples tipos |

---

**Siguiente**: [03 - Jerarquía de Excepciones](./03-jerarquia-excepciones.md)
