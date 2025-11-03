# Ejercicio 02: Manejo Básico de Excepciones

## 🎯 Objetivo
Implementar try-catch-finally para manejar excepciones comunes de Java.

## ⏱️ Tiempo: 40 minutos

## 📋 Tareas

1. **División Segura**: Try-catch para `ArithmeticException`
2. **Null Safety**: Manejar `NullPointerException`
3. **Lectura de Archivo**: Try-catch para `IOException`
4. **Finally**: Limpieza de recursos
5. **Múltiples Catch**: Catch específico → genérico

## ✅ Entregables
- Archivo `Main.java` con 5 métodos demostrando cada concepto
- Cada método debe incluir try-catch apropiado
- Al menos 1 uso de finally

## 💡 Pista
```java
try {
    // Código peligroso
} catch (ArithmeticException e) {
    System.err.println("Error: " + e.getMessage());
} finally {
    System.out.println("Limpieza");
}
```

**Ver carpeta `solucion/` para código completo**
