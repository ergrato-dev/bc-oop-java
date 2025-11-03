# Buenas Prácticas en Manejo de Excepciones

## 📋 Índice
1. [Principios Fundamentales](#principios-fundamentales)
2. [Try-with-Resources](#try-with-resources)
3. [Logging vs Exception Handling](#logging-vs-exception-handling)
4. [Performance y Excepciones](#performance-y-excepciones)
5. [Seguridad](#seguridad)
6. [Anti-Patrones Comunes](#anti-patrones-comunes)

---

## Principios Fundamentales

### 1. Captura Solo lo que Puedas Manejar

```java
// ✅ BIEN: Manejo específico
try {
    procesar Reserva(reserva);
} catch (ReservaInvalidaException e) {
    notificarCliente(e.getMessage());
    registrarError(e);
}

// ❌ MAL: Captura genérica sin hacer nada
try {
    procesarReserva(reserva);
} catch (Exception e) {
    // No hacer nada
}
```

### 2. No Escondas Excepciones

```java
// ✅ BIEN: Propagar o manejar apropiadamente
public void procesarArchivo(String ruta) throws IOException {
    FileReader reader = new FileReader(ruta);
    // ... procesamiento
}

// ❌ MAL: Ocultar excepciones importantes
public void procesarArchivo(String ruta) {
    try {
        FileReader reader = new FileReader(ruta);
    } catch (IOException e) {
        // Silenciosamente ignorar
    }
}
```

### 3. Mensajes Descriptivos

```java
// ✅ BIEN: Contexto específico
throw new ReservaInvalidaException(
    "No se puede reservar para la fecha " + fecha + 
    " porque ya existe una reserva con código " + codigo
);

// ❌ MAL: Mensaje genérico
throw new ReservaInvalidaException("Error");
```

### 4. Limpia Recursos en Finally

```java
// ✅ BIEN
FileReader reader = null;
try {
    reader = new FileReader("archivo.txt");
    // ... procesar
} catch (IOException e) {
    System.err.println("Error: " + e.getMessage());
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al cerrar: " + e.getMessage());
        }
    }
}
```

---

## Try-with-Resources

### ¿Qué es?

Desde Java 7, puedes usar **try-with-resources** para cerrar recursos automáticamente.

### Sintaxis

```java
try (TipoRecurso recurso = new TipoRecurso()) {
    // Usar recurso
} catch (Exception e) {
    // Manejar excepción
}
// recurso.close() se llama automáticamente
```

### Ejemplo: Lectura de Archivos

```java
import java.io.*;

// ✅ MEJOR: Try-with-resources
public String leerArchivo(String ruta) throws IOException {
    StringBuilder contenido = new StringBuilder();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea).append("\n");
        }
    }
    // reader.close() se llama automáticamente
    
    return contenido.toString();
}

// ❌ ANTIGUO: Finally manual
public String leerArchivoAntiguo(String ruta) throws IOException {
    BufferedReader reader = null;
    StringBuilder contenido = new StringBuilder();
    
    try {
        reader = new BufferedReader(new FileReader(ruta));
        String linea;
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea).append("\n");
        }
    } finally {
        if (reader != null) {
            reader.close();
        }
    }
    
    return contenido.toString();
}
```

### Múltiples Recursos

```java
// ✅ BIEN: Múltiples recursos
try (
    FileReader reader = new FileReader("entrada.txt");
    BufferedReader buffered = new BufferedReader(reader);
    FileWriter writer = new FileWriter("salida.txt")
) {
    String linea;
    while ((linea = buffered.readLine()) != null) {
        writer.write(linea.toUpperCase() + "\n");
    }
}
// Todos los recursos se cierran automáticamente
```

### Crear Recursos Personalizados

```java
// Para usar try-with-resources, implementa AutoCloseable
public class ConexionBaseDatos implements AutoCloseable {
    private boolean conectado = false;
    
    public ConexionBaseDatos(String url) {
        // Simular conexión
        this.conectado = true;
        System.out.println("✅ Conectado a: " + url);
    }
    
    public void ejecutarConsulta(String sql) {
        if (!conectado) {
            throw new IllegalStateException("No hay conexión");
        }
        System.out.println("Ejecutando: " + sql);
    }
    
    @Override
    public void close() {
        if (conectado) {
            conectado = false;
            System.out.println("✅ Conexión cerrada");
        }
    }
}

// Uso
try (ConexionBaseDatos db = new ConexionBaseDatos("jdbc:mysql://localhost")) {
    db.ejecutarConsulta("SELECT * FROM reservas");
}
// close() se llama automáticamente
```

---

## Logging vs Exception Handling

### Cuándo Usar Cada Uno

```java
import java.util.logging.*;

public class GestorReservas {
    private static final Logger logger = Logger.getLogger(GestorReservas.class.getName());
    
    // ✅ BIEN: Logging para información, excepciones para errores
    public void agregarReserva(Reserva r) throws ReservaInvalidaException {
        logger.info("Intentando agregar reserva: " + r.getCodigo());
        
        if (r.getPrecio() <= 0) {
            logger.warning("Intento de crear reserva con precio inválido: " + r.getPrecio());
            throw new ReservaInvalidaException("Precio debe ser mayor a 0");
        }
        
        reservas.add(r);
        logger.info("Reserva agregada exitosamente: " + r.getCodigo());
    }
    
    // ❌ MAL: Usar excepciones para logging
    public void agregarReservaMal(Reserva r) {
        try {
            throw new Exception("Log: agregando reserva");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```

### Niveles de Logging

```java
logger.severe("Error crítico");      // ERROR
logger.warning("Advertencia");        // WARN
logger.info("Información general");   // INFO
logger.config("Configuración");       // CONFIG
logger.fine("Debug detallado");       // DEBUG
```

### Ejemplo Completo

```java
import java.util.logging.*;

public class ServicioReservas {
    private static final Logger logger = Logger.getLogger(ServicioReservas.class.getName());
    
    static {
        // Configurar formato simple
        System.setProperty("java.util.logging.SimpleFormatter.format",
            "[%1$tF %1$tT] [%4$s] %5$s %n");
    }
    
    public void procesarReserva(String codigo, double precio) {
        try {
            logger.info("Procesando reserva: " + codigo);
            
            if (precio <= 0) {
                logger.warning("Precio inválido: " + precio);
                throw new IllegalArgumentException("Precio debe ser > 0");
            }
            
            // Simular procesamiento
            if (Math.random() < 0.3) {
                throw new RuntimeException("Error de red");
            }
            
            logger.info("✅ Reserva procesada: " + codigo);
            
        } catch (IllegalArgumentException e) {
            logger.warning("Validación fallida: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.severe("Error crítico procesando " + codigo + ": " + e.getMessage());
            throw new RuntimeException("No se pudo procesar la reserva", e);
        }
    }
}
```

---

## Performance y Excepciones

### Costo de las Excepciones

⚠️ **Lanzar excepciones es costoso** porque Java crea el stack trace completo.

```java
// ❌ MAL: Usar excepciones para control de flujo
public int encontrarIndice(String[] array, String valor) {
    try {
        for (int i = 0; ; i++) {  // Sin condición de salida
            if (array[i].equals(valor)) {
                return i;
            }
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        return -1;
    }
}

// ✅ BIEN: Lógica normal
public int encontrarIndice(String[] array, String valor) {
    for (int i = 0; i < array.length; i++) {
        if (array[i].equals(valor)) {
            return i;
        }
    }
    return -1;
}
```

### Validación Temprana

```java
// ✅ BIEN: Validar antes de procesar
public void procesarReservas(List<Reserva> reservas) {
    if (reservas == null || reservas.isEmpty()) {
        throw new IllegalArgumentException("Lista de reservas no puede estar vacía");
    }
    
    for (Reserva r : reservas) {
        // Procesar
    }
}
```

### Caché de Excepciones (Avanzado)

```java
// Para excepciones que se lanzan frecuentemente
public class ValidationException extends Exception {
    private static final ValidationException CACHE = new ValidationException("Error de validación");
    
    private ValidationException(String mensaje) {
        super(mensaje);
    }
    
    public static ValidationException getInstance() {
        return CACHE;
    }
}
```

---

## Seguridad

### 1. No Expongas Información Sensible

```java
// ❌ MAL: Expone detalles internos
catch (SQLException e) {
    throw new RuntimeException("Error en BD: " + e.getMessage() + 
        ", usuario: admin, contraseña: ****");
}

// ✅ BIEN: Mensaje genérico al usuario, detalles en log
catch (SQLException e) {
    logger.severe("Error de BD: " + e.getMessage());
    throw new RuntimeException("Error al procesar la solicitud");
}
```

### 2. Valida Entrada de Usuario

```java
public void buscarReserva(String codigo) throws ReservaInvalidaException {
    // ✅ BIEN: Validar formato antes de usar
    if (codigo == null || !codigo.matches("R\\d{3}")) {
        throw new ReservaInvalidaException("Código inválido");
    }
    
    // Ahora es seguro usar codigo
}
```

### 3. No Captures Throwable o Error

```java
// ❌ MUY MAL: Captura errores del sistema
try {
    // código
} catch (Throwable t) {
    // Esto captura OutOfMemoryError, etc.
}

// ✅ BIEN: Solo excepciones
try {
    // código
} catch (Exception e) {
    // Manejo apropiado
}
```

---

## Anti-Patrones Comunes

### 1. Catch Vacío

```java
// ❌ ANTI-PATRÓN
try {
    operacionPeligrosa();
} catch (Exception e) {
    // Nada
}

// ✅ SOLUCIÓN
try {
    operacionPeligrosa();
} catch (Exception e) {
    logger.warning("Operación falló: " + e.getMessage());
    // O lanzar de nuevo
    throw e;
}
```

### 2. printStackTrace() en Producción

```java
// ❌ ANTI-PATRÓN
try {
    operacion();
} catch (Exception e) {
    e.printStackTrace();  // Imprime en consola
}

// ✅ SOLUCIÓN
try {
    operacion();
} catch (Exception e) {
    logger.log(Level.SEVERE, "Error en operación", e);
}
```

### 3. Excepción Genérica

```java
// ❌ ANTI-PATRÓN
public void metodo() throws Exception {
    // Muy genérico
}

// ✅ SOLUCIÓN
public void metodo() throws ReservaInvalidaException, DisponibilidadException {
    // Específico
}
```

### 4. Return en Finally

```java
// ❌ ANTI-PATRÓN: Return en finally oculta excepciones
public int calcular() {
    try {
        throw new RuntimeException("Error");
    } finally {
        return 0;  // Oculta la excepción
    }
}

// ✅ SOLUCIÓN: No usar return en finally
public int calcular() {
    int resultado = 0;
    try {
        // cálculo
        resultado = 10;
    } catch (Exception e) {
        logger.severe("Error: " + e.getMessage());
        resultado = -1;
    }
    return resultado;
}
```

### 5. Catch y Lanzar sin Contexto

```java
// ❌ ANTI-PATRÓN: Pierde información
try {
    operacion();
} catch (IOException e) {
    throw new RuntimeException("Error");  // Pierde causa original
}

// ✅ SOLUCIÓN: Incluye causa
try {
    operacion();
} catch (IOException e) {
    throw new RuntimeException("Error al procesar archivo", e);  // Preserva causa
}
```

---

## Checklist de Buenas Prácticas

### ✅ Antes de Lanzar Excepción

- [ ] ¿El mensaje es descriptivo y útil?
- [ ] ¿Es el tipo de excepción apropiado (checked/unchecked)?
- [ ] ¿Incluye contexto relevante?
- [ ] ¿No expone información sensible?

### ✅ Antes de Capturar Excepción

- [ ] ¿Realmente puedo manejar este error aquí?
- [ ] ¿Es catch específico (no Exception genérico)?
- [ ] ¿Estoy haciendo algo útil en el catch?
- [ ] ¿Estoy registrando el error apropiadamente?

### ✅ Manejo de Recursos

- [ ] ¿Uso try-with-resources cuando es posible?
- [ ] ¿Limpio recursos en finally si no uso try-with-resources?
- [ ] ¿Manejo excepciones al cerrar recursos?

### ✅ Documentación

- [ ] ¿Documento con @throws las excepciones checked?
- [ ] ¿Documento las unchecked si son parte del contrato?
- [ ] ¿Los comentarios explican por qué se lanza?

---

## Ejemplo Completo: Aplicación de Buenas Prácticas

```java
package com.agencia.servicio;

import com.agencia.modelo.*;
import com.agencia.excepciones.*;
import java.io.*;
import java.util.logging.*;

public class GestorReservasOptimizado {
    private static final Logger logger = Logger.getLogger(GestorReservasOptimizado.class.getName());
    private List<Reserva> reservas = new ArrayList<>();
    
    /**
     * Exporta reservas a un archivo.
     * 
     * @param rutaArchivo Ruta donde guardar
     * @throws IOException Si hay error de I/O
     * @throws IllegalArgumentException Si rutaArchivo es null
     */
    public void exportarReservas(String rutaArchivo) throws IOException {
        // ✅ Validación temprana
        if (rutaArchivo == null || rutaArchivo.isEmpty()) {
            throw new IllegalArgumentException("Ruta de archivo no puede estar vacía");
        }
        
        logger.info("Exportando " + reservas.size() + " reservas a " + rutaArchivo);
        
        // ✅ Try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("Código,Cliente,Fecha,Precio\n");
            
            for (Reserva r : reservas) {
                writer.write(String.format("%s,%s,%s,%.2f\n",
                    r.getCodigo(),
                    r.getCliente().getNombre(),
                    r.getFecha(),
                    r.getPrecio()
                ));
            }
            
            logger.info("✅ Exportación exitosa");
            
        } catch (IOException e) {
            // ✅ Logging + propagar
            logger.severe("Error al exportar reservas: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Importa reservas desde archivo.
     * 
     * @param rutaArchivo Ruta del archivo
     * @return Número de reservas importadas
     * @throws IOException Si hay error de I/O
     * @throws ReservaInvalidaException Si formato es inválido
     */
    public int importarReservas(String rutaArchivo) 
            throws IOException, ReservaInvalidaException {
        
        if (rutaArchivo == null) {
            throw new IllegalArgumentException("Ruta no puede ser null");
        }
        
        int contador = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = reader.readLine(); // Saltar encabezado
            
            while ((linea = reader.readLine()) != null) {
                try {
                    String[] partes = linea.split(",");
                    
                    if (partes.length != 4) {
                        throw new ReservaInvalidaException(
                            "Formato inválido en línea: " + linea
                        );
                    }
                    
                    // Procesar reserva...
                    contador++;
                    
                } catch (ReservaInvalidaException e) {
                    // ✅ Logging + continuar con siguientes
                    logger.warning("Línea ignorada: " + e.getMessage());
                }
            }
            
            logger.info("✅ Importadas " + contador + " reservas");
            return contador;
            
        } catch (FileNotFoundException e) {
            logger.severe("Archivo no encontrado: " + rutaArchivo);
            throw new IOException("No se encontró el archivo: " + rutaArchivo, e);
        }
    }
}
```

---

## 📝 Resumen Final

| Práctica | Hacer ✅ | No Hacer ❌ |
|----------|----------|-------------|
| **Captura** | Específica (`IOException`) | Genérica (`Exception`) |
| **Mensaje** | Descriptivo con contexto | Genérico ("Error") |
| **Recursos** | Try-with-resources | Finally manual |
| **Logging** | Logger con niveles | printStackTrace() |
| **Propagación** | Con causa (`new Ex(msg, e)`) | Sin causa (`new Ex(msg)`) |
| **Control** | Condiciones normales | Excepciones |
| **Seguridad** | Mensaje genérico | Detalles internos |

---

**🎯 Aplicación Práctica**: Revisa tu código de semanas anteriores y aplica estas buenas prácticas.
